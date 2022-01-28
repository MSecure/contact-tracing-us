package e.b.a;

import android.view.View;
import e.i.i.v;
import e.i.i.x;
import e.i.i.z;

public class p implements Runnable {
    public final /* synthetic */ m b;

    public class a extends z {
        public a() {
        }

        @Override // e.i.i.y
        public void a(View view) {
            p.this.b.p.setAlpha(1.0f);
            p.this.b.s.d(null);
            p.this.b.s = null;
        }

        @Override // e.i.i.y, e.i.i.z
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
            x b2 = v.b(mVar2.p);
            b2.a(1.0f);
            mVar2.s = b2;
            x xVar = this.b.s;
            a aVar = new a();
            View view = xVar.a.get();
            if (view != null) {
                xVar.e(view, aVar);
                return;
            }
            return;
        }
        this.b.p.setAlpha(1.0f);
        this.b.p.setVisibility(0);
    }
}
