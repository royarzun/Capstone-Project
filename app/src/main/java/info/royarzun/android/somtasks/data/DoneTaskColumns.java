package info.royarzun.android.somtasks.data;

import net.simonvt.schematic.annotation.AutoIncrement;
import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.NotNull;
import net.simonvt.schematic.annotation.PrimaryKey;
import net.simonvt.schematic.annotation.References;

import static net.simonvt.schematic.annotation.DataType.Type.INTEGER;
import static net.simonvt.schematic.annotation.DataType.Type.TEXT;


public interface DoneTaskColumns {
    @DataType(INTEGER) @PrimaryKey
    @AutoIncrement
    String _ID = "_id";

    @DataType(INTEGER)
    @References(table = SomDatabase.Tables.PENDING_TASKS, column = PendingTasksColumns._ID)
    String TASK_ID = "task_id";

    @DataType(TEXT)
    String RESOLVED_AT = "resolved_at";


    @DataType(TEXT) @NotNull
    String RESULT = "title";
}
