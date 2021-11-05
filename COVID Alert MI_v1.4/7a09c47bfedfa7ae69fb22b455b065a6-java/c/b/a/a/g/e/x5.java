package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

public final class x5 extends ConnectionLifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final ConnectionLifecycleCallback f3811a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u4 f3812b;

    public x5(u4 u4Var, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.f3812b = u4Var;
        this.f3811a = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.f3812b.d(str);
        }
        this.f3811a.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().t()) {
            this.f3812b.e(str);
        }
        this.f3811a.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        this.f3812b.e(str);
        this.f3811a.onDisconnected(str);
    }
}
