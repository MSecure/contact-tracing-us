package e.j.c.m;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: i */
    public static Method f1588i;

    public d(Drawable drawable) {
        super(drawable);
        if (f1588i == null) {
            try {
                f1588i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // e.j.c.m.c
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f1587g;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f1587g.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f1587g.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f1587g;
        if (!(drawable == null || (method = f1588i) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.f1587g.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f1587g.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // e.j.c.m.c, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // e.j.c.m.c, android.graphics.drawable.Drawable
    public void setTint(int i2) {
        if (c()) {
            super.setTint(i2);
        } else {
            this.f1587g.setTint(i2);
        }
    }

    @Override // e.j.c.m.c, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f1585e.c = colorStateList;
            d(getState());
            return;
        }
        this.f1587g.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f1585e.f1589d = mode;
            d(getState());
            return;
        }
        this.f1587g.setTintMode(mode);
    }

    public d(e eVar, Resources resources) {
        super(eVar, resources);
        if (f1588i == null) {
            try {
                f1588i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }
}
