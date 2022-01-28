package g.b.a.w;

import g.b.a.p;
import g.b.a.q;
import g.b.a.t.h;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final l<p> f6656a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final l<h> f6657b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final l<m> f6658c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final l<p> f6659d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final l<q> f6660e = new e();

    /* renamed from: f  reason: collision with root package name */
    public static final l<g.b.a.e> f6661f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final l<g.b.a.g> f6662g = new g();

    public class a implements l<p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public p a(e eVar) {
            return (p) eVar.f(this);
        }
    }

    public class b implements l<h> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public h a(e eVar) {
            return (h) eVar.f(this);
        }
    }

    public class c implements l<m> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public m a(e eVar) {
            return (m) eVar.f(this);
        }
    }

    public class d implements l<p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public p a(e eVar) {
            p pVar = (p) eVar.f(k.f6656a);
            return pVar != null ? pVar : (p) eVar.f(k.f6660e);
        }
    }

    public class e implements l<q> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public q a(e eVar) {
            if (eVar.k(a.OFFSET_SECONDS)) {
                return q.R(eVar.d(a.OFFSET_SECONDS));
            }
            return null;
        }
    }

    public class f implements l<g.b.a.e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public g.b.a.e a(e eVar) {
            if (eVar.k(a.EPOCH_DAY)) {
                return g.b.a.e.h0(eVar.n(a.EPOCH_DAY));
            }
            return null;
        }
    }

    public class g implements l<g.b.a.g> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public g.b.a.g a(e eVar) {
            if (eVar.k(a.NANO_OF_DAY)) {
                return g.b.a.g.P(eVar.n(a.NANO_OF_DAY));
            }
            return null;
        }
    }
}
