package e.l.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;

public final class d extends b<d> {
    public e r = null;
    public float s = Float.MAX_VALUE;
    public boolean t = false;

    public <K> d(K k2, c<K> cVar) {
        super(k2, cVar);
    }

    public void d() {
        if (!(this.r.b > 0.0d)) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f1618f) {
            this.t = true;
        }
    }
}
