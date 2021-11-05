package c.b.a.b.c0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import c.b.a.b.e0.c;
import c.b.a.b.e0.d;
import java.lang.ref.WeakReference;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f2945a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public final d f2946b = new a();

    /* renamed from: c  reason: collision with root package name */
    public float f2947c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2948d = true;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<b> f2949e = new WeakReference<>(null);
    public c.b.a.b.e0.b f;

    public class a extends d {
        public a() {
        }

        @Override // c.b.a.b.e0.d
        public void a(int i) {
            h hVar = h.this;
            hVar.f2948d = true;
            b bVar = hVar.f2949e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c.b.a.b.e0.d
        public void b(Typeface typeface, boolean z) {
            if (!z) {
                h hVar = h.this;
                hVar.f2948d = true;
                b bVar = hVar.f2949e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        this.f2949e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.f2948d) {
            return this.f2947c;
        }
        float measureText = str == null ? 0.0f : this.f2945a.measureText((CharSequence) str, 0, str.length());
        this.f2947c = measureText;
        this.f2948d = false;
        return measureText;
    }

    public void b(c.b.a.b.e0.b bVar, Context context) {
        if (this.f != bVar) {
            this.f = bVar;
            if (bVar != null) {
                TextPaint textPaint = this.f2945a;
                d dVar = this.f2946b;
                bVar.a();
                bVar.d(textPaint, bVar.l);
                bVar.b(context, new c(bVar, textPaint, dVar));
                b bVar2 = this.f2949e.get();
                if (bVar2 != null) {
                    this.f2945a.drawableState = bVar2.getState();
                }
                bVar.c(context, this.f2945a, this.f2946b);
                this.f2948d = true;
            }
            b bVar3 = this.f2949e.get();
            if (bVar3 != null) {
                bVar3.a();
                bVar3.onStateChange(bVar3.getState());
            }
        }
    }
}
