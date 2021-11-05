package b.i.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import b.e.h;
import b.i.l.d;
import b.i.l.m;
import b.n.f;
import b.n.i;
import b.n.j;
import b.n.s;

public class d extends Activity implements i, d.a {
    public h<Class<? extends a>, a> mExtraDataMap = new h<>();
    public j mLifecycleRegistry = new j(this);

    @Deprecated
    public static class a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !m.e(decorView, keyEvent)) {
            return b.i.l.d.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !m.e(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.getOrDefault(cls, null);
    }

    @Override // b.n.i
    public abstract f getLifecycle();

    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s.c(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.f(f.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: b.e.h<java.lang.Class<? extends b.i.d.d$a>, b.i.d.d$a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    @Override // b.i.l.d.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
