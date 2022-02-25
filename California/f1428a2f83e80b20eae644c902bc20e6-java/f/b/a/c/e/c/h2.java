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
    public static final Pattern f2492d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f2493e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f2494f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, Boolean> f2495g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap<String, Integer> f2496h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static final HashMap<String, Long> f2497i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public static final HashMap<String, Float> f2498j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    public static Object f2499k;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f2500l;
    public static String[] m = new String[0];

    public static void a(ContentResolver contentResolver) {
        if (f2494f == null) {
            f2493e.set(false);
            f2494f = new HashMap<>();
            f2499k = new Object();
            f2500l = false;
            contentResolver.registerContentObserver(a, true, new i2());
        } else if (f2493e.getAndSet(false)) {
            f2494f.clear();
            f2495g.clear();
            f2496h.clear();
            f2497i.clear();
            f2498j.clear();
            f2499k = new Object();
            f2500l = false;
        }
    }

    public static void b(Object obj, String str, String str2) {
        synchronized (h2.class) {
            if (obj == f2499k) {
                f2494f.put(str, str2);
            }
        }
    }
}
