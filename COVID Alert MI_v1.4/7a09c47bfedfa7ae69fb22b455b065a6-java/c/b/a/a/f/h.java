package c.b.a.a.f;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.b.a.a.e.a;
import c.b.a.a.g.d.b;

public final class h implements f, IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f3208a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3209b = "com.google.android.gms.flags.IFlagProvider";

    public h(IBinder iBinder) {
        this.f3208a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3208a;
    }

    public final Parcel e0() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3209b);
        return obtain;
    }

    public final Parcel f0(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f3208a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    @Override // c.b.a.a.f.f
    public final boolean getBooleanFlagValue(String str, boolean z, int i) {
        Parcel e0 = e0();
        e0.writeString(str);
        b.a(e0, z);
        e0.writeInt(i);
        Parcel f0 = f0(2, e0);
        boolean z2 = f0.readInt() != 0;
        f0.recycle();
        return z2;
    }

    @Override // c.b.a.a.f.f
    public final int getIntFlagValue(String str, int i, int i2) {
        Parcel e0 = e0();
        e0.writeString(str);
        e0.writeInt(i);
        e0.writeInt(i2);
        Parcel f0 = f0(3, e0);
        int readInt = f0.readInt();
        f0.recycle();
        return readInt;
    }

    @Override // c.b.a.a.f.f
    public final long getLongFlagValue(String str, long j, int i) {
        Parcel e0 = e0();
        e0.writeString(str);
        e0.writeLong(j);
        e0.writeInt(i);
        Parcel f0 = f0(4, e0);
        long readLong = f0.readLong();
        f0.recycle();
        return readLong;
    }

    @Override // c.b.a.a.f.f
    public final String getStringFlagValue(String str, String str2, int i) {
        Parcel e0 = e0();
        e0.writeString(str);
        e0.writeString(str2);
        e0.writeInt(i);
        Parcel f0 = f0(5, e0);
        String readString = f0.readString();
        f0.recycle();
        return readString;
    }

    @Override // c.b.a.a.f.f
    public final void init(a aVar) {
        Parcel e0 = e0();
        b.b(e0, aVar);
        Parcel obtain = Parcel.obtain();
        try {
            this.f3208a.transact(1, e0, obtain, 0);
            obtain.readException();
        } finally {
            e0.recycle();
            obtain.recycle();
        }
    }
}
