import java.util.*;

/**
 * Created by Chenyang Su on 3/19/2016.
 */
public class Rule {
    private double weight;
    private ArrayList<String> ruleExpression;
    public Rule(double weight, ArrayList<String> ruleExpression) {
        this.weight = weight;
        this.ruleExpression = new ArrayList<>();
        this.ruleExpression = ruleExpression;
    }

    public double getWeight() {
        return weight;
    }

    public ArrayList<String> getRuleExpression() {
        return ruleExpression;
    }
}
