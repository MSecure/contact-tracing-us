package e.b0.x.t;

import androidx.work.impl.WorkDatabase;
import e.b0.x.f;
import e.b0.x.l;
import e.b0.x.s.q;
import java.util.ArrayList;
import java.util.Iterator;

public class b extends c {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1130d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f1131e;

    public b(l lVar, String str, boolean z) {
        this.c = lVar;
        this.f1130d = str;
        this.f1131e = z;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.b0.x.t.c
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            Iterator it = ((ArrayList) ((q) workDatabase.r()).h(this.f1130d)).iterator();
            while (it.hasNext()) {
                a(this.c, (String) it.next());
            }
            workDatabase.l();
            workDatabase.g();
            if (this.f1131e) {
                l lVar = this.c;
                f.a(lVar.b, lVar.c, lVar.f1030e);
            }
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
