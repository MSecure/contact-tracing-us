package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

public final class c4 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d8 f2539a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c4(d8 d8Var) {
        super(null);
        this.f2539a = d8Var;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onDisconnected(this.f2539a.f2551b);
    }
}
