package e.f;
/* loaded from: classes.dex */
public class i<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1317f = new Object();
    public boolean b = false;
    public int[] c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f1318d;

    /* renamed from: e  reason: collision with root package name */
    public int f1319e;

    public i() {
        int e2 = d.e(10);
        this.c = new int[e2];
        this.f1318d = new Object[e2];
    }

    public void a(int i2, E e2) {
        int i3 = this.f1319e;
        if (i3 == 0 || i2 > this.c[i3 - 1]) {
            if (this.b && i3 >= this.c.length) {
                c();
            }
            int i4 = this.f1319e;
            if (i4 >= this.c.length) {
                int e3 = d.e(i4 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1318d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.c = iArr;
                this.f1318d = objArr;
            }
            this.c[i4] = i2;
            this.f1318d[i4] = e2;
            this.f1319e = i4 + 1;
            return;
        }
        g(i2, e2);
    }

    /* renamed from: b */
    public i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            iVar.c = (int[]) this.c.clone();
            iVar.f1318d = (Object[]) this.f1318d.clone();
            return iVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void c() {
        int i2 = this.f1319e;
        int[] iArr = this.c;
        Object[] objArr = this.f1318d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1317f) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.b = false;
        this.f1319e = i3;
    }

    public E d(int i2) {
        return e(i2, null);
    }

    public E e(int i2, E e2) {
        int a = d.a(this.c, this.f1319e, i2);
        if (a >= 0) {
            Object[] objArr = this.f1318d;
            if (objArr[a] != f1317f) {
                return (E) objArr[a];
            }
        }
        return e2;
    }

    public int f(int i2) {
        if (this.b) {
            c();
        }
        return this.c[i2];
    }

    public void g(int i2, E e2) {
        int a = d.a(this.c, this.f1319e, i2);
        if (a >= 0) {
            this.f1318d[a] = e2;
            return;
        }
        int i3 = ~a;
        int i4 = this.f1319e;
        if (i3 < i4) {
            Object[] objArr = this.f1318d;
            if (objArr[i3] == f1317f) {
                this.c[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.b && i4 >= this.c.length) {
            c();
            i3 = ~d.a(this.c, this.f1319e, i2);
        }
        int i5 = this.f1319e;
        if (i5 >= this.c.length) {
            int e3 = d.e(i5 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1318d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = iArr;
            this.f1318d = objArr2;
        }
        int i6 = this.f1319e;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f1318d;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f1319e - i3);
        }
        this.c[i3] = i2;
        this.f1318d[i3] = e2;
        this.f1319e++;
    }

    public int h() {
        if (this.b) {
            c();
        }
        return this.f1319e;
    }

    public E i(int i2) {
        if (this.b) {
            c();
        }
        return (E) this.f1318d[i2];
    }

    @Override // java.lang.Object
    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1319e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1319e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(f(i2));
            sb.append('=');
            E i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
