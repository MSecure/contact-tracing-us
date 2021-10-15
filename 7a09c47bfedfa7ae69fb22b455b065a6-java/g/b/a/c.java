package g.b.a;

import b.x.t;
import com.google.android.gms.nearby.messages.Strategy;
import g.b.a.w.i;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

public final class c implements i, Comparable<c>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final c f6400d = new c(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final long f6401b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6402c;

    static {
        BigInteger.valueOf(1000000000);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    public c(long j, int i) {
        this.f6401b = j;
        this.f6402c = i;
    }

    public static c b(long j, int i) {
        return (((long) i) | j) == 0 ? f6400d : new c(j, i);
    }

    public static c d(long j) {
        return b(t.E2(j, Strategy.TTL_SECONDS_MAX), 0);
    }

    public static c f(long j) {
        long j2 = j / 1000;
        int i = (int) (j % 1000);
        if (i < 0) {
            i += 1000;
            j2--;
        }
        return b(j2, i * 1000000);
    }

    public static c i(long j) {
        return b(t.E2(j, 60), 0);
    }

    public static c k(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i += 1000000000;
            j2--;
        }
        return b(j2, i);
    }

    public static c m(long j) {
        return b(j, 0);
    }

    public static c n(long j, long j2) {
        return b(t.D2(j, t.t1(j2, 1000000000)), t.v1(j2, 1000000000));
    }

    public static c p(DataInput dataInput) {
        return n(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 1, this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(c cVar) {
        c cVar2 = cVar;
        int L = t.L(this.f6401b, cVar2.f6401b);
        return L != 0 ? L : this.f6402c - cVar2.f6402c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6401b == cVar.f6401b && this.f6402c == cVar.f6402c;
    }

    public int hashCode() {
        long j = this.f6401b;
        return (this.f6402c * 51) + ((int) (j ^ (j >>> 32)));
    }

    public long r() {
        return this.f6401b / 86400;
    }

    public long s() {
        return t.D2(t.E2(this.f6401b, 1000), (long) (this.f6402c / 1000000));
    }

    public String toString() {
        if (this == f6400d) {
            return "PT0S";
        }
        long j = this.f6401b;
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.f6402c == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i2 >= 0 || this.f6402c <= 0) {
            sb.append(i2);
        } else if (i2 == -1) {
            sb.append("-0");
        } else {
            sb.append(i2 + 1);
        }
        if (this.f6402c > 0) {
            int length = sb.length();
            sb.append(i2 < 0 ? 2000000000 - this.f6402c : this.f6402c + 1000000000);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
