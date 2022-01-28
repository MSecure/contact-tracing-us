package f.b.a.a.a.i;

import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import f.b.b.b.e;
import f.b.b.b.i;
import f.b.b.b.j;

public abstract class z<T> extends LiveData<T> {

    /* renamed from: l  reason: collision with root package name */
    public final SharedPreferences f2151l;
    public final e<String> m;
    public final SharedPreferences.OnSharedPreferenceChangeListener n = new f(this);

    public z(SharedPreferences sharedPreferences, String... strArr) {
        e<String> eVar;
        this.f2151l = sharedPreferences;
        int i2 = e.f3071d;
        int length = strArr.length;
        if (length == 0) {
            eVar = i.f3089j;
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
        this.f2151l.registerOnSharedPreferenceChangeListener(this.n);
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        this.f2151l.unregisterOnSharedPreferenceChangeListener(this.n);
    }

    public abstract void m();
}
