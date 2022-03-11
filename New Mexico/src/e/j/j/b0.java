package e.j.j;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import e.j.j.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b0 {
    public static final b0 b;
    public final k a;

    /* loaded from: classes.dex */
    public static class a {
        public static Field a;
        public static Field b;
        public static Field c;

        /* renamed from: d */
        public static boolean f1608d;

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
                f1608d = true;
            } catch (ReflectiveOperationException e2) {
                e2.getMessage();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e {

        /* renamed from: d */
        public static Field f1609d;

        /* renamed from: e */
        public static boolean f1610e;

        /* renamed from: f */
        public static Constructor<WindowInsets> f1611f;

        /* renamed from: g */
        public static boolean f1612g;
        public WindowInsets b;
        public e.j.c.b c;

        public b() {
            WindowInsets windowInsets;
            if (!f1610e) {
                try {
                    f1609d = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f1610e = true;
            }
            Field field = f1609d;
            WindowInsets windowInsets2 = null;
            if (field != null) {
                try {
                    windowInsets = (WindowInsets) field.get(null);
                } catch (ReflectiveOperationException unused2) {
                }
                if (windowInsets != null) {
                    windowInsets2 = new WindowInsets(windowInsets);
                    this.b = windowInsets2;
                }
            }
            if (!f1612g) {
                try {
                    f1611f = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f1612g = true;
            }
            Constructor<WindowInsets> constructor = f1611f;
            if (constructor != null) {
                try {
                    windowInsets2 = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            this.b = windowInsets2;
        }

        public b(b0 b0Var) {
            super(b0Var);
            this.b = b0Var.g();
        }

        @Override // e.j.j.b0.e
        public b0 a() {
            b0 h2 = b0.h(this.b);
            h2.a.l(null);
            h2.a.n(this.c);
            return h2;
        }

        @Override // e.j.j.b0.e
        public void b(e.j.c.b bVar) {
            this.c = bVar;
        }

        @Override // e.j.j.b0.e
        public void c(e.j.c.b bVar) {
            WindowInsets windowInsets = this.b;
            if (windowInsets != null) {
                this.b = windowInsets.replaceSystemWindowInsets(bVar.a, bVar.b, bVar.c, bVar.f1571d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends e {
        public final WindowInsets.Builder b;

        public c() {
            this.b = new WindowInsets.Builder();
        }

        public c(b0 b0Var) {
            super(b0Var);
            WindowInsets g2 = b0Var.g();
            this.b = g2 != null ? new WindowInsets.Builder(g2) : new WindowInsets.Builder();
        }

        @Override // e.j.j.b0.e
        public b0 a() {
            b0 h2 = b0.h(this.b.build());
            h2.a.l(null);
            return h2;
        }

        @Override // e.j.j.b0.e
        public void b(e.j.c.b bVar) {
            this.b.setStableInsets(bVar.c());
        }

        @Override // e.j.j.b0.e
        public void c(e.j.c.b bVar) {
            this.b.setSystemWindowInsets(bVar.c());
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c {
        public d() {
        }

        public d(b0 b0Var) {
            super(b0Var);
        }
    }

    /* loaded from: classes.dex */
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

        public void b(e.j.c.b bVar) {
            throw null;
        }

        public void c(e.j.c.b bVar) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends k {

        /* renamed from: h */
        public static boolean f1613h;

        /* renamed from: i */
        public static Method f1614i;

        /* renamed from: j */
        public static Class<?> f1615j;

        /* renamed from: k */
        public static Field f1616k;

        /* renamed from: l */
        public static Field f1617l;
        public final WindowInsets c;

        /* renamed from: d */
        public e.j.c.b[] f1618d;

        /* renamed from: e */
        public e.j.c.b f1619e = null;

        /* renamed from: f */
        public b0 f1620f;

        /* renamed from: g */
        public e.j.c.b f1621g;

        public f(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var);
            this.c = windowInsets;
        }

        @Override // e.j.j.b0.k
        public void d(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f1613h) {
                    try {
                        f1614i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                        Class<?> cls = Class.forName("android.view.View$AttachInfo");
                        f1615j = cls;
                        f1616k = cls.getDeclaredField("mVisibleInsets");
                        f1617l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                        f1616k.setAccessible(true);
                        f1617l.setAccessible(true);
                    } catch (ReflectiveOperationException e2) {
                        e2.getMessage();
                    }
                    f1613h = true;
                }
                Method method = f1614i;
                e.j.c.b bVar = null;
                if (!(method == null || f1615j == null || f1616k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke != null) {
                            Rect rect = (Rect) f1616k.get(f1617l.get(invoke));
                            if (rect != null) {
                                bVar = e.j.c.b.a(rect.left, rect.top, rect.right, rect.bottom);
                            }
                        }
                    } catch (ReflectiveOperationException e3) {
                        e3.getMessage();
                    }
                }
                if (bVar == null) {
                    bVar = e.j.c.b.f1570e;
                }
                this.f1621g = bVar;
                return;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // e.j.j.b0.k
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f1621g, ((f) obj).f1621g);
        }

        @Override // e.j.j.b0.k
        public final e.j.c.b h() {
            if (this.f1619e == null) {
                this.f1619e = e.j.c.b.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.f1619e;
        }

        @Override // e.j.j.b0.k
        public b0 i(int i2, int i3, int i4, int i5) {
            b0 h2 = b0.h(this.c);
            int i6 = Build.VERSION.SDK_INT;
            e dVar = i6 >= 30 ? new d(h2) : i6 >= 29 ? new c(h2) : new b(h2);
            dVar.c(b0.e(h(), i2, i3, i4, i5));
            dVar.b(b0.e(g(), i2, i3, i4, i5));
            return dVar.a();
        }

        @Override // e.j.j.b0.k
        public boolean k() {
            return this.c.isRound();
        }

        @Override // e.j.j.b0.k
        public void l(e.j.c.b[] bVarArr) {
            this.f1618d = bVarArr;
        }

        @Override // e.j.j.b0.k
        public void m(b0 b0Var) {
            this.f1620f = b0Var;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends f {
        public e.j.c.b m = null;

        public g(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.j.j.b0.k
        public b0 b() {
            return b0.h(this.c.consumeStableInsets());
        }

        @Override // e.j.j.b0.k
        public b0 c() {
            return b0.h(this.c.consumeSystemWindowInsets());
        }

        @Override // e.j.j.b0.k
        public final e.j.c.b g() {
            if (this.m == null) {
                this.m = e.j.c.b.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // e.j.j.b0.k
        public boolean j() {
            return this.c.isConsumed();
        }

        @Override // e.j.j.b0.k
        public void n(e.j.c.b bVar) {
            this.m = bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends g {
        public h(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.j.j.b0.k
        public b0 a() {
            return b0.h(this.c.consumeDisplayCutout());
        }

        @Override // e.j.j.b0.k
        public f e() {
            DisplayCutout displayCutout = this.c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new f(displayCutout);
        }

        @Override // e.j.j.b0.f, e.j.j.b0.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.c, hVar.c) && Objects.equals(this.f1621g, hVar.f1621g);
        }

        @Override // e.j.j.b0.k
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        public e.j.c.b n = null;
        public e.j.c.b o = null;
        public e.j.c.b p = null;

        public i(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.j.j.b0.k
        public e.j.c.b f() {
            if (this.o == null) {
                this.o = e.j.c.b.b(this.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        @Override // e.j.j.b0.f, e.j.j.b0.k
        public b0 i(int i2, int i3, int i4, int i5) {
            return b0.h(this.c.inset(i2, i3, i4, i5));
        }

        @Override // e.j.j.b0.g, e.j.j.b0.k
        public void n(e.j.c.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class j extends i {
        public static final b0 q = b0.h(WindowInsets.CONSUMED);

        public j(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // e.j.j.b0.f, e.j.j.b0.k
        public final void d(View view) {
        }
    }

    /* loaded from: classes.dex */
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

        public e.j.c.b f() {
            return h();
        }

        public e.j.c.b g() {
            return e.j.c.b.f1570e;
        }

        public e.j.c.b h() {
            return e.j.c.b.f1570e;
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

        public void l(e.j.c.b[] bVarArr) {
        }

        public void m(b0 b0Var) {
        }

        public void n(e.j.c.b bVar) {
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 30 ? j.q : k.b;
    }

    public b0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.a = i2 >= 30 ? new j(this, windowInsets) : i2 >= 29 ? new i(this, windowInsets) : i2 >= 28 ? new h(this, windowInsets) : new g(this, windowInsets);
    }

    public b0(b0 b0Var) {
        this.a = new k(this);
    }

    public static e.j.c.b e(e.j.c.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.a - i2);
        int max2 = Math.max(0, bVar.b - i3);
        int max3 = Math.max(0, bVar.c - i4);
        int max4 = Math.max(0, bVar.f1571d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : e.j.c.b.a(max, max2, max3, max4);
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
        return this.a.h().f1571d;
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
