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
        Query query = this.buildQuery();
        String queryString = "SELECT FROM " + table + " WHERE ";

        Iterator iterator = query.getQueryString().iterator();
        while (iterator.hasNext()) {
            queryString += iterator.next() + (iterator.hasNext() ? " AND " : "");
        }

        return queryString;
    }

    // Build Query maps the JSON Content on a Query Object
    private Query buildQuery() {
        JSONArray columns = (JSONArray) this.jsonQuery.get("columns");
        Query queryObj = new Query();
        Column columnObj = new Column();

        Iterator iterator = columns.iterator();
        while (iterator.hasNext()) {
            columnObj.setColumnValues((JSONObject) iterator.next());
            queryObj.addQueryString(columnObj.getColumnQueryString());
        }

        return queryObj;
    }
}
