package g.b.a.c.c;

import android.app.Application;
import android.content.Context;
import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.b.a.w;
import g.b.a.c.c.c;
import h.a.a1;
import h.a.b1;
import h.a.c1;
import h.a.j1.h;
import h.a.j1.i1;
import h.a.j1.l1;
import h.a.j1.l2;
import h.a.j1.s2;
import h.a.q;
import j.k.b.e;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import l.b.a.x.f;
/* loaded from: classes.dex */
public final class d implements Object<c.d> {
    public static long A(long j2, long j3) {
        long j4 = j2 - j3;
        if ((j2 ^ j4) >= 0 || (j2 ^ j3) >= 0) {
            return j4;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j2 + " - " + j3);
    }

    public static int B(long j2) {
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return (int) j2;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j2);
    }

    public static final char C(char[] cArr) {
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

    public static c1 D(q qVar) {
        b.A(qVar, "context must not be null");
        if (!qVar.S()) {
            return null;
        }
        Throwable x = qVar.x();
        if (x == null) {
            return c1.f4088g.g("io.grpc.Context was cancelled without error");
        }
        if (x instanceof TimeoutException) {
            return c1.f4090i.g(x.getMessage()).f(x);
        }
        c1 d2 = c1.d(x);
        return (!c1.b.UNKNOWN.equals(d2.a) || d2.c != x) ? d2.f(x) : c1.f4088g.g("Context cancelled").f(x);
    }

    public static List<s2> E(List<Map<String, ?>> list) {
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

    public static <T> void a(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static void b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static final void c(Closeable closeable, Throwable th) {
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
                j.j.b.a.a(th, th2);
            }
        }
    }

    public static int d(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int e(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static l1 f() {
        return l2.f4219e == null ? new l2() : new h();
    }

    public static final boolean g(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    public static boolean h(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static long i(long j2, long j3) {
        return j2 >= 0 ? j2 / j3 : ((j2 + 1) / j3) - 1;
    }

    public static int j(int i2, int i3) {
        return ((i2 % i3) + i3) % i3;
    }

    public static int k(long j2, int i2) {
        long j3 = (long) i2;
        return (int) (((j2 % j3) + j3) % j3);
    }

    public static long l(long j2, long j3) {
        return ((j2 % j3) + j3) % j3;
    }

    public static Object m(Context context) {
        Application v0 = b.v0(context.getApplicationContext());
        boolean z = v0 instanceof g.b.b.b;
        Object[] objArr = {v0.getClass()};
        if (z) {
            return ((g.b.b.b) v0).e();
        }
        throw new IllegalArgumentException(String.format("Hilt BroadcastReceiver must be attached to an @AndroidEntryPoint Application. Found: %s", objArr));
    }

    public static Set<c1.b> n(Map<String, ?> map, String str) {
        c1.b bVar;
        List<?> b = i1.b(map, str);
        if (b == null) {
            return null;
        }
        EnumSet noneOf = EnumSet.noneOf(c1.b.class);
        for (Object obj : b) {
            if (obj instanceof Double) {
                Double d2 = (Double) obj;
                int intValue = d2.intValue();
                boolean z = true;
                b.x1(((double) intValue) == d2.doubleValue(), "Status code %s is not integral", obj);
                bVar = c1.c(intValue).a;
                if (bVar.b != d2.intValue()) {
                    z = false;
                }
                b.x1(z, "Status code %s is not valid", obj);
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

    public static List<Map<String, ?>> o(Map<String, ?> map) {
        String g2;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            List<?> b = i1.b(map, "loadBalancingConfig");
            if (b == null) {
                b = null;
            } else {
                i1.a(b);
            }
            arrayList.addAll(b);
        }
        if (arrayList.isEmpty() && (g2 = i1.g(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(g2.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static final <T> List<T> p(T t) {
        List<T> singletonList = Collections.singletonList(t);
        e.b(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ServiceLoader] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.ServiceLoader] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [h.a.b1<T>, h.a.b1] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static <T> List<T> q(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, b1<T> b1Var) {
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

    public static final int r(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    public static f s(l.b.a.c cVar) {
        return new l.b.a.x.h(0, cVar, null);
    }

    public static Context t(g.b.a.c.d.a aVar) {
        Context context = aVar.a;
        Objects.requireNonNull(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }

    public static <T> T u(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a.x(str, " must not be null"));
    }

    public static int v(int i2, int i3) {
        int i4 = i2 + i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) < 0) {
            return i4;
        }
        throw new ArithmeticException("Addition overflows an int: " + i2 + " + " + i3);
    }

    public static long w(long j2, long j3) {
        long j4 = j2 + j3;
        if ((j2 ^ j4) >= 0 || (j2 ^ j3) < 0) {
            return j4;
        }
        throw new ArithmeticException("Addition overflows a long: " + j2 + " + " + j3);
    }

    public static long x(long j2, int i2) {
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

    public static long y(long j2, long j3) {
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

    public static int z(int i2, int i3) {
        int i4 = i2 - i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) >= 0) {
            return i4;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i2 + " - " + i3);
    }
}
