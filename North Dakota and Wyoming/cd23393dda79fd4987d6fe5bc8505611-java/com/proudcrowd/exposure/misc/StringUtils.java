package com.proudcrowd.exposure.misc;

import com.google.common.io.BaseEncoding;
import java.security.SecureRandom;
import java.util.Locale;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;

public final class StringUtils {
    private static final BaseEncoding BASE64 = BaseEncoding.base64();
    private static final DateTimeFormatter LONG_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss z").withZone(ZoneId.of("UTC"));
    private static final DateTimeFormatter MEDIUM_FORMAT = DateTimeFormatter.ofPattern("MMMM dd, YYYY").withZone(ZoneId.of("UTC"));
    private static final SecureRandom RAND = new SecureRandom();

    private StringUtils() {
    }

    public static String epochTimestampToMediumUTCDateString(long j, Locale locale) {
        return MEDIUM_FORMAT.withLocale(locale).format(Instant.ofEpochMilli(j));
    }

    public static String epochTimestampToLongUTCDateTimeString(long j, Locale locale) {
        return LONG_FORMAT.withLocale(locale).format(Instant.ofEpochMilli(j));
    }

    public static String truncateWithEllipsis(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i - 3) + "…";
    }

    public static String randomBase64Data(int i) {
        byte[] bArr = new byte[((int) (((double) i) * 0.75d))];
        RAND.nextBytes(bArr);
        return BASE64.encode(bArr);
    }
}
