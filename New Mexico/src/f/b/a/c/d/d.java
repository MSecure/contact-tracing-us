package f.b.a.c.d;

import android.os.IBinder;
import android.os.Parcel;
import f.b.a.c.c.a;
import f.b.a.c.e.b.b;
import f.b.a.c.e.b.c;
/* loaded from: classes.dex */
public final class d extends b implements e {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // f.b.a.c.d.e
    public final int C(a aVar, String str, boolean z) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(z ? 1 : 0);
        Parcel z2 = z(3, p);
        int readInt = z2.readInt();
        z2.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a J(a aVar, String str, int i2) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(i2);
        Parcel z = z(4, p);
        a z2 = a.AbstractBinderC0088a.z(z.readStrongBinder());
        z.recycle();
        return z2;
    }

    @Override // f.b.a.c.d.e
    public final int b() {
        Parcel z = z(6, p());
        int readInt = z.readInt();
        z.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a c(a aVar, String str, int i2, a aVar2) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(i2);
        c.b(p, aVar2);
        Parcel z = z(8, p);
        a z2 = a.AbstractBinderC0088a.z(z.readStrongBinder());
        z.recycle();
        return z2;
    }

    @Override // f.b.a.c.d.e
    public final int e(a aVar, String str, boolean z) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(z ? 1 : 0);
        Parcel z2 = z(5, p);
        int readInt = z2.readInt();
        z2.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a k(a aVar, String str, int i2) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(i2);
        Parcel z = z(2, p);
        a z2 = a.AbstractBinderC0088a.z(z.readStrongBinder());
        z.recycle();
        return z2;
    }

    @Override // f.b.a.c.d.e
    public final a y(a aVar, String str, boolean z) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(z ? 1 : 0);
        Parcel z2 = z(7, p);
        a z3 = a.AbstractBinderC0088a.z(z2.readStrongBinder());
        z2.recycle();
        return z3;
    }
}
