package f.b.a.d.q;

import android.view.View;
import e.i.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public final class n implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        AtomicInteger atomicInteger = m.a;
        view.requestApplyInsets();
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
