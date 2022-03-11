package f.d.a.f;

import android.view.View;
import j.k.b.e;
/* loaded from: classes.dex */
public final class d implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        e.c(view, "v");
        view.removeOnAttachStateChangeListener(this);
        view.requestApplyInsets();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        e.c(view, "v");
    }
}
