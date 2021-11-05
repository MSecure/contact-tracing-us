package c.b.a.b.i0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class o {

    /* renamed from: e  reason: collision with root package name */
    public static o f3046e;

    /* renamed from: a  reason: collision with root package name */
    public final Object f3047a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f3048b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    public c f3049c;

    /* renamed from: d  reason: collision with root package name */
    public c f3050d;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            o oVar = o.this;
            c cVar = (c) message.obj;
            synchronized (oVar.f3047a) {
                if (oVar.f3049c == cVar || oVar.f3050d == cVar) {
                    oVar.a(cVar, 2);
                }
            }
            return true;
        }
    }

    public interface b {
        void a();

        void b(int i);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f3052a;

        /* renamed from: b  reason: collision with root package name */
        public int f3053b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3054c;

        public c(int i, b bVar) {
            this.f3052a = new WeakReference<>(bVar);
            this.f3053b = i;
        }
    }

    public static o b() {
        if (f3046e == null) {
            f3046e = new o();
        }
        return f3046e;
    }

    public final boolean a(c cVar, int i) {
        b bVar = cVar.f3052a.get();
        if (bVar == null) {
            return false;
        }
        this.f3048b.removeCallbacksAndMessages(cVar);
        bVar.b(i);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.f3049c;
        if (cVar != null) {
            if (bVar != null && cVar.f3052a.get() == bVar) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.f3050d;
        if (cVar != null) {
            if (bVar != null && cVar.f3052a.get() == bVar) {
                return true;
            }
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.f3047a) {
            if (c(bVar) && !this.f3049c.f3054c) {
                this.f3049c.f3054c = true;
                this.f3048b.removeCallbacksAndMessages(this.f3049c);
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f3047a) {
            if (c(bVar) && this.f3049c.f3054c) {
                this.f3049c.f3054c = false;
                g(this.f3049c);
            }
        }
    }

    public final void g(c cVar) {
        int i = cVar.f3053b;
        if (i != -2) {
            if (i <= 0) {
                i = i == -1 ? 1500 : 2750;
            }
            this.f3048b.removeCallbacksAndMessages(cVar);
            Handler handler = this.f3048b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i);
        }
    }

    public final void h() {
        c cVar = this.f3050d;
        if (cVar != null) {
            this.f3049c = cVar;
            this.f3050d = null;
            b bVar = cVar.f3052a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.f3049c = null;
            }
        }
    }
}
