package src.app.domain.query.validator;

import src.app.domain.query.exception.EmptyQuery;
import src.app.domain.query.exception.MissingRequiredField;
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
        JSONArray join = (JSONArray) this.jsonQuery.get("join");

        if (emptyArrayField(column)) throw new EmptyQuery("empty query");
        if (missingField(column, false)) throw new MissingRequiredField("missing required field");

        if (join != null) {
            if (emptyArrayField(join)) throw new EmptyQuery("empty join query");
            if (missingField(join, true)) throw new MissingRequiredField("missing join required field");
        }

        return jsonQuery;
    }

    private boolean emptyArrayField(JSONArray fieldArray) {
         return fieldArray == null || fieldArray.size() == 0;
    }

    private boolean missingField(JSONArray column, boolean validateTableName) {
        var iterator = column.iterator();
        while (iterator.hasNext()) {
            JSONObject field = (JSONObject) iterator.next();
            JSONArray fieldValue = (JSONArray) field.get("fieldValue");

            if (this.isJsonFieldEmpty(field, "fieldName")
                || this.isJsonFieldEmpty(field, "operator")
                || this.emptyArrayField(fieldValue)
                || (validateTableName && this.isJsonFieldEmpty(field, "tableName"))
            ) {
                return true;
            }
        }
        return false;
    }

    private boolean isJsonFieldEmpty(JSONObject field, String fieldName) {
        Object fieldObj = field.get(fieldName);
        if (fieldObj == null || fieldObj == "") {
            return true;
        }
        return false;
    }
}
