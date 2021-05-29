import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonQueryValidator {
    private final JSONObject jsonQuery;

    public JsonQueryValidator(JSONObject jsonQuery) {
        this.jsonQuery = jsonQuery;
    }

    // Returns an exception if JSON is not valid
    public JSONObject validateAndReturnJsonQuery() throws EmptyQuery, MissingRequiredField {
        JSONArray column = (JSONArray) this.jsonQuery.get("columns");
        if (emptyArrayField(column)) throw new EmptyQuery("empty query");
        if (missingField(column)) throw new MissingRequiredField("missing required field");
        return jsonQuery;
    }

    private boolean emptyArrayField(JSONArray fieldArray) {
         return fieldArray == null || fieldArray.size() == 0;
    }

    private boolean missingField(JSONArray column) {
        var iterator = column.iterator();
        while (iterator.hasNext()) {
            JSONObject field = (JSONObject) iterator.next();
            JSONArray fieldValue = (JSONArray) field.get("fieldValue");
            if (field.get("fieldName") == null || field.get("operator") == null || emptyArrayField(fieldValue)) {
                return true;
            }
        }
        return false;
    }
}
