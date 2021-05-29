import java.io.File;
import java.io.FileNotFoundException;

public class JsonFileValidator {
    private String filePath;

    public JsonFileValidator(String filePath) {
        this.filePath = filePath;
    }

    // validateAndReturnJsonFilePath checks if file exists
    public String validateAndReturnJsonFilePath() throws FileNotFoundException, InvalidJsonFile {
        File file = new File(this.filePath);
        if (!file.exists()) throw new FileNotFoundException("file does not exist");
        if (!this.hasValidFileExtension()) throw new InvalidJsonFile("invalid file extension");
        return filePath;
    }

    // hasValidFileExtension validates if the file extension is .json
    private boolean hasValidFileExtension() {
        return this.filePath.matches("([^\\s]+(\\.(?i)(json))$)");
    }
}
