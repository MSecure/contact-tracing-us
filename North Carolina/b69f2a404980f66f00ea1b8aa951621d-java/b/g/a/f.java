package b.g.a;

public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f881a;

    /* renamed from: b  reason: collision with root package name */
    public int f882b;

    public f(int i) {
        if (i > 0) {
            this.f881a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i = this.f882b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f881a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f882b = i - 1;
        return t;
    }

    public boolean b(T t) {
        int i = this.f882b;
        Object[] objArr = this.f881a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f882b = i + 1;
        return true;
    }
}
