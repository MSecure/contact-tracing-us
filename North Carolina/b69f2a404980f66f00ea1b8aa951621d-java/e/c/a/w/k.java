package e.c.a.w;

import e.c.a.p;
import e.c.a.q;
import e.c.a.t.h;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final l<p> f5177a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final l<h> f5178b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final l<m> f5179c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final l<p> f5180d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final l<q> f5181e = new e();
    public static final l<e.c.a.e> f = new f();
    public static final l<e.c.a.g> g = new g();

    public class a implements l<p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public p a(e eVar) {
            return (p) eVar.f(this);
        }
    }

    public class b implements l<h> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public h a(e eVar) {
            return (h) eVar.f(this);
        }
    }

    public class c implements l<m> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public m a(e eVar) {
            return (m) eVar.f(this);
        }
    }

    public class d implements l<p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public p a(e eVar) {
            p pVar = (p) eVar.f(k.f5177a);
            return pVar != null ? pVar : (p) eVar.f(k.f5181e);
        }
    }

    public class e implements l<q> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public q a(e eVar) {
            if (eVar.i(a.OFFSET_SECONDS)) {
                return q.C(eVar.d(a.OFFSET_SECONDS));
            }
            return null;
        }
    }

    public class f implements l<e.c.a.e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public e.c.a.e a(e eVar) {
            if (eVar.i(a.EPOCH_DAY)) {
                return e.c.a.e.R(eVar.l(a.EPOCH_DAY));
            }
            return null;
        }
    }

    public class g implements l<e.c.a.g> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public e.c.a.g a(e eVar) {
            if (eVar.i(a.NANO_OF_DAY)) {
                return e.c.a.g.z(eVar.l(a.NANO_OF_DAY));
            }
            return null;
        }
    }
}
