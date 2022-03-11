package e.o.a;

import e.r.h;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class m0 {
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1827d;

    /* renamed from: e  reason: collision with root package name */
    public int f1828e;

    /* renamed from: f  reason: collision with root package name */
    public int f1829f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1830g;

    /* renamed from: i  reason: collision with root package name */
    public String f1832i;

    /* renamed from: j  reason: collision with root package name */
    public int f1833j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1834k;

    /* renamed from: l  reason: collision with root package name */
    public int f1835l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public ArrayList<a> a = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f1831h = true;
    public boolean p = false;

    /* loaded from: classes.dex */
    public static final class a {
        public int a;
        public m b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1836d;

        /* renamed from: e  reason: collision with root package name */
        public int f1837e;

        /* renamed from: f  reason: collision with root package name */
        public int f1838f;

        /* renamed from: g  reason: collision with root package name */
        public h.b f1839g;

        /* renamed from: h  reason: collision with root package name */
        public h.b f1840h;

        public a() {
        }

        public a(int i2, m mVar) {
            this.a = i2;
            this.b = mVar;
            h.b bVar = h.b.RESUMED;
            this.f1839g = bVar;
            this.f1840h = bVar;
        }
    }

    public m0(a0 a0Var, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.f1836d = this.c;
        aVar.f1837e = this.f1827d;
        aVar.f1838f = this.f1828e;
    }

    public m0 c(String str) {
        if (this.f1831h) {
            this.f1830g = true;
            this.f1832i = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract int d();

    public abstract int e();

    public abstract void f(int i2, m mVar, String str, int i3);

    public m0 g(int i2, m mVar, String str) {
        if (i2 != 0) {
            f(i2, mVar, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
}
