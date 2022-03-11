package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.f.u;
import f.b.a.c.b.o.b;
import f.b.a.e.q.k;
import f.b.a.e.z.a.a;
/* loaded from: classes.dex */
public class MaterialRadioButton extends u {

    /* renamed from: h */
    public static final int f589h = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: i */
    public static final int[][] f590i = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: f */
    public ColorStateList f591f;

    /* renamed from: g */
    public boolean f592g;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.radioButtonStyle;
        int i3 = f589h;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialRadioButton, i2, i3, new int[0]);
        int i4 = R$styleable.MaterialRadioButton_buttonTint;
        if (d2.hasValue(i4)) {
            setButtonTintList(b.y0(context2, d2, i4));
        }
        this.f592g = d2.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f591f == null) {
            int x0 = b.x0(this, R$attr.colorControlActivated);
            int x02 = b.x0(this, R$attr.colorOnSurface);
            int x03 = b.x0(this, R$attr.colorSurface);
            int[][] iArr = f590i;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.b1(x03, x0, 1.0f);
            iArr2[1] = b.b1(x03, x02, 0.54f);
            iArr2[2] = b.b1(x03, x02, 0.38f);
            iArr2[3] = b.b1(x03, x02, 0.38f);
            this.f591f = new ColorStateList(iArr, iArr2);
        }
        return this.f591f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f592g && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f592g = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
