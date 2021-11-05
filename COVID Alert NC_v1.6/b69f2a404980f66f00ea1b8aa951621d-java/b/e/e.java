package b.e;

public class e<E> implements Cloneable {
    public static final Object f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f803b = false;

    /* renamed from: c  reason: collision with root package name */
    public long[] f804c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f805d;

    /* renamed from: e  reason: collision with root package name */
    public int f806e;

    public e() {
        int f2 = d.f(10);
        this.f804c = new long[f2];
        this.f805d = new Object[f2];
    }

    public void a(long j, E e2) {
        int i = this.f806e;
        if (i == 0 || j > this.f804c[i - 1]) {
            if (this.f803b && this.f806e >= this.f804c.length) {
                d();
            }
            int i2 = this.f806e;
            if (i2 >= this.f804c.length) {
                int f2 = d.f(i2 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.f804c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f805d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f804c = jArr;
                this.f805d = objArr;
            }
            this.f804c[i2] = j;
            this.f805d[i2] = e2;
            this.f806e = i2 + 1;
            return;
        }
        g(j, e2);
    }

    public void b() {
        int i = this.f806e;
        Object[] objArr = this.f805d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f806e = 0;
        this.f803b = false;
    }

    /* renamed from: c */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.f804c = (long[]) this.f804c.clone();
            eVar.f805d = (Object[]) this.f805d.clone();
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void d() {
        int i = this.f806e;
        long[] jArr = this.f804c;
        Object[] objArr = this.f805d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f803b = false;
        this.f806e = i2;
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e2) {
        int b2 = d.b(this.f804c, this.f806e, j);
        if (b2 >= 0) {
            Object[] objArr = this.f805d;
            if (objArr[b2] != f) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public void g(long j, E e2) {
        int b2 = d.b(this.f804c, this.f806e, j);
        if (b2 >= 0) {
            this.f805d[b2] = e2;
            return;
        }
        int i = ~b2;
        if (i < this.f806e) {
            Object[] objArr = this.f805d;
            if (objArr[i] == f) {
                this.f804c[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f803b && this.f806e >= this.f804c.length) {
            d();
            i = ~d.b(this.f804c, this.f806e, j);
        }
        int i2 = this.f806e;
        if (i2 >= this.f804c.length) {
            int f2 = d.f(i2 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.f804c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f805d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f804c = jArr;
            this.f805d = objArr2;
        }
        int i3 = this.f806e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f804c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f805d;
            System.arraycopy(objArr4, i, objArr4, i4, this.f806e - i);
        }
        this.f804c[i] = j;
        this.f805d[i] = e2;
        this.f806e++;
    }

    public int h() {
        if (this.f803b) {
            d();
        }
        return this.f806e;
    }

    public E i(int i) {
        if (this.f803b) {
            d();
        }
        return (E) this.f805d[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f806e * 28);
        sb.append('{');
        for (int i = 0; i < this.f806e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f803b) {
                d();
            }
            sb.append(this.f804c[i]);
            sb.append('=');
            E i2 = i(i);
            if (i2 != this) {
                sb.append((Object) i2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
