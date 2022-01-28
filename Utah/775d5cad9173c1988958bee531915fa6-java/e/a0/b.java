package e.a0;

import android.os.IBinder;
import android.os.Parcelable;
import e.e.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class b {
    public final a<String, Method> a;
    public final a<String, Method> b;
    public final a<String, Class> c;

    public b(a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    public abstract void A(long j2);

    public abstract void B(Parcelable parcelable);

    public abstract void C(String str);

    public abstract void D(IBinder iBinder);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: e.a0.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void E(d dVar) {
        if (dVar == null) {
            C(null);
            return;
        }
        try {
            C(c(dVar.getClass()).getName());
            b b2 = b();
            try {
                e(dVar.getClass()).invoke(null, dVar, b2);
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
            throw new RuntimeException(dVar.getClass().getSimpleName() + " does not have a Parcelizer", e6);
        }
    }

    public abstract void a();

    public abstract b b();

    public final Class c(Class<? extends d> cls) {
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
        Method declaredMethod = Class.forName(str, true, b.class.getClassLoader()).getDeclaredMethod("read", b.class);
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
        Method declaredMethod = c2.getDeclaredMethod("write", cls, b.class);
        this.b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public <T> T[] f(T[] tArr, int i2) {
        Serializable serializable;
        if (!j(i2)) {
            return tArr;
        }
        int k2 = k();
        if (k2 < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(k2);
        if (k2 != 0) {
            int k3 = k();
            if (k2 < 0) {
                return null;
            }
            if (k3 == 1) {
                while (k2 > 0) {
                    arrayList.add(s());
                    k2--;
                }
            } else if (k3 == 2) {
                while (k2 > 0) {
                    arrayList.add(n());
                    k2--;
                }
            } else if (k3 == 3) {
                while (k2 > 0) {
                    String p = p();
                    if (p == null) {
                        serializable = null;
                    } else {
                        try {
                            serializable = (Serializable) new a(this, new ByteArrayInputStream(h())).readObject();
                        } catch (IOException e2) {
                            throw new RuntimeException(f.a.a.a.a.c("VersionedParcelable encountered IOException reading a Serializable object (name = ", p, ")"), e2);
                        } catch (ClassNotFoundException e3) {
                            throw new RuntimeException(f.a.a.a.a.c("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", p, ")"), e3);
                        }
                    }
                    arrayList.add(serializable);
                    k2--;
                }
            } else if (k3 == 4) {
                while (k2 > 0) {
                    arrayList.add(p());
                    k2--;
                }
            } else if (k3 == 5) {
                while (k2 > 0) {
                    arrayList.add(r());
                    k2--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public abstract boolean g();

    public abstract byte[] h();

    public abstract CharSequence i();

    public abstract boolean j(int i2);

    public abstract int k();

    public int l(int i2, int i3) {
        return !j(i3) ? i2 : k();
    }

    public abstract long m();

    public abstract <T extends Parcelable> T n();

    public <T extends Parcelable> T o(T t, int i2) {
        return !j(i2) ? t : (T) n();
    }

    public abstract String p();

    public String q(String str, int i2) {
        return !j(i2) ? str : p();
    }

    public abstract IBinder r();

    public <T extends d> T s() {
        String p = p();
        if (p == null) {
            return null;
        }
        b b2 = b();
        try {
            return (T) ((d) d(p).invoke(null, b2));
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

    public <T extends d> T t(T t, int i2) {
        return !j(i2) ? t : (T) s();
    }

    public abstract void u(int i2);

    public <T> void v(T[] tArr, int i2) {
        int i3;
        u(i2);
        if (tArr == null) {
            z(-1);
            return;
        }
        int length = tArr.length;
        z(length);
        if (length > 0) {
            int i4 = 0;
            T t = tArr[0];
            if (t instanceof String) {
                i3 = 4;
            } else if (t instanceof Parcelable) {
                i3 = 2;
            } else if (t instanceof d) {
                i3 = 1;
            } else if (t instanceof Serializable) {
                i3 = 3;
            } else if (t instanceof IBinder) {
                i3 = 5;
            } else if (t instanceof Integer) {
                i3 = 7;
            } else if (t instanceof Float) {
                i3 = 8;
            } else {
                throw new IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
            }
            z(i3);
            if (i3 == 1) {
                while (i4 < length) {
                    E(tArr[i4]);
                    i4++;
                }
            } else if (i3 == 2) {
                while (i4 < length) {
                    B(tArr[i4]);
                    i4++;
                }
            } else if (i3 == 3) {
                while (i4 < length) {
                    T t2 = tArr[i4];
                    if (t2 == null) {
                        C(null);
                    } else {
                        String name = t2.getClass().getName();
                        C(name);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            objectOutputStream.writeObject(t2);
                            objectOutputStream.close();
                            x(byteArrayOutputStream.toByteArray());
                        } catch (IOException e2) {
                            throw new RuntimeException(f.a.a.a.a.c("VersionedParcelable encountered IOException writing serializable object (name = ", name, ")"), e2);
                        }
                    }
                    i4++;
                }
            } else if (i3 == 4) {
                while (i4 < length) {
                    C(tArr[i4]);
                    i4++;
                }
            } else if (i3 == 5) {
                while (i4 < length) {
                    D(tArr[i4]);
                    i4++;
                }
            }
        }
    }

    public abstract void w(boolean z);

    public abstract void x(byte[] bArr);

    public abstract void y(CharSequence charSequence);

    public abstract void z(int i2);
}
