package c.b.c.a.f0.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import b.x.t;
import java.io.CharConversionException;
import java.io.FileNotFoundException;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f4816a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4817b;

    public d(Context context, String str, String str2) {
        this.f4817b = str;
        Context applicationContext = context.getApplicationContext();
        this.f4816a = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0);
    }

    public final byte[] a() {
        try {
            String string = this.f4816a.getString(this.f4817b, null);
            if (string != null) {
                return t.g0(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.f4817b));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.f4817b));
        }
    }
}
