package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

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
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline15("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        activity.requestPermissions(strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
