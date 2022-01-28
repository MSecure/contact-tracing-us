package b.i.i;

import android.os.Handler;
import b.i.i.c;
import java.util.concurrent.Callable;

public class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f1811b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Handler f1812c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c.AbstractC0032c f1813d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f1814b;

        public a(Object obj) {
            this.f1814b = obj;
        }

        public void run() {
            d.this.f1813d.a(this.f1814b);
        }
    }

    public d(c cVar, Callable callable, Handler handler, c.AbstractC0032c cVar2) {
        this.f1811b = callable;
        this.f1812c = handler;
        this.f1813d = cVar2;
    }

    public void run() {
        Object obj;
        try {
            obj = this.f1811b.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f1812c.post(new a(obj));
    }
}
