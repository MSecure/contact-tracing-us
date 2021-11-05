package c.b.a.a.i.b;

import android.os.IBinder;
import android.os.Parcel;
import c.b.a.a.g.a.b;
import c.b.a.a.g.a.c;

public final class i extends b implements f {
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // c.b.a.a.i.b.f
    public final void H(l lVar, d dVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3211b);
        c.b(obtain, lVar);
        obtain.writeStrongBinder(dVar.asBinder());
        Parcel obtain2 = Parcel.obtain();
        try {
            this.f3210a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
