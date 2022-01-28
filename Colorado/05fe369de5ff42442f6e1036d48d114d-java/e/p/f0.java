package e.p;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class f0 {
    public final b a;
    public final g0 b;

    public static class a extends d {
        public static a c;
        public Application b;

        public a(Application application) {
            this.b = application;
        }

        @Override // e.p.f0.b, e.p.f0.d
        public <T extends e0> T a(Class<T> cls) {
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
        <T extends e0> T a(Class<T> cls);
    }

    public static abstract class c extends e implements b {
        @Override // e.p.f0.b
        public <T extends e0> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends e0> T c(String str, Class<T> cls);
    }

    public static class d implements b {
        public static d a;

        @Override // e.p.f0.b
        public <T extends e0> T a(Class<T> cls) {
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
        public void b(e0 e0Var) {
        }
    }

    public f0(g0 g0Var, b bVar) {
        this.a = bVar;
        this.b = g0Var;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public f0(h0 h0Var) {
        this(r0, r3);
        b bVar;
        g0 i2 = h0Var.i();
        if (h0Var instanceof g) {
            bVar = ((g) h0Var).l();
        } else {
            if (d.a == null) {
                d.a = new d();
            }
            bVar = d.a;
        }
    }

    public <T extends e0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            String c2 = f.a.a.a.a.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            T t = (T) this.b.a.get(c2);
            if (cls.isInstance(t)) {
                b bVar = this.a;
                if (bVar instanceof e) {
                    ((e) bVar).b(t);
                }
            } else {
                b bVar2 = this.a;
                t = (T) (bVar2 instanceof c ? ((c) bVar2).c(c2, cls) : bVar2.a(cls));
                e0 put = this.b.a.put(c2, t);
                if (put != null) {
                    put.a();
                }
            }
            return t;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
