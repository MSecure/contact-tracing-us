package e.i.f;

import e.e.h;
import e.i.f.e;
import e.i.f.f;
import java.util.ArrayList;

public class d implements f.c<e.d> {
    public final /* synthetic */ String a;

    public d(String str) {
        this.a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0 >= r2.size()) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r2.get(r0).a(r5);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = 0;
     */
    /* renamed from: b */
    public void a(e.d dVar) {
        synchronized (e.c) {
            h<String, ArrayList<f.c<e.d>>> hVar = e.f1445d;
            ArrayList<f.c<e.d>> arrayList = hVar.get(this.a);
            if (arrayList != null) {
                hVar.remove(this.a);
            }
        }
    }
}
