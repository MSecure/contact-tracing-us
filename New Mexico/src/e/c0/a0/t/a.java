package e.c0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.c0.a0.f;
import e.c0.a0.l;
import java.util.UUID;
/* loaded from: classes.dex */
public class a extends d {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UUID f1206d;

    public a(l lVar, UUID uuid) {
        this.c = lVar;
        this.f1206d = uuid;
    }

    /* JADX WARN: Finally extract failed */
    @Override // e.c0.a0.t.d
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            a(this.c, this.f1206d.toString());
            workDatabase.l();
            workDatabase.g();
            l lVar = this.c;
            f.a(lVar.b, lVar.c, lVar.f1107e);
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
