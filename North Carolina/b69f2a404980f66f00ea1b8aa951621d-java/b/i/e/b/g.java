package b.i.e.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class g {

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Typeface f1040b;

        public a(Typeface typeface) {
            this.f1040b = typeface;
        }

        public void run() {
            g.this.d(this.f1040b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f1042b;

        public b(int i) {
            this.f1042b = i;
        }

        public void run() {
            g.this.c(this.f1042b);
        }
    }

    public final void a(int i, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new b(i));
    }

    public final void b(Typeface typeface, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new a(typeface));
    }

    public abstract void c(int i);

    public abstract void d(Typeface typeface);
}
