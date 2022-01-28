package f.b.a.a.a.i;

import android.content.SharedPreferences;

public class o extends z<Boolean> {
    public final String o;
    public final boolean p;

    public o(SharedPreferences sharedPreferences, String str, boolean z) {
        super(sharedPreferences, str);
        this.o = str;
        this.p = z;
    }

    @Override // f.b.a.a.a.i.z
    public void m() {
        l(Boolean.valueOf(this.f2151l.getBoolean(this.o, this.p)));
    }
}
