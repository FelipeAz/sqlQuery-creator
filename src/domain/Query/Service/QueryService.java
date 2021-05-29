import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;

public class QueryService {
    private final JSONObject jsonQuery;

    public QueryService(JSONObject jsonQuery) {
        this.jsonQuery = jsonQuery;
    }

    /********* Validate Query Fields *********/

    // Build Query maps the JSON Content on a Query Object
    public Query BuildQuery() {
        JSONArray columns = (JSONArray) this.jsonQuery.get("columns");
        Query queryObj = new Query();
        ColumnQuery columnQueryObj = new ColumnQuery();

        Iterator iterator = columns.iterator();
        while (iterator.hasNext()) {
            columnQueryObj.setColumnValues((JSONObject) iterator.next());
            queryObj.AddQueryString(columnQueryObj.getColumnQueryString());
        }

        return queryObj;
    }
}
