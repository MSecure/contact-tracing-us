package e.i.b.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class g {

    public class a implements Runnable {
        public final /* synthetic */ Typeface b;

        public a(Typeface typeface) {
            this.b = typeface;
        }

        public void run() {
            g.this.d(this.b);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int b;

        public b(int i2) {
            this.b = i2;
        }

        public void run() {
            g.this.c(this.b);
        }
    }

    public final void a(int i2, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new b(i2));
    }

    public final void b(Typeface typeface, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new a(typeface));
    }

    public abstract void c(int i2);

    public abstract void d(Typeface typeface);
}
