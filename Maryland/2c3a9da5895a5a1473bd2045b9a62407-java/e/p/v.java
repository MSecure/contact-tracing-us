package e.p;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import e.p.b0;
import e.u.a;
import e.u.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class v extends b0.c {

    /* renamed from: f  reason: collision with root package name */
    public static final Class<?>[] f1733f = {Application.class, u.class};

    /* renamed from: g  reason: collision with root package name */
    public static final Class<?>[] f1734g = {u.class};
    public final Application a;
    public final b0.b b;
    public final Bundle c;

    /* renamed from: d  reason: collision with root package name */
    public final g f1735d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1736e;

    public v(Application application, c cVar, Bundle bundle) {
        b0.b bVar;
        this.f1736e = cVar.d();
        this.f1735d = cVar.a();
        this.c = bundle;
        this.a = application;
        if (application != null) {
            if (b0.a.c == null) {
                b0.a.c = new b0.a(application);
            }
            bVar = b0.a.c;
        } else {
            if (b0.d.a == null) {
                b0.d.a = new b0.d();
            }
            bVar = b0.d.a;
        }
        this.b = bVar;
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

    @Override // e.p.b0.b, e.p.b0.c
    public <T extends a0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // e.p.b0.e
    public void b(a0 a0Var) {
        SavedStateHandleController.h(a0Var, this.f1736e, this.f1735d);
    }

    @Override // e.p.b0.c
    public <T extends a0> T c(String str, Class<T> cls) {
        Object obj;
        boolean isAssignableFrom = b.class.isAssignableFrom(cls);
        Constructor d2 = (!isAssignableFrom || this.a == null) ? d(cls, f1734g) : d(cls, f1733f);
        if (d2 == null) {
            return (T) this.b.a(cls);
        }
        SavedStateHandleController j2 = SavedStateHandleController.j(this.f1736e, this.f1735d, str, this.c);
        if (isAssignableFrom) {
            try {
                Application application = this.a;
                if (application != null) {
                    obj = d2.newInstance(application, j2.c);
                    T t = (T) ((a0) obj);
                    t.b("androidx.lifecycle.savedstate.vm.tag", j2);
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
        obj = d2.newInstance(j2.c);
        T t2 = (T) ((a0) obj);
        t2.b("androidx.lifecycle.savedstate.vm.tag", j2);
        return t2;
    }
}
