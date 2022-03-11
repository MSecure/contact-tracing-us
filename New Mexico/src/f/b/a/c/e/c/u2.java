package f.b.a.c.e.c;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class u2 {

    /* renamed from: f */
    public static HashMap<String, String> f2778f;

    /* renamed from: k */
    public static Object f2783k;
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d */
    public static final Pattern f2776d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e */
    public static final AtomicBoolean f2777e = new AtomicBoolean();

    /* renamed from: g */
    public static final HashMap<String, Boolean> f2779g = new HashMap<>();

    /* renamed from: h */
    public static final HashMap<String, Integer> f2780h = new HashMap<>();

    /* renamed from: i */
    public static final HashMap<String, Long> f2781i = new HashMap<>();

    /* renamed from: j */
    public static final HashMap<String, Float> f2782j = new HashMap<>();

    /* renamed from: l */
    public static final String[] f2784l = new String[0];

    public static void a(ContentResolver contentResolver) {
        if (f2778f == null) {
            f2777e.set(false);
            f2778f = new HashMap<>();
            f2783k = new Object();
            contentResolver.registerContentObserver(a, true, new t2());
        } else if (f2777e.getAndSet(false)) {
            f2778f.clear();
            f2779g.clear();
            f2780h.clear();
            f2781i.clear();
            f2782j.clear();
            f2783k = new Object();
        }
    }

    public static void b(Object obj, String str, String str2) {
        synchronized (u2.class) {
            if (obj == f2783k) {
                f2778f.put("gms:nearby:requires_gms_check", str2);
            }
        }
    }
}
