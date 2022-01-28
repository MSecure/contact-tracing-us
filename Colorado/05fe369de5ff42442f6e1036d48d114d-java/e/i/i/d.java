package e.i.i;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;

public final class d {
    public final a a;

    public interface a {
    }

    public static class b implements a {
        public final GestureDetector a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this.a = new b(context, onGestureListener, null);
    }
}
