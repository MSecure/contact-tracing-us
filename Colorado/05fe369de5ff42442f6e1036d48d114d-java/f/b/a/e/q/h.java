package f.b.a.e.q;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.a.e.p.k;

public final class h extends c {

    /* renamed from: g  reason: collision with root package name */
    public int f2932g;

    /* renamed from: h  reason: collision with root package name */
    public int f2933h;

    /* renamed from: i  reason: collision with root package name */
    public int f2934i;

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
        this.f2932g = b.z0(context, obtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize);
        this.f2933h = b.z0(context, obtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f2934i = obtainStyledAttributes.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // f.b.a.e.q.c
    public void a() {
        if (this.f2932g < this.a * 2) {
            StringBuilder i2 = a.i("The indicatorSize (");
            i2.append(this.f2932g);
            i2.append(" px) cannot be less than twice of the trackThickness (");
            i2.append(this.a);
            i2.append(" px).");
            throw new IllegalArgumentException(i2.toString());
        }
    }
}
