package e.m.a;

import e.p.g;
import java.util.ArrayList;

public abstract class l0 {
    public ArrayList<a> a = new ArrayList<>();
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1635d;

    /* renamed from: e  reason: collision with root package name */
    public int f1636e;

    /* renamed from: f  reason: collision with root package name */
    public int f1637f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1638g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1639h = true;

    /* renamed from: i  reason: collision with root package name */
    public String f1640i;

    /* renamed from: j  reason: collision with root package name */
    public int f1641j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1642k;

    /* renamed from: l  reason: collision with root package name */
    public int f1643l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;

    public static final class a {
        public int a;
        public l b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1644d;

        /* renamed from: e  reason: collision with root package name */
        public int f1645e;

        /* renamed from: f  reason: collision with root package name */
        public int f1646f;

        /* renamed from: g  reason: collision with root package name */
        public g.b f1647g;

        /* renamed from: h  reason: collision with root package name */
        public g.b f1648h;

        public a() {
        }

        public a(int i2, l lVar) {
            this.a = i2;
            this.b = lVar;
            g.b bVar = g.b.RESUMED;
            this.f1647g = bVar;
            this.f1648h = bVar;
        }

        public a(int i2, l lVar, g.b bVar) {
            this.a = i2;
            this.b = lVar;
            this.f1647g = lVar.O;
            this.f1648h = bVar;
        }
    }

    public l0(y yVar, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.f1644d = this.c;
        aVar.f1645e = this.f1635d;
        aVar.f1646f = this.f1636e;
    }

    public abstract int c();

    public abstract void d();

    public abstract void e(int i2, l lVar, String str, int i3);

    public l0 f(int i2, l lVar, String str) {
        if (i2 != 0) {
            e(i2, lVar, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
}
