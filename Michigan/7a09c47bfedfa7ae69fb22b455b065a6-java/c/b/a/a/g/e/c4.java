package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

public final class c4 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d8 f3524a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c4(d8 d8Var) {
        super(null);
        this.f3524a = d8Var;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onDisconnected(this.f3524a.f3536b);
    }
}
