package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;

public final class g7 extends a0 implements e7 {
    public g7(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // c.b.a.a.e.c.e7
    public final void W(f8 f8Var) {
        Parcel a_ = a_();
        s1.b(a_, f8Var);
        zzc(5, a_);
    }

    @Override // c.b.a.a.e.c.e7
    public final void b0(h8 h8Var) {
        Parcel a_ = a_();
        s1.b(a_, h8Var);
        zzc(2, a_);
    }

    @Override // c.b.a.a.e.c.e7
    public final void d0(s8 s8Var) {
        Parcel a_ = a_();
        s1.b(a_, s8Var);
        zzc(4, a_);
    }

    @Override // c.b.a.a.e.c.e7
    public final void f0(j8 j8Var) {
        Parcel a_ = a_();
        s1.b(a_, j8Var);
        zzc(3, a_);
    }
}
