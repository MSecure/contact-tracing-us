package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;

public final class z6 extends a0 implements x6 {
    public z6(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // c.b.a.a.g.e.x6
    public final void I(b8 b8Var) {
        Parcel a_ = a_();
        s1.b(a_, b8Var);
        zzc(3, a_);
    }

    @Override // c.b.a.a.g.e.x6
    public final void O(d8 d8Var) {
        Parcel a_ = a_();
        s1.b(a_, d8Var);
        zzc(4, a_);
    }

    @Override // c.b.a.a.g.e.x6
    public final void t(x7 x7Var) {
        Parcel a_ = a_();
        s1.b(a_, x7Var);
        zzc(5, a_);
    }

    @Override // c.b.a.a.g.e.x6
    public final void x(z7 z7Var) {
        Parcel a_ = a_();
        s1.b(a_, z7Var);
        zzc(2, a_);
    }
}
