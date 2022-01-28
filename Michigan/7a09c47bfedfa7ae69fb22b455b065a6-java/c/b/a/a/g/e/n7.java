package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;

public final class n7 extends a0 implements l7 {
    public n7(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // c.b.a.a.g.e.l7
    public final void G(m8 m8Var) {
        Parcel a_ = a_();
        s1.b(a_, m8Var);
        zzc(2, a_);
    }

    @Override // c.b.a.a.g.e.l7
    public final void L(o8 o8Var) {
        Parcel a_ = a_();
        s1.b(a_, o8Var);
        zzc(3, a_);
    }
}
