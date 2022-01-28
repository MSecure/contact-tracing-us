package c.b.a.a.g.b;

import android.content.Context;
import android.os.Build;
import b.x.t;
import c.a.b.o;
import c.b.a.a.c.a;
import c.b.a.a.h.b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class e5 implements a.b {

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f3258b = Charset.forName(o.DEFAULT_PARAMS_ENCODING);

    /* renamed from: c  reason: collision with root package name */
    public static final o f3259c = new o(null, b.a("com.google.android.gms.clearcut.public"), "gms:playlog:service:samplingrules_", "LogSamplingRules__", false, false);

    /* renamed from: d  reason: collision with root package name */
    public static final o f3260d = new o(null, b.a("com.google.android.gms.clearcut.public"), "gms:playlog:service:sampling_", "LogSampling__", false, false);

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentHashMap<String, e<r4>> f3261e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e<String>> f3262f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f3263g = null;
    public static Long h = null;
    public static final e<Boolean> i;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3264a;

    static {
        o oVar = f3259c;
        if (oVar != null) {
            i = e.e(oVar, "enable_log_sampling_rules");
            return;
        }
        throw null;
    }

    public e5(Context context) {
        this.f3264a = context;
        if (context != null && e.h == null) {
            synchronized (e.f3249g) {
                if (Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (e.h != context) {
                    e.i = null;
                }
                e.h = context;
            }
        }
    }

    public static long a(String str, long j) {
        if (str == null || str.isEmpty()) {
            return t.X3(ByteBuffer.allocate(8).putLong(j).array());
        }
        byte[] bytes = str.getBytes(f3258b);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return t.X3(allocate.array());
    }

    public static boolean b(long j, long j2, long j3) {
        if (j2 < 0 || j3 <= 0) {
            return true;
        }
        if (j < 0) {
            j = ((j & Long.MAX_VALUE) % j3) + (Long.MAX_VALUE % j3) + 1;
        }
        return j % j3 < j2;
    }

    public static boolean c(Context context) {
        if (f3263g == null) {
            f3263g = Boolean.valueOf(c.b.a.a.d.p.b.a(context).f3180a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f3263g.booleanValue();
    }

    public static long d(Context context) {
        if (h == null) {
            long j = 0;
            if (context == null) {
                return 0;
            }
            if (c(context)) {
                j = i5.a(context.getContentResolver(), "android_id");
            }
            h = Long.valueOf(j);
        }
        return h.longValue();
    }
}
