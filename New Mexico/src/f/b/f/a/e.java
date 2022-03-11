package f.b.f.a;

import f.b.f.a.d;
import f.b.f.a.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class e {

    /* renamed from: h  reason: collision with root package name */
    public static final Logger f3793h = Logger.getLogger(e.class.getName());

    /* renamed from: i  reason: collision with root package name */
    public static final Map<Character, Character> f3794i;

    /* renamed from: j  reason: collision with root package name */
    public static final Map<Character, Character> f3795j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f3796k;

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f3797l;
    public static final Pattern m;
    public static final Pattern n;
    public static final Pattern o;
    public static final Pattern p;
    public static final Pattern q;
    public static final String r;
    public static final String s;
    public static final Pattern t;
    public static final Pattern u;
    public static e v;
    public final c a;
    public final Map<Integer, List<String>> b;
    public final f.b.f.a.k.a c = new f.b.f.a.k.a();

    /* renamed from: d  reason: collision with root package name */
    public final Set<String> f3798d = new HashSet(35);

    /* renamed from: e  reason: collision with root package name */
    public final f.b.f.a.k.b f3799e = new f.b.f.a.k.b(100);

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f3800f = new HashSet(320);

    /* renamed from: g  reason: collision with root package name */
    public final Set<Integer> f3801g = new HashSet();

    /* loaded from: classes.dex */
    public enum a {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum b {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(54, "9");
        Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        Map<Character, Character> unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        f3794i = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        f3795j = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        hashMap5.put('*', '*');
        hashMap5.put('#', '#');
        Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character ch : unmodifiableMap.keySet()) {
            char charValue = ch.charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue)), Character.valueOf(charValue));
            hashMap6.put(Character.valueOf(charValue), Character.valueOf(charValue));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put('-', '-');
        hashMap6.put((char) 65293, '-');
        hashMap6.put((char) 8208, '-');
        hashMap6.put((char) 8209, '-');
        hashMap6.put((char) 8210, '-');
        hashMap6.put((char) 8211, '-');
        hashMap6.put((char) 8212, '-');
        hashMap6.put((char) 8213, '-');
        hashMap6.put((char) 8722, '-');
        hashMap6.put('/', '/');
        hashMap6.put((char) 65295, '/');
        hashMap6.put(' ', ' ');
        hashMap6.put((char) 12288, ' ');
        hashMap6.put((char) 8288, ' ');
        hashMap6.put('.', '.');
        hashMap6.put((char) 65294, '.');
        Collections.unmodifiableMap(hashMap6);
        Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = f3794i;
        sb.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String sb2 = sb.toString();
        f3796k = sb2;
        f3797l = Pattern.compile("[+＋]+");
        Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        m = Pattern.compile("(\\p{Nd})");
        n = Pattern.compile("[+＋\\p{Nd}]");
        o = Pattern.compile("[\\\\/] *x");
        p = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        q = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + sb2 + "\\p{Nd}]*";
        r = str;
        String a2 = a(true);
        s = a2;
        a(false);
        t = Pattern.compile("(?:" + a2 + ")$", 66);
        u = Pattern.compile(str + "(?:" + a2 + ")?", 66);
        Pattern.compile("(\\D+)");
        Pattern.compile("(\\$\\d)");
        Pattern.compile("\\(?\\$1\\)?");
        v = null;
    }

    public e(c cVar, Map<Integer, List<String>> map) {
        this.a = cVar;
        this.b = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() != 1 || !"001".equals(value.get(0))) {
                this.f3800f.addAll(value);
            } else {
                this.f3801g.add(entry.getKey());
            }
        }
        if (this.f3800f.remove("001")) {
            f3793h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f3798d.addAll(map.get(1));
    }

    public static String a(boolean z) {
        StringBuilder h2 = f.a.a.a.a.h(";ext=");
        h2.append(c(20));
        String sb = h2.toString();
        StringBuilder j2 = f.a.a.a.a.j("[  \\t,]*", "(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|anexo)", "[:\\.．]?[  \\t,-]*");
        j2.append(c(20));
        j2.append("#?");
        String sb2 = j2.toString();
        StringBuilder j3 = f.a.a.a.a.j("[  \\t,]*", "(?:[xｘ#＃~～]|int|ｉｎｔ)", "[:\\.．]?[  \\t,-]*");
        j3.append(c(9));
        j3.append("#?");
        String sb3 = j3.toString();
        StringBuilder h3 = f.a.a.a.a.h("[- ]+");
        h3.append(c(6));
        h3.append("#");
        String sb4 = h3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb);
        sb5.append("|");
        sb5.append(sb2);
        sb5.append("|");
        sb5.append(sb3);
        String e2 = f.a.a.a.a.e(sb5, "|", sb4);
        if (!z) {
            return e2;
        }
        StringBuilder j4 = f.a.a.a.a.j("[  \\t]*", "(?:,{2}|;)", "[:\\.．]?[  \\t,-]*");
        j4.append(c(15));
        j4.append("#?");
        String sb6 = j4.toString();
        StringBuilder j5 = f.a.a.a.a.j("[  \\t]*", "(?:,)+", "[:\\.．]?[  \\t,-]*");
        j5.append(c(9));
        j5.append("#?");
        String sb7 = j5.toString();
        return e2 + "|" + sb6 + "|" + sb7;
    }

    public static boolean b(i iVar) {
        return (iVar.a() == 1 && iVar.f3831d.get(0).intValue() == -1) ? false : true;
    }

    public static String c(int i2) {
        return f.a.a.a.a.v("(\\p{Nd}{1,", i2, "})");
    }

    public static boolean k(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return u.matcher(charSequence).matches();
    }

    public static StringBuilder n(StringBuilder sb) {
        String str;
        int i2;
        if (q.matcher(sb).matches()) {
            i2 = sb.length();
            Map<Character, Character> map = f3795j;
            StringBuilder sb2 = new StringBuilder(sb.length());
            for (int i3 = 0; i3 < sb.length(); i3++) {
                Character ch = map.get(Character.valueOf(Character.toUpperCase(sb.charAt(i3))));
                if (ch != null) {
                    sb2.append(ch);
                }
            }
            str = sb2.toString();
        } else {
            i2 = sb.length();
            str = o(sb);
        }
        sb.replace(0, i2, str);
        return sb;
    }

    public static String o(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            int digit = Character.digit(charSequence.charAt(i2), 10);
            if (digit != -1) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public g d(String str) {
        if (!(str != null && this.f3800f.contains(str))) {
            return null;
        }
        c cVar = this.a;
        return b.a(str, cVar.c, cVar.a, cVar.b);
    }

    public final g e(int i2, String str) {
        if (!"001".equals(str)) {
            return d(str);
        }
        if (!this.b.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        c cVar = this.a;
        Objects.requireNonNull(cVar);
        List list = (List) ((HashMap) f.b.a.c.b.o.b.B0()).get(Integer.valueOf(i2));
        boolean z = false;
        if (list.size() == 1 && "001".equals(list.get(0))) {
            z = true;
        }
        if (!z) {
            return null;
        }
        return b.a(Integer.valueOf(i2), cVar.f3788d, cVar.a, cVar.b);
    }

    public String f(j jVar) {
        int i2;
        StringBuilder sb = new StringBuilder();
        if (jVar.f3838g && (i2 = jVar.f3840i) > 0) {
            char[] cArr = new char[i2];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(jVar.c);
        return sb.toString();
    }

    public i g(g gVar, a aVar) {
        switch (aVar.ordinal()) {
            case 0:
            case 2:
                return gVar.f3823e;
            case 1:
                return gVar.f3825g;
            case 3:
                return gVar.f3827i;
            case 4:
                return gVar.f3829k;
            case 5:
                return gVar.m;
            case 6:
                return gVar.q;
            case 7:
                return gVar.o;
            case 8:
                return gVar.s;
            case 9:
                return gVar.u;
            case 10:
                return gVar.y;
            default:
                return gVar.c;
        }
    }

    public final a h(String str, g gVar) {
        a aVar = a.FIXED_LINE_OR_MOBILE;
        a aVar2 = a.UNKNOWN;
        if (!i(str, gVar.c)) {
            return aVar2;
        }
        if (i(str, gVar.f3829k)) {
            return a.PREMIUM_RATE;
        }
        if (i(str, gVar.f3827i)) {
            return a.TOLL_FREE;
        }
        if (i(str, gVar.m)) {
            return a.SHARED_COST;
        }
        if (i(str, gVar.q)) {
            return a.VOIP;
        }
        if (i(str, gVar.o)) {
            return a.PERSONAL_NUMBER;
        }
        if (i(str, gVar.s)) {
            return a.PAGER;
        }
        if (i(str, gVar.u)) {
            return a.UAN;
        }
        if (i(str, gVar.y)) {
            return a.VOICEMAIL;
        }
        if (!i(str, gVar.f3823e)) {
            return (gVar.W || !i(str, gVar.f3825g)) ? aVar2 : a.MOBILE;
        }
        if (gVar.W) {
            return aVar;
        }
        return i(str, gVar.f3825g) ? aVar : a.FIXED_LINE;
    }

    public boolean i(String str, i iVar) {
        int length = str.length();
        List<Integer> list = iVar.f3831d;
        if (list.size() <= 0 || list.contains(Integer.valueOf(length))) {
            return this.c.a(str, iVar, false);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008f, code lost:
        if (r2 != r5.K) goto L_0x00a9;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean j(j jVar) {
        String str;
        g e2;
        a aVar = a.UNKNOWN;
        int i2 = jVar.b;
        List<String> list = this.b.get(Integer.valueOf(i2));
        if (list == null) {
            Logger logger = f3793h;
            Level level = Level.INFO;
            logger.log(level, "Missing/invalid country_code (" + i2 + ")");
        } else {
            if (list.size() == 1) {
                str = list.get(0);
            } else {
                String f2 = f(jVar);
                for (String str2 : list) {
                    g d2 = d(str2);
                    if (d2.a0) {
                        if (this.f3799e.a(d2.b0).matcher(f2).lookingAt()) {
                            str = str2;
                            break;
                        }
                    } else if (h(f2, d2) != aVar) {
                        str = str2;
                        break;
                    }
                }
            }
            int i3 = jVar.b;
            e2 = e(i3, str);
            if (e2 != null) {
                if (!"001".equals(str)) {
                    g d3 = d(str);
                    if (d3 == null) {
                        throw new IllegalArgumentException(f.a.a.a.a.x("Invalid region code: ", str));
                    }
                }
                if (h(f(jVar), e2) != aVar) {
                    return true;
                }
            }
            return false;
        }
        str = null;
        int i32 = jVar.b;
        e2 = e(i32, str);
        if (e2 != null) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public int l(CharSequence charSequence, g gVar, StringBuilder sb, boolean z, j jVar) {
        j.a aVar;
        boolean z2;
        int i2 = 0;
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        String str = gVar != null ? gVar.L : "NonMatch";
        j.a aVar2 = j.a.FROM_DEFAULT_COUNTRY;
        int i3 = 1;
        if (sb2.length() != 0) {
            Matcher matcher = f3797l.matcher(sb2);
            if (matcher.lookingAt()) {
                sb2.delete(0, matcher.end());
                n(sb2);
                aVar = j.a.FROM_NUMBER_WITH_PLUS_SIGN;
            } else {
                Pattern a2 = this.f3799e.a(str);
                n(sb2);
                Matcher matcher2 = a2.matcher(sb2);
                if (matcher2.lookingAt()) {
                    int end = matcher2.end();
                    Matcher matcher3 = m.matcher(sb2.substring(end));
                    if (!matcher3.find() || !o(matcher3.group(1)).equals("0")) {
                        sb2.delete(0, end);
                        z2 = true;
                        if (z2) {
                            aVar = j.a.FROM_NUMBER_WITH_IDD;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            if (z) {
                Objects.requireNonNull(jVar);
                jVar.f3842k = true;
                jVar.f3843l = aVar;
            }
            if (aVar != aVar2) {
                if (gVar != null) {
                    int i4 = gVar.K;
                    String valueOf = String.valueOf(i4);
                    String sb3 = sb2.toString();
                    if (sb3.startsWith(valueOf)) {
                        StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                        i iVar = gVar.c;
                        m(sb4, gVar, null);
                        if ((!this.c.a(sb2, iVar, false) && this.c.a(sb4, iVar, false)) || q(sb2, gVar, a.UNKNOWN) == b.TOO_LONG) {
                            sb.append((CharSequence) sb4);
                            if (z) {
                                j.a aVar3 = j.a.FROM_NUMBER_WITHOUT_PLUS_SIGN;
                                Objects.requireNonNull(jVar);
                                jVar.f3842k = true;
                                jVar.f3843l = aVar3;
                            }
                            jVar.b = i4;
                            return i4;
                        }
                    }
                }
                jVar.b = 0;
                return 0;
            } else if (sb2.length() > 2) {
                if (sb2.length() != 0 && sb2.charAt(0) != '0') {
                    int length = sb2.length();
                    while (true) {
                        if (i3 > 3 || i3 > length) {
                            break;
                        }
                        int parseInt = Integer.parseInt(sb2.substring(0, i3));
                        if (this.b.containsKey(Integer.valueOf(parseInt))) {
                            sb.append(sb2.substring(i3));
                            i2 = parseInt;
                            break;
                        }
                        i3++;
                    }
                }
                if (i2 != 0) {
                    jVar.b = i2;
                    return i2;
                }
                throw new d(d.a.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            } else {
                throw new d(d.a.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
        }
        aVar = aVar2;
        if (z) {
        }
        if (aVar != aVar2) {
        }
    }

    public boolean m(StringBuilder sb, g gVar, StringBuilder sb2) {
        int length = sb.length();
        String str = gVar.T;
        if (!(length == 0 || str.length() == 0)) {
            Matcher matcher = this.f3799e.a(str).matcher(sb);
            if (matcher.lookingAt()) {
                i iVar = gVar.c;
                boolean a2 = this.c.a(sb, iVar, false);
                int groupCount = matcher.groupCount();
                String str2 = gVar.V;
                if (str2 != null && str2.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(str2));
                    if (a2 && !this.c.a(sb3.toString(), iVar, false)) {
                        return false;
                    }
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                } else if (a2 && !this.c.a(sb.substring(matcher.end()), iVar, false)) {
                    return false;
                } else {
                    if (!(sb2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x01d5, code lost:
        if (r0 != f.b.f.a.e.b.f3813f) goto L_0x01d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public j p(CharSequence charSequence, String str) {
        int i2;
        g gVar;
        StringBuilder sb;
        StringBuilder sb2;
        g gVar2;
        CharSequence charSequence2;
        j jVar = new j();
        d.a aVar = d.a.TOO_SHORT_NSN;
        d.a aVar2 = d.a.TOO_LONG;
        d.a aVar3 = d.a.NOT_A_NUMBER;
        d.a aVar4 = d.a.INVALID_COUNTRY_CODE;
        if (charSequence == null) {
            throw new d(aVar3, "The phone number supplied was null.");
        } else if (charSequence.length() <= 250) {
            StringBuilder sb3 = new StringBuilder();
            String charSequence3 = charSequence.toString();
            int indexOf = charSequence3.indexOf(";phone-context=");
            String str2 = "";
            if (indexOf >= 0) {
                int i3 = indexOf + 15;
                if (i3 < charSequence3.length() - 1 && charSequence3.charAt(i3) == '+') {
                    int indexOf2 = charSequence3.indexOf(59, i3);
                    sb3.append(indexOf2 > 0 ? charSequence3.substring(i3, indexOf2) : charSequence3.substring(i3));
                }
                int indexOf3 = charSequence3.indexOf("tel:");
                sb3.append(charSequence3.substring(indexOf3 >= 0 ? indexOf3 + 4 : 0, indexOf));
            } else {
                Matcher matcher = n.matcher(charSequence3);
                if (matcher.find()) {
                    charSequence2 = charSequence3.subSequence(matcher.start(), charSequence3.length());
                    Matcher matcher2 = p.matcher(charSequence2);
                    if (matcher2.find()) {
                        charSequence2 = charSequence2.subSequence(0, matcher2.start());
                    }
                    Matcher matcher3 = o.matcher(charSequence2);
                    if (matcher3.find()) {
                        charSequence2 = charSequence2.subSequence(0, matcher3.start());
                    }
                } else {
                    charSequence2 = str2;
                }
                sb3.append(charSequence2);
            }
            int indexOf4 = sb3.indexOf(";isub=");
            if (indexOf4 > 0) {
                sb3.delete(indexOf4, sb3.length());
            }
            if (k(sb3)) {
                if ((str != null && this.f3800f.contains(str)) || (sb3.length() != 0 && f3797l.matcher(sb3).lookingAt())) {
                    Matcher matcher4 = t.matcher(sb3);
                    if (matcher4.find() && k(sb3.substring(0, matcher4.start()))) {
                        int groupCount = matcher4.groupCount();
                        int i4 = 1;
                        while (true) {
                            if (i4 > groupCount) {
                                break;
                            } else if (matcher4.group(i4) != null) {
                                str2 = matcher4.group(i4);
                                sb3.delete(matcher4.start(), sb3.length());
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    if (str2.length() > 0) {
                        jVar.f3835d = true;
                        jVar.f3836e = str2;
                    }
                    g d2 = d(str);
                    StringBuilder sb4 = new StringBuilder();
                    try {
                        i2 = l(sb3, d2, sb4, false, jVar);
                    } catch (d e2) {
                        Matcher matcher5 = f3797l.matcher(sb3);
                        if (e2.b != aVar4 || !matcher5.lookingAt()) {
                            throw new d(e2.b, e2.getMessage());
                        }
                        i2 = l(sb3.substring(matcher5.end()), d2, sb4, false, jVar);
                        if (i2 == 0) {
                            throw new d(aVar4, "Could not interpret numbers after plus-sign.");
                        }
                    }
                    if (i2 != 0) {
                        List<String> list = this.b.get(Integer.valueOf(i2));
                        String str3 = list == null ? "ZZ" : list.get(0);
                        gVar = !str3.equals(str) ? e(i2, str3) : d2;
                        sb = sb4;
                    } else {
                        n(sb3);
                        sb = sb4;
                        sb.append((CharSequence) sb3);
                        if (str != null) {
                            gVar2 = d2;
                            jVar.b = gVar2.K;
                        } else {
                            gVar2 = d2;
                        }
                        gVar = gVar2;
                    }
                    if (sb.length() >= 2) {
                        if (gVar != null) {
                            StringBuilder sb5 = new StringBuilder();
                            sb2 = new StringBuilder(sb);
                            m(sb2, gVar, sb5);
                            b q2 = q(sb2, gVar, a.UNKNOWN);
                            if (q2 != b.TOO_SHORT) {
                                if (q2 != b.IS_POSSIBLE_LOCAL_ONLY) {
                                }
                            }
                        }
                        sb2 = sb;
                        int length = sb2.length();
                        if (length < 2) {
                            throw new d(aVar, "The string supplied is too short to be a phone number.");
                        } else if (length <= 17) {
                            if (sb2.length() > 1 && sb2.charAt(0) == '0') {
                                jVar.f3837f = true;
                                jVar.f3838g = true;
                                int i5 = 1;
                                while (i5 < sb2.length() - 1 && sb2.charAt(i5) == '0') {
                                    i5++;
                                }
                                if (i5 != 1) {
                                    jVar.f3839h = true;
                                    jVar.f3840i = i5;
                                }
                            }
                            jVar.c = Long.parseLong(sb2.toString());
                            return jVar;
                        } else {
                            throw new d(aVar2, "The string supplied is too long to be a phone number.");
                        }
                    } else {
                        throw new d(aVar, "The string supplied is too short to be a phone number.");
                    }
                } else {
                    throw new d(aVar4, "Missing or invalid default region.");
                }
            } else {
                throw new d(aVar3, "The string supplied did not seem to be a phone number.");
            }
        } else {
            throw new d(aVar2, "The string supplied was too long to parse.");
        }
    }

    public final b q(CharSequence charSequence, g gVar, a aVar) {
        ArrayList arrayList;
        b bVar = b.IS_POSSIBLE;
        a aVar2 = a.MOBILE;
        b bVar2 = b.INVALID_LENGTH;
        i g2 = g(gVar, aVar);
        List<Integer> list = g2.f3831d.isEmpty() ? gVar.c.f3831d : g2.f3831d;
        List<Integer> list2 = g2.f3832e;
        List<Integer> list3 = list;
        if (aVar == a.FIXED_LINE_OR_MOBILE) {
            if (!b(g(gVar, a.FIXED_LINE))) {
                return q(charSequence, gVar, aVar2);
            }
            i g3 = g(gVar, aVar2);
            list3 = list;
            if (b(g3)) {
                ArrayList arrayList2 = new ArrayList(list);
                arrayList2.addAll(g3.a() == 0 ? gVar.c.f3831d : g3.f3831d);
                Collections.sort(arrayList2);
                if (list2.isEmpty()) {
                    arrayList = g3.f3832e;
                } else {
                    ArrayList arrayList3 = new ArrayList(list2);
                    arrayList3.addAll(g3.f3832e);
                    Collections.sort(arrayList3);
                    arrayList = arrayList3;
                }
                list2 = arrayList;
                list3 = arrayList2;
            }
        }
        if (list3.get(0).intValue() == -1) {
            return bVar2;
        }
        int length = charSequence.length();
        if (list2.contains(Integer.valueOf(length))) {
            return b.IS_POSSIBLE_LOCAL_ONLY;
        }
        int intValue = list3.get(0).intValue();
        if (intValue == length) {
            return bVar;
        }
        if (intValue > length) {
            return b.TOO_SHORT;
        }
        if (list3.get(list3.size() - 1).intValue() < length) {
            return b.TOO_LONG;
        }
        return list3.subList(1, list3.size()).contains(Integer.valueOf(length)) ? bVar : bVar2;
    }
}
