package f.b.a.a.a.s;

import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import f.b.b.b.e;
import f.b.b.b.i;
import f.b.b.b.j;

public abstract class y<T> extends LiveData<T> {

    /* renamed from: l  reason: collision with root package name */
    public final SharedPreferences f2345l;
    public final e<String> m;
    public final SharedPreferences.OnSharedPreferenceChangeListener n = new f(this);

    public y(SharedPreferences sharedPreferences, String... strArr) {
        e<String> eVar;
        this.f2345l = sharedPreferences;
        int i2 = e.f3134d;
        int length = strArr.length;
        if (length == 0) {
            eVar = i.f3152j;
        } else if (length != 1) {
            eVar = e.p(strArr.length, (Object[]) strArr.clone());
        } else {
            eVar = new j(strArr[0]);
        }
        this.m = eVar;
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        m();
        this.f2345l.registerOnSharedPreferenceChangeListener(this.n);
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        this.f2345l.unregisterOnSharedPreferenceChangeListener(this.n);
    }

    public abstract void m();
}
