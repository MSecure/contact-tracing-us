package e.j.j;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.R$id;
import e.j.j.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class h {
    public static boolean a = false;
    public static Method b = null;
    public static boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public static Field f1637d;

    /* loaded from: classes.dex */
    public interface a {
        boolean g(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        int indexOfKey;
        AtomicInteger atomicInteger = v.a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList<WeakReference<View>> arrayList = v.p.f1647d;
            int i2 = R$id.tag_unhandled_key_event_manager;
            v.p pVar = (v.p) view.getTag(i2);
            if (pVar == null) {
                pVar = new v.p();
                view.setTag(i2, pVar);
            }
            WeakReference<KeyEvent> weakReference = pVar.c;
            if (weakReference == null || weakReference.get() != keyEvent) {
                pVar.c = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                if (pVar.b == null) {
                    pVar.b = new SparseArray<>();
                }
                SparseArray<WeakReference<View>> sparseArray = pVar.b;
                if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view2 = weakReference2.get();
                    if (view2 == null || !v.g.b(view2)) {
                        return true;
                    }
                    pVar.b(view2, keyEvent);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static boolean b(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        Window window;
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.g(keyEvent);
        }
        KeyEvent.DispatcherState dispatcherState = null;
        if (callback instanceof Activity) {
            Activity activity = (Activity) callback;
            activity.onUserInteraction();
            Window window2 = activity.getWindow();
            if (window2.hasFeature(8)) {
                Object actionBar = activity.getActionBar();
                if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                    if (!a) {
                        try {
                            b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                        } catch (NoSuchMethodException unused) {
                        }
                        a = true;
                    }
                    Method method = b;
                    if (method != null) {
                        try {
                            z = ((Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
            }
            if (window2.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window2.getDecorView();
            if (v.f(decorView, keyEvent)) {
                return true;
            }
            if (decorView != null) {
                dispatcherState = decorView.getKeyDispatcherState();
            }
            return keyEvent.dispatch(activity, dispatcherState, activity);
        } else if (callback instanceof Dialog) {
            Dialog dialog = (Dialog) callback;
            if (!c) {
                try {
                    Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                    f1637d = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused3) {
                }
                c = true;
            }
            Field field = f1637d;
            if (field != null) {
                try {
                    onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                } catch (IllegalAccessException unused4) {
                }
                if (onKeyListener == null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                window = dialog.getWindow();
                if (!window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window.getDecorView();
                if (v.f(decorView2, keyEvent)) {
                    return true;
                }
                if (decorView2 != null) {
                    dispatcherState = decorView2.getKeyDispatcherState();
                }
                return keyEvent.dispatch(dialog, dispatcherState, dialog);
            }
            onKeyListener = null;
            if (onKeyListener == null) {
            }
            window = dialog.getWindow();
            if (!window.superDispatchKeyEvent(keyEvent)) {
            }
        } else if ((view == null || !v.f(view, keyEvent)) && !aVar.g(keyEvent)) {
            return false;
        } else {
            return true;
        }
    }
}
