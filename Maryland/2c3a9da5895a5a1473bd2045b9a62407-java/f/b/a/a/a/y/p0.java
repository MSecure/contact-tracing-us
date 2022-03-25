package f.b.a.a.a.y;

import f.a.a.a.a;

public abstract class p0 {
    public static p0 a(long j2, double d2) {
        Long valueOf = Long.valueOf(j2);
        Double valueOf2 = Double.valueOf(d2);
        String str = valueOf == null ? " dateDaysSinceEpoch" : "";
        if (valueOf2 == null) {
            str = a.t(str, " exposureScore");
        }
        if (str.isEmpty()) {
            return new m(valueOf.longValue(), valueOf2.doubleValue(), null);
        }
        throw new IllegalStateException(a.t("Missing required properties:", str));
    }

    public abstract long b();

    public abstract double c();
}
