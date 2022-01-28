package b.b.k;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import b.b.i;
import b.b.k.i;
import b.b.p.a;
import b.b.p.c;
import b.b.q.d1;
import b.b.q.j;
import b.b.q.n0;
import b.e.e;
import b.i.d.p;
import b.i.e.b.h;
import b.l.d.m;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

public class f extends m implements g, p.a {
    public h mDelegate;
    public Resources mResources;

    public f() {
    }

    public f(int i) {
        super(i);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // androidx.activity.ComponentActivity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().c(view, layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x019e  */
    public void attachBaseContext(Context context) {
        Configuration configuration;
        boolean z;
        i iVar = (i) getDelegate();
        iVar.J = true;
        int i = iVar.N;
        if (i == -100) {
            i = -100;
        }
        int I = iVar.I(context, i);
        if (i.e0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(iVar.w(context, I, null));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof c) {
            try {
                ((c) context).a(iVar.w(context, I, null));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (i.d0) {
            try {
                Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
                Configuration configuration3 = context.getResources().getConfiguration();
                if (!configuration2.equals(configuration3)) {
                    configuration = new Configuration();
                    configuration.fontScale = 0.0f;
                    if (!(configuration3 == null || configuration2.diff(configuration3) == 0)) {
                        float f2 = configuration2.fontScale;
                        float f3 = configuration3.fontScale;
                        if (f2 != f3) {
                            configuration.fontScale = f3;
                        }
                        int i2 = configuration2.mcc;
                        int i3 = configuration3.mcc;
                        if (i2 != i3) {
                            configuration.mcc = i3;
                        }
                        int i4 = configuration2.mnc;
                        int i5 = configuration3.mnc;
                        if (i4 != i5) {
                            configuration.mnc = i5;
                        }
                        if (Build.VERSION.SDK_INT >= 24) {
                            LocaleList locales = configuration2.getLocales();
                            LocaleList locales2 = configuration3.getLocales();
                            if (!locales.equals(locales2)) {
                                configuration.setLocales(locales2);
                                configuration.locale = configuration3.locale;
                            }
                        } else if (!Objects.equals(configuration2.locale, configuration3.locale)) {
                            configuration.locale = configuration3.locale;
                        }
                        int i6 = configuration2.touchscreen;
                        int i7 = configuration3.touchscreen;
                        if (i6 != i7) {
                            configuration.touchscreen = i7;
                        }
                        int i8 = configuration2.keyboard;
                        int i9 = configuration3.keyboard;
                        if (i8 != i9) {
                            configuration.keyboard = i9;
                        }
                        int i10 = configuration2.keyboardHidden;
                        int i11 = configuration3.keyboardHidden;
                        if (i10 != i11) {
                            configuration.keyboardHidden = i11;
                        }
                        int i12 = configuration2.navigation;
                        int i13 = configuration3.navigation;
                        if (i12 != i13) {
                            configuration.navigation = i13;
                        }
                        int i14 = configuration2.navigationHidden;
                        int i15 = configuration3.navigationHidden;
                        if (i14 != i15) {
                            configuration.navigationHidden = i15;
                        }
                        int i16 = configuration2.orientation;
                        int i17 = configuration3.orientation;
                        if (i16 != i17) {
                            configuration.orientation = i17;
                        }
                        int i18 = configuration2.screenLayout & 15;
                        int i19 = configuration3.screenLayout & 15;
                        if (i18 != i19) {
                            configuration.screenLayout |= i19;
                        }
                        int i20 = configuration2.screenLayout & 192;
                        int i21 = configuration3.screenLayout & 192;
                        if (i20 != i21) {
                            configuration.screenLayout |= i21;
                        }
                        int i22 = configuration2.screenLayout & 48;
                        int i23 = configuration3.screenLayout & 48;
                        if (i22 != i23) {
                            configuration.screenLayout |= i23;
                        }
                        int i24 = configuration2.screenLayout & 768;
                        int i25 = configuration3.screenLayout & 768;
                        if (i24 != i25) {
                            configuration.screenLayout |= i25;
                        }
                        if (Build.VERSION.SDK_INT >= 26) {
                            int i26 = configuration2.colorMode & 3;
                            int i27 = configuration3.colorMode & 3;
                            if (i26 != i27) {
                                configuration.colorMode |= i27;
                            }
                            int i28 = configuration2.colorMode & 12;
                            int i29 = configuration3.colorMode & 12;
                            if (i28 != i29) {
                                configuration.colorMode |= i29;
                            }
                        }
                        int i30 = configuration2.uiMode & 15;
                        int i31 = configuration3.uiMode & 15;
                        if (i30 != i31) {
                            configuration.uiMode |= i31;
                        }
                        int i32 = configuration2.uiMode & 48;
                        int i33 = configuration3.uiMode & 48;
                        if (i32 != i33) {
                            configuration.uiMode |= i33;
                        }
                        int i34 = configuration2.screenWidthDp;
                        int i35 = configuration3.screenWidthDp;
                        if (i34 != i35) {
                            configuration.screenWidthDp = i35;
                        }
                        int i36 = configuration2.screenHeightDp;
                        int i37 = configuration3.screenHeightDp;
                        if (i36 != i37) {
                            configuration.screenHeightDp = i37;
                        }
                        int i38 = configuration2.smallestScreenWidthDp;
                        int i39 = configuration3.smallestScreenWidthDp;
                        if (i38 != i39) {
                            configuration.smallestScreenWidthDp = i39;
                        }
                        int i40 = configuration2.densityDpi;
                        int i41 = configuration3.densityDpi;
                        if (i40 != i41) {
                            configuration.densityDpi = i41;
                        }
                    }
                } else {
                    configuration = null;
                }
                Configuration w = iVar.w(context, I, configuration);
                c cVar = new c(context, i.Theme_AppCompat_Empty);
                cVar.a(w);
                try {
                    if (context.getTheme() != null) {
                        z = true;
                        if (z) {
                            Resources.Theme theme = cVar.getTheme();
                            if (Build.VERSION.SDK_INT >= 29) {
                                theme.rebase();
                            } else {
                                synchronized (h.f1741a) {
                                    if (!h.f1743c) {
                                        try {
                                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                            h.f1742b = declaredMethod;
                                            declaredMethod.setAccessible(true);
                                        } catch (NoSuchMethodException unused3) {
                                        }
                                        h.f1743c = true;
                                    }
                                    if (h.f1742b != null) {
                                        try {
                                            h.f1742b.invoke(theme, new Object[0]);
                                        } catch (IllegalAccessException | InvocationTargetException unused4) {
                                            h.f1742b = null;
                                        }
                                    }
                                }
                            }
                        }
                        context = cVar;
                    }
                } catch (NullPointerException unused5) {
                }
                z = false;
                if (z) {
                }
                context = cVar;
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("Application failed to obtain resources from itself", e2);
            }
        }
        super.attachBaseContext(context);
    }

    public void closeOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.a()) {
            super.closeOptionsMenu();
        }
    }

    @Override // b.i.d.e
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.j(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        i iVar = (i) getDelegate();
        iVar.A();
        return (T) iVar.f521f.findViewById(i);
    }

    public h getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = h.d(this, this);
        }
        return this.mDelegate;
    }

    public b getDrawerToggleDelegate() {
        i iVar = (i) getDelegate();
        if (iVar != null) {
            return new i.c(iVar);
        }
        throw null;
    }

    public MenuInflater getMenuInflater() {
        i iVar = (i) getDelegate();
        if (iVar.j == null) {
            iVar.G();
            a aVar = iVar.i;
            iVar.j = new b.b.p.f(aVar != null ? aVar.e() : iVar.f520e);
        }
        return iVar.j;
    }

    public Resources getResources() {
        if (this.mResources == null) {
            d1.a();
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public a getSupportActionBar() {
        i iVar = (i) getDelegate();
        iVar.G();
        return iVar.i;
    }

    @Override // b.i.d.p.a
    public Intent getSupportParentActivityIntent() {
        return i.j.F(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().g();
    }

    @Override // b.l.d.m
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        i iVar = (i) getDelegate();
        if (iVar.A && iVar.u) {
            iVar.G();
            a aVar = iVar.i;
            if (aVar != null) {
                aVar.g(configuration);
            }
        }
        j a2 = j.a();
        Context context = iVar.f520e;
        synchronized (a2) {
            n0 n0Var = a2.f869a;
            synchronized (n0Var) {
                e<WeakReference<Drawable.ConstantState>> eVar = n0Var.f897d.get(context);
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
        iVar.r(false);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.activity.ComponentActivity, b.i.d.e, b.l.d.m
    public void onCreate(Bundle bundle) {
        h delegate = getDelegate();
        delegate.f();
        delegate.h(bundle);
        super.onCreate(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(p pVar) {
        if (pVar != null) {
            Intent supportParentActivityIntent = getSupportParentActivityIntent();
            if (supportParentActivityIntent == null) {
                supportParentActivityIntent = i.j.F(this);
            }
            if (supportParentActivityIntent != null) {
                ComponentName component = supportParentActivityIntent.getComponent();
                if (component == null) {
                    component = supportParentActivityIntent.resolveActivity(pVar.f1720c.getPackageManager());
                }
                int size = pVar.f1719b.size();
                try {
                    Context context = pVar.f1720c;
                    while (true) {
                        Intent G = i.j.G(context, component);
                        if (G != null) {
                            pVar.f1719b.add(size, G);
                            context = pVar.f1720c;
                            component = G.getComponent();
                        } else {
                            pVar.f1719b.add(supportParentActivityIntent);
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
        } else {
            throw null;
        }
    }

    @Override // b.l.d.m
    public void onDestroy() {
        super.onDestroy();
        getDelegate().i();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // b.l.d.m
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // b.l.d.m
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((i) getDelegate()).A();
    }

    @Override // b.l.d.m
    public void onPostResume() {
        super.onPostResume();
        i iVar = (i) getDelegate();
        iVar.G();
        a aVar = iVar.i;
        if (aVar != null) {
            aVar.m(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(p pVar) {
    }

    @Override // androidx.activity.ComponentActivity, b.i.d.e
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (((i) getDelegate()) == null) {
            throw null;
        }
    }

    @Override // b.l.d.m
    public void onStart() {
        super.onStart();
        i iVar = (i) getDelegate();
        iVar.L = true;
        iVar.q();
    }

    @Override // b.l.d.m
    public void onStop() {
        super.onStop();
        i iVar = (i) getDelegate();
        iVar.L = false;
        iVar.G();
        a aVar = iVar.i;
        if (aVar != null) {
            aVar.m(false);
        }
    }

    @Override // b.b.k.g
    public void onSupportActionModeFinished(a aVar) {
    }

    @Override // b.b.k.g
    public void onSupportActionModeStarted(a aVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            p pVar = new p(this);
            onCreateSupportNavigateUpTaskStack(pVar);
            onPrepareSupportNavigateUpTaskStack(pVar);
            if (!pVar.f1719b.isEmpty()) {
                ArrayList<Intent> arrayList = pVar.f1719b;
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                b.i.e.a.d(pVar.f1720c, intentArr, null);
                try {
                    b.i.d.a.g(this);
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            } else {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().o(charSequence);
    }

    @Override // b.b.k.g
    public a onWindowStartingSupportActionMode(a.AbstractC0012a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.k()) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        getDelegate().l(i);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        getDelegate().m(view);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().n(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        i iVar = (i) getDelegate();
        if (iVar.f519d instanceof Activity) {
            iVar.G();
            a aVar = iVar.i;
            if (!(aVar instanceof u)) {
                iVar.j = null;
                if (aVar != null) {
                    aVar.h();
                }
                if (toolbar != null) {
                    Object obj = iVar.f519d;
                    r rVar = new r(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : iVar.k, iVar.f522g);
                    iVar.i = rVar;
                    window = iVar.f521f;
                    callback = rVar.f572c;
                } else {
                    iVar.i = null;
                    window = iVar.f521f;
                    callback = iVar.f522g;
                }
                window.setCallback(callback);
                iVar.g();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i) {
        super.setTheme(i);
        ((i) getDelegate()).O = i;
    }

    public a startSupportActionMode(a.AbstractC0012a aVar) {
        return getDelegate().p(aVar);
    }

    @Override // b.l.d.m
    public void supportInvalidateOptionsMenu() {
        getDelegate().g();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().k(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }
}
