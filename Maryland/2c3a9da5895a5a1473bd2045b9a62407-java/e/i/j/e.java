package e.i.j;

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

public class e implements ActionMode.Callback {
    public final ActionMode.Callback a;
    public final TextView b;
    public Class<?> c;

    /* renamed from: d  reason: collision with root package name */
    public Method f1524d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1525e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1526f = false;

    public e(ActionMode.Callback callback, TextView textView) {
        this.a = callback;
        this.b = textView;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.a.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.a.onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.a.onDestroyActionMode(actionMode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[ExcHandler: IllegalAccessException | NoSuchMethodException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:16:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x009f A[SYNTHETIC] */
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        boolean z;
        String str;
        Context context = this.b.getContext();
        PackageManager packageManager = context.getPackageManager();
        if (!this.f1526f) {
            this.f1526f = true;
            try {
                Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.c = cls;
                this.f1524d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                this.f1525e = true;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                this.c = null;
                this.f1524d = null;
                this.f1525e = false;
            }
        }
        Method declaredMethod = (!this.f1525e || !this.c.isInstance(menu)) ? menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE) : this.f1524d;
        for (int size = menu.size() - 1; size >= 0; size--) {
            try {
                MenuItem item = menu.getItem(size);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                    declaredMethod.invoke(menu, Integer.valueOf(size));
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
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i2);
            MenuItem add = menu.add(0, 0, i2 + 100, resolveInfo2.loadLabel(packageManager));
            TextView textView = this.b;
            Intent putExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
            ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
            add.setIntent(putExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
        }
        return this.a.onPrepareActionMode(actionMode, menu);
    }
}
