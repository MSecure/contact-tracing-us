package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.f.w0;
import f.b.a.c.b.o.b;
import f.b.a.e.n.a;
import f.b.a.e.q.k;

public class SwitchMaterial extends w0 {
    public static final int b0 = R$style.Widget_MaterialComponents_CompoundButton_Switch;
    public static final int[][] c0 = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public final a U;
    public ColorStateList V;
    public ColorStateList W;
    public boolean a0;

    /* JADX WARNING: Illegal instructions before constructor call */
    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.switchStyle;
        int i3 = b0;
        Context context2 = getContext();
        this.U = new a(context2);
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.SwitchMaterial, i2, i3, new int[0]);
        this.a0 = d2.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.V == null) {
            int w0 = b.w0(this, R$attr.colorSurface);
            int w02 = b.w0(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.U.a) {
                dimension += b.H0(this);
            }
            int a = this.U.a(w0, dimension);
            int[][] iArr = c0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.a1(w0, w02, 1.0f);
            iArr2[1] = a;
            iArr2[2] = b.a1(w0, w02, 0.38f);
            iArr2[3] = a;
            this.V = new ColorStateList(iArr, iArr2);
        }
        return this.V;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.W == null) {
            int[][] iArr = c0;
            int[] iArr2 = new int[iArr.length];
            int w0 = b.w0(this, R$attr.colorSurface);
            int w02 = b.w0(this, R$attr.colorControlActivated);
            int w03 = b.w0(this, R$attr.colorOnSurface);
            iArr2[0] = b.a1(w0, w02, 0.54f);
            iArr2[1] = b.a1(w0, w03, 0.32f);
            iArr2[2] = b.a1(w0, w02, 0.12f);
            iArr2[3] = b.a1(w0, w03, 0.12f);
            this.W = new ColorStateList(iArr, iArr2);
        }
        return this.W;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.a0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList colorStateList;
        this.a0 = z;
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
