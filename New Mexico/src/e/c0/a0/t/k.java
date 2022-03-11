package e.c0.a0.t;

import androidx.work.WorkerParameters;
import e.c0.a0.l;
/* loaded from: classes.dex */
public class k implements Runnable {
    public l b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public WorkerParameters.a f1212d;

    public k(l lVar, String str, WorkerParameters.a aVar) {
        this.b = lVar;
        this.c = str;
        this.f1212d = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f1108f.g(this.c, this.f1212d);
    }
}
