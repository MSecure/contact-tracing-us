package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

public final class e4 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2560a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e4(String str) {
        super(null);
        this.f2560a = str;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.f2560a, new ConnectionResolution(v3.c(13)));
    }
}
