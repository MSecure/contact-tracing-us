package b.z;

import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import b.e.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final a<String, Method> f2787a;

    /* renamed from: b  reason: collision with root package name */
    public final a<String, Method> f2788b;

    /* renamed from: c  reason: collision with root package name */
    public final a<String, Class> f2789c;

    public b(a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        this.f2787a = aVar;
        this.f2788b = aVar2;
        this.f2789c = aVar3;
    }

    public abstract void a();

    public abstract b b();

    public final Class c(Class<? extends d> cls) {
        Class orDefault = this.f2789c.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f2789c.put(cls.getName(), cls2);
        return cls2;
    }

    public final Method d(String str) {
        Method orDefault = this.f2787a.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, b.class.getClassLoader()).getDeclaredMethod("read", b.class);
        this.f2787a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) {
        Method orDefault = this.f2788b.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class c2 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c2.getDeclaredMethod("write", cls, b.class);
        this.f2788b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public <T> T[] f(T[] tArr, int i) {
        Serializable serializable;
        byte[] bArr;
        if (!i(i)) {
            return tArr;
        }
        int j = j();
        if (j < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(j);
        if (j != 0) {
            int j2 = j();
            if (j < 0) {
                return null;
            }
            if (j2 == 1) {
                while (j > 0) {
                    arrayList.add(o());
                    j--;
                }
            } else if (j2 == 2) {
                while (j > 0) {
                    arrayList.add(((c) this).f2791e.readParcelable(c.class.getClassLoader()));
                    j--;
                }
            } else if (j2 == 3) {
                while (j > 0) {
                    String m = m();
                    if (m == null) {
                        serializable = null;
                    } else {
                        c cVar = (c) this;
                        int readInt = cVar.f2791e.readInt();
                        if (readInt < 0) {
                            bArr = null;
                        } else {
                            bArr = new byte[readInt];
                            cVar.f2791e.readByteArray(bArr);
                        }
                        try {
                            serializable = (Serializable) new a(this, new ByteArrayInputStream(bArr)).readObject();
                        } catch (IOException e2) {
                            throw new RuntimeException(c.a.a.a.a.c("VersionedParcelable encountered IOException reading a Serializable object (name = ", m, ")"), e2);
                        } catch (ClassNotFoundException e3) {
                            throw new RuntimeException(c.a.a.a.a.c("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", m, ")"), e3);
                        }
                    }
                    arrayList.add(serializable);
                    j--;
                }
            } else if (j2 == 4) {
                while (j > 0) {
                    arrayList.add(m());
                    j--;
                }
            } else if (j2 == 5) {
                while (j > 0) {
                    arrayList.add(((c) this).f2791e.readStrongBinder());
                    j--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public boolean g(boolean z, int i) {
        if (!i(i)) {
            return z;
        }
        return ((c) this).f2791e.readInt() != 0;
    }

    public CharSequence h(CharSequence charSequence, int i) {
        return !i(i) ? charSequence : (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) this).f2791e);
    }

    public abstract boolean i(int i);

    public abstract int j();

    public int k(int i, int i2) {
        return !i(i2) ? i : j();
    }

    public <T extends Parcelable> T l(T t, int i) {
        return !i(i) ? t : (T) ((c) this).f2791e.readParcelable(c.class.getClassLoader());
    }

    public abstract String m();

    public String n(String str, int i) {
        return !i(i) ? str : m();
    }

    public <T extends d> T o() {
        String m = m();
        if (m == null) {
            return null;
        }
        b b2 = b();
        try {
            return (T) ((d) d(m).invoke(null, b2));
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

    public <T extends d> T p(T t, int i) {
        return !i(i) ? t : (T) o();
    }

    public abstract void q(int i);

    public <T> void r(T[] tArr, int i) {
        int i2;
        q(i);
        if (tArr == null) {
            ((c) this).f2791e.writeInt(-1);
            return;
        }
        int length = tArr.length;
        c cVar = (c) this;
        cVar.f2791e.writeInt(length);
        if (length > 0) {
            int i3 = 0;
            T t = tArr[0];
            if (t instanceof String) {
                i2 = 4;
            } else if (t instanceof Parcelable) {
                i2 = 2;
            } else if (t instanceof d) {
                i2 = 1;
            } else if (t instanceof Serializable) {
                i2 = 3;
            } else if (t instanceof IBinder) {
                i2 = 5;
            } else if (t instanceof Integer) {
                i2 = 7;
            } else if (t instanceof Float) {
                i2 = 8;
            } else {
                throw new IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
            }
            cVar.f2791e.writeInt(i2);
            if (i2 == 1) {
                while (i3 < length) {
                    w(tArr[i3]);
                    i3++;
                }
            } else if (i2 == 2) {
                for (T t2 : tArr) {
                    cVar.f2791e.writeParcelable(t2, 0);
                }
            } else if (i2 == 3) {
                while (i3 < length) {
                    T t3 = tArr[i3];
                    if (t3 == null) {
                        cVar.f2791e.writeString(null);
                    } else {
                        String name = t3.getClass().getName();
                        cVar.f2791e.writeString(name);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            objectOutputStream.writeObject(t3);
                            objectOutputStream.close();
                            s(byteArrayOutputStream.toByteArray());
                        } catch (IOException e2) {
                            throw new RuntimeException(c.a.a.a.a.c("VersionedParcelable encountered IOException writing serializable object (name = ", name, ")"), e2);
                        }
                    }
                    i3++;
                }
            } else if (i2 == 4) {
                while (i3 < length) {
                    cVar.f2791e.writeString(tArr[i3]);
                    i3++;
                }
            } else if (i2 == 5) {
                while (i3 < length) {
                    cVar.f2791e.writeStrongBinder(tArr[i3]);
                    i3++;
                }
            }
        }
    }

    public abstract void s(byte[] bArr);

    public void t(int i, int i2) {
        q(i2);
        ((c) this).f2791e.writeInt(i);
    }

    public void u(Parcelable parcelable, int i) {
        q(i);
        ((c) this).f2791e.writeParcelable(parcelable, 0);
    }

    public void v(String str, int i) {
        q(i);
        ((c) this).f2791e.writeString(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: b.z.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void w(d dVar) {
        if (dVar == null) {
            ((c) this).f2791e.writeString(null);
            return;
        }
        try {
            ((c) this).f2791e.writeString(c(dVar.getClass()).getName());
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
}
