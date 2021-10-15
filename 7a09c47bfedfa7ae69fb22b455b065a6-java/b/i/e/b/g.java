package b.i.e.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class g {

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Typeface f1737b;

        public a(Typeface typeface) {
            this.f1737b = typeface;
        }

        public void run() {
            g.this.d(this.f1737b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f1739b;

        public b(int i) {
            this.f1739b = i;
        }

        public void run() {
            g.this.c(this.f1739b);
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
