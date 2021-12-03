package e.z.x.t;

import androidx.work.WorkerParameters;
import e.z.x.l;

public class j implements Runnable {
    public l b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public WorkerParameters.a f2009d;

    public j(l lVar, String str, WorkerParameters.a aVar) {
        this.b = lVar;
        this.c = str;
        this.f2009d = aVar;
    }

    public void run() {
        this.b.f1905f.f(this.c, this.f2009d);
    }
}
