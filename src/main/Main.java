import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            JsonReaderService jsonReaderService = new JsonReaderService("src/query.json");
            JSONObject jsonContent = jsonReaderService.getContent();

            QueryService queryService = new QueryService(jsonContent);
            System.out.printf("Query: %s", queryService.getQuery("Teste"));
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
