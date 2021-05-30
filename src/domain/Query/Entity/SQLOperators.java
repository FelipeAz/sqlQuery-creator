import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SQLOperators {
    private final Map<String, String> sqlOperators;
    private final LinkedList<String> joinOperators;
    public SQLOperators() {
        this.sqlOperators = new HashMap<>() {
            {
                put("EQUAL", "=");
                put("NOT EQUAL", "<>");
                put("GREATER", ">");
                put("GREATERTHAN", ">");
                put("GREATERTHANOREQUAL", ">=");
                put("LOWER", "<");
                put("LOWERTHAN", "<");
                put("LOWERTHANOREQUAL", "<=");
            }
        };

        this.joinOperators = new LinkedList<>(){
            {
                add("JOIN");
                add("INNER JOIN");
                add("OUTER JOIN");
                add("LEFT JOIN");
                add("RIGHT JOIN");
                add("RIGHT EXCLUDING JOIN");
                add("OUTER EXCLUDING JOIN");
            }
        };
    }

    // translateSQLOperator translate an operator to the SQL syntax.
    public String translateSQLOperator(String sqlOperator) {
        String translatedOperator = this.sqlOperators.get(sqlOperator);
        if (translatedOperator == null) return sqlOperator;
        return translatedOperator;
    }

    // validate if the operator is a join operator
    public boolean isJoinOperator(String sqlOperator) {
        return this.joinOperators.contains(sqlOperator);
    }
}
