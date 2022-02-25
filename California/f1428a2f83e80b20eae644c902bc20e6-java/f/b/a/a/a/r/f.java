package f.b.a.a.a.r;

import androidx.work.ListenableWorker;
import f.b.b.a.g;
import f.b.b.f.a.u;

public final /* synthetic */ class f implements g {
    public final /* synthetic */ f.b.a.a.a.r.c0.f a;
    public final /* synthetic */ String b;

    public /* synthetic */ f(f.b.a.a.a.r.c0.f fVar, String str) {
        this.a = fVar;
        this.b = str;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        f.b.a.a.a.r.c0.f fVar = this.a;
        String str = this.b;
        u uVar = (u) obj;
        fVar.b();
        String.format("Workflow for metric %s finished successfully.", str);
        return new ListenableWorker.a.c();
    }
}
