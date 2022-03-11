package f.b.a.d.w;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class o {

    /* renamed from: e  reason: collision with root package name */
    public static o f2921e;
    public final Object a = new Object();
    public final Handler b = new Handler(Looper.getMainLooper(), new a());
    public c c;

    /* renamed from: d  reason: collision with root package name */
    public c f2922d;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            o oVar = o.this;
            c cVar = (c) message.obj;
            synchronized (oVar.a) {
                if (oVar.c == cVar || oVar.f2922d == cVar) {
                    oVar.a(cVar, 2);
                }
            }
            return true;
        }
    }

    public interface b {
        void a();

        void b(int i2);
    }

    public static class c {
        public final WeakReference<b> a;
        public int b;
        public boolean c;

        public c(int i2, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.b = i2;
        }
    }

    public static o b() {
        if (f2921e == null) {
            f2921e = new o();
        }
        return f2921e;
    }

    public final boolean a(c cVar, int i2) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.b.removeCallbacksAndMessages(cVar);
        bVar.b(i2);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.c;
        if (cVar == null) {
            return false;
        }
        return bVar != null && cVar.a.get() == bVar;
    }

    public final boolean d(b bVar) {
        c cVar = this.f2922d;
        if (cVar == null) {
            return false;
        }
        return bVar != null && cVar.a.get() == bVar;
    }

    public void e(b bVar) {
        synchronized (this.a) {
            if (c(bVar)) {
                c cVar = this.c;
                if (!cVar.c) {
                    cVar.c = true;
                    this.b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.a) {
            if (c(bVar)) {
                c cVar = this.c;
                if (cVar.c) {
                    cVar.c = false;
                    g(cVar);
                }
            }
        }
    }

    public final void g(c cVar) {
        int i2 = cVar.b;
        if (i2 != -2) {
            if (i2 <= 0) {
                i2 = i2 == -1 ? 1500 : 2750;
            }
            this.b.removeCallbacksAndMessages(cVar);
            Handler handler = this.b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i2);
        }
    }

    public final void h() {
        c cVar = this.f2922d;
        if (cVar != null) {
            this.c = cVar;
            this.f2922d = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.c = null;
            }
        }
    }
}
