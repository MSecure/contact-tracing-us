package e.i.i;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import e.i.i.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class b0 {
    public static final b0 b = (Build.VERSION.SDK_INT >= 30 ? j.q : k.b);
    public final k a;

    public static class a {
        public static Field a;
        public static Field b;
        public static Field c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f1523d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                e2.getMessage();
            }
        }
    }

    public static class b extends e {

        /* renamed from: d  reason: collision with root package name */
        public static Field f1524d = null;

        /* renamed from: e  reason: collision with root package name */
        public static boolean f1525e = false;

        /* renamed from: f  reason: collision with root package name */
        public static Constructor<WindowInsets> f1526f = null;

        /* renamed from: g  reason: collision with root package name */
        public static boolean f1527g = false;
        public WindowInsets b;
        public e.i.c.b c;

        public b() {
            if (!f1525e) {
                try {
                    f1524d = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f1525e = true;
            }
            Field field = f1524d;
            WindowInsets windowInsets = null;
            if (field != null) {
                try {
                    WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                    if (windowInsets2 != null) {
                        windowInsets = new WindowInsets(windowInsets2);
                        this.b = windowInsets;
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f1527g) {
                try {
                    f1526f = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f1527g = true;
            }
            Constructor<WindowInsets> constructor = f1526f;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            this.b = windowInsets;
        }

        public b(b0 b0Var) {
            super(b0Var);
            this.b = b0Var.g();
        }

        @Override // e.i.i.b0.e
        public b0 a() {
            b0 h2 = b0.h(this.b);
            h2.a.l(null);
            h2.a.n(this.c);
            return h2;
        }

        @Override // e.i.i.b0.e
        public void b(e.i.c.b bVar) {
            this.c = bVar;
        }

        @Override // e.i.i.b0.e
        public void c(e.i.c.b bVar) {
            WindowInsets windowInsets = this.b;
            if (windowInsets != null) {
                this.b = windowInsets.replaceSystemWindowInsets(bVar.a, bVar.b, bVar.c, bVar.f1487d);
            }
        }
    }

    public static class c extends e {
        public final WindowInsets.Builder b;

        public c() {
            this.b = new WindowInsets.Builder();
        }

        public c(b0 b0Var) {
            super(b0Var);
            WindowInsets.Builder builder;
            if (b0Var.g() == null) {
                builder = new WindowInsets.Builder();
            }
            this.b = builder;
        }

        @Override // e.i.i.b0.e
        public b0 a() {
            b0 h2 = b0.h(this.b.build());
            h2.a.l(null);
            return h2;
        }

        @Override // e.i.i.b0.e
        public void b(e.i.c.b bVar) {
            this.b.setStableInsets(bVar.c());
        }

        @Override // e.i.i.b0.e
        public void c(e.i.c.b bVar) {
            this.b.setSystemWindowInsets(bVar.c());
        }
    }

    public static class d extends c {
        public d() {
        }

        public d(b0 b0Var) {
            super(b0Var);
        }
    }

    public static class e {
        public final b0 a;

        public e() {
            this.a = new b0((b0) null);
        }

        public e(b0 b0Var) {
            this.a = b0Var;
        }

        public b0 a() {
            throw null;
        }

        public void b(e.i.c.b bVar) {
            throw null;
        }

        public void c(e.i.c.b bVar) {
            throw null;
        }
    }

    public static class f extends k {

        /* renamed from: h  reason: collision with root package name */
        public static boolean f1528h = false;

        /* renamed from: i  reason: collision with root package name */
        public static Method f1529i;

        /* renamed from: j  reason: collision with root package name */
        public static Class<?> f1530j;

        /* renamed from: k  reason: collision with root package name */
        public static Field f1531k;

        /* renamed from: l  reason: collision with root package name */
        public static Field f1532l;
        public final WindowInsets c;

        /* renamed from: d  reason: collision with root package name */
        public e.i.c.b[] f1533d;

        /* renamed from: e  reason: collision with root package name */
        public e.i.c.b f1534e = null;

        /* renamed from: f  reason: collision with root package name */
        public b0 f1535f;

        /* renamed from: g  reason: collision with root package name */
        public e.i.c.b f1536g;

        public f(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var);
            this.c = windowInsets;
        }

        @Override // e.i.i.b0.k
        public void d(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f1528h) {
                    try {
                        f1529i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                        Class<?> cls = Class.forName("android.view.View$AttachInfo");
                        f1530j = cls;
                        f1531k = cls.getDeclaredField("mVisibleInsets");
                        f1532l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                        f1531k.setAccessible(true);
                        f1532l.setAccessible(true);
                    } catch (ReflectiveOperationException e2) {
                        e2.getMessage();
                    }
                    f1528h = true;
                }
                Method method = f1529i;
                e.i.c.b bVar = null;
                if (!(method == null || f1530j == null || f1531k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke != null) {
                            Rect rect = (Rect) f1531k.get(f1532l.get(invoke));
                            if (rect != null) {
                                bVar = e.i.c.b.a(rect.left, rect.top, rect.right, rect.bottom);
                            }
                        }
                    } catch (ReflectiveOperationException e3) {
                        e3.getMessage();
                    }
                }
                if (bVar == null) {
                    bVar = e.i.c.b.f1486e;
                }
                this.f1536g = bVar;
                return;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // e.i.i.b0.k
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f1536g, ((f) obj).f1536g);
        }

        @Override // e.i.i.b0.k
        public final e.i.c.b h() {
            if (this.f1534e == null) {
                this.f1534e = e.i.c.b.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.f1534e;
        }

        @Override // e.i.i.b0.k
        public b0 i(int i2, int i3, int i4, int i5) {
            b0 h2 = b0.h(this.c);
            int i6 = Build.VERSION.SDK_INT;
            e dVar = i6 >= 30 ? new d(h2) : i6 >= 29 ? new c(h2) : new b(h2);
            dVar.c(b0.e(h(), i2, i3, i4, i5));
            dVar.b(b0.e(g(), i2, i3, i4, i5));
            return dVar.a();
        }

        @Override // e.i.i.b0.k
        public boolean k() {
            return this.c.isRound();
        }

        @Override // e.i.i.b0.k
        public void l(e.i.c.b[] bVarArr) {
            this.f1533d = bVarArr;
        }

        @Override // e.i.i.b0.k
        public void m(b0 b0Var) {
            this.f1535f = b0Var;
        }
    }

    public static class g extends f {
        public e.i.c.b m = null;

        public g(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.i.i.b0.k
        public b0 b() {
            return b0.h(this.c.consumeStableInsets());
        }

        @Override // e.i.i.b0.k
        public b0 c() {
            return b0.h(this.c.consumeSystemWindowInsets());
        }

        @Override // e.i.i.b0.k
        public final e.i.c.b g() {
            if (this.m == null) {
                this.m = e.i.c.b.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // e.i.i.b0.k
        public boolean j() {
            return this.c.isConsumed();
        }

        @Override // e.i.i.b0.k
        public void n(e.i.c.b bVar) {
            this.m = bVar;
        }
    }

    public static class h extends g {
        public h(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.i.i.b0.k
        public b0 a() {
            return b0.h(this.c.consumeDisplayCutout());
        }

        @Override // e.i.i.b0.k
        public f e() {
            DisplayCutout displayCutout = this.c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new f(displayCutout);
        }

        @Override // e.i.i.b0.f, e.i.i.b0.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.c, hVar.c) && Objects.equals(this.f1536g, hVar.f1536g);
        }

        @Override // e.i.i.b0.k
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    public static class i extends h {
        public e.i.c.b n = null;
        public e.i.c.b o = null;
        public e.i.c.b p = null;

        public i(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.i.i.b0.k
        public e.i.c.b f() {
            if (this.o == null) {
                this.o = e.i.c.b.b(this.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        @Override // e.i.i.b0.f, e.i.i.b0.k
        public b0 i(int i2, int i3, int i4, int i5) {
            return b0.h(this.c.inset(i2, i3, i4, i5));
        }

        @Override // e.i.i.b0.g, e.i.i.b0.k
        public void n(e.i.c.b bVar) {
        }
    }

    public static class j extends i {
        public static final b0 q = b0.h(WindowInsets.CONSUMED);

        public j(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.i.i.b0.f, e.i.i.b0.k
        public final void d(View view) {
        }
    }

    public static class k {
        public static final b0 b;
        public final b0 a;

        static {
            int i2 = Build.VERSION.SDK_INT;
            b = (i2 >= 30 ? new d() : i2 >= 29 ? new c() : new b()).a().a.a().a.b().a.c();
        }

        public k(b0 b0Var) {
            this.a = b0Var;
        }

        public b0 a() {
            return this.a;
        }

        public b0 b() {
            return this.a;
        }

        public b0 c() {
            return this.a;
        }

        public void d(View view) {
        }

        public f e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            if (k() != kVar.k() || j() != kVar.j() || !Objects.equals(h(), kVar.h()) || !Objects.equals(g(), kVar.g()) || !Objects.equals(e(), kVar.e())) {
                return false;
            }
            return true;
        }

        public e.i.c.b f() {
            return h();
        }

        public e.i.c.b g() {
            return e.i.c.b.f1486e;
        }

        public e.i.c.b h() {
            return e.i.c.b.f1486e;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(k()), Boolean.valueOf(j()), h(), g(), e());
        }

        public b0 i(int i2, int i3, int i4, int i5) {
            return b;
        }

        public boolean j() {
            return false;
        }

        public boolean k() {
            return false;
        }

        public void l(e.i.c.b[] bVarArr) {
        }

        public void m(b0 b0Var) {
        }

        public void n(e.i.c.b bVar) {
        }
    }

    public b0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.a = i2 >= 30 ? new j(this, windowInsets) : i2 >= 29 ? new i(this, windowInsets) : i2 >= 28 ? new h(this, windowInsets) : new g(this, windowInsets);
    }

    public b0(b0 b0Var) {
        this.a = new k(this);
    }

    public static e.i.c.b e(e.i.c.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.a - i2);
        int max2 = Math.max(0, bVar.b - i3);
        int max3 = Math.max(0, bVar.c - i4);
        int max4 = Math.max(0, bVar.f1487d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : e.i.c.b.a(max, max2, max3, max4);
    }

    public static b0 h(WindowInsets windowInsets) {
        return i(windowInsets, null);
    }

    public static b0 i(WindowInsets windowInsets, View view) {
        Objects.requireNonNull(windowInsets);
        b0 b0Var = new b0(windowInsets);
        if (view != null) {
            AtomicInteger atomicInteger = v.a;
            if (v.g.b(view)) {
                b0Var.a.m(v.l(view));
                b0Var.a.d(view.getRootView());
            }
        }
        return b0Var;
    }

    @Deprecated
    public int a() {
        return this.a.h().f1487d;
    }

    @Deprecated
    public int b() {
        return this.a.h().a;
    }

    @Deprecated
    public int c() {
        return this.a.h().c;
    }

    @Deprecated
    public int d() {
        return this.a.h().b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        return Objects.equals(this.a, ((b0) obj).a);
    }

    public boolean f() {
        return this.a.j();
    }

    public WindowInsets g() {
        k kVar = this.a;
        if (kVar instanceof f) {
            return ((f) kVar).c;
        }
        return null;
    }

    public int hashCode() {
        k kVar = this.a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }
}
