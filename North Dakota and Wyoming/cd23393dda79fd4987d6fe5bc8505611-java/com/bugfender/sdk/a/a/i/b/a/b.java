package com.bugfender.sdk.a.a.i.b.a;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class b extends DateFormat {
    private static final long a = 1;
    private static Calendar b = new GregorianCalendar();
    private static NumberFormat c = new DecimalFormat();
    private static b d;

    private b() {
        ((DateFormat) this).numberFormat = c;
        ((DateFormat) this).calendar = b;
    }

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(a.a(date, true));
        return stringBuffer;
    }

    public Date parse(String str, ParsePosition parsePosition) {
        parsePosition.setIndex(str.length());
        return a.a(str);
    }
}
