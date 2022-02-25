package e.m.a;

import e.p.g;
import java.util.ArrayList;

public abstract class l0 {
    public ArrayList<a> a = new ArrayList<>();
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1636d;

    /* renamed from: e  reason: collision with root package name */
    public int f1637e;

    /* renamed from: f  reason: collision with root package name */
    public int f1638f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1639g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1640h = true;

    /* renamed from: i  reason: collision with root package name */
    public String f1641i;

    /* renamed from: j  reason: collision with root package name */
    public int f1642j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1643k;

    /* renamed from: l  reason: collision with root package name */
    public int f1644l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;

    public static final class a {
        public int a;
        public l b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1645d;

        /* renamed from: e  reason: collision with root package name */
        public int f1646e;

        /* renamed from: f  reason: collision with root package name */
        public int f1647f;

        /* renamed from: g  reason: collision with root package name */
        public g.b f1648g;

        /* renamed from: h  reason: collision with root package name */
        public g.b f1649h;

        public a() {
        }

        public a(int i2, l lVar) {
            this.a = i2;
            this.b = lVar;
            g.b bVar = g.b.RESUMED;
            this.f1648g = bVar;
            this.f1649h = bVar;
        }

        public a(int i2, l lVar, g.b bVar) {
            this.a = i2;
            this.b = lVar;
            this.f1648g = lVar.O;
            this.f1649h = bVar;
        }
    }

    public l0(y yVar, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.f1645d = this.c;
        aVar.f1646e = this.f1636d;
        aVar.f1647f = this.f1637e;
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
