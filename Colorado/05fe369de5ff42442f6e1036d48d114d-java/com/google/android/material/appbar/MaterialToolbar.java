package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.a.m;
import e.i.i.m;
import f.b.a.c.b.o.b;
import f.b.a.e.p.k;
import f.b.a.e.u.g;
import f.b.a.e.y.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialToolbar extends Toolbar {
    public static final int R = R$style.Widget_MaterialComponents_Toolbar;
    public Integer Q;

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.toolbarStyle;
        int i3 = R;
        Context context2 = getContext();
        int i4 = 0;
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialToolbar, i2, i3, new int[0]);
        int i5 = R$styleable.MaterialToolbar_navigationIconTint;
        if (d2.hasValue(i5)) {
            setNavigationIconTint(d2.getColor(i5, -1));
        }
        d2.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.q(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : i4));
            gVar.b.b = new f.b.a.e.m.a(context2);
            gVar.y();
            AtomicInteger atomicInteger = m.a;
            gVar.p(getElevation());
            setBackground(gVar);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            b.m1(this, (g) background);
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        b.l1(this, f2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (!(drawable == null || this.Q == null)) {
            drawable = m.h.C1(drawable);
            drawable.setTint(this.Q.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i2) {
        this.Q = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }
}
