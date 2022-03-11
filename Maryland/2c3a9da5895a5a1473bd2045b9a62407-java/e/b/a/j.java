package e.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.runtime.R$id;
import e.a.d.a;
import e.b.a.m;
import e.b.e.a;
import e.b.f.d1;
import e.e.c;
import e.i.a.b;
import e.m.a.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class j extends r implements k {
    public l p;

    public j() {
        this.f2e.b.b("androidx:appcompat", new h(this));
        i iVar = new i(this);
        a aVar = this.c;
        if (aVar.b != null) {
            iVar.a(aVar.b);
        }
        aVar.a.add(iVar);
    }

    @Override // androidx.activity.ComponentActivity
    private void n() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    @Override // androidx.activity.ComponentActivity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        n();
        s().c(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(s().d(context));
    }

    public void closeOptionsMenu() {
        a t = t();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (t == null || !t.a()) {
            super.closeOptionsMenu();
        }
    }

    @Override // e.i.a.h
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a t = t();
        if (keyCode != 82 || t == null || !t.j(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) s().e(i2);
    }

    public MenuInflater getMenuInflater() {
        return s().g();
    }

    public Resources getResources() {
        int i2 = d1.a;
        return super.getResources();
    }

    @Override // e.b.a.k
    public void h(e.b.e.a aVar) {
    }

    public void invalidateOptionsMenu() {
        s().j();
    }

    @Override // e.b.a.k
    public void j(e.b.e.a aVar) {
    }

    @Override // e.b.a.k
    public e.b.e.a k(a.AbstractC0017a aVar) {
        return null;
    }

    @Override // e.m.a.r
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        s().k(configuration);
    }

    public void onContentChanged() {
    }

    @Override // e.m.a.r
    public void onDestroy() {
        super.onDestroy();
        s().m();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // e.m.a.r
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        Intent k0;
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a t = t();
        if (menuItem.getItemId() != 16908332 || t == null || (t.d() & 4) == 0 || (k0 = m.h.k0(this)) == null) {
            return false;
        }
        if (shouldUpRecreateTask(k0)) {
            ArrayList arrayList = new ArrayList();
            Intent u = u();
            if (u == null) {
                u = m.h.k0(this);
            }
            if (u != null) {
                ComponentName component = u.getComponent();
                if (component == null) {
                    component = u.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                while (true) {
                    try {
                        Intent l0 = m.h.l0(this, component);
                        if (l0 == null) {
                            break;
                        }
                        arrayList.add(size, l0);
                        component = l0.getComponent();
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                        throw new IllegalArgumentException(e2);
                    }
                }
                arrayList.add(u);
            }
            w();
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                Object obj = e.i.b.a.a;
                startActivities(intentArr, null);
                try {
                    int i3 = b.b;
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
            navigateUpTo(k0);
            return true;
        }
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // e.m.a.r
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        s().n(bundle);
    }

    @Override // e.m.a.r
    public void onPostResume() {
        super.onPostResume();
        s().o();
    }

    @Override // e.m.a.r
    public void onStart() {
        super.onStart();
        s().q();
    }

    @Override // e.m.a.r
    public void onStop() {
        super.onStop();
        s().r();
    }

    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        s().z(charSequence);
    }

    public void openOptionsMenu() {
        a t = t();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (t == null || !t.k()) {
            super.openOptionsMenu();
        }
    }

    @Override // e.m.a.r
    public void r() {
        s().j();
    }

    public l s() {
        if (this.p == null) {
            c<WeakReference<l>> cVar = l.b;
            this.p = new m(this, null, this, this);
        }
        return this.p;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        n();
        s().u(i2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        n();
        s().v(view);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        n();
        s().w(view, layoutParams);
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i2) {
        super.setTheme(i2);
        s().y(i2);
    }

    public a t() {
        return s().h();
    }

    public Intent u() {
        return m.h.k0(this);
    }

    public void v() {
    }

    public void w() {
    }
}
