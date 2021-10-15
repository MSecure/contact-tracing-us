package b.b0.y.r;

import b.s.h;
import b.s.m;
import b.w.a.f;
import b.w.a.g.e;

public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    public final h f1230a;

    /* renamed from: b  reason: collision with root package name */
    public final b.s.b<m> f1231b;

    /* renamed from: c  reason: collision with root package name */
    public final m f1232c;

    /* renamed from: d  reason: collision with root package name */
    public final m f1233d;

    public class a extends b.s.b<m> {
        public a(o oVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.w.a.f, java.lang.Object] */
        @Override // b.s.b
        public void bind(f fVar, m mVar) {
            m mVar2 = mVar;
            String str = mVar2.f1228a;
            if (str == null) {
                ((e) fVar).f2630b.bindNull(1);
            } else {
                ((e) fVar).f2630b.bindString(1, str);
            }
            byte[] h = b.b0.e.h(mVar2.f1229b);
            e eVar = (e) fVar;
            if (h == null) {
                eVar.f2630b.bindNull(2);
            } else {
                eVar.f2630b.bindBlob(2, h);
            }
        }

        @Override // b.s.m
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    public class b extends m {
        public b(o oVar, h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends m {
        public c(o oVar, h hVar) {
            super(hVar);
        }

        @Override // b.s.m
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(h hVar) {
        this.f1230a = hVar;
        this.f1231b = new a(this, hVar);
        this.f1232c = new b(this, hVar);
        this.f1233d = new c(this, hVar);
    }

    public void a(String str) {
        this.f1230a.assertNotSuspendingTransaction();
        b.w.a.g.f acquire = this.f1232c.acquire();
        if (str == null) {
            ((e) acquire).f2630b.bindNull(1);
        } else {
            ((e) acquire).f2630b.bindString(1, str);
        }
        this.f1230a.beginTransaction();
        acquire = (b.w.a.g.f) acquire;
        try {
            acquire.b();
            this.f1230a.setTransactionSuccessful();
        } finally {
            this.f1230a.endTransaction();
            this.f1232c.release(acquire);
        }
    }

    public void b() {
        this.f1230a.assertNotSuspendingTransaction();
        b.w.a.g.f acquire = this.f1233d.acquire();
        this.f1230a.beginTransaction();
        acquire = (b.w.a.g.f) acquire;
        try {
            acquire.b();
            this.f1230a.setTransactionSuccessful();
        } finally {
            this.f1230a.endTransaction();
            this.f1233d.release(acquire);
        }
    }
}
