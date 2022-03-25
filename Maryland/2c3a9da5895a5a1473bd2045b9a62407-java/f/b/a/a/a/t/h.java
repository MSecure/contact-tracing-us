package f.b.a.a.a.t;

import androidx.work.ListenableWorker;
import f.b.b.a.g;
import f.b.b.f.a.u;

public final /* synthetic */ class h implements g {
    public final /* synthetic */ String a;

    public /* synthetic */ h(String str) {
        this.a = str;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        u uVar = (u) obj;
        String.format("Workflow for metric %s finished successfully.", this.a);
        return new ListenableWorker.a.c();
    }
}
