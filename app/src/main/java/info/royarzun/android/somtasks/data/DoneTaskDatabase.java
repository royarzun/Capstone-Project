package info.royarzun.android.somtasks.data;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;


@Database(version = DoneTaskDatabase.VERSION)
public final class DoneTaskDatabase {

    public static final int VERSION = 1;
    @Table(DoneTaskColumns.class) public static final String DONE_TASKS = "done_tasks";
}
