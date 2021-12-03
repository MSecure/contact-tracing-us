package f.b.a.a.a.b0;

import f.a.a.a.a;

public abstract class u0 {
    public static u0 a(long j2, double d2) {
        Long valueOf = Long.valueOf(j2);
        Double valueOf2 = Double.valueOf(d2);
        String str = valueOf == null ? " dateDaysSinceEpoch" : "";
        if (valueOf2 == null) {
            str = a.c(str, " exposureScore");
        }
        if (str.isEmpty()) {
            return new n(valueOf.longValue(), valueOf2.doubleValue(), null);
        }
        throw new IllegalStateException(a.c("Missing required properties:", str));
    }

    public abstract long b();

    public abstract double c();
}
