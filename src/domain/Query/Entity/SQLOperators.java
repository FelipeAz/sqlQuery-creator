import java.util.HashMap;
import java.util.Map;

public class SQLOperators {
    private final Map<String, String> sqlOperators;
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
    }

    // translateSQLOperator translate an operator to the SQL syntax.
    public String translateSQLOperator(String sqlOperator) {
        String translatedOperator = this.sqlOperators.get(sqlOperator);
        if (translatedOperator == null) return sqlOperator;
        return translatedOperator;
    }
}
