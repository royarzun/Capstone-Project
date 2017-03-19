package info.royarzun.android.somtasks;

import android.animation.TimeInterpolator;

import java.util.List;


public class FormItem {
    public final int taskId;
    public final String description;
    public final List<String> options;
    public final TimeInterpolator interpolator;


    public FormItem(int taskId, String description, List<String> options, TimeInterpolator interpolator) {
        this.taskId = taskId;
        this.description = description;
        this.interpolator = interpolator;
        this.options = options;
    }
}
