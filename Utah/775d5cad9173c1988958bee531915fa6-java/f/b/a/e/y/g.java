package f.b.a.e.y;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import f.b.a.e.v.j;

public class g extends f.b.a.e.v.g {
    public final Paint A;
    public final RectF B;
    public int C;

    public g() {
        this(null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(j jVar) {
        super(jVar == null ? new j() : jVar);
        Paint paint = new Paint(1);
        this.A = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.B = new RectF();
    }

    @Override // f.b.a.e.v.g
    public void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.C = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.B, this.A);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.C);
        }
    }

    public void z(float f2, float f3, float f4, float f5) {
        RectF rectF = this.B;
        if (f2 != rectF.left || f3 != rectF.top || f4 != rectF.right || f5 != rectF.bottom) {
            rectF.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }
}
