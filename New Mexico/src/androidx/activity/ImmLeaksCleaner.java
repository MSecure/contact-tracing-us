package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import e.r.h;
import e.r.j;
import e.r.l;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements j {
    public static int b;
    public static Field c;

    /* renamed from: d  reason: collision with root package name */
    public static Field f11d;

    /* renamed from: e  reason: collision with root package name */
    public static Field f12e;
    public Activity a;

    public ImmLeaksCleaner(Activity activity) {
        this.a = activity;
    }

    @Override // e.r.j
    public void d(l lVar, h.a aVar) {
        if (aVar == h.a.ON_DESTROY) {
            if (b == 0) {
                try {
                    b = 2;
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    f11d = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    f12e = declaredField2;
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    c = declaredField3;
                    declaredField3.setAccessible(true);
                    b = 1;
                } catch (NoSuchFieldException unused) {
                }
            }
            if (b == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
                try {
                    Object obj = c.get(inputMethodManager);
                    if (obj != null) {
                        try {
                            synchronized (obj) {
                                try {
                                    try {
                                        View view = (View) f11d.get(inputMethodManager);
                                        if (view != null) {
                                            if (!view.isAttachedToWindow()) {
                                                try {
                                                    f12e.set(inputMethodManager, null);
                                                    inputMethodManager.isActive();
                                                } catch (IllegalAccessException unused2) {
                                                }
                                            }
                                        }
                                    } catch (ClassCastException unused3) {
                                    }
                                } catch (IllegalAccessException unused4) {
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IllegalAccessException unused5) {
                }
            }
        }
    }
}
