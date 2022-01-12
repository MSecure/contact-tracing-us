package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;

public class ActivityCompat extends ContextCompat {

    public interface PermissionCompatDelegate {
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void finishAffinity(Activity activity) {
        activity.finishAffinity();
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return null;
    }

    public static void recreate(final Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            activity.recreate();
        } else if (i <= 23) {
            new Handler(activity.getMainLooper()).post(new Runnable() {
                /* class androidx.core.app.ActivityCompat.AnonymousClass2 */

                public void run() {
                    if (!activity.isFinishing() && !ActivityRecreator.recreate(activity)) {
                        activity.recreate();
                    }
                }
            });
        } else if (!ActivityRecreator.recreate(activity)) {
            activity.recreate();
        }
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        activity.requestPermissions(strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
