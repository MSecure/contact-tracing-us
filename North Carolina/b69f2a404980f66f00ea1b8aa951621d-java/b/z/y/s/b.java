package b.z.y.s;

import androidx.work.impl.WorkDatabase;
import b.z.y.f;
import b.z.y.k;
import b.z.y.r.r;
import java.util.ArrayList;
import java.util.Iterator;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f2109c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2110d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f2111e;

    public b(k kVar, String str, boolean z) {
        this.f2109c = kVar;
        this.f2110d = str;
        this.f2111e = z;
    }

    /* JADX INFO: finally extract failed */
    @Override // b.z.y.s.c
    public void b() {
        WorkDatabase workDatabase = this.f2109c.f1971c;
        workDatabase.beginTransaction();
        try {
            Iterator it = ((ArrayList) ((r) workDatabase.h()).h(this.f2110d)).iterator();
            while (it.hasNext()) {
                a(this.f2109c, (String) it.next());
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (this.f2111e) {
                k kVar = this.f2109c;
                f.b(kVar.f1970b, kVar.f1971c, kVar.f1973e);
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
