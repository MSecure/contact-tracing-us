package e.c0.a0.t;

import android.content.Context;
import android.os.PowerManager;
import e.c0.n;
import f.a.a.a.a;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class m {
    public static final String a = n.e("WakeLocks");
    public static final WeakHashMap<PowerManager.WakeLock, String> b = new WeakHashMap<>();

    public static PowerManager.WakeLock a(Context context, String str) {
        String x = a.x("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, x);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = b;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, x);
        }
        return newWakeLock;
    }
}
