import java.util.LinkedList;
import java.util.Queue;

public class Query {
    private Queue<String> queryString;

    public Query() {
        this.queryString = new LinkedList<>();
    }

    // AddQueryString adds a query to the query queue
    public void AddQueryString(String query) {
        this.queryString.add(query);
    }
}
