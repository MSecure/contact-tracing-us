package c.b.a.a.g.b;

import android.content.SharedPreferences;

public final class k extends e<String> {
    public k(o oVar, String str, String str2) {
        super(oVar, str, str2, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.a.a.g.b.e
    public final String b(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.f3251b, null);
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f3251b);
            if (valueOf.length() != 0) {
                "Invalid string value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid string value in SharedPreferences for ");
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.a.a.g.b.e
    public final /* synthetic */ String f(String str) {
        return str;
    }
}
