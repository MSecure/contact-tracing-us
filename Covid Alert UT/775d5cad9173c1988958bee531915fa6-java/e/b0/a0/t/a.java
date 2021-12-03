package e.b0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.b0.a0.f;
import e.b0.a0.l;
import java.util.UUID;

public class a extends d {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UUID f1127d;

    public a(l lVar, UUID uuid) {
        this.c = lVar;
        this.f1127d = uuid;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.b0.a0.t.d
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            a(this.c, this.f1127d.toString());
            workDatabase.l();
            workDatabase.g();
            l lVar = this.c;
            f.a(lVar.b, lVar.c, lVar.f1028e);
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
