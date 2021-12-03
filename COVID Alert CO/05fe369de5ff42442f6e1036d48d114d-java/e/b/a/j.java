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
    private void o() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    @Override // androidx.activity.ComponentActivity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o();
        t().c(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(t().d(context));
    }

    public void closeOptionsMenu() {
        a u = u();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (u == null || !u.a()) {
            super.closeOptionsMenu();
        }
    }

    @Override // e.i.a.h
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a u = u();
        if (keyCode != 82 || u == null || !u.j(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) t().e(i2);
    }

    public MenuInflater getMenuInflater() {
        return t().g();
    }

    public Resources getResources() {
        int i2 = d1.a;
        return super.getResources();
    }

    @Override // e.b.a.k
    public void h(e.b.e.a aVar) {
    }

    public void invalidateOptionsMenu() {
        t().j();
    }

    @Override // e.b.a.k
    public void j(e.b.e.a aVar) {
    }

    @Override // e.b.a.k
    public e.b.e.a k(a.AbstractC0016a aVar) {
        return null;
    }

    @Override // e.m.a.r
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t().k(configuration);
    }

    public void onContentChanged() {
    }

    @Override // e.m.a.r
    public void onDestroy() {
        super.onDestroy();
        t().m();
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
        Intent o0;
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a u = u();
        if (menuItem.getItemId() != 16908332 || u == null || (u.d() & 4) == 0 || (o0 = m.h.o0(this)) == null) {
            return false;
        }
        if (shouldUpRecreateTask(o0)) {
            ArrayList arrayList = new ArrayList();
            Intent v = v();
            if (v == null) {
                v = m.h.o0(this);
            }
            if (v != null) {
                ComponentName component = v.getComponent();
                if (component == null) {
                    component = v.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                while (true) {
                    try {
                        Intent p0 = m.h.p0(this, component);
                        if (p0 == null) {
                            break;
                        }
                        arrayList.add(size, p0);
                        component = p0.getComponent();
                    } catch (PackageManager.NameNotFoundException e2) {
                        throw new IllegalArgumentException(e2);
                    }
                }
                arrayList.add(v);
            }
            x();
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
            navigateUpTo(o0);
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
        t().n(bundle);
    }

    @Override // e.m.a.r
    public void onPostResume() {
        super.onPostResume();
        t().o();
    }

    @Override // e.m.a.r
    public void onStart() {
        super.onStart();
        t().q();
    }

    @Override // e.m.a.r
    public void onStop() {
        super.onStop();
        t().r();
    }

    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        t().z(charSequence);
    }

    public void openOptionsMenu() {
        a u = u();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (u == null || !u.k()) {
            super.openOptionsMenu();
        }
    }

    @Override // e.m.a.r
    public void s() {
        t().j();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        o();
        t().u(i2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        o();
        t().v(view);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o();
        t().w(view, layoutParams);
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i2) {
        super.setTheme(i2);
        t().y(i2);
    }

    public l t() {
        if (this.p == null) {
            c<WeakReference<l>> cVar = l.b;
            this.p = new m(this, null, this, this);
        }
        return this.p;
    }

    public a u() {
        return t().h();
    }

    public Intent v() {
        return m.h.o0(this);
    }

    public void w() {
    }

    public void x() {
    }
}
