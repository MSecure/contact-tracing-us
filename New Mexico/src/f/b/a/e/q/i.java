package f.b.a.e.q;

import android.graphics.Typeface;
import android.text.TextPaint;
import f.b.a.e.s.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class i {
    public float c;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<b> f3011e;

    /* renamed from: f  reason: collision with root package name */
    public f.b.a.e.s.b f3012f;
    public final TextPaint a = new TextPaint(1);
    public final d b = new a();

    /* renamed from: d  reason: collision with root package name */
    public boolean f3010d = true;

    /* loaded from: classes.dex */
    public class a extends d {
        public a() {
        }

        @Override // f.b.a.e.s.d
        public void a(int i2) {
            i iVar = i.this;
            iVar.f3010d = true;
            b bVar = iVar.f3011e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // f.b.a.e.s.d
        public void b(Typeface typeface, boolean z) {
            if (!z) {
                i iVar = i.this;
                iVar.f3010d = true;
                b bVar = iVar.f3011e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        @Override // f.b.a.e.q.i.b
        boolean onStateChange(int[] iArr);
    }

    public i(b bVar) {
        this.f3011e = new WeakReference<>(null);
        this.f3011e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.f3010d) {
            return this.c;
        }
        float measureText = str == null ? 0.0f : this.a.measureText((CharSequence) str, 0, str.length());
        this.c = measureText;
        this.f3010d = false;
        return measureText;
    }
}
