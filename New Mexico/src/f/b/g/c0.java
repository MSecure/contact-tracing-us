package f.b.g;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class c0 {
    public static final Charset a = Charset.forName("UTF-8");
    public static final byte[] b;

    /* loaded from: classes.dex */
    public interface a extends i<Boolean> {
    }

    /* loaded from: classes.dex */
    public interface b extends i<Double> {
    }

    /* loaded from: classes.dex */
    public interface c {
        int getNumber();
    }

    /* loaded from: classes.dex */
    public interface d<T extends c> {
        T findValueByNumber(int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean isInRange(int i2);
    }

    /* loaded from: classes.dex */
    public interface f extends i<Float> {
    }

    /* loaded from: classes.dex */
    public interface g extends i<Integer> {
    }

    /* loaded from: classes.dex */
    public interface h extends i<Long> {
    }

    /* loaded from: classes.dex */
    public interface i<E> extends List<E>, RandomAccess {
        void b();

        i<E> d(int i2);

        boolean g();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        k.h(bArr, 0, 0, false);
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static Object c(Object obj, Object obj2) {
        return ((t0) obj).toBuilder().mergeFrom((t0) obj2).buildPartial();
    }
}
