package c.a.b;

import android.os.Handler;
import java.util.concurrent.Executor;

public class g implements r {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2206a;

    public class a implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f2207b;

        public a(g gVar, Handler handler) {
            this.f2207b = handler;
        }

        public void execute(Runnable runnable) {
            this.f2207b.post(runnable);
        }
    }

    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final o f2208b;

        /* renamed from: c  reason: collision with root package name */
        public final q f2209c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f2210d;

        public b(o oVar, q qVar, Runnable runnable) {
            this.f2208b = oVar;
            this.f2209c = qVar;
            this.f2210d = runnable;
        }

        public void run() {
            if (this.f2208b.isCanceled()) {
                this.f2208b.finish("canceled-at-delivery");
                return;
            }
            if (this.f2209c.f2236c == null) {
                this.f2208b.deliverResponse(this.f2209c.f2234a);
            } else {
                this.f2208b.deliverError(this.f2209c.f2236c);
            }
            if (this.f2209c.f2237d) {
                this.f2208b.addMarker("intermediate-response");
            } else {
                this.f2208b.finish("done");
            }
            Runnable runnable = this.f2210d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public g(Handler handler) {
        this.f2206a = new a(this, handler);
    }

    public void a(o<?> oVar, q<?> qVar) {
        oVar.markDelivered();
        oVar.addMarker("post-response");
        this.f2206a.execute(new b(oVar, qVar, null));
    }
}
