package l.b.a;

public class a extends RuntimeException {
    public a(String str) {
        super(str);
    }

    public a(String str, Throwable th) {
        super(str, th);
    }
}
