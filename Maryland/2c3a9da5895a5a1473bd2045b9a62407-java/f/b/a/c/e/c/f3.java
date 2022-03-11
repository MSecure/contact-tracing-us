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

public final /* synthetic */ class f3 implements k {
    public final t a;
    public final List b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2579d;

    public f3(t tVar, List list, b bVar, String str) {
        this.a = tVar;
        this.b = list;
        this.c = bVar;
        this.f2579d = str;
    }

    @Override // f.b.a.c.b.l.l.k
    public final void a(Object obj, Object obj2) {
        List<File> list = this.b;
        b bVar = this.c;
        String str = this.f2579d;
        k2 k2Var = (k2) obj;
        i iVar = (i) obj2;
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (File file : list) {
                arrayList.add(ParcelFileDescriptor.open(file, 268435456));
            }
            w1 w1Var = new w1(null);
            w1Var.f2599d = arrayList;
            w1Var.f2600e = bVar;
            w1Var.c = new q(arrayList, iVar);
            w1Var.f2601f = str;
            ((k1) k2Var.t()).v(w1Var);
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
