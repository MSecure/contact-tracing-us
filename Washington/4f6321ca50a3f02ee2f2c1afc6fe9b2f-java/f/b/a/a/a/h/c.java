package f.b.a.a.a.h;

import android.content.SharedPreferences;

public final /* synthetic */ class c implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ p a;

    public /* synthetic */ c(p pVar) {
        this.a = pVar;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        p pVar = this.a;
        if (pVar.m.contains(str)) {
            pVar.m();
        }
    }
}
