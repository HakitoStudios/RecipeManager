package ua.nure.khmelevskoy.recipemanager;

import android.text.format.DateUtils;

public class DurationUtil {
    public static String formatDuration(long seconds){
        return DateUtils.formatElapsedTime(seconds);
    }
}
