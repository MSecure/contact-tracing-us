package h.a;

import f.b.b.c.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import java.util.Objects;

public final class n0 {
    public static final d<String> c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final f.b.b.c.a f3940d;
    public Object[] a;
    public int b;

    public class a {
    }

    public class b implements d<String> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.n0.d
        public String a(String str) {
            return str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.a.n0.d
        public String b(String str) {
            return str;
        }
    }

    public static class c<T> extends f<T> {

        /* renamed from: f  reason: collision with root package name */
        public final d<T> f3941f;

        public c(String str, boolean z, d dVar, a aVar) {
            super(str, z, dVar, null);
            f.b.a.c.b.o.b.t(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            f.b.a.c.b.o.b.A(dVar, "marshaller");
            this.f3941f = dVar;
        }

        @Override // h.a.n0.f
        public T c(byte[] bArr) {
            return this.f3941f.b(new String(bArr, f.b.b.a.d.a));
        }

        @Override // h.a.n0.f
        public byte[] d(T t) {
            return this.f3941f.a(t).getBytes(f.b.b.a.d.a);
        }
    }

    public interface d<T> {
        String a(T t);

        T b(String str);
    }

    public interface e<T> {
        InputStream a(T t);
    }

    public static abstract class f<T> {

        /* renamed from: e  reason: collision with root package name */
        public static final BitSet f3942e;
        public final String a;
        public final String b;
        public final byte[] c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f3943d;

        static {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
                bitSet.set(c2);
            }
            for (char c3 = 'a'; c3 <= 'z'; c3 = (char) (c3 + 1)) {
                bitSet.set(c3);
            }
            f3942e = bitSet;
        }

        public f(String str, boolean z, Object obj, a aVar) {
            f.b.a.c.b.o.b.A(str, "name");
            this.a = str;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            f.b.a.c.b.o.b.A(lowerCase, "name");
            f.b.a.c.b.o.b.o(!lowerCase.isEmpty(), "token must have at least 1 tchar");
            for (int i2 = 0; i2 < lowerCase.length(); i2++) {
                char charAt = lowerCase.charAt(i2);
                if (!(z && charAt == ':' && i2 == 0) && !f3942e.get(charAt)) {
                    throw new IllegalArgumentException(f.b.a.c.b.o.b.n1("Invalid character '%s' in key name '%s'", Character.valueOf(charAt), lowerCase));
                }
            }
            this.b = lowerCase;
            this.c = lowerCase.getBytes(f.b.b.a.d.a);
            this.f3943d = obj;
        }

        public static <T> f<T> a(String str, d<T> dVar) {
            return new c(str, false, dVar, null);
        }

        public static <T> f<T> b(String str, boolean z, i<T> iVar) {
            return new h(str, z, iVar, null);
        }

        public abstract T c(byte[] bArr);

        public abstract byte[] d(T t);

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.b.equals(((f) obj).b);
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return f.a.a.a.a.e(f.a.a.a.a.h("Key{name='"), this.b, "'}");
        }
    }

    public static final class g<T> {
        public final e<T> a;
        public final T b;
        public volatile byte[] c;

        public byte[] a() {
            if (this.c == null) {
                synchronized (this) {
                    if (this.c == null) {
                        InputStream a2 = this.a.a(this.b);
                        d<String> dVar = n0.c;
                        try {
                            this.c = f.b.b.c.b.b(a2);
                        } catch (IOException e2) {
                            throw new RuntimeException("failure reading serialized stream", e2);
                        }
                    }
                }
            }
            return this.c;
        }
    }

    public static final class h<T> extends f<T> {

        /* renamed from: f  reason: collision with root package name */
        public final i<T> f3944f;

        public h(String str, boolean z, i iVar, a aVar) {
            super(str, z, iVar, null);
            f.b.a.c.b.o.b.t(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            f.b.a.c.b.o.b.A(iVar, "marshaller");
            this.f3944f = iVar;
        }

        @Override // h.a.n0.f
        public T c(byte[] bArr) {
            return this.f3944f.b(bArr);
        }

        @Override // h.a.n0.f
        public byte[] d(T t) {
            return this.f3944f.a(t);
        }
    }

    public interface i<T> {
        byte[] a(T t);

        T b(byte[] bArr);
    }

    static {
        a.e eVar = (a.e) f.b.b.c.a.a;
        Character ch = eVar.f2906e;
        f.b.b.c.a aVar = eVar;
        if (ch != null) {
            aVar = eVar.h(eVar.f2905d, null);
        }
        f3940d = aVar;
    }

    public n0() {
    }

    public n0(byte[]... bArr) {
        this.b = bArr.length / 2;
        this.a = bArr;
    }

    public final int a() {
        Object[] objArr = this.a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public <T> void b(f<T> fVar) {
        if (!e()) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.b;
                if (i2 < i4) {
                    if (!Arrays.equals(fVar.c, g(i2))) {
                        this.a[i3 * 2] = g(i2);
                        j(i3, i(i2));
                        i3++;
                    }
                    i2++;
                } else {
                    Arrays.fill(this.a, i3 * 2, i4 * 2, (Object) null);
                    this.b = i3;
                    return;
                }
            }
        }
    }

    public final void c(int i2) {
        Object[] objArr = new Object[i2];
        if (!e()) {
            System.arraycopy(this.a, 0, objArr, 0, this.b * 2);
        }
        this.a = objArr;
    }

    public <T> T d(f<T> fVar) {
        int i2 = this.b;
        do {
            i2--;
            if (i2 < 0) {
                return null;
            }
        } while (!Arrays.equals(fVar.c, g(i2)));
        Object obj = this.a[(i2 * 2) + 1];
        if (obj instanceof byte[]) {
            return fVar.c((byte[]) obj);
        }
        g gVar = (g) obj;
        Objects.requireNonNull(gVar);
        return fVar.c(gVar.a());
    }

    public final boolean e() {
        return this.b == 0;
    }

    public void f(n0 n0Var) {
        if (!n0Var.e()) {
            int a2 = a() - (this.b * 2);
            if (e() || a2 < n0Var.b * 2) {
                c((this.b * 2) + (n0Var.b * 2));
            }
            System.arraycopy(n0Var.a, 0, this.a, this.b * 2, n0Var.b * 2);
            this.b += n0Var.b;
        }
    }

    public final byte[] g(int i2) {
        return (byte[]) this.a[i2 * 2];
    }

    public <T> void h(f<T> fVar, T t) {
        f.b.a.c.b.o.b.A(fVar, "key");
        f.b.a.c.b.o.b.A(t, "value");
        int i2 = this.b * 2;
        if (i2 == 0 || i2 == a()) {
            c(Math.max(this.b * 2 * 2, 8));
        }
        int i3 = this.b * 2;
        this.a[i3] = fVar.c;
        this.a[i3 + 1] = fVar.d(t);
        this.b++;
    }

    public final Object i(int i2) {
        return this.a[(i2 * 2) + 1];
    }

    public final void j(int i2, Object obj) {
        if (this.a instanceof byte[][]) {
            c(a());
        }
        this.a[(i2 * 2) + 1] = obj;
    }

    public final byte[] k(int i2) {
        Object obj = this.a[(i2 * 2) + 1];
        return obj instanceof byte[] ? (byte[]) obj : ((g) obj).a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i2 = 0; i2 < this.b; i2++) {
            if (i2 != 0) {
                sb.append(',');
            }
            byte[] g2 = g(i2);
            Charset charset = f.b.b.a.d.a;
            String str = new String(g2, charset);
            sb.append(str);
            sb.append('=');
            sb.append(str.endsWith("-bin") ? f3940d.c(k(i2)) : new String(k(i2), charset));
        }
        sb.append(')');
        return sb.toString();
    }
}
