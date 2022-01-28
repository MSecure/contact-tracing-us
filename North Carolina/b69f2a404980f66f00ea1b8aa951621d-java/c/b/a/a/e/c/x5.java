package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

public final class x5 extends ConnectionLifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final ConnectionLifecycleCallback f2804a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u4 f2805b;

    public x5(u4 u4Var, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.f2805b = u4Var;
        this.f2804a = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.f2805b.d(str);
        }
        this.f2804a.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().p()) {
            this.f2805b.e(str);
        }
        this.f2804a.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        this.f2805b.e(str);
        this.f2804a.onDisconnected(str);
    }
}
