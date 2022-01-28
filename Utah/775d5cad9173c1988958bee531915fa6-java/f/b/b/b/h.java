package f.b.b.b;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

public final class h<K, V> extends d<K, V> {

    /* renamed from: h  reason: collision with root package name */
    public static final d<Object, Object> f3138h = new h(null, new Object[0], 0);

    /* renamed from: e  reason: collision with root package name */
    public final transient Object f3139e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f3140f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f3141g;

    public static class a<K, V> extends e<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final transient d<K, V> f3142e;

        /* renamed from: f  reason: collision with root package name */
        public final transient Object[] f3143f;

        /* renamed from: g  reason: collision with root package name */
        public final transient int f3144g;

        /* renamed from: h  reason: collision with root package name */
        public final transient int f3145h;

        /* renamed from: f.b.b.b.h$a$a  reason: collision with other inner class name */
        public class C0105a extends c<Map.Entry<K, V>> {
            public C0105a() {
            }

            @Override // java.util.List
            public Object get(int i2) {
                f.b.a.c.b.o.b.v(i2, a.this.f3145h);
                a aVar = a.this;
                Object[] objArr = aVar.f3143f;
                int i3 = i2 * 2;
                int i4 = aVar.f3144g;
                return new AbstractMap.SimpleImmutableEntry(objArr[i3 + i4], objArr[i3 + (i4 ^ 1)]);
            }

            @Override // f.b.b.b.b
            public boolean m() {
                return true;
            }

            public int size() {
                return a.this.f3145h;
            }
        }

        public a(d<K, V> dVar, Object[] objArr, int i2, int i3) {
            this.f3142e = dVar;
            this.f3143f = objArr;
            this.f3144g = i2;
            this.f3145h = i3;
        }

        @Override // f.b.b.b.b
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f3142e.get(key));
        }

        @Override // f.b.b.b.b
        public int i(Object[] objArr, int i2) {
            return h().i(objArr, i2);
        }

        @Override // f.b.b.b.b
        public boolean m() {
            return true;
        }

        @Override // f.b.b.b.b
        /* renamed from: n */
        public k<Map.Entry<K, V>> iterator() {
            return h().listIterator();
        }

        @Override // f.b.b.b.e
        public c<Map.Entry<K, V>> r() {
            return new C0105a();
        }

        public int size() {
            return this.f3145h;
        }
    }

    public static final class b<K> extends e<K> {

        /* renamed from: e  reason: collision with root package name */
        public final transient d<K, ?> f3147e;

        /* renamed from: f  reason: collision with root package name */
        public final transient c<K> f3148f;

        public b(d<K, ?> dVar, c<K> cVar) {
            this.f3147e = dVar;
            this.f3148f = cVar;
        }

        @Override // f.b.b.b.b
        public boolean contains(Object obj) {
            return this.f3147e.get(obj) != null;
        }

        @Override // f.b.b.b.b, f.b.b.b.e
        public c<K> h() {
            return this.f3148f;
        }

        @Override // f.b.b.b.b
        public int i(Object[] objArr, int i2) {
            return this.f3148f.i(objArr, i2);
        }

        @Override // f.b.b.b.b
        public boolean m() {
            return true;
        }

        @Override // f.b.b.b.b
        /* renamed from: n */
        public k<K> iterator() {
            return this.f3148f.listIterator();
        }

        public int size() {
            return ((h) this.f3147e).f3141g;
        }
    }

    public static final class c extends c<Object> {

        /* renamed from: d  reason: collision with root package name */
        public final transient Object[] f3149d;

        /* renamed from: e  reason: collision with root package name */
        public final transient int f3150e;

        /* renamed from: f  reason: collision with root package name */
        public final transient int f3151f;

        public c(Object[] objArr, int i2, int i3) {
            this.f3149d = objArr;
            this.f3150e = i2;
            this.f3151f = i3;
        }

        @Override // java.util.List
        public Object get(int i2) {
            f.b.a.c.b.o.b.v(i2, this.f3151f);
            return this.f3149d[(i2 * 2) + this.f3150e];
        }

        @Override // f.b.b.b.b
        public boolean m() {
            return true;
        }

        public int size() {
            return this.f3151f;
        }
    }

    public h(Object obj, Object[] objArr, int i2) {
        this.f3139e = obj;
        this.f3140f = objArr;
        this.f3141g = i2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x006e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [short[]] */
    /* JADX WARN: Type inference failed for: r8v5, types: [short] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r8v7, types: [byte] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r2[r7] = (byte) r4;
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        r2[r7] = (short) r4;
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d2, code lost:
        r2[r8] = r5;
        r3 = r3 + 1;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <K, V> h<K, V> d(int i2, Object[] objArr) {
        byte[] bArr;
        if (i2 == 0) {
            return (h) f3138h;
        }
        Object obj = null;
        if (i2 == 1) {
            f.b.a.c.b.o.b.x(objArr[0], objArr[1]);
            return new h<>(null, objArr, 1);
        }
        f.b.a.c.b.o.b.C(i2, objArr.length >> 1);
        int o = e.o(i2);
        if (i2 == 1) {
            f.b.a.c.b.o.b.x(objArr[0], objArr[1]);
        } else {
            int i3 = o - 1;
            if (o <= 128) {
                bArr = new byte[o];
                Arrays.fill((byte[]) bArr, (byte) -1);
                int i4 = 0;
                while (i4 < i2) {
                    int i5 = (i4 * 2) + 0;
                    Object obj2 = objArr[i5];
                    Object obj3 = objArr[i5 ^ 1];
                    f.b.a.c.b.o.b.x(obj2, obj3);
                    int r1 = f.b.a.c.b.o.b.r1(obj2.hashCode());
                    while (true) {
                        int i6 = r1 & i3;
                        int i7 = bArr[i6] & 255;
                        if (i7 == 255) {
                            break;
                        } else if (!objArr[i7].equals(obj2)) {
                            r1 = i6 + 1;
                        } else {
                            throw e(obj2, obj3, objArr, i7);
                        }
                    }
                }
            } else if (o <= 32768) {
                bArr = new short[o];
                Arrays.fill((short[]) bArr, (short) -1);
                int i8 = 0;
                while (i8 < i2) {
                    int i9 = (i8 * 2) + 0;
                    Object obj4 = objArr[i9];
                    Object obj5 = objArr[i9 ^ 1];
                    f.b.a.c.b.o.b.x(obj4, obj5);
                    int r12 = f.b.a.c.b.o.b.r1(obj4.hashCode());
                    while (true) {
                        int i10 = r12 & i3;
                        int i11 = bArr[i10] & 65535;
                        if (i11 == 65535) {
                            break;
                        } else if (!objArr[i11].equals(obj4)) {
                            r12 = i10 + 1;
                        } else {
                            throw e(obj4, obj5, objArr, i11);
                        }
                    }
                }
            } else {
                bArr = new int[o];
                Arrays.fill((int[]) bArr, -1);
                int i12 = 0;
                while (i12 < i2) {
                    int i13 = (i12 * 2) + 0;
                    Object obj6 = objArr[i13];
                    Object obj7 = objArr[i13 ^ 1];
                    f.b.a.c.b.o.b.x(obj6, obj7);
                    int r13 = f.b.a.c.b.o.b.r1(obj6.hashCode());
                    while (true) {
                        int i14 = r13 & i3;
                        ?? r9 = bArr[i14];
                        if (r9 == -1) {
                            break;
                        } else if (!objArr[r9].equals(obj6)) {
                            r13 = i14 + 1;
                        } else {
                            throw e(obj6, obj7, objArr, r9);
                        }
                    }
                }
            }
            obj = bArr;
        }
        return new h<>(obj, objArr, i2);
    }

    public static IllegalArgumentException e(Object obj, Object obj2, Object[] objArr, int i2) {
        return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i2] + "=" + objArr[i2 ^ 1]);
    }

    @Override // java.util.Map, f.b.b.b.d
    public V get(Object obj) {
        Object obj2 = this.f3139e;
        Object[] objArr = this.f3140f;
        int i2 = this.f3141g;
        if (obj == null) {
            return null;
        }
        if (i2 == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int r1 = f.b.a.c.b.o.b.r1(obj.hashCode());
                while (true) {
                    int i3 = r1 & length;
                    int i4 = bArr[i3] & 255;
                    if (i4 == 255) {
                        return null;
                    }
                    if (objArr[i4].equals(obj)) {
                        return (V) objArr[i4 ^ 1];
                    }
                    r1 = i3 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int r12 = f.b.a.c.b.o.b.r1(obj.hashCode());
                while (true) {
                    int i5 = r12 & length2;
                    int i6 = sArr[i5] & 65535;
                    if (i6 == 65535) {
                        return null;
                    }
                    if (objArr[i6].equals(obj)) {
                        return (V) objArr[i6 ^ 1];
                    }
                    r12 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int r13 = f.b.a.c.b.o.b.r1(obj.hashCode());
                while (true) {
                    int i7 = r13 & length3;
                    int i8 = iArr[i7];
                    if (i8 == -1) {
                        return null;
                    }
                    if (objArr[i8].equals(obj)) {
                        return (V) objArr[i8 ^ 1];
                    }
                    r13 = i7 + 1;
                }
            }
        }
    }

    public int size() {
        return this.f3141g;
    }
}
