package b.b.k;

import android.view.View;
import b.i.l.r;
import b.i.l.t;

public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f399b;

    public class a extends t {
        public a() {
        }

        @Override // b.i.l.s
        public void a(View view) {
            m.this.f399b.p.setAlpha(1.0f);
            m.this.f399b.s.d(null);
            m.this.f399b.s = null;
        }

        @Override // b.i.l.t, b.i.l.s
        public void b(View view) {
            m.this.f399b.p.setVisibility(0);
        }
    }

    public m(i iVar) {
        this.f399b = iVar;
    }

    public void run() {
        i iVar = this.f399b;
        iVar.q.showAtLocation(iVar.p, 55, 0, 0);
        this.f399b.z();
        if (this.f399b.M()) {
            this.f399b.p.setAlpha(0.0f);
            i iVar2 = this.f399b;
            r a2 = b.i.l.m.a(iVar2.p);
            a2.a(1.0f);
            iVar2.s = a2;
            r rVar = this.f399b.s;
            a aVar = new a();
            View view = rVar.f1171a.get();
            if (view != null) {
                rVar.e(view, aVar);
                return;
            }
            return;
        }
        this.f399b.p.setAlpha(1.0f);
        this.f399b.p.setVisibility(0);
    }
}
