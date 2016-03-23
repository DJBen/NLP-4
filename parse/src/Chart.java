import java.util.*;
import java.io.*;

/**
 * Created by Chenyang Su on 3/18/2016.
 */
public class Chart {
    private Vector<HashMap<DottedRuleStartColumn, WeightBackPointer>> chartTable;
    private int sentenceLength;
    public Chart(ArrayList<String> sentence, HashMap<String, ArrayList<Rule>> grammar) {
        sentenceLength = sentence.size();
        chartTable = new Vector<>(sentenceLength + 1);
        for (int i = 0; i <= sentenceLength; i++) {
            chartTable.add(new HashMap<DottedRuleStartColumn, WeightBackPointer>());
        }

        //initialization
        DottedRuleStartColumn initialKey = new DottedRuleStartColumn(0, 0,grammar.get("ROOT").get(0).getRuleExpression());
        chartTable.get(0).put(initialKey, new WeightBackPointer(grammar.get("ROOT").get(0).getWeight(), null, null));
        //There is one pointer of the entry iterate through each column one by one. There is also one pointer of the hashmap in the vector to indicate where to add new entries.
        //when the first pointer comes to a entry, the following situation may happen:
        // 1. predict    2. scan  3. attach
        //the end condition is that the entry pointer is at the end of vector's last hashmap
        //there is a lowest weight parse iff in the vector's last hashmap there is a complete ROOT rule.

        Iterator it;
        DottedRuleStartColumn entryPointer;
        int hashMapPosition; //this is the index of the hashmap in the vector where we are now adding new entries

        for(int i = 0; i <= sentenceLength; i++) {
           it = chartTable.get(i).entrySet().iterator();
           while (it.hasNext()) {
               Map.Entry pair = (Map.Entry)it.next();
               entryPointer = (DottedRuleStartColumn)pair.getKey();
               // do the entry operation
           }

        }



     /*   DottedRuleStartColumn entryPointer = initialKey;
        int hashMapPosition = 0; // this is the index of the hashmap in the vector where we are now adding new entries
        Iterator it;
        for (int i = 0; i <= sentenceLength; i++) {
            it = chartTable.get(i).entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                entryPointer = pair.getKey();

            }

        }*/




    }

    public double getParseWeight() {

    }
}
