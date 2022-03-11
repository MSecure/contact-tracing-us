package l.b.a.u;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import l.b.a.u.e;
import l.b.a.u.i;
import l.b.a.u.o;
import l.b.a.w.c;

public final class d {

    /* renamed from: h  reason: collision with root package name */
    public static final l.b.a.w.l<l.b.a.p> f4129h = new a();

    /* renamed from: i  reason: collision with root package name */
    public static final Map<Character, l.b.a.w.j> f4130i;

    /* renamed from: j  reason: collision with root package name */
    public static final Comparator<String> f4131j = new c();
    public d a;
    public final d b;
    public final List<f> c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4132d;

    /* renamed from: e  reason: collision with root package name */
    public int f4133e;

    /* renamed from: f  reason: collision with root package name */
    public char f4134f;

    /* renamed from: g  reason: collision with root package name */
    public int f4135g;

    public class a implements l.b.a.w.l<l.b.a.p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public l.b.a.p a(l.b.a.w.e eVar) {
            l.b.a.p pVar = (l.b.a.p) eVar.c(l.b.a.w.k.a);
            if (pVar == null || (pVar instanceof l.b.a.q)) {
                return null;
            }
            return pVar;
        }
    }

    public class b extends i {
        public final /* synthetic */ o.b b;

        public b(d dVar, o.b bVar) {
            this.b = bVar;
        }

        @Override // l.b.a.u.i
        public String a(l.b.a.w.j jVar, long j2, p pVar, Locale locale) {
            return this.b.a(j2, pVar);
        }

        @Override // l.b.a.u.i
        public Iterator<Map.Entry<String, Long>> b(l.b.a.w.j jVar, p pVar, Locale locale) {
            List<Map.Entry<String, Long>> list = this.b.b.get(pVar);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }

    public class c implements Comparator<String> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            return str3.length() == str4.length() ? str3.compareTo(str4) : str3.length() - str4.length();
        }
    }

    /* renamed from: l.b.a.u.d$d  reason: collision with other inner class name */
    public static final class C0149d implements f {
        public final char b;

        public C0149d(char c) {
            this.b = c;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            sb.append(this.b);
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            if (i2 == charSequence.length()) {
                return ~i2;
            }
            return !eVar.a(this.b, charSequence.charAt(i2)) ? ~i2 : i2 + 1;
        }

        public String toString() {
            if (this.b == '\'') {
                return "''";
            }
            StringBuilder h2 = f.a.a.a.a.h("'");
            h2.append(this.b);
            h2.append("'");
            return h2.toString();
        }
    }

    public static final class e implements f {
        public final f[] b;
        public final boolean c;

        public e(List<f> list, boolean z) {
            this.b = (f[]) list.toArray(new f[list.size()]);
            this.c = z;
        }

        public e(f[] fVarArr, boolean z) {
            this.b = fVarArr;
            this.c = z;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            int length = sb.length();
            if (this.c) {
                hVar.f4165d++;
            }
            try {
                for (f fVar : this.b) {
                    if (!fVar.a(hVar, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.c) {
                    hVar.a();
                }
                return true;
            } finally {
                if (this.c) {
                    hVar.a();
                }
            }
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            if (this.c) {
                ArrayList<e.a> arrayList = eVar.f4157g;
                e.a b2 = eVar.b();
                e.a aVar = new e.a();
                aVar.b = b2.b;
                aVar.c = b2.c;
                aVar.f4158d.putAll(b2.f4158d);
                aVar.f4159e = b2.f4159e;
                arrayList.add(aVar);
                int i3 = i2;
                for (f fVar : this.b) {
                    i3 = fVar.b(eVar, charSequence, i3);
                    if (i3 < 0) {
                        eVar.c(false);
                        return i2;
                    }
                }
                eVar.c(true);
                return i3;
            }
            for (f fVar2 : this.b) {
                i2 = fVar2.b(eVar, charSequence, i2);
                if (i2 < 0) {
                    break;
                }
            }
            return i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.b != null) {
                sb.append(this.c ? "[" : "(");
                for (f fVar : this.b) {
                    sb.append(fVar);
                }
                sb.append(this.c ? "]" : ")");
            }
            return sb.toString();
        }
    }

    public interface f {
        boolean a(h hVar, StringBuilder sb);

        int b(e eVar, CharSequence charSequence, int i2);
    }

    public static final class g implements f {
        public final l.b.a.w.j b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4136d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4137e;

        public g(l.b.a.w.j jVar, int i2, int i3, boolean z) {
            f.b.a.c.b.o.b.B1(jVar, "field");
            l.b.a.w.o h2 = jVar.h();
            if (!(h2.b == h2.c && h2.f4210d == h2.f4211e)) {
                throw new IllegalArgumentException(f.a.a.a.a.d("Field must have a fixed set of values: ", jVar));
            } else if (i2 < 0 || i2 > 9) {
                throw new IllegalArgumentException(f.a.a.a.a.q("Minimum width must be from 0 to 9 inclusive but was ", i2));
            } else if (i3 < 1 || i3 > 9) {
                throw new IllegalArgumentException(f.a.a.a.a.q("Maximum width must be from 1 to 9 inclusive but was ", i3));
            } else if (i3 >= i2) {
                this.b = jVar;
                this.c = i2;
                this.f4136d = i3;
                this.f4137e = z;
            } else {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
            }
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(this.b);
            if (b2 == null) {
                return false;
            }
            j jVar = hVar.c;
            long longValue = b2.longValue();
            l.b.a.w.o h2 = this.b.h();
            h2.b(longValue, this.b);
            BigDecimal valueOf = BigDecimal.valueOf(h2.b);
            BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(h2.f4211e).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
            if (stripTrailingZeros.scale() != 0) {
                String a = jVar.a(stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.c), this.f4136d), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.f4137e) {
                    sb.append(jVar.f4167d);
                }
                sb.append(a);
                return true;
            } else if (this.c <= 0) {
                return true;
            } else {
                if (this.f4137e) {
                    sb.append(jVar.f4167d);
                }
                for (int i2 = 0; i2 < this.c; i2++) {
                    sb.append(jVar.a);
                }
                return true;
            }
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            int i3;
            boolean z = eVar.f4156f;
            int i4 = z ? this.c : 0;
            int i5 = z ? this.f4136d : 9;
            int length = charSequence.length();
            if (i2 == length) {
                return i4 > 0 ? ~i2 : i2;
            }
            if (this.f4137e) {
                if (charSequence.charAt(i2) != eVar.b.f4167d) {
                    return i4 > 0 ? ~i2 : i2;
                }
                i2++;
            }
            int i6 = i4 + i2;
            if (i6 > length) {
                return ~i2;
            }
            int min = Math.min(i5 + i2, length);
            int i7 = i2;
            int i8 = 0;
            while (true) {
                if (i7 >= min) {
                    i3 = i7;
                    break;
                }
                int i9 = i7 + 1;
                int charAt = charSequence.charAt(i7) - eVar.b.a;
                if (charAt < 0 || charAt > 9) {
                    charAt = -1;
                }
                if (charAt >= 0) {
                    i8 = (i8 * 10) + charAt;
                    i7 = i9;
                } else if (i9 < i6) {
                    return ~i2;
                } else {
                    i3 = i9 - 1;
                }
            }
            BigDecimal movePointLeft = new BigDecimal(i8).movePointLeft(i3 - i2);
            l.b.a.w.o h2 = this.b.h();
            BigDecimal valueOf = BigDecimal.valueOf(h2.b);
            return eVar.g(this.b, movePointLeft.multiply(BigDecimal.valueOf(h2.f4211e).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i2, i3);
        }

        public String toString() {
            String str = this.f4137e ? ",DecimalPoint" : "";
            StringBuilder h2 = f.a.a.a.a.h("Fraction(");
            h2.append(this.b);
            h2.append(",");
            h2.append(this.c);
            h2.append(",");
            h2.append(this.f4136d);
            h2.append(str);
            h2.append(")");
            return h2.toString();
        }
    }

    public static final class h implements f {
        public h(int i2) {
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            int i2;
            Long b = hVar.b(l.b.a.w.a.INSTANT_SECONDS);
            Long l2 = 0L;
            l.b.a.w.e eVar = hVar.a;
            l.b.a.w.a aVar = l.b.a.w.a.NANO_OF_SECOND;
            if (eVar.f(aVar)) {
                l2 = Long.valueOf(hVar.a.i(aVar));
            }
            if (b == null) {
                return false;
            }
            long longValue = b.longValue();
            int m = aVar.m(l2.longValue());
            if (longValue >= -62167219200L) {
                long j2 = (longValue - 315569520000L) + 62167219200L;
                long B0 = f.b.a.c.b.o.b.B0(j2, 315569520000L) + 1;
                l.b.a.f G = l.b.a.f.G(f.b.a.c.b.o.b.D0(j2, 315569520000L) - 62167219200L, 0, l.b.a.q.f4070g);
                if (B0 > 0) {
                    sb.append('+');
                    sb.append(B0);
                }
                sb.append(G);
                if (G.c.f4051d == 0) {
                    sb.append(":00");
                }
            } else {
                long j3 = longValue + 62167219200L;
                long j4 = j3 / 315569520000L;
                long j5 = j3 % 315569520000L;
                l.b.a.f G2 = l.b.a.f.G(j5 - 62167219200L, 0, l.b.a.q.f4070g);
                int length = sb.length();
                sb.append(G2);
                if (G2.c.f4051d == 0) {
                    sb.append(":00");
                }
                if (j4 < 0) {
                    if (G2.b.b == -10000) {
                        sb.replace(length, length + 2, Long.toString(j4 - 1));
                    } else {
                        if (j5 != 0) {
                            length++;
                            j4 = Math.abs(j4);
                        }
                        sb.insert(length, j4);
                    }
                }
            }
            if (m != 0) {
                sb.append('.');
                int i3 = 1000000;
                if (m % 1000000 == 0) {
                    i2 = (m / 1000000) + 1000;
                } else {
                    if (m % 1000 == 0) {
                        m /= 1000;
                    } else {
                        i3 = 1000000000;
                    }
                    i2 = m + i3;
                }
                sb.append(Integer.toString(i2).substring(1));
            }
            sb.append('Z');
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            Objects.requireNonNull(eVar);
            e eVar2 = new e(eVar);
            d dVar = new d();
            dVar.a(c.f4120h);
            dVar.d('T');
            l.b.a.w.a aVar = l.b.a.w.a.HOUR_OF_DAY;
            dVar.m(aVar, 2);
            dVar.d(':');
            l.b.a.w.a aVar2 = l.b.a.w.a.MINUTE_OF_HOUR;
            dVar.m(aVar2, 2);
            dVar.d(':');
            l.b.a.w.a aVar3 = l.b.a.w.a.SECOND_OF_MINUTE;
            dVar.m(aVar3, 2);
            l.b.a.w.a aVar4 = l.b.a.w.a.NANO_OF_SECOND;
            int i3 = 1;
            dVar.b(aVar4, 0, 9, true);
            dVar.d('Z');
            int b = dVar.q().e(false).b(eVar2, charSequence, i2);
            if (b < 0) {
                return b;
            }
            long longValue = eVar2.e(l.b.a.w.a.YEAR).longValue();
            int intValue = eVar2.e(l.b.a.w.a.MONTH_OF_YEAR).intValue();
            int intValue2 = eVar2.e(l.b.a.w.a.DAY_OF_MONTH).intValue();
            int intValue3 = eVar2.e(aVar).intValue();
            int intValue4 = eVar2.e(aVar2).intValue();
            Long e2 = eVar2.e(aVar3);
            Long e3 = eVar2.e(aVar4);
            int intValue5 = e2 != null ? e2.intValue() : 0;
            int intValue6 = e3 != null ? e3.intValue() : 0;
            int i4 = ((int) longValue) % 10000;
            if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                intValue3 = 0;
            } else {
                if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                    eVar.b().f4159e = true;
                    intValue5 = 59;
                }
                i3 = 0;
            }
            try {
                l.b.a.f fVar = l.b.a.f.f4045d;
                return eVar.g(aVar4, (long) intValue6, i2, eVar.g(l.b.a.w.a.INSTANT_SECONDS, new l.b.a.f(l.b.a.e.P(i4, intValue, intValue2), l.b.a.g.v(intValue3, intValue4, intValue5, 0)).I((long) i3).v(l.b.a.q.f4070g) + f.b.a.c.b.o.b.J1(longValue / 10000, 315569520000L), i2, b));
            } catch (RuntimeException unused) {
                return ~i2;
            }
        }

        public String toString() {
            return "Instant()";
        }
    }

    public static final class i implements f {
        public final p b;

        public i(p pVar) {
            this.b = pVar;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(l.b.a.w.a.OFFSET_SECONDS);
            if (b2 == null) {
                return false;
            }
            sb.append("GMT");
            if (this.b == p.FULL) {
                return new l("", "+HH:MM:ss").a(hVar, sb);
            }
            int M1 = f.b.a.c.b.o.b.M1(b2.longValue());
            if (M1 == 0) {
                return true;
            }
            int abs = Math.abs((M1 / 3600) % 100);
            int abs2 = Math.abs((M1 / 60) % 60);
            int abs3 = Math.abs(M1 % 60);
            sb.append(M1 < 0 ? "-" : "+");
            sb.append(abs);
            if (abs2 <= 0 && abs3 <= 0) {
                return true;
            }
            sb.append(":");
            sb.append((char) ((abs2 / 10) + 48));
            sb.append((char) ((abs2 % 10) + 48));
            if (abs3 <= 0) {
                return true;
            }
            sb.append(":");
            sb.append((char) ((abs3 / 10) + 48));
            sb.append((char) ((abs3 % 10) + 48));
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            char charAt;
            if (!eVar.h(charSequence, i2, "GMT", 0, 3)) {
                return ~i2;
            }
            int i3 = i2 + 3;
            if (this.b == p.FULL) {
                return new l("", "+HH:MM:ss").b(eVar, charSequence, i3);
            }
            int length = charSequence.length();
            if (i3 == length) {
                return eVar.g(l.b.a.w.a.OFFSET_SECONDS, 0, i3, i3);
            }
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 != '+' && charAt2 != '-') {
                return eVar.g(l.b.a.w.a.OFFSET_SECONDS, 0, i3, i3);
            }
            int i4 = charAt2 == '-' ? -1 : 1;
            if (i3 == length) {
                return ~i3;
            }
            int i5 = i3 + 1;
            char charAt3 = charSequence.charAt(i5);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i5;
            }
            int i6 = i5 + 1;
            int i7 = charAt3 - '0';
            if (i6 != length && (charAt = charSequence.charAt(i6)) >= '0' && charAt <= '9') {
                i7 = (i7 * 10) + (charAt - '0');
                if (i7 > 23) {
                    return ~i6;
                }
                i6++;
            }
            if (i6 == length || charSequence.charAt(i6) != ':') {
                return eVar.g(l.b.a.w.a.OFFSET_SECONDS, (long) (i4 * 3600 * i7), i6, i6);
            }
            int i8 = i6 + 1;
            int i9 = length - 2;
            if (i8 > i9) {
                return ~i8;
            }
            char charAt4 = charSequence.charAt(i8);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i8;
            }
            int i10 = i8 + 1;
            int i11 = charAt4 - '0';
            char charAt5 = charSequence.charAt(i10);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i10;
            }
            int i12 = i10 + 1;
            int i13 = (charAt5 - '0') + (i11 * 10);
            if (i13 > 59) {
                return ~i12;
            }
            if (i12 == length || charSequence.charAt(i12) != ':') {
                return eVar.g(l.b.a.w.a.OFFSET_SECONDS, (long) (((i13 * 60) + (i7 * 3600)) * i4), i12, i12);
            }
            int i14 = i12 + 1;
            if (i14 > i9) {
                return ~i14;
            }
            char charAt6 = charSequence.charAt(i14);
            if (charAt6 < '0' || charAt6 > '9') {
                return ~i14;
            }
            int i15 = i14 + 1;
            int i16 = charAt6 - '0';
            char charAt7 = charSequence.charAt(i15);
            if (charAt7 < '0' || charAt7 > '9') {
                return ~i15;
            }
            int i17 = i15 + 1;
            int i18 = (charAt7 - '0') + (i16 * 10);
            return i18 > 59 ? ~i17 : eVar.g(l.b.a.w.a.OFFSET_SECONDS, (long) (((i13 * 60) + (i7 * 3600) + i18) * i4), i17, i17);
        }
    }

    public static final class j implements f {
        public final k b;
        public final k c;

        public j(k kVar, k kVar2) {
            this.b = kVar;
            this.c = kVar2;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            return c(hVar.b, l.b.a.t.h.l(hVar.a)).e(false).a(hVar, sb);
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            return c(eVar.a, eVar.d()).e(false).b(eVar, charSequence, i2);
        }

        public final c c(Locale locale, l.b.a.t.h hVar) {
            DateFormat dateFormat;
            k kVar = this.b;
            k kVar2 = this.c;
            if (kVar == null && kVar2 == null) {
                throw new IllegalArgumentException("Date and Time style must not both be null");
            }
            String str = hVar.n() + '|' + locale.toString() + '|' + kVar + kVar2;
            ConcurrentMap<String, Object> concurrentMap = n.a;
            Object obj = concurrentMap.get(str);
            if (obj == null) {
                if (kVar == null) {
                    dateFormat = DateFormat.getTimeInstance(kVar2.ordinal(), locale);
                } else if (kVar2 != null) {
                    dateFormat = DateFormat.getDateTimeInstance(kVar.ordinal(), kVar2.ordinal(), locale);
                } else {
                    dateFormat = DateFormat.getDateInstance(kVar.ordinal(), locale);
                }
                if (dateFormat instanceof SimpleDateFormat) {
                    String pattern = ((SimpleDateFormat) dateFormat).toPattern();
                    d dVar = new d();
                    dVar.h(pattern);
                    c r = dVar.r(locale);
                    concurrentMap.putIfAbsent(str, r);
                    return r;
                }
                concurrentMap.putIfAbsent(str, "");
                throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
            } else if (!obj.equals("")) {
                return (c) obj;
            } else {
                throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
            }
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("Localized(");
            Object obj = this.b;
            Object obj2 = "";
            if (obj == null) {
                obj = obj2;
            }
            h2.append(obj);
            h2.append(",");
            k kVar = this.c;
            if (kVar != null) {
                obj2 = kVar;
            }
            h2.append(obj2);
            h2.append(")");
            return h2.toString();
        }
    }

    public static class k implements f {

        /* renamed from: g  reason: collision with root package name */
        public static final int[] f4138g = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        public final l.b.a.w.j b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4139d;

        /* renamed from: e  reason: collision with root package name */
        public final m f4140e;

        /* renamed from: f  reason: collision with root package name */
        public final int f4141f;

        public k(l.b.a.w.j jVar, int i2, int i3, m mVar) {
            this.b = jVar;
            this.c = i2;
            this.f4139d = i3;
            this.f4140e = mVar;
            this.f4141f = 0;
        }

        public k(l.b.a.w.j jVar, int i2, int i3, m mVar, int i4) {
            this.b = jVar;
            this.c = i2;
            this.f4139d = i3;
            this.f4140e = mVar;
            this.f4141f = i4;
        }

        public k(l.b.a.w.j jVar, int i2, int i3, m mVar, int i4, a aVar) {
            this.b = jVar;
            this.c = i2;
            this.f4139d = i3;
            this.f4140e = mVar;
            this.f4141f = i4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
            if (r4 != 4) goto L_0x0087;
         */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0090 A[LOOP:0: B:27:0x0087->B:29:0x0090, LOOP_END] */
        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            String str;
            char c2;
            int i2;
            Long b2 = hVar.b(this.b);
            if (b2 == null) {
                return false;
            }
            long c3 = c(hVar, b2.longValue());
            j jVar = hVar.c;
            if (c3 == Long.MIN_VALUE) {
                str = "9223372036854775808";
            } else {
                str = Long.toString(Math.abs(c3));
            }
            if (str.length() <= this.f4139d) {
                String a = jVar.a(str);
                int i3 = (c3 > 0 ? 1 : (c3 == 0 ? 0 : -1));
                int ordinal = this.f4140e.ordinal();
                if (i3 >= 0) {
                    if (ordinal == 1 || (ordinal == 4 && (i2 = this.c) < 19 && c3 >= ((long) f4138g[i2]))) {
                        c2 = jVar.b;
                    }
                    for (int i4 = 0; i4 < this.c - a.length(); i4++) {
                        sb.append(jVar.a);
                    }
                    sb.append(a);
                    return true;
                }
                if (!(ordinal == 0 || ordinal == 1)) {
                    if (ordinal == 3) {
                        StringBuilder h2 = f.a.a.a.a.h("Field ");
                        h2.append(this.b);
                        h2.append(" cannot be printed as the value ");
                        h2.append(c3);
                        h2.append(" cannot be negative according to the SignStyle");
                        throw new l.b.a.a(h2.toString());
                    }
                }
                c2 = jVar.c;
                sb.append(c2);
                while (i4 < this.c - a.length()) {
                }
                sb.append(a);
                return true;
            }
            StringBuilder h3 = f.a.a.a.a.h("Field ");
            h3.append(this.b);
            h3.append(" cannot be printed as the value ");
            h3.append(c3);
            h3.append(" exceeds the maximum print width of ");
            h3.append(this.f4139d);
            throw new l.b.a.a(h3.toString());
        }

        /* JADX WARNING: Removed duplicated region for block: B:108:0x0147  */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0164  */
        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            int i3;
            boolean z;
            boolean z2;
            BigInteger bigInteger;
            int i4;
            long j2;
            long j3;
            int i5;
            long j4;
            int i6;
            int i7 = i2;
            int length = charSequence.length();
            if (i7 == length) {
                return ~i7;
            }
            char charAt = charSequence.charAt(i2);
            j jVar = eVar.b;
            int i8 = 0;
            if (charAt == jVar.b) {
                if (!this.f4140e.a(true, eVar.f4156f, this.c == this.f4139d)) {
                    return ~i7;
                }
                i3 = i7 + 1;
                z2 = true;
                z = false;
            } else {
                if (charAt == jVar.c) {
                    if (!this.f4140e.a(false, eVar.f4156f, this.c == this.f4139d)) {
                        return ~i7;
                    }
                    i7++;
                    z = true;
                } else if (this.f4140e == m.ALWAYS && eVar.f4156f) {
                    return ~i7;
                } else {
                    z = false;
                }
                i3 = i7;
                z2 = false;
            }
            int i9 = (eVar.f4156f || d(eVar)) ? this.c : 1;
            int i10 = i3 + i9;
            if (i10 > length) {
                return ~i3;
            }
            int i11 = 9;
            int max = Math.max(this.f4141f, 0) + ((eVar.f4156f || d(eVar)) ? this.f4139d : 9);
            while (true) {
                bigInteger = null;
                if (i8 >= 2) {
                    i4 = i3;
                    j2 = 0;
                    break;
                }
                int min = Math.min(max + i3, length);
                i5 = i3;
                j4 = 0;
                while (true) {
                    if (i5 >= min) {
                        break;
                    }
                    int i12 = i5 + 1;
                    int charAt2 = charSequence.charAt(i5) - eVar.b.a;
                    if (charAt2 < 0 || charAt2 > i11) {
                        charAt2 = -1;
                    }
                    if (charAt2 < 0) {
                        i5 = i12 - 1;
                        if (i5 < i10) {
                            return ~i3;
                        }
                    } else {
                        if (i12 - i3 > 18) {
                            if (bigInteger == null) {
                                bigInteger = BigInteger.valueOf(j4);
                            }
                            i6 = i10;
                            bigInteger = bigInteger.multiply(BigInteger.TEN).add(BigInteger.valueOf((long) charAt2));
                        } else {
                            i6 = i10;
                            j4 = (j4 * 10) + ((long) charAt2);
                        }
                        i10 = i6;
                        i5 = i12;
                        i11 = 9;
                    }
                }
                int i13 = this.f4141f;
                if (i13 <= 0 || i8 != 0) {
                    i4 = i5;
                    j2 = j4;
                } else {
                    max = Math.max(i9, (i5 - i3) - i13);
                    i8++;
                    i10 = i10;
                    i11 = 9;
                }
            }
            i4 = i5;
            j2 = j4;
            if (z) {
                if (bigInteger != null) {
                    if (bigInteger.equals(BigInteger.ZERO) && eVar.f4156f) {
                        return ~(i3 - 1);
                    }
                    bigInteger = bigInteger.negate();
                } else if (j2 == 0 && eVar.f4156f) {
                    return ~(i3 - 1);
                } else {
                    j3 = -j2;
                    if (bigInteger != null) {
                        return e(eVar, j3, i3, i4);
                    }
                    if (bigInteger.bitLength() > 63) {
                        bigInteger = bigInteger.divide(BigInteger.TEN);
                        i4--;
                    }
                    return e(eVar, bigInteger.longValue(), i3, i4);
                }
            } else if (this.f4140e == m.EXCEEDS_PAD && eVar.f4156f) {
                int i14 = i4 - i3;
                int i15 = this.c;
                if (z2) {
                    if (i14 <= i15) {
                        return ~(i3 - 1);
                    }
                } else if (i14 > i15) {
                    return ~i3;
                }
            }
            j3 = j2;
            if (bigInteger != null) {
            }
        }

        public long c(h hVar, long j2) {
            return j2;
        }

        public boolean d(e eVar) {
            int i2 = this.f4141f;
            return i2 == -1 || (i2 > 0 && this.c == this.f4139d && this.f4140e == m.NOT_NEGATIVE);
        }

        public int e(e eVar, long j2, int i2, int i3) {
            return eVar.g(this.b, j2, i2, i3);
        }

        public k f() {
            return this.f4141f == -1 ? this : new k(this.b, this.c, this.f4139d, this.f4140e, -1);
        }

        public k g(int i2) {
            return new k(this.b, this.c, this.f4139d, this.f4140e, this.f4141f + i2);
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            int i2 = this.c;
            if (i2 == 1 && this.f4139d == 19 && this.f4140e == m.NORMAL) {
                sb = f.a.a.a.a.h("Value(");
                obj = this.b;
            } else if (i2 == this.f4139d && this.f4140e == m.NOT_NEGATIVE) {
                sb = f.a.a.a.a.h("Value(");
                sb.append(this.b);
                sb.append(",");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            } else {
                sb = f.a.a.a.a.h("Value(");
                sb.append(this.b);
                sb.append(",");
                sb.append(this.c);
                sb.append(",");
                sb.append(this.f4139d);
                sb.append(",");
                obj = this.f4140e;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class l implements f {

        /* renamed from: d  reason: collision with root package name */
        public static final String[] f4142d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

        /* renamed from: e  reason: collision with root package name */
        public static final l f4143e = new l("Z", "+HH:MM:ss");
        public final String b;
        public final int c;

        public l(String str, String str2) {
            f.b.a.c.b.o.b.B1(str, "noOffsetText");
            f.b.a.c.b.o.b.B1(str2, "pattern");
            this.b = str;
            int i2 = 0;
            while (true) {
                String[] strArr = f4142d;
                if (i2 >= strArr.length) {
                    throw new IllegalArgumentException(f.a.a.a.a.t("Invalid zone offset pattern: ", str2));
                } else if (strArr[i2].equals(str2)) {
                    this.c = i2;
                    return;
                } else {
                    i2++;
                }
            }
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(l.b.a.w.a.OFFSET_SECONDS);
            if (b2 == null) {
                return false;
            }
            int M1 = f.b.a.c.b.o.b.M1(b2.longValue());
            if (M1 != 0) {
                int abs = Math.abs((M1 / 3600) % 100);
                int abs2 = Math.abs((M1 / 60) % 60);
                int abs3 = Math.abs(M1 % 60);
                int length = sb.length();
                sb.append(M1 < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i2 = this.c;
                if (i2 >= 3 || (i2 >= 1 && abs2 > 0)) {
                    String str = ":";
                    sb.append(i2 % 2 == 0 ? str : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i3 = this.c;
                    if (i3 >= 7 || (i3 >= 5 && abs3 > 0)) {
                        if (i3 % 2 != 0) {
                            str = "";
                        }
                        sb.append(str);
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                }
                return true;
            }
            sb.append(this.b);
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            if (r16.h(r17, r18, r15.b, 0, r9) != false) goto L_0x0036;
         */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            boolean z;
            l.b.a.w.a aVar;
            e eVar2;
            long j2;
            int i3;
            int i4;
            int length = charSequence.length();
            int length2 = this.b.length();
            if (length2 == 0) {
                if (i2 == length) {
                    aVar = l.b.a.w.a.OFFSET_SECONDS;
                    j2 = 0;
                    eVar2 = eVar;
                    i3 = i2;
                    i4 = i2;
                }
                char charAt = charSequence.charAt(i2);
                if (charAt == '+' || charAt == '-') {
                    int i5 = charAt == '-' ? -1 : 1;
                    int[] iArr = new int[4];
                    iArr[0] = i2 + 1;
                    if (!c(iArr, 1, charSequence, true)) {
                        if (!c(iArr, 2, charSequence, this.c >= 3) && !c(iArr, 3, charSequence, false)) {
                            z = false;
                            if (!z) {
                                long j3 = (long) i5;
                                long j4 = ((long) iArr[2]) * 60;
                                aVar = l.b.a.w.a.OFFSET_SECONDS;
                                int i6 = iArr[0];
                                eVar2 = eVar;
                                j2 = (j4 + (((long) iArr[1]) * 3600) + ((long) iArr[3])) * j3;
                                i3 = i2;
                                i4 = i6;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
                if (length2 != 0) {
                    return ~i2;
                }
                aVar = l.b.a.w.a.OFFSET_SECONDS;
                j2 = 0;
                i4 = i2 + length2;
                eVar2 = eVar;
                i3 = i2;
            } else if (i2 == length) {
                return ~i2;
            }
            return eVar2.g(aVar, j2, i3, i4);
        }

        public final boolean c(int[] iArr, int i2, CharSequence charSequence, boolean z) {
            int i3;
            int i4 = this.c;
            if ((i4 + 3) / 2 < i2) {
                return false;
            }
            int i5 = iArr[0];
            if (i4 % 2 == 0 && i2 > 1) {
                int i6 = i5 + 1;
                if (i6 > charSequence.length() || charSequence.charAt(i5) != ':') {
                    return z;
                }
                i5 = i6;
            }
            if (i5 + 2 > charSequence.length()) {
                return z;
            }
            int i7 = i5 + 1;
            char charAt = charSequence.charAt(i5);
            int i8 = i7 + 1;
            char charAt2 = charSequence.charAt(i7);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i3 = (charAt2 - '0') + ((charAt - '0') * 10)) < 0 || i3 > 59) {
                return z;
            }
            iArr[i2] = i3;
            iArr[0] = i8;
            return false;
        }

        public String toString() {
            String replace = this.b.replace("'", "''");
            StringBuilder h2 = f.a.a.a.a.h("Offset(");
            h2.append(f4142d[this.c]);
            h2.append(",'");
            h2.append(replace);
            h2.append("')");
            return h2.toString();
        }
    }

    public static final class m implements f {
        public final f b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final char f4144d;

        public m(f fVar, int i2, char c2) {
            this.b = fVar;
            this.c = i2;
            this.f4144d = c2;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            int length = sb.length();
            if (!this.b.a(hVar, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.c) {
                for (int i2 = 0; i2 < this.c - length2; i2++) {
                    sb.insert(length, this.f4144d);
                }
                return true;
            }
            throw new l.b.a.a("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.c);
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            boolean z = eVar.f4156f;
            boolean z2 = eVar.f4155e;
            if (i2 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            } else if (i2 == charSequence.length()) {
                return ~i2;
            } else {
                int i3 = this.c + i2;
                if (i3 > charSequence.length()) {
                    if (z) {
                        return ~i2;
                    }
                    i3 = charSequence.length();
                }
                int i4 = i2;
                while (i4 < i3) {
                    char charAt = charSequence.charAt(i4);
                    char c2 = this.f4144d;
                    if (!z2) {
                        if (!eVar.a(charAt, c2)) {
                            break;
                        }
                    } else if (charAt != c2) {
                        break;
                    }
                    i4++;
                }
                int b2 = this.b.b(eVar, charSequence.subSequence(0, i3), i4);
                return (b2 == i3 || !z) ? b2 : ~(i2 + i4);
            }
        }

        public String toString() {
            String str;
            StringBuilder h2 = f.a.a.a.a.h("Pad(");
            h2.append(this.b);
            h2.append(",");
            h2.append(this.c);
            if (this.f4144d == ' ') {
                str = ")";
            } else {
                StringBuilder h3 = f.a.a.a.a.h(",'");
                h3.append(this.f4144d);
                h3.append("')");
                str = h3.toString();
            }
            h2.append(str);
            return h2.toString();
        }
    }

    public static final class n extends k {

        /* renamed from: j  reason: collision with root package name */
        public static final l.b.a.e f4145j = l.b.a.e.P(2000, 1, 1);

        /* renamed from: h  reason: collision with root package name */
        public final int f4146h;

        /* renamed from: i  reason: collision with root package name */
        public final l.b.a.t.b f4147i;

        public n(l.b.a.w.j jVar, int i2, int i3, int i4, l.b.a.t.b bVar) {
            super(jVar, i2, i3, m.NOT_NEGATIVE);
            if (i2 < 1 || i2 > 10) {
                throw new IllegalArgumentException(f.a.a.a.a.q("The width must be from 1 to 10 inclusive but was ", i2));
            } else if (i3 < 1 || i3 > 10) {
                throw new IllegalArgumentException(f.a.a.a.a.q("The maxWidth must be from 1 to 10 inclusive but was ", i3));
            } else if (i3 >= i2) {
                if (bVar == null) {
                    long j2 = (long) i4;
                    if (!jVar.h().c(j2)) {
                        throw new IllegalArgumentException("The base value must be within the range of the field");
                    } else if (j2 + ((long) k.f4138g[i2]) > 2147483647L) {
                        throw new l.b.a.a("Unable to add printer-parser as the range exceeds the capacity of an int");
                    }
                }
                this.f4146h = i4;
                this.f4147i = bVar;
            } else {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            }
        }

        public n(l.b.a.w.j jVar, int i2, int i3, int i4, l.b.a.t.b bVar, int i5) {
            super(jVar, i2, i3, m.NOT_NEGATIVE, i5, null);
            this.f4146h = i4;
            this.f4147i = bVar;
        }

        @Override // l.b.a.u.d.k
        public long c(h hVar, long j2) {
            int i2;
            int[] iArr = k.f4138g;
            long abs = Math.abs(j2);
            int i3 = this.f4146h;
            if (this.f4147i != null) {
                i3 = l.b.a.t.h.l(hVar.a).c(this.f4147i).b(this.b);
            }
            if (j2 >= ((long) i3)) {
                int i4 = this.c;
                if (j2 < ((long) (i3 + iArr[i4]))) {
                    i2 = iArr[i4];
                    return abs % ((long) i2);
                }
            }
            i2 = iArr[this.f4139d];
            return abs % ((long) i2);
        }

        @Override // l.b.a.u.d.k
        public boolean d(e eVar) {
            if (!eVar.f4156f) {
                return false;
            }
            return super.d(eVar);
        }

        @Override // l.b.a.u.d.k
        public int e(e eVar, long j2, int i2, int i3) {
            int i4 = this.f4146h;
            if (this.f4147i != null) {
                i4 = eVar.d().c(this.f4147i).b(this.b);
                e.a b = eVar.b();
                if (b.f4161g == null) {
                    b.f4161g = new ArrayList(2);
                }
                b.f4161g.add(new Object[]{this, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            int i5 = i3 - i2;
            int i6 = this.c;
            if (i5 == i6 && j2 >= 0) {
                long j3 = (long) k.f4138g[i6];
                long j4 = (long) i4;
                long j5 = j4 - (j4 % j3);
                j2 = i4 > 0 ? j5 + j2 : j5 - j2;
                if (j2 < j4) {
                    j2 += j3;
                }
            }
            return eVar.g(this.b, j2, i2, i3);
        }

        @Override // l.b.a.u.d.k
        public k f() {
            return this.f4141f == -1 ? this : new n(this.b, this.c, this.f4139d, this.f4146h, this.f4147i, -1);
        }

        @Override // l.b.a.u.d.k
        public k g(int i2) {
            return new n(this.b, this.c, this.f4139d, this.f4146h, this.f4147i, this.f4141f + i2);
        }

        @Override // l.b.a.u.d.k
        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("ReducedValue(");
            h2.append(this.b);
            h2.append(",");
            h2.append(this.c);
            h2.append(",");
            h2.append(this.f4139d);
            h2.append(",");
            Object obj = this.f4147i;
            if (obj == null) {
                obj = Integer.valueOf(this.f4146h);
            }
            h2.append(obj);
            h2.append(")");
            return h2.toString();
        }
    }

    public enum o implements f {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                eVar.f4155e = true;
            } else if (ordinal == 1) {
                eVar.f4155e = false;
            } else if (ordinal == 2) {
                eVar.f4156f = true;
            } else if (ordinal == 3) {
                eVar.f4156f = false;
            }
            return i2;
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    public static final class p implements f {
        public final String b;

        public p(String str) {
            this.b = str;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            sb.append(this.b);
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            if (i2 > charSequence.length() || i2 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.b;
            return !eVar.h(charSequence, i2, str, 0, str.length()) ? ~i2 : this.b.length() + i2;
        }

        public String toString() {
            return f.a.a.a.a.c("'", this.b.replace("'", "''"), "'");
        }
    }

    public static final class q implements f {
        public final l.b.a.w.j b;
        public final p c;

        /* renamed from: d  reason: collision with root package name */
        public final i f4151d;

        /* renamed from: e  reason: collision with root package name */
        public volatile k f4152e;

        public q(l.b.a.w.j jVar, p pVar, i iVar) {
            this.b = jVar;
            this.c = pVar;
            this.f4151d = iVar;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(this.b);
            if (b2 == null) {
                return false;
            }
            String a = this.f4151d.a(this.b, b2.longValue(), this.c, hVar.b);
            if (a == null) {
                return c().a(hVar, sb);
            }
            sb.append(a);
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            int length = charSequence.length();
            if (i2 < 0 || i2 > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator<Map.Entry<String, Long>> b2 = this.f4151d.b(this.b, eVar.f4156f ? this.c : null, eVar.a);
            if (b2 != null) {
                while (b2.hasNext()) {
                    Map.Entry<String, Long> next = b2.next();
                    String key = next.getKey();
                    if (eVar.h(key, 0, charSequence, i2, key.length())) {
                        return eVar.g(this.b, next.getValue().longValue(), i2, key.length() + i2);
                    }
                }
                if (eVar.f4156f) {
                    return ~i2;
                }
            }
            return c().b(eVar, charSequence, i2);
        }

        public final k c() {
            if (this.f4152e == null) {
                this.f4152e = new k(this.b, 1, 19, m.NORMAL);
            }
            return this.f4152e;
        }

        public String toString() {
            Object obj;
            StringBuilder sb;
            if (this.c == p.FULL) {
                sb = f.a.a.a.a.h("Text(");
                obj = this.b;
            } else {
                sb = f.a.a.a.a.h("Text(");
                sb.append(this.b);
                sb.append(",");
                obj = this.c;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class r implements f {
        public final char b;
        public final int c;

        public r(char c2, int i2) {
            this.b = c2;
            this.c = i2;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            return ((k) c(l.b.a.w.p.a(hVar.b))).a(hVar, sb);
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            return ((k) c(l.b.a.w.p.a(eVar.a))).b(eVar, charSequence, i2);
        }

        public final f c(l.b.a.w.p pVar) {
            k kVar;
            f kVar2;
            m mVar = m.NOT_NEGATIVE;
            char c2 = this.b;
            if (c2 == 'W') {
                kVar = new k(pVar.f4214e, 1, 2, mVar);
            } else if (c2 == 'Y') {
                int i2 = this.c;
                if (i2 == 2) {
                    kVar2 = new n(pVar.f4216g, 2, 2, 0, n.f4145j);
                } else {
                    kVar2 = new k(pVar.f4216g, i2, 19, i2 < 4 ? m.NORMAL : m.EXCEEDS_PAD, -1, null);
                }
                return kVar2;
            } else if (c2 == 'c') {
                kVar = new k(pVar.f4213d, this.c, 2, mVar);
            } else if (c2 == 'e') {
                kVar = new k(pVar.f4213d, this.c, 2, mVar);
            } else if (c2 != 'w') {
                return null;
            } else {
                kVar = new k(pVar.f4215f, this.c, 2, mVar);
            }
            return kVar;
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c2 = this.b;
            if (c2 == 'Y') {
                int i2 = this.c;
                if (i2 == 1) {
                    str2 = "WeekBasedYear";
                } else if (i2 == 2) {
                    str2 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.c);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.c < 4 ? m.NORMAL : m.EXCEEDS_PAD);
                }
                sb.append(str2);
            } else {
                if (c2 == 'c' || c2 == 'e') {
                    str = "DayOfWeek";
                } else if (c2 == 'w') {
                    str = "WeekOfWeekBasedYear";
                } else {
                    if (c2 == 'W') {
                        str = "WeekOfMonth";
                    }
                    sb.append(",");
                    sb.append(this.c);
                }
                sb.append(str);
                sb.append(",");
                sb.append(this.c);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class s implements f {

        /* renamed from: d  reason: collision with root package name */
        public static volatile Map.Entry<Integer, a> f4153d;
        public final l.b.a.w.l<l.b.a.p> b;
        public final String c;

        public static final class a {
            public final int a;
            public final Map<CharSequence, a> b = new HashMap();
            public final Map<String, a> c = new HashMap();

            public a(int i2) {
                this.a = i2;
            }

            public a(int i2, a aVar) {
                this.a = i2;
            }

            public final void a(String str) {
                int length = str.length();
                int i2 = this.a;
                if (length == i2) {
                    this.b.put(str, null);
                    this.c.put(str.toLowerCase(Locale.ENGLISH), null);
                } else if (length > i2) {
                    String substring = str.substring(0, i2);
                    a aVar = this.b.get(substring);
                    if (aVar == null) {
                        aVar = new a(length);
                        this.b.put(substring, aVar);
                        this.c.put(substring.toLowerCase(Locale.ENGLISH), aVar);
                    }
                    aVar.a(str);
                }
            }
        }

        public s(l.b.a.w.l<l.b.a.p> lVar, String str) {
            this.b = lVar;
            this.c = str;
        }

        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            l.b.a.p pVar = (l.b.a.p) hVar.c(this.b);
            if (pVar == null) {
                return false;
            }
            sb.append(pVar.r());
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            String str;
            Map map;
            int i3;
            int length = charSequence.length();
            if (i2 > length) {
                throw new IndexOutOfBoundsException();
            } else if (i2 == length) {
                return ~i2;
            } else {
                char charAt = charSequence.charAt(i2);
                if (charAt == '+' || charAt == '-') {
                    Objects.requireNonNull(eVar);
                    e eVar2 = new e(eVar);
                    int b2 = l.f4143e.b(eVar2, charSequence, i2);
                    if (b2 < 0) {
                        return b2;
                    }
                    eVar.f(l.b.a.q.z((int) eVar2.e(l.b.a.w.a.OFFSET_SECONDS).longValue()));
                    return b2;
                }
                int i4 = i2 + 2;
                if (length >= i4) {
                    char charAt2 = charSequence.charAt(i2 + 1);
                    if (eVar.a(charAt, 'U') && eVar.a(charAt2, 'T')) {
                        int i5 = i2 + 3;
                        return (length < i5 || !eVar.a(charSequence.charAt(i4), 'C')) ? d(eVar, charSequence, i2, i4) : d(eVar, charSequence, i2, i5);
                    } else if (eVar.a(charAt, 'G') && length >= (i3 = i2 + 3) && eVar.a(charAt2, 'M') && eVar.a(charSequence.charAt(i4), 'T')) {
                        return d(eVar, charSequence, i2, i3);
                    }
                }
                Set<String> unmodifiableSet = Collections.unmodifiableSet(l.b.a.x.i.b.keySet());
                int size = unmodifiableSet.size();
                Map.Entry<Integer, a> entry = f4153d;
                String str2 = null;
                if (entry == null || entry.getKey().intValue() != size) {
                    synchronized (this) {
                        entry = f4153d;
                        if (entry == null || entry.getKey().intValue() != size) {
                            Integer valueOf = Integer.valueOf(size);
                            ArrayList arrayList = new ArrayList(unmodifiableSet);
                            Collections.sort(arrayList, d.f4131j);
                            a aVar = new a(((String) arrayList.get(0)).length(), null);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                aVar.a((String) it.next());
                            }
                            entry = new AbstractMap.SimpleImmutableEntry<>(valueOf, aVar);
                            f4153d = entry;
                        }
                    }
                }
                a value = entry.getValue();
                String str3 = null;
                while (value != null) {
                    int i6 = value.a + i2;
                    if (i6 > length) {
                        break;
                    }
                    String charSequence2 = charSequence.subSequence(i2, i6).toString();
                    if (eVar.f4155e) {
                        map = value.b;
                        str = charSequence2;
                    } else {
                        map = value.c;
                        str = charSequence2.toString().toLowerCase(Locale.ENGLISH);
                    }
                    value = (a) map.get(str);
                    str2 = str3;
                    str3 = charSequence2;
                }
                l.b.a.p c2 = c(unmodifiableSet, str3, eVar.f4155e);
                if (c2 == null) {
                    c2 = c(unmodifiableSet, str2, eVar.f4155e);
                    if (c2 == null) {
                        if (!eVar.a(charAt, 'Z')) {
                            return ~i2;
                        }
                        eVar.f(l.b.a.q.f4070g);
                        return i2 + 1;
                    }
                } else {
                    str2 = str3;
                }
                eVar.f(c2);
                return str2.length() + i2;
            }
        }

        public final l.b.a.p c(Set<String> set, String str, boolean z) {
            if (str == null) {
                return null;
            }
            if (!z) {
                for (String str2 : set) {
                    if (str2.equalsIgnoreCase(str)) {
                        return l.b.a.p.t(str2);
                    }
                }
                return null;
            } else if (set.contains(str)) {
                return l.b.a.p.t(str);
            } else {
                return null;
            }
        }

        public final int d(e eVar, CharSequence charSequence, int i2, int i3) {
            int b2;
            String upperCase = charSequence.subSequence(i2, i3).toString().toUpperCase();
            e eVar2 = new e(eVar);
            if ((i3 >= charSequence.length() || !eVar.a(charSequence.charAt(i3), 'Z')) && (b2 = l.f4143e.b(eVar2, charSequence, i3)) >= 0) {
                eVar.f(l.b.a.p.u(upperCase, l.b.a.q.z((int) eVar2.e(l.b.a.w.a.OFFSET_SECONDS).longValue())));
                return b2;
            }
            eVar.f(l.b.a.p.u(upperCase, l.b.a.q.f4070g));
            return i3;
        }

        public String toString() {
            return this.c;
        }
    }

    public static final class t implements f {
        public static final Comparator<String> c = new a();
        public final p b;

        public class a implements Comparator<String> {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                String str3 = str;
                String str4 = str2;
                int length = str4.length() - str3.length();
                return length == 0 ? str3.compareTo(str4) : length;
            }
        }

        public t(p pVar) {
            f.b.a.c.b.o.b.B1(pVar, "textStyle");
            this.b = pVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        @Override // l.b.a.u.d.f
        public boolean a(h hVar, StringBuilder sb) {
            l.b.a.q qVar;
            String str;
            boolean z;
            l.b.a.p pVar = (l.b.a.p) hVar.c(l.b.a.w.k.a);
            int i2 = 0;
            if (pVar == null) {
                return false;
            }
            try {
                l.b.a.x.f s = pVar.s();
                if (s.e()) {
                    qVar = s.a(l.b.a.d.f4040d);
                    if (!(qVar instanceof l.b.a.q)) {
                        str = pVar.r();
                    } else {
                        l.b.a.w.e eVar = hVar.a;
                        l.b.a.w.a aVar = l.b.a.w.a.INSTANT_SECONDS;
                        if (eVar.f(aVar)) {
                            z = pVar.s().d(l.b.a.d.r(eVar.i(aVar), 0));
                        } else {
                            z = false;
                        }
                        TimeZone timeZone = TimeZone.getTimeZone(pVar.r());
                        p pVar2 = this.b;
                        Objects.requireNonNull(pVar2);
                        if (p.values()[pVar2.ordinal() & -2] == p.FULL) {
                            i2 = 1;
                        }
                        str = timeZone.getDisplayName(z, i2, hVar.b);
                    }
                    sb.append(str);
                    return true;
                }
            } catch (l.b.a.x.g unused) {
            }
            qVar = pVar;
            if (!(qVar instanceof l.b.a.q)) {
            }
            sb.append(str);
            return true;
        }

        @Override // l.b.a.u.d.f
        public int b(e eVar, CharSequence charSequence, int i2) {
            TreeMap treeMap = new TreeMap(c);
            int i3 = l.b.a.p.b;
            Iterator it = new HashSet(Collections.unmodifiableSet(l.b.a.x.i.b.keySet())).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                treeMap.put(str, str);
                TimeZone timeZone = TimeZone.getTimeZone(str);
                p pVar = this.b;
                Objects.requireNonNull(pVar);
                int i4 = p.values()[pVar.ordinal() & -2] == p.FULL ? 1 : 0;
                String displayName = timeZone.getDisplayName(false, i4, eVar.a);
                if (str.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                    treeMap.put(displayName, str);
                }
                String displayName2 = timeZone.getDisplayName(true, i4, eVar.a);
                if (str.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                    treeMap.put(displayName2, str);
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str2 = (String) entry.getKey();
                if (eVar.h(charSequence, i2, str2, 0, str2.length())) {
                    eVar.f(l.b.a.p.t((String) entry.getValue()));
                    return str2.length() + i2;
                }
            }
            return ~i2;
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("ZoneText(");
            h2.append(this.b);
            h2.append(")");
            return h2.toString();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f4130i = hashMap;
        hashMap.put('G', l.b.a.w.a.ERA);
        hashMap.put('y', l.b.a.w.a.YEAR_OF_ERA);
        hashMap.put('u', l.b.a.w.a.YEAR);
        l.b.a.w.m mVar = l.b.a.w.c.a;
        c.b bVar = c.b.QUARTER_OF_YEAR;
        hashMap.put('Q', bVar);
        hashMap.put('q', bVar);
        l.b.a.w.a aVar = l.b.a.w.a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', l.b.a.w.a.DAY_OF_YEAR);
        hashMap.put('d', l.b.a.w.a.DAY_OF_MONTH);
        hashMap.put('F', l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        l.b.a.w.a aVar2 = l.b.a.w.a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', l.b.a.w.a.AMPM_OF_DAY);
        hashMap.put('H', l.b.a.w.a.HOUR_OF_DAY);
        hashMap.put('k', l.b.a.w.a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', l.b.a.w.a.HOUR_OF_AMPM);
        hashMap.put('h', l.b.a.w.a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', l.b.a.w.a.MINUTE_OF_HOUR);
        hashMap.put('s', l.b.a.w.a.SECOND_OF_MINUTE);
        l.b.a.w.a aVar3 = l.b.a.w.a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', l.b.a.w.a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', l.b.a.w.a.NANO_OF_DAY);
    }

    public d() {
        this.a = this;
        this.c = new ArrayList();
        this.f4135g = -1;
        this.b = null;
        this.f4132d = false;
    }

    public d(d dVar, boolean z) {
        this.a = this;
        this.c = new ArrayList();
        this.f4135g = -1;
        this.b = dVar;
        this.f4132d = z;
    }

    public d a(c cVar) {
        f.b.a.c.b.o.b.B1(cVar, "formatter");
        c(cVar.e(false));
        return this;
    }

    public d b(l.b.a.w.j jVar, int i2, int i3, boolean z) {
        c(new g(jVar, i2, i3, z));
        return this;
    }

    public final int c(f fVar) {
        f.b.a.c.b.o.b.B1(fVar, "pp");
        d dVar = this.a;
        int i2 = dVar.f4133e;
        if (i2 > 0) {
            m mVar = new m(fVar, i2, dVar.f4134f);
            dVar.f4133e = 0;
            dVar.f4134f = 0;
            fVar = mVar;
        }
        dVar.c.add(fVar);
        d dVar2 = this.a;
        dVar2.f4135g = -1;
        return dVar2.c.size() - 1;
    }

    public d d(char c2) {
        c(new C0149d(c2));
        return this;
    }

    public d e(String str) {
        f.b.a.c.b.o.b.B1(str, "literal");
        if (str.length() > 0) {
            c(str.length() == 1 ? new C0149d(str.charAt(0)) : new p(str));
        }
        return this;
    }

    public d f(p pVar) {
        f.b.a.c.b.o.b.B1(pVar, "style");
        if (pVar == p.FULL || pVar == p.SHORT) {
            c(new i(pVar));
            return this;
        }
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public d g(String str, String str2) {
        c(new l(str2, str));
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00dd, code lost:
        if (r4 == 1) goto L_0x021b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0381 A[SYNTHETIC] */
    public d h(String str) {
        String str2;
        String str3;
        r rVar;
        r rVar2;
        int i2;
        f.b.a.c.b.o.b.B1(str, "pattern");
        p pVar = p.SHORT;
        p pVar2 = p.FULL;
        int i3 = 0;
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int i4 = i3 + 1;
                while (i4 < str.length() && str.charAt(i4) == charAt) {
                    i4++;
                }
                int i5 = i4 - i3;
                if (charAt == 'p') {
                    if (i4 >= str.length() || (((charAt = str.charAt(i4)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        i2 = i5;
                        i5 = 0;
                    } else {
                        int i6 = i4 + 1;
                        while (i6 < str.length() && str.charAt(i6) == charAt) {
                            i6++;
                        }
                        i2 = i6 - i4;
                        i4 = i6;
                    }
                    if (i5 == 0) {
                        throw new IllegalArgumentException(f.a.a.a.a.t("Pad letter 'p' must be followed by valid pad pattern: ", str));
                    } else if (i5 >= 1) {
                        d dVar = this.a;
                        dVar.f4133e = i5;
                        dVar.f4134f = ' ';
                        dVar.f4135g = -1;
                        i5 = i2;
                    } else {
                        throw new IllegalArgumentException(f.a.a.a.a.q("The pad width must be at least one but was ", i5));
                    }
                }
                l.b.a.w.j jVar = f4130i.get(Character.valueOf(charAt));
                if (jVar != null) {
                    p pVar3 = p.NARROW_STANDALONE;
                    p pVar4 = p.FULL_STANDALONE;
                    p pVar5 = p.SHORT_STANDALONE;
                    p pVar6 = p.NARROW;
                    if (charAt != 'Q') {
                        if (charAt != 'S') {
                            if (charAt != 'a') {
                                if (!(charAt == 'h' || charAt == 'k' || charAt == 'm')) {
                                    if (charAt != 'q') {
                                        if (charAt != 's') {
                                            if (charAt != 'u' && charAt != 'y') {
                                                switch (charAt) {
                                                    case 'D':
                                                        if (i5 != 1) {
                                                            if (i5 > 3) {
                                                                throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                                            }
                                                            m(jVar, i5);
                                                            break;
                                                        }
                                                        l(jVar);
                                                        break;
                                                    case 'E':
                                                    case 'G':
                                                        if (!(i5 == 1 || i5 == 2 || i5 == 3)) {
                                                            if (i5 != 4) {
                                                                if (i5 != 5) {
                                                                    throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                                                }
                                                                j(jVar, pVar6);
                                                                break;
                                                            }
                                                            j(jVar, pVar2);
                                                            break;
                                                        }
                                                    case 'F':
                                                        if (i5 != 1) {
                                                            throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                                        }
                                                        l(jVar);
                                                        break;
                                                    default:
                                                        switch (charAt) {
                                                            case 'K':
                                                                break;
                                                            case 'L':
                                                                break;
                                                            case 'M':
                                                                break;
                                                            default:
                                                                switch (charAt) {
                                                                    case 'c':
                                                                        if (i5 == 1) {
                                                                            rVar2 = new r('c', i5);
                                                                            c(rVar2);
                                                                            break;
                                                                        } else if (i5 != 2) {
                                                                            if (i5 != 3) {
                                                                                if (i5 != 4) {
                                                                                    if (i5 != 5) {
                                                                                        throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                                                                    }
                                                                                    j(jVar, pVar3);
                                                                                    break;
                                                                                }
                                                                                j(jVar, pVar4);
                                                                                break;
                                                                            }
                                                                            j(jVar, pVar5);
                                                                            break;
                                                                        } else {
                                                                            throw new IllegalArgumentException(f.a.a.a.a.p("Invalid number of pattern letters: ", charAt));
                                                                        }
                                                                    case 'e':
                                                                        if (i5 != 1 && i5 != 2) {
                                                                            if (i5 != 3) {
                                                                                if (i5 != 4) {
                                                                                    if (i5 != 5) {
                                                                                        throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                                                                    }
                                                                                    j(jVar, pVar6);
                                                                                    break;
                                                                                }
                                                                                j(jVar, pVar2);
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            rVar2 = new r('e', i5);
                                                                            c(rVar2);
                                                                            break;
                                                                        }
                                                                        break;
                                                                }
                                                        }
                                                    case 'H':
                                                        if (i5 != 1) {
                                                            if (i5 != 2) {
                                                                throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                                            }
                                                            m(jVar, i5);
                                                            break;
                                                        }
                                                        l(jVar);
                                                        break;
                                                }
                                            } else if (i5 == 2) {
                                                l.b.a.e eVar = n.f4145j;
                                                f.b.a.c.b.o.b.B1(jVar, "field");
                                                f.b.a.c.b.o.b.B1(eVar, "baseDate");
                                                k(new n(jVar, 2, 2, 0, eVar));
                                            } else {
                                                n(jVar, i5, 19, i5 < 4 ? m.NORMAL : m.EXCEEDS_PAD);
                                            }
                                        }
                                    }
                                    if (i5 != 1) {
                                        if (i5 != 2) {
                                            if (i5 != 3) {
                                                if (i5 != 4) {
                                                    if (i5 != 5) {
                                                        throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                                    }
                                                    j(jVar, pVar3);
                                                }
                                                j(jVar, pVar4);
                                            }
                                            j(jVar, pVar5);
                                        }
                                        i5 = 2;
                                        m(jVar, i5);
                                    }
                                    l(jVar);
                                }
                                if (i5 != 1) {
                                }
                                l(jVar);
                            } else if (i5 != 1) {
                                throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                            }
                            j(jVar, pVar);
                        } else {
                            b(l.b.a.w.a.NANO_OF_SECOND, i5, i5, false);
                        }
                    }
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 != 4) {
                                    if (i5 != 5) {
                                        throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                                    }
                                    j(jVar, pVar6);
                                }
                                j(jVar, pVar2);
                            }
                            j(jVar, pVar);
                        }
                        i5 = 2;
                        m(jVar, i5);
                    }
                    l(jVar);
                } else if (charAt == 'z') {
                    if (i5 <= 4) {
                        c(i5 == 4 ? new t(pVar2) : new t(pVar));
                    } else {
                        throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                    }
                } else if (charAt != 'V') {
                    String str4 = "+0000";
                    if (charAt == 'Z') {
                        if (i5 < 4) {
                            str2 = "+HHMM";
                            g(str2, str4);
                        } else if (i5 != 4) {
                            if (i5 == 5) {
                                str3 = "+HH:MM:ss";
                                g(str3, "Z");
                            } else {
                                throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                            }
                        }
                    } else if (charAt == 'O') {
                        if (i5 == 1) {
                            f(pVar);
                        } else if (i5 != 4) {
                            throw new IllegalArgumentException(f.a.a.a.a.p("Pattern letter count must be 1 or 4: ", charAt));
                        }
                    } else if (charAt == 'X') {
                        if (i5 <= 5) {
                            str3 = l.f4142d[i5 + (i5 == 1 ? 0 : 1)];
                            g(str3, "Z");
                        } else {
                            throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                        }
                    } else if (charAt != 'x') {
                        if (charAt == 'W') {
                            if (i5 <= 1) {
                                rVar = new r('W', i5);
                            } else {
                                throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                            }
                        } else if (charAt == 'w') {
                            if (i5 <= 2) {
                                rVar = new r('w', i5);
                            } else {
                                throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                            }
                        } else if (charAt == 'Y') {
                            rVar = new r('Y', i5);
                        } else {
                            throw new IllegalArgumentException(f.a.a.a.a.p("Unknown pattern letter: ", charAt));
                        }
                        c(rVar);
                    } else if (i5 <= 5) {
                        if (i5 == 1) {
                            str4 = "+00";
                        } else if (i5 % 2 != 0) {
                            str4 = "+00:00";
                        }
                        str2 = l.f4142d[i5 + (i5 == 1 ? 0 : 1)];
                        g(str2, str4);
                    } else {
                        throw new IllegalArgumentException(f.a.a.a.a.p("Too many pattern letters: ", charAt));
                    }
                    f(pVar2);
                } else if (i5 == 2) {
                    c(new s(l.b.a.w.k.a, "ZoneId()"));
                } else {
                    throw new IllegalArgumentException(f.a.a.a.a.p("Pattern letter count must be 2: ", charAt));
                }
                i3 = i4 - 1;
            } else if (charAt == '\'') {
                int i7 = i3 + 1;
                int i8 = i7;
                while (i8 < str.length()) {
                    if (str.charAt(i8) == '\'') {
                        int i9 = i8 + 1;
                        if (i9 < str.length() && str.charAt(i9) == '\'') {
                            i8 = i9;
                        }
                        if (i8 >= str.length()) {
                            String substring = str.substring(i7, i8);
                            if (substring.length() == 0) {
                                d('\'');
                            } else {
                                e(substring.replace("''", "'"));
                            }
                            i3 = i8;
                        } else {
                            throw new IllegalArgumentException(f.a.a.a.a.t("Pattern ends with an incomplete string literal: ", str));
                        }
                    }
                    i8++;
                }
                if (i8 >= str.length()) {
                }
            } else if (charAt == '[') {
                p();
            } else if (charAt == ']') {
                if (this.a.b != null) {
                    o();
                } else {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
            } else if (charAt == '{' || charAt == '}' || charAt == '#') {
                throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
            } else {
                d(charAt);
            }
            i3++;
        }
        return this;
    }

    public d i(l.b.a.w.j jVar, Map<Long, String> map) {
        f.b.a.c.b.o.b.B1(jVar, "field");
        f.b.a.c.b.o.b.B1(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        p pVar = p.FULL;
        c(new q(jVar, pVar, new b(this, new o.b(Collections.singletonMap(pVar, linkedHashMap)))));
        return this;
    }

    public d j(l.b.a.w.j jVar, p pVar) {
        f.b.a.c.b.o.b.B1(jVar, "field");
        f.b.a.c.b.o.b.B1(pVar, "textStyle");
        AtomicReference<i> atomicReference = i.a;
        c(new q(jVar, pVar, i.a.a));
        return this;
    }

    public final d k(k kVar) {
        k kVar2;
        d dVar = this.a;
        int i2 = dVar.f4135g;
        if (i2 < 0 || !(dVar.c.get(i2) instanceof k)) {
            this.a.f4135g = c(kVar);
        } else {
            d dVar2 = this.a;
            int i3 = dVar2.f4135g;
            k kVar3 = (k) dVar2.c.get(i3);
            int i4 = kVar.c;
            int i5 = kVar.f4139d;
            if (i4 == i5 && kVar.f4140e == m.NOT_NEGATIVE) {
                kVar2 = kVar3.g(i5);
                c(kVar.f());
                this.a.f4135g = i3;
            } else {
                kVar2 = kVar3.f();
                this.a.f4135g = c(kVar);
            }
            this.a.c.set(i3, kVar2);
        }
        return this;
    }

    public d l(l.b.a.w.j jVar) {
        f.b.a.c.b.o.b.B1(jVar, "field");
        k(new k(jVar, 1, 19, m.NORMAL));
        return this;
    }

    public d m(l.b.a.w.j jVar, int i2) {
        f.b.a.c.b.o.b.B1(jVar, "field");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException(f.a.a.a.a.q("The width must be from 1 to 19 inclusive but was ", i2));
        }
        k(new k(jVar, i2, i2, m.NOT_NEGATIVE));
        return this;
    }

    public d n(l.b.a.w.j jVar, int i2, int i3, m mVar) {
        if (i2 == i3 && mVar == m.NOT_NEGATIVE) {
            m(jVar, i3);
            return this;
        }
        f.b.a.c.b.o.b.B1(jVar, "field");
        f.b.a.c.b.o.b.B1(mVar, "signStyle");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException(f.a.a.a.a.q("The minimum width must be from 1 to 19 inclusive but was ", i2));
        } else if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException(f.a.a.a.a.q("The maximum width must be from 1 to 19 inclusive but was ", i3));
        } else if (i3 >= i2) {
            k(new k(jVar, i2, i3, mVar));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
        }
    }

    public d o() {
        d dVar = this.a;
        if (dVar.b != null) {
            if (dVar.c.size() > 0) {
                d dVar2 = this.a;
                e eVar = new e(dVar2.c, dVar2.f4132d);
                this.a = this.a.b;
                c(eVar);
            } else {
                this.a = this.a.b;
            }
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public d p() {
        d dVar = this.a;
        dVar.f4135g = -1;
        this.a = new d(dVar, true);
        return this;
    }

    public c q() {
        return r(Locale.getDefault());
    }

    public c r(Locale locale) {
        f.b.a.c.b.o.b.B1(locale, "locale");
        while (this.a.b != null) {
            o();
        }
        return new c(new e(this.c, false), locale, j.f4166e, l.SMART, null, null, null);
    }

    public c s(l lVar) {
        c q2 = q();
        f.b.a.c.b.o.b.B1(lVar, "resolverStyle");
        return f.b.a.c.b.o.b.v0(q2.f4125d, lVar) ? q2 : new c(q2.a, q2.b, q2.c, lVar, q2.f4126e, q2.f4127f, q2.f4128g);
    }
}
