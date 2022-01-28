package c.b.a.a.c.l;

import android.os.IBinder;
import android.os.Parcel;

public final class m implements n {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f2471a;

    public m(IBinder iBinder) {
        this.f2471a = iBinder;
    }

    @Override // c.b.a.a.c.l.n
    public final void X(l lVar, f fVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(lVar.asBinder());
            obtain.writeInt(1);
            fVar.writeToParcel(obtain, 0);
            this.f2471a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f2471a;
    }
}
