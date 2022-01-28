package b.i.k;

public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1135a;

    /* renamed from: b  reason: collision with root package name */
    public int f1136b;

    public c(int i) {
        if (i > 0) {
            this.f1135a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i = this.f1136b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f1135a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f1136b = i - 1;
        return t;
    }

    public boolean b(T t) {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.f1136b) {
                z = false;
                break;
            } else if (this.f1135a[i] == t) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            int i2 = this.f1136b;
            Object[] objArr = this.f1135a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f1136b = i2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
