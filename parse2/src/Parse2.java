import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Chenyang Su on 3/18/2016.
 */
public class Parse2 {
    public static void main(String[] args) {
        /*we should deal with sentences in .sen one by one in chart, and print out the result*/
        try {
            FileReader grammarFile = new FileReader(args[0]);
            FileReader sentencesFile = new FileReader(args[1]);
            BufferedReader grammarBuffered = new BufferedReader(grammarFile);
            BufferedReader sentencesBuffered = new BufferedReader(sentencesFile);

            Map<String, List<Rule>> grammar = new HashMap<>();
            String line = null;
            String lhs;
            ArrayList<String> temp;
            double tempWeight;
            Rule tempRule;
            ArrayList<Rule> tempRuleList;
            ArrayList<String> tempSentence;
            Chart tempChart;
            List<List<String>> sentences = new ArrayList<>();
            Set<String> sentenceTokens = new HashSet<>();
            while ((line = sentencesBuffered.readLine()) != null) {
                if (line.length() > 0) {
                    tempSentence = new ArrayList<>(Arrays.asList(line.split("\\s+")));
                    for (String s : tempSentence) {
                        sentenceTokens.add(s);
                    }
                    sentences.add(tempSentence);
                }
            }
            sentencesBuffered.close();

            Set<String> lhsSet = new HashSet<>();
            while ((line = grammarBuffered.readLine()) != null) {
                temp = new ArrayList<>(Arrays.asList(line.split("\\s+")));
                temp.remove(0);
                lhs = temp.get(0);
                lhsSet.add(lhs);
            }

            grammarBuffered.close();
            grammarBuffered = new BufferedReader(new FileReader(args[0]));

            while ((line = grammarBuffered.readLine()) != null) {
                temp = new ArrayList<>(Arrays.asList(line.split("\\s+")));
                tempWeight = (-1) * Math.log10(Double.parseDouble(temp.remove(0)))/Math.log10(2.0);
                lhs = temp.get(0);
                temp.remove(0);
                tempRule = new Rule(tempWeight, lhs, temp);
                boolean shouldAdd = true;
                for (String t : temp) {
                    if (!lhsSet.contains(t) && !sentenceTokens.contains(t)) {
                        shouldAdd = false;
                        break;
                    }
                }
                if (!shouldAdd) {
                    continue;
                }
                if (grammar.get(lhs) == null) {
                    tempRuleList = new ArrayList<Rule>();
                    tempRuleList.add(tempRule);
                    grammar.put(lhs, tempRuleList);
                } else {
                    grammar.get(lhs).add(tempRule);
                }
            }

            grammarBuffered.close();
            Grammar.loadGrammar(grammar);
            long startTime = System.currentTimeMillis();

            for (List<String> s : sentences) {
                tempChart = new Chart(s);
                System.out.println(tempChart.treeView());
            }

            System.out.println((System.currentTimeMillis() - startTime) / 1000.0 + " s");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open file");
        }
        catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
