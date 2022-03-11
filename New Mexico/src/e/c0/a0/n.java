package e.c0.a0;

import androidx.work.ListenableWorker;
import e.c0.a0.t.s.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* loaded from: classes.dex */
public class n implements Runnable {
    public final /* synthetic */ c b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1113d;

    public n(o oVar, c cVar, String str) {
        this.f1113d = oVar;
        this.b = cVar;
        this.c = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [e.c0.a0.o] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // java.lang.Runnable
    public void run() {
        Throwable e2;
        try {
            int i2 = 1;
            i2 = 1;
            i2 = 1;
            try {
                ListenableWorker.a aVar = (ListenableWorker.a) this.b.get();
                if (aVar == null) {
                    e.c0.n.c().b(o.u, String.format("%s returned a null result. Treating it as a failure.", this.f1113d.f1116f.c), new Throwable[0]);
                } else {
                    e.c0.n.c().a(o.u, String.format("%s returned a %s result.", this.f1113d.f1116f.c, aVar), new Throwable[0]);
                    this.f1113d.f1119i = aVar;
                }
            } catch (InterruptedException e3) {
                e2 = e3;
                e.c0.n c = e.c0.n.c();
                String str = o.u;
                Object[] objArr = new Object[i2];
                objArr[0] = this.c;
                String format = String.format("%s failed because it threw an exception/error", objArr);
                Throwable[] thArr = new Throwable[i2];
                thArr[0] = e2;
                c.b(str, format, thArr);
            } catch (CancellationException e4) {
                e.c0.n c2 = e.c0.n.c();
                String str2 = o.u;
                Object[] objArr2 = new Object[i2];
                objArr2[0] = this.c;
                String format2 = String.format("%s was cancelled", objArr2);
                Throwable[] thArr2 = new Throwable[i2];
                thArr2[0] = e4;
                c2.d(str2, format2, thArr2);
            } catch (ExecutionException e5) {
                e2 = e5;
                e.c0.n c3 = e.c0.n.c();
                String str3 = o.u;
                Object[] objArr3 = new Object[i2];
                objArr3[0] = this.c;
                String format3 = String.format("%s failed because it threw an exception/error", objArr3);
                Throwable[] thArr3 = new Throwable[i2];
                thArr3[0] = e2;
                c3.b(str3, format3, thArr3);
            }
        } finally {
            this.f1113d.c();
        }
    }
}
