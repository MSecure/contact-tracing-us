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

public class w {
    public static final w b = (Build.VERSION.SDK_INT >= 30 ? i.f1495j : j.b);
    public final j a;

    public static class a extends d {
        public static Field c = null;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f1486d = false;

        /* renamed from: e  reason: collision with root package name */
        public static Constructor<WindowInsets> f1487e = null;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f1488f = false;
        public WindowInsets b;

        public a() {
            if (!f1486d) {
                try {
                    c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f1486d = true;
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
            if (!f1488f) {
                try {
                    f1487e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f1488f = true;
            }
            Constructor<WindowInsets> constructor = f1487e;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            this.b = windowInsets;
        }

        public a(w wVar) {
            this.b = wVar.f();
        }

        @Override // e.i.i.w.d
        public w a() {
            return w.g(this.b);
        }

        @Override // e.i.i.w.d
        public void c(e.i.c.b bVar) {
            WindowInsets windowInsets = this.b;
            if (windowInsets != null) {
                this.b = windowInsets.replaceSystemWindowInsets(bVar.a, bVar.b, bVar.c, bVar.f1436d);
            }
        }
    }

    public static class b extends d {
        public final WindowInsets.Builder b;

        public b() {
            this.b = new WindowInsets.Builder();
        }

        public b(w wVar) {
            WindowInsets.Builder builder;
            if (wVar.f() == null) {
                builder = new WindowInsets.Builder();
            }
            this.b = builder;
        }

        @Override // e.i.i.w.d
        public w a() {
            return w.g(this.b.build());
        }

        @Override // e.i.i.w.d
        public void b(e.i.c.b bVar) {
            this.b.setStableInsets(bVar.b());
        }

        @Override // e.i.i.w.d
        public void c(e.i.c.b bVar) {
            this.b.setSystemWindowInsets(bVar.b());
        }
    }

    public static class c extends b {
        public c() {
        }

        public c(w wVar) {
            super(wVar);
        }
    }

    public static class d {
        public final w a = new w((w) null);

        public w a() {
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
        public e.i.c.b f1489d = null;

        /* renamed from: e  reason: collision with root package name */
        public w f1490e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f1491f;

        /* renamed from: g  reason: collision with root package name */
        public int f1492g;

        public e(w wVar, WindowInsets windowInsets) {
            super(wVar);
            this.c = windowInsets;
        }

        @Override // e.i.i.w.j
        public final e.i.c.b g() {
            if (this.f1489d == null) {
                this.f1489d = e.i.c.b.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.f1489d;
        }

        @Override // e.i.i.w.j
        public w h(int i2, int i3, int i4, int i5) {
            w g2 = w.g(this.c);
            int i6 = Build.VERSION.SDK_INT;
            d cVar = i6 >= 30 ? new c(g2) : i6 >= 29 ? new b(g2) : new a(g2);
            cVar.c(w.e(g(), i2, i3, i4, i5));
            cVar.b(w.e(f(), i2, i3, i4, i5));
            return cVar.a();
        }

        @Override // e.i.i.w.j
        public boolean j() {
            return this.c.isRound();
        }

        @Override // e.i.i.w.j
        public void k(Rect rect, int i2) {
            this.f1491f = rect;
            this.f1492g = i2;
        }

        @Override // e.i.i.w.j
        public void l(w wVar) {
            this.f1490e = wVar;
        }
    }

    public static class f extends e {

        /* renamed from: h  reason: collision with root package name */
        public e.i.c.b f1493h = null;

        public f(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
        }

        @Override // e.i.i.w.j
        public w b() {
            return w.g(this.c.consumeStableInsets());
        }

        @Override // e.i.i.w.j
        public w c() {
            return w.g(this.c.consumeSystemWindowInsets());
        }

        @Override // e.i.i.w.j
        public final e.i.c.b f() {
            if (this.f1493h == null) {
                this.f1493h = e.i.c.b.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.f1493h;
        }

        @Override // e.i.i.w.j
        public boolean i() {
            return this.c.isConsumed();
        }
    }

    public static class g extends f {
        public g(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
        }

        @Override // e.i.i.w.j
        public w a() {
            return w.g(this.c.consumeDisplayCutout());
        }

        @Override // e.i.i.w.j
        public c d() {
            DisplayCutout displayCutout = this.c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new c(displayCutout);
        }

        @Override // e.i.i.w.j
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            return Objects.equals(this.c, ((g) obj).c);
        }

        @Override // e.i.i.w.j
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    public static class h extends g {

        /* renamed from: i  reason: collision with root package name */
        public e.i.c.b f1494i = null;

        public h(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
        }

        @Override // e.i.i.w.j
        public e.i.c.b e() {
            if (this.f1494i == null) {
                Insets mandatorySystemGestureInsets = this.c.getMandatorySystemGestureInsets();
                this.f1494i = e.i.c.b.a(mandatorySystemGestureInsets.left, mandatorySystemGestureInsets.top, mandatorySystemGestureInsets.right, mandatorySystemGestureInsets.bottom);
            }
            return this.f1494i;
        }

        @Override // e.i.i.w.e, e.i.i.w.j
        public w h(int i2, int i3, int i4, int i5) {
            return w.g(this.c.inset(i2, i3, i4, i5));
        }
    }

    public static class i extends h {

        /* renamed from: j  reason: collision with root package name */
        public static final w f1495j = w.g(WindowInsets.CONSUMED);

        public i(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
        }
    }

    public static class j {
        public static final w b;
        public final w a;

        static {
            int i2 = Build.VERSION.SDK_INT;
            b = (i2 >= 30 ? new c() : i2 >= 29 ? new b() : new a()).a().a.a().a.b().a.c();
        }

        public j(w wVar) {
            this.a = wVar;
        }

        public w a() {
            return this.a;
        }

        public w b() {
            return this.a;
        }

        public w c() {
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
            return e.i.c.b.f1435e;
        }

        public e.i.c.b g() {
            return e.i.c.b.f1435e;
        }

        public w h(int i2, int i3, int i4, int i5) {
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

        public void l(w wVar) {
        }
    }

    public w(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.a = i2 >= 30 ? new i(this, windowInsets) : i2 >= 29 ? new h(this, windowInsets) : i2 >= 28 ? new g(this, windowInsets) : new f(this, windowInsets);
    }

    public w(w wVar) {
        this.a = new j(this);
    }

    public static e.i.c.b e(e.i.c.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.a - i2);
        int max2 = Math.max(0, bVar.b - i3);
        int max3 = Math.max(0, bVar.c - i4);
        int max4 = Math.max(0, bVar.f1436d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : e.i.c.b.a(max, max2, max3, max4);
    }

    public static w g(WindowInsets windowInsets) {
        return h(windowInsets, null);
    }

    public static w h(WindowInsets windowInsets, View view) {
        Objects.requireNonNull(windowInsets);
        w wVar = new w(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            wVar.a.l(m.j(view));
            View rootView = view.getRootView();
            Rect rect = new Rect();
            rootView.getWindowVisibleDisplayFrame(rect);
            wVar.a.k(rect, rootView.getHeight());
        }
        return wVar;
    }

    @Deprecated
    public int a() {
        return this.a.g().f1436d;
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
        if (!(obj instanceof w)) {
            return false;
        }
        return Objects.equals(this.a, ((w) obj).a);
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
