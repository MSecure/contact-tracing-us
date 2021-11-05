package b.i.k;

public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1843a;

    /* renamed from: b  reason: collision with root package name */
    public int f1844b;

    public b(int i) {
        if (i > 0) {
            this.f1843a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i = this.f1844b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f1843a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f1844b = i - 1;
        return t;
    }

    public boolean b(T t) {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.f1844b) {
                z = false;
                break;
            } else if (this.f1843a[i] == t) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            int i2 = this.f1844b;
            Object[] objArr = this.f1843a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f1844b = i2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
