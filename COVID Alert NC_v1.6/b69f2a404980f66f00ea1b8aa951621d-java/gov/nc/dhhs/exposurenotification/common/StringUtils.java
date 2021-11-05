package gov.nc.dhhs.exposurenotification.common;

import c.b.b.c.a;
import e.c.a.p;
import e.c.a.u.c;
import e.c.a.u.d;
import java.security.SecureRandom;
import java.util.Locale;

public final class StringUtils {
    public static final a BASE64 = a.f3351a;
    public static final c LONG_FORMAT;
    public static final c MEDIUM_FORMAT;
    public static final SecureRandom RAND = new SecureRandom();

    static {
        d dVar = new d();
        dVar.h("MMMM dd, YYYY");
        MEDIUM_FORMAT = dVar.q().h(p.w("UTC"));
        d dVar2 = new d();
        dVar2.h("yyyy-MM-dd, HH:mm:ss z");
        LONG_FORMAT = dVar2.q().h(p.w("UTC"));
    }

    public static String epochTimestampToLongUTCDateTimeString(long j, Locale locale) {
        return LONG_FORMAT.g(locale).a(e.c.a.d.v(j));
    }

    public static String epochTimestampToMediumUTCDateString(long j, Locale locale) {
        return MEDIUM_FORMAT.g(locale).a(e.c.a.d.v(j));
    }

    public static String randomBase64Data(int i) {
        byte[] bArr = new byte[((int) (((double) i) * 0.75d))];
        RAND.nextBytes(bArr);
        return BASE64.c(bArr);
    }

    public static String truncateWithEllipsis(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i - 3) + "…";
    }
}
