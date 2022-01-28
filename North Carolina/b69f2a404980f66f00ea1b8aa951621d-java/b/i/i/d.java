package b.i.i;

import android.os.Handler;
import b.i.i.c;
import java.util.concurrent.Callable;

public class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f1104b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Handler f1105c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c.AbstractC0022c f1106d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f1107b;

        public a(Object obj) {
            this.f1107b = obj;
        }

        public void run() {
            d.this.f1106d.a(this.f1107b);
        }
    }

    public d(c cVar, Callable callable, Handler handler, c.AbstractC0022c cVar2) {
        this.f1104b = callable;
        this.f1105c = handler;
        this.f1106d = cVar2;
    }

    public void run() {
        Object obj;
        try {
            obj = this.f1104b.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f1105c.post(new a(obj));
    }
}
