package b.n;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import b.n.y;
import b.s.a;
import b.s.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class u extends y.c {
    public static final Class<?>[] f = {Application.class, t.class};
    public static final Class<?>[] g = {t.class};

    /* renamed from: a  reason: collision with root package name */
    public final Application f1409a;

    /* renamed from: b  reason: collision with root package name */
    public final y.a f1410b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f1411c;

    /* renamed from: d  reason: collision with root package name */
    public final f f1412d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1413e;

    @SuppressLint({"LambdaLast"})
    public u(Application application, c cVar, Bundle bundle) {
        this.f1413e = cVar.getSavedStateRegistry();
        this.f1412d = cVar.getLifecycle();
        this.f1411c = bundle;
        this.f1409a = application;
        if (y.a.f1424c == null) {
            y.a.f1424c = new y.a(application);
        }
        this.f1410b = y.a.f1424c;
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

    @Override // b.n.y.c, b.n.y.b
    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // b.n.y.e
    public void b(x xVar) {
        a aVar = this.f1413e;
        f fVar = this.f1412d;
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) xVar.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.f169b) {
            savedStateHandleController.h(aVar, fVar);
            SavedStateHandleController.i(aVar, fVar);
        }
    }

    @Override // b.n.y.c
    public <T extends x> T c(String str, Class<T> cls) {
        Object obj;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor d2 = isAssignableFrom ? d(cls, f) : d(cls, g);
        if (d2 == null) {
            return (T) this.f1410b.a(cls);
        }
        a aVar = this.f1413e;
        f fVar = this.f1412d;
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, t.a(aVar.a(str), this.f1411c));
        savedStateHandleController.h(aVar, fVar);
        SavedStateHandleController.i(aVar, fVar);
        if (isAssignableFrom) {
            try {
                obj = d2.newInstance(this.f1409a, savedStateHandleController.f170c);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        } else {
            obj = d2.newInstance(savedStateHandleController.f170c);
        }
        T t = (T) ((x) obj);
        t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return t;
    }
}
