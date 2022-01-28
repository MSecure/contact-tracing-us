package c.b.a.a.g.h;

import c.a.b.o;
import c.b.a.a.g.h.t1;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f4042a = Charset.forName(o.DEFAULT_PARAMS_ENCODING);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f4043b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f4043b = bArr;
        ByteBuffer.wrap(bArr);
        int length = f4043b.length;
        int i = length + 0;
        if (length < 0) {
            throw c2.b();
        } else if ((0 - 0) + length <= Integer.MAX_VALUE) {
            int i2 = i + 0 + 0;
        } else {
            try {
                throw c2.a();
            } catch (c2 e2) {
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

    public static <T> T d(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int e(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static Object f(Object obj, Object obj2) {
        c3 c3Var = (c3) obj2;
        j0 j0Var = (j0) ((c3) obj).e();
        if (j0Var != null) {
            t1.a aVar = (t1.a) j0Var;
            if (aVar.f4033b.getClass().isInstance(c3Var)) {
                aVar.h((t1) ((g0) c3Var));
                return aVar.j();
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        throw null;
    }

    public static String g(byte[] bArr) {
        return new String(bArr, f4042a);
    }

    public static int h(boolean z) {
        return z ? 1231 : 1237;
    }
}
