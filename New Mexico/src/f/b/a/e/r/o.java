package f.b.a.e.r;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import f.b.a.e.r.c;
/* loaded from: classes.dex */
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

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.m.e(canvas, c());
            this.m.b(canvas, this.f3048j);
            int i2 = 0;
            while (true) {
                n<ObjectAnimator> nVar = this.n;
                int[] iArr = nVar.c;
                if (i2 < iArr.length) {
                    m<S> mVar = this.m;
                    Paint paint = this.f3048j;
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

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.m.d();
    }

    @Override // f.b.a.e.r.l
    public boolean i(boolean z, boolean z2, boolean z3) {
        boolean i2 = super.i(z, z2, z3);
        if (!isRunning()) {
            this.n.a();
        }
        float a = this.f3042d.a(this.b.getContentResolver());
        if (z && (z3 || (Build.VERSION.SDK_INT <= 21 && a > 0.0f))) {
            this.n.c();
        }
        return i2;
    }
}
