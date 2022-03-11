package f.b.a.c.b.o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import androidx.activity.ComponentActivity;
import androidx.annotation.RecentlyNonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.aboutlibraries.R$attr;
import com.mikepenz.aboutlibraries.R$style;
import com.mikepenz.aboutlibraries.R$styleable;
import e.b.a.m;
import e.b.f.y0;
import e.i.i.m;
import e.m.a.l;
import e.p.b0;
import f.a.a.a.a;
import f.b.a.c.e.c.h2;
import f.b.a.c.e.c.i2;
import f.b.a.c.e.c.j2;
import f.b.a.c.i.c0;
import f.b.a.c.i.h;
import f.b.a.d.k.c;
import f.b.a.d.v.g;
import f.b.a.d.v.i;
import f.b.b.a.t;
import f.b.b.a.w;
import f.b.b.f.a.p;
import f.b.b.f.a.u;
import f.b.b.f.a.y;
import f.b.c.f.c;
import f.b.c.f.d;
import f.b.d.a.s;
import f.b.f.c0;
import f.b.f.d0;
import f.b.f.e1;
import f.b.f.f;
import f.b.f.j;
import f.b.f.j1;
import f.b.f.k;
import f.b.f.k0;
import f.b.f.o;
import f.b.f.p1;
import f.b.f.r1;
import f.b.f.s1;
import f.b.f.t0;
import f.b.f.v;
import f.b.f.v0;
import f.b.f.w1;
import f.b.f.x;
import f.b.f.y1;
import f.b.f.z;
import h.a.a1;
import h.a.b1;
import h.a.c1;
import h.a.j1.i1;
import h.a.j1.l1;
import h.a.j1.l2;
import h.a.j1.s2;
import h.a.q;
import j.j.b.e;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class b {
    public static Boolean a;
    public static Boolean b;
    public static Boolean c;

    /* renamed from: d  reason: collision with root package name */
    public static Boolean f2575d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f2576e;

    /* renamed from: f  reason: collision with root package name */
    public static Thread f2577f;

    public static <T> T A(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int A0(double d2, double d3) {
        if (d2 < d3) {
            return -1;
        }
        int i2 = (d2 > d3 ? 1 : (d2 == d3 ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (!Double.isNaN(d3)) {
            return -1;
        }
        return !Double.isNaN(d2) ? 1 : 0;
    }

    public static <T> T A1(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a.t(str, " must not be null"));
    }

    public static <T> T B(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(t.b(str, obj));
    }

    public static long B0(long j2, long j3) {
        return j2 >= 0 ? j2 / j3 : ((j2 + 1) / j3) - 1;
    }

    public static TypedValue B1(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static <T> T C(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int C0(int i2, int i3) {
        return ((i2 % i3) + i3) % i3;
    }

    public static boolean C1(Context context, int i2, boolean z) {
        TypedValue B1 = B1(context, i2);
        return (B1 == null || B1.type != 18) ? z : B1.data != 0;
    }

    public static int D(int i2, int i3) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(k(i2, i3, "index"));
    }

    public static int D0(long j2, int i2) {
        long j3 = (long) i2;
        return (int) (((j2 % j3) + j3) % j3);
    }

    public static int D1(Context context, int i2, String str) {
        TypedValue B1 = B1(context, i2);
        if (B1 != null) {
            return B1.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static void E(int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = k(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = k(i3, i4, "end index");
            } else {
                str = t.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static long E0(long j2, long j3) {
        return ((j2 % j3) + j3) % j3;
    }

    public static Object E1(Context context, int[] iArr, int i2, int i3, j.j.a.b bVar, int i4) {
        int[] iArr2;
        if ((i4 & 1) != 0) {
            iArr2 = R$styleable.AboutLibraries;
            e.b(iArr2, "R.styleable.AboutLibraries");
        } else {
            iArr2 = null;
        }
        if ((i4 & 2) != 0) {
            i2 = R$attr.aboutLibrariesStyle;
        }
        if ((i4 & 4) != 0) {
            i3 = R$style.AboutLibrariesStyle;
        }
        e.c(context, "$this$resolveStyledValue");
        e.c(iArr2, "attrs");
        e.c(bVar, "resolver");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr2, i2, i3);
        e.b(obtainStyledAttributes, "obtainStyledAttributes(n…efStyleAttr, defStyleRes)");
        Object d2 = bVar.d(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return d2;
    }

    public static void F(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static <TResult> h<TResult> F0(TResult tresult) {
        c0 c0Var = new c0();
        c0Var.q(tresult);
        return c0Var;
    }

    public static int F1(int i2, int i3) {
        int i4 = i2 + i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) < 0) {
            return i4;
        }
        throw new ArithmeticException("Addition overflows an int: " + i2 + " + " + i3);
    }

    public static void G(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static Object G0(Context context) {
        Application application = (Application) context.getApplicationContext();
        boolean z = application instanceof g.a.b.b;
        Object[] objArr = {application.getClass()};
        if (z) {
            return ((g.a.b.b) application).e();
        }
        throw new IllegalArgumentException(String.format("Hilt BroadcastReceiver must be attached to an @AndroidEntryPoint Application. Found: %s", objArr));
    }

    public static long G1(long j2, long j3) {
        long j4 = j2 + j3;
        if ((j2 ^ j4) >= 0 || (j2 ^ j3) < 0) {
            return j4;
        }
        throw new ArithmeticException("Addition overflows a long: " + j2 + " + " + j3);
    }

    public static void H(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(t.b(str, obj));
        }
    }

    public static <T> T H0(Object obj, Class<T> cls) {
        if (obj instanceof g.a.b.a) {
            return cls.cast(obj);
        }
        if (obj instanceof g.a.b.b) {
            return cls.cast(((g.a.b.b) obj).e());
        }
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", obj.getClass(), g.a.b.a.class, g.a.b.b.class));
    }

    public static long H1(long j2, int i2) {
        if (i2 != -1) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return j2;
            }
            long j3 = (long) i2;
            long j4 = j2 * j3;
            if (j4 / j3 == j2) {
                return j4;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + i2);
        } else if (j2 != Long.MIN_VALUE) {
            return -j2;
        } else {
            throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + i2);
        }
    }

    public static void I(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static b0.b I0(ComponentActivity componentActivity) {
        return Q0(((g.a.a.c.b.a) H0(componentActivity, g.a.a.c.b.a.class)).a());
    }

    public static long I1(long j2, long j3) {
        if (j3 == 1) {
            return j2;
        }
        if (j2 == 1) {
            return j3;
        }
        if (j2 == 0 || j3 == 0) {
            return 0;
        }
        long j4 = j2 * j3;
        if (j4 / j3 == j2 && ((j2 != Long.MIN_VALUE || j3 != -1) && (j3 != Long.MIN_VALUE || j2 != -1))) {
            return j4;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + j3);
    }

    public static final void J(Closeable closeable, Throwable th) {
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            e.c(th, "$this$addSuppressed");
            e.c(th2, "exception");
            if (th != th2) {
                j.i.b.a.a(th, th2);
            }
        }
    }

    public static int J0(Context context, int i2, int i3) {
        TypedValue B1 = B1(context, i2);
        return B1 != null ? B1.data : i3;
    }

    public static int J1(int i2, int i3) {
        int i4 = i2 - i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) >= 0) {
            return i4;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i2 + " - " + i3);
    }

    public static int K(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int K0(View view, int i2) {
        return D1(view.getContext(), i2, view.getClass().getCanonicalName());
    }

    public static long K1(long j2, long j3) {
        long j4 = j2 - j3;
        if ((j2 ^ j4) >= 0 || (j2 ^ j3) >= 0) {
            return j4;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j2 + " - " + j3);
    }

    public static int L(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static ColorStateList L0(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList a2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (a2 = e.b.b.a.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : a2;
    }

    public static int L1(long j2) {
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return (int) j2;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j2);
    }

    public static int M(int i2, int i3) {
        return e.i.c.a.c(i2, (Color.alpha(i2) * i3) / 255);
    }

    public static ColorStateList M0(Context context, y0 y0Var, int i2) {
        int resourceId;
        ColorStateList a2;
        return (!y0Var.b.hasValue(i2) || (resourceId = y0Var.b.getResourceId(i2, 0)) == 0 || (a2 = e.b.b.a.a.a(context, resourceId)) == null) ? y0Var.c(i2) : a2;
    }

    public static void M1(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            g gVar = (g) background;
            g.b bVar = gVar.b;
            if (bVar.o != f2) {
                bVar.o = f2;
                gVar.y();
            }
        }
    }

    public static d<?> N(String str, String str2) {
        f.b.c.n.a aVar = new f.b.c.n.a(str, str2);
        d.b a2 = d.a(f.b.c.n.e.class);
        a2.c = 1;
        a2.c(new c(aVar));
        return a2.b();
    }

    public static int N0(Context context, TypedArray typedArray, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, i3);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i3);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static void N1(View view, g gVar) {
        f.b.a.d.n.a aVar = gVar.b.b;
        if (aVar != null && aVar.a) {
            float V0 = V0(view);
            g.b bVar = gVar.b;
            if (bVar.n != V0) {
                bVar.n = V0;
                gVar.y();
            }
        }
    }

    public static l1 O() {
        return l2.f3745e == null ? new l2() : new h.a.j1.h();
    }

    public static <V> V O0(Future<V> future) {
        V v;
        H(future.isDone(), "Future was expected to be done: %s", future);
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public static final char O1(char[] cArr) {
        e.c(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static Animator P(f.b.a.d.k.c cVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, c.C0094c.a, c.b.b, new c.e(f2, f3, f4));
        c.e revealInfo = cVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, revealInfo.c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Drawable P0(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable b2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (b2 = e.b.b.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i2) : b2;
    }

    public static int P1(int i2, byte[] bArr, int i3, int i4, f fVar) {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return o0(bArr, i3, fVar);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return m0(bArr, i3, fVar) + fVar.a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = m0(bArr, i3, fVar);
                    i7 = fVar.a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = P1(i7, bArr, i3, i4, fVar);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw d0.g();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw d0.b();
            }
        } else {
            throw d0.b();
        }
    }

    public static f.b.a.d.v.d Q(int i2) {
        if (i2 == 0) {
            return new i();
        }
        if (i2 != 1) {
            return new i();
        }
        return new f.b.a.d.v.e();
    }

    public static b0.b Q0(Set<b0.b> set) {
        if (set.isEmpty()) {
            return null;
        }
        if (set.size() <= 1) {
            b0.b next = set.iterator().next();
            if (next != null) {
                return next;
            }
            throw new IllegalStateException("Default view model factory must not be null.");
        }
        throw new IllegalStateException("At most one default view model factory is expected. Found " + set);
    }

    public static int Q1(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * -862048943), 15)) * 461845907);
    }

    public static int R(byte[] bArr, int i2, f fVar) {
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a;
        if (i3 < 0) {
            throw d0.f();
        } else if (i3 > bArr.length - m0) {
            throw d0.h();
        } else if (i3 == 0) {
            fVar.c = j.c;
            return m0;
        } else {
            fVar.c = j.m(bArr, m0, i3);
            return m0 + i3;
        }
    }

    public static b0.b R0(l lVar) {
        return Q0(((g.a.a.c.b.b) H0(lVar, g.a.a.c.b.b.class)).c());
    }

    public static c1 R1(q qVar) {
        A(qVar, "context must not be null");
        if (!qVar.X()) {
            return null;
        }
        Throwable A = qVar.A();
        if (A == null) {
            return c1.f3614g.g("io.grpc.Context was cancelled without error");
        }
        if (A instanceof TimeoutException) {
            return c1.f3616i.g(A.getMessage()).f(A);
        }
        c1 d2 = c1.d(A);
        return (!c1.b.UNKNOWN.equals(d2.a) || d2.c != A) ? d2.f(A) : c1.f3614g.g("Context cancelled").f(A);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: f.b.f.r1<f.b.f.s1, f.b.f.s1> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b0  */
    public static int S(int i2, byte[] bArr, int i3, int i4, z.c<?, ?> cVar, z.e<?, ?> eVar, r1<s1, s1> r1Var, f fVar) {
        z.d dVar;
        Object g2;
        int i5;
        int i6;
        Object obj;
        Object obj2;
        long j2;
        int i7;
        int i8;
        int i9;
        f.b.f.c cVar2;
        Object obj3 = s1.f3464f;
        v<z.d> vVar = cVar.extensions;
        int i10 = i2 >>> 3;
        z.d dVar2 = eVar.f3514d;
        Object obj4 = null;
        if (!dVar2.f3512e || !dVar2.f3513f) {
            y1 y1Var = dVar2.f3511d;
            if (y1Var == y1.ENUM) {
                i6 = m0(bArr, i3, fVar);
                if (eVar.f3514d.b.findValueByNumber(fVar.a) == null) {
                    Object obj5 = cVar.unknownFields;
                    Object obj6 = obj5;
                    if (obj5 == obj3) {
                        s1 e2 = s1.e();
                        cVar.unknownFields = e2;
                        obj6 = e2;
                    }
                    int i11 = fVar.a;
                    Class<?> cls = f.b.f.l1.a;
                    Object obj7 = obj6;
                    if (obj6 == null) {
                        obj7 = r1Var.m();
                    }
                    r1Var.e(obj7 == 1 ? 1 : 0, i10, (long) i11);
                    return i6;
                }
            } else {
                switch (y1Var.ordinal()) {
                    case 0:
                        obj = Double.valueOf(Double.longBitsToDouble(U(bArr, i3)));
                        obj4 = obj;
                        i3 += 8;
                        break;
                    case 1:
                        obj2 = Float.valueOf(Float.intBitsToFloat(T(bArr, i3)));
                        obj4 = obj2;
                        i3 += 4;
                        break;
                    case 2:
                    case 3:
                        i7 = o0(bArr, i3, fVar);
                        j2 = fVar.b;
                        obj4 = Long.valueOf(j2);
                        i3 = i7;
                        break;
                    case 4:
                    case 12:
                        i6 = m0(bArr, i3, fVar);
                        break;
                    case 5:
                    case 15:
                        obj = Long.valueOf(U(bArr, i3));
                        obj4 = obj;
                        i3 += 8;
                        break;
                    case 6:
                    case 14:
                        obj2 = Integer.valueOf(T(bArr, i3));
                        obj4 = obj2;
                        i3 += 4;
                        break;
                    case 7:
                        i3 = o0(bArr, i3, fVar);
                        obj4 = Boolean.valueOf(fVar.b != 0);
                        break;
                    case 8:
                        i8 = i0(bArr, i3, fVar);
                        i3 = i8;
                        obj4 = fVar.c;
                        break;
                    case 9:
                        i8 = V(e1.c.a(eVar.c.getClass()), bArr, i3, i4, (i10 << 3) | 4, fVar);
                        i3 = i8;
                        obj4 = fVar.c;
                        break;
                    case 10:
                        i8 = W(e1.c.a(eVar.c.getClass()), bArr, i3, i4, fVar);
                        i3 = i8;
                        obj4 = fVar.c;
                        break;
                    case 11:
                        i8 = R(bArr, i3, fVar);
                        i3 = i8;
                        obj4 = fVar.c;
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 16:
                        int m0 = m0(bArr, i3, fVar);
                        i5 = k.b(fVar.a);
                        i3 = m0;
                        obj4 = Integer.valueOf(i5);
                        break;
                    case 17:
                        i7 = o0(bArr, i3, fVar);
                        j2 = k.c(fVar.b);
                        obj4 = Long.valueOf(j2);
                        i3 = i7;
                        break;
                }
                dVar = eVar.f3514d;
                if (!dVar.f3512e) {
                    vVar.a(dVar, obj4);
                } else {
                    int ordinal = dVar.f3511d.ordinal();
                    if ((ordinal == 9 || ordinal == 10) && (g2 = vVar.g(eVar.f3514d)) != null) {
                        obj4 = f.b.f.c0.c(g2, obj4);
                    }
                    vVar.o(eVar.f3514d, obj4);
                }
                return i3;
            }
            i3 = i6;
            i5 = fVar.a;
            obj4 = Integer.valueOf(i5);
            dVar = eVar.f3514d;
            if (!dVar.f3512e) {
            }
            return i3;
        }
        switch (dVar2.f3511d.ordinal()) {
            case 0:
                f.b.f.c oVar = new o();
                i9 = Z(bArr, i3, oVar, fVar);
                cVar2 = oVar;
                break;
            case 1:
                f.b.f.c xVar = new x();
                i9 = c0(bArr, i3, xVar, fVar);
                cVar2 = xVar;
                break;
            case 2:
            case 3:
                f.b.f.c k0Var = new k0();
                i9 = g0(bArr, i3, k0Var, fVar);
                cVar2 = k0Var;
                break;
            case 4:
            case 12:
                f.b.f.c b0Var = new f.b.f.b0();
                i9 = f0(bArr, i3, b0Var, fVar);
                cVar2 = b0Var;
                break;
            case 5:
            case 15:
                f.b.f.c k0Var2 = new k0();
                i9 = b0(bArr, i3, k0Var2, fVar);
                cVar2 = k0Var2;
                break;
            case 6:
            case 14:
                f.b.f.c b0Var2 = new f.b.f.b0();
                i9 = a0(bArr, i3, b0Var2, fVar);
                cVar2 = b0Var2;
                break;
            case 7:
                f.b.f.c hVar = new f.b.f.h();
                i9 = Y(bArr, i3, hVar, fVar);
                cVar2 = hVar;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                StringBuilder h2 = a.h("Type cannot be packed: ");
                h2.append(eVar.f3514d.f3511d);
                throw new IllegalStateException(h2.toString());
            case 13:
                f.b.f.b0 b0Var3 = new f.b.f.b0();
                int f0 = f0(bArr, i3, b0Var3, fVar);
                Object obj8 = cVar.unknownFields;
                if (obj8 != obj3) {
                    obj4 = obj8;
                }
                s1 s1Var = (s1) f.b.f.l1.y(i10, b0Var3, eVar.f3514d.b, obj4, r1Var);
                if (s1Var != null) {
                    cVar.unknownFields = s1Var;
                }
                vVar.o(eVar.f3514d, b0Var3);
                return f0;
            case 16:
                f.b.f.c b0Var4 = new f.b.f.b0();
                i9 = d0(bArr, i3, b0Var4, fVar);
                cVar2 = b0Var4;
                break;
            case 17:
                f.b.f.c k0Var3 = new k0();
                i9 = e0(bArr, i3, k0Var3, fVar);
                cVar2 = k0Var3;
                break;
        }
        vVar.o(eVar.f3514d, cVar2);
        return i9;
    }

    public static Set<c1.b> S0(Map<String, ?> map, String str) {
        c1.b bVar;
        List<?> b2 = i1.b(map, str);
        if (b2 == null) {
            return null;
        }
        EnumSet noneOf = EnumSet.noneOf(c1.b.class);
        for (Object obj : b2) {
            if (obj instanceof Double) {
                Double d2 = (Double) obj;
                int intValue = d2.intValue();
                boolean z = true;
                W1(((double) intValue) == d2.doubleValue(), "Status code %s is not integral", obj);
                bVar = c1.c(intValue).a;
                if (bVar.b != d2.intValue()) {
                    z = false;
                }
                W1(z, "Status code %s is not valid", obj);
            } else if (obj instanceof String) {
                try {
                    bVar = c1.b.valueOf((String) obj);
                } catch (IllegalArgumentException e2) {
                    throw new w("Status code " + obj + " is not valid", e2);
                }
            } else {
                throw new w("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
            }
            noneOf.add(bVar);
        }
        return Collections.unmodifiableSet(noneOf);
    }

    public static final String[] S1(Field[] fieldArr) {
        e.c(fieldArr, "$this$toStringArray");
        ArrayList arrayList = new ArrayList(fieldArr.length);
        for (Field field : fieldArr) {
            arrayList.add(field.getName());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String str = (String) next;
            e.b(str, "it");
            if (j.m.h.a(str, "define_", false)) {
                arrayList2.add(next);
            }
        }
        Object[] array = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public static int T(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static List<Map<String, ?>> T0(Map<String, ?> map) {
        String g2;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            List<?> b2 = i1.b(map, "loadBalancingConfig");
            if (b2 == null) {
                b2 = null;
            } else {
                i1.a(b2);
            }
            arrayList.addAll(b2);
        }
        if (arrayList.isEmpty() && (g2 = i1.g(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(g2.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static f.b.b.a.k T1(Object obj) {
        return new f.b.b.a.k(obj.getClass().getSimpleName(), null);
    }

    public static long U(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static p1 U0(s sVar) {
        return sVar.u().h("__local_write_time__").x();
    }

    public static List<s2> U1(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, ?> map : list) {
            if (map.size() == 1) {
                String key = map.entrySet().iterator().next().getKey();
                arrayList.add(new s2(key, i1.f(map, key)));
            } else {
                StringBuilder h2 = a.h("There are ");
                h2.append(map.size());
                h2.append(" fields in a LoadBalancingConfig object. Exactly one is expected. Config=");
                h2.append(map);
                throw new RuntimeException(h2.toString());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static int V(j1 j1Var, byte[] bArr, int i2, int i3, int i4, f fVar) {
        v0 v0Var = (v0) j1Var;
        Object g2 = v0Var.g();
        int K = v0Var.K(g2, bArr, i2, i3, i4, fVar);
        v0Var.i(g2);
        fVar.c = g2;
        return K;
    }

    public static float V0(View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            AtomicInteger atomicInteger = m.a;
            f2 += ((View) parent).getElevation();
        }
        return f2;
    }

    public static PorterDuffColorFilter V1(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static int W(j1 j1Var, byte[] bArr, int i2, int i3, f fVar) {
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        byte b3 = b2;
        if (b2 < 0) {
            i4 = l0(b2, bArr, i4, fVar);
            b3 = fVar.a;
        }
        if (b3 < 0 || b3 > i3 - i4) {
            throw d0.h();
        }
        Object g2 = j1Var.g();
        int i5 = (b3 == 1 ? 1 : 0) + i4;
        j1Var.e(g2, bArr, i4, i5, fVar);
        j1Var.i(g2);
        fVar.c = g2;
        return i5;
    }

    public static final String W0(Context context, String str) {
        e.c(context, "$this$getStringResourceByName");
        e.c(str, "aString");
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier == 0) {
            return "";
        }
        String string = context.getString(identifier);
        e.b(string, "getString(resId)");
        return string;
    }

    public static void W1(boolean z, String str, Object obj) {
        if (!z) {
            throw new w(t.b(str, obj));
        }
    }

    public static int X(j1<?> j1Var, int i2, byte[] bArr, int i3, int i4, c0.i<?> iVar, f fVar) {
        int W = W(j1Var, bArr, i3, i4, fVar);
        while (true) {
            iVar.add(fVar.c);
            if (W >= i4) {
                break;
            }
            int m0 = m0(bArr, W, fVar);
            if (i2 != fVar.a) {
                break;
            }
            W = W(j1Var, bArr, m0, i4, fVar);
        }
        return W;
    }

    public static final int X0(Context context, int i2) {
        e.c(context, "$this$getSupportColor");
        return e.i.b.a.a(context, i2);
    }

    public static int X1(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * -862048943), 15)) * 461845907);
    }

    public static int Y(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        f.b.f.h hVar = (f.b.f.h) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            m0 = o0(bArr, m0, fVar);
            hVar.i(fVar.b != 0);
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static final int Y0(Context context, int i2) {
        e.c(context, "$this$getThemeColor");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return 0;
        }
        int i3 = typedValue.resourceId;
        return i3 != 0 ? e.i.b.a.a(context, i3) : typedValue.data;
    }

    public static <T> h<T> Y1(h<T> hVar, long j2) {
        f.b.a.c.i.i iVar = new f.b.a.c.i.i();
        h2 h2Var = new h2(iVar);
        f.b.a.c.i.c0 c0Var = (f.b.a.c.i.c0) hVar;
        Objects.requireNonNull(c0Var);
        c0Var.c(f.b.a.c.i.j.a, h2Var);
        new j2(Looper.getMainLooper()).postDelayed(new i2(iVar), j2);
        return iVar.a;
    }

    public static int Z(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        o oVar = (o) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            oVar.i(Double.longBitsToDouble(U(bArr, m0)));
            m0 += 8;
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static final int Z0(Context context, int i2, int i3) {
        e.c(context, "$this$getThemeColor");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return i3;
        }
        if (typedValue.resourceId == 0) {
            return typedValue.data;
        }
        Resources resources = context.getResources();
        int i4 = typedValue.resourceId;
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i4, context.getTheme()) : resources.getColor(i4);
    }

    public static <TResult> TResult Z1(h<TResult> hVar) {
        if (hVar.n()) {
            return hVar.k();
        }
        if (hVar.l()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(hVar.j());
    }

    public static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) {
        if (!i1(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !i1(b4) && !i1(b5)) {
                int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i2] = (char) ((i3 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
                return;
            }
        }
        throw d0.c();
    }

    public static int a0(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        f.b.f.b0 b0Var = (f.b.f.b0) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            b0Var.i(T(bArr, m0));
            m0 += 4;
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static String a1(long j2) {
        Locale locale = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            return f.b.a.d.l.d0.c("yMMMd", locale).format(new Date(j2));
        }
        AtomicReference<f.b.a.d.l.c0> atomicReference = f.b.a.d.l.d0.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(f.b.a.d.l.d0.e());
        return dateInstance.format(new Date(j2));
    }

    public static String a2(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e2) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String sb2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), (Throwable) e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 9 + name2.length());
                    sb3.append("<");
                    sb3.append(sb2);
                    sb3.append(" threw ");
                    sb3.append(name2);
                    sb3.append(">");
                    str2 = sb3.toString();
                }
            }
            objArr[i3] = str2;
            i3++;
        }
        StringBuilder sb4 = new StringBuilder((length * 16) + str.length());
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i2 >= length2 || (indexOf = str.indexOf("%s", i4)) == -1) {
                sb4.append((CharSequence) str, i4, str.length());
            } else {
                sb4.append((CharSequence) str, i4, indexOf);
                sb4.append(objArr[i2]);
                i4 = indexOf + 2;
                i2++;
            }
        }
        sb4.append((CharSequence) str, i4, str.length());
        if (i2 < length2) {
            sb4.append(" [");
            sb4.append(objArr[i2]);
            for (int i5 = i2 + 1; i5 < objArr.length; i5++) {
                sb4.append(", ");
                sb4.append(objArr[i5]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }

    public static boolean b(byte b2) {
        return b2 >= 0;
    }

    public static int b0(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        k0 k0Var = (k0) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            k0Var.i(U(bArr, m0));
            m0 += 8;
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static void b1(boolean z, String str, Object... objArr) {
        if (!z) {
            z0(str, objArr);
            throw null;
        }
    }

    public static boolean b2(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean c(byte b2) {
        return b2 < -32;
    }

    public static int c0(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        x xVar = (x) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            xVar.i(Float.intBitsToFloat(T(bArr, m0)));
            m0 += 4;
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static int c1(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    public static int c2(int i2, int i3, String str) {
        String str2;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str2 = a2("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else if (i3 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str2 = a2("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static void d(byte b2, byte b3, char[] cArr, int i2) {
        if (b2 < -62 || i1(b3)) {
            throw d0.c();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static int d0(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        f.b.f.b0 b0Var = (f.b.f.b0) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            m0 = m0(bArr, m0, fVar);
            b0Var.i(k.b(fVar.a));
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static <V> u<V> d1(V v) {
        return v == null ? (u<V>) f.b.b.f.a.s.c : new f.b.b.f.a.s(v);
    }

    public static Object d2(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i2);
        throw new NullPointerException(sb.toString());
    }

    public static boolean e(byte b2) {
        return b2 < -16;
    }

    public static int e0(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        k0 k0Var = (k0) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            m0 = o0(bArr, m0, fVar);
            k0Var.i(k.c(fVar.b));
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    @RecentlyNonNull
    public static boolean e1() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static void e2(int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = f2(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = f2(i3, i4, "end index");
            } else {
                str = a2("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void f(byte b2, byte b3, byte b4, char[] cArr, int i2) {
        if (i1(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || i1(b4)))) {
            throw d0.c();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static int f0(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        f.b.f.b0 b0Var = (f.b.f.b0) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            m0 = m0(bArr, m0, fVar);
            b0Var.i(fVar.a);
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static boolean f1(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static String f2(int i2, int i3, String str) {
        if (i2 < 0) {
            return a2("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return a2("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static <V> void g(u<V> uVar, p<? super V> pVar, Executor executor) {
        Objects.requireNonNull(pVar);
        uVar.a(new f.b.b.f.a.q(uVar, pVar), executor);
    }

    public static int g0(byte[] bArr, int i2, c0.i<?> iVar, f fVar) {
        k0 k0Var = (k0) iVar;
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a + m0;
        while (m0 < i3) {
            m0 = o0(bArr, m0, fVar);
            k0Var.i(fVar.b);
        }
        if (m0 == i3) {
            return m0;
        }
        throw d0.h();
    }

    public static boolean g1(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static List<Integer> h(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new f.b.b.e.a(iArr);
    }

    public static f.b.c.k.u.l h0(String str) {
        List list;
        int length = str.length();
        b1(length >= 2, "Invalid path \"%s\"", str);
        if (length == 2) {
            b1(str.charAt(0) == 1 && str.charAt(1) == 1, "Non-empty path \"%s\" had length 2", str);
            list = Collections.emptyList();
        } else {
            int length2 = str.length() - 2;
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < length) {
                int indexOf = str.indexOf(1, i2);
                if (indexOf < 0 || indexOf > length2) {
                    throw new IllegalArgumentException(a.c("Invalid encoded resource path: \"", str, "\""));
                }
                int i3 = indexOf + 1;
                char charAt = str.charAt(i3);
                if (charAt == 1) {
                    String substring = str.substring(i2, indexOf);
                    if (sb.length() != 0) {
                        sb.append(substring);
                        substring = sb.toString();
                        sb.setLength(0);
                    }
                    arrayList.add(substring);
                } else if (charAt == 16) {
                    sb.append(str.substring(i2, indexOf));
                    sb.append((char) 0);
                } else if (charAt == 17) {
                    sb.append(str.substring(i2, i3));
                } else {
                    throw new IllegalArgumentException(a.c("Invalid encoded resource path: \"", str, "\""));
                }
                i2 = indexOf + 2;
            }
            list = arrayList;
        }
        return f.b.c.k.u.l.r(list);
    }

    public static boolean h1(View view) {
        AtomicInteger atomicInteger = m.a;
        return view.getLayoutDirection() == 1;
    }

    public static final <Item extends f.d.b.k<? extends RecyclerView.b0>> void i(f.d.b.r.c<Item> cVar, RecyclerView.b0 b0Var, View view) {
        e.c(cVar, "$this$attachToView");
        e.c(b0Var, "viewHolder");
        e.c(view, "view");
        if (cVar instanceof f.d.b.r.a) {
            view.setOnClickListener(new f.d.b.s.e(cVar, b0Var));
        } else if (cVar instanceof f.d.b.r.d) {
            view.setOnLongClickListener(new f.d.b.s.f(cVar, b0Var));
        } else if (cVar instanceof f.d.b.r.i) {
            view.setOnTouchListener(new f.d.b.s.g(cVar, b0Var));
        } else if (cVar instanceof f.d.b.r.b) {
            ((f.d.b.r.b) cVar).c(view, b0Var);
        }
    }

    public static int i0(byte[] bArr, int i2, f fVar) {
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a;
        if (i3 < 0) {
            throw d0.f();
        } else if (i3 == 0) {
            fVar.c = "";
            return m0;
        } else {
            fVar.c = new String(bArr, m0, i3, f.b.f.c0.a);
            return m0 + i3;
        }
    }

    public static boolean i1(byte b2) {
        return b2 > -65;
    }

    public static <TResult> TResult j(h<TResult> hVar) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            m.h.p(hVar, "Task must not be null");
            if (hVar.m()) {
                return (TResult) Z1(hVar);
            }
            f.b.a.c.i.k kVar = new f.b.a.c.i.k(null);
            Executor executor = f.b.a.c.i.j.b;
            hVar.g(executor, kVar);
            hVar.e(executor, kVar);
            hVar.b(executor, kVar);
            kVar.a.await();
            return (TResult) Z1(hVar);
        }
        throw new IllegalStateException("Must not be called on the main application thread");
    }

    public static int j0(byte[] bArr, int i2, f fVar) {
        int m0 = m0(bArr, i2, fVar);
        int i3 = fVar.a;
        if (i3 < 0) {
            throw d0.f();
        } else if (i3 == 0) {
            fVar.c = "";
            return m0;
        } else {
            fVar.c = w1.b(bArr, m0, i3);
            return m0 + i3;
        }
    }

    public static boolean j1(s sVar) {
        s g2 = sVar.u().g("__type__", null);
        return g2 != null && "server_timestamp".equals(g2.w());
    }

    public static String k(int i2, int i3, String str) {
        if (i2 < 0) {
            return t.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return t.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException(a.q("negative size: ", i3));
        }
    }

    public static int k0(int i2, byte[] bArr, int i3, int i4, s1 s1Var, f fVar) {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int o0 = o0(bArr, i3, fVar);
                s1Var.f(i2, Long.valueOf(fVar.b));
                return o0;
            } else if (i5 == 1) {
                s1Var.f(i2, Long.valueOf(U(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int m0 = m0(bArr, i3, fVar);
                int i6 = fVar.a;
                if (i6 < 0) {
                    throw d0.f();
                } else if (i6 <= bArr.length - m0) {
                    s1Var.f(i2, i6 == 0 ? j.c : j.m(bArr, m0, i6));
                    return m0 + i6;
                } else {
                    throw d0.h();
                }
            } else if (i5 == 3) {
                s1 e2 = s1.e();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int m02 = m0(bArr, i3, fVar);
                    int i9 = fVar.a;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = m02;
                        break;
                    }
                    int k0 = k0(i8, bArr, m02, i4, e2, fVar);
                    i8 = i9;
                    i3 = k0;
                }
                if (i3 > i4 || i8 != i7) {
                    throw d0.g();
                }
                s1Var.f(i2, e2);
                return i3;
            } else if (i5 == 5) {
                s1Var.f(i2, Integer.valueOf(T(bArr, i3)));
                return i3 + 4;
            } else {
                throw d0.b();
            }
        } else {
            throw d0.b();
        }
    }

    @RecentlyNonNull
    public static boolean k1(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (a == null) {
            a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return a.booleanValue();
    }

    public static final void l(List<? extends f.d.b.r.c<? extends f.d.b.k<? extends RecyclerView.b0>>> list, RecyclerView.b0 b0Var) {
        e.c(list, "$this$bind");
        e.c(b0Var, "viewHolder");
        Iterator<? extends f.d.b.r.c<? extends f.d.b.k<? extends RecyclerView.b0>>> it = list.iterator();
        while (it.hasNext()) {
            f.d.b.r.c cVar = (f.d.b.r.c) it.next();
            View a2 = cVar.a(b0Var);
            if (a2 != null) {
                i(cVar, b0Var, a2);
            }
            List<View> b2 = cVar.b(b0Var);
            if (b2 != null) {
                for (View view : b2) {
                    i(cVar, b0Var, view);
                }
            }
        }
    }

    public static int l0(int i2, byte[] bArr, int i3, f fVar) {
        int i4;
        int i5;
        int i6 = i2 & 127;
        int i7 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            i4 = b2 << 7;
        } else {
            int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
            int i9 = i7 + 1;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i5 = b3 << 14;
            } else {
                i6 = i8 | ((b3 & Byte.MAX_VALUE) << 14);
                i7 = i9 + 1;
                byte b4 = bArr[i9];
                if (b4 >= 0) {
                    i4 = b4 << 21;
                } else {
                    i8 = i6 | ((b4 & Byte.MAX_VALUE) << 21);
                    i9 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 >= 0) {
                        i5 = b5 << 28;
                    } else {
                        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i11 = i9 + 1;
                            if (bArr[i9] < 0) {
                                i9 = i11;
                            } else {
                                fVar.a = i10;
                                return i11;
                            }
                        }
                    }
                }
            }
            fVar.a = i8 | i5;
            return i9;
        }
        fVar.a = i6 | i4;
        return i7;
    }

    @RecentlyNonNull
    public static boolean l1(@RecentlyNonNull Context context) {
        if (k1(context)) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (b == null) {
                    b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
                }
                if (!b.booleanValue() || e1()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static final String m(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static int m0(byte[] bArr, int i2, f fVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return l0(b2, bArr, i3, fVar);
        }
        fVar.a = b2;
        return i3;
    }

    public static int m1(int i2, int i3, float f2) {
        return e.i.c.a.a(e.i.c.a.c(i3, Math.round(((float) Color.alpha(i3)) * f2)), i2);
    }

    public static void n(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static int n0(int i2, byte[] bArr, int i3, int i4, c0.i<?> iVar, f fVar) {
        f.b.f.b0 b0Var = (f.b.f.b0) iVar;
        int m0 = m0(bArr, i3, fVar);
        while (true) {
            b0Var.i(fVar.a);
            if (m0 >= i4) {
                break;
            }
            int m02 = m0(bArr, m0, fVar);
            if (i2 != fVar.a) {
                break;
            }
            m0 = m0(bArr, m02, fVar);
        }
        return m0;
    }

    public static float n1(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static void o(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int o0(byte[] bArr, int i2, f fVar) {
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        if (j2 >= 0) {
            fVar.b = j2;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j3 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            b2 = b3;
            i4 = i6;
        }
        fVar.b = j3;
        return i4;
    }

    public static final <T> List<T> o1(T t) {
        List<T> singletonList = Collections.singletonList(t);
        e.b(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static void p(boolean z, String str, char c2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, Character.valueOf(c2)));
        }
    }

    public static float p0(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x005f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [h.a.b1<T>, h.a.b1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ServiceLoader] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.ServiceLoader] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <T> List<T> p1(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, b1<T> b1Var) {
        boolean z;
        ?? r7;
        try {
            Class.forName("android.app.Application", false, classLoader);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            r7 = new ArrayList();
            for (Class<?> cls2 : iterable) {
                try {
                    r7.add(cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Throwable th) {
                    throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
                }
            }
        } else {
            r7 = ServiceLoader.load(cls, classLoader);
            if (!r7.iterator().hasNext()) {
                r7 = ServiceLoader.load(cls);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : r7) {
            if (b1Var.b(obj)) {
                arrayList.add(obj);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new a1(b1Var)));
        return Collections.unmodifiableList(arrayList);
    }

    public static void q(boolean z, String str, int i2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, Integer.valueOf(i2)));
        }
    }

    public static final void q0(View view, int... iArr) {
        e.c(view, "$this$doOnApplySystemWindowInsets");
        e.c(iArr, "gravities");
        view.setOnApplyWindowInsetsListener(new f.d.a.f.c(iArr, new f.d.a.f.a(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom())));
        e.c(view, "$this$requestApplyInsetsWhenAttached");
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new f.d.a.f.d());
        }
    }

    public static final int q1(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    public static void r(boolean z, String str, long j2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, Long.valueOf(j2)));
        }
    }

    public static float r0(Context context, int i2) {
        return TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static l.b.a.w.f r1(l.b.a.b bVar) {
        return new l.b.a.w.h(0, bVar, null);
    }

    public static void s(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, obj));
        }
    }

    public static <B extends f.b.c.k.u.a<B>> String s0(B b2) {
        StringBuilder sb = new StringBuilder();
        int n = b2.n();
        for (int i2 = 0; i2 < n; i2++) {
            if (sb.length() > 0) {
                sb.append((char) 1);
                sb.append((char) 1);
            }
            String i3 = b2.i(i2);
            int length = i3.length();
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = i3.charAt(i4);
                if (charAt == 0) {
                    sb.append((char) 1);
                    charAt = 16;
                } else if (charAt == 1) {
                    sb.append((char) 1);
                    charAt = 17;
                }
                sb.append(charAt);
            }
        }
        sb.append((char) 1);
        sb.append((char) 1);
        return sb.toString();
    }

    /* JADX WARN: Incorrect args count in method signature: <Item::Lf/d/b/k<+Landroidx/recyclerview/widget/RecyclerView$b0;>;>(Lf/d/b/r/c<TItem;>;Landroidx/recyclerview/widget/RecyclerView$b0;)Landroid/view/View; */
    public static View s1(RecyclerView.b0 b0Var) {
        e.c(b0Var, "viewHolder");
        return null;
    }

    public static void t(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(t.b(str, obj, obj2));
        }
    }

    public static boolean t0(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX WARN: Incorrect args count in method signature: <Item::Lf/d/b/k<+Landroidx/recyclerview/widget/RecyclerView$b0;>;>(Lf/d/b/r/c<TItem;>;Landroidx/recyclerview/widget/RecyclerView$b0;)Ljava/util/List<Landroid/view/View;>; */
    public static List t1(RecyclerView.b0 b0Var) {
        e.c(b0Var, "viewHolder");
        return null;
    }

    public static void u(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static final boolean u0(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
    }

    public static PorterDuff.Mode u1(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static <T> void v(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static boolean v0(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static void v1(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = list.get(i2);
            j2 = Math.max(j2, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j2);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static int w(int i2, int i3) {
        String str;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str = t.b("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else if (i3 >= 0) {
            str = t.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException(a.q("negative size: ", i3));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static String w0(j jVar) {
        String str;
        StringBuilder sb = new StringBuilder(jVar.size());
        for (int i2 = 0; i2 < jVar.size(); i2++) {
            int i3 = jVar.i(i2);
            if (i3 == 34) {
                str = "\\\"";
            } else if (i3 == 39) {
                str = "\\'";
            } else if (i3 != 92) {
                switch (i3) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (i3 < 32 || i3 > 126) {
                            sb.append('\\');
                            sb.append((char) (((i3 >>> 6) & 3) + 48));
                            sb.append((char) (((i3 >>> 3) & 7) + 48));
                            i3 = (i3 & 7) + 48;
                        }
                        sb.append((char) i3);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static final void w1(StringBuilder sb, int i2, String str, Object obj) {
        String w0;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                w1(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                w1(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                w0 = w0(j.n((String) obj));
            } else if (obj instanceof j) {
                sb.append(": \"");
                w0 = w0((j) obj);
            } else {
                if (obj instanceof z) {
                    sb.append(" {");
                    y1((z) obj, sb, i2 + 2);
                    sb.append("\n");
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry2 = (Map.Entry) obj;
                    int i5 = i2 + 2;
                    w1(sb, i5, "key", entry2.getKey());
                    w1(sb, i5, "value", entry2.getValue());
                    sb.append("\n");
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                    return;
                }
                sb.append("}");
                return;
            }
            sb.append(w0);
            sb.append('\"');
        }
    }

    public static Object x(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(a.q("at index ", i2));
    }

    public static final Boolean x0(Context context, Boolean bool, String str) {
        e.c(context, "$this$extractBooleanBundleOrResource");
        e.c(str, "resName");
        if (bool != null) {
            return bool;
        }
        String W0 = W0(context, str);
        if (W0.length() > 0) {
            try {
                return Boolean.valueOf(Boolean.parseBoolean(W0));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Context x1(g.a.a.c.d.a aVar) {
        Context context = aVar.a;
        Objects.requireNonNull(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }

    public static void y(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    public static final String y0(Context context, String str, String str2) {
        e.c(context, "$this$extractStringBundleOrResource");
        e.c(str2, "resName");
        if (str != null) {
            return str;
        }
        String W0 = W0(context, str2);
        if (W0.length() > 0) {
            return W0;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ca, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01db, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ed, code lost:
        if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L_0x021d;
     */
    public static void y1(t0 t0Var, StringBuilder sb, int i2) {
        Object obj;
        String str;
        boolean z;
        Object obj2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = t0Var.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String substring = str2.startsWith("get") ? str2.substring(3) : str2;
            boolean z2 = true;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String str3 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 4);
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    str = m(str3);
                    obj = z.invokeOrDie(method2, t0Var, new Object[0]);
                    w1(sb, i2, str, obj);
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    w1(sb, i2, m(str4), z.invokeOrDie(method3, t0Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    StringBuilder h2 = a.h("get");
                    h2.append(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(h2.toString())) {
                    }
                }
                String str5 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    obj = z.invokeOrDie(method4, t0Var, new Object[0]);
                    if (method5 == null) {
                        if (obj instanceof Boolean) {
                            z = !((Boolean) obj).booleanValue();
                        } else {
                            if (!(obj instanceof Integer)) {
                                if (!(obj instanceof Float)) {
                                    if (!(obj instanceof Double)) {
                                        if (obj instanceof String) {
                                            obj2 = "";
                                        } else if (obj instanceof j) {
                                            obj2 = j.c;
                                        } else {
                                            z = !(obj instanceof t0) ? false : false;
                                        }
                                        z = obj.equals(obj2);
                                    }
                                }
                            }
                            z = true;
                        }
                        if (z) {
                            z2 = false;
                        }
                    } else {
                        z2 = ((Boolean) z.invokeOrDie(method5, t0Var, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        str = m(str5);
                        w1(sb, i2, str, obj);
                    }
                }
            }
        }
        if (t0Var instanceof z.c) {
            Iterator<Map.Entry<z.d, Object>> l2 = ((z.c) t0Var).extensions.l();
            while (l2.hasNext()) {
                Map.Entry<z.d, Object> next = l2.next();
                StringBuilder h3 = a.h("[");
                h3.append(next.getKey().c);
                h3.append("]");
                w1(sb, i2, h3.toString(), next.getValue());
            }
        }
        s1 s1Var = ((z) t0Var).unknownFields;
        if (s1Var != null) {
            for (int i3 = 0; i3 < s1Var.a; i3++) {
                w1(sb, i2, String.valueOf(s1Var.b[i3] >>> 3), s1Var.c[i3]);
            }
        }
    }

    public static int z(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    public static AssertionError z0(String str, Object... objArr) {
        StringBuilder h2 = a.h("INTERNAL ASSERTION FAILED: ");
        h2.append(String.format(str, objArr));
        throw new AssertionError(h2.toString());
    }

    public static Executor z1(Executor executor, f.b.b.f.a.b<?> bVar) {
        Objects.requireNonNull(executor);
        return executor == f.b.b.f.a.k.INSTANCE ? executor : new y(executor, bVar);
    }
}
