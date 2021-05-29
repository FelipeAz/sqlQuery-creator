import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;

public class QueryService {
    private final JSONObject jsonQuery;

    public QueryService(JSONObject jsonQuery) {
        this.jsonQuery = jsonQuery;
    }

    /********* Validate Query Fields *********/

    // Returns the query to the user
    public String getQuery(String table) {
        return this.buildQuery(table);
    }

    // Build Query maps the JSON Content on a Query Object
    private String buildQuery(String table) {
        StringBuilder queryString = new StringBuilder("SELECT FROM " + table + " WHERE ");

        JSONArray columns = (JSONArray) this.jsonQuery.get("columns");
        Column columnObj = new Column();
        var iterator = columns.iterator();
        while (iterator.hasNext()) {
            columnObj.setColumnValues((JSONObject) iterator.next());
            queryString.append(columnObj.getColumnQueryString())
                    .append(iterator.hasNext() ? " AND " : "");
        }

        return queryString.toString();
    }
}
