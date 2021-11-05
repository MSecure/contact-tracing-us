package c.b.c.a.l0;

import b.x.t;
import c.b.c.a.i;
import c.b.c.a.i0.o;
import c.b.c.a.i0.o0;
import c.b.c.a.i0.p;
import c.b.c.a.i0.q;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.e;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import c.b.c.a.z;
import java.security.GeneralSecurityException;

public final class b extends i<o> {

    public class a extends i.b<z, o> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public z a(o oVar) {
            o oVar2 = oVar;
            byte[] q = oVar2.keyValue_.q();
            o0 b2 = o0.b(oVar2.p().hkdfHashType_);
            if (b2 == null) {
                b2 = o0.UNRECOGNIZED;
            }
            return new e(q, t.Y2(b2), oVar2.p().derivedKeySize_, oVar2.p().ciphertextSegmentSize_, 0);
        }
    }

    /* renamed from: c.b.c.a.l0.b$b  reason: collision with other inner class name */
    public class C0104b extends i.a<p, o> {
        public C0104b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public o a(p pVar) {
            p pVar2 = pVar;
            o.b bVar = (o.b) o.DEFAULT_INSTANCE.e();
            byte[] a2 = i0.a(pVar2.keySize_);
            c.b.c.a.j0.a.i g2 = c.b.c.a.j0.a.i.g(a2, 0, a2.length);
            bVar.d();
            o.o((o) bVar.f5063c, g2);
            q qVar = pVar2.params_;
            if (qVar == null) {
                qVar = q.DEFAULT_INSTANCE;
            }
            bVar.d();
            o.n((o) bVar.f5063c, qVar);
            if (b.this != null) {
                bVar.d();
                ((o) bVar.f5063c).version_ = 0;
                return (o) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public p b(c.b.c.a.j0.a.i iVar) {
            return (p) y.k(p.DEFAULT_INSTANCE, iVar, c.b.c.a.j0.a.q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(p pVar) {
            p pVar2 = pVar;
            if (pVar2.keySize_ >= 16) {
                q qVar = pVar2.params_;
                if (qVar == null) {
                    qVar = q.DEFAULT_INSTANCE;
                }
                b.h(qVar);
                return;
            }
            throw new GeneralSecurityException("key_size must be at least 16 bytes");
        }
    }

    public b() {
        super(o.class, new a(z.class));
    }

    public static void h(q qVar) {
        n0.a(qVar.derivedKeySize_);
        o0 b2 = o0.b(qVar.hkdfHashType_);
        if (b2 == null) {
            b2 = o0.UNRECOGNIZED;
        }
        if (b2 == o0.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        } else if (qVar.ciphertextSegmentSize_ < qVar.derivedKeySize_ + 7 + 16 + 2) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + NONCE_PREFIX_IN_BYTES + TAG_SIZE_IN_BYTES + 2)");
        }
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.p, c.b.c.a.i0.o>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, o> c() {
        return new C0104b(p.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public o e(c.b.c.a.j0.a.i iVar) {
        return (o) y.k(o.DEFAULT_INSTANCE, iVar, c.b.c.a.j0.a.q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(o oVar) {
        o oVar2 = oVar;
        n0.e(oVar2.version_, 0);
        h(oVar2.p());
    }
}
