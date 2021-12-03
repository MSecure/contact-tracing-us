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
        Parcel q = q(6, k());
        int readInt = q.readInt();
        q.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a b(a aVar, String str, int i2, a aVar2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        c.b(k2, aVar2);
        Parcel q = q(8, k2);
        a q2 = a.AbstractBinderC0086a.q(q.readStrongBinder());
        q.recycle();
        return q2;
    }

    @Override // f.b.a.c.d.e
    public final int d(a aVar, String str, boolean z) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(z ? 1 : 0);
        Parcel q = q(5, k2);
        int readInt = q.readInt();
        q.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a h(a aVar, String str, int i2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        Parcel q = q(2, k2);
        a q2 = a.AbstractBinderC0086a.q(q.readStrongBinder());
        q.recycle();
        return q2;
    }

    @Override // f.b.a.c.d.e
    public final a p(a aVar, String str, boolean z) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(z ? 1 : 0);
        Parcel q = q(7, k2);
        a q2 = a.AbstractBinderC0086a.q(q.readStrongBinder());
        q.recycle();
        return q2;
    }

    @Override // f.b.a.c.d.e
    public final int s(a aVar, String str, boolean z) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(z ? 1 : 0);
        Parcel q = q(3, k2);
        int readInt = q.readInt();
        q.recycle();
        return readInt;
    }

    @Override // f.b.a.c.d.e
    public final a z(a aVar, String str, int i2) {
        Parcel k2 = k();
        c.b(k2, aVar);
        k2.writeString(str);
        k2.writeInt(i2);
        Parcel q = q(4, k2);
        a q2 = a.AbstractBinderC0086a.q(q.readStrongBinder());
        q.recycle();
        return q2;
    }
}
