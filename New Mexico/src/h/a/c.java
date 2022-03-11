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
/* loaded from: classes.dex */
public final class c {

    /* renamed from: k */
    public static final c f4077k = new c();
    public r a;
    public Executor b;
    public String c;

    /* renamed from: d */
    public b f4078d;

    /* renamed from: e */
    public String f4079e;

    /* renamed from: f */
    public Object[][] f4080f;

    /* renamed from: g */
    public List<j.a> f4081g;

    /* renamed from: h */
    public Boolean f4082h;

    /* renamed from: i */
    public Integer f4083i;

    /* renamed from: j */
    public Integer f4084j;

    /* loaded from: classes.dex */
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
        this.f4080f = (Object[][]) Array.newInstance(Object.class, 0, 2);
        this.f4081g = Collections.emptyList();
    }

    public c(c cVar) {
        this.f4080f = (Object[][]) Array.newInstance(Object.class, 0, 2);
        this.f4081g = Collections.emptyList();
        this.a = cVar.a;
        this.c = cVar.c;
        this.f4078d = cVar.f4078d;
        this.b = cVar.b;
        this.f4079e = cVar.f4079e;
        this.f4080f = cVar.f4080f;
        this.f4082h = cVar.f4082h;
        this.f4083i = cVar.f4083i;
        this.f4084j = cVar.f4084j;
        this.f4081g = cVar.f4081g;
    }

    public <T> T a(a<T> aVar) {
        b.A(aVar, "key");
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f4080f;
            if (i2 >= objArr.length) {
                return null;
            }
            if (aVar.equals(objArr[i2][0])) {
                return (T) this.f4080f[i2][1];
            }
            i2++;
        }
    }

    public boolean b() {
        return Boolean.TRUE.equals(this.f4082h);
    }

    public c c(int i2) {
        b.r(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f4083i = Integer.valueOf(i2);
        return cVar;
    }

    public c d(int i2) {
        b.r(i2 >= 0, "invalid maxsize %s", i2);
        c cVar = new c(this);
        cVar.f4084j = Integer.valueOf(i2);
        return cVar;
    }

    public <T> c e(a<T> aVar, T t) {
        b.A(aVar, "key");
        b.A(t, "value");
        c cVar = new c(this);
        int i2 = 0;
        while (true) {
            Object[][] objArr = this.f4080f;
            if (i2 >= objArr.length) {
                i2 = -1;
                break;
            } else if (aVar.equals(objArr[i2][0])) {
                break;
            } else {
                i2++;
            }
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, this.f4080f.length + (i2 == -1 ? 1 : 0), 2);
        cVar.f4080f = objArr2;
        Object[][] objArr3 = this.f4080f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i2 == -1) {
            Object[][] objArr4 = cVar.f4080f;
            int length = this.f4080f.length;
            Object[] objArr5 = new Object[2];
            objArr5[0] = aVar;
            objArr5[1] = t;
            objArr4[length] = objArr5;
        } else {
            Object[][] objArr6 = cVar.f4080f;
            Object[] objArr7 = new Object[2];
            objArr7[0] = aVar;
            objArr7[1] = t;
            objArr6[i2] = objArr7;
        }
        return cVar;
    }

    public c f(j.a aVar) {
        c cVar = new c(this);
        ArrayList arrayList = new ArrayList(this.f4081g.size() + 1);
        arrayList.addAll(this.f4081g);
        arrayList.add(aVar);
        cVar.f4081g = Collections.unmodifiableList(arrayList);
        return cVar;
    }

    public String toString() {
        k u1 = b.u1(this);
        u1.d("deadline", this.a);
        u1.d("authority", this.c);
        u1.d("callCredentials", this.f4078d);
        Executor executor = this.b;
        u1.d("executor", executor != null ? executor.getClass() : null);
        u1.d("compressorName", this.f4079e);
        u1.d("customOptions", Arrays.deepToString(this.f4080f));
        u1.c("waitForReady", b());
        u1.d("maxInboundMessageSize", this.f4083i);
        u1.d("maxOutboundMessageSize", this.f4084j);
        u1.d("streamTracerFactories", this.f4081g);
        return u1.toString();
    }
}
