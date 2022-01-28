package c.b.c.a.m0;

import java.security.SecureRandom;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<SecureRandom> f5146a = new a();

    public class a extends ThreadLocal<SecureRandom> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public SecureRandom initialValue() {
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextLong();
            return secureRandom;
        }
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        f5146a.get().nextBytes(bArr);
        return bArr;
    }
}
