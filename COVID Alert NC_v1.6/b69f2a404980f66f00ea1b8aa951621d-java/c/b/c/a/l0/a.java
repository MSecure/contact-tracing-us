package c.b.c.a.l0;

import c.b.a.a.c.n.c;
import c.b.c.a.i;
import c.b.c.a.i0.f;
import c.b.c.a.i0.g;
import c.b.c.a.i0.h;
import c.b.c.a.i0.o0;
import c.b.c.a.i0.u0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import c.b.c.a.z;
import java.security.GeneralSecurityException;

public final class a extends i<f> {

    /* renamed from: c.b.c.a.l0.a$a  reason: collision with other inner class name */
    public class C0094a extends i.b<z, f> {
        public C0094a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public z a(f fVar) {
            f fVar2 = fVar;
            byte[] r = fVar2.keyValue_.r();
            o0 b2 = o0.b(fVar2.p().hkdfHashType_);
            if (b2 == null) {
                b2 = o0.UNRECOGNIZED;
            }
            return new c.b.c.a.m0.b(r, c.q2(b2), fVar2.p().derivedKeySize_, c.q2(fVar2.p().n().n()), fVar2.p().n().tagSize_, fVar2.p().ciphertextSegmentSize_, 0);
        }
    }

    public class b extends i.a<g, f> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public f a(g gVar) {
            g gVar2 = gVar;
            f.b bVar = (f.b) f.DEFAULT_INSTANCE.e();
            byte[] a2 = i0.a(gVar2.keySize_);
            c.b.c.a.j0.a.i h = c.b.c.a.j0.a.i.h(a2, 0, a2.length);
            bVar.d();
            f.o((f) bVar.f3674c, h);
            h hVar = gVar2.params_;
            if (hVar == null) {
                hVar = h.DEFAULT_INSTANCE;
            }
            bVar.d();
            f.n((f) bVar.f3674c, hVar);
            if (a.this != null) {
                bVar.d();
                ((f) bVar.f3674c).version_ = 0;
                return (f) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public g b(c.b.c.a.j0.a.i iVar) {
            return (g) y.k(g.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(g gVar) {
            g gVar2 = gVar;
            if (gVar2.keySize_ >= 16) {
                h hVar = gVar2.params_;
                if (hVar == null) {
                    hVar = h.DEFAULT_INSTANCE;
                }
                a.h(hVar);
                return;
            }
            throw new GeneralSecurityException("key_size must be at least 16 bytes");
        }
    }

    public a() {
        super(f.class, new C0094a(z.class));
    }

    public static void h(h hVar) {
        o0 o0Var = o0.UNKNOWN_HASH;
        n0.a(hVar.derivedKeySize_);
        o0 b2 = o0.b(hVar.hkdfHashType_);
        if (b2 == null) {
            b2 = o0.UNRECOGNIZED;
        }
        if (b2 == o0Var) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        } else if (hVar.n().n() != o0Var) {
            u0 n = hVar.n();
            if (n.tagSize_ >= 10) {
                int ordinal = n.n().ordinal();
                if (ordinal != 1) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            throw new GeneralSecurityException("unknown hash type");
                        } else if (n.tagSize_ > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (n.tagSize_ > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (n.tagSize_ > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                if (hVar.ciphertextSegmentSize_ < hVar.derivedKeySize_ + hVar.n().tagSize_ + 2 + 7) {
                    throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + tag_size + NONCE_PREFIX_IN_BYTES + 2)");
                }
                return;
            }
            throw new GeneralSecurityException("tag size too small");
        } else {
            throw new GeneralSecurityException("unknown HMAC hash type");
        }
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.g, c.b.c.a.i0.f>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, f> c() {
        return new b(g.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public f e(c.b.c.a.j0.a.i iVar) {
        return (f) y.k(f.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(f fVar) {
        f fVar2 = fVar;
        n0.e(fVar2.version_, 0);
        if (fVar2.keyValue_.size() < 16) {
            throw new GeneralSecurityException("key_value must have at least 16 bytes");
        } else if (fVar2.keyValue_.size() >= fVar2.p().derivedKeySize_) {
            h(fVar2.p());
        } else {
            throw new GeneralSecurityException("key_value must have at least as many bits as derived keys");
        }
    }
}
