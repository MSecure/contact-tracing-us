package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.j;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public final class c {

    /* renamed from: k  reason: collision with root package name */
    public static final c f3507k = new c();
    public r a;
    public Executor b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public b f3508d;

    /* renamed from: e  reason: collision with root package name */
    public String f3509e;

    /* renamed from: f  reason: collision with root package name */
    public Object[][] f3510f = ((Object[][]) Array.newInstance(Object.class, 0, 2));

    /* renamed from: g  reason: collision with root package name */
    public List<j.a> f3511g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public Boolean f3512h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f3513i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f3514j;

    public static final class a<T> {
        public final String a;

        public a(String str, T t) {
            this.a = str;
        }

        public static <T> a<T> a(String str) {
            b.A(str, "debugString");
            return new a<>(str, null);
        }

        public String toString() {
            return this.a;
        }
    }

    public c() {
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.c = cVar.c;
        this.f3508d = cVar.f3508d;
        this.b = cVar.b;
        this.f3509e = cVar.f3509e;
        this.f3510f = cVar.f3510f;
        this.f3512h = cVar.f3512h;
        this.f3513i = cVar.f3513i;
        this.f3514j = cVar.f3514j;
        this.f3511g = cVar.f3511g;
    }

    public <T> T a(a<T> aVar) {
        b.A(aVar, "key");
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3510f;
            if (i2 >= objArr.length) {
                return null;
            }
            if (aVar.equals(objArr[i2][0])) {
                return (T) this.f3510f[i2][1];
            }
            i2++;
        }
    }

    public boolean b() {
        return Boolean.TRUE.equals(this.f3512h);
    }

    public c c(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3513i = Integer.valueOf(i2);
        return cVar;
    }

    public c d(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3514j = Integer.valueOf(i2);
        return cVar;
    }

    public <T> c e(a<T> aVar, T t) {
        b.A(aVar, "key");
        b.A(t, "value");
        c cVar = new c(this);
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3510f;
            if (i2 >= objArr.length) {
                i2 = -1;
                break;
            } else if (aVar.equals(objArr[i2][0])) {
                break;
            } else {
                i2++;
            }
        }
        int length = this.f3510f.length;
        int i3 = i2 == -1 ? 1 : 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = length + i3;
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, iArr);
        cVar.f3510f = objArr2;
        Object[][] objArr3 = this.f3510f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i2 == -1) {
            cVar.f3510f[this.f3510f.length] = new Object[]{aVar, t};
        } else {
            cVar.f3510f[i2] = new Object[]{aVar, t};
        }
        return cVar;
    }

    public c f(j.a aVar) {
        c cVar = new c(this);
        ArrayList arrayList = new ArrayList(this.f3511g.size() + 1);
        arrayList.addAll(this.f3511g);
        arrayList.add(aVar);
        cVar.f3511g = Collections.unmodifiableList(arrayList);
        return cVar;
    }

    public String toString() {
        k U1 = b.U1(this);
        U1.d("deadline", this.a);
        U1.d("authority", this.c);
        U1.d("callCredentials", this.f3508d);
        Executor executor = this.b;
        U1.d("executor", executor != null ? executor.getClass() : null);
        U1.d("compressorName", this.f3509e);
        U1.d("customOptions", Arrays.deepToString(this.f3510f));
        U1.c("waitForReady", b());
        U1.d("maxInboundMessageSize", this.f3513i);
        U1.d("maxOutboundMessageSize", this.f3514j);
        U1.d("streamTracerFactories", this.f3511g);
        return U1.toString();
    }
}
