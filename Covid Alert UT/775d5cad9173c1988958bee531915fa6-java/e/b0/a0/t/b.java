package e.b0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.b0.a0.f;
import e.b0.a0.l;
import e.b0.a0.s.q;
import java.util.ArrayList;
import java.util.Iterator;

public class b extends d {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1128d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f1129e;

    public b(l lVar, String str, boolean z) {
        this.c = lVar;
        this.f1128d = str;
        this.f1129e = z;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.b0.a0.t.d
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            Iterator it = ((ArrayList) ((q) workDatabase.r()).h(this.f1128d)).iterator();
            while (it.hasNext()) {
                a(this.c, (String) it.next());
            }
            workDatabase.l();
            workDatabase.g();
            if (this.f1129e) {
                l lVar = this.c;
                f.a(lVar.b, lVar.c, lVar.f1028e);
            }
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
