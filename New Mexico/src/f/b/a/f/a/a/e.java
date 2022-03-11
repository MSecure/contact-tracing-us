package f.b.a.f.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import f.b.a.f.a.e.a;
import f.b.a.f.a.f.c;
/* loaded from: classes.dex */
public final class e extends c<InstallState> {
    public e(Context context) {
        super(new a("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    @Override // f.b.a.f.a.f.c
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.a.a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.a.a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        a aVar = this.a;
        aVar.a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        aVar.a("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        aVar.a("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        f.b.a.f.a.d.c cVar = new f.b.a.f.a.d.c(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0), intent.getLongExtra("total.bytes.to.download", 0), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
        this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", cVar);
        c(cVar);
    }
}
