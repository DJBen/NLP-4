import java.util.*;

/**
 * Created by Chenyang Su on 3/21/2016.
 */
public class DottedRuleStartColumn {
    private int startColumn;
    private int dotPosition;
    private ArrayList<String> ruleExpression;

    public DottedRuleStartColumn(int startColumn, int dotPosition, ArrayList<String> ruleExpression) {
        this.startColumn = startColumn;
        this.dotPosition = dotPosition;
        this.ruleExpression = ruleExpression;
    }

}
