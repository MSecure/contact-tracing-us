package c.b.c.a.b0;

import c.b.a.a.c.n.c;
import c.b.c.a.p;
import c.b.c.a.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class b implements q<c.b.c.a.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3429a = Logger.getLogger(b.class.getName());

    /* renamed from: c.b.c.a.b0.b$b  reason: collision with other inner class name */
    public static class C0082b implements c.b.c.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final p<c.b.c.a.a> f3430a;

        public C0082b(p pVar, a aVar) {
            this.f3430a = pVar;
        }

        @Override // c.b.c.a.a
        public byte[] a(byte[] bArr, byte[] bArr2) {
            return c.C(this.f3430a.f3814b.a(), this.f3430a.f3814b.f3816a.a(bArr, bArr2));
        }

        @Override // c.b.c.a.a
        public byte[] b(byte[] bArr, byte[] bArr2) {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (p.a<c.b.c.a.a> aVar : this.f3430a.a(copyOfRange)) {
                    try {
                        return aVar.f3816a.b(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e2) {
                        Logger logger = b.f3429a;
                        StringBuilder g = c.a.a.a.a.g("ciphertext prefix matches a key, but cannot decrypt: ");
                        g.append(e2.toString());
                        logger.info(g.toString());
                    }
                }
            }
            for (p.a<c.b.c.a.a> aVar2 : this.f3430a.b()) {
                try {
                    return aVar2.f3816a.b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    @Override // c.b.c.a.q
    public Class<c.b.c.a.a> a() {
        return c.b.c.a.a.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public c.b.c.a.a b(p<c.b.c.a.a> pVar) {
        return new C0082b(pVar, null);
    }
}
