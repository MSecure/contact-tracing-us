package c.b.c.a.j0.a;

import c.a.b.o;
import c.b.c.a.j0.a.a;
import c.b.c.a.j0.a.y;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3518a = Charset.forName(o.DEFAULT_PARAMS_ENCODING);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f3519b;

    public interface a {
        int a();
    }

    public interface b {
        boolean a(int i);
    }

    public interface c<E> extends List<E>, RandomAccess {
        void d();

        c<E> g(int i);

        boolean k();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f3519b = bArr;
        ByteBuffer.wrap(bArr);
        byte[] bArr2 = f3519b;
        j.f(bArr2, 0, bArr2.length, false);
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
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

    public static int e(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static Object f(Object obj, Object obj2) {
        r0 r0Var = (r0) obj2;
        a.AbstractC0091a aVar = (a.AbstractC0091a) ((r0) obj).toBuilder();
        if (aVar != null) {
            y.a aVar2 = (y.a) aVar;
            if (aVar2.f3673b.getClass().isInstance(r0Var)) {
                aVar2.d();
                aVar2.f(aVar2.f3674c, (y) ((a) r0Var));
                return aVar2.c();
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        throw null;
    }

    public static int g(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static String h(byte[] bArr) {
        return new String(bArr, f3518a);
    }
}
