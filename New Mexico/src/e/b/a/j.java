package e.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.runtime.R$id;
import e.b.a.m;
import e.b.e.a;
import e.b.f.h1;
import e.j.a.c;
import e.j.b.a;
import e.o.a.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends r implements k {
    public l p;

    public j() {
        this.f2e.b.b("androidx:appcompat", new h(this));
        n(new i(this));
    }

    private void p() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        u().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(u().d(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a v = v();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (v == null || !v.a()) {
            super.closeOptionsMenu();
        }
    }

    @Override // e.j.a.g, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a v = v();
        if (keyCode != 82 || v == null || !v.j(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) u().e(i2);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return u().g();
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public Resources getResources() {
        int i2 = h1.a;
        return super.getResources();
    }

    @Override // e.b.a.k
    public void h(a aVar) {
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        u().j();
    }

    @Override // e.b.a.k
    public void j(a aVar) {
    }

    @Override // e.b.a.k
    public a k(a.AbstractC0017a aVar) {
        return null;
    }

    @Override // e.o.a.r, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        u().k(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // e.o.a.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        u().m();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // e.o.a.r, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        Intent y0;
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a v = v();
        if (menuItem.getItemId() != 16908332 || v == null || (v.d() & 4) == 0 || (y0 = m.e.y0(this)) == null) {
            return false;
        }
        if (shouldUpRecreateTask(y0)) {
            ArrayList arrayList = new ArrayList();
            Intent w = w();
            if (w == null) {
                w = m.e.y0(this);
            }
            if (w != null) {
                ComponentName component = w.getComponent();
                if (component == null) {
                    component = w.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                while (true) {
                    try {
                        Intent z0 = m.e.z0(this, component);
                        if (z0 == null) {
                            break;
                        }
                        arrayList.add(size, z0);
                        component = z0.getComponent();
                    } catch (PackageManager.NameNotFoundException e2) {
                        throw new IllegalArgumentException(e2);
                    }
                }
                arrayList.add(w);
            }
            y();
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                Object obj = e.j.b.a.a;
                a.C0036a.a(this, intentArr, null);
                try {
                    int i3 = c.b;
                    finishAffinity();
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            } else {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
        } else {
            navigateUpTo(y0);
            return true;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // e.o.a.r, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        u().n(bundle);
    }

    @Override // e.o.a.r, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        u().o();
    }

    @Override // e.o.a.r, android.app.Activity
    public void onStart() {
        super.onStart();
        u().q();
    }

    @Override // e.o.a.r, android.app.Activity
    public void onStop() {
        super.onStop();
        u().r();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        u().z(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a v = v();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (v == null || !v.k()) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        p();
        u().u(i2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        p();
        u().v(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        u().w(view, layoutParams);
    }

    @Override // android.app.Activity, android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void setTheme(int i2) {
        super.setTheme(i2);
        u().y(i2);
    }

    @Override // e.o.a.r
    public void t() {
        u().j();
    }

    public l u() {
        if (this.p == null) {
            e.f.c<WeakReference<l>> cVar = l.b;
            this.p = new m(this, null, this, this);
        }
        return this.p;
    }

    public a v() {
        return u().h();
    }

    public Intent w() {
        return m.e.y0(this);
    }

    public void x() {
    }

    public void y() {
    }
}
