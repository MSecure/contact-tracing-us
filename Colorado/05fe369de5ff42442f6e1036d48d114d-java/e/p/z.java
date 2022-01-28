package e.p;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import e.p.f0;
import e.u.a;
import e.u.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class z extends f0.c {

    /* renamed from: f  reason: collision with root package name */
    public static final Class<?>[] f1550f = {Application.class, y.class};

    /* renamed from: g  reason: collision with root package name */
    public static final Class<?>[] f1551g = {y.class};
    public final Application a;
    public final f0.b b;
    public final Bundle c;

    /* renamed from: d  reason: collision with root package name */
    public final h f1552d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1553e;

    public z(Application application, c cVar, Bundle bundle) {
        f0.b bVar;
        this.f1553e = cVar.d();
        this.f1552d = cVar.a();
        this.c = bundle;
        this.a = application;
        if (application != null) {
            if (f0.a.c == null) {
                f0.a.c = new f0.a(application);
            }
            bVar = f0.a.c;
        } else {
            if (f0.d.a == null) {
                f0.d.a = new f0.d();
            }
            bVar = f0.d.a;
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

    @Override // e.p.f0.b, e.p.f0.c
    public <T extends e0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // e.p.f0.e
    public void b(e0 e0Var) {
        SavedStateHandleController.h(e0Var, this.f1553e, this.f1552d);
    }

    @Override // e.p.f0.c
    public <T extends e0> T c(String str, Class<T> cls) {
        Object obj;
        boolean isAssignableFrom = b.class.isAssignableFrom(cls);
        Constructor d2 = (!isAssignableFrom || this.a == null) ? d(cls, f1551g) : d(cls, f1550f);
        if (d2 == null) {
            return (T) this.b.a(cls);
        }
        SavedStateHandleController j2 = SavedStateHandleController.j(this.f1553e, this.f1552d, str, this.c);
        if (isAssignableFrom) {
            try {
                Application application = this.a;
                if (application != null) {
                    obj = d2.newInstance(application, j2.c);
                    T t = (T) ((e0) obj);
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
        T t2 = (T) ((e0) obj);
        t2.b("androidx.lifecycle.savedstate.vm.tag", j2);
        return t2;
    }
}
