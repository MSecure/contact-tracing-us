package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

public final class a4 extends k4<ConnectionLifecycleCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z7 f2517a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a4(z7 z7Var) {
        super(null);
        this.f2517a = z7Var;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionInitiated(this.f2517a.f2822b, new ConnectionInfo.zza().zza(this.f2517a.f2823c).zzb(this.f2517a.f2824d).zza(this.f2517a.g).zza(this.f2517a.f2825e).zzb(this.f2517a.h).zzb(this.f2517a.i).zza());
    }
}
