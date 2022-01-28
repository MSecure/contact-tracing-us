package b.g.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.a.h.d;

public class f extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f954b;

    /* renamed from: c  reason: collision with root package name */
    public View f955c;

    /* renamed from: d  reason: collision with root package name */
    public int f956d;

    public void a() {
        if (this.f955c != null) {
            ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f955c.getLayoutParams();
            d dVar = aVar2.k0;
            dVar.Y = 0;
            aVar.k0.C(dVar.n());
            aVar.k0.w(aVar2.k0.h());
            aVar2.k0.Y = 8;
        }
    }

    public View getContent() {
        return this.f955c;
    }

    public int getEmptyVisibility() {
        return this.f956d;
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

    public void setContentId(int i) {
        View findViewById;
        if (this.f954b != i) {
            View view = this.f955c;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.a) this.f955c.getLayoutParams()).Z = false;
                this.f955c = null;
            }
            this.f954b = i;
            if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.f956d = i;
    }
}
