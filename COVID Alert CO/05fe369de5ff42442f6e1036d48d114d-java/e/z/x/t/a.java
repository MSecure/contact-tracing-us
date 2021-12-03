package e.z.x.t;

import androidx.work.impl.WorkDatabase;
import e.z.x.f;
import e.z.x.l;
import java.util.UUID;

public class a extends c {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UUID f2003d;

    public a(l lVar, UUID uuid) {
        this.c = lVar;
        this.f2003d = uuid;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.z.x.t.c
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            a(this.c, this.f2003d.toString());
            workDatabase.l();
            workDatabase.g();
            l lVar = this.c;
            f.a(lVar.b, lVar.c, lVar.f1904e);
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
