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
/* loaded from: classes.dex */
public abstract class t extends a implements i0 {
    public int a;

    public t(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        m.e.h(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    public static byte[] Q(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // f.b.a.c.b.m.i0
    public final int O() {
        return this.a;
    }

    @Override // f.b.a.c.b.m.i0
    public final f.b.a.c.c.a b() {
        return new b(z());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        f.b.a.c.c.a b;
        if (obj != null && (obj instanceof i0)) {
            try {
                i0 i0Var = (i0) obj;
                if (i0Var.O() == this.a && (b = i0Var.b()) != null) {
                    return Arrays.equals(z(), (byte[]) b.Q(b));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a;
    }

    @Override // f.b.a.c.e.b.a
    public final boolean p(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            b bVar = new b(z());
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

    public abstract byte[] z();
}
