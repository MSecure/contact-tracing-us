package c.b.a.a.c.l;

import android.content.Intent;
import c.b.a.a.c.k.o.j;

public final class u extends e {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f2485b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f2486c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2487d;

    public u(Intent intent, j jVar, int i) {
        this.f2485b = intent;
        this.f2486c = jVar;
        this.f2487d = i;
    }

    @Override // c.b.a.a.c.l.e
    public final void a() {
        Intent intent = this.f2485b;
        if (intent != null) {
            this.f2486c.startActivityForResult(intent, this.f2487d);
        }
    }
}
