package c.b.c.a.b0;

import b.x.t;
import c.b.c.a.p;
import c.b.c.a.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class b implements q<c.b.c.a.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f4779a = Logger.getLogger(b.class.getName());

    /* renamed from: c.b.c.a.b0.b$b  reason: collision with other inner class name */
    public static class C0091b implements c.b.c.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final p<c.b.c.a.a> f4780a;

        public C0091b(p pVar, a aVar) {
            this.f4780a = pVar;
        }

        @Override // c.b.c.a.a
        public byte[] a(byte[] bArr, byte[] bArr2) {
            return t.N(this.f4780a.f5215b.a(), this.f4780a.f5215b.f5217a.a(bArr, bArr2));
        }

        @Override // c.b.c.a.a
        public byte[] b(byte[] bArr, byte[] bArr2) {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (p.a<c.b.c.a.a> aVar : this.f4780a.a(copyOfRange)) {
                    try {
                        return aVar.f5217a.b(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e2) {
                        Logger logger = b.f4779a;
                        StringBuilder h = c.a.a.a.a.h("ciphertext prefix matches a key, but cannot decrypt: ");
                        h.append(e2.toString());
                        logger.info(h.toString());
                    }
                }
            }
            for (p.a<c.b.c.a.a> aVar2 : this.f4780a.b()) {
                try {
                    return aVar2.f5217a.b(bArr, bArr2);
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
        return new C0091b(pVar, null);
    }
}
