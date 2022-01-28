package f.b.a.c.e.c;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class u2 {
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f2735d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f2736e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f2737f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, Boolean> f2738g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap<String, Integer> f2739h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static final HashMap<String, Long> f2740i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public static final HashMap<String, Float> f2741j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    public static Object f2742k;

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f2743l = new String[0];

    public static void a(ContentResolver contentResolver) {
        if (f2737f == null) {
            f2736e.set(false);
            f2737f = new HashMap<>();
            f2742k = new Object();
            contentResolver.registerContentObserver(a, true, new t2());
        } else if (f2736e.getAndSet(false)) {
            f2737f.clear();
            f2738g.clear();
            f2739h.clear();
            f2740i.clear();
            f2741j.clear();
            f2742k = new Object();
        }
    }

    public static void b(Object obj, String str, String str2) {
        synchronized (u2.class) {
            if (obj == f2742k) {
                f2737f.put("gms:nearby:requires_gms_check", str2);
            }
        }
    }
}
