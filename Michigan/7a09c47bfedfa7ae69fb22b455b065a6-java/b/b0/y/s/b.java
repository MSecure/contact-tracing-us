package b.b0.y.s;

import androidx.work.impl.WorkDatabase;
import b.b0.y.f;
import b.b0.y.k;
import b.b0.y.r.r;
import java.util.ArrayList;
import java.util.Iterator;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f1256c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1257d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f1258e;

    public b(k kVar, String str, boolean z) {
        this.f1256c = kVar;
        this.f1257d = str;
        this.f1258e = z;
    }

    /* JADX INFO: finally extract failed */
    @Override // b.b0.y.s.c
    public void b() {
        WorkDatabase workDatabase = this.f1256c.f1096c;
        workDatabase.beginTransaction();
        try {
            Iterator it = ((ArrayList) ((r) workDatabase.h()).h(this.f1257d)).iterator();
            while (it.hasNext()) {
                a(this.f1256c, (String) it.next());
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (this.f1258e) {
                k kVar = this.f1256c;
                f.b(kVar.f1095b, kVar.f1096c, kVar.f1098e);
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
