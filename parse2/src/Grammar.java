import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by DJBen on 3/23/16.
 */
public class Grammar {
    private static Map<String, List<Rule>> grammar;

    public static void loadGrammar(Map<String, List<Rule>> g) {
        grammar = g;
    }

    public static List<Rule> getRulesForSymbol(String symbol) {
        return grammar.get(symbol);
    }

    public static boolean isTerminal(String str) {
        return grammar.get(str) == null;
    }

    @Override
    public String toString() {
        return grammar.toString();
    }
}
