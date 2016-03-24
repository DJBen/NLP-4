/**
 * Created by DJBen on 3/24/16.
 */
public class BackPointer {
    private ChartEntryKey key;
    private int column;

    public ChartEntryKey getKey() {
        return key;
    }

    public int getColumn() {
        return column;
    }

    public BackPointer(ChartEntryKey key, int column) {
        this.key = key;
        this.column = column;
    }
}
