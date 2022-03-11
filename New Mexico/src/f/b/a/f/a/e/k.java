package f.b.a.f.a.e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes.dex */
public final class k implements ServiceConnection {
    public final /* synthetic */ l a;

    public /* synthetic */ k(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.a.a().post(new i(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.a.a().post(new j(this));
    }
}
