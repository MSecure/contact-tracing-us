package e.c.a.u;

import androidx.recyclerview.widget.RecyclerView;
import e.c.a.u.e;
import e.c.a.u.o;
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
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

public final class d {
    public static final e.c.a.w.l<e.c.a.p> h = new a();
    public static final Map<Character, e.c.a.w.j> i;
    public static final Comparator<String> j = new c();

    /* renamed from: a  reason: collision with root package name */
    public d f5063a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5064b;

    /* renamed from: c  reason: collision with root package name */
    public final List<f> f5065c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5066d;

    /* renamed from: e  reason: collision with root package name */
    public int f5067e;
    public char f;
    public int g;

    public class a implements e.c.a.w.l<e.c.a.p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public e.c.a.p a(e.c.a.w.e eVar) {
            e.c.a.p pVar = (e.c.a.p) eVar.f(e.c.a.w.k.f5177a);
            if (pVar == null || (pVar instanceof e.c.a.q)) {
                return null;
            }
            return pVar;
        }
    }

    public class b extends i {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o.b f5068b;

        public b(d dVar, o.b bVar) {
            this.f5068b = bVar;
        }

        @Override // e.c.a.u.i
        public String b(e.c.a.w.j jVar, long j, p pVar, Locale locale) {
            return this.f5068b.a(j, pVar);
        }

        @Override // e.c.a.u.i
        public Iterator<Map.Entry<String, Long>> c(e.c.a.w.j jVar, p pVar, Locale locale) {
            List<Map.Entry<String, Long>> list = this.f5068b.f5150b.get(pVar);
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

    /* renamed from: e.c.a.u.d$d  reason: collision with other inner class name */
    public static final class C0121d implements f {

        /* renamed from: b  reason: collision with root package name */
        public final char f5069b;

        public C0121d(char c2) {
            this.f5069b = c2;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            sb.append(this.f5069b);
            return true;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            if (i == charSequence.length()) {
                return ~i;
            }
            return !eVar.a(this.f5069b, charSequence.charAt(i)) ? ~i : i + 1;
        }

        public String toString() {
            if (this.f5069b == '\'') {
                return "''";
            }
            StringBuilder g = c.a.a.a.a.g("'");
            g.append(this.f5069b);
            g.append("'");
            return g.toString();
        }
    }

    public static final class e implements f {

        /* renamed from: b  reason: collision with root package name */
        public final f[] f5070b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5071c;

        public e(List<f> list, boolean z) {
            this.f5070b = (f[]) list.toArray(new f[list.size()]);
            this.f5071c = z;
        }

        public e(f[] fVarArr, boolean z) {
            this.f5070b = fVarArr;
            this.f5071c = z;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            int length = sb.length();
            if (this.f5071c) {
                hVar.f5126d++;
            }
            try {
                for (f fVar : this.f5070b) {
                    if (!fVar.b(hVar, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.f5071c) {
                    hVar.a();
                }
                return true;
            } finally {
                if (this.f5071c) {
                    hVar.a();
                }
            }
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            if (this.f5071c) {
                ArrayList<e.a> arrayList = eVar.g;
                e.a b2 = eVar.b();
                e.a aVar = new e.a();
                aVar.f5115b = b2.f5115b;
                aVar.f5116c = b2.f5116c;
                aVar.f5117d.putAll(b2.f5117d);
                aVar.f5118e = b2.f5118e;
                arrayList.add(aVar);
                int i2 = i;
                for (f fVar : this.f5070b) {
                    i2 = fVar.d(eVar, charSequence, i2);
                    if (i2 < 0) {
                        eVar.c(false);
                        return i;
                    }
                }
                eVar.c(true);
                return i2;
            }
            for (f fVar2 : this.f5070b) {
                i = fVar2.d(eVar, charSequence, i);
                if (i < 0) {
                    break;
                }
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f5070b != null) {
                sb.append(this.f5071c ? "[" : "(");
                for (f fVar : this.f5070b) {
                    sb.append(fVar);
                }
                sb.append(this.f5071c ? "]" : ")");
            }
            return sb.toString();
        }
    }

    public interface f {
        boolean b(h hVar, StringBuilder sb);

        int d(e eVar, CharSequence charSequence, int i);
    }

    public static final class g implements f {

        /* renamed from: b  reason: collision with root package name */
        public final e.c.a.w.j f5072b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5073c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5074d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5075e;

        public g(e.c.a.w.j jVar, int i, int i2, boolean z) {
            c.b.a.a.c.n.c.T1(jVar, "field");
            e.c.a.w.o k = jVar.k();
            if (!(k.f5182b == k.f5183c && k.f5184d == k.f5185e)) {
                throw new IllegalArgumentException(c.a.a.a.a.c("Field must have a fixed set of values: ", jVar));
            } else if (i < 0 || i > 9) {
                throw new IllegalArgumentException(c.a.a.a.a.l("Minimum width must be from 0 to 9 inclusive but was ", i));
            } else if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException(c.a.a.a.a.l("Maximum width must be from 1 to 9 inclusive but was ", i2));
            } else if (i2 >= i) {
                this.f5072b = jVar;
                this.f5073c = i;
                this.f5074d = i2;
                this.f5075e = z;
            } else {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
            }
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(this.f5072b);
            if (b2 == null) {
                return false;
            }
            j jVar = hVar.f5125c;
            long longValue = b2.longValue();
            e.c.a.w.o k = this.f5072b.k();
            k.b(longValue, this.f5072b);
            BigDecimal valueOf = BigDecimal.valueOf(k.f5182b);
            BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(k.f5185e).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
            if (stripTrailingZeros.scale() != 0) {
                String a2 = jVar.a(stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.f5073c), this.f5074d), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.f5075e) {
                    sb.append(jVar.f5133d);
                }
                sb.append(a2);
                return true;
            } else if (this.f5073c <= 0) {
                return true;
            } else {
                if (this.f5075e) {
                    sb.append(jVar.f5133d);
                }
                for (int i = 0; i < this.f5073c; i++) {
                    sb.append(jVar.f5130a);
                }
                return true;
            }
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            int i2;
            int i3 = eVar.f ? this.f5073c : 0;
            int i4 = eVar.f ? this.f5074d : 9;
            int length = charSequence.length();
            if (i == length) {
                return i3 > 0 ? ~i : i;
            }
            if (this.f5075e) {
                if (charSequence.charAt(i) != eVar.f5111b.f5133d) {
                    return i3 > 0 ? ~i : i;
                }
                i++;
            }
            int i5 = i3 + i;
            if (i5 > length) {
                return ~i;
            }
            int min = Math.min(i4 + i, length);
            int i6 = 0;
            int i7 = i;
            while (true) {
                if (i7 >= min) {
                    i2 = i7;
                    break;
                }
                int i8 = i7 + 1;
                int charAt = charSequence.charAt(i7) - eVar.f5111b.f5130a;
                if (charAt < 0 || charAt > 9) {
                    charAt = -1;
                }
                if (charAt >= 0) {
                    i6 = (i6 * 10) + charAt;
                    i7 = i8;
                } else if (i8 < i5) {
                    return ~i;
                } else {
                    i2 = i8 - 1;
                }
            }
            BigDecimal movePointLeft = new BigDecimal(i6).movePointLeft(i2 - i);
            e.c.a.w.o k = this.f5072b.k();
            BigDecimal valueOf = BigDecimal.valueOf(k.f5182b);
            return eVar.g(this.f5072b, movePointLeft.multiply(BigDecimal.valueOf(k.f5185e).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i, i2);
        }

        public String toString() {
            String str = this.f5075e ? ",DecimalPoint" : "";
            StringBuilder g = c.a.a.a.a.g("Fraction(");
            g.append(this.f5072b);
            g.append(",");
            g.append(this.f5073c);
            g.append(",");
            g.append(this.f5074d);
            g.append(str);
            g.append(")");
            return g.toString();
        }
    }

    public static final class h implements f {

        /* renamed from: b  reason: collision with root package name */
        public final int f5076b;

        public h(int i) {
            this.f5076b = i;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            int i;
            Long b2 = hVar.b(e.c.a.w.a.INSTANT_SECONDS);
            Long l = 0L;
            if (hVar.f5123a.i(e.c.a.w.a.NANO_OF_SECOND)) {
                l = Long.valueOf(hVar.f5123a.l(e.c.a.w.a.NANO_OF_SECOND));
            }
            int i2 = 0;
            if (b2 == null) {
                return false;
            }
            long longValue = b2.longValue();
            int o = e.c.a.w.a.NANO_OF_SECOND.o(l.longValue());
            if (longValue >= -62167219200L) {
                long j = (longValue - 315569520000L) + 62167219200L;
                long R0 = c.b.a.a.c.n.c.R0(j, 315569520000L) + 1;
                e.c.a.f J = e.c.a.f.J(c.b.a.a.c.n.c.U0(j, 315569520000L) - 62167219200L, 0, e.c.a.q.f);
                if (R0 > 0) {
                    sb.append('+');
                    sb.append(R0);
                }
                sb.append(J);
                if (J.f4976c.f4979d == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = longValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                e.c.a.f J2 = e.c.a.f.J(j4 - 62167219200L, 0, e.c.a.q.f);
                int length = sb.length();
                sb.append(J2);
                if (J2.f4976c.f4979d == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (J2.f4975b.f4970b == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else {
                        if (j4 != 0) {
                            length++;
                            j3 = Math.abs(j3);
                        }
                        sb.insert(length, j3);
                    }
                }
            }
            int i3 = this.f5076b;
            if (i3 == -2) {
                if (o != 0) {
                    sb.append('.');
                    int i4 = 1000000;
                    if (o % 1000000 == 0) {
                        i = (o / 1000000) + 1000;
                    } else {
                        if (o % 1000 == 0) {
                            o /= 1000;
                        } else {
                            i4 = 1000000000;
                        }
                        i = o + i4;
                    }
                    sb.append(Integer.toString(i).substring(1));
                }
            } else if (i3 > 0 || (i3 == -1 && o > 0)) {
                sb.append('.');
                int i5 = 100000000;
                while (true) {
                    if ((this.f5076b != -1 || o <= 0) && i2 >= this.f5076b) {
                        break;
                    }
                    int i6 = o / i5;
                    sb.append((char) (i6 + 48));
                    o -= i6 * i5;
                    i5 /= 10;
                    i2++;
                }
            }
            sb.append('Z');
            return true;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            int i2;
            int i3;
            if (eVar != null) {
                e eVar2 = new e(eVar);
                int i4 = this.f5076b;
                if (i4 < 0) {
                    i4 = 0;
                }
                int i5 = this.f5076b;
                if (i5 < 0) {
                    i5 = 9;
                }
                d dVar = new d();
                dVar.a(c.h);
                dVar.d('T');
                dVar.m(e.c.a.w.a.HOUR_OF_DAY, 2);
                dVar.d(':');
                dVar.m(e.c.a.w.a.MINUTE_OF_HOUR, 2);
                dVar.d(':');
                dVar.m(e.c.a.w.a.SECOND_OF_MINUTE, 2);
                dVar.b(e.c.a.w.a.NANO_OF_SECOND, i4, i5, true);
                dVar.d('Z');
                int d2 = dVar.q().e(false).d(eVar2, charSequence, i);
                if (d2 < 0) {
                    return d2;
                }
                long longValue = eVar2.e(e.c.a.w.a.YEAR).longValue();
                int intValue = eVar2.e(e.c.a.w.a.MONTH_OF_YEAR).intValue();
                int intValue2 = eVar2.e(e.c.a.w.a.DAY_OF_MONTH).intValue();
                int intValue3 = eVar2.e(e.c.a.w.a.HOUR_OF_DAY).intValue();
                int intValue4 = eVar2.e(e.c.a.w.a.MINUTE_OF_HOUR).intValue();
                Long e2 = eVar2.e(e.c.a.w.a.SECOND_OF_MINUTE);
                Long e3 = eVar2.e(e.c.a.w.a.NANO_OF_SECOND);
                int intValue5 = e2 != null ? e2.intValue() : 0;
                int intValue6 = e3 != null ? e3.intValue() : 0;
                int i6 = ((int) longValue) % 10000;
                if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                    i3 = 1;
                    i2 = intValue5;
                    intValue3 = 0;
                } else {
                    if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                        eVar.b().f5118e = true;
                        i2 = 59;
                    } else {
                        i2 = intValue5;
                    }
                    i3 = 0;
                }
                try {
                    return eVar.g(e.c.a.w.a.NANO_OF_SECOND, (long) intValue6, i, eVar.g(e.c.a.w.a.INSTANT_SECONDS, e.c.a.f.H(i6, intValue, intValue2, intValue3, intValue4, i2, 0).L((long) i3).x(e.c.a.q.f) + c.b.a.a.c.n.c.a2(longValue / 10000, 315569520000L), i, d2));
                } catch (RuntimeException unused) {
                    return ~i;
                }
            } else {
                throw null;
            }
        }

        public String toString() {
            return "Instant()";
        }
    }

    public static final class i implements f {

        /* renamed from: b  reason: collision with root package name */
        public final p f5077b;

        public i(p pVar) {
            this.f5077b = pVar;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(e.c.a.w.a.OFFSET_SECONDS);
            if (b2 == null) {
                return false;
            }
            sb.append("GMT");
            if (this.f5077b == p.FULL) {
                return new l("", "+HH:MM:ss").b(hVar, sb);
            }
            int d2 = c.b.a.a.c.n.c.d2(b2.longValue());
            if (d2 == 0) {
                return true;
            }
            int abs = Math.abs((d2 / 3600) % 100);
            int abs2 = Math.abs((d2 / 60) % 60);
            int abs3 = Math.abs(d2 % 60);
            sb.append(d2 < 0 ? "-" : "+");
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

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            char charAt;
            if (!eVar.h(charSequence, i, "GMT", 0, 3)) {
                return ~i;
            }
            int i2 = i + 3;
            if (this.f5077b == p.FULL) {
                return new l("", "+HH:MM:ss").d(eVar, charSequence, i2);
            }
            int length = charSequence.length();
            if (i2 == length) {
                return eVar.g(e.c.a.w.a.OFFSET_SECONDS, 0, i2, i2);
            }
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 != '+' && charAt2 != '-') {
                return eVar.g(e.c.a.w.a.OFFSET_SECONDS, 0, i2, i2);
            }
            int i3 = charAt2 == '-' ? -1 : 1;
            if (i2 == length) {
                return ~i2;
            }
            int i4 = i2 + 1;
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i4;
            }
            int i5 = i4 + 1;
            int i6 = charAt3 - '0';
            if (i5 != length && (charAt = charSequence.charAt(i5)) >= '0' && charAt <= '9') {
                i6 = (i6 * 10) + (charAt - '0');
                if (i6 > 23) {
                    return ~i5;
                }
                i5++;
            }
            if (i5 == length || charSequence.charAt(i5) != ':') {
                return eVar.g(e.c.a.w.a.OFFSET_SECONDS, (long) (i3 * 3600 * i6), i5, i5);
            }
            int i7 = i5 + 1;
            int i8 = length - 2;
            if (i7 > i8) {
                return ~i7;
            }
            char charAt4 = charSequence.charAt(i7);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i7;
            }
            int i9 = i7 + 1;
            int i10 = charAt4 - '0';
            char charAt5 = charSequence.charAt(i9);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i9;
            }
            int i11 = i9 + 1;
            int i12 = (charAt5 - '0') + (i10 * 10);
            if (i12 > 59) {
                return ~i11;
            }
            if (i11 == length || charSequence.charAt(i11) != ':') {
                return eVar.g(e.c.a.w.a.OFFSET_SECONDS, (long) c.a.a.a.a.a(i12, 60, i6 * 3600, i3), i11, i11);
            }
            int i13 = i11 + 1;
            if (i13 > i8) {
                return ~i13;
            }
            char charAt6 = charSequence.charAt(i13);
            if (charAt6 < '0' || charAt6 > '9') {
                return ~i13;
            }
            int i14 = i13 + 1;
            int i15 = charAt6 - '0';
            char charAt7 = charSequence.charAt(i14);
            if (charAt7 < '0' || charAt7 > '9') {
                return ~i14;
            }
            int i16 = i14 + 1;
            int i17 = (charAt7 - '0') + (i15 * 10);
            return i17 > 59 ? ~i16 : eVar.g(e.c.a.w.a.OFFSET_SECONDS, (long) (((i12 * 60) + (i6 * 3600) + i17) * i3), i16, i16);
        }
    }

    public static final class j implements f {

        /* renamed from: b  reason: collision with root package name */
        public final k f5078b;

        /* renamed from: c  reason: collision with root package name */
        public final k f5079c;

        public j(k kVar, k kVar2) {
            this.f5078b = kVar;
            this.f5079c = kVar2;
        }

        public final c a(Locale locale, e.c.a.t.h hVar) {
            DateFormat dateFormat;
            k kVar = this.f5078b;
            k kVar2 = this.f5079c;
            if (kVar == null && kVar2 == null) {
                throw new IllegalArgumentException("Date and Time style must not both be null");
            }
            String str = hVar.p() + '|' + locale.toString() + '|' + kVar + kVar2;
            Object obj = n.f5146a.get(str);
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
                    n.f5146a.putIfAbsent(str, r);
                    return r;
                }
                n.f5146a.putIfAbsent(str, "");
                throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
            } else if (!obj.equals("")) {
                return (c) obj;
            } else {
                throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
            }
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            a(hVar.f5124b, e.c.a.t.h.n(hVar.f5123a)).e(false).b(hVar, sb);
            return true;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            return a(eVar.f5110a, eVar.d()).e(false).d(eVar, charSequence, i);
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("Localized(");
            Object obj = this.f5078b;
            Object obj2 = "";
            if (obj == null) {
                obj = obj2;
            }
            g.append(obj);
            g.append(",");
            k kVar = this.f5079c;
            if (kVar != null) {
                obj2 = kVar;
            }
            g.append(obj2);
            g.append(")");
            return g.toString();
        }
    }

    public static class k implements f {
        public static final int[] g = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

        /* renamed from: b  reason: collision with root package name */
        public final e.c.a.w.j f5080b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5081c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5082d;

        /* renamed from: e  reason: collision with root package name */
        public final m f5083e;
        public final int f;

        public k(e.c.a.w.j jVar, int i, int i2, m mVar) {
            this.f5080b = jVar;
            this.f5081c = i;
            this.f5082d = i2;
            this.f5083e = mVar;
            this.f = 0;
        }

        public k(e.c.a.w.j jVar, int i, int i2, m mVar, int i3) {
            this.f5080b = jVar;
            this.f5081c = i;
            this.f5082d = i2;
            this.f5083e = mVar;
            this.f = i3;
        }

        public k(e.c.a.w.j jVar, int i, int i2, m mVar, int i3, a aVar) {
            this.f5080b = jVar;
            this.f5081c = i;
            this.f5082d = i2;
            this.f5083e = mVar;
            this.f = i3;
        }

        public long a(h hVar, long j) {
            return j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
            if (r4 != 4) goto L_0x008d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[LOOP:0: B:29:0x008d->B:31:0x0096, LOOP_END] */
        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            String str;
            char c2;
            int i;
            Long b2 = hVar.b(this.f5080b);
            if (b2 == null) {
                return false;
            }
            long a2 = a(hVar, b2.longValue());
            j jVar = hVar.f5125c;
            if (a2 == Long.MIN_VALUE) {
                str = "9223372036854775808";
            } else {
                str = Long.toString(Math.abs(a2));
            }
            if (str.length() <= this.f5082d) {
                String a3 = jVar.a(str);
                if (a2 >= 0) {
                    int ordinal = this.f5083e.ordinal();
                    if (ordinal == 1 || (ordinal == 4 && (i = this.f5081c) < 19 && a2 >= ((long) g[i]))) {
                        c2 = jVar.f5131b;
                    }
                    for (int i2 = 0; i2 < this.f5081c - a3.length(); i2++) {
                        sb.append(jVar.f5130a);
                    }
                    sb.append(a3);
                    return true;
                }
                int ordinal2 = this.f5083e.ordinal();
                if (!(ordinal2 == 0 || ordinal2 == 1)) {
                    if (ordinal2 == 3) {
                        StringBuilder g2 = c.a.a.a.a.g("Field ");
                        g2.append(this.f5080b);
                        g2.append(" cannot be printed as the value ");
                        g2.append(a2);
                        g2.append(" cannot be negative according to the SignStyle");
                        throw new e.c.a.a(g2.toString());
                    }
                }
                c2 = jVar.f5132c;
                sb.append(c2);
                while (i2 < this.f5081c - a3.length()) {
                }
                sb.append(a3);
                return true;
            }
            StringBuilder g3 = c.a.a.a.a.g("Field ");
            g3.append(this.f5080b);
            g3.append(" cannot be printed as the value ");
            g3.append(a2);
            g3.append(" exceeds the maximum print width of ");
            g3.append(this.f5082d);
            throw new e.c.a.a(g3.toString());
        }

        public boolean c(e eVar) {
            int i = this.f;
            return i == -1 || (i > 0 && this.f5081c == this.f5082d && this.f5083e == m.NOT_NEGATIVE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:107:0x0149  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x0166  */
        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            int i2;
            boolean z;
            boolean z2;
            BigInteger bigInteger;
            int i3;
            long j;
            long j2;
            int i4;
            long j3;
            int i5;
            int length = charSequence.length();
            if (i == length) {
                return ~i;
            }
            char charAt = charSequence.charAt(i);
            j jVar = eVar.f5111b;
            int i6 = 0;
            if (charAt == jVar.f5131b) {
                if (!this.f5083e.b(true, eVar.f, this.f5081c == this.f5082d)) {
                    return ~i;
                }
                i2 = i + 1;
                z2 = false;
                z = true;
            } else if (charAt == jVar.f5132c) {
                if (!this.f5083e.b(false, eVar.f, this.f5081c == this.f5082d)) {
                    return ~i;
                }
                i2 = i + 1;
                z = false;
                z2 = true;
            } else if (this.f5083e == m.ALWAYS && eVar.f) {
                return ~i;
            } else {
                i2 = i;
                z2 = false;
                z = false;
            }
            int i7 = (eVar.f || c(eVar)) ? this.f5081c : 1;
            int i8 = i2 + i7;
            if (i8 > length) {
                return ~i2;
            }
            int i9 = 9;
            int max = Math.max(this.f, 0) + ((eVar.f || c(eVar)) ? this.f5082d : 9);
            while (true) {
                bigInteger = null;
                if (i6 >= 2) {
                    i3 = i2;
                    j = 0;
                    break;
                }
                int min = Math.min(max + i2, length);
                i4 = i2;
                j3 = 0;
                while (true) {
                    if (i4 >= min) {
                        break;
                    }
                    int i10 = i4 + 1;
                    int charAt2 = charSequence.charAt(i4) - eVar.f5111b.f5130a;
                    if (charAt2 < 0 || charAt2 > i9) {
                        charAt2 = -1;
                    }
                    if (charAt2 < 0) {
                        i4 = i10 - 1;
                        if (i4 < i8) {
                            return ~i2;
                        }
                    } else {
                        if (i10 - i2 > 18) {
                            if (bigInteger == null) {
                                bigInteger = BigInteger.valueOf(j3);
                            }
                            i5 = i8;
                            bigInteger = bigInteger.multiply(BigInteger.TEN).add(BigInteger.valueOf((long) charAt2));
                        } else {
                            i5 = i8;
                            j3 = (j3 * 10) + ((long) charAt2);
                        }
                        i8 = i5;
                        i4 = i10;
                        i9 = 9;
                    }
                }
                int i11 = this.f;
                if (i11 <= 0 || i6 != 0) {
                    i3 = i4;
                    j = j3;
                } else {
                    max = Math.max(i7, (i4 - i2) - i11);
                    i6++;
                    i8 = i8;
                    i9 = 9;
                }
            }
            i3 = i4;
            j = j3;
            if (z2) {
                if (bigInteger != null) {
                    if (bigInteger.equals(BigInteger.ZERO) && eVar.f) {
                        return ~(i2 - 1);
                    }
                    bigInteger = bigInteger.negate();
                } else if (j == 0 && eVar.f) {
                    return ~(i2 - 1);
                } else {
                    j2 = -j;
                    if (bigInteger != null) {
                        return e(eVar, j2, i2, i3);
                    }
                    if (bigInteger.bitLength() > 63) {
                        bigInteger = bigInteger.divide(BigInteger.TEN);
                        i3--;
                    }
                    return e(eVar, bigInteger.longValue(), i2, i3);
                }
            } else if (this.f5083e == m.EXCEEDS_PAD && eVar.f) {
                int i12 = i3 - i2;
                int i13 = this.f5081c;
                if (z) {
                    if (i12 <= i13) {
                        return ~(i2 - 1);
                    }
                } else if (i12 > i13) {
                    return ~i2;
                }
            }
            j2 = j;
            if (bigInteger != null) {
            }
        }

        public int e(e eVar, long j, int i, int i2) {
            return eVar.g(this.f5080b, j, i, i2);
        }

        public k f() {
            return this.f == -1 ? this : new k(this.f5080b, this.f5081c, this.f5082d, this.f5083e, -1);
        }

        public k g(int i) {
            return new k(this.f5080b, this.f5081c, this.f5082d, this.f5083e, this.f + i);
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            if (this.f5081c == 1 && this.f5082d == 19 && this.f5083e == m.NORMAL) {
                sb = c.a.a.a.a.g("Value(");
                obj = this.f5080b;
            } else if (this.f5081c == this.f5082d && this.f5083e == m.NOT_NEGATIVE) {
                sb = c.a.a.a.a.g("Value(");
                sb.append(this.f5080b);
                sb.append(",");
                sb.append(this.f5081c);
                sb.append(")");
                return sb.toString();
            } else {
                sb = c.a.a.a.a.g("Value(");
                sb.append(this.f5080b);
                sb.append(",");
                sb.append(this.f5081c);
                sb.append(",");
                sb.append(this.f5082d);
                sb.append(",");
                obj = this.f5083e;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class l implements f {

        /* renamed from: d  reason: collision with root package name */
        public static final String[] f5084d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

        /* renamed from: e  reason: collision with root package name */
        public static final l f5085e = new l("Z", "+HH:MM:ss");

        /* renamed from: b  reason: collision with root package name */
        public final String f5086b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5087c;

        public l(String str, String str2) {
            c.b.a.a.c.n.c.T1(str, "noOffsetText");
            c.b.a.a.c.n.c.T1(str2, "pattern");
            this.f5086b = str;
            int i = 0;
            while (true) {
                String[] strArr = f5084d;
                if (i >= strArr.length) {
                    throw new IllegalArgumentException(c.a.a.a.a.o("Invalid zone offset pattern: ", str2));
                } else if (strArr[i].equals(str2)) {
                    this.f5087c = i;
                    return;
                } else {
                    i++;
                }
            }
        }

        public final boolean a(int[] iArr, int i, CharSequence charSequence, boolean z) {
            int i2;
            int i3 = this.f5087c;
            if ((i3 + 3) / 2 < i) {
                return false;
            }
            int i4 = iArr[0];
            if (i3 % 2 == 0 && i > 1) {
                int i5 = i4 + 1;
                if (i5 > charSequence.length() || charSequence.charAt(i4) != ':') {
                    return z;
                }
                i4 = i5;
            }
            if (i4 + 2 > charSequence.length()) {
                return z;
            }
            int i6 = i4 + 1;
            char charAt = charSequence.charAt(i4);
            int i7 = i6 + 1;
            char charAt2 = charSequence.charAt(i6);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i2 = (charAt2 - '0') + ((charAt - '0') * 10)) < 0 || i2 > 59) {
                return z;
            }
            iArr[i] = i2;
            iArr[0] = i7;
            return false;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(e.c.a.w.a.OFFSET_SECONDS);
            if (b2 == null) {
                return false;
            }
            int d2 = c.b.a.a.c.n.c.d2(b2.longValue());
            if (d2 != 0) {
                int abs = Math.abs((d2 / 3600) % 100);
                int abs2 = Math.abs((d2 / 60) % 60);
                int abs3 = Math.abs(d2 % 60);
                int length = sb.length();
                sb.append(d2 < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i = this.f5087c;
                if (i >= 3 || (i >= 1 && abs2 > 0)) {
                    String str = ":";
                    sb.append(this.f5087c % 2 == 0 ? str : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i2 = this.f5087c;
                    if (i2 >= 7 || (i2 >= 5 && abs3 > 0)) {
                        if (this.f5087c % 2 != 0) {
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
            sb.append(this.f5086b);
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            if (r16.h(r17, r18, r15.f5086b, 0, r9) != false) goto L_0x0036;
         */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            boolean z;
            e.c.a.w.a aVar;
            e eVar2;
            long j;
            int i2;
            int i3;
            int length = charSequence.length();
            int length2 = this.f5086b.length();
            if (length2 == 0) {
                if (i == length) {
                    aVar = e.c.a.w.a.OFFSET_SECONDS;
                    j = 0;
                    eVar2 = eVar;
                    i2 = i;
                    i3 = i;
                }
                char charAt = charSequence.charAt(i);
                if (charAt == '+' || charAt == '-') {
                    int i4 = charAt == '-' ? -1 : 1;
                    int[] iArr = new int[4];
                    iArr[0] = i + 1;
                    if (!a(iArr, 1, charSequence, true)) {
                        if (!a(iArr, 2, charSequence, this.f5087c >= 3) && !a(iArr, 3, charSequence, false)) {
                            z = false;
                            if (!z) {
                                long j2 = (long) i4;
                                long j3 = ((long) iArr[2]) * 60;
                                aVar = e.c.a.w.a.OFFSET_SECONDS;
                                int i5 = iArr[0];
                                eVar2 = eVar;
                                j = (j3 + (((long) iArr[1]) * 3600) + ((long) iArr[3])) * j2;
                                i2 = i;
                                i3 = i5;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
                if (length2 != 0) {
                    return ~i;
                }
                aVar = e.c.a.w.a.OFFSET_SECONDS;
                j = 0;
                i3 = i + length2;
                eVar2 = eVar;
                i2 = i;
            } else if (i == length) {
                return ~i;
            }
            return eVar2.g(aVar, j, i2, i3);
        }

        public String toString() {
            String replace = this.f5086b.replace("'", "''");
            StringBuilder g = c.a.a.a.a.g("Offset(");
            g.append(f5084d[this.f5087c]);
            g.append(",'");
            g.append(replace);
            g.append("')");
            return g.toString();
        }
    }

    public static final class m implements f {

        /* renamed from: b  reason: collision with root package name */
        public final f f5088b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5089c;

        /* renamed from: d  reason: collision with root package name */
        public final char f5090d;

        public m(f fVar, int i, char c2) {
            this.f5088b = fVar;
            this.f5089c = i;
            this.f5090d = c2;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            int length = sb.length();
            if (!this.f5088b.b(hVar, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.f5089c) {
                for (int i = 0; i < this.f5089c - length2; i++) {
                    sb.insert(length, this.f5090d);
                }
                return true;
            }
            StringBuilder h = c.a.a.a.a.h("Cannot print as output of ", length2, " characters exceeds pad width of ");
            h.append(this.f5089c);
            throw new e.c.a.a(h.toString());
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            boolean z = eVar.f;
            boolean z2 = eVar.f5114e;
            if (i > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            } else if (i == charSequence.length()) {
                return ~i;
            } else {
                int i2 = this.f5089c + i;
                if (i2 > charSequence.length()) {
                    if (z) {
                        return ~i;
                    }
                    i2 = charSequence.length();
                }
                int i3 = i;
                while (i3 < i2) {
                    char charAt = charSequence.charAt(i3);
                    char c2 = this.f5090d;
                    if (!z2) {
                        if (!eVar.a(charAt, c2)) {
                            break;
                        }
                    } else if (charAt != c2) {
                        break;
                    }
                    i3++;
                }
                int d2 = this.f5088b.d(eVar, charSequence.subSequence(0, i2), i3);
                return (d2 == i2 || !z) ? d2 : ~(i + i3);
            }
        }

        public String toString() {
            String str;
            StringBuilder g = c.a.a.a.a.g("Pad(");
            g.append(this.f5088b);
            g.append(",");
            g.append(this.f5089c);
            if (this.f5090d == ' ') {
                str = ")";
            } else {
                StringBuilder g2 = c.a.a.a.a.g(",'");
                g2.append(this.f5090d);
                g2.append("')");
                str = g2.toString();
            }
            g.append(str);
            return g.toString();
        }
    }

    public static final class n extends k {
        public static final e.c.a.e j = e.c.a.e.P(RecyclerView.MAX_SCROLL_DURATION, 1, 1);
        public final int h;
        public final e.c.a.t.b i;

        public n(e.c.a.w.j jVar, int i2, int i3, int i4, e.c.a.t.b bVar) {
            super(jVar, i2, i3, m.NOT_NEGATIVE);
            if (i2 < 1 || i2 > 10) {
                throw new IllegalArgumentException(c.a.a.a.a.l("The width must be from 1 to 10 inclusive but was ", i2));
            } else if (i3 < 1 || i3 > 10) {
                throw new IllegalArgumentException(c.a.a.a.a.l("The maxWidth must be from 1 to 10 inclusive but was ", i3));
            } else if (i3 >= i2) {
                if (bVar == null) {
                    long j2 = (long) i4;
                    if (!jVar.k().c(j2)) {
                        throw new IllegalArgumentException("The base value must be within the range of the field");
                    } else if (j2 + ((long) k.g[i2]) > 2147483647L) {
                        throw new e.c.a.a("Unable to add printer-parser as the range exceeds the capacity of an int");
                    }
                }
                this.h = i4;
                this.i = bVar;
            } else {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            }
        }

        public n(e.c.a.w.j jVar, int i2, int i3, int i4, e.c.a.t.b bVar, int i5) {
            super(jVar, i2, i3, m.NOT_NEGATIVE, i5, null);
            this.h = i4;
            this.i = bVar;
        }

        @Override // e.c.a.u.d.k
        public long a(h hVar, long j2) {
            int i2;
            long abs = Math.abs(j2);
            int i3 = this.h;
            if (this.i != null) {
                i3 = e.c.a.t.h.n(hVar.f5123a).f(this.i).d(this.f5080b);
            }
            if (j2 >= ((long) i3)) {
                int[] iArr = k.g;
                int i4 = this.f5081c;
                if (j2 < ((long) (i3 + iArr[i4]))) {
                    i2 = iArr[i4];
                    return abs % ((long) i2);
                }
            }
            i2 = k.g[this.f5082d];
            return abs % ((long) i2);
        }

        @Override // e.c.a.u.d.k
        public boolean c(e eVar) {
            if (!eVar.f) {
                return false;
            }
            return super.c(eVar);
        }

        @Override // e.c.a.u.d.k
        public int e(e eVar, long j2, int i2, int i3) {
            int i4 = this.h;
            if (this.i != null) {
                i4 = eVar.d().f(this.i).d(this.f5080b);
                e.a b2 = eVar.b();
                if (b2.g == null) {
                    b2.g = new ArrayList(2);
                }
                b2.g.add(new Object[]{this, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            int i5 = i3 - i2;
            int i6 = this.f5081c;
            if (i5 == i6 && j2 >= 0) {
                long j3 = (long) k.g[i6];
                long j4 = (long) i4;
                long j5 = j4 - (j4 % j3);
                j2 = i4 > 0 ? j5 + j2 : j5 - j2;
                if (j2 < j4) {
                    j2 += j3;
                }
            }
            return eVar.g(this.f5080b, j2, i2, i3);
        }

        @Override // e.c.a.u.d.k
        public k f() {
            return this.f == -1 ? this : new n(this.f5080b, this.f5081c, this.f5082d, this.h, this.i, -1);
        }

        @Override // e.c.a.u.d.k
        public k g(int i2) {
            return new n(this.f5080b, this.f5081c, this.f5082d, this.h, this.i, this.f + i2);
        }

        @Override // e.c.a.u.d.k
        public String toString() {
            StringBuilder g = c.a.a.a.a.g("ReducedValue(");
            g.append(this.f5080b);
            g.append(",");
            g.append(this.f5081c);
            g.append(",");
            g.append(this.f5082d);
            g.append(",");
            Object obj = this.i;
            if (obj == null) {
                obj = Integer.valueOf(this.h);
            }
            g.append(obj);
            g.append(")");
            return g.toString();
        }
    }

    public enum o implements f {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            return true;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                eVar.f5114e = true;
            } else if (ordinal == 1) {
                eVar.f5114e = false;
            } else if (ordinal == 2) {
                eVar.f = true;
            } else if (ordinal == 3) {
                eVar.f = false;
            }
            return i;
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

        /* renamed from: b  reason: collision with root package name */
        public final String f5095b;

        public p(String str) {
            this.f5095b = str;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            sb.append(this.f5095b);
            return true;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            if (i > charSequence.length() || i < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.f5095b;
            return !eVar.h(charSequence, i, str, 0, str.length()) ? ~i : this.f5095b.length() + i;
        }

        public String toString() {
            return c.a.a.a.a.p("'", this.f5095b.replace("'", "''"), "'");
        }
    }

    public static final class q implements f {

        /* renamed from: b  reason: collision with root package name */
        public final e.c.a.w.j f5096b;

        /* renamed from: c  reason: collision with root package name */
        public final p f5097c;

        /* renamed from: d  reason: collision with root package name */
        public final i f5098d;

        /* renamed from: e  reason: collision with root package name */
        public volatile k f5099e;

        public q(e.c.a.w.j jVar, p pVar, i iVar) {
            this.f5096b = jVar;
            this.f5097c = pVar;
            this.f5098d = iVar;
        }

        public final k a() {
            if (this.f5099e == null) {
                this.f5099e = new k(this.f5096b, 1, 19, m.NORMAL);
            }
            return this.f5099e;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            Long b2 = hVar.b(this.f5096b);
            if (b2 == null) {
                return false;
            }
            String b3 = this.f5098d.b(this.f5096b, b2.longValue(), this.f5097c, hVar.f5124b);
            if (b3 == null) {
                return a().b(hVar, sb);
            }
            sb.append(b3);
            return true;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            int length = charSequence.length();
            if (i < 0 || i > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator<Map.Entry<String, Long>> c2 = this.f5098d.c(this.f5096b, eVar.f ? this.f5097c : null, eVar.f5110a);
            if (c2 != null) {
                while (c2.hasNext()) {
                    Map.Entry<String, Long> next = c2.next();
                    String key = next.getKey();
                    if (eVar.h(key, 0, charSequence, i, key.length())) {
                        return eVar.g(this.f5096b, next.getValue().longValue(), i, key.length() + i);
                    }
                }
                if (eVar.f) {
                    return ~i;
                }
            }
            return a().d(eVar, charSequence, i);
        }

        public String toString() {
            Object obj;
            StringBuilder sb;
            if (this.f5097c == p.FULL) {
                sb = c.a.a.a.a.g("Text(");
                obj = this.f5096b;
            } else {
                sb = c.a.a.a.a.g("Text(");
                sb.append(this.f5096b);
                sb.append(",");
                obj = this.f5097c;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class r implements f {

        /* renamed from: b  reason: collision with root package name */
        public final char f5100b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5101c;

        public r(char c2, int i) {
            this.f5100b = c2;
            this.f5101c = i;
        }

        public final f a(e.c.a.w.p pVar) {
            k kVar;
            f kVar2;
            m mVar = m.NOT_NEGATIVE;
            char c2 = this.f5100b;
            if (c2 == 'W') {
                kVar = new k(pVar.f5189e, 1, 2, mVar);
            } else if (c2 == 'Y') {
                int i = this.f5101c;
                if (i == 2) {
                    kVar2 = new n(pVar.g, 2, 2, 0, n.j);
                } else {
                    kVar2 = new k(pVar.g, i, 19, i < 4 ? m.NORMAL : m.EXCEEDS_PAD, -1, null);
                }
                return kVar2;
            } else if (c2 == 'c') {
                kVar = new k(pVar.f5188d, this.f5101c, 2, mVar);
            } else if (c2 == 'e') {
                kVar = new k(pVar.f5188d, this.f5101c, 2, mVar);
            } else if (c2 != 'w') {
                return null;
            } else {
                kVar = new k(pVar.f, this.f5101c, 2, mVar);
            }
            return kVar;
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            return a(e.c.a.w.p.a(hVar.f5124b)).b(hVar, sb);
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            return a(e.c.a.w.p.a(eVar.f5110a)).d(eVar, charSequence, i);
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c2 = this.f5100b;
            if (c2 == 'Y') {
                int i = this.f5101c;
                if (i == 1) {
                    str2 = "WeekBasedYear";
                } else if (i == 2) {
                    str2 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.f5101c);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.f5101c < 4 ? m.NORMAL : m.EXCEEDS_PAD);
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
                    sb.append(this.f5101c);
                }
                sb.append(str);
                sb.append(",");
                sb.append(this.f5101c);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class s implements f {

        /* renamed from: d  reason: collision with root package name */
        public static volatile Map.Entry<Integer, a> f5102d;

        /* renamed from: b  reason: collision with root package name */
        public final e.c.a.w.l<e.c.a.p> f5103b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5104c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final int f5105a;

            /* renamed from: b  reason: collision with root package name */
            public final Map<CharSequence, a> f5106b = new HashMap();

            /* renamed from: c  reason: collision with root package name */
            public final Map<String, a> f5107c = new HashMap();

            public a(int i) {
                this.f5105a = i;
            }

            public a(int i, a aVar) {
                this.f5105a = i;
            }

            public final void a(String str) {
                int length = str.length();
                int i = this.f5105a;
                if (length == i) {
                    this.f5106b.put(str, null);
                    this.f5107c.put(str.toLowerCase(Locale.ENGLISH), null);
                } else if (length > i) {
                    String substring = str.substring(0, i);
                    a aVar = this.f5106b.get(substring);
                    if (aVar == null) {
                        aVar = new a(length);
                        this.f5106b.put(substring, aVar);
                        this.f5107c.put(substring.toLowerCase(Locale.ENGLISH), aVar);
                    }
                    aVar.a(str);
                }
            }
        }

        public s(e.c.a.w.l<e.c.a.p> lVar, String str) {
            this.f5103b = lVar;
            this.f5104c = str;
        }

        public final e.c.a.p a(Set<String> set, String str, boolean z) {
            if (str == null) {
                return null;
            }
            if (!z) {
                for (String str2 : set) {
                    if (str2.equalsIgnoreCase(str)) {
                        return e.c.a.p.w(str2);
                    }
                }
                return null;
            } else if (set.contains(str)) {
                return e.c.a.p.w(str);
            } else {
                return null;
            }
        }

        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            e.c.a.p pVar = (e.c.a.p) hVar.c(this.f5103b);
            if (pVar == null) {
                return false;
            }
            sb.append(pVar.u());
            return true;
        }

        public final int c(e eVar, CharSequence charSequence, int i, int i2) {
            int d2;
            String upperCase = charSequence.subSequence(i, i2).toString().toUpperCase();
            e eVar2 = new e(eVar);
            if ((i2 >= charSequence.length() || !eVar.a(charSequence.charAt(i2), 'Z')) && (d2 = l.f5085e.d(eVar2, charSequence, i2)) >= 0) {
                eVar.f(e.c.a.p.x(upperCase, e.c.a.q.C((int) eVar2.e(e.c.a.w.a.OFFSET_SECONDS).longValue())));
                return d2;
            }
            eVar.f(e.c.a.p.x(upperCase, e.c.a.q.f));
            return i2;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            String str;
            Map map;
            int i2;
            int length = charSequence.length();
            if (i > length) {
                throw new IndexOutOfBoundsException();
            } else if (i == length) {
                return ~i;
            } else {
                char charAt = charSequence.charAt(i);
                String str2 = null;
                if (charAt != '+' && charAt != '-') {
                    int i3 = i + 2;
                    if (length >= i3) {
                        char charAt2 = charSequence.charAt(i + 1);
                        if (eVar.a(charAt, 'U') && eVar.a(charAt2, 'T')) {
                            int i4 = i + 3;
                            return (length < i4 || !eVar.a(charSequence.charAt(i3), 'C')) ? c(eVar, charSequence, i, i3) : c(eVar, charSequence, i, i4);
                        } else if (eVar.a(charAt, 'G') && length >= (i2 = i + 3) && eVar.a(charAt2, 'M') && eVar.a(charSequence.charAt(i3), 'T')) {
                            return c(eVar, charSequence, i, i2);
                        }
                    }
                    Set<String> unmodifiableSet = Collections.unmodifiableSet(e.c.a.x.i.f5221b.keySet());
                    int size = unmodifiableSet.size();
                    Map.Entry<Integer, a> entry = f5102d;
                    if (entry == null || entry.getKey().intValue() != size) {
                        synchronized (this) {
                            entry = f5102d;
                            if (entry == null || entry.getKey().intValue() != size) {
                                Integer valueOf = Integer.valueOf(size);
                                ArrayList arrayList = new ArrayList(unmodifiableSet);
                                Collections.sort(arrayList, d.j);
                                a aVar = new a(((String) arrayList.get(0)).length(), null);
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    aVar.a((String) it.next());
                                }
                                entry = new AbstractMap.SimpleImmutableEntry<>(valueOf, aVar);
                                f5102d = entry;
                            }
                        }
                    }
                    a value = entry.getValue();
                    String str3 = null;
                    while (value != null) {
                        int i5 = value.f5105a + i;
                        if (i5 > length) {
                            break;
                        }
                        String charSequence2 = charSequence.subSequence(i, i5).toString();
                        if (eVar.f5114e) {
                            map = value.f5106b;
                            str = charSequence2;
                        } else {
                            map = value.f5107c;
                            str = charSequence2.toString().toLowerCase(Locale.ENGLISH);
                        }
                        value = (a) map.get(str);
                        str3 = str2;
                        str2 = charSequence2;
                    }
                    e.c.a.p a2 = a(unmodifiableSet, str2, eVar.f5114e);
                    if (a2 == null) {
                        a2 = a(unmodifiableSet, str3, eVar.f5114e);
                        if (a2 != null) {
                            str2 = str3;
                        } else if (!eVar.a(charAt, 'Z')) {
                            return ~i;
                        } else {
                            eVar.f(e.c.a.q.f);
                            return i + 1;
                        }
                    }
                    eVar.f(a2);
                    return str2.length() + i;
                } else if (eVar != null) {
                    e eVar2 = new e(eVar);
                    int d2 = l.f5085e.d(eVar2, charSequence, i);
                    if (d2 < 0) {
                        return d2;
                    }
                    eVar.f(e.c.a.q.C((int) eVar2.e(e.c.a.w.a.OFFSET_SECONDS).longValue()));
                    return d2;
                } else {
                    throw null;
                }
            }
        }

        public String toString() {
            return this.f5104c;
        }
    }

    public static final class t implements f {

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<String> f5108c = new a();

        /* renamed from: b  reason: collision with root package name */
        public final p f5109b;

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
            c.b.a.a.c.n.c.T1(pVar, "textStyle");
            this.f5109b = pVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        @Override // e.c.a.u.d.f
        public boolean b(h hVar, StringBuilder sb) {
            e.c.a.q qVar;
            String str;
            boolean z;
            e.c.a.p pVar = (e.c.a.p) hVar.c(e.c.a.w.k.f5177a);
            int i = 0;
            if (pVar == null) {
                return false;
            }
            try {
                e.c.a.x.f v = pVar.v();
                if (v.e()) {
                    qVar = v.a(e.c.a.d.f4966d);
                    if (!(qVar instanceof e.c.a.q)) {
                        str = pVar.u();
                    } else {
                        e.c.a.w.e eVar = hVar.f5123a;
                        if (eVar.i(e.c.a.w.a.INSTANT_SECONDS)) {
                            z = pVar.v().d(e.c.a.d.s(eVar.l(e.c.a.w.a.INSTANT_SECONDS), 0));
                        } else {
                            z = false;
                        }
                        TimeZone timeZone = TimeZone.getTimeZone(pVar.u());
                        p pVar2 = this.f5109b;
                        if (pVar2 != null) {
                            if (p.values()[pVar2.ordinal() & -2] == p.FULL) {
                                i = 1;
                            }
                            str = timeZone.getDisplayName(z, i, hVar.f5124b);
                        } else {
                            throw null;
                        }
                    }
                    sb.append(str);
                    return true;
                }
            } catch (e.c.a.x.g unused) {
            }
            qVar = pVar;
            if (!(qVar instanceof e.c.a.q)) {
            }
            sb.append(str);
            return true;
        }

        @Override // e.c.a.u.d.f
        public int d(e eVar, CharSequence charSequence, int i) {
            TreeMap treeMap = new TreeMap(f5108c);
            Iterator it = ((HashSet) e.c.a.p.t()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                treeMap.put(str, str);
                TimeZone timeZone = TimeZone.getTimeZone(str);
                p pVar = this.f5109b;
                if (pVar != null) {
                    int i2 = p.values()[pVar.ordinal() & -2] == p.FULL ? 1 : 0;
                    String displayName = timeZone.getDisplayName(false, i2, eVar.f5110a);
                    if (str.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                        treeMap.put(displayName, str);
                    }
                    String displayName2 = timeZone.getDisplayName(true, i2, eVar.f5110a);
                    if (str.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                        treeMap.put(displayName2, str);
                    }
                } else {
                    throw null;
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str2 = (String) entry.getKey();
                if (eVar.h(charSequence, i, str2, 0, str2.length())) {
                    eVar.f(e.c.a.p.w((String) entry.getValue()));
                    return str2.length() + i;
                }
            }
            return ~i;
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("ZoneText(");
            g.append(this.f5109b);
            g.append(")");
            return g.toString();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put('G', e.c.a.w.a.ERA);
        i.put('y', e.c.a.w.a.YEAR_OF_ERA);
        i.put('u', e.c.a.w.a.YEAR);
        i.put('Q', e.c.a.w.c.f5163a);
        i.put('q', e.c.a.w.c.f5163a);
        i.put('M', e.c.a.w.a.MONTH_OF_YEAR);
        i.put('L', e.c.a.w.a.MONTH_OF_YEAR);
        i.put('D', e.c.a.w.a.DAY_OF_YEAR);
        i.put('d', e.c.a.w.a.DAY_OF_MONTH);
        i.put('F', e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        i.put('E', e.c.a.w.a.DAY_OF_WEEK);
        i.put('c', e.c.a.w.a.DAY_OF_WEEK);
        i.put('e', e.c.a.w.a.DAY_OF_WEEK);
        i.put('a', e.c.a.w.a.AMPM_OF_DAY);
        i.put('H', e.c.a.w.a.HOUR_OF_DAY);
        i.put('k', e.c.a.w.a.CLOCK_HOUR_OF_DAY);
        i.put('K', e.c.a.w.a.HOUR_OF_AMPM);
        i.put('h', e.c.a.w.a.CLOCK_HOUR_OF_AMPM);
        i.put('m', e.c.a.w.a.MINUTE_OF_HOUR);
        i.put('s', e.c.a.w.a.SECOND_OF_MINUTE);
        i.put('S', e.c.a.w.a.NANO_OF_SECOND);
        i.put('A', e.c.a.w.a.MILLI_OF_DAY);
        i.put('n', e.c.a.w.a.NANO_OF_SECOND);
        i.put('N', e.c.a.w.a.NANO_OF_DAY);
    }

    public d() {
        this.f5063a = this;
        this.f5065c = new ArrayList();
        this.g = -1;
        this.f5064b = null;
        this.f5066d = false;
    }

    public d(d dVar, boolean z) {
        this.f5063a = this;
        this.f5065c = new ArrayList();
        this.g = -1;
        this.f5064b = dVar;
        this.f5066d = z;
    }

    public d a(c cVar) {
        c.b.a.a.c.n.c.T1(cVar, "formatter");
        c(cVar.e(false));
        return this;
    }

    public d b(e.c.a.w.j jVar, int i2, int i3, boolean z) {
        c(new g(jVar, i2, i3, z));
        return this;
    }

    public final int c(f fVar) {
        c.b.a.a.c.n.c.T1(fVar, "pp");
        d dVar = this.f5063a;
        int i2 = dVar.f5067e;
        if (i2 > 0) {
            m mVar = new m(fVar, i2, dVar.f);
            d dVar2 = this.f5063a;
            dVar2.f5067e = 0;
            dVar2.f = 0;
            fVar = mVar;
        }
        this.f5063a.f5065c.add(fVar);
        d dVar3 = this.f5063a;
        dVar3.g = -1;
        return dVar3.f5065c.size() - 1;
    }

    public d d(char c2) {
        c(new C0121d(c2));
        return this;
    }

    public d e(String str) {
        c.b.a.a.c.n.c.T1(str, "literal");
        if (str.length() > 0) {
            c(str.length() == 1 ? new C0121d(str.charAt(0)) : new p(str));
        }
        return this;
    }

    public d f(p pVar) {
        c.b.a.a.c.n.c.T1(pVar, "style");
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
        if (r4 == 1) goto L_0x021e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0383 A[SYNTHETIC] */
    public d h(String str) {
        String str2;
        String str3;
        r rVar;
        int i2;
        r rVar2;
        int i3;
        c.b.a.a.c.n.c.T1(str, "pattern");
        p pVar = p.SHORT;
        p pVar2 = p.FULL;
        int i4 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int i5 = i4 + 1;
                while (i5 < str.length() && str.charAt(i5) == charAt) {
                    i5++;
                }
                int i6 = i5 - i4;
                if (charAt == 'p') {
                    if (i5 >= str.length() || (((charAt = str.charAt(i5)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        i3 = i6;
                        i6 = 0;
                    } else {
                        int i7 = i5 + 1;
                        while (i7 < str.length() && str.charAt(i7) == charAt) {
                            i7++;
                        }
                        i3 = i7 - i5;
                        i5 = i7;
                    }
                    if (i6 == 0) {
                        throw new IllegalArgumentException(c.a.a.a.a.o("Pad letter 'p' must be followed by valid pad pattern: ", str));
                    } else if (i6 >= 1) {
                        d dVar = this.f5063a;
                        dVar.f5067e = i6;
                        dVar.f = ' ';
                        dVar.g = -1;
                        i6 = i3;
                    } else {
                        throw new IllegalArgumentException(c.a.a.a.a.l("The pad width must be at least one but was ", i6));
                    }
                }
                e.c.a.w.j jVar = i.get(Character.valueOf(charAt));
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
                                                        if (i6 != 1) {
                                                            if (i6 > 3) {
                                                                throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                                            }
                                                            m(jVar, i6);
                                                            break;
                                                        }
                                                        l(jVar);
                                                        break;
                                                    case 'E':
                                                    case 'G':
                                                        if (!(i6 == 1 || i6 == 2 || i6 == 3)) {
                                                            if (i6 != 4) {
                                                                if (i6 != 5) {
                                                                    throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                                                }
                                                                j(jVar, pVar6);
                                                                break;
                                                            }
                                                            j(jVar, pVar2);
                                                            break;
                                                        }
                                                    case 'F':
                                                        if (i6 != 1) {
                                                            throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
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
                                                                        if (i6 == 1) {
                                                                            rVar2 = new r('c', i6);
                                                                            c(rVar2);
                                                                            break;
                                                                        } else if (i6 != 2) {
                                                                            if (i6 != 3) {
                                                                                if (i6 != 4) {
                                                                                    if (i6 != 5) {
                                                                                        throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
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
                                                                            throw new IllegalArgumentException(c.a.a.a.a.k("Invalid number of pattern letters: ", charAt));
                                                                        }
                                                                    case 'e':
                                                                        if (i6 != 1 && i6 != 2) {
                                                                            if (i6 != 3) {
                                                                                if (i6 != 4) {
                                                                                    if (i6 != 5) {
                                                                                        throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                                                                    }
                                                                                    j(jVar, pVar6);
                                                                                    break;
                                                                                }
                                                                                j(jVar, pVar2);
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            rVar2 = new r('e', i6);
                                                                            c(rVar2);
                                                                            break;
                                                                        }
                                                                        break;
                                                                }
                                                        }
                                                    case 'H':
                                                        if (i6 != 1) {
                                                            if (i6 != 2) {
                                                                throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                                            }
                                                            m(jVar, i6);
                                                            break;
                                                        }
                                                        l(jVar);
                                                        break;
                                                }
                                            } else if (i6 == 2) {
                                                e.c.a.e eVar = n.j;
                                                c.b.a.a.c.n.c.T1(jVar, "field");
                                                c.b.a.a.c.n.c.T1(eVar, "baseDate");
                                                k(new n(jVar, 2, 2, 0, eVar));
                                            } else {
                                                n(jVar, i6, 19, i6 < 4 ? m.NORMAL : m.EXCEEDS_PAD);
                                            }
                                        }
                                    }
                                    if (i6 != 1) {
                                        i2 = 2;
                                        if (i6 != 2) {
                                            if (i6 != 3) {
                                                if (i6 != 4) {
                                                    if (i6 != 5) {
                                                        throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                                    }
                                                    j(jVar, pVar3);
                                                }
                                                j(jVar, pVar4);
                                            }
                                            j(jVar, pVar5);
                                        }
                                        m(jVar, i2);
                                    }
                                    l(jVar);
                                }
                                if (i6 != 1) {
                                }
                                l(jVar);
                            } else if (i6 != 1) {
                                throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                            }
                            j(jVar, pVar);
                        } else {
                            b(e.c.a.w.a.NANO_OF_SECOND, i6, i6, false);
                        }
                    }
                    if (i6 != 1) {
                        i2 = 2;
                        if (i6 != 2) {
                            if (i6 != 3) {
                                if (i6 != 4) {
                                    if (i6 != 5) {
                                        throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                    }
                                    j(jVar, pVar6);
                                }
                                j(jVar, pVar2);
                            }
                            j(jVar, pVar);
                        }
                        m(jVar, i2);
                    }
                    l(jVar);
                } else {
                    int i8 = 0;
                    if (charAt == 'z') {
                        if (i6 <= 4) {
                            c(i6 == 4 ? new t(pVar2) : new t(pVar));
                        } else {
                            throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                        }
                    } else if (charAt != 'V') {
                        String str4 = "+0000";
                        if (charAt == 'Z') {
                            if (i6 < 4) {
                                str2 = "+HHMM";
                                g(str2, str4);
                            } else if (i6 != 4) {
                                if (i6 == 5) {
                                    str3 = "+HH:MM:ss";
                                    g(str3, "Z");
                                } else {
                                    throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                }
                            }
                        } else if (charAt == 'O') {
                            if (i6 == 1) {
                                f(pVar);
                            } else if (i6 != 4) {
                                throw new IllegalArgumentException(c.a.a.a.a.k("Pattern letter count must be 1 or 4: ", charAt));
                            }
                        } else if (charAt == 'X') {
                            if (i6 <= 5) {
                                String[] strArr = l.f5084d;
                                if (i6 != 1) {
                                    i8 = 1;
                                }
                                str3 = strArr[i6 + i8];
                                g(str3, "Z");
                            } else {
                                throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                            }
                        } else if (charAt != 'x') {
                            if (charAt == 'W') {
                                if (i6 <= 1) {
                                    rVar = new r('W', i6);
                                } else {
                                    throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                }
                            } else if (charAt == 'w') {
                                if (i6 <= 2) {
                                    rVar = new r('w', i6);
                                } else {
                                    throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                                }
                            } else if (charAt == 'Y') {
                                rVar = new r('Y', i6);
                            } else {
                                throw new IllegalArgumentException(c.a.a.a.a.k("Unknown pattern letter: ", charAt));
                            }
                            c(rVar);
                        } else if (i6 <= 5) {
                            if (i6 == 1) {
                                str4 = "+00";
                            } else if (i6 % 2 != 0) {
                                str4 = "+00:00";
                            }
                            String[] strArr2 = l.f5084d;
                            if (i6 != 1) {
                                i8 = 1;
                            }
                            str2 = strArr2[i6 + i8];
                            g(str2, str4);
                        } else {
                            throw new IllegalArgumentException(c.a.a.a.a.k("Too many pattern letters: ", charAt));
                        }
                        f(pVar2);
                    } else if (i6 == 2) {
                        c(new s(e.c.a.w.k.f5177a, "ZoneId()"));
                    } else {
                        throw new IllegalArgumentException(c.a.a.a.a.k("Pattern letter count must be 2: ", charAt));
                    }
                }
                i4 = i5 - 1;
            } else if (charAt == '\'') {
                int i9 = i4 + 1;
                int i10 = i9;
                while (i10 < str.length()) {
                    if (str.charAt(i10) == '\'') {
                        int i11 = i10 + 1;
                        if (i11 < str.length() && str.charAt(i11) == '\'') {
                            i10 = i11;
                        }
                        if (i10 >= str.length()) {
                            String substring = str.substring(i9, i10);
                            if (substring.length() == 0) {
                                d('\'');
                            } else {
                                e(substring.replace("''", "'"));
                            }
                            i4 = i10;
                        } else {
                            throw new IllegalArgumentException(c.a.a.a.a.o("Pattern ends with an incomplete string literal: ", str));
                        }
                    }
                    i10++;
                }
                if (i10 >= str.length()) {
                }
            } else if (charAt == '[') {
                p();
            } else if (charAt == ']') {
                if (this.f5063a.f5064b != null) {
                    o();
                } else {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
            } else if (charAt == '{' || charAt == '}' || charAt == '#') {
                throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
            } else {
                d(charAt);
            }
            i4++;
        }
        return this;
    }

    public d i(e.c.a.w.j jVar, Map<Long, String> map) {
        p pVar = p.FULL;
        c.b.a.a.c.n.c.T1(jVar, "field");
        c.b.a.a.c.n.c.T1(map, "textLookup");
        c(new q(jVar, pVar, new b(this, new o.b(Collections.singletonMap(pVar, new LinkedHashMap(map))))));
        return this;
    }

    public d j(e.c.a.w.j jVar, p pVar) {
        c.b.a.a.c.n.c.T1(jVar, "field");
        c.b.a.a.c.n.c.T1(pVar, "textStyle");
        c(new q(jVar, pVar, i.a()));
        return this;
    }

    public final d k(k kVar) {
        k kVar2;
        d dVar = this.f5063a;
        int i2 = dVar.g;
        if (i2 < 0 || !(dVar.f5065c.get(i2) instanceof k)) {
            this.f5063a.g = c(kVar);
        } else {
            d dVar2 = this.f5063a;
            int i3 = dVar2.g;
            k kVar3 = (k) dVar2.f5065c.get(i3);
            int i4 = kVar.f5081c;
            int i5 = kVar.f5082d;
            if (i4 == i5 && kVar.f5083e == m.NOT_NEGATIVE) {
                kVar2 = kVar3.g(i5);
                c(kVar.f());
                this.f5063a.g = i3;
            } else {
                kVar2 = kVar3.f();
                this.f5063a.g = c(kVar);
            }
            this.f5063a.f5065c.set(i3, kVar2);
        }
        return this;
    }

    public d l(e.c.a.w.j jVar) {
        c.b.a.a.c.n.c.T1(jVar, "field");
        k(new k(jVar, 1, 19, m.NORMAL));
        return this;
    }

    public d m(e.c.a.w.j jVar, int i2) {
        c.b.a.a.c.n.c.T1(jVar, "field");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException(c.a.a.a.a.l("The width must be from 1 to 19 inclusive but was ", i2));
        }
        k(new k(jVar, i2, i2, m.NOT_NEGATIVE));
        return this;
    }

    public d n(e.c.a.w.j jVar, int i2, int i3, m mVar) {
        if (i2 == i3 && mVar == m.NOT_NEGATIVE) {
            m(jVar, i3);
            return this;
        }
        c.b.a.a.c.n.c.T1(jVar, "field");
        c.b.a.a.c.n.c.T1(mVar, "signStyle");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException(c.a.a.a.a.l("The minimum width must be from 1 to 19 inclusive but was ", i2));
        } else if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException(c.a.a.a.a.l("The maximum width must be from 1 to 19 inclusive but was ", i3));
        } else if (i3 >= i2) {
            k(new k(jVar, i2, i3, mVar));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
        }
    }

    public d o() {
        d dVar = this.f5063a;
        if (dVar.f5064b != null) {
            if (dVar.f5065c.size() > 0) {
                d dVar2 = this.f5063a;
                e eVar = new e(dVar2.f5065c, dVar2.f5066d);
                this.f5063a = this.f5063a.f5064b;
                c(eVar);
            } else {
                this.f5063a = this.f5063a.f5064b;
            }
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public d p() {
        d dVar = this.f5063a;
        dVar.g = -1;
        this.f5063a = new d(dVar, true);
        return this;
    }

    public c q() {
        return r(Locale.getDefault());
    }

    public c r(Locale locale) {
        c.b.a.a.c.n.c.T1(locale, "locale");
        while (this.f5063a.f5064b != null) {
            o();
        }
        return new c(new e(this.f5065c, false), locale, j.f5129e, l.SMART, null, null, null);
    }

    public c s(l lVar) {
        c q2 = q();
        c.b.a.a.c.n.c.T1(lVar, "resolverStyle");
        return c.b.a.a.c.n.c.L0(q2.f5061d, lVar) ? q2 : new c(q2.f5058a, q2.f5059b, q2.f5060c, lVar, q2.f5062e, q2.f, q2.g);
    }
}
