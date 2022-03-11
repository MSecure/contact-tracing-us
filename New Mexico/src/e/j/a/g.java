package e.j.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import e.j.j.h;
import e.r.h;
import e.r.l;
import e.r.m;
import e.r.x;
/* loaded from: classes.dex */
public class g extends Activity implements l, h.a {
    public m b = new m(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !h.a(decorView, keyEvent)) {
            return h.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !h.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // e.j.j.h.a
    public boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.c(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        m mVar = this.b;
        h.b bVar = h.b.CREATED;
        mVar.d("markState");
        mVar.d("setCurrentState");
        mVar.g(bVar);
        super.onSaveInstanceState(bundle);
    }
}
