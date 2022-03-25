package f.b.a.d.r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.a.d.q.k;

public final class h extends c {

    /* renamed from: g  reason: collision with root package name */
    public int f2827g;

    /* renamed from: h  reason: collision with root package name */
    public int f2828h;

    /* renamed from: i  reason: collision with root package name */
    public int f2829i;

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
        this.f2827g = b.N0(context, obtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize);
        this.f2828h = b.N0(context, obtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f2829i = obtainStyledAttributes.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // f.b.a.d.r.c
    public void a() {
        if (this.f2827g < this.a * 2) {
            StringBuilder h2 = a.h("The indicatorSize (");
            h2.append(this.f2827g);
            h2.append(" px) cannot be less than twice of the trackThickness (");
            h2.append(this.a);
            h2.append(" px).");
            throw new IllegalArgumentException(h2.toString());
        }
    }
}
