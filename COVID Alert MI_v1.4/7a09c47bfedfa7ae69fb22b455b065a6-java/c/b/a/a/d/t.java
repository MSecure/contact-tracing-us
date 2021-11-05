package c.b.a.a.d;

import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.a.d.m.k0;
import c.b.a.a.e.b;
import c.b.a.a.g.c.a;
import c.b.a.a.g.c.c;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class t extends a implements k0 {

    /* renamed from: a  reason: collision with root package name */
    public int f3184a;

    public t(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        b.x.t.q(bArr.length == 25);
        this.f3184a = Arrays.hashCode(bArr);
    }

    public static byte[] g0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.b.a.a.d.m.k0
    public final int c() {
        return this.f3184a;
    }

    @Override // c.b.a.a.g.c.a
    public final boolean e0(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            c.b.a.a.e.a u = u();
            parcel2.writeNoException();
            c.b(parcel2, u);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int c2 = c();
            parcel2.writeNoException();
            parcel2.writeInt(c2);
            return true;
        }
    }

    public boolean equals(Object obj) {
        c.b.a.a.e.a u;
        if (obj != null && (obj instanceof k0)) {
            try {
                k0 k0Var = (k0) obj;
                if (k0Var.c() == this.f3184a && (u = k0Var.u()) != null) {
                    return Arrays.equals(f0(), (byte[]) b.g0(u));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public abstract byte[] f0();

    public int hashCode() {
        return this.f3184a;
    }

    @Override // c.b.a.a.d.m.k0
    public final c.b.a.a.e.a u() {
        return new b(f0());
    }
}
