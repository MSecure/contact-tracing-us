package c.b.d;

import c.a.b.o;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f5438a = Charset.forName(o.DEFAULT_PARAMS_ENCODING);

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f5439b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f5440c;

    public interface a extends h<Boolean> {
    }

    public interface b extends h<Double> {
    }

    public interface c {
        int a();
    }

    public interface d {
        boolean a(int i);
    }

    public interface e extends h<Float> {
    }

    public interface f extends h<Integer> {
    }

    public interface g extends h<Long> {
    }

    public interface h<E> extends List<E>, RandomAccess {
        void f();

        h<E> i(int i);

        boolean m();
    }

    static {
        byte[] bArr = new byte[0];
        f5440c = bArr;
        ByteBuffer.wrap(bArr);
        byte[] bArr2 = f5440c;
        k.i(bArr2, 0, bArr2.length);
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
        return ((i1) obj).toBuilder().mergeFrom((i1) obj2).buildPartial();
    }

    public static int g(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static String h(byte[] bArr) {
        return new String(bArr, f5438a);
    }
}
