import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class ColumnQuery {
    private final SQLOperators sqlOperators;
    private final ColumnQueryService columnQueryService;
    private String fieldName;
    private JSONArray fieldValue;
    private String operator;

    public ColumnQuery() {
        this.sqlOperators = new SQLOperators();
        this.columnQueryService = new ColumnQueryService(this);
    }

    // SetColumnValues sets the column object values using the JSON reference
    public void setColumnValues(JSONObject column) {
        this.fieldName = column.get("fieldName").toString();
        this.fieldValue = (JSONArray) column.get("fieldValue");
        this.operator = this.sqlOperators.translateSQLOperator(column.get("operator").toString().toUpperCase());
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
        Iterator iterator = this.fieldValue.iterator();
        while (iterator.hasNext()) {
            values.append(iterator.next()).append(" ");
        }
        return values.toString().trim();
    }

    public String getOperator() {
        return this.operator;
    }
}
