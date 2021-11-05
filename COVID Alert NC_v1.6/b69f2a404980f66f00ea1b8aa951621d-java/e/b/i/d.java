package e.b.i;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f4879a;

    /* renamed from: b  reason: collision with root package name */
    public String f4880b;

    public d(int i, String str) {
        this.f4879a = i;
        this.f4880b = str;
    }

    public d(int i, String str, Object... objArr) {
        this.f4880b = String.format(str, objArr);
        this.f4879a = i;
    }

    public String toString() {
        return this.f4879a + ": " + this.f4880b;
    }
}
