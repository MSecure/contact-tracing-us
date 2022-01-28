package c.b.a.b.e0;

import android.graphics.Typeface;
import android.text.TextPaint;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextPaint f4240a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4241b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f4242c;

    public c(b bVar, TextPaint textPaint, d dVar) {
        this.f4242c = bVar;
        this.f4240a = textPaint;
        this.f4241b = dVar;
    }

    @Override // c.b.a.b.e0.d
    public void a(int i) {
        this.f4241b.a(i);
    }

    @Override // c.b.a.b.e0.d
    public void b(Typeface typeface, boolean z) {
        this.f4242c.d(this.f4240a, typeface);
        this.f4241b.b(typeface, z);
    }
}
