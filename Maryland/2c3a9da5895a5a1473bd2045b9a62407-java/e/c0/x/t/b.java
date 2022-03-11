package e.c0.x.t;

import androidx.work.impl.WorkDatabase;
import e.c0.x.f;
import e.c0.x.l;
import e.c0.x.s.q;
import java.util.ArrayList;
import java.util.Iterator;

public class b extends c {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1149d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f1150e;

    public b(l lVar, String str, boolean z) {
        this.c = lVar;
        this.f1149d = str;
        this.f1150e = z;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.c0.x.t.c
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            Iterator it = ((ArrayList) ((q) workDatabase.r()).h(this.f1149d)).iterator();
            while (it.hasNext()) {
                a(this.c, (String) it.next());
            }
            workDatabase.l();
            workDatabase.g();
            if (this.f1150e) {
                l lVar = this.c;
                f.a(lVar.b, lVar.c, lVar.f1049e);
            }
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
