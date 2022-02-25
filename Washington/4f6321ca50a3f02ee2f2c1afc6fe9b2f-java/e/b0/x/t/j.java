package e.b0.x.t;

import androidx.work.WorkerParameters;
import e.b0.x.l;

public class j implements Runnable {
    public l b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public WorkerParameters.a f1134d;

    public j(l lVar, String str, WorkerParameters.a aVar) {
        this.b = lVar;
        this.c = str;
        this.f1134d = aVar;
    }

    public void run() {
        this.b.f1030f.f(this.c, this.f1134d);
    }
}
