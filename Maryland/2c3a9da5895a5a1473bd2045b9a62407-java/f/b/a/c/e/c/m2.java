package f.b.a.c.e.c;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class m2 {
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f2580d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f2581e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f2582f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, Boolean> f2583g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap<String, Integer> f2584h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static final HashMap<String, Long> f2585i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public static final HashMap<String, Float> f2586j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    public static Object f2587k;

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f2588l = new String[0];

    public static void a(ContentResolver contentResolver) {
        if (f2582f == null) {
            f2581e.set(false);
            f2582f = new HashMap<>();
            f2587k = new Object();
            contentResolver.registerContentObserver(a, true, new l2());
        } else if (f2581e.getAndSet(false)) {
            f2582f.clear();
            f2583g.clear();
            f2584h.clear();
            f2585i.clear();
            f2586j.clear();
            f2587k = new Object();
        }
    }

    public static void b(Object obj, String str, String str2) {
        synchronized (m2.class) {
            if (obj == f2587k) {
                f2582f.put("gms:nearby:requires_gms_check", str2);
            }
        }
    }
}
