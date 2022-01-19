package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TextViewCompat$OreoCallback implements ActionMode.Callback {
    public final ActionMode.Callback mCallback;
    public boolean mCanUseMenuBuilderReferences;
    public boolean mInitializedMenuBuilderReferences = false;
    public Class<?> mMenuBuilderClass;
    public Method mMenuBuilderRemoveItemAtMethod;
    public final TextView mTextView;

    public TextViewCompat$OreoCallback(ActionMode.Callback callback, TextView textView) {
        this.mCallback = callback;
        this.mTextView = textView;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.mCallback.onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.mCallback.onDestroyActionMode(actionMode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[ExcHandler: IllegalAccessException | NoSuchMethodException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:16:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x009f A[SYNTHETIC] */
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        Method method;
        boolean z;
        String str;
        Context context = this.mTextView.getContext();
        PackageManager packageManager = context.getPackageManager();
        if (!this.mInitializedMenuBuilderReferences) {
            this.mInitializedMenuBuilderReferences = true;
            try {
                Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.mMenuBuilderClass = cls;
                this.mMenuBuilderRemoveItemAtMethod = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                this.mCanUseMenuBuilderReferences = true;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                this.mMenuBuilderClass = null;
                this.mMenuBuilderRemoveItemAtMethod = null;
                this.mCanUseMenuBuilderReferences = false;
            }
        }
        if (!this.mCanUseMenuBuilderReferences || !this.mMenuBuilderClass.isInstance(menu)) {
            method = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
        } else {
            method = this.mMenuBuilderRemoveItemAtMethod;
        }
        for (int size = menu.size() - 1; size >= 0; size--) {
            try {
                MenuItem item = menu.getItem(size);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                    method.invoke(menu, Integer.valueOf(size));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }
        ArrayList arrayList = new ArrayList();
        if (context instanceof Activity) {
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0)) {
                if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (!activityInfo.exported || !((str = activityInfo.permission) == null || context.checkSelfPermission(str) == 0)) {
                        z = false;
                        if (!z) {
                            arrayList.add(resolveInfo);
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i);
            MenuItem add = menu.add(0, 0, i + 100, resolveInfo2.loadLabel(packageManager));
            TextView textView = this.mTextView;
            Intent putExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
            ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
            add.setIntent(putExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
        }
        return this.mCallback.onPrepareActionMode(actionMode, menu);
    }
}
