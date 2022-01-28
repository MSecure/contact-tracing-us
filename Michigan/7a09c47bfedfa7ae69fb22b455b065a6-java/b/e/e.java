package b.e;

public class e<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1381f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f1382b = false;

    /* renamed from: c  reason: collision with root package name */
    public long[] f1383c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f1384d;

    /* renamed from: e  reason: collision with root package name */
    public int f1385e;

    public e() {
        int f2 = d.f(10);
        this.f1383c = new long[f2];
        this.f1384d = new Object[f2];
    }

    public void a(long j, E e2) {
        int i = this.f1385e;
        if (i == 0 || j > this.f1383c[i - 1]) {
            if (this.f1382b && this.f1385e >= this.f1383c.length) {
                d();
            }
            int i2 = this.f1385e;
            if (i2 >= this.f1383c.length) {
                int f2 = d.f(i2 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.f1383c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1384d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1383c = jArr;
                this.f1384d = objArr;
            }
            this.f1383c[i2] = j;
            this.f1384d[i2] = e2;
            this.f1385e = i2 + 1;
            return;
        }
        g(j, e2);
    }

    public void b() {
        int i = this.f1385e;
        Object[] objArr = this.f1384d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1385e = 0;
        this.f1382b = false;
    }

    /* renamed from: c */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.f1383c = (long[]) this.f1383c.clone();
            eVar.f1384d = (Object[]) this.f1384d.clone();
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void d() {
        int i = this.f1385e;
        long[] jArr = this.f1383c;
        Object[] objArr = this.f1384d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1381f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1382b = false;
        this.f1385e = i2;
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e2) {
        int b2 = d.b(this.f1383c, this.f1385e, j);
        if (b2 >= 0) {
            Object[] objArr = this.f1384d;
            if (objArr[b2] != f1381f) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public void g(long j, E e2) {
        int b2 = d.b(this.f1383c, this.f1385e, j);
        if (b2 >= 0) {
            this.f1384d[b2] = e2;
            return;
        }
        int i = ~b2;
        if (i < this.f1385e) {
            Object[] objArr = this.f1384d;
            if (objArr[i] == f1381f) {
                this.f1383c[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f1382b && this.f1385e >= this.f1383c.length) {
            d();
            i = ~d.b(this.f1383c, this.f1385e, j);
        }
        int i2 = this.f1385e;
        if (i2 >= this.f1383c.length) {
            int f2 = d.f(i2 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.f1383c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1384d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1383c = jArr;
            this.f1384d = objArr2;
        }
        int i3 = this.f1385e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f1383c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f1384d;
            System.arraycopy(objArr4, i, objArr4, i4, this.f1385e - i);
        }
        this.f1383c[i] = j;
        this.f1384d[i] = e2;
        this.f1385e++;
    }

    public int h() {
        if (this.f1382b) {
            d();
        }
        return this.f1385e;
    }

    public E i(int i) {
        if (this.f1382b) {
            d();
        }
        return (E) this.f1384d[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1385e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1385e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f1382b) {
                d();
            }
            sb.append(this.f1383c[i]);
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
