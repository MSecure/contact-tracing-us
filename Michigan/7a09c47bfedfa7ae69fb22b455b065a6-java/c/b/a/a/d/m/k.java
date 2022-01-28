package c.b.a.a.d.m;

import android.os.IBinder;
import android.os.Parcel;

public final class k implements l {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f3137a;

    public k(IBinder iBinder) {
        this.f3137a = iBinder;
    }

    @Override // c.b.a.a.d.m.l
    public final void U(j jVar, e eVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(jVar.asBinder());
            obtain.writeInt(1);
            eVar.writeToParcel(obtain, 0);
            this.f3137a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f3137a;
    }
}
