package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.q.s0;
import c.b.a.a.c.n.c;
import c.b.a.b.b;
import c.b.a.b.c0.i;
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
        TypedArray d2 = i.d(context2, attributeSet, l.SwitchMaterial, i, U, new int[0]);
        this.T = d2.getBoolean(l.SwitchMaterial_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.R == null) {
            int Y0 = c.Y0(this, b.colorSurface);
            int Y02 = c.Y0(this, b.colorControlActivated);
            float dimension = getResources().getDimension(d.mtrl_switch_thumb_elevation);
            if (this.Q.f3306a) {
                dimension += c.h1(this);
            }
            int a2 = this.Q.a(Y0, dimension);
            int[] iArr = new int[V.length];
            iArr[0] = c.x1(Y0, Y02, 1.0f);
            iArr[1] = a2;
            iArr[2] = c.x1(Y0, Y02, 0.38f);
            iArr[3] = a2;
            this.R = new ColorStateList(V, iArr);
        }
        return this.R;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.S == null) {
            int[] iArr = new int[V.length];
            int Y0 = c.Y0(this, b.colorSurface);
            int Y02 = c.Y0(this, b.colorControlActivated);
            int Y03 = c.Y0(this, b.colorOnSurface);
            iArr[0] = c.x1(Y0, Y02, 0.54f);
            iArr[1] = c.x1(Y0, Y03, 0.32f);
            iArr[2] = c.x1(Y0, Y02, 0.12f);
            iArr[3] = c.x1(Y0, Y03, 0.12f);
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
