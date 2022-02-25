package f.b.a.a.a.h;

import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import f.b.b.b.e;
import f.b.b.b.i;
import f.b.b.b.j;

public abstract class p<T> extends LiveData<T> {

    /* renamed from: l  reason: collision with root package name */
    public final SharedPreferences f2075l;
    public final e<String> m;
    public final SharedPreferences.OnSharedPreferenceChangeListener n = new c(this);

    public p(SharedPreferences sharedPreferences, String... strArr) {
        e<String> eVar;
        this.f2075l = sharedPreferences;
        int i2 = e.f2873d;
        int length = strArr.length;
        if (length == 0) {
            eVar = i.f2891j;
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
        this.f2075l.registerOnSharedPreferenceChangeListener(this.n);
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        this.f2075l.unregisterOnSharedPreferenceChangeListener(this.n);
    }

    public abstract void m();
}
