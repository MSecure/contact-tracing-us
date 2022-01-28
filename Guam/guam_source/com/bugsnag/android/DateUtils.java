package com.bugsnag.android;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public static final ThreadLocal<DateFormat> iso8601Holder = new ThreadLocal<DateFormat>() {
        /* class com.bugsnag.android.DateUtils.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat;
        }
    };

    public static Date fromIso8601(String str) {
        try {
            return iso8601Holder.get().parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse timestamp", e);
        }
    }

    public static String toIso8601(Date date) {
        DateFormat dateFormat = iso8601Holder.get();
        if (dateFormat != null) {
            return dateFormat.format(date);
        }
        throw new IllegalStateException("Unable to find valid dateformatter");
    }
}
