package b.b0.y.s;

import androidx.work.impl.WorkDatabase;
import b.b0.y.f;
import b.b0.y.k;
import java.util.UUID;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f1254c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UUID f1255d;

    public a(k kVar, UUID uuid) {
        this.f1254c = kVar;
        this.f1255d = uuid;
    }

    /* JADX INFO: finally extract failed */
    @Override // b.b0.y.s.c
    public void b() {
        WorkDatabase workDatabase = this.f1254c.f1096c;
        workDatabase.beginTransaction();
        try {
            a(this.f1254c, this.f1255d.toString());
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            k kVar = this.f1254c;
            f.b(kVar.f1095b, kVar.f1096c, kVar.f1098e);
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
