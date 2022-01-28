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
    public static final c f3757k = new c();
    public r a;
    public Executor b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public b f3758d;

    /* renamed from: e  reason: collision with root package name */
    public String f3759e;

    /* renamed from: f  reason: collision with root package name */
    public Object[][] f3760f = ((Object[][]) Array.newInstance(Object.class, 0, 2));

    /* renamed from: g  reason: collision with root package name */
    public List<j.a> f3761g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    public Boolean f3762h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f3763i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f3764j;

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
        this.f3758d = cVar.f3758d;
        this.b = cVar.b;
        this.f3759e = cVar.f3759e;
        this.f3760f = cVar.f3760f;
        this.f3762h = cVar.f3762h;
        this.f3763i = cVar.f3763i;
        this.f3764j = cVar.f3764j;
        this.f3761g = cVar.f3761g;
    }

    public <T> T a(a<T> aVar) {
        b.z(aVar, "key");
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3760f;
            if (i2 >= objArr.length) {
                return null;
            }
            if (aVar.equals(objArr[i2][0])) {
                return (T) this.f3760f[i2][1];
            }
            i2++;
        }
    }

    public boolean b() {
        return Boolean.TRUE.equals(this.f3762h);
    }

    public c c(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3763i = Integer.valueOf(i2);
        return cVar;
    }

    public c d(int i2) {
        b.q(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f3764j = Integer.valueOf(i2);
        return cVar;
    }

    public <T> c e(a<T> aVar, T t) {
        b.z(aVar, "key");
        b.z(t, "value");
        c cVar = new c(this);
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f3760f;
            if (i2 >= objArr.length) {
                i2 = -1;
                break;
            } else if (aVar.equals(objArr[i2][0])) {
                break;
            } else {
                i2++;
            }
        }
        int length = this.f3760f.length;
        int i3 = i2 == -1 ? 1 : 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = length + i3;
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, iArr);
        cVar.f3760f = objArr2;
        Object[][] objArr3 = this.f3760f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i2 == -1) {
            cVar.f3760f[this.f3760f.length] = new Object[]{aVar, t};
        } else {
            cVar.f3760f[i2] = new Object[]{aVar, t};
        }
        return cVar;
    }

    public c f(j.a aVar) {
        c cVar = new c(this);
        ArrayList arrayList = new ArrayList(this.f3761g.size() + 1);
        arrayList.addAll(this.f3761g);
        arrayList.add(aVar);
        cVar.f3761g = Collections.unmodifiableList(arrayList);
        return cVar;
    }

    public String toString() {
        k q1 = b.q1(this);
        q1.d("deadline", this.a);
        q1.d("authority", this.c);
        q1.d("callCredentials", this.f3758d);
        Executor executor = this.b;
        q1.d("executor", executor != null ? executor.getClass() : null);
        q1.d("compressorName", this.f3759e);
        q1.d("customOptions", Arrays.deepToString(this.f3760f));
        q1.c("waitForReady", b());
        q1.d("maxInboundMessageSize", this.f3763i);
        q1.d("maxOutboundMessageSize", this.f3764j);
        q1.d("streamTracerFactories", this.f3761g);
        return q1.toString();
    }
}
