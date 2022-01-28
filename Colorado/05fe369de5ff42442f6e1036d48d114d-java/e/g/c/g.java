package e.g.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import e.g.b.h.d;

public class g extends View {
    public int b;
    public View c;

    /* renamed from: d  reason: collision with root package name */
    public int f1204d;

    public void a() {
        if (this.c != null) {
            ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.c.getLayoutParams();
            aVar2.l0.c0 = 0;
            d.a m = aVar.l0.m();
            d.a aVar3 = d.a.FIXED;
            if (m != aVar3) {
                aVar.l0.M(aVar2.l0.r());
            }
            if (aVar.l0.q() != aVar3) {
                aVar.l0.H(aVar2.l0.l());
            }
            aVar2.l0.c0 = 8;
        }
    }

    public View getContent() {
        return this.c;
    }

    public int getEmptyVisibility() {
        return this.f1204d;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) rect.height()) / 2.0f) + (((float) height) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.b != i2) {
            View view = this.c;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.a) this.c.getLayoutParams()).a0 = false;
                this.c = null;
            }
            this.b = i2;
            if (i2 != -1 && (findViewById = ((View) getParent()).findViewById(i2)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i2) {
        this.f1204d = i2;
    }
}
