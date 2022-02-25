package e.i.f;

import android.os.Handler;
import e.i.b.b.g;
import e.i.f.e;
import e.i.f.f;

public class c implements f.c<e.d> {
    public final /* synthetic */ g a;
    public final /* synthetic */ Handler b;

    public c(g gVar, Handler handler) {
        this.a = gVar;
        this.b = handler;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.i.f.f.c
    public void a(e.d dVar) {
        g gVar;
        int i2;
        e.d dVar2 = dVar;
        if (dVar2 == null) {
            gVar = this.a;
            i2 = 1;
        } else {
            i2 = dVar2.b;
            if (i2 == 0) {
                this.a.b(dVar2.a, this.b);
                return;
            }
            gVar = this.a;
        }
        gVar.a(i2, this.b);
    }
}
