package l.b.a.x;

import l.b.a.q;
import l.b.a.r;
import l.b.a.u.h;
/* loaded from: classes.dex */
public final class k {
    public static final l<q> a = new a();
    public static final l<h> b = new b();
    public static final l<m> c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final l<q> f4777d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final l<r> f4778e = new e();

    /* renamed from: f  reason: collision with root package name */
    public static final l<l.b.a.f> f4779f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final l<l.b.a.h> f4780g = new g();

    /* loaded from: classes.dex */
    public class a implements l<q> {
        @Override // l.b.a.x.l
        public q a(e eVar) {
            return (q) eVar.c(this);
        }
    }

    /* loaded from: classes.dex */
    public class b implements l<h> {
        @Override // l.b.a.x.l
        public h a(e eVar) {
            return (h) eVar.c(this);
        }
    }

    /* loaded from: classes.dex */
    public class c implements l<m> {
        @Override // l.b.a.x.l
        public m a(e eVar) {
            return (m) eVar.c(this);
        }
    }

    /* loaded from: classes.dex */
    public class d implements l<q> {
        @Override // l.b.a.x.l
        public q a(e eVar) {
            q qVar = (q) eVar.c(k.a);
            return qVar != null ? qVar : (q) eVar.c(k.f4778e);
        }
    }

    /* loaded from: classes.dex */
    public class e implements l<r> {
        @Override // l.b.a.x.l
        public r a(e eVar) {
            a aVar = a.OFFSET_SECONDS;
            if (eVar.f(aVar)) {
                return r.z(eVar.b(aVar));
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class f implements l<l.b.a.f> {
        @Override // l.b.a.x.l
        public l.b.a.f a(e eVar) {
            a aVar = a.EPOCH_DAY;
            if (eVar.f(aVar)) {
                return l.b.a.f.R(eVar.i(aVar));
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class g implements l<l.b.a.h> {
        @Override // l.b.a.x.l
        public l.b.a.h a(e eVar) {
            a aVar = a.NANO_OF_DAY;
            if (eVar.f(aVar)) {
                return l.b.a.h.w(eVar.i(aVar));
            }
            return null;
        }
    }
}
