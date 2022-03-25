package e.c0.x.t;

import androidx.work.impl.WorkDatabase;
import e.c0.x.f;
import e.c0.x.l;
import java.util.UUID;

public class a extends c {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UUID f1148d;

    public a(l lVar, UUID uuid) {
        this.c = lVar;
        this.f1148d = uuid;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.c0.x.t.c
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            a(this.c, this.f1148d.toString());
            workDatabase.l();
            workDatabase.g();
            l lVar = this.c;
            f.a(lVar.b, lVar.c, lVar.f1049e);
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
