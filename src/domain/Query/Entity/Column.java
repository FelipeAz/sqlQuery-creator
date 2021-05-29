import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class Column {
    private final SQLOperators sqlOperators;
    private final ColumnService columnService;
    private String fieldName;
    private JSONArray fieldValue;
    private String operator;

    public Column() {
        this.sqlOperators = new SQLOperators();
        this.columnService = new ColumnService(this);
    }

    // SetColumnValues sets the column object values using the JSON reference
    public void setColumnValues(JSONObject column) {
        this.fieldName = column.get("fieldName").toString();
        this.fieldValue = (JSONArray) column.get("fieldValue");
        this.operator = this.sqlOperators.translateSQLOperator(column.get("operator").toString().toUpperCase());
    }

    // GetColumnQuery returns the query to the current column
    public String getColumnQueryString() {
        return this.columnService.buildColumnQueryString();
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
}
