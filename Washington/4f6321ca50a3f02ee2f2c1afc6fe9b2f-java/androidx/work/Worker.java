package androidx.work;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import e.b0.x.t.p.c;
import f.b.b.f.a.u;

public abstract class Worker extends ListenableWorker {

    /* renamed from: e  reason: collision with root package name */
    public c<ListenableWorker.a> f303e;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                Worker.this.f303e.j(Worker.this.g());
            } catch (Throwable th) {
                Worker.this.f303e.k(th);
            }
        }
    }

    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final u<ListenableWorker.a> d() {
        this.f303e = new c<>();
        this.c.c.execute(new a());
        return this.f303e;
    }

    public abstract ListenableWorker.a g();
}
