package b.o;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public final b f2258a;

    /* renamed from: b  reason: collision with root package name */
    public final z f2259b;

    public static class a extends d {

        /* renamed from: c  reason: collision with root package name */
        public static a f2260c;

        /* renamed from: b  reason: collision with root package name */
        public Application f2261b;

        public a(Application application) {
            this.f2261b = application;
        }

        @Override // b.o.y.b, b.o.y.d
        public <T extends x> T a(Class<T> cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.f2261b);
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
        @Override // b.o.y.b
        public <T extends x> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends x> T c(String str, Class<T> cls);
    }

    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        public static d f2262a;

        @Override // b.o.y.b
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
            if (d.f2262a == null) {
                d.f2262a = new d();
            }
            bVar = d.f2262a;
        }
    }

    public y(z zVar, b bVar) {
        this.f2258a = bVar;
        this.f2259b = zVar;
    }

    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            String q = c.a.a.a.a.q("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            T t = (T) this.f2259b.f2263a.get(q);
            if (cls.isInstance(t)) {
                b bVar = this.f2258a;
                if (bVar instanceof e) {
                    ((e) bVar).b(t);
                }
            } else {
                b bVar2 = this.f2258a;
                t = (T) (bVar2 instanceof c ? ((c) bVar2).c(q, cls) : bVar2.a(cls));
                x put = this.f2259b.f2263a.put(q, t);
                if (put != null) {
                    put.onCleared();
                }
            }
            return t;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
