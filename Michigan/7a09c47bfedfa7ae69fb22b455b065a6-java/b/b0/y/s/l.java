package b.b0.y.s;

import android.content.Context;
import android.os.PowerManager;
import b.b0.m;
import c.a.a.a.a;
import java.util.HashMap;
import java.util.WeakHashMap;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1280a = m.e("WakeLocks");

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<PowerManager.WakeLock, String> f1281b = new WeakHashMap<>();

    public static void a() {
        HashMap hashMap = new HashMap();
        synchronized (f1281b) {
            hashMap.putAll(f1281b);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                m.c().f(f1280a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock b(Context context, String str) {
        String q = a.q("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, q);
        synchronized (f1281b) {
            f1281b.put(newWakeLock, q);
        }
        return newWakeLock;
    }
}
