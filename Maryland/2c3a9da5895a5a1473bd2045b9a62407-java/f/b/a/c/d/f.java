package f.b.a.c.d;

import android.os.IBinder;
import android.os.Parcel;
import f.b.a.c.c.a;
import f.b.a.c.e.b.b;
import f.b.a.c.e.b.c;

public final class f extends b implements g {
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // f.b.a.c.d.g
    public final a b(a aVar, String str, int i2, a aVar2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        c.b(k2, aVar2);
        Parcel m = m(2, k2);
        a m2 = a.AbstractBinderC0089a.m(m.readStrongBinder());
        m.recycle();
        return m2;
    }

    @Override // f.b.a.c.d.g
    public final a n(a aVar, String str, int i2, a aVar2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        c.b(k2, aVar2);
        Parcel m = m(3, k2);
        a m2 = a.AbstractBinderC0089a.m(m.readStrongBinder());
        m.recycle();
        return m2;
    }
}
