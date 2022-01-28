package f.b.a.e.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.f.g;
import f.b.a.c.b.o.b;
import f.b.a.e.q.k;

public class a extends g {

    /* renamed from: h  reason: collision with root package name */
    public static final int f2875h = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: i  reason: collision with root package name */
    public static final int[][] f2876i = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f2877f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2878g;

    /* JADX WARNING: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.checkboxStyle;
        int i3 = f2875h;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialCheckBox, i2, i3, new int[0]);
        int i4 = R$styleable.MaterialCheckBox_buttonTint;
        if (d2.hasValue(i4)) {
            setButtonTintList(b.x0(context2, d2, i4));
        }
        this.f2878g = d2.getBoolean(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2877f == null) {
            int[][] iArr = f2876i;
            int[] iArr2 = new int[iArr.length];
            int w0 = b.w0(this, R$attr.colorControlActivated);
            int w02 = b.w0(this, R$attr.colorSurface);
            int w03 = b.w0(this, R$attr.colorOnSurface);
            iArr2[0] = b.a1(w02, w0, 1.0f);
            iArr2[1] = b.a1(w02, w03, 0.54f);
            iArr2[2] = b.a1(w02, w03, 0.38f);
            iArr2[3] = b.a1(w02, w03, 0.38f);
            this.f2877f = new ColorStateList(iArr, iArr2);
        }
        return this.f2877f;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2878g && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f2878g = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
