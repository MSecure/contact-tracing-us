package c.b.a.b.x;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicReference<z> f4551a = new AtomicReference<>();

    public static long a(long j) {
        Calendar g2 = g();
        g2.setTimeInMillis(j);
        return c(g2).getTimeInMillis();
    }

    @TargetApi(24)
    public static DateFormat b(Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMEd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }

    public static Calendar c(Calendar calendar) {
        Calendar h = h(calendar);
        Calendar g2 = g();
        g2.set(h.get(1), h.get(2), h.get(5));
        return g2;
    }

    public static java.text.DateFormat d(Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(0, locale);
        dateInstance.setTimeZone(e());
        return dateInstance;
    }

    public static java.util.TimeZone e() {
        return java.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar f() {
        z zVar = f4551a.get();
        if (zVar == null) {
            zVar = z.f4630c;
        }
        java.util.TimeZone timeZone = zVar.f4632b;
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = zVar.f4631a;
        if (l != null) {
            instance.setTimeInMillis(l.longValue());
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

    @TargetApi(24)
    public static DateFormat i(Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMEd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }
}
