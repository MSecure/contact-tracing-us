package e.n.a;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public ProviderInfo a(ResolveInfo resolveInfo) {
        throw null;
    }

    public Signature[] b(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i2) {
        throw null;
    }
}
