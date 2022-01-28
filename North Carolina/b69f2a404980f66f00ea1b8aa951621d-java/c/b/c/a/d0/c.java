package c.b.c.a.d0;

import c.b.c.a.p;
import c.b.c.a.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class c implements q<c.b.c.a.c> {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3445a = Logger.getLogger(c.class.getName());

    public static class a implements c.b.c.a.c {

        /* renamed from: a  reason: collision with root package name */
        public p<c.b.c.a.c> f3446a;

        public a(p<c.b.c.a.c> pVar) {
            this.f3446a = pVar;
        }

        @Override // c.b.c.a.c
        public byte[] a(byte[] bArr, byte[] bArr2) {
            return c.b.a.a.c.n.c.C(this.f3446a.f3814b.a(), this.f3446a.f3814b.f3816a.a(bArr, bArr2));
        }

        @Override // c.b.c.a.c
        public byte[] b(byte[] bArr, byte[] bArr2) {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (p.a<c.b.c.a.c> aVar : this.f3446a.a(copyOfRange)) {
                    try {
                        return aVar.f3816a.b(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e2) {
                        Logger logger = c.f3445a;
                        StringBuilder g = c.a.a.a.a.g("ciphertext prefix matches a key, but cannot decrypt: ");
                        g.append(e2.toString());
                        logger.info(g.toString());
                    }
                }
            }
            for (p.a<c.b.c.a.c> aVar2 : this.f3446a.b()) {
                try {
                    return aVar2.f3816a.b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    @Override // c.b.c.a.q
    public Class<c.b.c.a.c> a() {
        return c.b.c.a.c.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public c.b.c.a.c b(p<c.b.c.a.c> pVar) {
        return new a(pVar);
    }
}
