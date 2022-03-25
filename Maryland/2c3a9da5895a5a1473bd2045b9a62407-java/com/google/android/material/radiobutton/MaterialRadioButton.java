package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.f.r;
import f.b.a.c.b.o.b;
import f.b.a.d.a0.a.a;
import f.b.a.d.q.k;

public class MaterialRadioButton extends r {

    /* renamed from: g  reason: collision with root package name */
    public static final int f555g = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h  reason: collision with root package name */
    public static final int[][] f556h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f557e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f558f;

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.radioButtonStyle;
        int i3 = f555g;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialRadioButton, i2, i3, new int[0]);
        int i4 = R$styleable.MaterialRadioButton_buttonTint;
        if (d2.hasValue(i4)) {
            setButtonTintList(b.L0(context2, d2, i4));
        }
        this.f558f = d2.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f557e == null) {
            int K0 = b.K0(this, R$attr.colorControlActivated);
            int K02 = b.K0(this, R$attr.colorOnSurface);
            int K03 = b.K0(this, R$attr.colorSurface);
            int[][] iArr = f556h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.m1(K03, K0, 1.0f);
            iArr2[1] = b.m1(K03, K02, 0.54f);
            iArr2[2] = b.m1(K03, K02, 0.38f);
            iArr2[3] = b.m1(K03, K02, 0.38f);
            this.f557e = new ColorStateList(iArr, iArr2);
        }
        return this.f557e;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f558f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f558f = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
