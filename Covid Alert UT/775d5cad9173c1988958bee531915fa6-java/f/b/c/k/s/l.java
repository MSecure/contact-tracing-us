package f.b.c.k.s;

import android.content.Context;
import f.b.a.c.b.o.b;
import f.b.a.c.i.i;
import f.b.c.k.h;
import f.b.c.k.r.f;
import java.util.concurrent.ExecutionException;

public final /* synthetic */ class l implements Runnable {
    public final n b;
    public final i c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f3305d;

    /* renamed from: e  reason: collision with root package name */
    public final h f3306e;

    public l(n nVar, i iVar, Context context, h hVar) {
        this.b = nVar;
        this.c = iVar;
        this.f3305d = context;
        this.f3306e = hVar;
    }

    public void run() {
        n nVar = this.b;
        i iVar = this.c;
        try {
            nVar.a(this.f3305d, (f) b.j(iVar.a), this.f3306e);
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }
}
