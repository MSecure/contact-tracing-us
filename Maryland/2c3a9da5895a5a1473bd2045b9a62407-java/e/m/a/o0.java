package e.m.a;

import e.p.g;
import java.util.ArrayList;

public abstract class o0 {
    public ArrayList<a> a = new ArrayList<>();
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1663d;

    /* renamed from: e  reason: collision with root package name */
    public int f1664e;

    /* renamed from: f  reason: collision with root package name */
    public int f1665f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1666g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1667h = true;

    /* renamed from: i  reason: collision with root package name */
    public String f1668i;

    /* renamed from: j  reason: collision with root package name */
    public int f1669j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1670k;

    /* renamed from: l  reason: collision with root package name */
    public int f1671l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;

    public static final class a {
        public int a;
        public l b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1672d;

        /* renamed from: e  reason: collision with root package name */
        public int f1673e;

        /* renamed from: f  reason: collision with root package name */
        public int f1674f;

        /* renamed from: g  reason: collision with root package name */
        public g.b f1675g;

        /* renamed from: h  reason: collision with root package name */
        public g.b f1676h;

        public a() {
        }

        public a(int i2, l lVar) {
            this.a = i2;
            this.b = lVar;
            g.b bVar = g.b.RESUMED;
            this.f1675g = bVar;
            this.f1676h = bVar;
        }

        public a(int i2, l lVar, g.b bVar) {
            this.a = i2;
            this.b = lVar;
            this.f1675g = lVar.O;
            this.f1676h = bVar;
        }
    }

    public o0(b0 b0Var, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.f1672d = this.c;
        aVar.f1673e = this.f1663d;
        aVar.f1674f = this.f1664e;
    }

    public abstract int c();

    public abstract void d();

    public abstract void e(int i2, l lVar, String str, int i3);

    public o0 f(int i2, l lVar, String str) {
        if (i2 != 0) {
            e(i2, lVar, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
}
