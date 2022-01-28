package f.b.a.e.s;

import android.graphics.Typeface;
import f.b.a.e.q.b;
import f.b.a.e.q.c;

public final class a extends d {
    public final Typeface a;
    public final AbstractC0096a b;
    public boolean c;

    /* renamed from: f.b.a.e.s.a$a  reason: collision with other inner class name */
    public interface AbstractC0096a {
    }

    public a(AbstractC0096a aVar, Typeface typeface) {
        this.a = typeface;
        this.b = aVar;
    }

    @Override // f.b.a.e.s.d
    public void a(int i2) {
        c(this.a);
    }

    @Override // f.b.a.e.s.d
    public void b(Typeface typeface, boolean z) {
        c(typeface);
    }

    public final void c(Typeface typeface) {
        if (!this.c) {
            c cVar = ((b) this.b).a;
            a aVar = cVar.w;
            boolean z = true;
            if (aVar != null) {
                aVar.c = true;
            }
            if (cVar.t != typeface) {
                cVar.t = typeface;
            } else {
                z = false;
            }
            if (z) {
                cVar.k();
            }
        }
    }
}
