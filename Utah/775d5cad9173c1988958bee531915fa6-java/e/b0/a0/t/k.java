package e.b0.a0.t;

import androidx.work.WorkerParameters;
import e.b0.a0.l;

public class k implements Runnable {
    public l b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public WorkerParameters.a f1133d;

    public k(l lVar, String str, WorkerParameters.a aVar) {
        this.b = lVar;
        this.c = str;
        this.f1133d = aVar;
    }

    public void run() {
        this.b.f1029f.g(this.c, this.f1133d);
    }
}
