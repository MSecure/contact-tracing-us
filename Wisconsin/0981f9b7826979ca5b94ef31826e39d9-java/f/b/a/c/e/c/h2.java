package f.b.a.c.e.c;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class h2 {
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f2500d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f2501e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f2502f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, Boolean> f2503g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap<String, Integer> f2504h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static final HashMap<String, Long> f2505i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public static final HashMap<String, Float> f2506j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    public static Object f2507k;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f2508l;
    public static String[] m = new String[0];

    public static void a(ContentResolver contentResolver) {
        if (f2502f == null) {
            f2501e.set(false);
            f2502f = new HashMap<>();
            f2507k = new Object();
            f2508l = false;
            contentResolver.registerContentObserver(a, true, new i2());
        } else if (f2501e.getAndSet(false)) {
            f2502f.clear();
            f2503g.clear();
            f2504h.clear();
            f2505i.clear();
            f2506j.clear();
            f2507k = new Object();
            f2508l = false;
        }
    }

    public static void b(Object obj, String str, String str2) {
        synchronized (h2.class) {
            if (obj == f2507k) {
                f2502f.put(str, str2);
            }
        }
    }
}
