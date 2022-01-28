package b.d.e;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public float f788a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f789b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f790c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f791d;

    /* renamed from: e  reason: collision with root package name */
    public float f792e;
    public boolean f = false;
    public boolean g = true;
    public ColorStateList h;
    public PorterDuffColorFilter i;
    public ColorStateList j;
    public PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    public d(ColorStateList colorStateList, float f2) {
        this.f788a = f2;
        this.f789b = new Paint(5);
        b(colorStateList);
        this.f790c = new RectF();
        this.f791d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.h = colorStateList;
        this.f789b.setColor(colorStateList.getColorForState(getState(), this.h.getDefaultColor()));
    }

    public final void c(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f790c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f791d.set(rect);
        if (this.f) {
            float b2 = e.b(this.f792e, this.f788a, this.g);
            this.f791d.inset((int) Math.ceil((double) e.a(this.f792e, this.f788a, this.g)), (int) Math.ceil((double) b2));
            this.f790c.set(this.f791d);
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f789b;
        if (this.i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.i);
            z = true;
        }
        RectF rectF = this.f790c;
        float f2 = this.f788a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f791d, this.f788a);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c(rect);
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f789b.getColor();
        if (z) {
            this.f789b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i2) {
        this.f789b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f789b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = a(colorStateList, this.k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.i = a(this.j, mode);
        invalidateSelf();
    }
}
