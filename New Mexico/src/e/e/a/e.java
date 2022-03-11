package e.e.a;

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
/* loaded from: classes.dex */
public class e extends Drawable {
    public float a;

    /* renamed from: e  reason: collision with root package name */
    public float f1282e;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f1285h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffColorFilter f1286i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f1287j;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1283f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1284g = true;

    /* renamed from: k  reason: collision with root package name */
    public PorterDuff.Mode f1288k = PorterDuff.Mode.SRC_IN;
    public final Paint b = new Paint(5);
    public final RectF c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1281d = new Rect();

    public e(ColorStateList colorStateList, float f2) {
        this.a = f2;
        b(colorStateList);
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
        this.f1285h = colorStateList;
        this.b.setColor(colorStateList.getColorForState(getState(), this.f1285h.getDefaultColor()));
    }

    public final void c(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1281d.set(rect);
        if (this.f1283f) {
            float b = f.b(this.f1282e, this.a, this.f1284g);
            this.f1281d.inset((int) Math.ceil((double) f.a(this.f1282e, this.a, this.f1284g)), (int) Math.ceil((double) b));
            this.c.set(this.f1281d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.b;
        if (this.f1286i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1286i);
            z = true;
        }
        RectF rectF = this.c;
        float f2 = this.a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1281d, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1287j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1285h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1285h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.b.getColor();
        if (z) {
            this.b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1287j;
        if (colorStateList2 == null || (mode = this.f1288k) == null) {
            return z;
        }
        this.f1286i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1287j = colorStateList;
        this.f1286i = a(colorStateList, this.f1288k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1288k = mode;
        this.f1286i = a(this.f1287j, mode);
        invalidateSelf();
    }
}
