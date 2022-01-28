package c.b.a.a.g.e;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

public final class z3 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b8 f3826a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Status f3827b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z3(b8 b8Var, Status status) {
        super(null);
        this.f3826a = b8Var;
        this.f3827b = status;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.f3826a.f3513b, new ConnectionResolution(this.f3827b));
    }
}
