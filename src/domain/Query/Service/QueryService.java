import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class QueryService {
    private final JSONObject jsonQuery;

    public QueryService(JSONObject jsonQuery) throws Exception {
        JsonQueryValidator jsonQueryValidator = new JsonQueryValidator(jsonQuery);
        this.jsonQuery = jsonQueryValidator.validateAndReturnJsonQuery();
    }

    // Returns the query to the user
    public String getQuery(String table) {
        return this.buildQuery(table);
    }

    // Build Query maps the JSON Content on a Query Object
    private String buildQuery(String table) {
        StringBuilder queryString = new StringBuilder("SELECT FROM " + table + " WHERE ");

        JSONArray columns = (JSONArray) this.jsonQuery.get("columns");
        queryString.append(this.queryStringBuilder(columns,true));

        JSONArray join = (JSONArray) this.jsonQuery.get("join");
        if (join != null) {
            queryString.append(" ");
            queryString.append(this.queryStringBuilder(join, false));
        }

        return queryString.toString().trim();
    }

    private String queryStringBuilder(JSONArray jsonArray, boolean appendText) {
        Column columnObj = new Column();
        StringBuilder queryString = new StringBuilder("");
        var iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            columnObj.setColumnValues((JSONObject) iterator.next());
            queryString.append(columnObj.getColumnQueryString()).append(appendText ? iterator.hasNext() ? " AND " : " " : "");
        }
        return queryString.toString().trim();
    }
}
