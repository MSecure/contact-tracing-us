package h.a;

public class e1 extends RuntimeException {
    public final c1 b;
    public final boolean c = true;

    public e1(c1 c1Var) {
        super(c1.b(c1Var), c1Var.c);
        this.b = c1Var;
        fillInStackTrace();
    }

    public synchronized Throwable fillInStackTrace() {
        return this.c ? super.fillInStackTrace() : this;
    }
}
