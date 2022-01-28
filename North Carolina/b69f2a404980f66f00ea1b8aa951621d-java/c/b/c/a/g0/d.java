package c.b.c.a.g0;

import c.b.a.a.c.n.c;
import c.b.c.a.i0.f1;
import c.b.c.a.o;
import c.b.c.a.p;
import c.b.c.a.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class d implements q<o> {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3472a = Logger.getLogger(d.class.getName());

    public static class b implements o {

        /* renamed from: a  reason: collision with root package name */
        public final p<o> f3473a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f3474b = {0};

        public b(p pVar, a aVar) {
            this.f3473a = pVar;
        }

        @Override // c.b.c.a.o
        public void a(byte[] bArr, byte[] bArr2) {
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (p.a<o> aVar : this.f3473a.a(copyOf)) {
                    try {
                        if (aVar.f3819d.equals(f1.LEGACY)) {
                            aVar.f3816a.a(copyOfRange, c.C(bArr2, this.f3474b));
                            return;
                        }
                        aVar.f3816a.a(copyOfRange, bArr2);
                        return;
                    } catch (GeneralSecurityException e2) {
                        Logger logger = d.f3472a;
                        logger.info("tag prefix matches a key, but cannot verify: " + e2);
                    }
                }
                for (p.a<o> aVar2 : this.f3473a.b()) {
                    try {
                        aVar2.f3816a.a(bArr, bArr2);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid MAC");
            }
            throw new GeneralSecurityException("tag too short");
        }

        @Override // c.b.c.a.o
        public byte[] b(byte[] bArr) {
            if (this.f3473a.f3814b.f3819d.equals(f1.LEGACY)) {
                return c.C(this.f3473a.f3814b.a(), this.f3473a.f3814b.f3816a.b(c.C(bArr, this.f3474b)));
            }
            return c.C(this.f3473a.f3814b.a(), this.f3473a.f3814b.f3816a.b(bArr));
        }
    }

    @Override // c.b.c.a.q
    public Class<o> a() {
        return o.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public o b(p<o> pVar) {
        return new b(pVar, null);
    }
}
