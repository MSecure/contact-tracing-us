package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import b.b0.y.s.r.c;
import c.b.b.e.a.u;

public abstract class Worker extends ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    public c<ListenableWorker.a> f439a;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                Worker.this.f439a.k(Worker.this.a());
            } catch (Throwable th) {
                Worker.this.f439a.l(th);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.a a();

    @Override // androidx.work.ListenableWorker
    public final u<ListenableWorker.a> startWork() {
        this.f439a = new c<>();
        getBackgroundExecutor().execute(new a());
        return this.f439a;
    }
}
