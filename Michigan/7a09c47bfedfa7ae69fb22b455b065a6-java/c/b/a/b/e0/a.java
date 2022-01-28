package c.b.a.b.e0;

import android.graphics.Typeface;
import c.b.a.b.c0.b;
import c.b.a.b.c0.c;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f4228a;

    /* renamed from: b  reason: collision with root package name */
    public final AbstractC0073a f4229b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4230c;

    /* renamed from: c.b.a.b.e0.a$a  reason: collision with other inner class name */
    public interface AbstractC0073a {
    }

    public a(AbstractC0073a aVar, Typeface typeface) {
        this.f4228a = typeface;
        this.f4229b = aVar;
    }

    @Override // c.b.a.b.e0.d
    public void a(int i) {
        c(this.f4228a);
    }

    @Override // c.b.a.b.e0.d
    public void b(Typeface typeface, boolean z) {
        c(typeface);
    }

    public final void c(Typeface typeface) {
        if (!this.f4230c) {
            c cVar = ((b) this.f4229b).f4188a;
            a aVar = cVar.v;
            boolean z = true;
            if (aVar != null) {
                aVar.f4230c = true;
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
