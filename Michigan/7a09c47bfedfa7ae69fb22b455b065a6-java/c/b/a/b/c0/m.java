package c.b.a.b.c0;

import android.view.View;

public final class m implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        b.i.l.m.S(view);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
