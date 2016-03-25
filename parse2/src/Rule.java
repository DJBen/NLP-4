import java.util.ArrayList;

/**
 * Created by Chenyang Su on 3/19/2016.
 */
public class Rule {
    private double weight;
    private String lhs;
    private ArrayList<String> ruleExpression;

    @Override
    public String toString() {
        return "\"" + weight +
                " " + ruleExpression +
                "\"";
    }

    public Rule(double weight, String lhs, ArrayList<String> ruleExpression) {
        this.weight = weight;
        this.lhs = lhs;
        this.ruleExpression = ruleExpression;
    }

    public double getWeight() {
        return weight;
    }

    public String getLhs() {
        return lhs;
    }

    public ArrayList<String> getRuleExpression() {
        return ruleExpression;
    }

}
