package b.i.d;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;

public class a extends b.i.e.a {

    /* renamed from: b.i.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0018a {
    }

    public interface b {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void f(Activity activity) {
        activity.finishAffinity();
    }

    public static void g(Activity activity) {
        activity.finishAfterTransition();
    }

    public static AbstractC0018a h() {
        return null;
    }

    public static void i(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void j(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28 || !b.b(activity)) {
            activity.recreate();
        }
    }

    public static void k(Activity activity, String[] strArr, int i) {
        ((b) activity).validateRequestPermissionsRequestCode(i);
        activity.requestPermissions(strArr, i);
    }

    public static void l(Activity activity) {
        activity.setEnterSharedElementCallback(null);
    }

    public static void m(Activity activity) {
        activity.setExitSharedElementCallback(null);
    }

    public static boolean n(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }

    public static void o(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void p(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void q(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
