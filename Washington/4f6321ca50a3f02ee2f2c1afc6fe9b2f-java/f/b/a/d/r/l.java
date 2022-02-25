package f.b.a.d.r;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import e.x.a.a.b;

public final class l extends i {
    public final j o;
    public k<AnimatorSet> p;

    public class a extends b {
        public a() {
        }

        @Override // e.x.a.a.b
        public void a(Drawable drawable) {
            l.this.p.a();
            l.this.p.f();
        }
    }

    public l(Context context, s sVar) {
        super(context, sVar);
        Pair pair;
        int i2 = sVar.a;
        boolean z = sVar.f2742j;
        if (i2 == 1) {
            pair = new Pair(new b(), new e());
        } else {
            pair = new Pair(new m(), z ? new r() : new o(this.b));
        }
        this.o = (j) pair.first;
        h((k) pair.second);
    }

    @Override // f.b.a.d.r.i
    public void c() {
        super.c();
        k<AnimatorSet> kVar = this.p;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.o.c(canvas, this.c, this.f2717i);
            s sVar = this.c;
            float f2 = this.f2717i;
            float f3 = ((float) sVar.b) * f2;
            float f4 = ((float) sVar.c) * f2;
            this.o.d(canvas, this.f2720l, this.f2718j, 0.0f, 1.0f, f3, f4);
            int i2 = 0;
            while (true) {
                k<AnimatorSet> kVar = this.p;
                int[] iArr = kVar.c;
                if (i2 < iArr.length) {
                    j jVar = this.o;
                    Paint paint = this.f2720l;
                    int i3 = iArr[i2];
                    float[] fArr = kVar.b;
                    int i4 = i2 * 2;
                    jVar.d(canvas, paint, i3, fArr[i4], fArr[i4 + 1], f3, f4);
                    i2++;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    @Override // f.b.a.d.r.i
    public boolean f(boolean z, boolean z2, boolean z3) {
        boolean f2 = super.f(z, z2, z3);
        if (!isRunning()) {
            this.p.a();
            this.p.f();
        }
        if (z && z3) {
            this.p.g();
        }
        return f2;
    }

    public int getIntrinsicHeight() {
        return this.o.b(this.c);
    }

    public int getIntrinsicWidth() {
        return this.o.a(this.c);
    }

    public void h(k<AnimatorSet> kVar) {
        this.p = kVar;
        kVar.d(this);
        this.f2716h = new a();
        e(1.0f);
    }
}
