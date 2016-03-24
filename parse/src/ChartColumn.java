import java.util.*;

/**
 * Created by DJBen on 3/23/16.
 */
public class ChartColumn {
    private Map<ChartEntryKey, WeightBackPointer> columnMap = new HashMap<>();
    private List<ChartEntryKey> columnList = new ArrayList<>();
    private int readIndex = 0;
    private int columnNumber;

    public void addEntry(ChartEntryKey key, WeightBackPointer value) {
        if (columnMap.get(key) == null) {
            columnList.add(key);
            columnMap.put(key, value);
        } else {
            if (columnMap.get(key).getWeight() > value.getWeight()) {
                columnMap.put(key, value);
            }
        }
    }

    public ChartColumn(int column) {
        this.columnNumber = column;
    }

    public ChartColumn(int column, boolean initialize) {
        this.columnNumber = column;
        // Initialize the column with "0 ROOT . S" rule
        if (!initialize) return;
        List<Rule> rules = Grammar.getRulesForSymbol("ROOT");
        ChartEntryKey initialKey = new ChartEntryKey(0, 0, rules.get(0).getLhs(), rules.get(0).getRuleExpression());
        WeightBackPointer value = new WeightBackPointer(rules.get(0).getWeight(), null, null);
        this.addEntry(initialKey, value);
    }

    public ChartEntryKey peekKey() {
        return columnList.get(readIndex);
    }

    public ChartEntryKey getNextKey() {
        return columnList.get(readIndex++);
    }

    public boolean hasNextKey() {
        return readIndex < columnList.size();
    }

    public WeightBackPointer getWeightForKey(ChartEntryKey key) {
        return columnMap.get(key);
    }

    public void addPredictions() {
        ChartEntryKey key = this.getNextKey();
        if (key.operation() != ChartOperation.PREDICT) {
            return;
        }
        String symbol = key.symbolAfterDot();
        List<Rule> rules = Grammar.getRulesForSymbol(symbol);

        for (Rule r : rules) {
            ChartEntryKey newKey = new ChartEntryKey(columnNumber, 0, symbol, r.getRuleExpression());
            this.addEntry(newKey, new WeightBackPointer(r.getWeight(), null, null));
        }
    }

    public Map.Entry<ChartEntryKey, WeightBackPointer> scannedKeyAgainstWord(String word) {
        ChartEntryKey key = this.getNextKey();
        if (key.operation() != ChartOperation.SCAN) {
            return null;
        }

        String symbol = key.symbolAfterDot();
        if (!symbol.equals(word)) {
            return null;
        }

        ChartEntryKey scannedKey = new ChartEntryKey(key.getStartColumn(), key.getDotPosition() + 1, key.getLhs(), key.getRhs());
        WeightBackPointer pt = new WeightBackPointer(columnMap.get(key).getWeight(), key, null);
        return new AbstractMap.SimpleEntry<>(scannedKey, pt);
    }

    public List<Map.Entry<ChartEntryKey, Double>> keysToAttachForKey(ChartEntryKey key) {
        if (key.operation() != ChartOperation.ATTACH) {
            return null;
        }

        if (key.getStartColumn() != this.columnNumber) {
            return null;
        }

        List<Map.Entry<ChartEntryKey, Double>> result = new ArrayList<>();
        for (ChartEntryKey k : columnList) {
            if (k.symbolAfterDot() == null) {
                continue;
            }
            if (k.symbolAfterDot().equals(key.getLhs())) {
                AbstractMap.SimpleEntry<ChartEntryKey, Double> entry = new AbstractMap.SimpleEntry<>(k, columnMap.get(k).getWeight());
                result.add(entry);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return columnNumber + " - " + columnList.toString();
    }
}
