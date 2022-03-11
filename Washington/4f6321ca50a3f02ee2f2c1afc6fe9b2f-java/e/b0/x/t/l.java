package e.b0.x.t;

import android.content.Context;
import android.os.PowerManager;
import f.a.a.a.a;
import java.util.WeakHashMap;

public class l {
    public static final String a = e.b0.l.e("WakeLocks");
    public static final WeakHashMap<PowerManager.WakeLock, String> b = new WeakHashMap<>();

    public static PowerManager.WakeLock a(Context context, String str) {
        String t = a.t("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, t);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = b;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, t);
        }
        return newWakeLock;
    }
}
