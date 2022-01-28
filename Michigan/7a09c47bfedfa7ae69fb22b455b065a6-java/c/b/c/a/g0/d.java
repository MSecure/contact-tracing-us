package c.b.c.a.g0;

import b.x.t;
import c.b.c.a.i0.f1;
import c.b.c.a.o;
import c.b.c.a.p;
import c.b.c.a.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class d implements q<o> {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f4824a = Logger.getLogger(d.class.getName());

    public static class b implements o {

        /* renamed from: a  reason: collision with root package name */
        public final p<o> f4825a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f4826b = {0};

        public b(p pVar, a aVar) {
            this.f4825a = pVar;
        }

        @Override // c.b.c.a.o
        public void a(byte[] bArr, byte[] bArr2) {
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (p.a<o> aVar : this.f4825a.a(copyOf)) {
                    try {
                        if (aVar.f5220d.equals(f1.LEGACY)) {
                            aVar.f5217a.a(copyOfRange, t.N(bArr2, this.f4826b));
                            return;
                        }
                        aVar.f5217a.a(copyOfRange, bArr2);
                        return;
                    } catch (GeneralSecurityException e2) {
                        Logger logger = d.f4824a;
                        logger.info("tag prefix matches a key, but cannot verify: " + e2);
                    }
                }
                for (p.a<o> aVar2 : this.f4825a.b()) {
                    try {
                        aVar2.f5217a.a(bArr, bArr2);
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
            if (this.f4825a.f5215b.f5220d.equals(f1.LEGACY)) {
                return t.N(this.f4825a.f5215b.a(), this.f4825a.f5215b.f5217a.b(t.N(bArr, this.f4826b)));
            }
            return t.N(this.f4825a.f5215b.a(), this.f4825a.f5215b.f5217a.b(bArr));
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
