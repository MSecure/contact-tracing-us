package f.b.a.e.q;

import android.graphics.Typeface;
import android.text.TextPaint;
import f.b.a.e.s.d;
import java.lang.ref.WeakReference;

public class i {
    public final TextPaint a = new TextPaint(1);
    public final d b = new a();
    public float c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2968d = true;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<b> f2969e = new WeakReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public f.b.a.e.s.b f2970f;

    public class a extends d {
        public a() {
        }

        @Override // f.b.a.e.s.d
        public void a(int i2) {
            i iVar = i.this;
            iVar.f2968d = true;
            b bVar = iVar.f2969e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // f.b.a.e.s.d
        public void b(Typeface typeface, boolean z) {
            if (!z) {
                i iVar = i.this;
                iVar.f2968d = true;
                b bVar = iVar.f2969e.get();
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
        this.f2969e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.f2968d) {
            return this.c;
        }
        float measureText = str == null ? 0.0f : this.a.measureText((CharSequence) str, 0, str.length());
        this.c = measureText;
        this.f2968d = false;
        return measureText;
    }
}
