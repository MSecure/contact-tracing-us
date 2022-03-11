package e.n.a;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
/* loaded from: classes.dex */
public class d extends c {
    @Override // e.n.a.b
    public Signature[] b(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
