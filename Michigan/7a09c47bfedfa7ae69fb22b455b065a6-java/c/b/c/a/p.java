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
    public static final Charset f5213d = Charset.forName(o.DEFAULT_PARAMS_ENCODING);

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentMap<String, List<a<P>>> f5214a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public a<P> f5215b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<P> f5216c;

    public static final class a<P> {

        /* renamed from: a  reason: collision with root package name */
        public final P f5217a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f5218b;

        /* renamed from: c  reason: collision with root package name */
        public final w0 f5219c;

        /* renamed from: d  reason: collision with root package name */
        public final f1 f5220d;

        /* renamed from: e  reason: collision with root package name */
        public final int f5221e;

        public a(P p, byte[] bArr, w0 w0Var, f1 f1Var, int i) {
            this.f5217a = p;
            this.f5218b = Arrays.copyOf(bArr, bArr.length);
            this.f5219c = w0Var;
            this.f5220d = f1Var;
            this.f5221e = i;
        }

        public final byte[] a() {
            byte[] bArr = this.f5218b;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }
    }

    public p(Class<P> cls) {
        this.f5216c = cls;
    }

    public List<a<P>> a(byte[] bArr) {
        List<a<P>> list = this.f5214a.get(new String(bArr, f5213d));
        return list != null ? list : Collections.emptyList();
    }

    public List<a<P>> b() {
        return a(b.f4775a);
    }
}
