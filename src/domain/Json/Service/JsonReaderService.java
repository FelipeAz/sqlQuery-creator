import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class JsonReaderService {
    private final String filePath;

    public JsonReaderService(String filePath) throws FileNotFoundException, InvalidJsonFile {
        JsonFileValidator validator = new JsonFileValidator(filePath);
        this.filePath = validator.validateAndReturnJsonFilePath();
    }

    // GetContent returns the json content
    public JSONObject getContent() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        try (Reader reader = new FileReader(this.filePath)) {
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (ParseException e) {
            throw new InvalidJsonFormat("invalid json format");
        }
        return jsonObject;
    }
}
