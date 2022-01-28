package f.b.c.i;

public final class c extends RuntimeException {
    public c(String str) {
        super(str);
    }

    public c(String str, Exception exc) {
        super(str, exc);
    }
}
