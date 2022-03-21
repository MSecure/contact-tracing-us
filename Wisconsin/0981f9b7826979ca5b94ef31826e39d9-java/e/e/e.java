package e.e;

public class e<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1182f = new Object();
    public boolean b = false;
    public long[] c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f1183d;

    /* renamed from: e  reason: collision with root package name */
    public int f1184e;

    public e() {
        int f2 = d.f(10);
        this.c = new long[f2];
        this.f1183d = new Object[f2];
    }

    public void a(long j2, E e2) {
        int i2 = this.f1184e;
        if (i2 == 0 || j2 > this.c[i2 - 1]) {
            if (this.b && i2 >= this.c.length) {
                e();
            }
            int i3 = this.f1184e;
            if (i3 >= this.c.length) {
                int f2 = d.f(i3 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1183d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.c = jArr;
                this.f1183d = objArr;
            }
            this.c[i3] = j2;
            this.f1183d[i3] = e2;
            this.f1184e = i3 + 1;
            return;
        }
        j(j2, e2);
    }

    public void b() {
        int i2 = this.f1184e;
        Object[] objArr = this.f1183d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1184e = 0;
        this.b = false;
    }

    /* renamed from: c */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.c = (long[]) this.c.clone();
            eVar.f1183d = (Object[]) this.f1183d.clone();
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean d(long j2) {
        if (this.b) {
            e();
        }
        return d.b(this.c, this.f1184e, j2) >= 0;
    }

    public final void e() {
        int i2 = this.f1184e;
        long[] jArr = this.c;
        Object[] objArr = this.f1183d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1182f) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.b = false;
        this.f1184e = i3;
    }

    public E f(long j2) {
        return g(j2, null);
    }

    public E g(long j2, E e2) {
        int b2 = d.b(this.c, this.f1184e, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f1183d;
            if (objArr[b2] != f1182f) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public boolean h() {
        return l() == 0;
    }

    public long i(int i2) {
        if (this.b) {
            e();
        }
        return this.c[i2];
    }

    public void j(long j2, E e2) {
        int b2 = d.b(this.c, this.f1184e, j2);
        if (b2 >= 0) {
            this.f1183d[b2] = e2;
            return;
        }
        int i2 = ~b2;
        int i3 = this.f1184e;
        if (i2 < i3) {
            Object[] objArr = this.f1183d;
            if (objArr[i2] == f1182f) {
                this.c[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.b && i3 >= this.c.length) {
            e();
            i2 = ~d.b(this.c, this.f1184e, j2);
        }
        int i4 = this.f1184e;
        if (i4 >= this.c.length) {
            int f2 = d.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1183d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = jArr;
            this.f1183d = objArr2;
        }
        int i5 = this.f1184e;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.c;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f1183d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f1184e - i2);
        }
        this.c[i2] = j2;
        this.f1183d[i2] = e2;
        this.f1184e++;
    }

    public void k(long j2) {
        Object[] objArr;
        Object obj;
        int b2 = d.b(this.c, this.f1184e, j2);
        if (b2 >= 0 && (objArr = this.f1183d)[b2] != (obj = f1182f)) {
            objArr[b2] = obj;
            this.b = true;
        }
    }

    public int l() {
        if (this.b) {
            e();
        }
        return this.f1184e;
    }

    public E m(int i2) {
        if (this.b) {
            e();
        }
        return (E) this.f1183d[i2];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1184e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1184e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(i(i2));
            sb.append('=');
            E m = m(i2);
            if (m != this) {
                sb.append((Object) m);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
