package e.b0.a0.t;

import android.content.Context;
import androidx.work.ListenableWorker;
import e.b.a.m;
import e.b0.a0.s.o;
import e.b0.a0.t.s.c;
import e.b0.i;
import e.b0.j;
import java.util.Objects;
import java.util.UUID;

public class n implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public static final String f1136h = e.b0.n.e("WorkForegroundRunnable");
    public final c<Void> b = new c<>();
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final o f1137d;

    /* renamed from: e  reason: collision with root package name */
    public final ListenableWorker f1138e;

    /* renamed from: f  reason: collision with root package name */
    public final j f1139f;

    /* renamed from: g  reason: collision with root package name */
    public final e.b0.a0.t.t.a f1140g;

    public class a implements Runnable {
        public final /* synthetic */ c b;

        public a(c cVar) {
            this.b = cVar;
        }

        public void run() {
            c cVar = this.b;
            Objects.requireNonNull(n.this.f1138e);
            c cVar2 = new c();
            cVar2.k(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
            cVar.l(cVar2);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ c b;

        public b(c cVar) {
            this.b = cVar;
        }

        public void run() {
            try {
                i iVar = (i) this.b.get();
                if (iVar != null) {
                    e.b0.n.c().a(n.f1136h, String.format("Updating notification for %s", n.this.f1137d.c), new Throwable[0]);
                    n nVar = n.this;
                    ListenableWorker listenableWorker = nVar.f1138e;
                    listenableWorker.f301f = true;
                    c<Void> cVar = nVar.b;
                    j jVar = nVar.f1139f;
                    Context context = nVar.c;
                    UUID uuid = listenableWorker.c.a;
                    p pVar = (p) jVar;
                    Objects.requireNonNull(pVar);
                    c cVar2 = new c();
                    e.b0.a0.t.t.a aVar = pVar.a;
                    ((e.b0.a0.t.t.b) aVar).a.execute(new o(pVar, cVar2, uuid, iVar, context));
                    cVar.l(cVar2);
                    return;
                }
                throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", n.this.f1137d.c));
            } catch (Throwable th) {
                n.this.b.k(th);
            }
        }
    }

    public n(Context context, o oVar, ListenableWorker listenableWorker, j jVar, e.b0.a0.t.t.a aVar) {
        this.c = context;
        this.f1137d = oVar;
        this.f1138e = listenableWorker;
        this.f1139f = jVar;
        this.f1140g = aVar;
    }

    public void run() {
        if (!this.f1137d.q || m.e.I0()) {
            this.b.j(null);
            return;
        }
        c cVar = new c();
        ((e.b0.a0.t.t.b) this.f1140g).c.execute(new a(cVar));
        cVar.a(new b(cVar), ((e.b0.a0.t.t.b) this.f1140g).c);
    }
}
