package b.z.y.r;

import b.r.h;
import b.r.m;
import b.u.a.f;
import b.u.a.g.e;

public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    public final h f2087a;

    /* renamed from: b  reason: collision with root package name */
    public final b.r.b<m> f2088b;

    /* renamed from: c  reason: collision with root package name */
    public final m f2089c;

    /* renamed from: d  reason: collision with root package name */
    public final m f2090d;

    public class a extends b.r.b<m> {
        public a(o oVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.u.a.f, java.lang.Object] */
        @Override // b.r.b
        public void bind(f fVar, m mVar) {
            m mVar2 = mVar;
            String str = mVar2.f2085a;
            if (str == null) {
                ((e) fVar).f1754b.bindNull(1);
            } else {
                ((e) fVar).f1754b.bindString(1, str);
            }
            byte[] h = b.z.e.h(mVar2.f2086b);
            e eVar = (e) fVar;
            if (h == null) {
                eVar.f1754b.bindNull(2);
            } else {
                eVar.f1754b.bindBlob(2, h);
            }
        }

        @Override // b.r.m
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    public class b extends m {
        public b(o oVar, h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends m {
        public c(o oVar, h hVar) {
            super(hVar);
        }

        @Override // b.r.m
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(h hVar) {
        this.f2087a = hVar;
        this.f2088b = new a(this, hVar);
        this.f2089c = new b(this, hVar);
        this.f2090d = new c(this, hVar);
    }

    public void a(String str) {
        this.f2087a.assertNotSuspendingTransaction();
        b.u.a.g.f acquire = this.f2089c.acquire();
        if (str == null) {
            ((e) acquire).f1754b.bindNull(1);
        } else {
            ((e) acquire).f1754b.bindString(1, str);
        }
        this.f2087a.beginTransaction();
        acquire = (b.u.a.g.f) acquire;
        try {
            acquire.b();
            this.f2087a.setTransactionSuccessful();
        } finally {
            this.f2087a.endTransaction();
            this.f2089c.release(acquire);
        }
    }

    public void b() {
        this.f2087a.assertNotSuspendingTransaction();
        b.u.a.g.f acquire = this.f2090d.acquire();
        this.f2087a.beginTransaction();
        acquire = (b.u.a.g.f) acquire;
        try {
            acquire.b();
            this.f2087a.setTransactionSuccessful();
        } finally {
            this.f2087a.endTransaction();
            this.f2090d.release(acquire);
        }
    }
}
