package e.g.a;
/* loaded from: classes.dex */
public final class c extends Throwable {
    public c(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
