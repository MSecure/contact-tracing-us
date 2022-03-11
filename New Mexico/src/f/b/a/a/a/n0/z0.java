package f.b.a.a.a.n0;

import f.a.a.a.a;
/* loaded from: classes.dex */
public abstract class z0 {
    public static z0 a(long j2, double d2) {
        Long valueOf = Long.valueOf(j2);
        Double valueOf2 = Double.valueOf(d2);
        String str = valueOf == null ? " dateDaysSinceEpoch" : "";
        if (valueOf2 == null) {
            str = a.x(str, " exposureScore");
        }
        if (str.isEmpty()) {
            return new n(valueOf.longValue(), valueOf2.doubleValue(), null);
        }
        throw new IllegalStateException(a.x("Missing required properties:", str));
    }

    public abstract long b();

    public abstract double c();
}
