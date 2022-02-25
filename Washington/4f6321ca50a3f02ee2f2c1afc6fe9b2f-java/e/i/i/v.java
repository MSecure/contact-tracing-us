package e.i.i;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public class v {
    public static final v b = (Build.VERSION.SDK_INT >= 30 ? i.f1481j : j.b);
    public final j a;

    public static class a extends d {
        public static Field c = null;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f1472d = false;

        /* renamed from: e  reason: collision with root package name */
        public static Constructor<WindowInsets> f1473e = null;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f1474f = false;
        public WindowInsets b;

        public a() {
            if (!f1472d) {
                try {
                    c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f1472d = true;
            }
            Field field = c;
            WindowInsets windowInsets = null;
            if (field != null) {
                try {
                    WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                    if (windowInsets2 != null) {
                        windowInsets = new WindowInsets(windowInsets2);
                        this.b = windowInsets;
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f1474f) {
                try {
                    f1473e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f1474f = true;
            }
            Constructor<WindowInsets> constructor = f1473e;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            this.b = windowInsets;
        }

        public a(v vVar) {
            this.b = vVar.f();
        }

        @Override // e.i.i.v.d
        public v a() {
            return v.g(this.b);
        }

        @Override // e.i.i.v.d
        public void c(e.i.c.b bVar) {
            WindowInsets windowInsets = this.b;
            if (windowInsets != null) {
                this.b = windowInsets.replaceSystemWindowInsets(bVar.a, bVar.b, bVar.c, bVar.f1422d);
            }
        }
    }

    public static class b extends d {
        public final WindowInsets.Builder b;

        public b() {
            this.b = new WindowInsets.Builder();
        }

        public b(v vVar) {
            WindowInsets.Builder builder;
            if (vVar.f() == null) {
                builder = new WindowInsets.Builder();
            }
            this.b = builder;
        }

        @Override // e.i.i.v.d
        public v a() {
            return v.g(this.b.build());
        }

        @Override // e.i.i.v.d
        public void b(e.i.c.b bVar) {
            this.b.setStableInsets(bVar.b());
        }

        @Override // e.i.i.v.d
        public void c(e.i.c.b bVar) {
            this.b.setSystemWindowInsets(bVar.b());
        }
    }

    public static class c extends b {
        public c() {
        }

        public c(v vVar) {
            super(vVar);
        }
    }

    public static class d {
        public final v a = new v((v) null);

        public v a() {
            throw null;
        }

        public void b(e.i.c.b bVar) {
        }

        public void c(e.i.c.b bVar) {
            throw null;
        }
    }

    public static class e extends j {
        public final WindowInsets c;

        /* renamed from: d  reason: collision with root package name */
        public e.i.c.b f1475d = null;

        /* renamed from: e  reason: collision with root package name */
        public v f1476e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f1477f;

        /* renamed from: g  reason: collision with root package name */
        public int f1478g;

        public e(v vVar, WindowInsets windowInsets) {
            super(vVar);
            this.c = windowInsets;
        }

        @Override // e.i.i.v.j
        public final e.i.c.b g() {
            if (this.f1475d == null) {
                this.f1475d = e.i.c.b.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.f1475d;
        }

        @Override // e.i.i.v.j
        public v h(int i2, int i3, int i4, int i5) {
            v g2 = v.g(this.c);
            int i6 = Build.VERSION.SDK_INT;
            d cVar = i6 >= 30 ? new c(g2) : i6 >= 29 ? new b(g2) : new a(g2);
            cVar.c(v.e(g(), i2, i3, i4, i5));
            cVar.b(v.e(f(), i2, i3, i4, i5));
            return cVar.a();
        }

        @Override // e.i.i.v.j
        public boolean j() {
            return this.c.isRound();
        }

        @Override // e.i.i.v.j
        public void k(Rect rect, int i2) {
            this.f1477f = rect;
            this.f1478g = i2;
        }

        @Override // e.i.i.v.j
        public void l(v vVar) {
            this.f1476e = vVar;
        }
    }

    public static class f extends e {

        /* renamed from: h  reason: collision with root package name */
        public e.i.c.b f1479h = null;

        public f(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // e.i.i.v.j
        public v b() {
            return v.g(this.c.consumeStableInsets());
        }

        @Override // e.i.i.v.j
        public v c() {
            return v.g(this.c.consumeSystemWindowInsets());
        }

        @Override // e.i.i.v.j
        public final e.i.c.b f() {
            if (this.f1479h == null) {
                this.f1479h = e.i.c.b.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.f1479h;
        }

        @Override // e.i.i.v.j
        public boolean i() {
            return this.c.isConsumed();
        }
    }

    public static class g extends f {
        public g(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // e.i.i.v.j
        public v a() {
            return v.g(this.c.consumeDisplayCutout());
        }

        @Override // e.i.i.v.j
        public c d() {
            DisplayCutout displayCutout = this.c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new c(displayCutout);
        }

        @Override // e.i.i.v.j
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            return Objects.equals(this.c, ((g) obj).c);
        }

        @Override // e.i.i.v.j
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    public static class h extends g {

        /* renamed from: i  reason: collision with root package name */
        public e.i.c.b f1480i = null;

        public h(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // e.i.i.v.j
        public e.i.c.b e() {
            if (this.f1480i == null) {
                Insets mandatorySystemGestureInsets = this.c.getMandatorySystemGestureInsets();
                this.f1480i = e.i.c.b.a(mandatorySystemGestureInsets.left, mandatorySystemGestureInsets.top, mandatorySystemGestureInsets.right, mandatorySystemGestureInsets.bottom);
            }
            return this.f1480i;
        }

        @Override // e.i.i.v.e, e.i.i.v.j
        public v h(int i2, int i3, int i4, int i5) {
            return v.g(this.c.inset(i2, i3, i4, i5));
        }
    }

    public static class i extends h {

        /* renamed from: j  reason: collision with root package name */
        public static final v f1481j = v.g(WindowInsets.CONSUMED);

        public i(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }
    }

    public static class j {
        public static final v b;
        public final v a;

        static {
            int i2 = Build.VERSION.SDK_INT;
            b = (i2 >= 30 ? new c() : i2 >= 29 ? new b() : new a()).a().a.a().a.b().a.c();
        }

        public j(v vVar) {
            this.a = vVar;
        }

        public v a() {
            return this.a;
        }

        public v b() {
            return this.a;
        }

        public v c() {
            return this.a;
        }

        public c d() {
            return null;
        }

        public e.i.c.b e() {
            return g();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (j() != jVar.j() || i() != jVar.i() || !Objects.equals(g(), jVar.g()) || !Objects.equals(f(), jVar.f()) || !Objects.equals(d(), jVar.d())) {
                return false;
            }
            return true;
        }

        public e.i.c.b f() {
            return e.i.c.b.f1421e;
        }

        public e.i.c.b g() {
            return e.i.c.b.f1421e;
        }

        public v h(int i2, int i3, int i4, int i5) {
            return b;
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

        public void k(Rect rect, int i2) {
        }

        public void l(v vVar) {
        }
    }

    public v(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.a = i2 >= 30 ? new i(this, windowInsets) : i2 >= 29 ? new h(this, windowInsets) : i2 >= 28 ? new g(this, windowInsets) : new f(this, windowInsets);
    }

    public v(v vVar) {
        this.a = new j(this);
    }

    public static e.i.c.b e(e.i.c.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.a - i2);
        int max2 = Math.max(0, bVar.b - i3);
        int max3 = Math.max(0, bVar.c - i4);
        int max4 = Math.max(0, bVar.f1422d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : e.i.c.b.a(max, max2, max3, max4);
    }

    public static v g(WindowInsets windowInsets) {
        return h(windowInsets, null);
    }

    public static v h(WindowInsets windowInsets, View view) {
        Objects.requireNonNull(windowInsets);
        v vVar = new v(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            vVar.a.l(l.j(view));
            View rootView = view.getRootView();
            Rect rect = new Rect();
            rootView.getWindowVisibleDisplayFrame(rect);
            vVar.a.k(rect, rootView.getHeight());
        }
        return vVar;
    }

    @Deprecated
    public int a() {
        return this.a.g().f1422d;
    }

    @Deprecated
    public int b() {
        return this.a.g().a;
    }

    @Deprecated
    public int c() {
        return this.a.g().c;
    }

    @Deprecated
    public int d() {
        return this.a.g().b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return Objects.equals(this.a, ((v) obj).a);
    }

    public WindowInsets f() {
        j jVar = this.a;
        if (jVar instanceof e) {
            return ((e) jVar).c;
        }
        return null;
    }

    public int hashCode() {
        j jVar = this.a;
        if (jVar == null) {
            return 0;
        }
        return jVar.hashCode();
    }
}
