package info.royarzun.android.somtasks.data.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;


@IgnoreExtraProperties
public class ActionFormField {
    public int index;
    public int keyId;
    public String inputType;
    public String fieldLabel;
    public boolean required;

    public ActionFormField() {
    }

    public ActionFormField(int index, int keyId, String inputType, String fieldLabel, boolean required) {
        this.index = index;
        this.keyId = keyId;
        this.inputType = inputType;
        this.fieldLabel = fieldLabel;
        this.required = required;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("index", index);
        result.put("key_id", keyId);
        result.put("input_type", inputType);
        result.put("field_label", fieldLabel);
        result.put("required", required);
        return result;
    }
}
