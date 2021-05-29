public class ColumnQueryService {
    private ColumnQuery columnQuery;

    public ColumnQueryService(ColumnQuery columnQuery) {
        this.columnQuery = columnQuery;
    }

    // buildValue builds the query column value
    public String buildColumnQueryString() {
        return switch (this.columnQuery.getOperator()) {
            case "IN", "NOT IN" -> this.getFieldNameAndOperator() + this.buildManyValuesStatement();
            case "BETWEEN" -> this.getFieldNameAndOperator() + " " + this.buildTwoValuesStatement();
            default -> this.getFieldNameAndOperator() + " " + this.buildOneValueStatement();
        };
    }

    private String getFieldNameAndOperator() {
        return this.columnQuery.getFieldName() + " " + this.columnQuery.getOperator();
    }

    private String buildOneValueStatement() {
        return this.columnQuery.getFieldValue();
    }

    private String buildTwoValuesStatement() {
        String []values = this.columnQuery.getFieldValue().split(" ");
        return values[0] + " AND " + values[values.length-1];
    }

    private String buildManyValuesStatement() {
        return " (" + this.columnQuery.getFieldValue() + ")";
    }
}
