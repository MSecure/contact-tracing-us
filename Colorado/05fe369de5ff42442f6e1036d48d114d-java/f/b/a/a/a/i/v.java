package f.b.a.a.a.i;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import f.b.b.a.a;
import f.b.b.a.l;
import f.b.b.a.o;
import java.util.Locale;
import java.util.regex.Pattern;

public final class v {
    public static final String a;
    public static final Pattern b;

    static {
        String format = String.format(Locale.US, "^[a-zA-Z0-9]{1,%d}$", 128);
        a = format;
        b = Pattern.compile(format);
    }

    public static Intent a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        launchIntentForPackage.setFlags(268468224);
        launchIntentForPackage.putExtra("IntentUtil.EXTRA_NOTIFICATION", true);
        return launchIntentForPackage;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent(context, ExposureNotificationDismissedReceiver.class);
        intent.setAction("ApolloExposureNotificationCallback.NOTIFICATION_DISMISSED_ACTION_ID");
        return intent;
    }

    public static l<String> c(Uri uri) {
        if (uri == null) {
            return a.b;
        }
        String value = new UrlQuerySanitizer(uri.toString()).getValue("c");
        if (value == null) {
            return a.b;
        }
        return !b.matcher(value).find() ? a.b : new o(value);
    }
}
