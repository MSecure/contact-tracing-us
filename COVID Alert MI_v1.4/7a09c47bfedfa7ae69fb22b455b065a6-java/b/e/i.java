package b.e;

public class i<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1414f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f1415b = false;

    /* renamed from: c  reason: collision with root package name */
    public int[] f1416c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f1417d;

    /* renamed from: e  reason: collision with root package name */
    public int f1418e;

    public i() {
        int e2 = d.e(10);
        this.f1416c = new int[e2];
        this.f1417d = new Object[e2];
    }

    public void a(int i, E e2) {
        int i2 = this.f1418e;
        if (i2 == 0 || i > this.f1416c[i2 - 1]) {
            if (this.f1415b && this.f1418e >= this.f1416c.length) {
                c();
            }
            int i3 = this.f1418e;
            if (i3 >= this.f1416c.length) {
                int e3 = d.e(i3 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.f1416c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1417d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1416c = iArr;
                this.f1417d = objArr;
            }
            this.f1416c[i3] = i;
            this.f1417d[i3] = e2;
            this.f1418e = i3 + 1;
            return;
        }
        g(i, e2);
    }

    /* renamed from: b */
    public i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            iVar.f1416c = (int[]) this.f1416c.clone();
            iVar.f1417d = (Object[]) this.f1417d.clone();
            return iVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void c() {
        int i = this.f1418e;
        int[] iArr = this.f1416c;
        Object[] objArr = this.f1417d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1414f) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1415b = false;
        this.f1418e = i2;
    }

    public E d(int i) {
        return e(i, null);
    }

    public E e(int i, E e2) {
        int a2 = d.a(this.f1416c, this.f1418e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f1417d;
            if (objArr[a2] != f1414f) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public int f(int i) {
        if (this.f1415b) {
            c();
        }
        return this.f1416c[i];
    }

    public void g(int i, E e2) {
        int a2 = d.a(this.f1416c, this.f1418e, i);
        if (a2 >= 0) {
            this.f1417d[a2] = e2;
            return;
        }
        int i2 = ~a2;
        if (i2 < this.f1418e) {
            Object[] objArr = this.f1417d;
            if (objArr[i2] == f1414f) {
                this.f1416c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1415b && this.f1418e >= this.f1416c.length) {
            c();
            i2 = ~d.a(this.f1416c, this.f1418e, i);
        }
        int i3 = this.f1418e;
        if (i3 >= this.f1416c.length) {
            int e3 = d.e(i3 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f1416c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1417d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1416c = iArr;
            this.f1417d = objArr2;
        }
        int i4 = this.f1418e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1416c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1417d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1418e - i2);
        }
        this.f1416c[i2] = i;
        this.f1417d[i2] = e2;
        this.f1418e++;
    }

    public int h() {
        if (this.f1415b) {
            c();
        }
        return this.f1418e;
    }

    public E i(int i) {
        if (this.f1415b) {
            c();
        }
        return (E) this.f1417d[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1418e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1418e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(f(i));
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
