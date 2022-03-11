package f.b.a.c.b.m;

import android.os.IBinder;
import android.os.Parcel;
import f.b.a.c.e.b.a;

public final class j implements k {
    public final IBinder a;

    public j(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    @Override // f.b.a.c.b.m.k
    public final void y(i iVar, e eVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder((a) iVar);
            obtain.writeInt(1);
            eVar.writeToParcel(obtain, 0);
            this.a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
