package f.b.a.a.a.h;

import android.content.SharedPreferences;

public class j extends p<Boolean> {
    public final String o;

    public j(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
        this.o = str;
    }

    @Override // f.b.a.a.a.h.p
    public void m() {
        l(Boolean.valueOf(this.f2095l.contains(this.o)));
    }
}
