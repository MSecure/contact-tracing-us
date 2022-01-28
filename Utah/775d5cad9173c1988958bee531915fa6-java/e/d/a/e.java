package e.d.a;

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

public class e extends Drawable {
    public float a;
    public final Paint b;
    public final RectF c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1197d;

    /* renamed from: e  reason: collision with root package name */
    public float f1198e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1199f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1200g = true;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f1201h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffColorFilter f1202i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f1203j;

    /* renamed from: k  reason: collision with root package name */
    public PorterDuff.Mode f1204k = PorterDuff.Mode.SRC_IN;

    public e(ColorStateList colorStateList, float f2) {
        this.a = f2;
        this.b = new Paint(5);
        b(colorStateList);
        this.c = new RectF();
        this.f1197d = new Rect();
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
        this.f1201h = colorStateList;
        this.b.setColor(colorStateList.getColorForState(getState(), this.f1201h.getDefaultColor()));
    }

    public final void c(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1197d.set(rect);
        if (this.f1199f) {
            float b2 = f.b(this.f1198e, this.a, this.f1200g);
            this.f1197d.inset((int) Math.ceil((double) f.a(this.f1198e, this.a, this.f1200g)), (int) Math.ceil((double) b2));
            this.c.set(this.f1197d);
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.b;
        if (this.f1202i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1202i);
            z = true;
        }
        RectF rectF = this.c;
        float f2 = this.a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1197d, this.a);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1203j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1201h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c(rect);
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1201h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.b.getColor();
        if (z) {
            this.b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1203j;
        if (colorStateList2 == null || (mode = this.f1204k) == null) {
            return z;
        }
        this.f1202i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1203j = colorStateList;
        this.f1202i = a(colorStateList, this.f1204k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1204k = mode;
        this.f1202i = a(this.f1203j, mode);
        invalidateSelf();
    }
}
