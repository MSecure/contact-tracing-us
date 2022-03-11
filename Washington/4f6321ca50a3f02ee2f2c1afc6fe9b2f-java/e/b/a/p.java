package e.b.a;

import android.view.View;
import e.i.i.l;
import e.i.i.r;
import e.i.i.t;

public class p implements Runnable {
    public final /* synthetic */ m b;

    public class a extends t {
        public a() {
        }

        @Override // e.i.i.s
        public void a(View view) {
            p.this.b.p.setAlpha(1.0f);
            p.this.b.s.d(null);
            p.this.b.s = null;
        }

        @Override // e.i.i.s, e.i.i.t
        public void b(View view) {
            p.this.b.p.setVisibility(0);
        }
    }

    public p(m mVar) {
        this.b = mVar;
    }

    public void run() {
        m mVar = this.b;
        mVar.q.showAtLocation(mVar.p, 55, 0, 0);
        this.b.J();
        if (this.b.W()) {
            this.b.p.setAlpha(0.0f);
            m mVar2 = this.b;
            r b2 = l.b(mVar2.p);
            b2.a(1.0f);
            mVar2.s = b2;
            r rVar = this.b.s;
            a aVar = new a();
            View view = rVar.a.get();
            if (view != null) {
                rVar.e(view, aVar);
                return;
            }
            return;
        }
        this.b.p.setAlpha(1.0f);
        this.b.p.setVisibility(0);
    }
}
