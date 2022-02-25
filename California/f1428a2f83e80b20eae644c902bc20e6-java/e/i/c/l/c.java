package e.i.c.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class c extends Drawable implements Drawable.Callback, b, a {

    /* renamed from: h  reason: collision with root package name */
    public static final PorterDuff.Mode f1435h = PorterDuff.Mode.SRC_IN;
    public int b;
    public PorterDuff.Mode c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1436d;

    /* renamed from: e  reason: collision with root package name */
    public e f1437e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1438f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f1439g;

    public c(Drawable drawable) {
        this.f1437e = new e(this.f1437e);
        b(drawable);
    }

    @Override // e.i.c.l.b
    public final Drawable a() {
        return this.f1439g;
    }

    @Override // e.i.c.l.b
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f1439g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1439g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            e eVar = this.f1437e;
            if (eVar != null) {
                eVar.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public boolean c() {
        throw null;
    }

    public final boolean d(int[] iArr) {
        if (!c()) {
            return false;
        }
        e eVar = this.f1437e;
        ColorStateList colorStateList = eVar.c;
        PorterDuff.Mode mode = eVar.f1441d;
        if (colorStateList == null || mode == null) {
            this.f1436d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f1436d && colorForState == this.b && mode == this.c)) {
                setColorFilter(colorForState, mode);
                this.b = colorForState;
                this.c = mode;
                this.f1436d = true;
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        this.f1439g.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        e eVar = this.f1437e;
        return changingConfigurations | (eVar != null ? eVar.getChangingConfigurations() : 0) | this.f1439g.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        e eVar = this.f1437e;
        if (eVar == null) {
            return null;
        }
        if (!(eVar.b != null)) {
            return null;
        }
        eVar.a = getChangingConfigurations();
        return this.f1437e;
    }

    public Drawable getCurrent() {
        return this.f1439g.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f1439g.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f1439g.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f1439g.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f1439g.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f1439g.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f1439g.getPadding(rect);
    }

    public int[] getState() {
        return this.f1439g.getState();
    }

    public Region getTransparentRegion() {
        return this.f1439g.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f1439g.isAutoMirrored();
    }

    public boolean isStateful() {
        e eVar;
        ColorStateList colorStateList = (!c() || (eVar = this.f1437e) == null) ? null : eVar.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1439g.isStateful();
    }

    public void jumpToCurrentState() {
        this.f1439g.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f1438f && super.mutate() == this) {
            this.f1437e = new e(this.f1437e);
            Drawable drawable = this.f1439g;
            if (drawable != null) {
                drawable.mutate();
            }
            e eVar = this.f1437e;
            if (eVar != null) {
                Drawable drawable2 = this.f1439g;
                eVar.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1438f = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1439g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i2) {
        return this.f1439g.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f1439g.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        this.f1439g.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i2) {
        this.f1439g.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1439g.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f1439g.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1439g.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return d(iArr) || this.f1439g.setState(iArr);
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        throw null;
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1439g.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public c(e eVar, Resources resources) {
        Drawable.ConstantState constantState;
        this.f1437e = eVar;
        if (eVar != null && (constantState = eVar.b) != null) {
            b(constantState.newDrawable(resources));
        }
    }
}
