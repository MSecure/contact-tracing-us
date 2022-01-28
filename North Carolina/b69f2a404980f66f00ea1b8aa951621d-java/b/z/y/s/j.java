package b.z.y.s;

import androidx.work.WorkerParameters;
import b.z.y.k;

public class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public k f2126b;

    /* renamed from: c  reason: collision with root package name */
    public String f2127c;

    /* renamed from: d  reason: collision with root package name */
    public WorkerParameters.a f2128d;

    public j(k kVar, String str, WorkerParameters.a aVar) {
        this.f2126b = kVar;
        this.f2127c = str;
        this.f2128d = aVar;
    }

    public void run() {
        this.f2126b.f.g(this.f2127c, this.f2128d);
    }
}
