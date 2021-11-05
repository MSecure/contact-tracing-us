package b.n;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public final b f1422a;

    /* renamed from: b  reason: collision with root package name */
    public final z f1423b;

    public static class a extends d {

        /* renamed from: c  reason: collision with root package name */
        public static a f1424c;

        /* renamed from: b  reason: collision with root package name */
        public Application f1425b;

        public a(Application application) {
            this.f1425b = application;
        }

        @Override // b.n.y.d, b.n.y.b
        public <T extends x> T a(Class<T> cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.f1425b);
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
        <T extends x> T a(Class<T> cls);
    }

    public static abstract class c extends e implements b {
        @Override // b.n.y.b
        public <T extends x> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends x> T c(String str, Class<T> cls);
    }

    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        public static d f1426a;

        @Override // b.n.y.b
        public <T extends x> T a(Class<T> cls) {
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
        public void b(x xVar) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public y(a0 a0Var) {
        this(r0, r3);
        b bVar;
        z viewModelStore = a0Var.getViewModelStore();
        if (a0Var instanceof e) {
            bVar = ((e) a0Var).getDefaultViewModelProviderFactory();
        } else {
            if (d.f1426a == null) {
                d.f1426a = new d();
            }
            bVar = d.f1426a;
        }
    }

    public y(z zVar, b bVar) {
        this.f1422a = bVar;
        this.f1423b = zVar;
    }

    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            String o = c.a.a.a.a.o("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            T t = (T) this.f1423b.f1427a.get(o);
            if (cls.isInstance(t)) {
                b bVar = this.f1422a;
                if (bVar instanceof e) {
                    ((e) bVar).b(t);
                }
            } else {
                b bVar2 = this.f1422a;
                t = (T) (bVar2 instanceof c ? ((c) bVar2).c(o, cls) : bVar2.a(cls));
                x put = this.f1423b.f1427a.put(o, t);
                if (put != null) {
                    put.onCleared();
                }
            }
            return t;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
