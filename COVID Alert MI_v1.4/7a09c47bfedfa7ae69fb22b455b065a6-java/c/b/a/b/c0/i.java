package c.b.a.b.c0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import c.b.a.b.e0.c;
import c.b.a.b.e0.d;
import java.lang.ref.WeakReference;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f4209a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public final d f4210b = new a();

    /* renamed from: c  reason: collision with root package name */
    public float f4211c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4212d = true;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<b> f4213e = new WeakReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public c.b.a.b.e0.b f4214f;

    public class a extends d {
        public a() {
        }

        @Override // c.b.a.b.e0.d
        public void a(int i) {
            i iVar = i.this;
            iVar.f4212d = true;
            b bVar = iVar.f4213e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c.b.a.b.e0.d
        public void b(Typeface typeface, boolean z) {
            if (!z) {
                i iVar = i.this;
                iVar.f4212d = true;
                b bVar = iVar.f4213e.get();
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
        this.f4213e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.f4212d) {
            return this.f4211c;
        }
        float measureText = str == null ? 0.0f : this.f4209a.measureText((CharSequence) str, 0, str.length());
        this.f4211c = measureText;
        this.f4212d = false;
        return measureText;
    }

    public void b(c.b.a.b.e0.b bVar, Context context) {
        if (this.f4214f != bVar) {
            this.f4214f = bVar;
            if (bVar != null) {
                TextPaint textPaint = this.f4209a;
                d dVar = this.f4210b;
                bVar.a();
                bVar.d(textPaint, bVar.n);
                bVar.b(context, new c(bVar, textPaint, dVar));
                b bVar2 = this.f4213e.get();
                if (bVar2 != null) {
                    this.f4209a.drawableState = bVar2.getState();
                }
                bVar.c(context, this.f4209a, this.f4210b);
                this.f4212d = true;
            }
            b bVar3 = this.f4213e.get();
            if (bVar3 != null) {
                bVar3.a();
                bVar3.onStateChange(bVar3.getState());
            }
        }
    }
}
