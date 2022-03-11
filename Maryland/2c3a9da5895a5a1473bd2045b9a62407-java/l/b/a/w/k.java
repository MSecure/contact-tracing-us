package l.b.a.w;

import l.b.a.p;
import l.b.a.q;
import l.b.a.t.h;

public final class k {
    public static final l<p> a = new a();
    public static final l<h> b = new b();
    public static final l<m> c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final l<p> f4302d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final l<q> f4303e = new e();

    /* renamed from: f  reason: collision with root package name */
    public static final l<l.b.a.e> f4304f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final l<l.b.a.g> f4305g = new g();

    public class a implements l<p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public p a(e eVar) {
            return (p) eVar.c(this);
        }
    }

    public class b implements l<h> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public h a(e eVar) {
            return (h) eVar.c(this);
        }
    }

    public class c implements l<m> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public m a(e eVar) {
            return (m) eVar.c(this);
        }
    }

    public class d implements l<p> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public p a(e eVar) {
            p pVar = (p) eVar.c(k.a);
            return pVar != null ? pVar : (p) eVar.c(k.f4303e);
        }
    }

    public class e implements l<q> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public q a(e eVar) {
            a aVar = a.OFFSET_SECONDS;
            if (eVar.f(aVar)) {
                return q.z(eVar.b(aVar));
            }
            return null;
        }
    }

    public class f implements l<l.b.a.e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public l.b.a.e a(e eVar) {
            a aVar = a.EPOCH_DAY;
            if (eVar.f(aVar)) {
                return l.b.a.e.R(eVar.i(aVar));
            }
            return null;
        }
    }

    public class g implements l<l.b.a.g> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public l.b.a.g a(e eVar) {
            a aVar = a.NANO_OF_DAY;
            if (eVar.f(aVar)) {
                return l.b.a.g.w(eVar.i(aVar));
            }
            return null;
        }
    }
}
