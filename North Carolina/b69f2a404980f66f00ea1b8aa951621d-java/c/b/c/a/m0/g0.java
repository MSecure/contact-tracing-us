package c.b.c.a.m0;

import c.b.c.a.h0.c;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

public final class g0 implements c {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadLocal<Mac> f3734a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f3735b;

    /* renamed from: c  reason: collision with root package name */
    public final Key f3736c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3737d;

    public class a extends ThreadLocal<Mac> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public Mac initialValue() {
            try {
                Mac a2 = a0.g.a(g0.this.f3735b);
                a2.init(g0.this.f3736c);
                return a2;
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public g0(String str, Key key) {
        int i;
        this.f3735b = str;
        this.f3736c = key;
        if (key.getEncoded().length >= 16) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c2 = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c2 = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c2 = 0;
            }
            if (c2 == 0) {
                i = 20;
            } else if (c2 == 1) {
                i = 32;
            } else if (c2 == 2) {
                i = 64;
            } else {
                throw new NoSuchAlgorithmException(c.a.a.a.a.o("unknown Hmac algorithm: ", str));
            }
            this.f3737d = i;
            this.f3734a.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    @Override // c.b.c.a.h0.c
    public byte[] a(byte[] bArr, int i) {
        if (i <= this.f3737d) {
            this.f3734a.get().update(bArr);
            return Arrays.copyOf(this.f3734a.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
