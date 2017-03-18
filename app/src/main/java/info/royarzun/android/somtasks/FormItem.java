package info.royarzun.android.somtasks;

import android.animation.TimeInterpolator;


public class FormItem {

    public final String description;
    public final TimeInterpolator interpolator;

    public FormItem(String description, TimeInterpolator interpolator) {
        this.description = description;
        this.interpolator = interpolator;
    }
}
