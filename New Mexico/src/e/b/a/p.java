package e.b.a;

import android.view.View;
import e.j.j.v;
import e.j.j.x;
import e.j.j.z;
/* loaded from: classes.dex */
public class p implements Runnable {
    public final /* synthetic */ m b;

    /* loaded from: classes.dex */
    public class a extends z {
        public a() {
        }

        @Override // e.j.j.y
        public void a(View view) {
            p.this.b.p.setAlpha(1.0f);
            p.this.b.s.d(null);
            p.this.b.s = null;
        }

        @Override // e.j.j.z, e.j.j.y
        public void b(View view) {
            p.this.b.p.setVisibility(0);
        }
    }

    public p(m mVar) {
        this.b = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.b;
        mVar.q.showAtLocation(mVar.p, 55, 0, 0);
        this.b.J();
        if (this.b.W()) {
            this.b.p.setAlpha(0.0f);
            m mVar2 = this.b;
            x b = v.b(mVar2.p);
            b.a(1.0f);
            mVar2.s = b;
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
