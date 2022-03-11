package f.b.a.a.a.t;

import f.b.b.c.a;
import java.security.SecureRandom;
/* loaded from: classes.dex */
public final class j0 {
    public static final a a = a.a;

    public static String a(SecureRandom secureRandom) {
        byte[] bArr = new byte[16];
        secureRandom.nextBytes(bArr);
        return a.c(bArr);
    }
}
