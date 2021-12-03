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
    public static final c f3822k = new c();
    public r a;
    public Executor b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public b f3823d;

    /* renamed from: e  reason: collision with root package name */
    public String f3824e;

    /* renamed from: f  reason: collision with root package name */
    public Object[][] f3825f = ((Object[][]) Array.newInstance(Object.class, 0, 2));

    /* renamed from: g  reason: collision with root package name */
    public List<j.a> f3826g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public Boolean f3827h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f3828i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f3829j;

    public static final class a<T> {
        public final String a;

        public a(String str, T t) {
            this.a = str;
        }

        public static <T> a<T> a(String str) {
            b.z(str, "debugString");
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
        this.f3823d = cVar.f3823d;
        this.b = cVar.b;
        this.f3824e = cVar.f3824e;
        this.f3825f = cVar.f3825f;
        this.f3827h = cVar.f3827h;
        this.f3828i = cVar.f3828i;
        this.f3829j = cVar.f3829j;
        this.f3826g = cVar.f3826g;
    }

    public <T> T a(a<T> aVar) {
        b.z(aVar, "key");
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3825f;
            if (i2 >= objArr.length) {
                return null;
            }
            if (aVar.equals(objArr[i2][0])) {
                return (T) this.f3825f[i2][1];
            }
            i2++;
        }
    }

    public boolean b() {
        return Boolean.TRUE.equals(this.f3827h);
    }

    public c c(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3828i = Integer.valueOf(i2);
        return cVar;
    }

    public c d(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3829j = Integer.valueOf(i2);
        return cVar;
    }

    public <T> c e(a<T> aVar, T t) {
        b.z(aVar, "key");
        b.z(t, "value");
        c cVar = new c(this);
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3825f;
            if (i2 >= objArr.length) {
                i2 = -1;
                break;
            } else if (aVar.equals(objArr[i2][0])) {
                break;
            } else {
                i2++;
            }
        }
        int length = this.f3825f.length;
        int i3 = i2 == -1 ? 1 : 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = length + i3;
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, iArr);
        cVar.f3825f = objArr2;
        Object[][] objArr3 = this.f3825f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i2 == -1) {
            cVar.f3825f[this.f3825f.length] = new Object[]{aVar, t};
        } else {
            cVar.f3825f[i2] = new Object[]{aVar, t};
        }
        return cVar;
    }

    public c f(j.a aVar) {
        c cVar = new c(this);
        ArrayList arrayList = new ArrayList(this.f3826g.size() + 1);
        arrayList.addAll(this.f3826g);
        arrayList.add(aVar);
        cVar.f3826g = Collections.unmodifiableList(arrayList);
        return cVar;
    }

    public String toString() {
        k t1 = b.t1(this);
        t1.d("deadline", this.a);
        t1.d("authority", this.c);
        t1.d("callCredentials", this.f3823d);
        Executor executor = this.b;
        t1.d("executor", executor != null ? executor.getClass() : null);
        t1.d("compressorName", this.f3824e);
        t1.d("customOptions", Arrays.deepToString(this.f3825f));
        t1.c("waitForReady", b());
        t1.d("maxInboundMessageSize", this.f3828i);
        t1.d("maxOutboundMessageSize", this.f3829j);
        t1.d("streamTracerFactories", this.f3826g);
        return t1.toString();
    }
}
