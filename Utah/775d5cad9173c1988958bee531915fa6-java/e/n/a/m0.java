package e.n.a;

import e.q.h;
import java.util.ArrayList;

public abstract class m0 {
    public ArrayList<a> a = new ArrayList<>();
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1742d;

    /* renamed from: e  reason: collision with root package name */
    public int f1743e;

    /* renamed from: f  reason: collision with root package name */
    public int f1744f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1745g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1746h = true;

    /* renamed from: i  reason: collision with root package name */
    public String f1747i;

    /* renamed from: j  reason: collision with root package name */
    public int f1748j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1749k;

    /* renamed from: l  reason: collision with root package name */
    public int f1750l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;

    public static final class a {
        public int a;
        public m b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1751d;

        /* renamed from: e  reason: collision with root package name */
        public int f1752e;

        /* renamed from: f  reason: collision with root package name */
        public int f1753f;

        /* renamed from: g  reason: collision with root package name */
        public h.b f1754g;

        /* renamed from: h  reason: collision with root package name */
        public h.b f1755h;

        public a() {
        }

        public a(int i2, m mVar) {
            this.a = i2;
            this.b = mVar;
            h.b bVar = h.b.RESUMED;
            this.f1754g = bVar;
            this.f1755h = bVar;
        }
    }

    public m0(a0 a0Var, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.f1751d = this.c;
        aVar.f1752e = this.f1742d;
        aVar.f1753f = this.f1743e;
    }

    public m0 c(String str) {
        if (this.f1746h) {
            this.f1745g = true;
            this.f1747i = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract int d();

    public abstract void e(int i2, m mVar, String str, int i3);

    public m0 f(int i2, m mVar, String str) {
        if (i2 != 0) {
            e(i2, mVar, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
}
