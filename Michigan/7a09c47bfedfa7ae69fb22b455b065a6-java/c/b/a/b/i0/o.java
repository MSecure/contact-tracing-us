package c.b.a.b.i0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class o {

    /* renamed from: e  reason: collision with root package name */
    public static o f4339e;

    /* renamed from: a  reason: collision with root package name */
    public final Object f4340a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f4341b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    public c f4342c;

    /* renamed from: d  reason: collision with root package name */
    public c f4343d;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            o oVar = o.this;
            c cVar = (c) message.obj;
            synchronized (oVar.f4340a) {
                if (oVar.f4342c == cVar || oVar.f4343d == cVar) {
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
        public final WeakReference<b> f4345a;

        /* renamed from: b  reason: collision with root package name */
        public int f4346b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4347c;

        public c(int i, b bVar) {
            this.f4345a = new WeakReference<>(bVar);
            this.f4346b = i;
        }
    }

    public static o b() {
        if (f4339e == null) {
            f4339e = new o();
        }
        return f4339e;
    }

    public final boolean a(c cVar, int i) {
        b bVar = cVar.f4345a.get();
        if (bVar == null) {
            return false;
        }
        this.f4341b.removeCallbacksAndMessages(cVar);
        bVar.b(i);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.f4342c;
        if (cVar != null) {
            if (bVar != null && cVar.f4345a.get() == bVar) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.f4343d;
        if (cVar != null) {
            if (bVar != null && cVar.f4345a.get() == bVar) {
                return true;
            }
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.f4340a) {
            if (c(bVar) && !this.f4342c.f4347c) {
                this.f4342c.f4347c = true;
                this.f4341b.removeCallbacksAndMessages(this.f4342c);
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f4340a) {
            if (c(bVar) && this.f4342c.f4347c) {
                this.f4342c.f4347c = false;
                g(this.f4342c);
            }
        }
    }

    public final void g(c cVar) {
        int i = cVar.f4346b;
        if (i != -2) {
            if (i <= 0) {
                i = i == -1 ? 1500 : 2750;
            }
            this.f4341b.removeCallbacksAndMessages(cVar);
            Handler handler = this.f4341b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i);
        }
    }

    public final void h() {
        c cVar = this.f4343d;
        if (cVar != null) {
            this.f4342c = cVar;
            this.f4343d = null;
            b bVar = cVar.f4345a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.f4342c = null;
            }
        }
    }
}
