package e.b.j;

public class h extends IllegalStateException {
    public h(String str, Object... objArr) {
        super(String.format(str, objArr));
    }
}
