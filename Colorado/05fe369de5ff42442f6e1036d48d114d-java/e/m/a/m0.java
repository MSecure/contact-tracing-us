package e.m.a;

import e.p.h;
import java.util.ArrayList;

public abstract class m0 {
    public ArrayList<a> a = new ArrayList<>();
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1469d;

    /* renamed from: e  reason: collision with root package name */
    public int f1470e;

    /* renamed from: f  reason: collision with root package name */
    public int f1471f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1472g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1473h = true;

    /* renamed from: i  reason: collision with root package name */
    public String f1474i;

    /* renamed from: j  reason: collision with root package name */
    public int f1475j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1476k;

    /* renamed from: l  reason: collision with root package name */
    public int f1477l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;

    public static final class a {
        public int a;
        public m b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1478d;

        /* renamed from: e  reason: collision with root package name */
        public int f1479e;

        /* renamed from: f  reason: collision with root package name */
        public int f1480f;

        /* renamed from: g  reason: collision with root package name */
        public h.b f1481g;

        /* renamed from: h  reason: collision with root package name */
        public h.b f1482h;

        public a() {
        }

        public a(int i2, m mVar) {
            this.a = i2;
            this.b = mVar;
            h.b bVar = h.b.RESUMED;
            this.f1481g = bVar;
            this.f1482h = bVar;
        }
    }

    public m0(a0 a0Var, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.f1478d = this.c;
        aVar.f1479e = this.f1469d;
        aVar.f1480f = this.f1470e;
    }

    public m0 c(String str) {
        if (this.f1473h) {
            this.f1472g = true;
            this.f1474i = str;
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
