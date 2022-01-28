package b.e;

public class i<E> implements Cloneable {
    public static final Object f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f830b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f831c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f832d;

    /* renamed from: e  reason: collision with root package name */
    public int f833e;

    public i() {
        this(10);
    }

    public i(int i) {
        this.f830b = false;
        if (i == 0) {
            this.f831c = d.f800a;
            this.f832d = d.f802c;
            return;
        }
        int e2 = d.e(i);
        this.f831c = new int[e2];
        this.f832d = new Object[e2];
    }

    public void a(int i, E e2) {
        int i2 = this.f833e;
        if (i2 == 0 || i > this.f831c[i2 - 1]) {
            if (this.f830b && this.f833e >= this.f831c.length) {
                c();
            }
            int i3 = this.f833e;
            if (i3 >= this.f831c.length) {
                int e3 = d.e(i3 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.f831c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f832d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f831c = iArr;
                this.f832d = objArr;
            }
            this.f831c[i3] = i;
            this.f832d[i3] = e2;
            this.f833e = i3 + 1;
            return;
        }
        g(i, e2);
    }

    /* renamed from: b */
    public i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            iVar.f831c = (int[]) this.f831c.clone();
            iVar.f832d = (Object[]) this.f832d.clone();
            return iVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void c() {
        int i = this.f833e;
        int[] iArr = this.f831c;
        Object[] objArr = this.f832d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f830b = false;
        this.f833e = i2;
    }

    public E d(int i) {
        return e(i, null);
    }

    public E e(int i, E e2) {
        int a2 = d.a(this.f831c, this.f833e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f832d;
            if (objArr[a2] != f) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public int f(int i) {
        if (this.f830b) {
            c();
        }
        return this.f831c[i];
    }

    public void g(int i, E e2) {
        int a2 = d.a(this.f831c, this.f833e, i);
        if (a2 >= 0) {
            this.f832d[a2] = e2;
            return;
        }
        int i2 = ~a2;
        if (i2 < this.f833e) {
            Object[] objArr = this.f832d;
            if (objArr[i2] == f) {
                this.f831c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f830b && this.f833e >= this.f831c.length) {
            c();
            i2 = ~d.a(this.f831c, this.f833e, i);
        }
        int i3 = this.f833e;
        if (i3 >= this.f831c.length) {
            int e3 = d.e(i3 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f831c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f832d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f831c = iArr;
            this.f832d = objArr2;
        }
        int i4 = this.f833e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f831c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f832d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f833e - i2);
        }
        this.f831c[i2] = i;
        this.f832d[i2] = e2;
        this.f833e++;
    }

    public void h(int i) {
        Object[] objArr;
        Object obj;
        int a2 = d.a(this.f831c, this.f833e, i);
        if (a2 >= 0 && (objArr = this.f832d)[a2] != (obj = f)) {
            objArr[a2] = obj;
            this.f830b = true;
        }
    }

    public int i() {
        if (this.f830b) {
            c();
        }
        return this.f833e;
    }

    public E j(int i) {
        if (this.f830b) {
            c();
        }
        return (E) this.f832d[i];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f833e * 28);
        sb.append('{');
        for (int i = 0; i < this.f833e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(f(i));
            sb.append('=');
            E j = j(i);
            if (j != this) {
                sb.append((Object) j);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
