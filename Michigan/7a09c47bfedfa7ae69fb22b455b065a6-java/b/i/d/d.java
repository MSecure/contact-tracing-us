package b.i.d;

public class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1664c;

    public d(Object obj, Object obj2) {
        this.f1663b = obj;
        this.f1664c = obj2;
    }

    public void run() {
        try {
            if (c.f1650d != null) {
                c.f1650d.invoke(this.f1663b, this.f1664c, Boolean.FALSE, "AppCompat recreation");
                return;
            }
            c.f1651e.invoke(this.f1663b, this.f1664c, Boolean.FALSE);
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable unused) {
        }
    }
}
