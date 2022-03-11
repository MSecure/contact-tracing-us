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
/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: h  reason: collision with root package name */
    public static final int f2917h = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: i  reason: collision with root package name */
    public static final int[][] f2918i = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f2919f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2920g;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public a(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.checkboxStyle;
        int i3 = f2917h;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialCheckBox, i2, i3, new int[0]);
        int i4 = R$styleable.MaterialCheckBox_buttonTint;
        if (d2.hasValue(i4)) {
            setButtonTintList(b.y0(context2, d2, i4));
        }
        this.f2920g = d2.getBoolean(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        d2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2919f == null) {
            int[][] iArr = f2918i;
            int[] iArr2 = new int[iArr.length];
            int x0 = b.x0(this, R$attr.colorControlActivated);
            int x02 = b.x0(this, R$attr.colorSurface);
            int x03 = b.x0(this, R$attr.colorOnSurface);
            iArr2[0] = b.b1(x02, x0, 1.0f);
            iArr2[1] = b.b1(x02, x03, 0.54f);
            iArr2[2] = b.b1(x02, x03, 0.38f);
            iArr2[3] = b.b1(x02, x03, 0.38f);
            this.f2919f = new ColorStateList(iArr, iArr2);
        }
        return this.f2919f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2920g && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f2920g = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
