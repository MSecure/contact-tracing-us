package androidx.core.os;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashSet;
import java.util.Locale;
import org.pathcheck.covidsafepaths.BuildConfig;

public final class LocaleListCompatWrapper implements LocaleListInterface {
    public static final Locale EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    public static final Locale[] sEmptyList = new Locale[0];
    public final Locale[] mList;

    static {
        new Locale(BuildConfig.SUPPORTED_LOCALES, "XA");
        new Locale("ar", "XB");
    }

    public LocaleListCompatWrapper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException(GeneratedOutlineSupport.outline6("list[", i, "] is null"));
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
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline6("list[", i, "] is a repetition"));
            }
        }
        this.mList = localeArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.mList;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                outline17.append(localeArr[i]);
                if (i < this.mList.length - 1) {
                    outline17.append(',');
                }
                i++;
            } else {
                outline17.append("]");
                return outline17.toString();
            }
        }
    }
}
