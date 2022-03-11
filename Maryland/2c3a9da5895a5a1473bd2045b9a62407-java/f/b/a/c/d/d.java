package f.b.a.c.d;

import android.os.IBinder;
import android.os.Parcel;
import f.b.a.c.c.a;
import f.b.a.c.e.b.b;
import f.b.a.c.e.b.c;

public final class d extends b implements e {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // f.b.a.c.d.e
    public final int a() {
        Parcel m = m(6, k());
        int readInt = m.readInt();
        m.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a b(a aVar, String str, int i2, a aVar2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        c.b(k2, aVar2);
        Parcel m = m(8, k2);
        a m2 = a.AbstractBinderC0089a.m(m.readStrongBinder());
        m.recycle();
        return m2;
    }

    @Override // f.b.a.c.d.e
    public final int d(a aVar, String str, boolean z) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(z ? 1 : 0);
        Parcel m = m(5, k2);
        int readInt = m.readInt();
        m.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a j(a aVar, String str, int i2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        Parcel m = m(2, k2);
        a m2 = a.AbstractBinderC0089a.m(m.readStrongBinder());
        m.recycle();
        return m2;
    }

    @Override // f.b.a.c.d.e
    public final a l(a aVar, String str, boolean z) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(z ? 1 : 0);
        Parcel m = m(7, k2);
        a m2 = a.AbstractBinderC0089a.m(m.readStrongBinder());
        m.recycle();
        return m2;
    }

    @Override // f.b.a.c.d.e
    public final int o(a aVar, String str, boolean z) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(z ? 1 : 0);
        Parcel m = m(3, k2);
        int readInt = m.readInt();
        m.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a u(a aVar, String str, int i2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        Parcel m = m(4, k2);
        a m2 = a.AbstractBinderC0089a.m(m.readStrongBinder());
        m.recycle();
        return m2;
    }
}
