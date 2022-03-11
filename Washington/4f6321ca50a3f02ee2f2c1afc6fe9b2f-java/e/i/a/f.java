package e.i.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import e.i.i.d;
import e.p.g;
import e.p.j;
import e.p.k;
import e.p.t;

public class f extends Activity implements j, d.a {
    public k b = new k(this);

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !d.a(decorView, keyEvent)) {
            return d.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !d.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // e.i.i.d.a
    public boolean f(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t.c(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        k kVar = this.b;
        g.b bVar = g.b.CREATED;
        kVar.d("markState");
        kVar.d("setCurrentState");
        kVar.g(bVar);
        super.onSaveInstanceState(bundle);
    }
}
