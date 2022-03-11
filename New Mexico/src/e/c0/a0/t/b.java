package e.c0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.c0.a0.f;
import e.c0.a0.l;
import e.c0.a0.s.q;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends d {
    public final /* synthetic */ l c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1207d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f1208e;

    public b(l lVar, String str, boolean z) {
        this.c = lVar;
        this.f1207d = str;
        this.f1208e = z;
    }

    /* JADX WARN: Finally extract failed */
    @Override // e.c0.a0.t.d
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            Iterator it = ((ArrayList) ((q) workDatabase.r()).h(this.f1207d)).iterator();
            while (it.hasNext()) {
                a(this.c, (String) it.next());
            }
            workDatabase.l();
            workDatabase.g();
            if (this.f1208e) {
                l lVar = this.c;
                f.a(lVar.b, lVar.c, lVar.f1107e);
            }
        } catch (Throwable th) {
            workDatabase.g();
            throw th;
        }
    }
}
