package c.b.c.a.f0.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import c.b.c.a.l;

public final class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences.Editor f3466a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3467b;

    public e(Context context, String str, String str2) {
        this.f3467b = str;
        Context applicationContext = context.getApplicationContext();
        this.f3466a = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).edit();
    }
}
