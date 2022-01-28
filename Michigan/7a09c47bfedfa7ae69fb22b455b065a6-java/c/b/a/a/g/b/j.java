package c.b.a.a.g.b;

import android.content.SharedPreferences;

public final class j extends e<Boolean> {
    public j(o oVar, String str, Boolean bool) {
        super(oVar, str, bool, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.a.a.g.b.e
    public final Boolean b(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.f3251b, false));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f3251b);
            if (valueOf.length() != 0) {
                "Invalid boolean value in SharedPreferences for ".concat(valueOf);
            } else {
                new String("Invalid boolean value in SharedPreferences for ");
            }
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.a.a.g.b.e
    public final /* synthetic */ Boolean f(String str) {
        if (i5.f3323c.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (i5.f3324d.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String.valueOf(this.f3251b).length();
        str.length();
        return null;
    }
}
