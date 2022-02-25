package f.b.a.d.q;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import f.b.a.d.s.c;
import f.b.a.d.s.d;
import java.lang.ref.WeakReference;

public class i {
    public final TextPaint a = new TextPaint(1);
    public final d b = new a();
    public float c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2691d = true;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<b> f2692e = new WeakReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public f.b.a.d.s.b f2693f;

    public class a extends d {
        public a() {
        }

        @Override // f.b.a.d.s.d
        public void a(int i2) {
            i iVar = i.this;
            iVar.f2691d = true;
            b bVar = iVar.f2692e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // f.b.a.d.s.d
        public void b(Typeface typeface, boolean z) {
            if (!z) {
                i iVar = i.this;
                iVar.f2691d = true;
                b bVar = iVar.f2692e.get();
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

    public i(b bVar) {
        this.f2692e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.f2691d) {
            return this.c;
        }
        float measureText = str == null ? 0.0f : this.a.measureText((CharSequence) str, 0, str.length());
        this.c = measureText;
        this.f2691d = false;
        return measureText;
    }

    public void b(f.b.a.d.s.b bVar, Context context) {
        if (this.f2693f != bVar) {
            this.f2693f = bVar;
            if (bVar != null) {
                TextPaint textPaint = this.a;
                d dVar = this.b;
                bVar.a();
                bVar.d(textPaint, bVar.n);
                bVar.b(context, new c(bVar, textPaint, dVar));
                b bVar2 = this.f2692e.get();
                if (bVar2 != null) {
                    this.a.drawableState = bVar2.getState();
                }
                bVar.c(context, this.a, this.b);
                this.f2691d = true;
            }
            b bVar3 = this.f2692e.get();
            if (bVar3 != null) {
                bVar3.a();
                bVar3.onStateChange(bVar3.getState());
            }
        }
    }
}
