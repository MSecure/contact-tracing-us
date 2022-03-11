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
import e.m.a.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class j extends o implements k {
    public l o;

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
    private void m() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    @Override // androidx.activity.ComponentActivity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        r().c(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(r().d(context));
    }

    public void closeOptionsMenu() {
        a s = s();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (s == null || !s.a()) {
            super.closeOptionsMenu();
        }
    }

    @Override // e.i.a.f
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a s = s();
        if (keyCode != 82 || s == null || !s.j(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) r().e(i2);
    }

    @Override // e.b.a.k
    public void g(e.b.e.a aVar) {
    }

    public MenuInflater getMenuInflater() {
        return r().g();
    }

    public Resources getResources() {
        int i2 = d1.a;
        return super.getResources();
    }

    @Override // e.b.a.k
    public void i(e.b.e.a aVar) {
    }

    public void invalidateOptionsMenu() {
        r().j();
    }

    @Override // e.b.a.k
    public e.b.e.a j(a.AbstractC0014a aVar) {
        return null;
    }

    @Override // e.m.a.o
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        r().k(configuration);
    }

    public void onContentChanged() {
    }

    @Override // e.m.a.o
    public void onDestroy() {
        super.onDestroy();
        r().m();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // e.m.a.o
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        Intent k0;
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a s = s();
        if (menuItem.getItemId() != 16908332 || s == null || (s.d() & 4) == 0 || (k0 = m.h.k0(this)) == null) {
            return false;
        }
        if (shouldUpRecreateTask(k0)) {
            ArrayList arrayList = new ArrayList();
            Intent t = t();
            if (t == null) {
                t = m.h.k0(this);
            }
            if (t != null) {
                ComponentName component = t.getComponent();
                if (component == null) {
                    component = t.resolveActivity(getPackageManager());
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
                arrayList.add(t);
            }
            v();
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                Object obj = e.i.b.a.a;
                startActivities(intentArr, null);
                try {
                    int i3 = e.i.a.a.b;
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

    @Override // e.m.a.o
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        r().n(bundle);
    }

    @Override // e.m.a.o
    public void onPostResume() {
        super.onPostResume();
        r().o();
    }

    @Override // e.m.a.o
    public void onStart() {
        super.onStart();
        r().q();
    }

    @Override // e.m.a.o
    public void onStop() {
        super.onStop();
        r().r();
    }

    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        r().z(charSequence);
    }

    public void openOptionsMenu() {
        a s = s();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (s == null || !s.k()) {
            super.openOptionsMenu();
        }
    }

    @Override // e.m.a.o
    public void q() {
        r().j();
    }

    public l r() {
        if (this.o == null) {
            c<WeakReference<l>> cVar = l.b;
            this.o = new m(this, null, this, this);
        }
        return this.o;
    }

    public a s() {
        return r().h();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        m();
        r().u(i2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        m();
        r().v(view);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        r().w(view, layoutParams);
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i2) {
        super.setTheme(i2);
        r().y(i2);
    }

    public Intent t() {
        return m.h.k0(this);
    }

    public void u() {
    }

    public void v() {
    }
}
