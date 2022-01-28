package f.b.a.a.a.a0;

import android.content.Context;
import e.b0.q;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.io.File;
import java.util.Objects;

public final /* synthetic */ class b implements i {
    public final /* synthetic */ e a;
    public final /* synthetic */ Context b;

    public /* synthetic */ b(e eVar, Context context) {
        this.a = eVar;
        this.b = context;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        e eVar = this.a;
        Context context = this.b;
        q.b.c cVar = (q.b.c) obj;
        Objects.requireNonNull(eVar);
        File file = new File(context.getApplicationInfo().dataDir);
        boolean z = false;
        if (file.exists()) {
            String[] list = file.list();
            boolean z2 = false;
            for (String str : list) {
                if (!str.equals("no_backup")) {
                    z2 = eVar.a(new File(file, str));
                }
            }
            z = z2;
        }
        return f.b.a.c.b.o.b.Q0(Boolean.valueOf(z));
    }
}
