package info.royarzun.android.somtasks.data;

import net.simonvt.schematic.annotation.AutoIncrement;
import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.PrimaryKey;
import net.simonvt.schematic.annotation.References;

import static info.royarzun.android.somtasks.data.SomDatabase.Tables;
import static net.simonvt.schematic.annotation.DataType.Type.INTEGER;
import static net.simonvt.schematic.annotation.DataType.Type.TEXT;


public interface ActionFieldColumns {

    @DataType(INTEGER) @PrimaryKey
    @AutoIncrement
    String _ID = "_id";

    @DataType(INTEGER)
    @References(table = Tables.PENDING_TASKS, column = PendingTasksColumns._ID)
    String TASK_ID = "task_id";

    @DataType(INTEGER)
    String INDEX = "index";

    @DataType(INTEGER)
    String KEY_ID = "key_id";

    @DataType(TEXT)
    String REQUIRED = "required";
}
