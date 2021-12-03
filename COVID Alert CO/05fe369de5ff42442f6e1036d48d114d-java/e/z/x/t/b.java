package e.z.x.t;

import androidx.work.impl.WorkDatabase;
import e.z.x.f;
import e.z.x.l;
import e.z.x.s.q;
import java.util.ArrayList;
import java.util.Iterator;

public class b extends c {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2004d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f2005e;

    public b(l lVar, String str, boolean z) {
        this.c = lVar;
        this.f2004d = str;
        this.f2005e = z;
    }

    /* JADX INFO: finally extract failed */
    @Override // e.z.x.t.c
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            Iterator it = ((ArrayList) ((q) workDatabase.r()).h(this.f2004d)).iterator();
            while (it.hasNext()) {
                a(this.c, (String) it.next());
            }
            workDatabase.l();
            workDatabase.g();
            if (this.f2005e) {
                l lVar = this.c;
                f.a(lVar.b, lVar.c, lVar.f1904e);
            }
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
