package e.z.x.t;

import android.content.Context;
import android.os.PowerManager;
import f.a.a.a.a;
import java.util.WeakHashMap;

public class l {
    public static final String a = e.z.l.e("WakeLocks");
    public static final WeakHashMap<PowerManager.WakeLock, String> b = new WeakHashMap<>();

    public static PowerManager.WakeLock a(Context context, String str) {
        String c = a.c("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, c);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = b;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, c);
        }
        return newWakeLock;
    }
}
