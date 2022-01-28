package b.i.h;

import c.a.a.a.a;
import java.util.HashSet;
import java.util.Locale;

public final class c implements d {

    /* renamed from: b  reason: collision with root package name */
    public static final Locale[] f1768b = new Locale[0];

    /* renamed from: a  reason: collision with root package name */
    public final Locale[] f1769a;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        b.b("en-Latn");
    }

    public c(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f1769a = f1768b;
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException(a.o("list[", i, "] is null"));
            } else if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                localeArr2[i] = locale2;
                locale2.getLanguage();
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    locale2.getCountry();
                }
                int length = localeArr.length;
                hashSet.add(locale2);
            } else {
                throw new IllegalArgumentException(a.o("list[", i, "] is a repetition"));
            }
        }
        this.f1769a = localeArr2;
    }

    @Override // b.i.h.d
    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        Locale[] localeArr = ((c) obj).f1769a;
        if (this.f1769a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.f1769a;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // b.i.h.d
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f1769a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f1769a;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    public String toString() {
        StringBuilder h = a.h("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f1769a;
            if (i < localeArr.length) {
                h.append(localeArr[i]);
                if (i < this.f1769a.length - 1) {
                    h.append(',');
                }
                i++;
            } else {
                h.append("]");
                return h.toString();
            }
        }
    }
}
