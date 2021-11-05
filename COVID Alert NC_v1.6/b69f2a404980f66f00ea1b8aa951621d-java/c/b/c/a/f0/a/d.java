package c.b.c.a.f0.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import c.b.a.a.c.n.c;
import java.io.CharConversionException;
import java.io.FileNotFoundException;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f3464a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3465b;

    public d(Context context, String str, String str2) {
        this.f3465b = str;
        Context applicationContext = context.getApplicationContext();
        this.f3464a = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0);
    }

    public final byte[] a() {
        try {
            String string = this.f3464a.getString(this.f3465b, null);
            if (string != null) {
                return c.I(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.f3465b));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.f3465b));
        }
    }
}
