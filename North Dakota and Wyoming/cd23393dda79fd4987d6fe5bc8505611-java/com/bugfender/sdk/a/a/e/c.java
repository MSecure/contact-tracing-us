package com.bugfender.sdk.a.a.e;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

public final class c {
    private c() {
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static int c(int i, int i2, String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(a(i, i2, str));
    }

    public static int d(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(b(i, i2, str));
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(a(str, objArr));
        }
    }

    public static void b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(a(str, objArr));
        }
    }

    public static void a(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Character.valueOf(c)));
        }
    }

    public static void b(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalStateException(a(str, Character.valueOf(c)));
        }
    }

    public static void a(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Integer.valueOf(i)));
        }
    }

    public static void b(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(a(str, Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j)));
        }
    }

    public static void b(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(a(str, Long.valueOf(j)));
        }
    }

    public static void a(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj));
        }
    }

    public static void b(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(a(str, obj));
        }
    }

    public static void a(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void b(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalStateException(a(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void a(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void b(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalStateException(a(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void b(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalStateException(a(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void a(boolean z, String str, char c, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Character.valueOf(c), obj));
        }
    }

    public static void b(boolean z, String str, char c, Object obj) {
        if (!z) {
            throw new IllegalStateException(a(str, Character.valueOf(c), obj));
        }
    }

    public static void a(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void b(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalStateException(a(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void a(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void b(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalStateException(a(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void a(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void b(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalStateException(a(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void a(boolean z, String str, int i, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Integer.valueOf(i), obj));
        }
    }

    public static void b(boolean z, String str, int i, Object obj) {
        if (!z) {
            throw new IllegalStateException(a(str, Integer.valueOf(i), obj));
        }
    }

    public static void a(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void b(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalStateException(a(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void a(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void b(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalStateException(a(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void b(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalStateException(a(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void a(boolean z, String str, long j, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j), obj));
        }
    }

    public static void b(boolean z, String str, long j, Object obj) {
        if (!z) {
            throw new IllegalStateException(a(str, Long.valueOf(j), obj));
        }
    }

    public static void a(boolean z, String str, Object obj, char c) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, Character.valueOf(c)));
        }
    }

    public static void b(boolean z, String str, Object obj, char c) {
        if (!z) {
            throw new IllegalStateException(a(str, obj, Character.valueOf(c)));
        }
    }

    public static void a(boolean z, String str, Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, Integer.valueOf(i)));
        }
    }

    public static void b(boolean z, String str, Object obj, int i) {
        if (!z) {
            throw new IllegalStateException(a(str, obj, Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, String str, Object obj, long j) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, Long.valueOf(j)));
        }
    }

    public static void b(boolean z, String str, Object obj, long j) {
        if (!z) {
            throw new IllegalStateException(a(str, obj, Long.valueOf(j)));
        }
    }

    public static void a(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, obj2));
        }
    }

    public static void b(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalStateException(a(str, obj, obj2));
        }
    }

    public static void a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, obj2, obj3));
        }
    }

    public static void b(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (!z) {
            throw new IllegalStateException(a(str, obj, obj2, obj3));
        }
    }

    public static void a(boolean z, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, obj2, obj3, obj4));
        }
    }

    public static void b(boolean z, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z) {
            throw new IllegalStateException(a(str, obj, obj2, obj3, obj4));
        }
    }

    public static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int b(int i, int i2) {
        return d(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private static String b(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }

    public static <T> T a(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, objArr));
    }

    public static <T> T a(T t, String str, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Character.valueOf(c)));
    }

    public static <T> T a(T t, String str, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Integer.valueOf(i)));
    }

    public static <T> T a(T t, String str, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Long.valueOf(j)));
    }

    public static <T> T a(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj));
    }

    public static <T> T a(T t, String str, char c, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Character.valueOf(c), Character.valueOf(c2)));
    }

    public static <T> T a(T t, String str, char c, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Character.valueOf(c), Integer.valueOf(i)));
    }

    public static <T> T a(T t, String str, char c, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Character.valueOf(c), Long.valueOf(j)));
    }

    public static void b(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(a(i, i2, i3));
        }
    }

    public static <T> T a(T t, String str, char c, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Character.valueOf(c), obj));
    }

    public static <T> T a(T t, String str, int i, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Integer.valueOf(i), Character.valueOf(c)));
    }

    public static <T> T a(T t, String str, int i, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static <T> T a(T t, String str, int i, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Integer.valueOf(i), Long.valueOf(j)));
    }

    public static <T> T a(T t, String str, int i, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Integer.valueOf(i), obj));
    }

    public static <T> T a(T t, String str, long j, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Long.valueOf(j), Character.valueOf(c)));
    }

    public static <T> T a(T t, String str, long j, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Long.valueOf(j), Integer.valueOf(i)));
    }

    public static <T> T a(T t, String str, long j, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Long.valueOf(j), Long.valueOf(j2)));
    }

    public static <T> T a(T t, String str, long j, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, Long.valueOf(j), obj));
    }

    public static <T> T a(T t, String str, Object obj, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj, Character.valueOf(c)));
    }

    public static <T> T a(T t, String str, Object obj, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj, Integer.valueOf(i)));
    }

    public static <T> T a(T t, String str, Object obj, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj, Long.valueOf(j)));
    }

    public static <T> T a(T t, String str, Object obj, Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj, obj2));
    }

    public static <T> T a(T t, String str, Object obj, Object obj2, Object obj3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj, obj2, obj3));
    }

    public static <T> T a(T t, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj, obj2, obj3, obj4));
    }

    public static int a(int i, int i2) {
        return c(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    private static String a(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }

    private static String a(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return b(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return b(i2, i3, "end index");
        }
        return a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String a(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i2)) != -1) {
            sb.append((CharSequence) valueOf, i2, indexOf);
            sb.append(objArr[i]);
            i2 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i2, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < objArr.length; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
