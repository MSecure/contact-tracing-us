package f.b.a.a.a.i;

import android.content.Context;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.text.style.URLSpan;
import f.b.a.a.a.i.e0.a;
import java.security.SecureRandom;
import l.b.a.e;
import l.b.a.q;
import l.b.a.t;
import l.b.a.v.c;
import l.b.a.v.d;

public final class b0 {
    public static final a a = a.e("StringUtils");
    public static final SecureRandom b = new SecureRandom();
    public static final f.b.b.c.a c = f.b.b.c.a.a;

    static {
        c cVar = c.f4371h;
        d dVar = new d();
        dVar.h("yyyy-MM-dd, HH:mm:ss z");
        dVar.q().h(q.t("UTC"));
    }

    public static String a(long j2, e eVar, t tVar, Context context) {
        l.b.a.d c2 = l.b.a.d.c(tVar.b.b.A(tVar.f4327d).w(), eVar);
        l.b.a.d f2 = l.b.a.d.f(1);
        return DateUtils.getRelativeDateTimeString(context, j2, 86400000, c2.q(f2.b, (long) f2.c).t(), 0).toString();
    }

    public static SpannableString b(URLSpan uRLSpan, String str, String str2) {
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.indexOf(str2);
        spannableString.setSpan(uRLSpan, indexOf, str2.length() + indexOf, 33);
        return spannableString;
    }

    public static String c(int i2) {
        byte[] bArr = new byte[i2];
        b.nextBytes(bArr);
        return c.c(bArr);
    }
}
