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

public class MaterialRadioButton extends u {

    /* renamed from: h  reason: collision with root package name */
    public static final int f577h = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: i  reason: collision with root package name */
    public static final int[][] f578i = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f579f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f580g;

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.radioButtonStyle;
        int i3 = f577h;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialRadioButton, i2, i3, new int[0]);
        int i4 = R$styleable.MaterialRadioButton_buttonTint;
        if (d2.hasValue(i4)) {
            setButtonTintList(b.x0(context2, d2, i4));
        }
        this.f580g = d2.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f579f == null) {
            int w0 = b.w0(this, R$attr.colorControlActivated);
            int w02 = b.w0(this, R$attr.colorOnSurface);
            int w03 = b.w0(this, R$attr.colorSurface);
            int[][] iArr = f578i;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.a1(w03, w0, 1.0f);
            iArr2[1] = b.a1(w03, w02, 0.54f);
            iArr2[2] = b.a1(w03, w02, 0.38f);
            iArr2[3] = b.a1(w03, w02, 0.38f);
            this.f579f = new ColorStateList(iArr, iArr2);
        }
        return this.f579f;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f580g && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f580g = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
