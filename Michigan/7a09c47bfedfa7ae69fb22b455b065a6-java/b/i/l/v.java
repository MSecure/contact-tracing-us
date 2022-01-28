package b.i.l;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public class v {

    /* renamed from: b  reason: collision with root package name */
    public static final v f1888b = (Build.VERSION.SDK_INT >= 29 ? new b() : new a()).a().f1889a.a().f1889a.b().f1889a.c();

    /* renamed from: a  reason: collision with root package name */
    public final h f1889a;

    public static class a extends c {

        /* renamed from: c  reason: collision with root package name */
        public static Field f1890c = null;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f1891d = false;

        /* renamed from: e  reason: collision with root package name */
        public static Constructor<WindowInsets> f1892e = null;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f1893f = false;

        /* renamed from: b  reason: collision with root package name */
        public WindowInsets f1894b;

        public a() {
            if (!f1891d) {
                try {
                    f1890c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f1891d = true;
            }
            Field field = f1890c;
            WindowInsets windowInsets = null;
            if (field != null) {
                try {
                    WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                    if (windowInsets2 != null) {
                        windowInsets = new WindowInsets(windowInsets2);
                        this.f1894b = windowInsets;
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f1893f) {
                try {
                    f1892e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f1893f = true;
            }
            Constructor<WindowInsets> constructor = f1892e;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            this.f1894b = windowInsets;
        }

        public a(v vVar) {
            this.f1894b = vVar.i();
        }

        @Override // b.i.l.v.c
        public v a() {
            return v.j(this.f1894b);
        }

        @Override // b.i.l.v.c
        public void c(b.i.f.b bVar) {
            WindowInsets windowInsets = this.f1894b;
            if (windowInsets != null) {
                this.f1894b = windowInsets.replaceSystemWindowInsets(bVar.f1745a, bVar.f1746b, bVar.f1747c, bVar.f1748d);
            }
        }
    }

    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsets.Builder f1895b;

        public b() {
            this.f1895b = new WindowInsets.Builder();
        }

        public b(v vVar) {
            WindowInsets.Builder builder;
            if (vVar.i() == null) {
                builder = new WindowInsets.Builder();
            }
            this.f1895b = builder;
        }

        @Override // b.i.l.v.c
        public v a() {
            return v.j(this.f1895b.build());
        }

        @Override // b.i.l.v.c
        public void b(b.i.f.b bVar) {
            this.f1895b.setStableInsets(Insets.of(bVar.f1745a, bVar.f1746b, bVar.f1747c, bVar.f1748d));
        }

        @Override // b.i.l.v.c
        public void c(b.i.f.b bVar) {
            this.f1895b.setSystemWindowInsets(Insets.of(bVar.f1745a, bVar.f1746b, bVar.f1747c, bVar.f1748d));
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final v f1896a = new v((v) null);

        public abstract v a();

        public void b(b.i.f.b bVar) {
        }

        public abstract void c(b.i.f.b bVar);
    }

    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsets f1897b;

        /* renamed from: c  reason: collision with root package name */
        public b.i.f.b f1898c = null;

        public d(v vVar, WindowInsets windowInsets) {
            super(vVar);
            this.f1897b = windowInsets;
        }

        @Override // b.i.l.v.h
        public final b.i.f.b g() {
            if (this.f1898c == null) {
                this.f1898c = b.i.f.b.a(this.f1897b.getSystemWindowInsetLeft(), this.f1897b.getSystemWindowInsetTop(), this.f1897b.getSystemWindowInsetRight(), this.f1897b.getSystemWindowInsetBottom());
            }
            return this.f1898c;
        }

        @Override // b.i.l.v.h
        public v h(int i, int i2, int i3, int i4) {
            v j = v.j(this.f1897b);
            c bVar = Build.VERSION.SDK_INT >= 29 ? new b(j) : new a(j);
            bVar.c(v.f(g(), i, i2, i3, i4));
            bVar.b(v.f(f(), i, i2, i3, i4));
            return bVar.a();
        }

        @Override // b.i.l.v.h
        public boolean j() {
            return this.f1897b.isRound();
        }
    }

    public static class e extends d {

        /* renamed from: d  reason: collision with root package name */
        public b.i.f.b f1899d = null;

        public e(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // b.i.l.v.h
        public v b() {
            return v.j(this.f1897b.consumeStableInsets());
        }

        @Override // b.i.l.v.h
        public v c() {
            return v.j(this.f1897b.consumeSystemWindowInsets());
        }

        @Override // b.i.l.v.h
        public final b.i.f.b f() {
            if (this.f1899d == null) {
                this.f1899d = b.i.f.b.a(this.f1897b.getStableInsetLeft(), this.f1897b.getStableInsetTop(), this.f1897b.getStableInsetRight(), this.f1897b.getStableInsetBottom());
            }
            return this.f1899d;
        }

        @Override // b.i.l.v.h
        public boolean i() {
            return this.f1897b.isConsumed();
        }
    }

    public static class f extends e {
        public f(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // b.i.l.v.h
        public v a() {
            return v.j(this.f1897b.consumeDisplayCutout());
        }

        @Override // b.i.l.v.h
        public c d() {
            DisplayCutout displayCutout = this.f1897b.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new c(displayCutout);
        }

        @Override // b.i.l.v.h
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            return Objects.equals(this.f1897b, ((f) obj).f1897b);
        }

        @Override // b.i.l.v.h
        public int hashCode() {
            return this.f1897b.hashCode();
        }
    }

    public static class g extends f {

        /* renamed from: e  reason: collision with root package name */
        public b.i.f.b f1900e = null;

        public g(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // b.i.l.v.h
        public b.i.f.b e() {
            if (this.f1900e == null) {
                Insets mandatorySystemGestureInsets = this.f1897b.getMandatorySystemGestureInsets();
                this.f1900e = b.i.f.b.a(mandatorySystemGestureInsets.left, mandatorySystemGestureInsets.top, mandatorySystemGestureInsets.right, mandatorySystemGestureInsets.bottom);
            }
            return this.f1900e;
        }

        @Override // b.i.l.v.h, b.i.l.v.d
        public v h(int i, int i2, int i3, int i4) {
            return v.j(this.f1897b.inset(i, i2, i3, i4));
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public final v f1901a;

        public h(v vVar) {
            this.f1901a = vVar;
        }

        public v a() {
            return this.f1901a;
        }

        public v b() {
            return this.f1901a;
        }

        public v c() {
            return this.f1901a;
        }

        public c d() {
            return null;
        }

        public b.i.f.b e() {
            return g();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return j() == hVar.j() && i() == hVar.i() && Objects.equals(g(), hVar.g()) && Objects.equals(f(), hVar.f()) && Objects.equals(d(), hVar.d());
        }

        public b.i.f.b f() {
            return b.i.f.b.f1744e;
        }

        public b.i.f.b g() {
            return b.i.f.b.f1744e;
        }

        public v h(int i, int i2, int i3, int i4) {
            return v.f1888b;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(j()), Boolean.valueOf(i()), g(), f(), d());
        }

        public boolean i() {
            return false;
        }

        public boolean j() {
            return false;
        }
    }

    public v(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        this.f1889a = i >= 29 ? new g(this, windowInsets) : i >= 28 ? new f(this, windowInsets) : new e(this, windowInsets);
    }

    public v(v vVar) {
        this.f1889a = new h(this);
    }

    public static b.i.f.b f(b.i.f.b bVar, int i, int i2, int i3, int i4) {
        int max = Math.max(0, bVar.f1745a - i);
        int max2 = Math.max(0, bVar.f1746b - i2);
        int max3 = Math.max(0, bVar.f1747c - i3);
        int max4 = Math.max(0, bVar.f1748d - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? bVar : b.i.f.b.a(max, max2, max3, max4);
    }

    public static v j(WindowInsets windowInsets) {
        if (windowInsets != null) {
            return new v(windowInsets);
        }
        throw null;
    }

    public int a() {
        return e().f1748d;
    }

    public int b() {
        return e().f1745a;
    }

    public int c() {
        return e().f1747c;
    }

    public int d() {
        return e().f1746b;
    }

    public b.i.f.b e() {
        return this.f1889a.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return Objects.equals(this.f1889a, ((v) obj).f1889a);
    }

    public boolean g() {
        return this.f1889a.i();
    }

    @Deprecated
    public v h(int i, int i2, int i3, int i4) {
        c bVar = Build.VERSION.SDK_INT >= 29 ? new b(this) : new a(this);
        bVar.c(b.i.f.b.a(i, i2, i3, i4));
        return bVar.a();
    }

    public int hashCode() {
        h hVar = this.f1889a;
        if (hVar == null) {
            return 0;
        }
        return hVar.hashCode();
    }

    public WindowInsets i() {
        h hVar = this.f1889a;
        if (hVar instanceof d) {
            return ((d) hVar).f1897b;
        }
        return null;
    }
}
