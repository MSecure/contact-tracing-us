package f.d.a.f;

import android.view.View;
import j.j.b.e;

public final class d implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        e.c(view, "v");
        view.removeOnAttachStateChangeListener(this);
        view.requestApplyInsets();
    }

    public void onViewDetachedFromWindow(View view) {
        e.c(view, "v");
    }
}
