package f.b.a.c.e.c;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import f.b.a.c.b.l.l.k;
import f.b.a.c.f.b.b;
import f.b.a.c.i.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public final /* synthetic */ class d implements k {
    public final s2 a;
    public final List b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2489d;

    public d(s2 s2Var, List list, b bVar, String str) {
        this.a = s2Var;
        this.b = list;
        this.c = bVar;
        this.f2489d = str;
    }

    @Override // f.b.a.c.b.l.l.k
    public final void a(Object obj, Object obj2) {
        List<File> list = this.b;
        b bVar = this.c;
        String str = this.f2489d;
        q2 q2Var = (q2) obj;
        i iVar = (i) obj2;
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (File file : list) {
                arrayList.add(ParcelFileDescriptor.open(file, 268435456));
            }
            v1 v1Var = new v1(null);
            v1Var.f2509d = arrayList;
            v1Var.f2510e = bVar;
            v1Var.c = new s(arrayList, iVar);
            v1Var.f2511f = str;
            ((i1) q2Var.t()).v(v1Var);
        } catch (FileNotFoundException e2) {
            Status status = new Status(39506, e2.getMessage());
            if (status.d()) {
                iVar.a.q(null);
                return;
            }
            iVar.a.p(new f.b.a.c.b.l.b(status));
        }
    }
}
