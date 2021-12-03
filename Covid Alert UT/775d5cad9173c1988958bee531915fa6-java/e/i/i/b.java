package e.i.i;

import android.view.KeyEvent;
import android.view.View;
import e.i.i.v;

public final /* synthetic */ class b implements View.OnUnhandledKeyEventListener {
    public final /* synthetic */ v.o a;

    public /* synthetic */ b(v.o oVar) {
        this.a = oVar;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.a.onUnhandledKeyEvent(view, keyEvent);
    }
}
