package b.x;

import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final b.e.a<String, Method> f1879a;

    /* renamed from: b  reason: collision with root package name */
    public final b.e.a<String, Method> f1880b;

    /* renamed from: c  reason: collision with root package name */
    public final b.e.a<String, Class> f1881c;

    public a(b.e.a<String, Method> aVar, b.e.a<String, Method> aVar2, b.e.a<String, Class> aVar3) {
        this.f1879a = aVar;
        this.f1880b = aVar2;
        this.f1881c = aVar3;
    }

    public abstract void a();

    public abstract a b();

    public final Class c(Class<? extends c> cls) {
        Class orDefault = this.f1881c.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f1881c.put(cls.getName(), cls2);
        return cls2;
    }

    public final Method d(String str) {
        Method orDefault = this.f1879a.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f1879a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) {
        Method orDefault = this.f1880b.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class c2 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c2.getDeclaredMethod("write", cls, a.class);
        this.f1880b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f(boolean z, int i) {
        if (!h(i)) {
            return z;
        }
        return ((b) this).f1883e.readInt() != 0;
    }

    public CharSequence g(CharSequence charSequence, int i) {
        return !h(i) ? charSequence : (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) this).f1883e);
    }

    public abstract boolean h(int i);

    public int i(int i, int i2) {
        return !h(i2) ? i : ((b) this).f1883e.readInt();
    }

    public <T extends Parcelable> T j(T t, int i) {
        return !h(i) ? t : (T) ((b) this).f1883e.readParcelable(b.class.getClassLoader());
    }

    public <T extends c> T k() {
        String readString = ((b) this).f1883e.readString();
        if (readString == null) {
            return null;
        }
        a b2 = b();
        try {
            return (T) ((c) d(readString).invoke(null, b2));
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

    public abstract void l(int i);

    public void m(int i, int i2) {
        l(i2);
        ((b) this).f1883e.writeInt(i);
    }

    public void n(Parcelable parcelable, int i) {
        l(i);
        ((b) this).f1883e.writeParcelable(parcelable, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: b.x.a */
    /* JADX WARN: Multi-variable type inference failed */
    public void o(c cVar) {
        if (cVar == null) {
            ((b) this).f1883e.writeString(null);
            return;
        }
        try {
            ((b) this).f1883e.writeString(c(cVar.getClass()).getName());
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
