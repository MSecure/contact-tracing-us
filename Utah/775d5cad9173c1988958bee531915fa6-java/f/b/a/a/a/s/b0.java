package f.b.a.a.a.s;

import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Objects;

public class b0 {
    public final TelephonyManager a;
    public final Resources b;

    public b0(TelephonyManager telephonyManager, Resources resources) {
        this.a = telephonyManager;
        this.b = resources;
    }

    public String a() {
        TelephonyManager telephonyManager = this.a;
        String str = null;
        String simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
        if (TextUtils.isEmpty(simCountryIso)) {
            TelephonyManager telephonyManager2 = this.a;
            if (telephonyManager2 != null) {
                str = telephonyManager2.getNetworkCountryIso();
            }
            simCountryIso = str;
        }
        if (TextUtils.isEmpty(simCountryIso)) {
            simCountryIso = this.b.getConfiguration().locale.getCountry();
        }
        if (TextUtils.isEmpty(simCountryIso)) {
            simCountryIso = Locale.getDefault().getCountry();
        }
        if (TextUtils.isEmpty(simCountryIso)) {
            return "US";
        }
        Objects.requireNonNull(simCountryIso);
        return simCountryIso.toUpperCase(Locale.US);
    }
}
