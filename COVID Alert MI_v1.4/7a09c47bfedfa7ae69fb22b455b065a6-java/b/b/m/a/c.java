package b.b.m.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class c extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    public Drawable f632b;

    public c(Drawable drawable) {
        Drawable drawable2 = this.f632b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f632b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f632b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f632b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f632b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f632b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f632b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f632b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f632b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f632b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f632b.getPadding(rect);
    }

    public int[] getState() {
        return this.f632b.getState();
    }

    public Region getTransparentRegion() {
        return this.f632b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f632b.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.f632b.isStateful();
    }

    public void jumpToCurrentState() {
        this.f632b.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.f632b.setBounds(rect);
    }

    public boolean onLevelChange(int i) {
        return this.f632b.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f632b.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        this.f632b.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.f632b.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f632b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f632b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f632b.setFilterBitmap(z);
    }

    public void setHotspot(float f2, float f3) {
        this.f632b.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f632b.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f632b.setState(iArr);
    }

    public void setTint(int i) {
        this.f632b.setTint(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f632b.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f632b.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f632b.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
