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
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(i2);
        c.b(l2, aVar2);
        Parcel n = n(2, l2);
        a n2 = a.AbstractBinderC0086a.n(n.readStrongBinder());
        n.recycle();
        return n2;
    }

    @Override // f.b.a.c.d.g
    public final a o(a aVar, String str, int i2, a aVar2) {
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(i2);
        c.b(l2, aVar2);
        Parcel n = n(3, l2);
        a n2 = a.AbstractBinderC0086a.n(n.readStrongBinder());
        n.recycle();
        return n2;
    }
}
