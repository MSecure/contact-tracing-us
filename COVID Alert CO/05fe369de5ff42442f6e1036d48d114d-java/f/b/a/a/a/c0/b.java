package f.b.a.a.a.c0;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import f.b.a.a.a.i.e0.a;
import gov.co.cdphe.exposurenotifications.R;

public final class b {
    public static final a a = a.e("UrlUtils");

    public static void a(View view, String str) {
        int i2;
        Uri parse = Uri.parse(str);
        if (!"https".equals(parse.getScheme())) {
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.scheme("https");
            parse = buildUpon.build();
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            view.getContext().startActivity(intent);
            return;
        } catch (ActivityNotFoundException unused) {
            i2 = R.string.browser_unavailable_error;
        } catch (Exception e2) {
            a.d(String.format("Exception while launching ACTION_VIEW with URL %s", parse.toString()), e2);
            i2 = R.string.generic_error_message;
        }
        int[] iArr = Snackbar.t;
        Snackbar.j(view, view.getResources().getText(i2), 0).l();
    }
}
