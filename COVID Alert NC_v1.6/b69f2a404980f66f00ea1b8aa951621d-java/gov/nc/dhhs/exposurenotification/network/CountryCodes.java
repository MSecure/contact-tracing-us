package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import android.telephony.TelephonyManager;
import c.b.b.a.k;
import c.b.b.b.c;
import java.util.List;

public class CountryCodes {
    public static final String DEFAULT_COUNTRY = "US";
    public final TelephonyManager telephonyManager;

    public CountryCodes(Context context) {
        this.telephonyManager = (TelephonyManager) context.getSystemService("phone");
    }

    public List<String> getExposureRelevantCountryCodes() {
        String upperCase = this.telephonyManager.getNetworkCountryIso().toUpperCase();
        if (k.c(upperCase)) {
            upperCase = DEFAULT_COUNTRY;
        }
        return c.x(upperCase);
    }

    public String getHomeCountryCode() {
        return DEFAULT_COUNTRY;
    }
}
