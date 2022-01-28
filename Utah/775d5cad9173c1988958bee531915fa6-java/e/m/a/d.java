package e.m.a;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

public class d extends c {
    @Override // e.m.a.b
    public Signature[] b(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
