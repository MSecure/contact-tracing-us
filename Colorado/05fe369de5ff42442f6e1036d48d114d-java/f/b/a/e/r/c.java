package f.b.a.e.r;

import android.graphics.Typeface;
import android.text.TextPaint;

public class c extends d {
    public final /* synthetic */ TextPaint a;
    public final /* synthetic */ d b;
    public final /* synthetic */ b c;

    public c(b bVar, TextPaint textPaint, d dVar) {
        this.c = bVar;
        this.a = textPaint;
        this.b = dVar;
    }

    @Override // f.b.a.e.r.d
    public void a(int i2) {
        this.b.a(i2);
    }

    @Override // f.b.a.e.r.d
    public void b(Typeface typeface, boolean z) {
        this.c.d(this.a, typeface);
        this.b.b(typeface, z);
    }
}
