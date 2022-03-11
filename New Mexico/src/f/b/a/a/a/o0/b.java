package f.b.a.a.a.o0;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import f.b.a.a.a.t.p0.a;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
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
        } catch (ActivityNotFoundException unused) {
            i2 = R.string.browser_unavailable_error;
            int[] iArr = Snackbar.s;
            Snackbar.j(view, view.getResources().getText(i2), 0).l();
        } catch (Exception e2) {
            a.d(String.format("Exception while launching ACTION_VIEW with URL %s", parse.toString()), e2);
            i2 = R.string.generic_error_message;
            int[] iArr2 = Snackbar.s;
            Snackbar.j(view, view.getResources().getText(i2), 0).l();
        }
    }
}
