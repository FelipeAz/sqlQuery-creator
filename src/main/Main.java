import org.json.simple.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("########## SQL Query Creator ##########\n");
        System.out.println("Press enter to confirm an action\n");

        try {
            System.out.println("Specify the JSON file path: ex: src/example.json ");
            Scanner sc = new Scanner(System.in);
            String filePath = sc.nextLine();

            JsonReaderService jsonReaderService = new JsonReaderService(filePath);
            JSONObject jsonContent = jsonReaderService.getContent();

            System.out.println("Specify the Table Name: ex: Table 1");
            String tableName = sc.next();
            sc.close();

            QueryService queryService = new QueryService(jsonContent);
            System.out.printf("\nQuery Result: %s\n", queryService.getQuery(tableName));
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
