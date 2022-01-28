package b.z.y.s;

import androidx.work.impl.WorkDatabase;
import b.z.y.f;
import b.z.y.k;
import java.util.UUID;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f2107c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UUID f2108d;

    public a(k kVar, UUID uuid) {
        this.f2107c = kVar;
        this.f2108d = uuid;
    }

    /* JADX INFO: finally extract failed */
    @Override // b.z.y.s.c
    public void b() {
        WorkDatabase workDatabase = this.f2107c.f1971c;
        workDatabase.beginTransaction();
        try {
            a(this.f2107c, this.f2108d.toString());
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            k kVar = this.f2107c;
            f.b(kVar.f1970b, kVar.f1971c, kVar.f1973e);
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
