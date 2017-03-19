package info.royarzun.android.somtasks.data.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@IgnoreExtraProperties
public class Task {
    public int id;
    public String type;
    public String label;
    public List<ActionFormField> forms = new ArrayList<>();

    public Task() {
    }

    public Task(int id, String type, String label, List<ActionFormField> forms) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.forms = forms;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("type", type);
        result.put("label", label);

        List<Object> actionForms = new ArrayList<>();

        for(ActionFormField actionFormField: forms){
            actionForms.add(actionFormField.toMap());
        }
        result.put("forms", actionForms);

        return result;
    }


}
