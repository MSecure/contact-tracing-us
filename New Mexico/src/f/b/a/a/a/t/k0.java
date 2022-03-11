package f.b.a.a.a.t;

import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import f.b.b.b.e;
import f.b.b.b.i;
import f.b.b.b.j;
/* loaded from: classes.dex */
public abstract class k0<T> extends LiveData<T> {

    /* renamed from: l */
    public final SharedPreferences f2392l;
    public final e<String> m;
    public final SharedPreferences.OnSharedPreferenceChangeListener n = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: f.b.a.a.a.t.o
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            k0 k0Var = k0.this;
            if (k0Var.m.contains(str)) {
                k0Var.m();
            }
        }
    };

    public k0(SharedPreferences sharedPreferences, String... strArr) {
        e<String> eVar;
        this.f2392l = sharedPreferences;
        int i2 = e.f3389d;
        int length = strArr.length;
        if (length == 0) {
            eVar = i.f3407j;
        } else if (length != 1) {
            eVar = e.p(strArr.length, (Object[]) strArr.clone());
        } else {
            eVar = new j<>(strArr[0]);
        }
        this.m = eVar;
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        m();
        this.f2392l.registerOnSharedPreferenceChangeListener(this.n);
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        this.f2392l.unregisterOnSharedPreferenceChangeListener(this.n);
    }

    public abstract void m();
}
