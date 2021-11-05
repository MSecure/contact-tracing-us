package c.b.a.a.e.c;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

public final class z3 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b8 f2819a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Status f2820b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z3(b8 b8Var, Status status) {
        super(null);
        this.f2819a = b8Var;
        this.f2820b = status;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.f2819a.f2528b, new ConnectionResolution(this.f2820b));
    }
}
