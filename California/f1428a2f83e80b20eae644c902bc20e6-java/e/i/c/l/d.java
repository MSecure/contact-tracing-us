package e.i.c.l;

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
import android.util.Log;
import java.lang.reflect.Method;

public class d extends c {

    /* renamed from: i  reason: collision with root package name */
    public static Method f1440i;

    public d(Drawable drawable) {
        super(drawable);
        e();
    }

    public d(e eVar, Resources resources) {
        super(eVar, resources);
        e();
    }

    @Override // e.i.c.l.c
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f1439g;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final void e() {
        if (f1440i == null) {
            try {
                f1440i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }

    public Rect getDirtyBounds() {
        return this.f1439g.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f1439g.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f1439g;
        if (!(drawable == null || (method = f1440i) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e2);
            }
        }
        return false;
    }

    public void setHotspot(float f2, float f3) {
        this.f1439g.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f1439g.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // e.i.c.l.c
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // e.i.c.l.c
    public void setTint(int i2) {
        if (c()) {
            super.setTint(i2);
        } else {
            this.f1439g.setTint(i2);
        }
    }

    @Override // e.i.c.l.c
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f1437e.c = colorStateList;
            d(getState());
            return;
        }
        this.f1439g.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f1437e.f1441d = mode;
            d(getState());
            return;
        }
        this.f1439g.setTintMode(mode);
    }
}
