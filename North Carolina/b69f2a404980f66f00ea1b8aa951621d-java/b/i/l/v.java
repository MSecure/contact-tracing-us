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
    public static final v f1179b = (Build.VERSION.SDK_INT >= 29 ? new b() : new a()).a().f1180a.a().f1180a.b().a();

    /* renamed from: a  reason: collision with root package name */
    public final h f1180a;

    public static class a extends c {

        /* renamed from: c  reason: collision with root package name */
        public static Field f1181c = null;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f1182d = false;

        /* renamed from: e  reason: collision with root package name */
        public static Constructor<WindowInsets> f1183e = null;
        public static boolean f = false;

        /* renamed from: b  reason: collision with root package name */
        public WindowInsets f1184b;

        public a() {
            if (!f1182d) {
                try {
                    f1181c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f1182d = true;
            }
            Field field = f1181c;
            WindowInsets windowInsets = null;
            if (field != null) {
                try {
                    WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                    if (windowInsets2 != null) {
                        windowInsets = new WindowInsets(windowInsets2);
                        this.f1184b = windowInsets;
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f) {
                try {
                    f1183e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f = true;
            }
            Constructor<WindowInsets> constructor = f1183e;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            this.f1184b = windowInsets;
        }

        public a(v vVar) {
            this.f1184b = vVar.j();
        }

        @Override // b.i.l.v.c
        public v a() {
            return v.k(this.f1184b);
        }

        @Override // b.i.l.v.c
        public void c(b.i.f.b bVar) {
            WindowInsets windowInsets = this.f1184b;
            if (windowInsets != null) {
                this.f1184b = windowInsets.replaceSystemWindowInsets(bVar.f1048a, bVar.f1049b, bVar.f1050c, bVar.f1051d);
            }
        }
    }

    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsets.Builder f1185b;

        public b() {
            this.f1185b = new WindowInsets.Builder();
        }

        public b(v vVar) {
            WindowInsets.Builder builder;
            if (vVar.j() == null) {
                builder = new WindowInsets.Builder();
            }
            this.f1185b = builder;
        }

        @Override // b.i.l.v.c
        public v a() {
            return v.k(this.f1185b.build());
        }

        @Override // b.i.l.v.c
        public void b(b.i.f.b bVar) {
            this.f1185b.setStableInsets(Insets.of(bVar.f1048a, bVar.f1049b, bVar.f1050c, bVar.f1051d));
        }

        @Override // b.i.l.v.c
        public void c(b.i.f.b bVar) {
            this.f1185b.setSystemWindowInsets(Insets.of(bVar.f1048a, bVar.f1049b, bVar.f1050c, bVar.f1051d));
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final v f1186a = new v((v) null);

        public abstract v a();

        public void b(b.i.f.b bVar) {
        }

        public abstract void c(b.i.f.b bVar);
    }

    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsets f1187b;

        /* renamed from: c  reason: collision with root package name */
        public b.i.f.b f1188c = null;

        public d(v vVar, WindowInsets windowInsets) {
            super(vVar);
            this.f1187b = windowInsets;
        }

        @Override // b.i.l.v.h
        public final b.i.f.b f() {
            if (this.f1188c == null) {
                this.f1188c = b.i.f.b.a(this.f1187b.getSystemWindowInsetLeft(), this.f1187b.getSystemWindowInsetTop(), this.f1187b.getSystemWindowInsetRight(), this.f1187b.getSystemWindowInsetBottom());
            }
            return this.f1188c;
        }

        @Override // b.i.l.v.h
        public v g(int i, int i2, int i3, int i4) {
            v k = v.k(this.f1187b);
            c bVar = Build.VERSION.SDK_INT >= 29 ? new b(k) : new a(k);
            bVar.c(v.g(f(), i, i2, i3, i4));
            bVar.b(v.g(e(), i, i2, i3, i4));
            return bVar.a();
        }

        @Override // b.i.l.v.h
        public boolean i() {
            return this.f1187b.isRound();
        }
    }

    public static class e extends d {

        /* renamed from: d  reason: collision with root package name */
        public b.i.f.b f1189d = null;

        public e(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // b.i.l.v.h
        public v b() {
            return v.k(this.f1187b.consumeStableInsets());
        }

        @Override // b.i.l.v.h
        public v c() {
            return v.k(this.f1187b.consumeSystemWindowInsets());
        }

        @Override // b.i.l.v.h
        public final b.i.f.b e() {
            if (this.f1189d == null) {
                this.f1189d = b.i.f.b.a(this.f1187b.getStableInsetLeft(), this.f1187b.getStableInsetTop(), this.f1187b.getStableInsetRight(), this.f1187b.getStableInsetBottom());
            }
            return this.f1189d;
        }

        @Override // b.i.l.v.h
        public boolean h() {
            return this.f1187b.isConsumed();
        }
    }

    public static class f extends e {
        public f(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // b.i.l.v.h
        public v a() {
            return v.k(this.f1187b.consumeDisplayCutout());
        }

        @Override // b.i.l.v.h
        public c d() {
            DisplayCutout displayCutout = this.f1187b.getDisplayCutout();
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
            return Objects.equals(this.f1187b, ((f) obj).f1187b);
        }

        @Override // b.i.l.v.h
        public int hashCode() {
            return this.f1187b.hashCode();
        }
    }

    public static class g extends f {
        public g(v vVar, WindowInsets windowInsets) {
            super(vVar, windowInsets);
        }

        @Override // b.i.l.v.h, b.i.l.v.d
        public v g(int i, int i2, int i3, int i4) {
            return v.k(this.f1187b.inset(i, i2, i3, i4));
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public final v f1190a;

        public h(v vVar) {
            this.f1190a = vVar;
        }

        public v a() {
            return this.f1190a;
        }

        public v b() {
            return this.f1190a;
        }

        public v c() {
            return this.f1190a;
        }

        public c d() {
            return null;
        }

        public b.i.f.b e() {
            return b.i.f.b.f1047e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return i() == hVar.i() && h() == hVar.h() && Objects.equals(f(), hVar.f()) && Objects.equals(e(), hVar.e()) && Objects.equals(d(), hVar.d());
        }

        public b.i.f.b f() {
            return b.i.f.b.f1047e;
        }

        public v g(int i, int i2, int i3, int i4) {
            return v.f1179b;
        }

        public boolean h() {
            return false;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(i()), Boolean.valueOf(h()), f(), e(), d());
        }

        public boolean i() {
            return false;
        }
    }

    public v(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        this.f1180a = i >= 29 ? new g(this, windowInsets) : i >= 28 ? new f(this, windowInsets) : new e(this, windowInsets);
    }

    public v(v vVar) {
        this.f1180a = new h(this);
    }

    public static b.i.f.b g(b.i.f.b bVar, int i, int i2, int i3, int i4) {
        int max = Math.max(0, bVar.f1048a - i);
        int max2 = Math.max(0, bVar.f1049b - i2);
        int max3 = Math.max(0, bVar.f1050c - i3);
        int max4 = Math.max(0, bVar.f1051d - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? bVar : b.i.f.b.a(max, max2, max3, max4);
    }

    public static v k(WindowInsets windowInsets) {
        if (windowInsets != null) {
            return new v(windowInsets);
        }
        throw null;
    }

    public v a() {
        return this.f1180a.c();
    }

    public int b() {
        return f().f1051d;
    }

    public int c() {
        return f().f1048a;
    }

    public int d() {
        return f().f1050c;
    }

    public int e() {
        return f().f1049b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return Objects.equals(this.f1180a, ((v) obj).f1180a);
    }

    public b.i.f.b f() {
        return this.f1180a.f();
    }

    public boolean h() {
        return this.f1180a.h();
    }

    public int hashCode() {
        h hVar = this.f1180a;
        if (hVar == null) {
            return 0;
        }
        return hVar.hashCode();
    }

    @Deprecated
    public v i(int i, int i2, int i3, int i4) {
        c bVar = Build.VERSION.SDK_INT >= 29 ? new b(this) : new a(this);
        bVar.c(b.i.f.b.a(i, i2, i3, i4));
        return bVar.a();
    }

    public WindowInsets j() {
        h hVar = this.f1180a;
        if (hVar instanceof d) {
            return ((d) hVar).f1187b;
        }
        return null;
    }
}
