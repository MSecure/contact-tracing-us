package e.j.j;

import android.view.KeyEvent;
import android.view.View;
import e.j.j.v;
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnUnhandledKeyEventListener {
    public final /* synthetic */ v.o a;

    public /* synthetic */ b(v.o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnUnhandledKeyEventListener
    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.a.onUnhandledKeyEvent(view, keyEvent);
    }
}
