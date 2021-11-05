package c.b.a.b.e0;

import android.graphics.Typeface;
import android.text.TextPaint;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextPaint f2965a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f2966b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f2967c;

    public c(b bVar, TextPaint textPaint, d dVar) {
        this.f2967c = bVar;
        this.f2965a = textPaint;
        this.f2966b = dVar;
    }

    @Override // c.b.a.b.e0.d
    public void a(int i) {
        this.f2966b.a(i);
    }

    @Override // c.b.a.b.e0.d
    public void b(Typeface typeface, boolean z) {
        this.f2967c.d(this.f2965a, typeface);
        this.f2966b.b(typeface, z);
    }
}
