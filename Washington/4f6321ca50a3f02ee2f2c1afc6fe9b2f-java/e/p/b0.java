package e.p;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class b0 {
    public final b a;
    public final c0 b;

    public static class a extends d {
        public static a c;
        public Application b;

        public a(Application application) {
            this.b = application;
        }

        @Override // e.p.b0.b, e.p.b0.d
        public <T extends a0> T a(Class<T> cls) {
            if (!b.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.b);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }
    }

    public interface b {
        <T extends a0> T a(Class<T> cls);
    }

    public static abstract class c extends e implements b {
        @Override // e.p.b0.b
        public <T extends a0> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends a0> T c(String str, Class<T> cls);
    }

    public static class d implements b {
        public static d a;

        @Override // e.p.b0.b
        public <T extends a0> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    public static class e {
        public void b(a0 a0Var) {
        }
    }

    public b0(c0 c0Var, b bVar) {
        this.a = bVar;
        this.b = c0Var;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public b0(d0 d0Var) {
        this(r0, r3);
        b bVar;
        c0 h2 = d0Var.h();
        if (d0Var instanceof f) {
            bVar = ((f) d0Var).k();
        } else {
            if (d.a == null) {
                d.a = new d();
            }
            bVar = d.a;
        }
    }

    public <T extends a0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            String t = f.a.a.a.a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            T t2 = (T) this.b.a.get(t);
            if (cls.isInstance(t2)) {
                b bVar = this.a;
                if (bVar instanceof e) {
                    ((e) bVar).b(t2);
                }
            } else {
                b bVar2 = this.a;
                t2 = (T) (bVar2 instanceof c ? ((c) bVar2).c(t, cls) : bVar2.a(cls));
                a0 put = this.b.a.put(t, t2);
                if (put != null) {
                    put.a();
                }
            }
            return t2;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
