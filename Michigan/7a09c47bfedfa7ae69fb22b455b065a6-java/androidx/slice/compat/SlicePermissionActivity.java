package androidx.slice.compat;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import b.b.k.e;
import b.i.j.a;
import b.v.a.b;
import b.v.a.c;

public class SlicePermissionActivity extends Activity implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public Uri f409b;

    /* renamed from: c  reason: collision with root package name */
    public String f410c;

    /* renamed from: d  reason: collision with root package name */
    public String f411d;

    /* renamed from: e  reason: collision with root package name */
    public e f412e;

    public final CharSequence a(PackageManager packageManager, ApplicationInfo applicationInfo) {
        String obj = Html.fromHtml(applicationInfo.loadLabel(packageManager).toString()).toString();
        int length = obj.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int codePointAt = obj.codePointAt(i);
            int type = Character.getType(codePointAt);
            if (type == 13 || type == 15 || type == 14) {
                obj = obj.substring(0, i);
            } else {
                if (type == 12) {
                    obj = obj.substring(0, i) + " " + obj.substring(Character.charCount(codePointAt) + i);
                }
                i += Character.charCount(codePointAt);
            }
        }
        String trim = obj.trim();
        if (trim.isEmpty()) {
            return applicationInfo.packageName;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(42.0f);
        return TextUtils.ellipsize(trim, textPaint, 500.0f, TextUtils.TruncateAt.END);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r6.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        throw r7;
     */
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            String packageName = getPackageName();
            String str = this.f410c;
            Uri build = this.f409b.buildUpon().path("").build();
            try {
                ContentProviderClient acquireUnstableContentProviderClient = getContentResolver().acquireUnstableContentProviderClient(build);
                if (acquireUnstableContentProviderClient != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("slice_uri", build);
                    bundle.putString("provider_pkg", packageName);
                    bundle.putString("pkg", str);
                    acquireUnstableContentProviderClient.call("grant_perms", "supports_versioned_parcelable", bundle);
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                } else {
                    throw new IllegalArgumentException("No provider found for " + build);
                }
            } catch (RemoteException unused) {
            }
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f409b = (Uri) getIntent().getParcelableExtra("slice_uri");
        this.f410c = getIntent().getStringExtra("pkg");
        this.f411d = getIntent().getStringExtra("provider_pkg");
        try {
            PackageManager packageManager = getPackageManager();
            String e2 = a.c().e(a(packageManager, packageManager.getApplicationInfo(this.f410c, 0)).toString());
            String e3 = a.c().e(a(packageManager, packageManager.getApplicationInfo(this.f411d, 0)).toString());
            e.a aVar = new e.a(this);
            aVar.f515a.f64f = getString(c.abc_slice_permission_title, new Object[]{e2, e3});
            int i = b.abc_slice_permission_request;
            AlertController.b bVar = aVar.f515a;
            bVar.t = null;
            bVar.s = i;
            bVar.u = false;
            int i2 = c.abc_slice_permission_deny;
            AlertController.b bVar2 = aVar.f515a;
            bVar2.k = bVar2.f59a.getText(i2);
            aVar.f515a.l = this;
            int i3 = c.abc_slice_permission_allow;
            AlertController.b bVar3 = aVar.f515a;
            bVar3.i = bVar3.f59a.getText(i3);
            aVar.f515a.j = this;
            aVar.f515a.o = this;
            e a2 = aVar.a();
            a2.show();
            this.f412e = a2;
            ((TextView) a2.getWindow().getDecorView().findViewById(b.v.a.a.text1)).setText(getString(c.abc_slice_permission_text_1, new Object[]{e3}));
            ((TextView) this.f412e.getWindow().getDecorView().findViewById(b.v.a.a.text2)).setText(getString(c.abc_slice_permission_text_2, new Object[]{e3}));
        } catch (PackageManager.NameNotFoundException unused) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        e eVar = this.f412e;
        if (eVar != null && eVar.isShowing()) {
            this.f412e.cancel();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        finish();
    }
}
