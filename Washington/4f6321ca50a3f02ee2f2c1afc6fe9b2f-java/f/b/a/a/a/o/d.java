package f.b.a.a.a.o;

import f.b.a.a.a.o.a;
import f.b.b.a.k;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class d {
    public static final f.b.b.c.a a = f.b.b.c.a.c.e();
    public static final f.b.b.c.a b = f.b.b.c.a.a;
    public static final long c = TimeUnit.MINUTES.toMillis(10);

    public static abstract class a {
        public d a() {
            int i2;
            int i3;
            a.b bVar = (a.b) this;
            Integer num = bVar.f2160d;
            if (num != null) {
                if (num.intValue() > 0) {
                    Integer num2 = bVar.f2160d;
                    if (num2 != null) {
                        i2 = num2.intValue();
                    } else {
                        throw new IllegalStateException("Property \"transmissionRisk\" has not been set");
                    }
                } else {
                    i2 = 1;
                }
                c(i2);
                Integer num3 = bVar.c;
                if (num3 != null) {
                    if (num3.intValue() > 0) {
                        Integer num4 = bVar.c;
                        if (num4 != null) {
                            i3 = num4.intValue();
                        } else {
                            throw new IllegalStateException("Property \"rollingPeriod\" has not been set");
                        }
                    } else {
                        i3 = 144;
                    }
                    b(i3);
                    String str = bVar.a == null ? " key" : "";
                    if (bVar.b == null) {
                        str = f.a.a.a.a.t(str, " intervalNumber");
                    }
                    if (bVar.c == null) {
                        str = f.a.a.a.a.t(str, " rollingPeriod");
                    }
                    if (bVar.f2160d == null) {
                        str = f.a.a.a.a.t(str, " transmissionRisk");
                    }
                    if (str.isEmpty()) {
                        return new a(bVar.a, bVar.b.intValue(), bVar.c.intValue(), bVar.f2160d.intValue(), null);
                    }
                    throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
                }
                throw new IllegalStateException("Property \"rollingPeriod\" has not been set");
            }
            throw new IllegalStateException("Property \"transmissionRisk\" has not been set");
        }

        public abstract a b(int i2);

        public abstract a c(int i2);
    }

    public static class b {
        public final byte[] a;

        public b(byte[] bArr) {
            this.a = (byte[]) bArr.clone();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return Arrays.equals(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public String toString() {
            return Arrays.toString(this.a);
        }
    }

    public abstract int a();

    public abstract b b();

    public byte[] c() {
        return (byte[]) b().a.clone();
    }

    public abstract int d();

    public abstract int e();

    public String toString() {
        k U1 = f.b.a.c.b.o.b.U1(this);
        StringBuilder h2 = f.a.a.a.a.h("[");
        h2.append(a.c(c()));
        h2.append("]");
        U1.d("key:hex", h2.toString());
        U1.d("key:base64", "[" + b.c(c()) + "]");
        U1.a("interval_number", a());
        U1.a("rolling_period", d());
        U1.a("transmission_risk", e());
        return U1.toString();
    }
}
