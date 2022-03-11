package f.b.a.e.r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import f.b.a.c.b.o.b;
import f.b.a.e.q.k;
/* loaded from: classes.dex */
public abstract class c {
    public int a;
    public int b;
    public int[] c;

    /* renamed from: d */
    public int f3023d;

    /* renamed from: e */
    public int f3024e;

    /* renamed from: f */
    public int f3025f;

    public c(Context context, AttributeSet attributeSet, int i2, int i3) {
        int i4;
        this.c = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        int[] iArr = R$styleable.BaseProgressIndicator;
        k.a(context, attributeSet, i2, i3);
        k.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.a = b.C0(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.b = Math.min(b.C0(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.f3024e = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f3025f = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        int i5 = R$styleable.BaseProgressIndicator_indicatorColor;
        if (!obtainStyledAttributes.hasValue(i5)) {
            this.c = new int[]{b.w0(context, R$attr.colorPrimary, -1)};
        } else if (obtainStyledAttributes.peekValue(i5).type != 1) {
            this.c = new int[]{obtainStyledAttributes.getColor(i5, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(obtainStyledAttributes.getResourceId(i5, -1));
            this.c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        int i6 = R$styleable.BaseProgressIndicator_trackColor;
        if (obtainStyledAttributes.hasValue(i6)) {
            i4 = obtainStyledAttributes.getColor(i6, -1);
        } else {
            this.f3023d = this.c[0];
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{16842803});
            float f2 = obtainStyledAttributes2.getFloat(0, 0.2f);
            obtainStyledAttributes2.recycle();
            i4 = b.I(this.f3023d, (int) (f2 * 255.0f));
        }
        this.f3023d = i4;
        obtainStyledAttributes.recycle();
    }
}
