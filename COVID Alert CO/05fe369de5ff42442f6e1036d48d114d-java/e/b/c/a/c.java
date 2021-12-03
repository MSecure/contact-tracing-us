package e.b.c.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class c extends Drawable implements Drawable.Callback {
    public Drawable b;

    public c(Drawable drawable) {
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.b.getPadding(rect);
    }

    public int[] getState() {
        return this.b.getState();
    }

    public Region getTransparentRegion() {
        return this.b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.b.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.b.isStateful();
    }

    public void jumpToCurrentState() {
        this.b.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.b.setBounds(rect);
    }

    public boolean onLevelChange(int i2) {
        return this.b.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        this.b.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i2) {
        this.b.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.b.setFilterBitmap(z);
    }

    public void setHotspot(float f2, float f3) {
        this.b.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.b.setHotspotBounds(i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        return this.b.setState(iArr);
    }

    public void setTint(int i2) {
        this.b.setTint(i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.b.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.b.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.b.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
