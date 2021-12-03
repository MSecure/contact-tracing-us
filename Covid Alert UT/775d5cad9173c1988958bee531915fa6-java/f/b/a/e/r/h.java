package f.b.a.e.r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import f.b.a.c.b.o.b;
import f.b.a.e.q.k;

public final class h extends c {

    /* renamed from: g  reason: collision with root package name */
    public int f2996g;

    /* renamed from: h  reason: collision with root package name */
    public int f2997h;

    /* renamed from: i  reason: collision with root package name */
    public int f2998i;

    /* JADX WARNING: Illegal instructions before constructor call */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r6, r7);
        int i2 = R$attr.circularProgressIndicatorStyle;
        int i3 = CircularProgressIndicator.q;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        int[] iArr = R$styleable.CircularProgressIndicator;
        k.a(context, attributeSet, i2, i3);
        k.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f2996g = Math.max(b.B0(context, obtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.a * 2);
        this.f2997h = b.B0(context, obtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f2998i = obtainStyledAttributes.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        obtainStyledAttributes.recycle();
    }
}
