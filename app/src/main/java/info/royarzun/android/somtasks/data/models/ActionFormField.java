package info.royarzun.android.somtasks.data.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@IgnoreExtraProperties
public class ActionFormField {
    public int index;
    public int keyId;
    public List<String> options;
    public boolean required;

    public ActionFormField() {
    }

    public ActionFormField(int index, int keyId, List<String> options, boolean required) {
        this.index = index;
        this.keyId = keyId;
        this.required = required;
        this.options = options;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("index", index);
        result.put("key_id", keyId);
        result.put("required", required);
        result.put("options", options);
        return result;
    }
}
