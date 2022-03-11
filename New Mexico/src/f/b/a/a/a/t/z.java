package f.b.a.a.a.t;

import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class z extends k0<Boolean> {
    public final String o;
    public final boolean p;

    public z(SharedPreferences sharedPreferences, String str, boolean z) {
        super(sharedPreferences, str);
        this.o = str;
        this.p = z;
    }

    @Override // f.b.a.a.a.t.k0
    public void m() {
        l(Boolean.valueOf(this.f2392l.getBoolean(this.o, this.p)));
    }
}
