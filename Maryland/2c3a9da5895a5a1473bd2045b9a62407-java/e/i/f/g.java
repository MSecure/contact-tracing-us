package e.i.f;

import android.os.Handler;
import e.i.f.f;
import java.util.concurrent.Callable;

public class g implements Runnable {
    public final /* synthetic */ Callable b;
    public final /* synthetic */ Handler c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f.c f1467d;

    public class a implements Runnable {
        public final /* synthetic */ Object b;

        public a(Object obj) {
            this.b = obj;
        }

        public void run() {
            g.this.f1467d.a(this.b);
        }
    }

    public g(f fVar, Callable callable, Handler handler, f.c cVar) {
        this.b = callable;
        this.c = handler;
        this.f1467d = cVar;
    }

    public void run() {
        Object obj;
        try {
            obj = this.b.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.c.post(new a(obj));
    }
}
