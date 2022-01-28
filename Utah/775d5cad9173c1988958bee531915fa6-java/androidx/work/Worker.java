package androidx.work;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import e.b0.a0.t.s.c;
import f.b.b.f.a.u;

public abstract class Worker extends ListenableWorker {

    /* renamed from: g  reason: collision with root package name */
    public c<ListenableWorker.a> f302g;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                Worker.this.f302g.j(Worker.this.g());
            } catch (Throwable th) {
                Worker.this.f302g.k(th);
            }
        }
    }

    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final u<ListenableWorker.a> d() {
        this.f302g = new c<>();
        this.c.c.execute(new a());
        return this.f302g;
    }

    public abstract ListenableWorker.a g();
}
