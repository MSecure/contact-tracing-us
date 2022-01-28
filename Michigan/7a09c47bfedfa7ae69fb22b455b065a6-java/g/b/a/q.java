package g.b.a;

import b.x.t;
import c.a.a.a.a;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import g.b.a.w.o;
import g.b.a.x.f;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class q extends p implements e, f, Comparable<q>, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentMap<Integer, q> f6444e = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: f  reason: collision with root package name */
    public static final ConcurrentMap<String, q> f6445f = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: g  reason: collision with root package name */
    public static final q f6446g = R(0);
    public static final q h = R(-64800);
    public static final q i = R(64800);

    /* renamed from: c  reason: collision with root package name */
    public final int f6447c;

    /* renamed from: d  reason: collision with root package name */
    public final transient String f6448d;

    public q(int i2) {
        String str;
        this.f6447c = i2;
        if (i2 == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i2);
            StringBuilder sb = new StringBuilder();
            int i3 = abs / 3600;
            int i4 = (abs / 60) % 60;
            sb.append(i2 < 0 ? "-" : "+");
            sb.append(i3 < 10 ? "0" : "");
            sb.append(i3);
            String str2 = ":0";
            sb.append(i4 < 10 ? str2 : ":");
            sb.append(i4);
            int i5 = abs % 60;
            if (i5 != 0) {
                sb.append(i5 >= 10 ? ":" : str2);
                sb.append(i5);
            }
            str = sb.toString();
        }
        this.f6448d = str;
    }

    public static q L(e eVar) {
        q qVar = (q) eVar.f(k.f6660e);
        if (qVar != null) {
            return qVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain ZoneOffset from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(a.e(eVar, sb));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    public static q P(String str) {
        int i2;
        int i3;
        int i4;
        char charAt;
        t.y2(str, "offsetId");
        q qVar = f6445f.get(str);
        if (qVar != null) {
            return qVar;
        }
        int length = str.length();
        if (length == 2) {
            str = str.charAt(0) + "0" + str.charAt(1);
        } else if (length != 3) {
            if (length == 5) {
                i4 = S(str, 1, false);
                i3 = S(str, 3, false);
            } else if (length != 6) {
                if (length == 7) {
                    i4 = S(str, 1, false);
                    i3 = S(str, 3, false);
                    i2 = S(str, 5, false);
                } else if (length == 9) {
                    i4 = S(str, 1, false);
                    i3 = S(str, 4, true);
                    i2 = S(str, 7, true);
                } else {
                    throw new a(a.q("Invalid ID for ZoneOffset, invalid format: ", str));
                }
                charAt = str.charAt(0);
                if (charAt != '+' || charAt == '-') {
                    return charAt == '-' ? Q(-i4, -i3, -i2) : Q(i4, i3, i2);
                }
                throw new a(a.q("Invalid ID for ZoneOffset, plus/minus not found when expected: ", str));
            } else {
                i4 = S(str, 1, false);
                i3 = S(str, 4, true);
            }
            i2 = 0;
            charAt = str.charAt(0);
            if (charAt != '+') {
            }
            if (charAt == '-') {
            }
        }
        i4 = S(str, 1, false);
        i3 = 0;
        i2 = 0;
        charAt = str.charAt(0);
        if (charAt != '+') {
        }
        if (charAt == '-') {
        }
    }

    public static q Q(int i2, int i3, int i4) {
        if (i2 < -18 || i2 > 18) {
            throw new a(a.o("Zone offset hours not in valid range: value ", i2, " is not in the range -18 to 18"));
        }
        if (i2 > 0) {
            if (i3 < 0 || i4 < 0) {
                throw new a("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i2 < 0) {
            if (i3 > 0 || i4 > 0) {
                throw new a("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i3 > 0 && i4 < 0) || (i3 < 0 && i4 > 0)) {
            throw new a("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i3) > 59) {
            StringBuilder h2 = a.h("Zone offset minutes not in valid range: abs(value) ");
            h2.append(Math.abs(i3));
            h2.append(" is not in the range 0 to 59");
            throw new a(h2.toString());
        } else if (Math.abs(i4) > 59) {
            StringBuilder h3 = a.h("Zone offset seconds not in valid range: abs(value) ");
            h3.append(Math.abs(i4));
            h3.append(" is not in the range 0 to 59");
            throw new a(h3.toString());
        } else if (Math.abs(i2) != 18 || (Math.abs(i3) <= 0 && Math.abs(i4) <= 0)) {
            return R((i3 * 60) + (i2 * 3600) + i4);
        } else {
            throw new a("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static q R(int i2) {
        if (Math.abs(i2) > 64800) {
            throw new a("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i2 % BuildConfig.ATTENUATION_THRESHOLD != 0) {
            return new q(i2);
        } else {
            Integer valueOf = Integer.valueOf(i2);
            q qVar = f6444e.get(valueOf);
            if (qVar != null) {
                return qVar;
            }
            f6444e.putIfAbsent(valueOf, new q(i2));
            q qVar2 = f6444e.get(valueOf);
            f6445f.putIfAbsent(qVar2.f6448d, qVar2);
            return qVar2;
        }
    }

    public static int S(CharSequence charSequence, int i2, boolean z) {
        if (!z || charSequence.charAt(i2 - 1) == ':') {
            char charAt = charSequence.charAt(i2);
            char charAt2 = charSequence.charAt(i2 + 1);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
                throw new a("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
            }
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new a("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
    }

    public static q T(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? R(dataInput.readInt()) : R(readByte * 900);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 8, this);
    }

    @Override // g.b.a.p
    public String A() {
        return this.f6448d;
    }

    @Override // g.b.a.p
    public g.b.a.x.f B() {
        t.y2(this, "offset");
        return new f.a(this);
    }

    @Override // g.b.a.p
    public void H(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        U(dataOutput);
    }

    public void U(DataOutput dataOutput) {
        int i2 = this.f6447c;
        int i3 = i2 % BuildConfig.ATTENUATION_THRESHOLD == 0 ? i2 / BuildConfig.ATTENUATION_THRESHOLD : 127;
        dataOutput.writeByte(i3);
        if (i3 == 127) {
            dataOutput.writeInt(i2);
        }
    }

    @Override // g.b.a.w.e
    public o b(j jVar) {
        if (jVar == g.b.a.w.a.OFFSET_SECONDS) {
            return jVar.m();
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.p(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(q qVar) {
        return qVar.f6447c - this.f6447c;
    }

    @Override // g.b.a.w.e
    public int d(j jVar) {
        if (jVar == g.b.a.w.a.OFFSET_SECONDS) {
            return this.f6447c;
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return b(jVar).a(n(jVar), jVar);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.p
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f6447c == ((q) obj).f6447c;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: g.b.a.q */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.b.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6660e || lVar == k.f6659d) {
            return this;
        }
        if (lVar == k.f6661f || lVar == k.f6662g || lVar == k.f6658c || lVar == k.f6657b || lVar == k.f6656a) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // g.b.a.p
    public int hashCode() {
        return this.f6447c;
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.OFFSET_SECONDS : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (jVar == g.b.a.w.a.OFFSET_SECONDS) {
            return (long) this.f6447c;
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        throw new a(a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(g.b.a.w.a.OFFSET_SECONDS, (long) this.f6447c);
    }

    @Override // g.b.a.p
    public String toString() {
        return this.f6448d;
    }
}
