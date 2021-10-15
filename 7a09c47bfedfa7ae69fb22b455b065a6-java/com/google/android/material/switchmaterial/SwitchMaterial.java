package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.q.s0;
import b.x.t;
import c.b.a.b.b;
import c.b.a.b.d;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.z.a;

public class SwitchMaterial extends s0 {
    public static final int U = k.Widget_MaterialComponents_CompoundButton_Switch;
    public static final int[][] V = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public final a Q;
    public ColorStateList R;
    public ColorStateList S;
    public boolean T;

    /* JADX WARNING: Illegal instructions before constructor call */
    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r3, U), attributeSet, r3);
        int i = b.switchStyle;
        Context context2 = getContext();
        this.Q = new a(context2);
        TypedArray d2 = c.b.a.b.c0.k.d(context2, attributeSet, l.SwitchMaterial, i, U, new int[0]);
        this.T = d2.getBoolean(l.SwitchMaterial_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.R == null) {
            int A1 = t.A1(this, b.colorSurface);
            int A12 = t.A1(this, b.colorControlActivated);
            float dimension = getResources().getDimension(d.mtrl_switch_thumb_elevation);
            if (this.Q.f4642a) {
                dimension += t.K1(this);
            }
            int a2 = this.Q.a(A1, dimension);
            int[] iArr = new int[V.length];
            iArr[0] = t.a2(A1, A12, 1.0f);
            iArr[1] = a2;
            iArr[2] = t.a2(A1, A12, 0.38f);
            iArr[3] = a2;
            this.R = new ColorStateList(V, iArr);
        }
        return this.R;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.S == null) {
            int[] iArr = new int[V.length];
            int A1 = t.A1(this, b.colorSurface);
            int A12 = t.A1(this, b.colorControlActivated);
            int A13 = t.A1(this, b.colorOnSurface);
            iArr[0] = t.a2(A1, A12, 0.54f);
            iArr[1] = t.a2(A1, A13, 0.32f);
            iArr[2] = t.a2(A1, A12, 0.12f);
            iArr[3] = t.a2(A1, A13, 0.12f);
            this.S = new ColorStateList(V, iArr);
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
