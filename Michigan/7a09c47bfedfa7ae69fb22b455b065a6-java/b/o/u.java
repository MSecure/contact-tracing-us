package b.o;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import b.o.y;
import b.t.b;
import b.t.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class u extends y.c {

    /* renamed from: f  reason: collision with root package name */
    public static final Class<?>[] f2243f = {Application.class, t.class};

    /* renamed from: g  reason: collision with root package name */
    public static final Class<?>[] f2244g = {t.class};

    /* renamed from: a  reason: collision with root package name */
    public final Application f2245a;

    /* renamed from: b  reason: collision with root package name */
    public final y.b f2246b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f2247c;

    /* renamed from: d  reason: collision with root package name */
    public final f f2248d;

    /* renamed from: e  reason: collision with root package name */
    public final b f2249e;

    @SuppressLint({"LambdaLast"})
    public u(Application application, d dVar, Bundle bundle) {
        y.b bVar;
        this.f2249e = dVar.getSavedStateRegistry();
        this.f2248d = dVar.getLifecycle();
        this.f2247c = bundle;
        this.f2245a = application;
        if (application != null) {
            if (y.a.f2260c == null) {
                y.a.f2260c = new y.a(application);
            }
            bVar = y.a.f2260c;
        } else {
            if (y.d.f2262a == null) {
                y.d.f2262a = new y.d();
            }
            bVar = y.d.f2262a;
        }
        this.f2246b = bVar;
    }

    public static <T> Constructor<T> d(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                return constructor2;
            }
        }
        return null;
    }

    @Override // b.o.y.b, b.o.y.c
    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // b.o.y.e
    public void b(x xVar) {
        b bVar = this.f2249e;
        f fVar = this.f2248d;
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) xVar.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.f249b) {
            savedStateHandleController.h(bVar, fVar);
            SavedStateHandleController.i(bVar, fVar);
        }
    }

    @Override // b.o.y.c
    public <T extends x> T c(String str, Class<T> cls) {
        Object obj;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor d2 = (!isAssignableFrom || this.f2245a == null) ? d(cls, f2244g) : d(cls, f2243f);
        if (d2 == null) {
            return (T) this.f2246b.a(cls);
        }
        b bVar = this.f2249e;
        f fVar = this.f2248d;
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, t.a(bVar.a(str), this.f2247c));
        savedStateHandleController.h(bVar, fVar);
        SavedStateHandleController.i(bVar, fVar);
        if (isAssignableFrom) {
            try {
                if (this.f2245a != null) {
                    obj = d2.newInstance(this.f2245a, savedStateHandleController.f250c);
                    T t = (T) ((x) obj);
                    t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                    return t;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        }
        obj = d2.newInstance(savedStateHandleController.f250c);
        T t2 = (T) ((x) obj);
        t2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return t2;
    }
}
