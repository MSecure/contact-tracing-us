package f.b.a.a.a.h;

import android.content.SharedPreferences;

public class h extends p<Boolean> {
    public final String o;
    public final boolean p;

    public h(SharedPreferences sharedPreferences, String str, boolean z) {
        super(sharedPreferences, str);
        this.o = str;
        this.p = z;
    }

    @Override // f.b.a.a.a.h.p
    public void m() {
        l(Boolean.valueOf(this.f2075l.getBoolean(this.o, this.p)));
    }
}
