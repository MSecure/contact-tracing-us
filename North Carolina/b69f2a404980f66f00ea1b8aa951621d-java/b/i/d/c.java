package b.i.d;

public class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f976b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f977c;

    public c(Object obj, Object obj2) {
        this.f976b = obj;
        this.f977c = obj2;
    }

    public void run() {
        try {
            if (b.f966d != null) {
                b.f966d.invoke(this.f976b, this.f977c, Boolean.FALSE, "AppCompat recreation");
                return;
            }
            b.f967e.invoke(this.f976b, this.f977c, Boolean.FALSE);
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable unused) {
        }
    }
}
