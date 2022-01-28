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
import androidx.slice.core.R$id;
import androidx.slice.core.R$layout;
import androidx.slice.core.R$string;
import e.b.a.g;
import e.i.g.a;

public class SlicePermissionActivity extends Activity implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    public Uri b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f296d;

    /* renamed from: e  reason: collision with root package name */
    public g f297e;

    public final CharSequence a(PackageManager packageManager, ApplicationInfo applicationInfo) {
        String obj = Html.fromHtml(applicationInfo.loadLabel(packageManager).toString()).toString();
        int length = obj.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int codePointAt = obj.codePointAt(i2);
            int type = Character.getType(codePointAt);
            if (type == 13 || type == 15 || type == 14) {
                obj = obj.substring(0, i2);
            } else {
                if (type == 12) {
                    obj = obj.substring(0, i2) + " " + obj.substring(Character.charCount(codePointAt) + i2);
                }
                i2 += Character.charCount(codePointAt);
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
    public void onClick(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            String packageName = getPackageName();
            String str = this.c;
            Uri build = this.b.buildUpon().path("").build();
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
        this.b = (Uri) getIntent().getParcelableExtra("slice_uri");
        this.c = getIntent().getStringExtra("pkg");
        this.f296d = getIntent().getStringExtra("provider_pkg");
        try {
            PackageManager packageManager = getPackageManager();
            String e2 = a.c().e(a(packageManager, packageManager.getApplicationInfo(this.c, 0)).toString());
            String e3 = a.c().e(a(packageManager, packageManager.getApplicationInfo(this.f296d, 0)).toString());
            g.a aVar = new g.a(this);
            String string = getString(R$string.abc_slice_permission_title, new Object[]{e2, e3});
            AlertController.b bVar = aVar.a;
            bVar.f30d = string;
            bVar.q = R$layout.abc_slice_permission_request;
            bVar.f35i = bVar.a.getText(R$string.abc_slice_permission_deny);
            AlertController.b bVar2 = aVar.a;
            bVar2.f36j = this;
            bVar2.f33g = bVar2.a.getText(R$string.abc_slice_permission_allow);
            AlertController.b bVar3 = aVar.a;
            bVar3.f34h = this;
            bVar3.m = this;
            g b2 = aVar.b();
            this.f297e = b2;
            ((TextView) b2.getWindow().getDecorView().findViewById(R$id.text1)).setText(getString(R$string.abc_slice_permission_text_1, new Object[]{e3}));
            ((TextView) this.f297e.getWindow().getDecorView().findViewById(R$id.text2)).setText(getString(R$string.abc_slice_permission_text_2, new Object[]{e3}));
        } catch (PackageManager.NameNotFoundException unused) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        g gVar = this.f297e;
        if (gVar != null && gVar.isShowing()) {
            this.f297e.cancel();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        finish();
    }
}
