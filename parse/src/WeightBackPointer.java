/**
 * Created by Chenyang Su on 3/21/2016.
 */
public class WeightBackPointer {
    private double weight;
    private DottedRuleStartColumn backPointer1;
    private DottedRuleStartColumn backPointer2;

    public WeightBackPointer(double weight, DottedRuleStartColumn backPointer1, DottedRuleStartColumn backPointer2) {
        this.weight = weight;
        this.backPointer1 = backPointer1;
        this.backPointer2 = backPointer2;
    }

}
