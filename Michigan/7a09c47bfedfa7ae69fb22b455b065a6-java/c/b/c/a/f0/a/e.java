package c.b.c.a.f0.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import c.b.c.a.l;

public final class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences.Editor f4818a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4819b;

    public e(Context context, String str, String str2) {
        this.f4819b = str;
        Context applicationContext = context.getApplicationContext();
        this.f4818a = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).edit();
    }
}
