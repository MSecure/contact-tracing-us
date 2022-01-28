package c.b.a.a.f.d;

import android.content.Context;
import android.content.SharedPreferences;
import b.x.t;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f3206a;

    public static SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f3206a == null) {
                f3206a = (SharedPreferences) t.b4(new f(context));
            }
            sharedPreferences = f3206a;
        }
        return sharedPreferences;
    }
}
