package f.b.a.e.q;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import f.b.a.e.q.c;

public final class o<S extends c> extends l {
    public m<S> m;
    public n<ObjectAnimator> n;

    public o(Context context, c cVar, m<S> mVar, n<ObjectAnimator> nVar) {
        super(context, cVar);
        this.m = mVar;
        mVar.b = this;
        this.n = nVar;
        nVar.a = this;
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.m.e(canvas, c());
            this.m.b(canvas, this.f2942j);
            int i2 = 0;
            while (true) {
                n<ObjectAnimator> nVar = this.n;
                int[] iArr = nVar.c;
                if (i2 < iArr.length) {
                    m<S> mVar = this.m;
                    Paint paint = this.f2942j;
                    float[] fArr = nVar.b;
                    int i3 = i2 * 2;
                    mVar.a(canvas, paint, fArr[i3], fArr[i3 + 1], iArr[i2]);
                    i2++;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    public int getIntrinsicHeight() {
        return this.m.c();
    }

    public int getIntrinsicWidth() {
        return this.m.d();
    }

    @Override // f.b.a.e.q.l
    public boolean i(boolean z, boolean z2, boolean z3) {
        boolean i2 = super.i(z, z2, z3);
        if (!isRunning()) {
            this.n.a();
        }
        float a = this.f2936d.a(this.b.getContentResolver());
        if (z && (z3 || (Build.VERSION.SDK_INT <= 21 && a > 0.0f))) {
            g gVar = (g) this.n;
            if (gVar.f2924d == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gVar, g.o, 0.0f, 1.0f);
                gVar.f2924d = ofFloat;
                ofFloat.setDuration(5400L);
                gVar.f2924d.setInterpolator(null);
                gVar.f2924d.setRepeatCount(-1);
                gVar.f2924d.addListener(new e(gVar));
            }
            if (gVar.f2925e == null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(gVar, g.p, 0.0f, 1.0f);
                gVar.f2925e = ofFloat2;
                ofFloat2.setDuration(333L);
                gVar.f2925e.setInterpolator(gVar.f2926f);
                gVar.f2925e.addListener(new f(gVar));
            }
            gVar.c();
            gVar.f2924d.start();
        }
        return i2;
    }
}
