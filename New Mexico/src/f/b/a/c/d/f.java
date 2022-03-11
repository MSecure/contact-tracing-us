package f.b.a.c.d;

import android.os.IBinder;
import android.os.Parcel;
import f.b.a.c.c.a;
import f.b.a.c.e.b.b;
import f.b.a.c.e.b.c;
/* loaded from: classes.dex */
public final class f extends b implements g {
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // f.b.a.c.d.g
    public final a A(a aVar, String str, int i2, a aVar2) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(i2);
        c.b(p, aVar2);
        Parcel z = z(3, p);
        a z2 = a.AbstractBinderC0088a.z(z.readStrongBinder());
        z.recycle();
        return z2;
    }

    @Override // f.b.a.c.d.g
    public final a c(a aVar, String str, int i2, a aVar2) {
        Parcel p = p();
        c.b(p, aVar);
        p.writeString(str);
        p.writeInt(i2);
        c.b(p, aVar2);
        Parcel z = z(2, p);
        a z2 = a.AbstractBinderC0088a.z(z.readStrongBinder());
        z.recycle();
        return z2;
    }
}
