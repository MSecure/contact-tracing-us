package h.a.j1;

import f.b.b.a.d;
import h.a.c1;
import h.a.e0;
import h.a.j1.a;
import h.a.n0;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public abstract class t0 extends a.c {
    public static final e0.a<Integer> v;
    public static final n0.f<Integer> w;
    public c1 r;
    public n0 s;
    public Charset t = d.b;
    public boolean u;

    /* loaded from: classes.dex */
    public class a implements e0.a<Integer> {
        @Override // h.a.n0.i
        public byte[] a(Object obj) {
            Integer num = (Integer) obj;
            throw new UnsupportedOperationException();
        }

        @Override // h.a.n0.i
        public Object b(byte[] bArr) {
            if (bArr.length >= 3) {
                int i2 = (bArr[1] - 48) * 10;
                return Integer.valueOf((bArr[2] - 48) + i2 + ((bArr[0] - 48) * 100));
            }
            StringBuilder h2 = f.a.a.a.a.h("Malformed status code ");
            h2.append(new String(bArr, e0.a));
            throw new NumberFormatException(h2.toString());
        }
    }

    static {
        a aVar = new a();
        v = aVar;
        w = e0.a(":status", aVar);
    }

    public t0(int i2, w2 w2Var, c3 c3Var) {
        super(i2, w2Var, c3Var);
    }

    public static Charset j(n0 n0Var) {
        String str = (String) n0Var.d(q0.f4290g);
        if (str != null) {
            String[] split = str.split("charset=", 2);
            try {
                return Charset.forName(split[split.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return d.b;
    }

    public final c1 k(n0 n0Var) {
        char charAt;
        Integer num = (Integer) n0Var.d(w);
        if (num == null) {
            return c1.m.g("Missing HTTP status code");
        }
        String str = (String) n0Var.d(q0.f4290g);
        boolean z = false;
        if (str != null && 16 <= str.length()) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("application/grpc") && (lowerCase.length() == 16 || (charAt = lowerCase.charAt(16)) == '+' || charAt == ';')) {
                z = true;
            }
        }
        if (z) {
            return null;
        }
        c1 f2 = q0.f(num.intValue());
        return f2.a("invalid content-type: " + str);
    }
}
