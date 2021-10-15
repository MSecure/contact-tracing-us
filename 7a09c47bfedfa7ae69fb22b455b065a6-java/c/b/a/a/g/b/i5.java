package c.b.a.a.g.b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class i5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f3321a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f3322b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f3323c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f3324d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f3325e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f3326f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, Boolean> f3327g = new HashMap<>();
    public static final HashMap<String, Integer> h = new HashMap<>();
    public static final HashMap<String, Long> i = new HashMap<>();
    public static final HashMap<String, Float> j = new HashMap<>();
    public static Object k;
    public static boolean l;
    public static String[] m = new String[0];

    public static long a(ContentResolver contentResolver, String str) {
        Object obj;
        synchronized (i5.class) {
            d(contentResolver);
            obj = k;
        }
        long j2 = 0;
        Long l2 = (Long) b(i, str, 0L);
        if (l2 != null) {
            return l2.longValue();
        }
        String c2 = c(contentResolver, str);
        if (c2 != null) {
            try {
                long parseLong = Long.parseLong(c2);
                l2 = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        f(obj, i, str, l2);
        return j2;
    }

    public static <T> T b(HashMap<String, T> hashMap, String str, T t) {
        synchronized (i5.class) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            T t2 = hashMap.get(str);
            if (t2 != null) {
                t = t2;
            }
            return t;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008a, code lost:
        r14 = r14.query(c.b.a.a.g.b.i5.f3321a, null, null, new java.lang.String[]{r15}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        if (r14 == null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        if (r14.moveToFirst() != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        r0 = r14.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a5, code lost:
        if (r0 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ab, code lost:
        if (r0.equals(null) == false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ad, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ae, code lost:
        e(r1, r15, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r0 == null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b3, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b4, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b8, code lost:
        e(r1, r15, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bb, code lost:
        if (r14 == null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bd, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c0, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c1, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c2, code lost:
        if (r14 != null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c7, code lost:
        throw r15;
     */
    public static String c(ContentResolver contentResolver, String str) {
        synchronized (i5.class) {
            d(contentResolver);
            Object obj = k;
            String str2 = null;
            if (f3326f.containsKey(str)) {
                String str3 = f3326f.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
                return str2;
            }
            for (String str4 : m) {
                if (str.startsWith(str4)) {
                    if (!l || f3326f.isEmpty()) {
                        String[] strArr = m;
                        HashMap<String, String> hashMap = f3326f;
                        Cursor query = contentResolver.query(f3322b, null, null, strArr, null);
                        TreeMap treeMap = new TreeMap();
                        if (query != null) {
                            while (query.moveToNext()) {
                                try {
                                    treeMap.put(query.getString(0), query.getString(1));
                                } finally {
                                    query.close();
                                }
                            }
                        }
                        hashMap.putAll(treeMap);
                        l = true;
                        if (f3326f.containsKey(str)) {
                            String str5 = f3326f.get(str);
                            if (str5 != null) {
                                str2 = str5;
                            }
                            return str2;
                        }
                    }
                    return null;
                }
            }
        }
    }

    public static void d(ContentResolver contentResolver) {
        if (f3326f == null) {
            f3325e.set(false);
            f3326f = new HashMap<>();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(f3321a, true, new j5());
        } else if (f3325e.getAndSet(false)) {
            f3326f.clear();
            f3327g.clear();
            h.clear();
            i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    public static void e(Object obj, String str, String str2) {
        synchronized (i5.class) {
            if (obj == k) {
                f3326f.put(str, str2);
            }
        }
    }

    public static <T> void f(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (i5.class) {
            if (obj == k) {
                hashMap.put(str, t);
                f3326f.remove(str);
            }
        }
    }

    public static boolean g(ContentResolver contentResolver, String str, boolean z) {
        Object obj;
        synchronized (i5.class) {
            d(contentResolver);
            obj = k;
        }
        Boolean bool = (Boolean) b(f3327g, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String c2 = c(contentResolver, str);
        if (c2 != null && !c2.equals("")) {
            if (f3323c.matcher(c2).matches()) {
                z = true;
                bool = Boolean.TRUE;
            } else if (f3324d.matcher(c2).matches()) {
                z = false;
                bool = Boolean.FALSE;
            }
        }
        f(obj, f3327g, str, bool);
        return z;
    }
}
