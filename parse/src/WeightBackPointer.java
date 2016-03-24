/**
 * Created by Chenyang Su on 3/21/2016.
 */
public class WeightBackPointer {
    private double weight;
    private ChartEntryKey backPointer1;
    private ChartEntryKey backPointer2;

    public WeightBackPointer(double weight, ChartEntryKey backPointer1, ChartEntryKey backPointer2) {
        this.weight = weight;
        this.backPointer1 = backPointer1;
        this.backPointer2 = backPointer2;
    }

    public double getWeight() {
        return weight;
    }

    public ChartEntryKey getBackPointer1() {
        return backPointer1;
    }

    public ChartEntryKey getBackPointer2() {
        return backPointer2;
    }
}
