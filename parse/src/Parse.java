import java.io.*;
import java.util.*;

/**
 * Created by Chenyang Su on 3/18/2016.
 */
public class Parse {
    public static void main(String[] args) {
        /*we should deal with sentences in .sen one by one in chart, and print out the result*/
        try {
            FileReader grammarFile = new FileReader(args[0]);
            FileReader sentencesFile = new FileReader(args[1]);
            BufferedReader grammarBuffered = new BufferedReader(grammarFile);
            BufferedReader sentencesBuffered = new BufferedReader(sentencesFile);

            HashMap<String, ArrayList<Rule>> grammar = new HashMap<String, ArrayList<Rule>>();
            String line = null;
            String lhs;
            ArrayList<String> temp;
            double tempWeight;
            Rule tempRule;
            ArrayList<Rule> tempRuleList;
            ArrayList<String> tempSentence;
            Chart tempChart;
            while ((line = grammarBuffered.readLine()) != null) {
                temp = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
                tempWeight = (-1) * Math.log10(Double.parseDouble(temp.remove(0)))/Math.log10(2.0);
                tempRule = new Rule(tempWeight, temp);
                lhs = temp.get(0);
                if (grammar.get(lhs) == null) {
                    tempRuleList = new ArrayList<Rule>();
                    tempRuleList.add(tempRule);
                    grammar.put(lhs, tempRuleList);
                } else
                {
                    grammar.get(lhs).add(tempRule);
                }
            }

            while ((line = sentencesBuffered.readLine()) != null) {
                if (line.length() > 0) {
                    tempSentence = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
                    tempChart = new Chart(tempSentence, grammar);
                    tempChart.getParseWeight();
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open file");
        }
        catch (IOException ex) {
            System.out.println("Error reading file");
        }

    }
}
