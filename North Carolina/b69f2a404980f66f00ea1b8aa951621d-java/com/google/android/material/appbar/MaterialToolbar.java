package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import b.i.l.m;
import c.b.a.a.c.n.c;
import c.b.a.b.b;
import c.b.a.b.h0.g;
import c.b.a.b.k;
import c.b.a.b.m0.a.a;

public class MaterialToolbar extends Toolbar {
    public static final int Q = k.Widget_MaterialComponents_Toolbar;

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r0, Q), attributeSet, r0);
        int i = b.toolbarStyle;
        Context context2 = getContext();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.r(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.f2982b.f2988b = new c.b.a.b.z.a(context2);
            gVar.z();
            gVar.q(m.k(this));
            setBackground(gVar);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            c.f2(this, (g) background);
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        c.e2(this, f);
    }
}
