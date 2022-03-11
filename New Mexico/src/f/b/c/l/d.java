package f.b.c.l;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class d {
    public static d b;
    public final SharedPreferences a;

    public d(Context context) {
        this.a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public synchronized boolean a(String str, long j2) {
        if (!this.a.contains(str)) {
            this.a.edit().putLong(str, j2).apply();
            return true;
        } else if (j2 - this.a.getLong(str, -1) < 86400000) {
            return false;
        } else {
            this.a.edit().putLong(str, j2).apply();
            return true;
        }
    }
}
