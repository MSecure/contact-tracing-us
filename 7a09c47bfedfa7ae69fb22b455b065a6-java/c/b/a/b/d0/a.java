package c.b.a.b.d0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.q.r;
import b.x.t;
import c.b.a.b.b;
import c.b.a.b.k;
import c.b.a.b.l;

public class a extends r {

    /* renamed from: g  reason: collision with root package name */
    public static final int f4225g = k.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f4226e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4227f;

    /* JADX WARNING: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r3, f4225g), attributeSet, r3);
        int i = b.radioButtonStyle;
        Context context2 = getContext();
        TypedArray d2 = c.b.a.b.c0.k.d(context2, attributeSet, l.MaterialRadioButton, i, f4225g, new int[0]);
        if (d2.hasValue(l.MaterialRadioButton_buttonTint)) {
            setButtonTintList(t.B1(context2, d2, l.MaterialRadioButton_buttonTint));
        }
        this.f4227f = d2.getBoolean(l.MaterialRadioButton_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4226e == null) {
            int A1 = t.A1(this, b.colorControlActivated);
            int A12 = t.A1(this, b.colorOnSurface);
            int A13 = t.A1(this, b.colorSurface);
            int[] iArr = new int[h.length];
            iArr[0] = t.a2(A13, A1, 1.0f);
            iArr[1] = t.a2(A13, A12, 0.54f);
            iArr[2] = t.a2(A13, A12, 0.38f);
            iArr[3] = t.a2(A13, A12, 0.38f);
            this.f4226e = new ColorStateList(h, iArr);
        }
        return this.f4226e;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4227f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f4227f = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
