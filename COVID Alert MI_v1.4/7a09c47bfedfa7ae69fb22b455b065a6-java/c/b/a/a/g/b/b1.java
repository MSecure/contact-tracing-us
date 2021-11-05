package c.b.a.a.g.b;

import c.a.b.o;
import c.b.a.a.g.b.z0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3229a = Charset.forName(o.DEFAULT_PARAMS_ENCODING);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f3230b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f3230b = bArr;
        ByteBuffer.wrap(bArr);
        int length = f3230b.length;
        int i = length + 0;
        if (length < 0) {
            throw new f1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if ((0 - 0) + length <= Integer.MAX_VALUE) {
            int i2 = i + 0 + 0;
        } else {
            try {
                throw f1.a();
            } catch (f1 e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int i = length;
        for (int i2 = 0; i2 < 0 + length; i2++) {
            i = (i * 31) + bArr[i2];
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static int c(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static Object d(Object obj, Object obj2) {
        e2 e2Var = (e2) obj2;
        q qVar = (q) ((e2) obj).c();
        if (qVar != null) {
            z0.a aVar = (z0.a) qVar;
            if (aVar.f3484b.getClass().isInstance(e2Var)) {
                aVar.g((z0) ((p) e2Var));
                return aVar.i();
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        throw null;
    }

    public static <T> T e(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int f(boolean z) {
        return z ? 1231 : 1237;
    }

    public static String g(byte[] bArr) {
        return new String(bArr, f3229a);
    }

    public static int h(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
