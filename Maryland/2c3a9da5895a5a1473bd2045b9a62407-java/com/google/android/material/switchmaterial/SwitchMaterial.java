package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.f.s0;
import f.b.a.c.b.o.b;
import f.b.a.d.n.a;
import f.b.a.d.q.k;

public class SwitchMaterial extends s0 {
    public static final int U = R$style.Widget_MaterialComponents_CompoundButton_Switch;
    public static final int[][] V = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public final a Q;
    public ColorStateList R;
    public ColorStateList S;
    public boolean T;

    /* JADX WARNING: Illegal instructions before constructor call */
    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        super(f.b.a.d.a0.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.switchStyle;
        int i3 = U;
        Context context2 = getContext();
        this.Q = new a(context2);
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.SwitchMaterial, i2, i3, new int[0]);
        this.T = d2.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.R == null) {
            int K0 = b.K0(this, R$attr.colorSurface);
            int K02 = b.K0(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.Q.a) {
                dimension += b.V0(this);
            }
            int a = this.Q.a(K0, dimension);
            int[][] iArr = V;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.m1(K0, K02, 1.0f);
            iArr2[1] = a;
            iArr2[2] = b.m1(K0, K02, 0.38f);
            iArr2[3] = a;
            this.R = new ColorStateList(iArr, iArr2);
        }
        return this.R;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.S == null) {
            int[][] iArr = V;
            int[] iArr2 = new int[iArr.length];
            int K0 = b.K0(this, R$attr.colorSurface);
            int K02 = b.K0(this, R$attr.colorControlActivated);
            int K03 = b.K0(this, R$attr.colorOnSurface);
            iArr2[0] = b.m1(K0, K02, 0.54f);
            iArr2[1] = b.m1(K0, K03, 0.32f);
            iArr2[2] = b.m1(K0, K02, 0.12f);
            iArr2[3] = b.m1(K0, K03, 0.12f);
            this.S = new ColorStateList(iArr, iArr2);
        }
        return this.S;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.T && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.T && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList colorStateList;
        this.T = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            colorStateList = getMaterialThemeColorsTrackTintList();
        } else {
            colorStateList = null;
            setThumbTintList(null);
        }
        setTrackTintList(colorStateList);
    }
}
