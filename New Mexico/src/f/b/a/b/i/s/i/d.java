package f.b.a.b.i.s.i;

import f.a.a.a.a;
/* loaded from: classes.dex */
public abstract class d {
    public static final d a;

    static {
        Long l2 = 10485760L;
        Integer num = 200;
        Integer num2 = 10000;
        Long l3 = 604800000L;
        Integer num3 = 81920;
        String str = l2 == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            str = a.x(str, " loadBatchSize");
        }
        if (num2 == null) {
            str = a.x(str, " criticalSectionEnterTimeoutMs");
        }
        if (l3 == null) {
            str = a.x(str, " eventCleanUpAge");
        }
        if (num3 == null) {
            str = a.x(str, " maxBlobByteSizePerRow");
        }
        if (str.isEmpty()) {
            a = new a(l2.longValue(), num.intValue(), num2.intValue(), l3.longValue(), num3.intValue(), null);
            return;
        }
        throw new IllegalStateException(a.x("Missing required properties:", str));
    }

    public abstract int a();

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract long e();
}
