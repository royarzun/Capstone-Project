package info.royarzun.android.somtasks.data;

import android.net.Uri;

import net.simonvt.schematic.annotation.ContentProvider;
import net.simonvt.schematic.annotation.ContentUri;
import net.simonvt.schematic.annotation.TableEndpoint;


@ContentProvider(authority = DoneTaskContentProvider.AUTHORITY, database = DoneTaskDatabase.class)
public final class DoneTaskContentProvider {

    public static final String AUTHORITY = "info.royarzun.android.somtasks.data.DoneTaskContentProvider";

    @TableEndpoint(table = DoneTaskDatabase.DONE_TASKS)
    public static class DoneTasks {

        @ContentUri(
                path = "done_tasks",
                type = "vnd.android.cursor.dir/list",
                defaultSort = DoneTaskColumns.TASK_ID + " DESC")
        public static final Uri DONE_TASKS = Uri.parse("content://" + AUTHORITY + "/done_tasks");
    }
}
