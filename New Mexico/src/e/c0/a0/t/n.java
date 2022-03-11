package e.c0.a0.t;

import android.content.Context;
import androidx.work.ListenableWorker;
import e.b.a.m;
import e.c0.a0.s.o;
import e.c0.a0.t.s.c;
import e.c0.i;
import e.c0.j;
import java.util.Objects;
import java.util.UUID;
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public static final String f1215h = e.c0.n.e("WorkForegroundRunnable");
    public final c<Void> b = new c<>();
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final o f1216d;

    /* renamed from: e  reason: collision with root package name */
    public final ListenableWorker f1217e;

    /* renamed from: f  reason: collision with root package name */
    public final j f1218f;

    /* renamed from: g  reason: collision with root package name */
    public final e.c0.a0.t.t.a f1219g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ c b;

        public a(c cVar) {
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.b;
            Objects.requireNonNull(n.this.f1217e);
            c cVar2 = new c();
            cVar2.k(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
            cVar.l(cVar2);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ c b;

        public b(c cVar) {
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                i iVar = (i) this.b.get();
                if (iVar != null) {
                    e.c0.n.c().a(n.f1215h, String.format("Updating notification for %s", n.this.f1216d.c), new Throwable[0]);
                    n nVar = n.this;
                    ListenableWorker listenableWorker = nVar.f1217e;
                    listenableWorker.f301f = true;
                    c<Void> cVar = nVar.b;
                    j jVar = nVar.f1218f;
                    Context context = nVar.c;
                    UUID uuid = listenableWorker.c.a;
                    p pVar = (p) jVar;
                    Objects.requireNonNull(pVar);
                    c cVar2 = new c();
                    ((e.c0.a0.t.t.b) pVar.a).a.execute(new o(pVar, cVar2, uuid, iVar, context));
                    cVar.l(cVar2);
                    return;
                }
                throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", n.this.f1216d.c));
            } catch (Throwable th) {
                n.this.b.k(th);
            }
        }
    }

    public n(Context context, o oVar, ListenableWorker listenableWorker, j jVar, e.c0.a0.t.t.a aVar) {
        this.c = context;
        this.f1216d = oVar;
        this.f1217e = listenableWorker;
        this.f1218f = jVar;
        this.f1219g = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f1216d.q || m.e.K0()) {
            this.b.j(null);
            return;
        }
        c cVar = new c();
        ((e.c0.a0.t.t.b) this.f1219g).c.execute(new a(cVar));
        cVar.a(new b(cVar), ((e.c0.a0.t.t.b) this.f1219g).c);
    }
}
