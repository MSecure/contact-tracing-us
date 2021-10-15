package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

public final class a4 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z7 f3500a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a4(z7 z7Var) {
        super(null);
        this.f3500a = z7Var;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionInitiated(this.f3500a.f3829b, new ConnectionInfo.zza().zza(this.f3500a.f3830c).zzb(this.f3500a.f3831d).zza(this.f3500a.f3834g).zza(this.f3500a.f3832e).zzb(this.f3500a.h).zzb(this.f3500a.i).zza());
    }
}
