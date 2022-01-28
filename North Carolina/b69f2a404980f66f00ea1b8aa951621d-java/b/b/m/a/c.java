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
    public Drawable f466b;

    public c(Drawable drawable) {
        Drawable drawable2 = this.f466b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f466b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f466b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f466b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f466b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f466b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f466b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f466b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f466b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f466b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f466b.getPadding(rect);
    }

    public int[] getState() {
        return this.f466b.getState();
    }

    public Region getTransparentRegion() {
        return this.f466b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f466b.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.f466b.isStateful();
    }

    public void jumpToCurrentState() {
        this.f466b.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.f466b.setBounds(rect);
    }

    public boolean onLevelChange(int i) {
        return this.f466b.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f466b.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        this.f466b.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.f466b.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f466b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f466b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f466b.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        this.f466b.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f466b.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f466b.setState(iArr);
    }

    public void setTint(int i) {
        this.f466b.setTint(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f466b.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f466b.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f466b.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
