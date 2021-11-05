package c.b.a.b.d0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.q.r;
import c.b.a.a.c.n.c;
import c.b.a.b.b;
import c.b.a.b.c0.i;
import c.b.a.b.k;
import c.b.a.b.l;

public class a extends r {
    public static final int g = k.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f2954e;
    public boolean f;

    /* JADX WARNING: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r3, g), attributeSet, r3);
        int i = b.radioButtonStyle;
        Context context2 = getContext();
        TypedArray d2 = i.d(context2, attributeSet, l.MaterialRadioButton, i, g, new int[0]);
        if (d2.hasValue(l.MaterialRadioButton_buttonTint)) {
            setButtonTintList(c.Z0(context2, d2, l.MaterialRadioButton_buttonTint));
        }
        this.f = d2.getBoolean(l.MaterialRadioButton_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2954e == null) {
            int Y0 = c.Y0(this, b.colorControlActivated);
            int Y02 = c.Y0(this, b.colorOnSurface);
            int Y03 = c.Y0(this, b.colorSurface);
            int[] iArr = new int[h.length];
            iArr[0] = c.x1(Y03, Y0, 1.0f);
            iArr[1] = c.x1(Y03, Y02, 0.54f);
            iArr[2] = c.x1(Y03, Y02, 0.38f);
            iArr[3] = c.x1(Y03, Y02, 0.38f);
            this.f2954e = new ColorStateList(h, iArr);
        }
        return this.f2954e;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
