package f.b.b.a;

import f.b.a.c.b.o.b;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class s {
    public boolean a;
    public long b;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[TimeUnit.values().length];
            a = iArr;
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            a[TimeUnit.SECONDS.ordinal()] = 4;
            a[TimeUnit.MINUTES.ordinal()] = 5;
            a[TimeUnit.HOURS.ordinal()] = 6;
            try {
                a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public long a(TimeUnit timeUnit) {
        long j2 = 0;
        if (this.a) {
            m mVar = n.a;
            j2 = 0 + (System.nanoTime() - this.b);
        }
        return timeUnit.convert(j2, TimeUnit.NANOSECONDS);
    }

    public s b() {
        this.a = false;
        return this;
    }

    public s c() {
        b.G(!this.a, "This stopwatch is already running.");
        this.a = true;
        m mVar = n.a;
        this.b = System.nanoTime();
        return this;
    }

    public String toString() {
        long j2;
        String str;
        if (this.a) {
            m mVar = n.a;
            j2 = (System.nanoTime() - this.b) + 0;
        } else {
            j2 = 0;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j2, timeUnit2) <= 0) {
            timeUnit = TimeUnit.HOURS;
            if (timeUnit.convert(j2, timeUnit2) <= 0) {
                timeUnit = TimeUnit.MINUTES;
                if (timeUnit.convert(j2, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.SECONDS;
                    if (timeUnit.convert(j2, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MILLISECONDS;
                        if (timeUnit.convert(j2, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.MICROSECONDS;
                            if (timeUnit.convert(j2, timeUnit2) <= 0) {
                                timeUnit = timeUnit2;
                            }
                        }
                    }
                }
            }
        }
        double convert = ((double) j2) / ((double) timeUnit2.convert(1, timeUnit));
        StringBuilder sb = new StringBuilder();
        m mVar2 = n.a;
        sb.append(String.format(Locale.ROOT, "%.4g", Double.valueOf(convert)));
        sb.append(" ");
        switch (a.a[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        sb.append(str);
        return sb.toString();
    }
}
