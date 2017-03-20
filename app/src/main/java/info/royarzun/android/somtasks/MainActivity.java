package info.royarzun.android.somtasks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.facebook.stetho.Stetho;
import com.firebase.ui.auth.AuthUI;
import com.github.aakira.expandablelayout.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import info.royarzun.android.somtasks.data.models.Task;


public class MainActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 200;

    private DatabaseReference mDatabase;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private List<FormItem> data = new ArrayList<>();
    private String userUID;

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.user_profile) TextView mUserProfileTV;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);

        // Initialize Firebase components
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
                if (user != null) {
                    // User is signed in
                    userUID = user.getUid();
                    Toast.makeText(MainActivity.this,
                            getResources().getText(R.string.welcome_session) +" "+ user.getEmail(),
                            Toast.LENGTH_SHORT).show();
                    mDatabase = FirebaseDatabase.getInstance().getReference("tasks");

                    mDatabase.child(userUID).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            Task newTask = dataSnapshot.getValue(Task.class);
                            data.add(new FormItem(newTask.id, newTask.label,
                                    newTask.forms.get(0).options,
                                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
                            mRecyclerView.setAdapter(new FormListAdapter(data));
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {
                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                } else {
                    // User is signed out
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.need_login_toast), Toast.LENGTH_SHORT).show();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setProviders(AuthUI.EMAIL_PROVIDER, AuthUI.GOOGLE_PROVIDER)
                                    .setTheme(R.style.FirebaseLoginTheme)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");

        try{
            mUserProfileTV.setText(getResources().getText(R.string.welcome_session) +
                    " " + mFirebaseAuth.getCurrentUser().getEmail() + ", "+ getResources().getText(R.string.todo_tasks_title) );
        } catch (NullPointerException e) {
            mUserProfileTV.setText("N/A");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main_action_logout:
                FirebaseAuth.getInstance().signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
