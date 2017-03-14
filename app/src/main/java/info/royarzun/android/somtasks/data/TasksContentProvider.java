package info.royarzun.android.somtasks.data;

import android.net.Uri;

import net.simonvt.schematic.annotation.ContentProvider;
import net.simonvt.schematic.annotation.ContentUri;
import net.simonvt.schematic.annotation.TableEndpoint;


@ContentProvider(
        authority = TasksContentProvider.AUTHORITY,
        database = SomDatabase.class
)
public final class TasksContentProvider {

    public static final String AUTHORITY = "info.royarzun.android.somtasks.data.TasksContentProvider";

    @TableEndpoint(table = SomDatabase.Tables.DONE_TASKS)
    public static class DoneTasks {

        @ContentUri(
                path = "done_tasks",
                type = "vnd.android.cursor.dir/done_tasks",
                defaultSort = DoneTaskColumns.TASK_ID + " DESC")
        public static final Uri DONE_TASKS_URI = Uri.parse("content://" + AUTHORITY + "/done_tasks");
    }

    @TableEndpoint(table = SomDatabase.Tables.PENDING_TASKS)
    public static class PendingTasks {

        @ContentUri(
                path = "pending_tasks",
                type = "vnd.android.cursor.dir/pending_tasks"    ,
                defaultSort = PendingTasksColumns.TASK_ID + " DESC")
        public static final Uri PENDING_TASKS_URI = Uri.parse("content://" + AUTHORITY + "/pending_tasks");
    }
}
