import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Column {
    private final SQLOperators sqlOperators;
    private final ColumnQueryService columnQueryService;
    private JSONArray fieldValue;
    private String fieldName;
    private String operator;
    private String joinTableName;

    public Column() {
        this.sqlOperators = new SQLOperators();
        this.columnQueryService = new ColumnQueryService(this);
    }

    // SetColumnValues sets the column object values using the JSON reference
    public void setColumnValues(JSONObject column) {
        this.fieldName = column.get("fieldName").toString();
        this.fieldValue = (JSONArray) column.get("fieldValue");
        this.operator = this.sqlOperators.translateSQLOperator(column.get("operator").toString().toUpperCase());

        // Extended Functionalities - Join & Select
        this.joinTableName = "";
        if (this.sqlOperators.isJoinOperator(this.operator)) {
            this.joinTableName = column.get("tableName").toString();
        }
    }

    // GetColumnQuery returns the query to the current column
    public String getColumnQueryString() {
        return this.columnQueryService.buildColumnQueryString();
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getFieldValue() {
        StringBuilder values = new StringBuilder();
        var iterator = this.fieldValue.iterator();
        while (iterator.hasNext()) {
            values.append(iterator.next()).append(" ");
        }
        return values.toString().trim();
    }

    public String getOperator() {
        return this.operator;
    }

    public String getJoinTableName() {
        return this.joinTableName;
    }
}
