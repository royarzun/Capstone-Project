package info.royarzun.android.somtasks.data;

import net.simonvt.schematic.annotation.AutoIncrement;
import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.NotNull;
import net.simonvt.schematic.annotation.PrimaryKey;

import static net.simonvt.schematic.annotation.DataType.Type.INTEGER;
import static net.simonvt.schematic.annotation.DataType.Type.TEXT;

/**
 * Created by royarzun on 3/12/17.
 */

public interface DoneTaskColumns {
    @DataType(INTEGER) @PrimaryKey
    @AutoIncrement
    String _ID = "_id";

    @DataType(INTEGER) @NotNull
    String TASK_ID = "task_id";

    @DataType(TEXT)
    String RESOLVED_AT = "resolved_at";


    @DataType(TEXT) @NotNull
    String RESULT = "title";
}
