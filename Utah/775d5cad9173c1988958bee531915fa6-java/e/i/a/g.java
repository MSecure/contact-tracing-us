package e.i.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import e.i.i.h;
import e.q.h;
import e.q.l;
import e.q.m;
import e.q.x;

public class g extends Activity implements l, h.a {
    public m b = new m(this);

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !h.a(decorView, keyEvent)) {
            return h.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !h.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // e.i.i.h.a
    public boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.c(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        m mVar = this.b;
        h.b bVar = h.b.CREATED;
        mVar.d("markState");
        mVar.d("setCurrentState");
        mVar.g(bVar);
        super.onSaveInstanceState(bundle);
    }
}
