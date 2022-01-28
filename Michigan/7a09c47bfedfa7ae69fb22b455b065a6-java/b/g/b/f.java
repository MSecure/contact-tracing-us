package b.g.b;

public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1477a;

    /* renamed from: b  reason: collision with root package name */
    public int f1478b;

    public f(int i) {
        if (i > 0) {
            this.f1477a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i = this.f1478b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f1477a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f1478b = i - 1;
        return t;
    }

    public boolean b(T t) {
        int i = this.f1478b;
        Object[] objArr = this.f1477a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f1478b = i + 1;
        return true;
    }
}
