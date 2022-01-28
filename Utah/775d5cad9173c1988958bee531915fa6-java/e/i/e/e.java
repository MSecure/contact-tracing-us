package e.i.e;

import android.os.LocaleList;
import java.util.Locale;

public final class e implements d {
    public final LocaleList a;

    public e(LocaleList localeList) {
        this.a = localeList;
    }

    @Override // e.i.e.d
    public Object a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this.a.equals(((d) obj).a());
    }

    @Override // e.i.e.d
    public Locale get(int i2) {
        return this.a.get(i2);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
