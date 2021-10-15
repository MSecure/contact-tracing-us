package c.b.a.a.g.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.b.a.a.c.f;

public final class d5 implements c5, IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f3247a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3248b = "com.google.android.gms.clearcut.internal.IClearcutLoggerService";

    public d5(IBinder iBinder) {
        this.f3247a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3247a;
    }

    @Override // c.b.a.a.g.b.c5
    public final void c0(a5 a5Var, f fVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3248b);
        s0.b(obtain, a5Var);
        if (fVar == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            fVar.writeToParcel(obtain, 0);
        }
        try {
            this.f3247a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
