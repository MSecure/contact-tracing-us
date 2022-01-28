package e.q;

import android.os.Handler;
import e.q.h;

public class a0 {
    public final m a;
    public final Handler b = new Handler();
    public a c;

    public static class a implements Runnable {
        public final m b;
        public final h.a c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1804d = false;

        public a(m mVar, h.a aVar) {
            this.b = mVar;
            this.c = aVar;
        }

        public void run() {
            if (!this.f1804d) {
                this.b.e(this.c);
                this.f1804d = true;
            }
        }
    }

    public a0(l lVar) {
        this.a = new m(lVar);
    }

    public final void a(h.a aVar) {
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.a, aVar);
        this.c = aVar3;
        this.b.postAtFrontOfQueue(aVar3);
    }
}
