package e.e;

public class e<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1216f = new Object();
    public boolean b = false;
    public long[] c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f1217d;

    /* renamed from: e  reason: collision with root package name */
    public int f1218e;

    public e() {
        int f2 = d.f(10);
        this.c = new long[f2];
        this.f1217d = new Object[f2];
    }

    public void a(long j2, E e2) {
        int i2 = this.f1218e;
        if (i2 == 0 || j2 > this.c[i2 - 1]) {
            if (this.b && i2 >= this.c.length) {
                d();
            }
            int i3 = this.f1218e;
            if (i3 >= this.c.length) {
                int f2 = d.f(i3 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1217d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.c = jArr;
                this.f1217d = objArr;
            }
            this.c[i3] = j2;
            this.f1217d[i3] = e2;
            this.f1218e = i3 + 1;
            return;
        }
        g(j2, e2);
    }

    public void b() {
        int i2 = this.f1218e;
        Object[] objArr = this.f1217d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1218e = 0;
        this.b = false;
    }

    /* renamed from: c */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.c = (long[]) this.c.clone();
            eVar.f1217d = (Object[]) this.f1217d.clone();
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void d() {
        int i2 = this.f1218e;
        long[] jArr = this.c;
        Object[] objArr = this.f1217d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1216f) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.b = false;
        this.f1218e = i3;
    }

    public E e(long j2) {
        return f(j2, null);
    }

    public E f(long j2, E e2) {
        int b2 = d.b(this.c, this.f1218e, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f1217d;
            if (objArr[b2] != f1216f) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public void g(long j2, E e2) {
        int b2 = d.b(this.c, this.f1218e, j2);
        if (b2 >= 0) {
            this.f1217d[b2] = e2;
            return;
        }
        int i2 = ~b2;
        int i3 = this.f1218e;
        if (i2 < i3) {
            Object[] objArr = this.f1217d;
            if (objArr[i2] == f1216f) {
                this.c[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.b && i3 >= this.c.length) {
            d();
            i2 = ~d.b(this.c, this.f1218e, j2);
        }
        int i4 = this.f1218e;
        if (i4 >= this.c.length) {
            int f2 = d.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1217d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = jArr;
            this.f1217d = objArr2;
        }
        int i5 = this.f1218e;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.c;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f1217d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f1218e - i2);
        }
        this.c[i2] = j2;
        this.f1217d[i2] = e2;
        this.f1218e++;
    }

    public int h() {
        if (this.b) {
            d();
        }
        return this.f1218e;
    }

    public E i(int i2) {
        if (this.b) {
            d();
        }
        return (E) this.f1217d[i2];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1218e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1218e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            if (this.b) {
                d();
            }
            sb.append(this.c[i2]);
            sb.append('=');
            E i3 = i(i2);
            if (i3 != this) {
                sb.append((Object) i3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
