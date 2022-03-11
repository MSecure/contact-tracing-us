package e.y;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {
    public final e.e.a<String, Method> a;
    public final e.e.a<String, Method> b;
    public final e.e.a<String, Class> c;

    public a(e.e.a<String, Method> aVar, e.e.a<String, Method> aVar2, e.e.a<String, Class> aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    public abstract void a();

    public abstract a b();

    public final Class c(Class<? extends c> cls) {
        Class orDefault = this.c.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.c.put(cls.getName(), cls2);
        return cls2;
    }

    public final Method d(String str) {
        Method orDefault = this.a.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) {
        Method orDefault = this.b.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class c2 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c2.getDeclaredMethod("write", cls, a.class);
        this.b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean f();

    public abstract byte[] g();

    public abstract CharSequence h();

    public abstract boolean i(int i2);

    public abstract int j();

    public int k(int i2, int i3) {
        return !i(i3) ? i2 : j();
    }

    public abstract <T extends Parcelable> T l();

    public <T extends Parcelable> T m(T t, int i2) {
        return !i(i2) ? t : (T) l();
    }

    public abstract String n();

    public <T extends c> T o() {
        String n = n();
        if (n == null) {
            return null;
        }
        a b2 = b();
        try {
            return (T) ((c) d(n).invoke(null, b2));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    public abstract void p(int i2);

    public abstract void q(boolean z);

    public abstract void r(byte[] bArr);

    public abstract void s(CharSequence charSequence);

    public abstract void t(int i2);

    public abstract void u(Parcelable parcelable);

    public abstract void v(String str);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: e.y.a */
    /* JADX WARN: Multi-variable type inference failed */
    public void w(c cVar) {
        if (cVar == null) {
            v(null);
            return;
        }
        try {
            v(c(cVar.getClass()).getName());
            a b2 = b();
            try {
                e(cVar.getClass()).invoke(null, cVar, b2);
                b2.a();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (InvocationTargetException e3) {
                if (e3.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e3.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
            }
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e6);
        }
    }
}
