package e.j.c.m;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import e.b.a.m;
/* loaded from: classes.dex */
public class c extends Drawable implements Drawable.Callback, b, a {

    /* renamed from: h */
    public static final PorterDuff.Mode f1583h = PorterDuff.Mode.SRC_IN;
    public int b;
    public PorterDuff.Mode c;

    /* renamed from: d */
    public boolean f1584d;

    /* renamed from: e */
    public e f1585e;

    /* renamed from: f */
    public boolean f1586f;

    /* renamed from: g */
    public Drawable f1587g;

    public c(Drawable drawable) {
        this.f1585e = new e(this.f1585e);
        b(drawable);
    }

    @Override // e.j.c.m.b
    public final Drawable a() {
        return this.f1587g;
    }

    @Override // e.j.c.m.b
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f1587g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1587g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            e eVar = this.f1585e;
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
        e eVar = this.f1585e;
        ColorStateList colorStateList = eVar.c;
        PorterDuff.Mode mode = eVar.f1589d;
        if (colorStateList == null || mode == null) {
            this.f1584d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f1584d && colorForState == this.b && mode == this.c)) {
                setColorFilter(colorForState, mode);
                this.b = colorForState;
                this.c = mode;
                this.f1584d = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1587g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        e eVar = this.f1585e;
        return changingConfigurations | (eVar != null ? eVar.getChangingConfigurations() : 0) | this.f1587g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        e eVar = this.f1585e;
        if (eVar == null) {
            return null;
        }
        if (!(eVar.b != null)) {
            return null;
        }
        eVar.a = getChangingConfigurations();
        return this.f1585e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1587g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1587g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1587g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return m.e.q0(this.f1587g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1587g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1587g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1587g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1587g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1587g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1587g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1587g.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        e eVar;
        ColorStateList colorStateList = (!c() || (eVar = this.f1585e) == null) ? null : eVar.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1587g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1587g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1586f && super.mutate() == this) {
            this.f1585e = new e(this.f1585e);
            Drawable drawable = this.f1587g;
            if (drawable != null) {
                drawable.mutate();
            }
            e eVar = this.f1585e;
            if (eVar != null) {
                Drawable drawable2 = this.f1587g;
                eVar.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1586f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1587g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return m.e.z1(this.f1587g, i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        return this.f1587g.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1587g.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f1587g.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f1587g.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1587g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1587g.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1587g.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return d(iArr) || this.f1587g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1587g.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public c(e eVar, Resources resources) {
        Drawable.ConstantState constantState;
        this.f1585e = eVar;
        if (eVar != null && (constantState = eVar.b) != null) {
            b(constantState.newDrawable(resources));
        }
    }
}
