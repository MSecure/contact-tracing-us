package f.b.a.e.w;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class p {

    /* renamed from: e  reason: collision with root package name */
    public static p f3082e;
    public final Object a = new Object();
    public final Handler b = new Handler(Looper.getMainLooper(), new a());
    public c c;

    /* renamed from: d  reason: collision with root package name */
    public c f3083d;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            p pVar = p.this;
            c cVar = (c) message.obj;
            synchronized (pVar.a) {
                if (pVar.c == cVar || pVar.f3083d == cVar) {
                    pVar.a(cVar, 2);
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

    public static p b() {
        if (f3082e == null) {
            f3082e = new p();
        }
        return f3082e;
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
        c cVar = this.f3083d;
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
        c cVar = this.f3083d;
        if (cVar != null) {
            this.c = cVar;
            this.f3083d = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.c = null;
            }
        }
    }
}
