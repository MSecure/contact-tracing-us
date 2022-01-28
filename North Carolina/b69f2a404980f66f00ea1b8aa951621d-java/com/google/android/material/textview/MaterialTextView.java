package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.b.q.z;
import c.b.a.a.c.n.c;
import c.b.a.b.b;
import c.b.a.b.l;
import c.b.a.b.m0.a.a;

public class MaterialTextView extends z {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 16842884, 0), attributeSet, 16842884);
        Context context2 = getContext();
        boolean z = true;
        if (c.V1(context2, b.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, 16842884, 0);
            int f = f(context2, obtainStyledAttributes, l.MaterialTextView_android_lineHeight, l.MaterialTextView_lineHeight);
            obtainStyledAttributes.recycle();
            if (!(f == -1 ? false : z)) {
                TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, 16842884, 0);
                int resourceId = obtainStyledAttributes2.getResourceId(l.MaterialTextView_android_textAppearance, -1);
                obtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    c(theme, resourceId);
                }
            }
        }
    }

    public static int f(Context context, TypedArray typedArray, int... iArr) {
        int i = -1;
        for (int i2 = 0; i2 < iArr.length && i < 0; i2++) {
            int i3 = iArr[i2];
            TypedValue typedValue = new TypedValue();
            if (!typedArray.getValue(i3, typedValue) || typedValue.type != 2) {
                i = typedArray.getDimensionPixelSize(i3, -1);
            } else {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
                obtainStyledAttributes.recycle();
                i = dimensionPixelSize;
            }
        }
        return i;
    }

    public final void c(Resources.Theme theme, int i) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i, l.MaterialTextAppearance);
        int f = f(getContext(), obtainStyledAttributes, l.MaterialTextAppearance_android_lineHeight, l.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (f >= 0) {
            setLineHeight(f);
        }
    }

    @Override // b.b.q.z
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (c.V1(context, b.textAppearanceLineHeightEnabled, true)) {
            c(context.getTheme(), i);
        }
    }
}
