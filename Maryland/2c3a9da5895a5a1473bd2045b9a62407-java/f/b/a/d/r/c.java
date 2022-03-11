package f.b.a.d.r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import f.b.a.c.b.o.b;
import f.b.a.d.q.k;

public abstract class c {
    public int a;
    public int b;
    public int[] c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    public int f2812d;

    /* renamed from: e  reason: collision with root package name */
    public int f2813e;

    /* renamed from: f  reason: collision with root package name */
    public int f2814f;

    public c(Context context, AttributeSet attributeSet, int i2, int i3) {
        int i4;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        int[] iArr = R$styleable.BaseProgressIndicator;
        k.a(context, attributeSet, i2, i3);
        k.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.a = b.N0(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.b = Math.min(b.N0(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.f2813e = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f2814f = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        int i5 = R$styleable.BaseProgressIndicator_indicatorColor;
        if (!obtainStyledAttributes.hasValue(i5)) {
            this.c = new int[]{b.J0(context, R$attr.colorPrimary, -1)};
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
            this.f2812d = this.c[0];
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{16842803});
            float f2 = obtainStyledAttributes2.getFloat(0, 0.2f);
            obtainStyledAttributes2.recycle();
            i4 = b.M(this.f2812d, (int) (f2 * 255.0f));
        }
        this.f2812d = i4;
        obtainStyledAttributes.recycle();
    }

    public abstract void a();
}
