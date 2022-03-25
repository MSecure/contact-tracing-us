package l.b.a;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;
import l.b.a.w.o;
import l.b.a.x.f;

public final class q extends p implements e, f, Comparable<q>, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentMap<Integer, q> f4164e = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: f  reason: collision with root package name */
    public static final ConcurrentMap<String, q> f4165f = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: g  reason: collision with root package name */
    public static final q f4166g = z(0);

    /* renamed from: h  reason: collision with root package name */
    public static final q f4167h = z(-64800);

    /* renamed from: i  reason: collision with root package name */
    public static final q f4168i = z(64800);
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final transient String f4169d;

    public q(int i2) {
        String str;
        this.c = i2;
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
        this.f4169d = str;
    }

    public static int A(CharSequence charSequence, int i2, boolean z) {
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

    public static q B(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? z(dataInput.readInt()) : z(readByte * 900);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static q w(e eVar) {
        q qVar = (q) eVar.c(k.f4303e);
        if (qVar != null) {
            return qVar;
        }
        throw new a(a.f(eVar, a.k("Unable to obtain ZoneOffset from TemporalAccessor: ", eVar, ", type ")));
    }

    private Object writeReplace() {
        return new m((byte) 8, this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    public static q x(String str) {
        int i2;
        int i3;
        int i4;
        char charAt;
        b.A1(str, "offsetId");
        q qVar = f4165f.get(str);
        if (qVar != null) {
            return qVar;
        }
        int length = str.length();
        if (length == 2) {
            str = str.charAt(0) + "0" + str.charAt(1);
        } else if (length != 3) {
            if (length == 5) {
                i4 = A(str, 1, false);
                i3 = A(str, 3, false);
            } else if (length != 6) {
                if (length == 7) {
                    i4 = A(str, 1, false);
                    i3 = A(str, 3, false);
                    i2 = A(str, 5, false);
                } else if (length == 9) {
                    i4 = A(str, 1, false);
                    i3 = A(str, 4, true);
                    i2 = A(str, 7, true);
                } else {
                    throw new a(a.t("Invalid ID for ZoneOffset, invalid format: ", str));
                }
                charAt = str.charAt(0);
                if (charAt != '+' || charAt == '-') {
                    return charAt == '-' ? y(-i4, -i3, -i2) : y(i4, i3, i2);
                }
                throw new a(a.t("Invalid ID for ZoneOffset, plus/minus not found when expected: ", str));
            } else {
                i4 = A(str, 1, false);
                i3 = A(str, 4, true);
            }
            i2 = 0;
            charAt = str.charAt(0);
            if (charAt != '+') {
            }
            if (charAt == '-') {
            }
        }
        i4 = A(str, 1, false);
        i3 = 0;
        i2 = 0;
        charAt = str.charAt(0);
        if (charAt != '+') {
        }
        if (charAt == '-') {
        }
    }

    public static q y(int i2, int i3, int i4) {
        if (i2 < -18 || i2 > 18) {
            throw new a(a.r("Zone offset hours not in valid range: value ", i2, " is not in the range -18 to 18"));
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
            return z((i3 * 60) + (i2 * 3600) + i4);
        } else {
            throw new a("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static q z(int i2) {
        if (Math.abs(i2) > 64800) {
            throw new a("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i2 % 900 != 0) {
            return new q(i2);
        } else {
            Integer valueOf = Integer.valueOf(i2);
            ConcurrentMap<Integer, q> concurrentMap = f4164e;
            q qVar = concurrentMap.get(valueOf);
            if (qVar != null) {
                return qVar;
            }
            concurrentMap.putIfAbsent(valueOf, new q(i2));
            q qVar2 = concurrentMap.get(valueOf);
            f4165f.putIfAbsent(qVar2.f4169d, qVar2);
            return qVar2;
        }
    }

    public void C(DataOutput dataOutput) {
        int i2 = this.c;
        int i3 = i2 % 900 == 0 ? i2 / 900 : 127;
        dataOutput.writeByte(i3);
        if (i3 == 127) {
            dataOutput.writeInt(i2);
        }
    }

    @Override // l.b.a.w.e
    public o a(j jVar) {
        if (jVar == l.b.a.w.a.OFFSET_SECONDS) {
            return jVar.h();
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.l(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.e
    public int b(j jVar) {
        if (jVar == l.b.a.w.a.OFFSET_SECONDS) {
            return this.c;
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return a(jVar).a(i(jVar), jVar);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: l.b.a.q */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.f4303e || lVar == k.f4302d) {
            return this;
        }
        if (lVar == k.f4304f || lVar == k.f4305g || lVar == k.c || lVar == k.b || lVar == k.a) {
            return null;
        }
        return lVar.a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(q qVar) {
        return qVar.c - this.c;
    }

    @Override // l.b.a.p
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && this.c == ((q) obj).c;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar == l.b.a.w.a.OFFSET_SECONDS : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.p
    public int hashCode() {
        return this.c;
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (jVar == l.b.a.w.a.OFFSET_SECONDS) {
            return (long) this.c;
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        throw new a(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(l.b.a.w.a.OFFSET_SECONDS, (long) this.c);
    }

    @Override // l.b.a.p
    public String r() {
        return this.f4169d;
    }

    @Override // l.b.a.p
    public l.b.a.x.f s() {
        b.A1(this, "offset");
        return new f.a(this);
    }

    @Override // l.b.a.p
    public String toString() {
        return this.f4169d;
    }

    @Override // l.b.a.p
    public void v(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        C(dataOutput);
    }
}
