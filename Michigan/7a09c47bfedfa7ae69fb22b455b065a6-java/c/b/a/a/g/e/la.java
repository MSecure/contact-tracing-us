package c.b.a.a.g.e;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class la {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f3645a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f3646b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f3647c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f3648d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f3649e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f3650f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, Boolean> f3651g = new HashMap<>();
    public static final HashMap<String, Integer> h = new HashMap<>();
    public static final HashMap<String, Long> i = new HashMap<>();
    public static final HashMap<String, Float> j = new HashMap<>();
    public static Object k;
    public static boolean l;
    public static String[] m = new String[0];

    public static void a(ContentResolver contentResolver) {
        if (f3650f == null) {
            f3649e.set(false);
            f3650f = new HashMap<>();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(f3645a, true, new ka());
        } else if (f3649e.getAndSet(false)) {
            f3650f.clear();
            f3651g.clear();
            h.clear();
            i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    public static void b(Object obj, String str, String str2) {
        synchronized (la.class) {
            if (obj == k) {
                f3650f.put(str, str2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        if (r14 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009f, code lost:
        if (r14 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bd, code lost:
        if (r14 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010e A[SYNTHETIC] */
    public static boolean c(ContentResolver contentResolver, String str) {
        Object obj;
        String str2;
        boolean z;
        Boolean bool;
        String str3;
        synchronized (la.class) {
            a(contentResolver);
            obj = k;
        }
        HashMap<String, Boolean> hashMap = f3651g;
        Boolean bool2 = Boolean.TRUE;
        synchronized (la.class) {
            str2 = null;
            if (hashMap.containsKey(str)) {
                Boolean bool3 = hashMap.get(str);
                if (bool3 != null) {
                    bool2 = bool3;
                }
            } else {
                bool2 = null;
            }
        }
        Boolean bool4 = bool2;
        if (bool4 != null) {
            return bool4.booleanValue();
        }
        synchronized (la.class) {
            a(contentResolver);
            Object obj2 = k;
            z = false;
            if (f3650f.containsKey(str)) {
                str3 = f3650f.get(str);
            } else {
                for (String str4 : m) {
                    if (str.startsWith(str4)) {
                        if (!l || f3650f.isEmpty()) {
                            String[] strArr = m;
                            HashMap<String, String> hashMap2 = f3650f;
                            Cursor query = contentResolver.query(f3646b, null, null, strArr, null);
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
                            hashMap2.putAll(treeMap);
                            l = true;
                            if (f3650f.containsKey(str)) {
                                str3 = f3650f.get(str);
                            }
                        }
                    }
                }
                Cursor query2 = contentResolver.query(f3645a, null, null, new String[]{str}, null);
                if (query2 != null) {
                    try {
                        if (!query2.moveToFirst()) {
                            b(obj2, str, null);
                        } else {
                            String string = query2.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            b(obj2, str, string);
                            if (string != null) {
                                str2 = string;
                            }
                        }
                    } catch (Throwable th) {
                        query2.close();
                        throw th;
                    }
                }
                query2.close();
            }
            str2 = str3;
        }
        if (str2 != null && !str2.equals("")) {
            if (f3647c.matcher(str2).matches()) {
                bool4 = Boolean.TRUE;
            } else if (f3648d.matcher(str2).matches()) {
                bool = Boolean.FALSE;
                HashMap<String, Boolean> hashMap3 = f3651g;
                synchronized (la.class) {
                    if (obj == k) {
                        hashMap3.put(str, bool);
                        f3650f.remove(str);
                    }
                }
                return z;
            }
        }
        bool = bool4;
        z = true;
        HashMap<String, Boolean> hashMap32 = f3651g;
        synchronized (la.class) {
        }
    }
}
