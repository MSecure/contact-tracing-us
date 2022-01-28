package e.f.a;

public final class c extends Throwable {
    public c(String str) {
        super(str);
    }

    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
