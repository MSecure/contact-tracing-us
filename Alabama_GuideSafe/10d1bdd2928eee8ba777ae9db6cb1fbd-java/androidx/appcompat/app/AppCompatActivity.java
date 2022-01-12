package androidx.appcompat.app;

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
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$style;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.LongSparseArray;
import androidx.core.app.ActivityCompat;
import androidx.core.app.TaskStackBuilder$SupportParentable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.uimanager.BaseViewManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder$SupportParentable {
    public AppCompatDelegate mDelegate;
    public Resources mResources;

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x019e  */
    public void attachBaseContext(Context context) {
        Configuration configuration;
        boolean z;
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mBaseContextAttached = true;
        int i = appCompatDelegateImpl.mLocalNightMode;
        if (i == -100) {
            i = -100;
        }
        int mapNightMode = appCompatDelegateImpl.mapNightMode(context, i);
        if (AppCompatDelegateImpl.sCanApplyOverrideConfiguration && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(appCompatDelegateImpl.createOverrideConfigurationForDayNight(context, mapNightMode, null));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(appCompatDelegateImpl.createOverrideConfigurationForDayNight(context, mapNightMode, null));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
            try {
                Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
                Configuration configuration3 = context.getResources().getConfiguration();
                if (!configuration2.equals(configuration3)) {
                    configuration = new Configuration();
                    configuration.fontScale = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    if (!(configuration3 == null || configuration2.diff(configuration3) == 0)) {
                        float f = configuration2.fontScale;
                        float f2 = configuration3.fontScale;
                        if (f != f2) {
                            configuration.fontScale = f2;
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
                Configuration createOverrideConfigurationForDayNight = appCompatDelegateImpl.createOverrideConfigurationForDayNight(context, mapNightMode, configuration);
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R$style.Theme_AppCompat_Empty);
                contextThemeWrapper.applyOverrideConfiguration(createOverrideConfigurationForDayNight);
                try {
                    if (context.getTheme() != null) {
                        z = true;
                        if (z) {
                            Resources.Theme theme = contextThemeWrapper.getTheme();
                            if (Build.VERSION.SDK_INT >= 29) {
                                theme.rebase();
                            } else {
                                synchronized (ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethodLock) {
                                    if (!ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethodFetched) {
                                        try {
                                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                            ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod = declaredMethod;
                                            declaredMethod.setAccessible(true);
                                        } catch (NoSuchMethodException e) {
                                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                                        }
                                        ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethodFetched = true;
                                    }
                                    if (ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod != null) {
                                        try {
                                            ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod.invoke(theme, new Object[0]);
                                        } catch (IllegalAccessException | InvocationTargetException e2) {
                                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                                            ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod = null;
                                        }
                                    }
                                }
                            }
                        }
                        context = contextThemeWrapper;
                    }
                } catch (NullPointerException unused3) {
                }
                z = false;
                if (z) {
                }
                context = contextThemeWrapper;
            } catch (PackageManager.NameNotFoundException e3) {
                throw new RuntimeException("Application failed to obtain resources from itself", e3);
            }
        }
        super.attachBaseContext(context);
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.onMenuKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        return (T) appCompatDelegateImpl.mWindow.findViewById(i);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create(this, this);
        }
        return this.mDelegate;
    }

    public MenuInflater getMenuInflater() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mMenuInflater == null) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            appCompatDelegateImpl.mMenuInflater = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : appCompatDelegateImpl.mContext);
        }
        return appCompatDelegateImpl.mMenuInflater;
    }

    public Resources getResources() {
        if (this.mResources == null) {
            VectorEnabledTintResources.shouldBeUsed();
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public ActionBar getSupportActionBar() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        return appCompatDelegateImpl.mActionBar;
    }

    @Override // androidx.core.app.TaskStackBuilder$SupportParentable
    public Intent getSupportParentActivityIntent() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHasActionBar && appCompatDelegateImpl.mSubDecorInstalled) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                actionBar.onConfigurationChanged(configuration);
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = appCompatDelegateImpl.mContext;
        synchronized (appCompatDrawableManager) {
            ResourceManagerInternal resourceManagerInternal = appCompatDrawableManager.mResourceManager;
            synchronized (resourceManagerInternal) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = resourceManagerInternal.mDrawableCaches.get(context);
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
        appCompatDelegateImpl.applyDayNight(false);
    }

    public void onContentChanged() {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppCompatDelegate delegate = getDelegate();
        delegate.installViewFactory();
        delegate.onCreate(bundle);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        Intent parentActivityIntent = AppCompatDelegateImpl.ConfigurationImplApi17.getParentActivityIntent(this);
        if (parentActivityIntent == null) {
            return false;
        }
        if (shouldUpRecreateTask(parentActivityIntent)) {
            ArrayList arrayList = new ArrayList();
            Intent supportParentActivityIntent = getSupportParentActivityIntent();
            if (supportParentActivityIntent == null) {
                supportParentActivityIntent = AppCompatDelegateImpl.ConfigurationImplApi17.getParentActivityIntent(this);
            }
            if (supportParentActivityIntent != null) {
                ComponentName component = supportParentActivityIntent.getComponent();
                if (component == null) {
                    component = supportParentActivityIntent.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent parentActivityIntent2 = AppCompatDelegateImpl.ConfigurationImplApi17.getParentActivityIntent(this, component);
                    while (parentActivityIntent2 != null) {
                        arrayList.add(size, parentActivityIntent2);
                        parentActivityIntent2 = AppCompatDelegateImpl.ConfigurationImplApi17.getParentActivityIntent(this, parentActivityIntent2.getComponent());
                    }
                    arrayList.add(supportParentActivityIntent);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e);
                }
            }
            onPrepareSupportNavigateUpTaskStack();
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                ContextCompat.startActivities(this, intentArr, null);
                try {
                    ActivityCompat.finishAffinity(this);
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            } else {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
        } else {
            navigateUpTo(parentActivityIntent);
            return true;
        }
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged() {
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegateImpl) getDelegate()).ensureSubDecor();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack() {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (((AppCompatDelegateImpl) getDelegate()) == null) {
            throw null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mStarted = true;
        appCompatDelegateImpl.applyDayNight();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mStarted = false;
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        getDelegate().setContentView(i);
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i) {
        super.setTheme(i);
        ((AppCompatDelegateImpl) getDelegate()).mThemeResId = i;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }
}
