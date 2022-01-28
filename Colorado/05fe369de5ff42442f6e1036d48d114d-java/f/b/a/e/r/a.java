package f.b.a.e.r;

import android.graphics.Typeface;
import f.b.a.e.p.b;
import f.b.a.e.p.c;

public final class a extends d {
    public final Typeface a;
    public final AbstractC0097a b;
    public boolean c;

    /* renamed from: f.b.a.e.r.a$a  reason: collision with other inner class name */
    public interface AbstractC0097a {
    }

    public a(AbstractC0097a aVar, Typeface typeface) {
        this.a = typeface;
        this.b = aVar;
    }

    @Override // f.b.a.e.r.d
    public void a(int i2) {
        c(this.a);
    }

    @Override // f.b.a.e.r.d
    public void b(Typeface typeface, boolean z) {
        c(typeface);
    }

    public final void c(Typeface typeface) {
        if (!this.c) {
            c cVar = ((b) this.b).a;
            a aVar = cVar.v;
            boolean z = true;
            if (aVar != null) {
                aVar.c = true;
            }
            if (cVar.s != typeface) {
                cVar.s = typeface;
            } else {
                z = false;
            }
            if (z) {
                cVar.k();
            }
        }
    }
}
