package b.n;

import android.os.Handler;
import b.n.f;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public final j f1414a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f1415b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public a f1416c;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final j f1417b;

        /* renamed from: c  reason: collision with root package name */
        public final f.a f1418c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1419d = false;

        public a(j jVar, f.a aVar) {
            this.f1417b = jVar;
            this.f1418c = aVar;
        }

        public void run() {
            if (!this.f1419d) {
                this.f1417b.d(this.f1418c);
                this.f1419d = true;
            }
        }
    }

    public v(i iVar) {
        this.f1414a = new j(iVar);
    }

    public final void a(f.a aVar) {
        a aVar2 = this.f1416c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.f1414a, aVar);
        this.f1416c = aVar3;
        this.f1415b.postAtFrontOfQueue(aVar3);
    }
}
