package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.n.f;
import b.n.g;
import b.n.i;
import java.lang.reflect.Field;

public final class ImmLeaksCleaner implements g {

    /* renamed from: b  reason: collision with root package name */
    public static int f6b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f7c;

    /* renamed from: d  reason: collision with root package name */
    public static Field f8d;

    /* renamed from: e  reason: collision with root package name */
    public static Field f9e;

    /* renamed from: a  reason: collision with root package name */
    public Activity f10a;

    public ImmLeaksCleaner(Activity activity) {
        this.f10a = activity;
    }

    @Override // b.n.g
    public void d(i iVar, f.a aVar) {
        if (aVar == f.a.ON_DESTROY) {
            if (f6b == 0) {
                try {
                    f6b = 2;
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    f8d = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    f9e = declaredField2;
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    f7c = declaredField3;
                    declaredField3.setAccessible(true);
                    f6b = 1;
                } catch (NoSuchFieldException unused) {
                }
            }
            if (f6b == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f10a.getSystemService("input_method");
                try {
                    Object obj = f7c.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                View view = (View) f8d.get(inputMethodManager);
                                if (view != null) {
                                    if (!view.isAttachedToWindow()) {
                                        try {
                                            f9e.set(inputMethodManager, null);
                                            inputMethodManager.isActive();
                                        } catch (IllegalAccessException unused2) {
                                        }
                                    }
                                }
                            } catch (IllegalAccessException unused3) {
                            } catch (ClassCastException unused4) {
                            }
                        }
                    }
                } catch (IllegalAccessException unused5) {
                }
            }
        }
    }
}
