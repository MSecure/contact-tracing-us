package b.i.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1764a;

    /* renamed from: b  reason: collision with root package name */
    public AbstractC0030a f1765b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1766c;

    /* renamed from: b.i.h.a$a  reason: collision with other inner class name */
    public interface AbstractC0030a {
        void a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.f1766c = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0022, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.f1766c = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0028, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 == null) goto L_0x0022;
     */
    public void a() {
        synchronized (this) {
            if (!this.f1764a) {
                this.f1764a = true;
                this.f1766c = true;
                AbstractC0030a aVar = this.f1765b;
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:20:0x0001, LOOP_START, SYNTHETIC] */
    public void b(AbstractC0030a aVar) {
        synchronized (this) {
            while (this.f1766c) {
                wait();
            }
            if (this.f1765b != aVar) {
                this.f1765b = aVar;
                if (this.f1764a) {
                    aVar.a();
                }
            }
        }
    }
}
