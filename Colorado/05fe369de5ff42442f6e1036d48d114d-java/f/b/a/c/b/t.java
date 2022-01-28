package f.b.a.c.b;

import android.os.Parcel;
import android.os.RemoteException;
import e.b.a.m;
import f.b.a.c.b.m.i0;
import f.b.a.c.c.b;
import f.b.a.c.e.b.a;
import f.b.a.c.e.b.c;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class t extends a implements i0 {
    public int a;

    public t(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        m.h.h(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    public static byte[] E(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // f.b.a.c.b.m.i0
    public final int D() {
        return this.a;
    }

    @Override // f.b.a.c.b.m.i0
    public final f.b.a.c.c.a a() {
        return new b(q());
    }

    public boolean equals(Object obj) {
        f.b.a.c.c.a a2;
        if (obj != null && (obj instanceof i0)) {
            try {
                i0 i0Var = (i0) obj;
                if (i0Var.D() == this.a && (a2 = i0Var.a()) != null) {
                    return Arrays.equals(q(), (byte[]) b.E(a2));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a;
    }

    @Override // f.b.a.c.e.b.a
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            b bVar = new b(q());
            parcel2.writeNoException();
            c.b(parcel2, bVar);
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            int i4 = this.a;
            parcel2.writeNoException();
            parcel2.writeInt(i4);
            return true;
        }
    }

    public abstract byte[] q();
}
