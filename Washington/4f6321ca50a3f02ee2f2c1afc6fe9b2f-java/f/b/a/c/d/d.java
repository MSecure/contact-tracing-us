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
        Parcel n = n(6, l());
        int readInt = n.readInt();
        n.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a b(a aVar, String str, int i2, a aVar2) {
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(i2);
        c.b(l2, aVar2);
        Parcel n = n(8, l2);
        a n2 = a.AbstractBinderC0086a.n(n.readStrongBinder());
        n.recycle();
        return n2;
    }

    @Override // f.b.a.c.d.e
    public final int c(a aVar, String str, boolean z) {
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(z ? 1 : 0);
        Parcel n = n(5, l2);
        int readInt = n.readInt();
        n.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a k(a aVar, String str, int i2) {
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(i2);
        Parcel n = n(2, l2);
        a n2 = a.AbstractBinderC0086a.n(n.readStrongBinder());
        n.recycle();
        return n2;
    }

    @Override // f.b.a.c.d.e
    public final a m(a aVar, String str, boolean z) {
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(z ? 1 : 0);
        Parcel n = n(7, l2);
        a n2 = a.AbstractBinderC0086a.n(n.readStrongBinder());
        n.recycle();
        return n2;
    }

    @Override // f.b.a.c.d.e
    public final int p(a aVar, String str, boolean z) {
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(z ? 1 : 0);
        Parcel n = n(3, l2);
        int readInt = n.readInt();
        n.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a x(a aVar, String str, int i2) {
        Parcel l2 = l();
        c.b(l2, aVar);
        l2.writeString(str);
        l2.writeInt(i2);
        Parcel n = n(4, l2);
        a n2 = a.AbstractBinderC0086a.n(n.readStrongBinder());
        n.recycle();
        return n2;
    }
}
