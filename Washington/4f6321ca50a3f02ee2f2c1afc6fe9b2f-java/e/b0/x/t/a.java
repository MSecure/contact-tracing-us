package e.b0.x.t;

import androidx.work.impl.WorkDatabase;
import e.b0.x.f;
import e.b0.x.l;
import java.util.UUID;

public class a extends c {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UUID f1128d;

    public a(l lVar, UUID uuid) {
        this.c = lVar;
        this.f1128d = uuid;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.b0.x.t.c
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            a(this.c, this.f1128d.toString());
            workDatabase.l();
            workDatabase.g();
            l lVar = this.c;
            f.a(lVar.b, lVar.c, lVar.f1029e);
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
