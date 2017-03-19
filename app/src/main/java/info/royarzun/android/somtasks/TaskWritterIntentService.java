package info.royarzun.android.somtasks;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class TaskWritterIntentService extends IntentService {
    public static final String EXTRA_TASK_ID = "task_id";
    public static final String EXTRA_FEEDBACK = "feedback";
    public static final String EXTRA_ACTION = "action";

    private String uid;
    private DatabaseReference mDatabase;

    public TaskWritterIntentService() {
        super(TaskWritterIntentService.class.getName());
        this.mDatabase = FirebaseDatabase.getInstance().getReference("done_tasks");
        this.uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent firebaseIntent) {
        Log.d("TASK", "ACA intentando correr la task");
        String key = mDatabase.child(this.uid).push().getKey();

        HashMap<String, Object> result = new HashMap<>();
        result.put("task_id", firebaseIntent.getIntExtra(EXTRA_TASK_ID, 0));
        result.put("feedback", firebaseIntent.getStringExtra(EXTRA_FEEDBACK));
        result.put("action", firebaseIntent.getStringExtra(EXTRA_ACTION));

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(key, result);

        mDatabase.updateChildren(childUpdates);
    }
}
