package c.b.c.a.g0;

import c.b.c.a.i;
import c.b.c.a.i0.o0;
import c.b.c.a.i0.s0;
import c.b.c.a.i0.t0;
import c.b.c.a.i0.u0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.g0;
import c.b.c.a.m0.h0;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import c.b.c.a.o;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

public final class b extends i<s0> {

    public class a extends i.b<o, s0> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public o a(s0 s0Var) {
            s0 s0Var2 = s0Var;
            o0 n = s0Var2.p().n();
            SecretKeySpec secretKeySpec = new SecretKeySpec(s0Var2.keyValue_.r(), "HMAC");
            int i = s0Var2.p().tagSize_;
            int ordinal = n.ordinal();
            if (ordinal == 1) {
                return new h0(new g0("HMACSHA1", secretKeySpec), i);
            }
            if (ordinal == 3) {
                return new h0(new g0("HMACSHA256", secretKeySpec), i);
            }
            if (ordinal == 4) {
                return new h0(new g0("HMACSHA512", secretKeySpec), i);
            }
            throw new GeneralSecurityException("unknown hash");
        }
    }

    /* renamed from: c.b.c.a.g0.b$b  reason: collision with other inner class name */
    public class C0087b extends i.a<t0, s0> {
        public C0087b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public s0 a(t0 t0Var) {
            t0 t0Var2 = t0Var;
            s0.b bVar = (s0.b) s0.DEFAULT_INSTANCE.e();
            if (b.this != null) {
                bVar.d();
                ((s0) bVar.f3674c).version_ = 0;
                u0 u0Var = t0Var2.params_;
                if (u0Var == null) {
                    u0Var = u0.DEFAULT_INSTANCE;
                }
                bVar.d();
                s0.n((s0) bVar.f3674c, u0Var);
                byte[] a2 = i0.a(t0Var2.keySize_);
                c.b.c.a.j0.a.i h = c.b.c.a.j0.a.i.h(a2, 0, a2.length);
                bVar.d();
                s0.o((s0) bVar.f3674c, h);
                return (s0) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public t0 b(c.b.c.a.j0.a.i iVar) {
            return (t0) y.k(t0.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(t0 t0Var) {
            t0 t0Var2 = t0Var;
            if (t0Var2.keySize_ >= 16) {
                u0 u0Var = t0Var2.params_;
                if (u0Var == null) {
                    u0Var = u0.DEFAULT_INSTANCE;
                }
                b.i(u0Var);
                return;
            }
            throw new GeneralSecurityException("key too short");
        }
    }

    public b() {
        super(s0.class, new a(o.class));
    }

    public static void i(u0 u0Var) {
        if (u0Var.tagSize_ >= 10) {
            int ordinal = u0Var.n().ordinal();
            if (ordinal != 1) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (u0Var.tagSize_ > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (u0Var.tagSize_ > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (u0Var.tagSize_ > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.t0, c.b.c.a.i0.s0>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, s0> c() {
        return new C0087b(t0.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public s0 e(c.b.c.a.j0.a.i iVar) {
        return (s0) y.k(s0.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* renamed from: h */
    public void g(s0 s0Var) {
        n0.e(s0Var.version_, 0);
        if (s0Var.keyValue_.size() >= 16) {
            i(s0Var.p());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
