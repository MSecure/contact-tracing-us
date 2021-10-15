package b.o;

import android.os.Handler;
import b.o.f;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public final j f2250a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f2251b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public a f2252c;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final j f2253b;

        /* renamed from: c  reason: collision with root package name */
        public final f.a f2254c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2255d = false;

        public a(j jVar, f.a aVar) {
            this.f2253b = jVar;
            this.f2254c = aVar;
        }

        public void run() {
            if (!this.f2255d) {
                this.f2253b.e(this.f2254c);
                this.f2255d = true;
            }
        }
    }

    public v(i iVar) {
        this.f2250a = new j(iVar);
    }

    public final void a(f.a aVar) {
        a aVar2 = this.f2252c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.f2250a, aVar);
        this.f2252c = aVar3;
        this.f2251b.postAtFrontOfQueue(aVar3);
    }
}
