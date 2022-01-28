package b.z.y.s;

import android.content.Context;
import android.os.PowerManager;
import b.z.m;
import c.a.a.a.a;
import java.util.HashMap;
import java.util.WeakHashMap;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2133a = m.e("WakeLocks");

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<PowerManager.WakeLock, String> f2134b = new WeakHashMap<>();

    public static void a() {
        HashMap hashMap = new HashMap();
        synchronized (f2134b) {
            hashMap.putAll(f2134b);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                m.c().f(f2133a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock b(Context context, String str) {
        String o = a.o("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, o);
        synchronized (f2134b) {
            f2134b.put(newWakeLock, o);
        }
        return newWakeLock;
    }
}
