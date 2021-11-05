package e.c.a;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.n;
import e.c.a.w.o;
import e.c.a.x.f;
import gov.nc.dhhs.exposurenotification.BuildConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class q extends p implements e, f, Comparable<q>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentMap<Integer, q> f5000d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentMap<String, q> f5001e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final q f = C(0);
    public static final q g = C(-64800);
    public static final q h = C(64800);

    /* renamed from: b  reason: collision with root package name */
    public final int f5002b;

    /* renamed from: c  reason: collision with root package name */
    public final transient String f5003c;

    public q(int i) {
        String str;
        this.f5002b = i;
        if (i == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = abs / 3600;
            int i3 = (abs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : "");
            sb.append(i2);
            String str2 = ":0";
            sb.append(i3 < 10 ? str2 : ":");
            sb.append(i3);
            int i4 = abs % 60;
            if (i4 != 0) {
                sb.append(i4 >= 10 ? ":" : str2);
                sb.append(i4);
            }
            str = sb.toString();
        }
        this.f5003c = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    public static q A(String str) {
        int i;
        int i2;
        int i3;
        char charAt;
        c.T1(str, "offsetId");
        q qVar = f5001e.get(str);
        if (qVar != null) {
            return qVar;
        }
        int length = str.length();
        if (length == 2) {
            str = str.charAt(0) + "0" + str.charAt(1);
        } else if (length != 3) {
            if (length == 5) {
                i3 = D(str, 1, false);
                i2 = D(str, 3, false);
            } else if (length != 6) {
                if (length == 7) {
                    i3 = D(str, 1, false);
                    i2 = D(str, 3, false);
                    i = D(str, 5, false);
                } else if (length == 9) {
                    i3 = D(str, 1, false);
                    i2 = D(str, 4, true);
                    i = D(str, 7, true);
                } else {
                    throw new a(a.o("Invalid ID for ZoneOffset, invalid format: ", str));
                }
                charAt = str.charAt(0);
                if (charAt != '+' || charAt == '-') {
                    return charAt == '-' ? B(-i3, -i2, -i) : B(i3, i2, i);
                }
                throw new a(a.o("Invalid ID for ZoneOffset, plus/minus not found when expected: ", str));
            } else {
                i3 = D(str, 1, false);
                i2 = D(str, 4, true);
            }
            i = 0;
            charAt = str.charAt(0);
            if (charAt != '+') {
            }
            if (charAt == '-') {
            }
        }
        i3 = D(str, 1, false);
        i2 = 0;
        i = 0;
        charAt = str.charAt(0);
        if (charAt != '+') {
        }
        if (charAt == '-') {
        }
    }

    public static q B(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new a(a.m("Zone offset hours not in valid range: value ", i, " is not in the range -18 to 18"));
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new a("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new a("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new a("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i2) > 59) {
            StringBuilder g2 = a.g("Zone offset minutes not in valid range: abs(value) ");
            g2.append(Math.abs(i2));
            g2.append(" is not in the range 0 to 59");
            throw new a(g2.toString());
        } else if (Math.abs(i3) > 59) {
            StringBuilder g3 = a.g("Zone offset seconds not in valid range: abs(value) ");
            g3.append(Math.abs(i3));
            g3.append(" is not in the range 0 to 59");
            throw new a(g3.toString());
        } else if (Math.abs(i) != 18 || (Math.abs(i2) <= 0 && Math.abs(i3) <= 0)) {
            return C((i2 * 60) + (i * 3600) + i3);
        } else {
            throw new a("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static q C(int i) {
        if (Math.abs(i) > 64800) {
            throw new a("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i % BuildConfig.ATTENUATION_THRESHOLD != 0) {
            return new q(i);
        } else {
            Integer valueOf = Integer.valueOf(i);
            q qVar = f5000d.get(valueOf);
            if (qVar != null) {
                return qVar;
            }
            f5000d.putIfAbsent(valueOf, new q(i));
            q qVar2 = f5000d.get(valueOf);
            f5001e.putIfAbsent(qVar2.f5003c, qVar2);
            return qVar2;
        }
    }

    public static int D(CharSequence charSequence, int i, boolean z) {
        if (!z || charSequence.charAt(i - 1) == ':') {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence.charAt(i + 1);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
                throw new a("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
            }
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new a("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
    }

    public static q E(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? C(dataInput.readInt()) : C(readByte * 900);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 8, this);
    }

    public static q z(e eVar) {
        q qVar = (q) eVar.f(k.f5181e);
        if (qVar != null) {
            return qVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain ZoneOffset from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(a.d(eVar, sb));
    }

    public void F(DataOutput dataOutput) {
        int i = this.f5002b;
        int i2 = i % BuildConfig.ATTENUATION_THRESHOLD == 0 ? i / BuildConfig.ATTENUATION_THRESHOLD : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    @Override // e.c.a.w.e
    public o b(j jVar) {
        if (jVar == e.c.a.w.a.OFFSET_SECONDS) {
            return jVar.k();
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.n(this);
        }
        throw new n(a.c("Unsupported field: ", jVar));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(q qVar) {
        return qVar.f5002b - this.f5002b;
    }

    @Override // e.c.a.w.e
    public int d(j jVar) {
        if (jVar == e.c.a.w.a.OFFSET_SECONDS) {
            return this.f5002b;
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return b(jVar).a(l(jVar), jVar);
        }
        throw new n(a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.p
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f5002b == ((q) obj).f5002b;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: e.c.a.q */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5181e || lVar == k.f5180d) {
            return this;
        }
        if (lVar == k.f || lVar == k.g || lVar == k.f5179c || lVar == k.f5178b || lVar == k.f5177a) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // e.c.a.p
    public int hashCode() {
        return this.f5002b;
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar == e.c.a.w.a.OFFSET_SECONDS : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (jVar == e.c.a.w.a.OFFSET_SECONDS) {
            return (long) this.f5002b;
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        throw new a(a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(e.c.a.w.a.OFFSET_SECONDS, (long) this.f5002b);
    }

    @Override // e.c.a.p
    public String toString() {
        return this.f5003c;
    }

    @Override // e.c.a.p
    public String u() {
        return this.f5003c;
    }

    @Override // e.c.a.p
    public e.c.a.x.f v() {
        c.T1(this, "offset");
        return new f.a(this);
    }

    @Override // e.c.a.p
    public void y(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        F(dataOutput);
    }
}
