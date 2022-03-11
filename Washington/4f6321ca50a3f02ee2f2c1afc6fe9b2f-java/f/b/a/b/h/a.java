package f.b.a.b.h;

import e.b.a.m;
import f.b.a.b.b;
import f.b.a.b.i.d;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class a implements d {
    public static final String c = m.h.J1("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: d  reason: collision with root package name */
    public static final String f2298d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f2299e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<b> f2300f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new b("proto"), new b("json"))));

    /* renamed from: g  reason: collision with root package name */
    public static final a f2301g;
    public final String a;
    public final String b;

    static {
        String J1 = m.h.J1("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f2298d = J1;
        String J12 = m.h.J1("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f2299e = J12;
        f2301g = new a(J1, J12);
    }

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public byte[] b() {
        String str = this.b;
        if (str == null && this.a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }
}
