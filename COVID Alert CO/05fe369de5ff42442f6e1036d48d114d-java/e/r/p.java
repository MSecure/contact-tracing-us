package e.r;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

public abstract class p<T> {
    public static final p<Integer> b = new c(false);
    public static final p<Integer> c = new d(false);

    /* renamed from: d  reason: collision with root package name */
    public static final p<int[]> f1592d = new e(true);

    /* renamed from: e  reason: collision with root package name */
    public static final p<Long> f1593e = new f(false);

    /* renamed from: f  reason: collision with root package name */
    public static final p<long[]> f1594f = new g(true);

    /* renamed from: g  reason: collision with root package name */
    public static final p<Float> f1595g = new h(false);

    /* renamed from: h  reason: collision with root package name */
    public static final p<float[]> f1596h = new i(true);

    /* renamed from: i  reason: collision with root package name */
    public static final p<Boolean> f1597i = new j(false);

    /* renamed from: j  reason: collision with root package name */
    public static final p<boolean[]> f1598j = new k(true);

    /* renamed from: k  reason: collision with root package name */
    public static final p<String> f1599k = new a(true);

    /* renamed from: l  reason: collision with root package name */
    public static final p<String[]> f1600l = new b(true);
    public final boolean a;

    public class a extends p<String> {
        public a(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public String a(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "string";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public String c(String str) {
            return str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    public class b extends p<String[]> {
        public b(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public String[] a(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "string[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public String[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    public class c extends p<Integer> {
        public c(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "integer";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Integer c(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    public class d extends p<Integer> {
        public d(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "reference";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Integer c(String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    public class e extends p<int[]> {
        public e(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public int[] a(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "integer[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public int[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    public class f extends p<Long> {
        public f(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Long a(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "long";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Long c(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            return Long.valueOf(str.startsWith("0x") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, Long l2) {
            bundle.putLong(str, l2.longValue());
        }
    }

    public class g extends p<long[]> {
        public g(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public long[] a(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "long[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public long[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    public class h extends p<Float> {
        public h(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Float a(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "float";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Float c(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, Float f2) {
            bundle.putFloat(str, f2.floatValue());
        }
    }

    public class i extends p<float[]> {
        public i(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public float[] a(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "float[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public float[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    public class j extends p<Boolean> {
        public j(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Boolean a(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "boolean";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public Boolean c(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    public class k extends p<boolean[]> {
        public k(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public boolean[] a(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return "boolean[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.r.p
        public boolean[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // e.r.p
        public void d(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static final class l<D extends Enum> extends C0046p<D> {
        public final Class<D> n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // e.r.p.C0046p, e.r.p
        public String b() {
            return this.n.getName();
        }

        /* renamed from: f */
        public D e(String str) {
            D[] enumConstants = this.n.getEnumConstants();
            for (D d2 : enumConstants) {
                if (d2.name().equals(str)) {
                    return d2;
                }
            }
            StringBuilder k2 = f.a.a.a.a.k("Enum value ", str, " not found for type ");
            k2.append(this.n.getName());
            k2.append(".");
            throw new IllegalArgumentException(k2.toString());
        }
    }

    public static final class m<D extends Parcelable> extends p<D[]> {
        public final Class<D[]> m;

        public m(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        @Override // e.r.p
        public Object a(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return this.m.getName();
        }

        @Override // e.r.p
        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // e.r.p
        public void d(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            this.m.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((m) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    public static final class n<D> extends p<D> {
        public final Class<D> m;

        public n(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        @Override // e.r.p
        public D a(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return this.m.getName();
        }

        @Override // e.r.p
        public D c(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // e.r.p
        public void d(Bundle bundle, String str, D d2) {
            this.m.cast(d2);
            if (d2 == null || (d2 instanceof Parcelable)) {
                bundle.putParcelable(str, d2);
            } else if (d2 instanceof Serializable) {
                bundle.putSerializable(str, d2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((n) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    public static final class o<D extends Serializable> extends p<D[]> {
        public final Class<D[]> m;

        public o(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        @Override // e.r.p
        public Object a(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return this.m.getName();
        }

        @Override // e.r.p
        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.os.Bundle */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // e.r.p
        public void d(Bundle bundle, String str, Object obj) {
            ?? r4 = (Serializable[]) obj;
            this.m.cast(r4);
            bundle.putSerializable(str, r4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((o) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    /* renamed from: e.r.p$p  reason: collision with other inner class name */
    public static class C0046p<D extends Serializable> extends p<D> {
        public final Class<D> m;

        public C0046p(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        public C0046p(boolean z, Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        @Override // e.r.p
        public Object a(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        @Override // e.r.p
        public String b() {
            return this.m.getName();
        }

        @Override // e.r.p
        public void d(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            this.m.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        /* renamed from: e */
        public D c(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0046p)) {
                return false;
            }
            return this.m.equals(((C0046p) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    public p(boolean z) {
        this.a = z;
    }

    public abstract T a(Bundle bundle, String str);

    public abstract String b();

    public abstract T c(String str);

    public abstract void d(Bundle bundle, String str, T t);

    public String toString() {
        return b();
    }
}
