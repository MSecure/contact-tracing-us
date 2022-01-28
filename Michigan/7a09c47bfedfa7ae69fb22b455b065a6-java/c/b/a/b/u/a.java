package c.b.a.b.u;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.q.g;
import b.x.t;
import c.b.a.b.b;
import c.b.a.b.k;
import c.b.a.b.l;

public class a extends g {

    /* renamed from: g  reason: collision with root package name */
    public static final int f4527g = k.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[][] h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f4528e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4529f;

    /* JADX WARNING: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r3, f4527g), attributeSet, r3);
        int i = b.checkboxStyle;
        Context context2 = getContext();
        TypedArray d2 = c.b.a.b.c0.k.d(context2, attributeSet, l.MaterialCheckBox, i, f4527g, new int[0]);
        if (d2.hasValue(l.MaterialCheckBox_buttonTint)) {
            setButtonTintList(t.B1(context2, d2, l.MaterialCheckBox_buttonTint));
        }
        this.f4529f = d2.getBoolean(l.MaterialCheckBox_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4528e == null) {
            int[] iArr = new int[h.length];
            int A1 = t.A1(this, b.colorControlActivated);
            int A12 = t.A1(this, b.colorSurface);
            int A13 = t.A1(this, b.colorOnSurface);
            iArr[0] = t.a2(A12, A1, 1.0f);
            iArr[1] = t.a2(A12, A13, 0.54f);
            iArr[2] = t.a2(A12, A13, 0.38f);
            iArr[3] = t.a2(A12, A13, 0.38f);
            this.f4528e = new ColorStateList(h, iArr);
        }
        return this.f4528e;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4529f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f4529f = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
