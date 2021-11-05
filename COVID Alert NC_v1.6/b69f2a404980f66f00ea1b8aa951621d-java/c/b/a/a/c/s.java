package c.b.a.a.c;

import android.os.Parcel;
import android.os.RemoteException;
import b.b.k.i;
import c.b.a.a.c.l.g0;
import c.b.a.a.d.b;
import c.b.a.a.e.b.a;
import c.b.a.a.e.b.c;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class s extends a implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public int f2503a;

    public s(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        i.j.i(bArr.length == 25);
        this.f2503a = Arrays.hashCode(bArr);
    }

    public static byte[] e(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.b.a.a.e.b.a
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            c.b.a.a.d.a x = x();
            parcel2.writeNoException();
            c.b(parcel2, x);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int g0 = g0();
            parcel2.writeNoException();
            parcel2.writeInt(g0);
            return true;
        }
    }

    public abstract byte[] d();

    public boolean equals(Object obj) {
        c.b.a.a.d.a x;
        if (obj != null && (obj instanceof g0)) {
            try {
                g0 g0Var = (g0) obj;
                if (g0Var.g0() == this.f2503a && (x = g0Var.x()) != null) {
                    return Arrays.equals(d(), (byte[]) b.d(x));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    @Override // c.b.a.a.c.l.g0
    public final int g0() {
        return this.f2503a;
    }

    public int hashCode() {
        return this.f2503a;
    }

    @Override // c.b.a.a.c.l.g0
    public final c.b.a.a.d.a x() {
        return new b(d());
    }
}
