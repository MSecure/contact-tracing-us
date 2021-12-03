package f.a.b;

import android.os.Handler;
import f.a.b.p;
import java.util.Objects;
import java.util.concurrent.Executor;

public class f implements q {
    public final Executor a;

    public class a implements Executor {
        public final /* synthetic */ Handler b;

        public a(f fVar, Handler handler) {
            this.b = handler;
        }

        public void execute(Runnable runnable) {
            this.b.post(runnable);
        }
    }

    public static class b implements Runnable {
        public final n b;
        public final p c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f2033d;

        public b(n nVar, p pVar, Runnable runnable) {
            this.b = nVar;
            this.c = pVar;
            this.f2033d = runnable;
        }

        public void run() {
            p.a aVar;
            this.b.m();
            p pVar = this.c;
            u uVar = pVar.c;
            if (uVar == null) {
                this.b.b(pVar.a);
            } else {
                n nVar = this.b;
                synchronized (nVar.f2041f) {
                    aVar = nVar.f2042g;
                }
                if (aVar != null) {
                    aVar.a(uVar);
                }
            }
            Objects.requireNonNull(this.c);
            this.b.c("done");
            Runnable runnable = this.f2033d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.a = new a(this, handler);
    }

    public void a(n<?> nVar, p<?> pVar, Runnable runnable) {
        synchronized (nVar.f2041f) {
            nVar.f2046k = true;
        }
        nVar.a("post-response");
        this.a.execute(new b(nVar, pVar, null));
    }
}
