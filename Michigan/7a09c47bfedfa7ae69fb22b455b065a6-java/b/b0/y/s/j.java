package b.b0.y.s;

import androidx.work.WorkerParameters;
import b.b0.y.k;

public class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public k f1273b;

    /* renamed from: c  reason: collision with root package name */
    public String f1274c;

    /* renamed from: d  reason: collision with root package name */
    public WorkerParameters.a f1275d;

    public j(k kVar, String str, WorkerParameters.a aVar) {
        this.f1273b = kVar;
        this.f1274c = str;
        this.f1275d = aVar;
    }

    public void run() {
        this.f1273b.f1099f.g(this.f1274c, this.f1275d);
    }
}
