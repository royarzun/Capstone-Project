package info.royarzun.android.somtasks.data;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;


@Database(version = SomDatabase.VERSION)
public final class SomDatabase {

    public static final int VERSION = 1;

    public static class Tables {
        @Table(DoneTaskColumns.class)
        public static final String DONE_TASKS = "done_tasks";

        @Table(PendingTasksColumns.class)
        public static final String PENDING_TASKS = "pending_tasks";

        @Table(ActionFieldColumns.class)
        public static final String TASK_ACTIONS = "task_actions";
    }
}
