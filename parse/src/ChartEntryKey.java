import java.util.*;

/**
 * Created by Chenyang Su on 3/21/2016.
 */
public class ChartEntryKey {
    private int startColumn;
    private int dotPosition;
    private String lhs;
    private ArrayList<String> ruleExpression;

    public ChartEntryKey(int startColumn, int dotPosition, String symbol, ArrayList<String> ruleExpression) {
        this.startColumn = startColumn;
        this.dotPosition = dotPosition;
        this.lhs = symbol;
        this.ruleExpression = ruleExpression;
    }

    public String getRhsSymbolAtIndex(int i) {
        return ruleExpression.get(i);
    }

    public ArrayList<String> getRhs() {
        return ruleExpression;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public String getLhs() {
        return lhs;
    }

    public int getDotPosition() {
        return dotPosition;
    }

    public ChartOperation operation() {
        if (dotPosition == ruleExpression.size()) {
            return ChartOperation.ATTACH;
        } else {
            if (Grammar.isTerminal(this.symbolAfterDot())) {
                return ChartOperation.SCAN;
            } else {
                return ChartOperation.PREDICT;
            }
        }
    }

    public String symbolAfterDot() {
        if (dotPosition >= ruleExpression.size()) {
            return null;
        }
        return ruleExpression.get(dotPosition);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(startColumn + " " + lhs + " ");
        int i;
        for (i = 0; i < dotPosition; i++) {
            builder.append(ruleExpression.get(i) + " ");
        }
        builder.append(". ");
        for (; i < ruleExpression.size(); i++) {
            builder.append(ruleExpression.get(i));
            if (i == ruleExpression.size() - 1) {
                break;
            }
            builder.append(" ");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChartEntryKey that = (ChartEntryKey) o;

        if (startColumn != that.startColumn) return false;
        if (dotPosition != that.dotPosition) return false;
        if (lhs != null ? !lhs.equals(that.lhs) : that.lhs != null) return false;
        return ruleExpression != null ? ruleExpression.equals(that.ruleExpression) : that.ruleExpression == null;

    }

    @Override
    public int hashCode() {
        int result = startColumn;
        result = 31 * result + dotPosition;
        result = 31 * result + (lhs != null ? lhs.hashCode() : 0);
        result = 31 * result + (ruleExpression != null ? ruleExpression.hashCode() : 0);
        return result;
    }
}
