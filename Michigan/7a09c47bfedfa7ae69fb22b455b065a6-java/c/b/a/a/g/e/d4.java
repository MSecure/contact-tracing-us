package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

public final class d4 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3531a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d4(String str) {
        super(null);
        this.f3531a = str;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onDisconnected(this.f3531a);
    }
}
