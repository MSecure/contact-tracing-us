package e.m.b;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import e.m.a.h;
import java.util.Objects;

public final class e implements KeyListener {
    public final KeyListener a;
    public final a b;

    public static class a {
    }

    public e(KeyListener keyListener) {
        a aVar = new a();
        this.a = keyListener;
        this.b = aVar;
    }

    public void clearMetaKeyState(View view, Editable editable, int i2) {
        this.a.clearMetaKeyState(view, editable, i2);
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        Objects.requireNonNull(this.b);
        Object obj = e.m.a.e.f1632j;
        if (i2 != 67) {
            z = i2 != 112 ? false : h.a(editable, keyEvent, true);
        } else {
            z = h.a(editable, keyEvent, false);
        }
        if (z) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || this.a.onKeyDown(view, editable, i2, keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.a.onKeyUp(view, editable, i2, keyEvent);
    }
}
