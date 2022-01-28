package e.i.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import e.i.i.e;
import e.p.h;
import e.p.l;
import e.p.m;
import e.p.x;

public class h extends Activity implements l, e.a {
    public m b = new m(this);

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return e.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // e.i.i.e.a
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
