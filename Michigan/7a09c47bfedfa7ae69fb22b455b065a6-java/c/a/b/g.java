package c.a.b;

import android.os.Handler;
import java.util.concurrent.Executor;

public class g implements r {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2815a;

    public class a implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f2816b;

        public a(g gVar, Handler handler) {
            this.f2816b = handler;
        }

        public void execute(Runnable runnable) {
            this.f2816b.post(runnable);
        }
    }

    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final o f2817b;

        /* renamed from: c  reason: collision with root package name */
        public final q f2818c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f2819d;

        public b(o oVar, q qVar, Runnable runnable) {
            this.f2817b = oVar;
            this.f2818c = qVar;
            this.f2819d = runnable;
        }

        public void run() {
            if (this.f2817b.isCanceled()) {
                this.f2817b.finish("canceled-at-delivery");
                return;
            }
            if (this.f2818c.f2849c == null) {
                this.f2817b.deliverResponse(this.f2818c.f2847a);
            } else {
                this.f2817b.deliverError(this.f2818c.f2849c);
            }
            if (this.f2818c.f2850d) {
                this.f2817b.addMarker("intermediate-response");
            } else {
                this.f2817b.finish("done");
            }
            Runnable runnable = this.f2819d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public g(Handler handler) {
        this.f2815a = new a(this, handler);
    }

    public void a(o<?> oVar, q<?> qVar) {
        oVar.markDelivered();
        oVar.addMarker("post-response");
        this.f2815a.execute(new b(oVar, qVar, null));
    }
}
