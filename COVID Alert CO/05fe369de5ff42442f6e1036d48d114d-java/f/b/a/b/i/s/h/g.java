package f.b.a.b.i.s.h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import f.b.a.b.i.i;
import f.b.a.b.i.s.i.c;
import f.b.a.b.i.t.b;

public final /* synthetic */ class g implements Runnable {
    public final l b;
    public final i c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2548d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f2549e;

    public g(l lVar, i iVar, int i2, Runnable runnable) {
        this.b = lVar;
        this.c = iVar;
        this.f2548d = i2;
        this.f2549e = runnable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.f2552d.a(r1, r2 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r3.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0044 */
    public void run() {
        l lVar = this.b;
        i iVar = this.c;
        int i2 = this.f2548d;
        Runnable runnable = this.f2549e;
        b bVar = lVar.f2554f;
        c cVar = lVar.c;
        cVar.getClass();
        bVar.c(new j(cVar));
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) lVar.a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
            lVar.f2554f.c(new k(lVar, iVar, i2));
        } else {
            lVar.a(iVar, i2);
        }
        runnable.run();
    }
}
