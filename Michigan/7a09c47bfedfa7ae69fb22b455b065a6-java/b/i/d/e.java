package b.i.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import b.e.h;
import b.i.l.d;
import b.i.l.m;
import b.o.f;
import b.o.i;
import b.o.j;
import b.o.s;

public class e extends Activity implements i, d.a {
    public h<Class<? extends a>, a> mExtraDataMap = new h<>();
    public j mLifecycleRegistry = new j(this);

    @Deprecated
    public static class a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !m.e(decorView, keyEvent)) {
            return d.a(this, decorView, this, keyEvent);
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

    @Override // b.o.i
    public abstract f getLifecycle();

    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s.c(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        j jVar = this.mLifecycleRegistry;
        f.b bVar = f.b.CREATED;
        jVar.d("markState");
        jVar.d("setCurrentState");
        jVar.g(bVar);
        super.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: b.e.h<java.lang.Class<? extends b.i.d.e$a>, b.i.d.e$a> */
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
