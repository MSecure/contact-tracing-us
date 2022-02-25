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
    public static final c f3499k = new c();
    public r a;
    public Executor b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public b f3500d;

    /* renamed from: e  reason: collision with root package name */
    public String f3501e;

    /* renamed from: f  reason: collision with root package name */
    public Object[][] f3502f = ((Object[][]) Array.newInstance(Object.class, 0, 2));

    /* renamed from: g  reason: collision with root package name */
    public List<j.a> f3503g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public Boolean f3504h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f3505i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f3506j;

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
        this.f3500d = cVar.f3500d;
        this.b = cVar.b;
        this.f3501e = cVar.f3501e;
        this.f3502f = cVar.f3502f;
        this.f3504h = cVar.f3504h;
        this.f3505i = cVar.f3505i;
        this.f3506j = cVar.f3506j;
        this.f3503g = cVar.f3503g;
    }

    public <T> T a(a<T> aVar) {
        b.A(aVar, "key");
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3502f;
            if (i2 >= objArr.length) {
                return null;
            }
            if (aVar.equals(objArr[i2][0])) {
                return (T) this.f3502f[i2][1];
            }
            i2++;
        }
    }

    public boolean b() {
        return Boolean.TRUE.equals(this.f3504h);
    }

    public c c(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3505i = Integer.valueOf(i2);
        return cVar;
    }

    public c d(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3506j = Integer.valueOf(i2);
        return cVar;
    }

    public <T> c e(a<T> aVar, T t) {
        b.A(aVar, "key");
        b.A(t, "value");
        c cVar = new c(this);
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3502f;
            if (i2 >= objArr.length) {
                i2 = -1;
                break;
            } else if (aVar.equals(objArr[i2][0])) {
                break;
            } else {
                i2++;
            }
        }
        int length = this.f3502f.length;
        int i3 = i2 == -1 ? 1 : 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = length + i3;
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, iArr);
        cVar.f3502f = objArr2;
        Object[][] objArr3 = this.f3502f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i2 == -1) {
            cVar.f3502f[this.f3502f.length] = new Object[]{aVar, t};
        } else {
            cVar.f3502f[i2] = new Object[]{aVar, t};
        }
        return cVar;
    }

    public c f(j.a aVar) {
        c cVar = new c(this);
        ArrayList arrayList = new ArrayList(this.f3503g.size() + 1);
        arrayList.addAll(this.f3503g);
        arrayList.add(aVar);
        cVar.f3503g = Collections.unmodifiableList(arrayList);
        return cVar;
    }

    public String toString() {
        k U1 = b.U1(this);
        U1.d("deadline", this.a);
        U1.d("authority", this.c);
        U1.d("callCredentials", this.f3500d);
        Executor executor = this.b;
        U1.d("executor", executor != null ? executor.getClass() : null);
        U1.d("compressorName", this.f3501e);
        U1.d("customOptions", Arrays.deepToString(this.f3502f));
        U1.c("waitForReady", b());
        U1.d("maxInboundMessageSize", this.f3505i);
        U1.d("maxOutboundMessageSize", this.f3506j);
        U1.d("streamTracerFactories", this.f3503g);
        return U1.toString();
    }
}
