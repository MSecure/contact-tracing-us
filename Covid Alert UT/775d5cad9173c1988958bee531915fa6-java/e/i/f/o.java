package e.i.f;

import android.os.Handler;
import java.util.concurrent.Callable;

public class o<T> implements Runnable {
    public Callable<T> b;
    public e.i.h.a<T> c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f1513d;

    public class a implements Runnable {
        public final /* synthetic */ e.i.h.a b;
        public final /* synthetic */ Object c;

        public a(o oVar, e.i.h.a aVar, Object obj) {
            this.b = aVar;
            this.c = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: e.i.h.a */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            this.b.a(this.c);
        }
    }

    public o(Handler handler, Callable<T> callable, e.i.h.a<T> aVar) {
        this.b = callable;
        this.c = aVar;
        this.f1513d = handler;
    }

    public void run() {
        T t;
        try {
            t = this.b.call();
        } catch (Exception unused) {
            t = null;
        }
        this.f1513d.post(new a(this, this.c, t));
    }
}
