package b.i.h;

import android.os.LocaleList;
import java.util.Locale;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final LocaleList f1770a;

    public e(LocaleList localeList) {
        this.f1770a = localeList;
    }

    @Override // b.i.h.d
    public Object a() {
        return this.f1770a;
    }

    public boolean equals(Object obj) {
        return this.f1770a.equals(((d) obj).a());
    }

    @Override // b.i.h.d
    public Locale get(int i) {
        return this.f1770a.get(i);
    }

    public int hashCode() {
        return this.f1770a.hashCode();
    }

    public String toString() {
        return this.f1770a.toString();
    }
}
