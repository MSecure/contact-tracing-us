package f.b.a.a.a.s;

import android.content.SharedPreferences;

public class o extends y<Boolean> {
    public final String o;
    public final boolean p;

    public o(SharedPreferences sharedPreferences, String str, boolean z) {
        super(sharedPreferences, str);
        this.o = str;
        this.p = z;
    }

    @Override // f.b.a.a.a.s.y
    public void m() {
        l(Boolean.valueOf(this.f2345l.getBoolean(this.o, this.p)));
    }
}
