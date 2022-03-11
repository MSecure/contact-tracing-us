package f.b.a.a.a.t;

import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class c0 extends k0<Boolean> {
    public final String o;

    public c0(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
        this.o = str;
    }

    @Override // f.b.a.a.a.t.k0
    public void m() {
        l(Boolean.valueOf(this.f2392l.contains(this.o)));
    }
}
