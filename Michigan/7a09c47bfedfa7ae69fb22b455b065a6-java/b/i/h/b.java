package b.i.h;

import android.os.Build;
import android.os.LocaleList;
import c.a.a.a.a;
import java.util.Locale;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public d f1767a;

    static {
        a(new Locale[0]);
    }

    public b(d dVar) {
        this.f1767a = dVar;
    }

    public static b a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new b(new e(new LocaleList(localeArr)));
        }
        return new b(new c(localeArr));
    }

    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException(a.c("Can not parse language tag: [", str, "]"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && this.f1767a.equals(((b) obj).f1767a);
    }

    public int hashCode() {
        return this.f1767a.hashCode();
    }

    public String toString() {
        return this.f1767a.toString();
    }
}
