package e.j.g;

import android.graphics.Typeface;
import e.j.b.b.h;
import e.j.c.e;
/* loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ m b;
    public final /* synthetic */ Typeface c;

    public a(c cVar, m mVar, Typeface typeface) {
        this.b = mVar;
        this.c = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.b;
        Typeface typeface = this.c;
        h.c cVar = ((e.a) mVar).a;
        if (cVar != null) {
            cVar.e(typeface);
        }
    }
}
