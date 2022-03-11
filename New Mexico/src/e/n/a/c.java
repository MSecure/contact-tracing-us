package e.n.a;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import java.util.List;
/* loaded from: classes.dex */
public class c extends b {
    @Override // e.n.a.b
    public ProviderInfo a(ResolveInfo resolveInfo) {
        return resolveInfo.providerInfo;
    }

    @Override // e.n.a.b
    public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i2) {
        return packageManager.queryIntentContentProviders(intent, i2);
    }
}
