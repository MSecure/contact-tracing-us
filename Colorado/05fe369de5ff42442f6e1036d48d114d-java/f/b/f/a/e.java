package f.b.f.a;

import f.b.f.a.d;
import f.b.f.a.j;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e {

    /* renamed from: g  reason: collision with root package name */
    public static final Logger f3475g = Logger.getLogger(e.class.getName());

    /* renamed from: h  reason: collision with root package name */
    public static final Map<Character, Character> f3476h;

    /* renamed from: i  reason: collision with root package name */
    public static final Map<Character, Character> f3477i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f3478j;

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f3479k = Pattern.compile("[+＋]+");

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f3480l = Pattern.compile("(\\p{Nd})");
    public static final Pattern m = Pattern.compile("[+＋\\p{Nd}]");
    public static final Pattern n = Pattern.compile("[\\\\/] *x");
    public static final Pattern o = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    public static final Pattern p = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    public static final String q;
    public static final String r;
    public static final Pattern s;
    public static final Pattern t;
    public static e u = null;
    public final c a;
    public final Map<Integer, List<String>> b;
    public final Set<String> c = new HashSet(35);

    /* renamed from: d  reason: collision with root package name */
    public final k f3481d = new k(100);

    /* renamed from: e  reason: collision with root package name */
    public final Set<String> f3482e = new HashSet(320);

    /* renamed from: f  reason: collision with root package name */
    public final Set<Integer> f3483f = new HashSet();

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

    public enum b {
        IS_POSSIBLE,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(52, "1");
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
        f3476h = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        f3477i = Collections.unmodifiableMap(hashMap4);
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
        Map<Character, Character> map = f3476h;
        sb.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String sb2 = sb.toString();
        f3478j = sb2;
        Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*" + sb2 + "\\p{Nd}" + "]*";
        q = str;
        String a2 = a(",;xｘ#＃~～");
        r = a2;
        a("xｘ#＃~～");
        s = Pattern.compile("(?:" + a2 + ")$", 66);
        t = Pattern.compile(str + "(?:" + a2 + ")?", 66);
        Pattern.compile("(\\D+)");
        Pattern.compile("(\\$\\d)");
        Pattern.compile("\\$NP");
        Pattern.compile("\\$FG");
        Pattern.compile("\\$CC");
        Pattern.compile("\\(?\\$1\\)?");
    }

    public e(c cVar, Map<Integer, List<String>> map) {
        this.a = cVar;
        this.b = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() != 1 || !"001".equals(value.get(0))) {
                this.f3482e.addAll(value);
            } else {
                this.f3483f.add(entry.getKey());
            }
        }
        if (this.f3482e.remove("001")) {
            f3475g.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.c.addAll(map.get(1));
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[");
        sb.append(str);
        sb.append("]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*");
        sb.append("(\\p{Nd}{1,7})");
        sb.append("#?|[- ]+(");
        return f.a.a.a.a.f(sb, "\\p{Nd}", "{1,5})#");
    }

    public static boolean h(String str) {
        if (str.length() < 2) {
            return false;
        }
        return t.matcher(str).matches();
    }

    public static void k(StringBuilder sb) {
        String str;
        String sb2 = sb.toString();
        if (p.matcher(sb2).matches()) {
            Map<Character, Character> map = f3477i;
            StringBuilder sb3 = new StringBuilder(sb2.length());
            for (int i2 = 0; i2 < sb2.length(); i2++) {
                Character ch = map.get(Character.valueOf(Character.toUpperCase(sb2.charAt(i2))));
                if (ch != null) {
                    sb3.append(ch);
                }
            }
            str = sb3.toString();
        } else {
            str = l(sb2);
        }
        sb.replace(0, sb.length(), str);
    }

    public static String l(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (char c2 : str.toCharArray()) {
            int digit = Character.digit(c2, 10);
            if (digit != -1) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public g b(String str) {
        if (!(str != null && this.f3482e.contains(str))) {
            return null;
        }
        c cVar = this.a;
        return b.a(str, cVar.c, cVar.a, cVar.b);
    }

    public final g c(int i2, String str) {
        if (!"001".equals(str)) {
            return b(str);
        }
        if (!this.b.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        c cVar = this.a;
        Objects.requireNonNull(cVar);
        List list = (List) ((HashMap) f.b.a.c.b.o.b.y0()).get(Integer.valueOf(i2));
        boolean z = false;
        if (list.size() == 1 && "001".equals(list.get(0))) {
            z = true;
        }
        if (!z) {
            return null;
        }
        return b.a(Integer.valueOf(i2), cVar.f3470d, cVar.a, cVar.b);
    }

    public String d(j jVar) {
        StringBuilder sb = new StringBuilder();
        if (jVar.f3520g) {
            char[] cArr = new char[jVar.f3522i];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(jVar.c);
        return sb.toString();
    }

    public final a e(String str, g gVar) {
        a aVar = a.FIXED_LINE_OR_MOBILE;
        a aVar2 = a.UNKNOWN;
        if (!f(str, gVar.c)) {
            return aVar2;
        }
        if (f(str, gVar.f3509k)) {
            return a.PREMIUM_RATE;
        }
        if (f(str, gVar.f3507i)) {
            return a.TOLL_FREE;
        }
        if (f(str, gVar.m)) {
            return a.SHARED_COST;
        }
        if (f(str, gVar.q)) {
            return a.VOIP;
        }
        if (f(str, gVar.o)) {
            return a.PERSONAL_NUMBER;
        }
        if (f(str, gVar.s)) {
            return a.PAGER;
        }
        if (f(str, gVar.u)) {
            return a.UAN;
        }
        if (f(str, gVar.y)) {
            return a.VOICEMAIL;
        }
        return f(str, gVar.f3503e) ? (!gVar.U && !f(str, gVar.f3505g)) ? a.FIXED_LINE : aVar : (gVar.U || !f(str, gVar.f3505g)) ? aVar2 : a.MOBILE;
    }

    public boolean f(String str, i iVar) {
        int length = str.length();
        List<Integer> list = iVar.f3513f;
        if (list.size() <= 0 || list.contains(Integer.valueOf(length))) {
            return this.f3481d.a(iVar.c).matcher(str).matches();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0096, code lost:
        if (r2 != r5.I) goto L_0x00b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    public boolean g(j jVar) {
        String str;
        g c2;
        String next;
        a aVar = a.UNKNOWN;
        int i2 = jVar.b;
        List<String> list = this.b.get(Integer.valueOf(i2));
        if (list == null) {
            String d2 = d(jVar);
            Logger logger = f3475g;
            Level level = Level.INFO;
            logger.log(level, "Missing/invalid country_code (" + i2 + ") for number " + d2);
        } else {
            if (list.size() == 1) {
                str = list.get(0);
            } else {
                String d3 = d(jVar);
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    g b2 = b(next);
                    if (b2.Y) {
                        if (this.f3481d.a(b2.Z).matcher(d3).lookingAt()) {
                            break;
                        }
                    } else if (e(d3, b2) != aVar) {
                        break;
                    }
                }
                str = next;
            }
            int i3 = jVar.b;
            c2 = c(i3, str);
            if (c2 != null) {
                if (!"001".equals(str)) {
                    g b3 = b(str);
                    if (b3 == null) {
                        throw new IllegalArgumentException(f.a.a.a.a.c("Invalid region code: ", str));
                    }
                }
                if (e(d(jVar), c2) != aVar) {
                    return true;
                }
            }
            return false;
        }
        str = null;
        int i32 = jVar.b;
        c2 = c(i32, str);
        if (c2 != null) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00de  */
    public int i(String str, g gVar, StringBuilder sb, boolean z, j jVar) {
        j.a aVar;
        boolean z2;
        int i2 = 0;
        if (str.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(str);
        String str2 = gVar != null ? gVar.J : "NonMatch";
        j.a aVar2 = j.a.FROM_DEFAULT_COUNTRY;
        int i3 = 1;
        if (sb2.length() != 0) {
            Matcher matcher = f3479k.matcher(sb2);
            if (matcher.lookingAt()) {
                sb2.delete(0, matcher.end());
                k(sb2);
                aVar = j.a.FROM_NUMBER_WITH_PLUS_SIGN;
            } else {
                Pattern a2 = this.f3481d.a(str2);
                k(sb2);
                Matcher matcher2 = a2.matcher(sb2);
                if (matcher2.lookingAt()) {
                    int end = matcher2.end();
                    Matcher matcher3 = f3480l.matcher(sb2.substring(end));
                    if (!matcher3.find() || !l(matcher3.group(1)).equals("0")) {
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
                jVar.f3524k = true;
                jVar.f3525l = aVar;
            }
            if (aVar != aVar2) {
                if (gVar != null) {
                    int i4 = gVar.I;
                    String valueOf = String.valueOf(i4);
                    String sb3 = sb2.toString();
                    if (sb3.startsWith(valueOf)) {
                        StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                        i iVar = gVar.c;
                        Pattern a3 = this.f3481d.a(iVar.c);
                        j(sb4, gVar, null);
                        if ((!a3.matcher(sb2).matches() && a3.matcher(sb4).matches()) || n(sb2.toString(), iVar) == b.TOO_LONG) {
                            sb.append((CharSequence) sb4);
                            if (z) {
                                j.a aVar3 = j.a.FROM_NUMBER_WITHOUT_PLUS_SIGN;
                                Objects.requireNonNull(jVar);
                                jVar.f3524k = true;
                                jVar.f3525l = aVar3;
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

    public boolean j(StringBuilder sb, g gVar, StringBuilder sb2) {
        int length = sb.length();
        String str = gVar.R;
        if (!(length == 0 || str.length() == 0)) {
            Matcher matcher = this.f3481d.a(str).matcher(sb);
            if (matcher.lookingAt()) {
                Pattern a2 = this.f3481d.a(gVar.c.c);
                boolean matches = a2.matcher(sb).matches();
                int groupCount = matcher.groupCount();
                String str2 = gVar.T;
                if (str2 != null && str2.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(str2));
                    if (matches && !a2.matcher(sb3.toString()).matches()) {
                        return false;
                    }
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                } else if (matches && !a2.matcher(sb.substring(matcher.end())).matches()) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ee, code lost:
        if (n(r5.toString(), r6.c) != f.b.f.a.e.b.f3493d) goto L_0x01f2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d3  */
    public j m(String str, String str2) {
        String str3;
        StringBuilder sb;
        g gVar;
        int i2;
        g gVar2;
        StringBuilder sb2;
        StringBuilder sb3;
        g gVar3;
        d e2;
        j jVar = new j();
        d.a aVar = d.a.TOO_SHORT_NSN;
        d.a aVar2 = d.a.INVALID_COUNTRY_CODE;
        d.a aVar3 = d.a.TOO_LONG;
        d.a aVar4 = d.a.NOT_A_NUMBER;
        if (str == null) {
            throw new d(aVar4, "The phone number supplied was null.");
        } else if (str.length() <= 250) {
            StringBuilder sb4 = new StringBuilder();
            int indexOf = str.indexOf(";phone-context=");
            String str4 = "";
            if (indexOf > 0) {
                int i3 = indexOf + 15;
                if (str.charAt(i3) == '+') {
                    int indexOf2 = str.indexOf(59, i3);
                    sb4.append(indexOf2 > 0 ? str.substring(i3, indexOf2) : str.substring(i3));
                }
                int indexOf3 = str.indexOf("tel:");
                str3 = str.substring(indexOf3 >= 0 ? indexOf3 + 4 : 0, indexOf);
            } else {
                Matcher matcher = m.matcher(str);
                if (matcher.find()) {
                    str3 = str.substring(matcher.start());
                    Matcher matcher2 = o.matcher(str3);
                    if (matcher2.find()) {
                        str3 = str3.substring(0, matcher2.start());
                        Logger logger = f3475g;
                        Level level = Level.FINER;
                        logger.log(level, "Stripped trailing characters: " + str3);
                    }
                    Matcher matcher3 = n.matcher(str3);
                    if (matcher3.find()) {
                        str3 = str3.substring(0, matcher3.start());
                    }
                } else {
                    str3 = str4;
                }
            }
            sb4.append(str3);
            int indexOf4 = sb4.indexOf(";isub=");
            if (indexOf4 > 0) {
                sb4.delete(indexOf4, sb4.length());
            }
            if (h(sb4.toString())) {
                String sb5 = sb4.toString();
                if ((str2 != null && this.f3482e.contains(str2)) || !(sb5 == null || sb5.length() == 0 || !f3479k.matcher(sb5).lookingAt())) {
                    Matcher matcher4 = s.matcher(sb4);
                    if (matcher4.find() && h(sb4.substring(0, matcher4.start()))) {
                        int groupCount = matcher4.groupCount();
                        int i4 = 1;
                        while (true) {
                            if (i4 > groupCount) {
                                break;
                            } else if (matcher4.group(i4) != null) {
                                str4 = matcher4.group(i4);
                                sb4.delete(matcher4.start(), sb4.length());
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    if (str4.length() > 0) {
                        jVar.f3517d = true;
                        jVar.f3518e = str4;
                    }
                    g b2 = b(str2);
                    StringBuilder sb6 = new StringBuilder();
                    try {
                        sb = sb6;
                        gVar = b2;
                        try {
                            i2 = i(sb4.toString(), b2, sb6, false, jVar);
                        } catch (d e3) {
                            e2 = e3;
                        }
                    } catch (d e4) {
                        e2 = e4;
                        sb = sb6;
                        gVar = b2;
                        Matcher matcher5 = f3479k.matcher(sb4.toString());
                        if (e2.b != aVar2 || !matcher5.lookingAt()) {
                            throw new d(e2.b, e2.getMessage());
                        }
                        i2 = i(sb4.substring(matcher5.end()), gVar, sb, false, jVar);
                        if (i2 == 0) {
                            throw new d(aVar2, "Could not interpret numbers after plus-sign.");
                        }
                        if (i2 == 0) {
                        }
                        if (sb2.length() < 2) {
                        }
                    }
                    if (i2 == 0) {
                        List<String> list = this.b.get(Integer.valueOf(i2));
                        String str5 = list == null ? "ZZ" : list.get(0);
                        gVar2 = !str5.equals(str2) ? c(i2, str5) : gVar;
                        sb2 = sb;
                    } else {
                        k(sb4);
                        sb2 = sb;
                        sb2.append((CharSequence) sb4);
                        if (str2 != null) {
                            gVar3 = gVar;
                            jVar.b = gVar3.I;
                        } else {
                            gVar3 = gVar;
                        }
                        gVar2 = gVar3;
                    }
                    if (sb2.length() < 2) {
                        if (gVar2 != null) {
                            StringBuilder sb7 = new StringBuilder();
                            sb3 = new StringBuilder(sb2);
                            j(sb3, gVar2, sb7);
                        }
                        sb3 = sb2;
                        int length = sb3.length();
                        if (length < 2) {
                            throw new d(aVar, "The string supplied is too short to be a phone number.");
                        } else if (length <= 17) {
                            String sb8 = sb3.toString();
                            if (sb8.length() > 1 && sb8.charAt(0) == '0') {
                                jVar.f3519f = true;
                                jVar.f3520g = true;
                                int i5 = 1;
                                while (i5 < sb8.length() - 1 && sb8.charAt(i5) == '0') {
                                    i5++;
                                }
                                if (i5 != 1) {
                                    jVar.f3521h = true;
                                    jVar.f3522i = i5;
                                }
                            }
                            jVar.c = Long.parseLong(sb3.toString());
                            return jVar;
                        } else {
                            throw new d(aVar3, "The string supplied is too long to be a phone number.");
                        }
                    } else {
                        throw new d(aVar, "The string supplied is too short to be a phone number.");
                    }
                } else {
                    throw new d(aVar2, "Missing or invalid default region.");
                }
            } else {
                throw new d(aVar4, "The string supplied did not seem to be a phone number.");
            }
        } else {
            throw new d(aVar3, "The string supplied was too long to parse.");
        }
    }

    public final b n(String str, i iVar) {
        int intValue;
        b bVar = b.TOO_LONG;
        b bVar2 = b.IS_POSSIBLE;
        List<Integer> list = iVar.f3513f;
        List<Integer> list2 = iVar.f3514g;
        int length = str.length();
        if (list2.contains(Integer.valueOf(length)) || (intValue = list.get(0).intValue()) == length) {
            return bVar2;
        }
        if (intValue > length) {
            return b.TOO_SHORT;
        }
        return (list.get(list.size() - 1).intValue() >= length && list.subList(1, list.size()).contains(Integer.valueOf(length))) ? bVar2 : bVar;
    }
}
