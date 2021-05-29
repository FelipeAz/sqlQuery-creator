import java.util.LinkedList;
import java.util.Queue;

public class Query {
    private Queue<String> queryString;

    public Query() {
        this.queryString = new LinkedList<>();
    }

    // adQueryString adds a query to the query queue
    public void addQueryString(String query) {
        this.queryString.add(query);
    }

    public Queue<String> getQueryString() {
        return queryString;
    }
}
