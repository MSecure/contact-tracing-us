package c.b.c.a;

import c.a.a.a.a;
import c.b.c.a.i;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.b0;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.r0;
import java.security.GeneralSecurityException;

public class g<PrimitiveT, KeyProtoT extends r0> implements f<PrimitiveT> {

    /* renamed from: a  reason: collision with root package name */
    public final i<KeyProtoT> f4820a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<PrimitiveT> f4821b;

    public g(i<KeyProtoT> iVar, Class<PrimitiveT> cls) {
        if (iVar.f().contains(cls) || Void.class.equals(cls)) {
            this.f4820a = iVar;
            this.f4821b = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", iVar.toString(), cls.getName()));
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.lang.Class<PrimitiveT>, java.lang.Class<P> */
    public final PrimitiveT a(i iVar) {
        try {
            KeyProtoT e2 = this.f4820a.e(iVar);
            if (!Void.class.equals(this.f4821b)) {
                this.f4820a.g(e2);
                return (PrimitiveT) this.f4820a.b(e2, (Class<PrimitiveT>) this.f4821b);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (b0 e3) {
            StringBuilder h = a.h("Failures parsing proto of type ");
            h.append(this.f4820a.f4837a.getName());
            throw new GeneralSecurityException(h.toString(), e3);
        }
    }

    public final r0 b(i iVar) {
        try {
            i.a<?, KeyProtoT> c2 = this.f4820a.c();
            r0 b2 = c2.b(iVar);
            c2.c(b2);
            return c2.a(b2);
        } catch (b0 e2) {
            StringBuilder h = a.h("Failures parsing proto of type ");
            h.append(this.f4820a.c().f4840a.getName());
            throw new GeneralSecurityException(h.toString(), e2);
        }
    }

    public final v0 c(c.b.c.a.j0.a.i iVar) {
        try {
            i.a<?, KeyProtoT> c2 = this.f4820a.c();
            r0 b2 = c2.b(iVar);
            c2.c(b2);
            v0.b bVar = (v0.b) v0.DEFAULT_INSTANCE.e();
            String a2 = this.f4820a.a();
            bVar.d();
            v0.n((v0) bVar.f5063c, a2);
            c.b.c.a.j0.a.i byteString = c2.a(b2).toByteString();
            bVar.d();
            v0.o((v0) bVar.f5063c, byteString);
            v0.c d2 = this.f4820a.d();
            bVar.d();
            v0.p((v0) bVar.f5063c, d2);
            return (v0) bVar.b();
        } catch (b0 e2) {
            throw new GeneralSecurityException("Unexpected proto", e2);
        }
    }
}
