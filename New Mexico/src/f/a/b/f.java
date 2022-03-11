package f.a.b;

import android.os.Handler;
import f.a.b.p;
import java.util.Objects;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class f implements q {
    public final Executor a;

    /* loaded from: classes.dex */
    public class a implements Executor {
        public final /* synthetic */ Handler b;

        public a(f fVar, Handler handler) {
            this.b = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.b.post(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public final n b;
        public final p c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f2159d;

        public b(n nVar, p pVar, Runnable runnable) {
            this.b = nVar;
            this.c = pVar;
            this.f2159d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.a aVar;
            this.b.m();
            p pVar = this.c;
            u uVar = pVar.c;
            if (uVar == null) {
                this.b.b(pVar.a);
            } else {
                n nVar = this.b;
                synchronized (nVar.f2167f) {
                    aVar = nVar.f2168g;
                }
                if (aVar != null) {
                    aVar.a(uVar);
                }
            }
            Objects.requireNonNull(this.c);
            this.b.c("done");
            Runnable runnable = this.f2159d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.a = new a(this, handler);
    }

    public void a(n<?> nVar, p<?> pVar, Runnable runnable) {
        synchronized (nVar.f2167f) {
            nVar.f2172k = true;
        }
        nVar.a("post-response");
        this.a.execute(new b(nVar, pVar, null));
    }
}
