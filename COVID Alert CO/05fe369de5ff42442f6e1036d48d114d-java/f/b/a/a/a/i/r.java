package f.b.a.a.a.i;

import android.content.SharedPreferences;

public class r extends z<Boolean> {
    public final String o;

    public r(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
        this.o = str;
    }

    @Override // f.b.a.a.a.i.z
    public void m() {
        l(Boolean.valueOf(this.f2151l.contains(this.o)));
    }
}
