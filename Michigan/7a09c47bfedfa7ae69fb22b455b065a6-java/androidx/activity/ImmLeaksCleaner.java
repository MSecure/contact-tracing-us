package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.o.f;
import b.o.g;
import b.o.i;
import java.lang.reflect.Field;

public final class ImmLeaksCleaner implements g {

    /* renamed from: b  reason: collision with root package name */
    public static int f13b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f14c;

    /* renamed from: d  reason: collision with root package name */
    public static Field f15d;

    /* renamed from: e  reason: collision with root package name */
    public static Field f16e;

    /* renamed from: a  reason: collision with root package name */
    public Activity f17a;

    public ImmLeaksCleaner(Activity activity) {
        this.f17a = activity;
    }

    @Override // b.o.g
    public void d(i iVar, f.a aVar) {
        if (aVar == f.a.ON_DESTROY) {
            if (f13b == 0) {
                try {
                    f13b = 2;
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    f15d = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    f16e = declaredField2;
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    f14c = declaredField3;
                    declaredField3.setAccessible(true);
                    f13b = 1;
                } catch (NoSuchFieldException unused) {
                }
            }
            if (f13b == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f17a.getSystemService("input_method");
                try {
                    Object obj = f14c.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                View view = (View) f15d.get(inputMethodManager);
                                if (view != null) {
                                    if (!view.isAttachedToWindow()) {
                                        try {
                                            f16e.set(inputMethodManager, null);
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
