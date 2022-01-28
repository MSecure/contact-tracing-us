package e.i.f;

import android.graphics.Typeface;
import e.i.b.b.h;
import e.i.c.e;

public class a implements Runnable {
    public final /* synthetic */ m b;
    public final /* synthetic */ Typeface c;

    public a(c cVar, m mVar, Typeface typeface) {
        this.b = mVar;
        this.c = typeface;
    }

    public void run() {
        m mVar = this.b;
        Typeface typeface = this.c;
        h.c cVar = ((e.a) mVar).a;
        if (cVar != null) {
            cVar.e(typeface);
        }
    }
}
