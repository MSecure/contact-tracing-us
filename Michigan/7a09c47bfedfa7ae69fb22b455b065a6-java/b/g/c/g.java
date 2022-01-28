package b.g.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.b.h.d;
import gov.michigan.MiCovidExposure.BuildConfig;

public class g extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f1638b;

    /* renamed from: c  reason: collision with root package name */
    public View f1639c;

    /* renamed from: d  reason: collision with root package name */
    public int f1640d;

    public void a() {
        if (this.f1639c != null) {
            ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f1639c.getLayoutParams();
            d dVar = aVar2.m0;
            dVar.V = 0;
            aVar.m0.B(dVar.o());
            aVar.m0.w(aVar2.m0.i());
            aVar2.m0.V = 8;
        }
    }

    public View getContent() {
        return this.f1639c;
    }

    public int getEmptyVisibility() {
        return this.f1640d;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(BuildConfig.VERSION_CODE, 210, 210, 210);
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

    public void setContentId(int i) {
        View findViewById;
        if (this.f1638b != i) {
            View view = this.f1639c;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.a) this.f1639c.getLayoutParams()).a0 = false;
                this.f1639c = null;
            }
            this.f1638b = i;
            if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.f1640d = i;
    }
}
