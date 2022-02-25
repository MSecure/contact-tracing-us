package e.p;

import android.os.Handler;
import e.p.g;

public class w {
    public final k a;
    public final Handler b = new Handler();
    public a c;

    public static class a implements Runnable {
        public final k b;
        public final g.a c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1723d = false;

        public a(k kVar, g.a aVar) {
            this.b = kVar;
            this.c = aVar;
        }

        public void run() {
            if (!this.f1723d) {
                this.b.e(this.c);
                this.f1723d = true;
            }
        }
    }

    public w(j jVar) {
        this.a = new k(jVar);
    }

    public final void a(g.a aVar) {
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.a, aVar);
        this.c = aVar3;
        this.b.postAtFrontOfQueue(aVar3);
    }
}
