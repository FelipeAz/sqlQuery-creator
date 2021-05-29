public class ColumnService {
    private final Column column;

    public ColumnService(Column column) {
        this.column = column;
    }

    // buildValue builds the query column value
    public String buildColumnQueryString() {
        return switch (this.column.getOperator()) {
            case "IN", "NOT IN" -> this.getFieldNameAndOperator() + this.buildManyValuesStatement();
            case "BETWEEN" -> this.getFieldNameAndOperator() + " " + this.buildTwoValuesStatement();
            case "LIKE" -> this.getFieldNameAndOperator() + " %" + this.buildOneValueStatement() + "%";
            default -> this.getFieldNameAndOperator() + " " + this.buildOneValueStatement();
        };
    }

    private String getFieldNameAndOperator() {
        return this.column.getFieldName() + " " + this.column.getOperator();
    }

    private String buildOneValueStatement() {
        return this.column.getFieldValue();
    }

    private String buildTwoValuesStatement() {
        String []values = this.column.getFieldValue().split(" ");
        return values[0] + " AND " + values[values.length-1];
    }

    private String buildManyValuesStatement() {
        return " (" + this.column.getFieldValue() + ")";
    }
}
