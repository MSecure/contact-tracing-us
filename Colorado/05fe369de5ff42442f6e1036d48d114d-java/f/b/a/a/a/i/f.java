package f.b.a.a.a.i;

import android.content.SharedPreferences;

public final /* synthetic */ class f implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ z a;

    public /* synthetic */ f(z zVar) {
        this.a = zVar;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        z zVar = this.a;
        if (zVar.m.contains(str)) {
            zVar.m();
        }
    }
}
