package e.m.a;

import androidx.activity.result.ActivityResultRegistry;
import e.a.e.b;
import e.c.a.c.a;
import e.m.a.m;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class n extends m.f {
    public final /* synthetic */ a a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ e.a.e.f.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f1483d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1484e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(m mVar, a aVar, AtomicReference atomicReference, e.a.e.f.a aVar2, b bVar) {
        super(null);
        this.f1484e = mVar;
        this.a = aVar;
        this.b = atomicReference;
        this.c = aVar2;
        this.f1483d = bVar;
    }

    @Override // e.m.a.m.f
    public void a() {
        m mVar = this.f1484e;
        Objects.requireNonNull(mVar);
        this.b.set(((ActivityResultRegistry) this.a.a(null)).d("fragment_" + mVar.f1453f + "_rq#" + mVar.T.getAndIncrement(), this.f1484e, this.c, this.f1483d));
    }
}
