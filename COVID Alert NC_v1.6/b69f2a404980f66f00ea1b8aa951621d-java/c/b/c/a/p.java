package c.b.c.a;

import c.a.b.o;
import c.b.c.a.i0.f1;
import c.b.c.a.i0.w0;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class p<P> {

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f3812d = Charset.forName(o.DEFAULT_PARAMS_ENCODING);

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentMap<String, List<a<P>>> f3813a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public a<P> f3814b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<P> f3815c;

    public static final class a<P> {

        /* renamed from: a  reason: collision with root package name */
        public final P f3816a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f3817b;

        /* renamed from: c  reason: collision with root package name */
        public final w0 f3818c;

        /* renamed from: d  reason: collision with root package name */
        public final f1 f3819d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3820e;

        public a(P p, byte[] bArr, w0 w0Var, f1 f1Var, int i) {
            this.f3816a = p;
            this.f3817b = Arrays.copyOf(bArr, bArr.length);
            this.f3818c = w0Var;
            this.f3819d = f1Var;
            this.f3820e = i;
        }

        public final byte[] a() {
            byte[] bArr = this.f3817b;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }
    }

    public p(Class<P> cls) {
        this.f3815c = cls;
    }

    public List<a<P>> a(byte[] bArr) {
        List<a<P>> list = this.f3813a.get(new String(bArr, f3812d));
        return list != null ? list : Collections.emptyList();
    }

    public List<a<P>> b() {
        return a(b.f3425a);
    }
}
