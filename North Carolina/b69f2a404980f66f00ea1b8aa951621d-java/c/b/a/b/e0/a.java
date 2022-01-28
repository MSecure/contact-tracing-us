package c.b.a.b.e0;

import android.graphics.Typeface;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f2955a;

    /* renamed from: b  reason: collision with root package name */
    public final AbstractC0064a f2956b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2957c;

    /* renamed from: c.b.a.b.e0.a$a  reason: collision with other inner class name */
    public interface AbstractC0064a {
        void a(Typeface typeface);
    }

    public a(AbstractC0064a aVar, Typeface typeface) {
        this.f2955a = typeface;
        this.f2956b = aVar;
    }

    @Override // c.b.a.b.e0.d
    public void a(int i) {
        Typeface typeface = this.f2955a;
        if (!this.f2957c) {
            this.f2956b.a(typeface);
        }
    }

    @Override // c.b.a.b.e0.d
    public void b(Typeface typeface, boolean z) {
        if (!this.f2957c) {
            this.f2956b.a(typeface);
        }
    }
}
