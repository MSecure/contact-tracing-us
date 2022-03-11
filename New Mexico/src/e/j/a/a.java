package e.j.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import e.j.a.c;
/* loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ String[] b;
    public final /* synthetic */ Activity c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1530d;

    public a(String[] strArr, Activity activity, int i2) {
        this.b = strArr;
        this.c = activity;
        this.f1530d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.b.length];
        PackageManager packageManager = this.c.getPackageManager();
        String packageName = this.c.getPackageName();
        int length = this.b.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = packageManager.checkPermission(this.b[i2], packageName);
        }
        ((c.a) this.c).onRequestPermissionsResult(this.f1530d, this.b, iArr);
    }
}
