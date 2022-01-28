package c.b.a.b.l0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import c.b.a.b.h0.j;

public class g extends c.b.a.b.h0.g {
    public final RectF A;
    public int B;
    public final Paint z;

    public g() {
        this(null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(j jVar) {
        super(jVar == null ? new j() : jVar);
        Paint paint = new Paint(1);
        this.z = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.z.setColor(-1);
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.A = new RectF();
    }

    public void A(float f2, float f3, float f4, float f5) {
        RectF rectF = this.A;
        if (f2 != rectF.left || f3 != rectF.top || f4 != rectF.right || f5 != rectF.bottom) {
            this.A.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    @Override // c.b.a.b.h0.g
    public void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.B = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.A, this.z);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.B);
        }
    }
}
