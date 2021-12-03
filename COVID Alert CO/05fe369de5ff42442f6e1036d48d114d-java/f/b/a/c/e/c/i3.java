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

public final /* synthetic */ class i3 implements k {
    public final /* synthetic */ v a;
    public final /* synthetic */ List b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2680d;

    public /* synthetic */ i3(v vVar, List list, b bVar, String str) {
        this.a = vVar;
        this.b = list;
        this.c = bVar;
        this.f2680d = str;
    }

    @Override // f.b.a.c.b.l.l.k
    public final void a(Object obj, Object obj2) {
        List<File> list = this.b;
        b bVar = this.c;
        String str = this.f2680d;
        s2 s2Var = (s2) obj;
        i iVar = (i) obj2;
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (File file : list) {
                arrayList.add(ParcelFileDescriptor.open(file, 268435456));
            }
            y1 y1Var = new y1(null);
            y1Var.f2693d = arrayList;
            y1Var.f2694e = bVar;
            y1Var.c = new s(arrayList, iVar);
            y1Var.f2695f = str;
            ((m1) s2Var.t()).G(y1Var);
        } catch (FileNotFoundException e2) {
            Status status = new Status(39506, e2.getMessage());
            if (status.d()) {
                iVar.a.r(null);
                return;
            }
            iVar.a.q(new f.b.a.c.b.l.b(status));
        }
    }
}
