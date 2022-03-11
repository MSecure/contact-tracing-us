package e.t;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class p<T> {
    public static final p<Integer> b = new c(false);
    public static final p<Integer> c = new d(false);

    /* renamed from: d  reason: collision with root package name */
    public static final p<int[]> f1952d = new e(true);

    /* renamed from: e  reason: collision with root package name */
    public static final p<Long> f1953e = new f(false);

    /* renamed from: f  reason: collision with root package name */
    public static final p<long[]> f1954f = new g(true);

    /* renamed from: g  reason: collision with root package name */
    public static final p<Float> f1955g = new h(false);

    /* renamed from: h  reason: collision with root package name */
    public static final p<float[]> f1956h = new i(true);

    /* renamed from: i  reason: collision with root package name */
    public static final p<Boolean> f1957i = new j(false);

    /* renamed from: j  reason: collision with root package name */
    public static final p<boolean[]> f1958j = new k(true);

    /* renamed from: k  reason: collision with root package name */
    public static final p<String> f1959k = new a(true);

    /* renamed from: l  reason: collision with root package name */
    public static final p<String[]> f1960l = new b(true);
    public final boolean a;

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class a extends p<String> {
        public a(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public String a(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        public String b() {
            return "string";
        }

        public Object c(String str) {
            return str;
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putString(str, (String) obj);
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class b extends p<String[]> {
        public b(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public String[] a(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        public String b() {
            return "string[]";
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putStringArray(str, (String[]) obj);
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class c extends p<Integer> {
        public c(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        public String b() {
            return "integer";
        }

        public Object c(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class d extends p<Integer> {
        public d(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        public String b() {
            return "reference";
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class e extends p<int[]> {
        public e(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public int[] a(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        public String b() {
            return "integer[]";
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putIntArray(str, (int[]) obj);
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class f extends p<Long> {
        public f(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public Long a(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        public String b() {
            return "long";
        }

        public Object c(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            return Long.valueOf(str.startsWith("0x") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str));
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putLong(str, ((Long) obj).longValue());
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class g extends p<long[]> {
        public g(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public long[] a(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        public String b() {
            return "long[]";
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putLongArray(str, (long[]) obj);
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class h extends p<Float> {
        public h(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public Float a(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        public String b() {
            return "float";
        }

        public Object c(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class i extends p<float[]> {
        public i(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public float[] a(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        public String b() {
            return "float[]";
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putFloatArray(str, (float[]) obj);
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class j extends p<Boolean> {
        public j(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public Boolean a(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        public String b() {
            return "boolean";
        }

        public Object c(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
    public class k extends p<boolean[]> {
        public k(boolean z) {
            super(z);
        }

        @Override // e.t.p
        public boolean[] a(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        public String b() {
            return "boolean[]";
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void d(Bundle bundle, String str, Object obj) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        }
    }

    /* loaded from: classes.dex */
    public static final class l<D extends Enum> extends C0056p<D> {
        public final Class<D> n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // e.t.p.C0056p, e.t.p
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
            StringBuilder j2 = f.a.a.a.a.j("Enum value ", str, " not found for type ");
            j2.append(this.n.getName());
            j2.append(".");
            throw new IllegalArgumentException(j2.toString());
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
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

        @Override // e.t.p
        public Object a(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        public String b() {
            return this.m.getName();
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

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

    /* loaded from: classes.dex */
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

        @Override // e.t.p
        public D a(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // e.t.p
        public String b() {
            return this.m.getName();
        }

        @Override // e.t.p
        public D c(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // e.t.p
        public void d(Bundle bundle, String str, D d2) {
            this.m.cast(d2);
            if (d2 == null || (d2 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d2);
            } else if (d2 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d2);
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

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* loaded from: classes.dex */
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

        @Override // e.t.p
        public Object a(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        public String b() {
            return this.m.getName();
        }

        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        /* JADX WARN: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump */
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

    /*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
        java.lang.UnsupportedOperationException
        	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
        	at java.util.AbstractList.equals(AbstractList.java:519)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
        	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
        */
    /* renamed from: e.t.p$p  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056p<D extends Serializable> extends p<D> {
        public final Class<D> m;

        public C0056p(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        public C0056p(boolean z, Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        @Override // e.t.p
        public Object a(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        @Override // e.t.p
        public String b() {
            return this.m.getName();
        }

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
            if (!(obj instanceof C0056p)) {
                return false;
            }
            return this.m.equals(((C0056p) obj).m);
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
