package e.c0.a0.s;

import e.v.g;
import e.v.l;
import e.x.a.f.f;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class n implements m {
    public final g a;
    public final l b;
    public final l c;

    /* loaded from: classes.dex */
    public class a extends l {
        public a(n nVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(n nVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM WorkProgress";
        }
    }

    public n(g gVar) {
        this.a = gVar;
        new AtomicBoolean(false);
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }

    public void a(String str) {
        this.a.b();
        f a2 = this.b.a();
        if (str == null) {
            a2.b.bindNull(1);
        } else {
            a2.b.bindString(1, str);
        }
        this.a.c();
        try {
            a2.d();
            this.a.l();
            this.a.g();
            l lVar = this.b;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        } catch (Throwable th) {
            this.a.g();
            this.b.c(a2);
            throw th;
        }
    }

    public void b() {
        this.a.b();
        f a2 = this.c.a();
        this.a.c();
        try {
            a2.d();
            this.a.l();
            this.a.g();
            l lVar = this.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        } catch (Throwable th) {
            this.a.g();
            this.c.c(a2);
            throw th;
        }
    }
}
