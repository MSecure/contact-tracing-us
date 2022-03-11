package f.b.a.c.h.b;

import android.os.IBinder;
import android.os.Parcel;
import f.b.a.c.e.a.a;
import f.b.a.c.e.a.b;
import f.b.a.c.e.a.c;

public final class i extends b implements f {
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // f.b.a.c.h.b.f
    public final void r(l lVar, d dVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        int i2 = c.a;
        obtain.writeInt(1);
        lVar.writeToParcel(obtain, 0);
        obtain.writeStrongBinder((a) dVar);
        Parcel obtain2 = Parcel.obtain();
        try {
            this.a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
