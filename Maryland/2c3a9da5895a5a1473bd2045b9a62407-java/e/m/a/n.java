package e.m.a;

import androidx.activity.result.ActivityResultRegistry;
import e.a.e.b;
import e.c.a.c.a;
import e.m.a.l;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class n extends l.e {
    public final /* synthetic */ a a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ e.a.e.f.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f1661d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1662e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(l lVar, a aVar, AtomicReference atomicReference, e.a.e.f.a aVar2, b bVar) {
        super(null);
        this.f1662e = lVar;
        this.a = aVar;
        this.b = atomicReference;
        this.c = aVar2;
        this.f1661d = bVar;
    }

    @Override // e.m.a.l.e
    public void a() {
        l lVar = this.f1662e;
        Objects.requireNonNull(lVar);
        this.b.set(((ActivityResultRegistry) this.a.a(null)).d("fragment_" + lVar.f1631f + "_rq#" + lVar.U.getAndIncrement(), this.f1662e, this.c, this.f1661d));
    }
}
