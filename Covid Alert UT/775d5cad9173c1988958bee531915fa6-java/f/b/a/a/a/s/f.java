package f.b.a.a.a.s;

import android.content.SharedPreferences;

public final /* synthetic */ class f implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ y a;

    public /* synthetic */ f(y yVar) {
        this.a = yVar;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        y yVar = this.a;
        if (yVar.m.contains(str)) {
            yVar.m();
        }
    }
}
