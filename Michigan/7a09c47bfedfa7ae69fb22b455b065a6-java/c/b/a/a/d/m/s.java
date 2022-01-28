package c.b.a.a.d.m;

import android.content.Intent;
import c.b.a.a.d.k.o.j;

public final class s extends p {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f3153b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f3154c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3155d = 2;

    public s(Intent intent, j jVar) {
        this.f3153b = intent;
        this.f3154c = jVar;
    }

    @Override // c.b.a.a.d.m.p
    public final void a() {
        Intent intent = this.f3153b;
        if (intent != null) {
            this.f3154c.startActivityForResult(intent, this.f3155d);
        }
    }
}
