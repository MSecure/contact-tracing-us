package e.i.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import e.i.a.b;

public class a implements Runnable {
    public final /* synthetic */ String[] b;
    public final /* synthetic */ Activity c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1397d;

    public a(String[] strArr, Activity activity, int i2) {
        this.b = strArr;
        this.c = activity;
        this.f1397d = i2;
    }

    public void run() {
        int[] iArr = new int[this.b.length];
        PackageManager packageManager = this.c.getPackageManager();
        String packageName = this.c.getPackageName();
        int length = this.b.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = packageManager.checkPermission(this.b[i2], packageName);
        }
        ((b.a) this.c).onRequestPermissionsResult(this.f1397d, this.b, iArr);
    }
}
