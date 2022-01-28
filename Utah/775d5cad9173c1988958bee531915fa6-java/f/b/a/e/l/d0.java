package f.b.a.e.l;

import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class d0 {
    public static AtomicReference<c0> a = new AtomicReference<>();

    public static long a(long j2) {
        Calendar g2 = g();
        g2.setTimeInMillis(j2);
        return d(g2).getTimeInMillis();
    }

    public static int b(String str, String str2, int i2, int i3) {
        while (i3 >= 0 && i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            if (str.charAt(i3) == '\'') {
                do {
                    i3 += i2;
                    if (i3 < 0 || i3 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i3) != '\'');
            }
            i3 += i2;
        }
        return i3;
    }

    public static DateFormat c(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }

    public static Calendar d(Calendar calendar) {
        Calendar h2 = h(calendar);
        Calendar g2 = g();
        g2.set(h2.get(1), h2.get(2), h2.get(5));
        return g2;
    }

    public static java.util.TimeZone e() {
        return java.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar f() {
        c0 c0Var = a.get();
        if (c0Var == null) {
            c0Var = c0.c;
        }
        java.util.TimeZone timeZone = c0Var.b;
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l2 = c0Var.a;
        if (l2 != null) {
            instance.setTimeInMillis(l2.longValue());
        }
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.setTimeZone(e());
        return instance;
    }

    public static Calendar g() {
        return h(null);
    }

    public static Calendar h(Calendar calendar) {
        Calendar instance = Calendar.getInstance(e());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }
}
