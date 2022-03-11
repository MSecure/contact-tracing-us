package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import e.h.a.i.a;
import e.h.a.i.d;
import e.h.c.b;
/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: j  reason: collision with root package name */
    public int f108j;

    /* renamed from: k  reason: collision with root package name */
    public int f109k;

    /* renamed from: l  reason: collision with root package name */
    public a f110l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f110l.t0;
    }

    public int getMargin() {
        return this.f110l.u0;
    }

    public int getType() {
        return this.f108j;
    }

    @Override // e.h.c.b
    public void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f110l = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f110l.t0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f110l.u0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1470e = this.f110l;
        n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
        if (r0 == 6) goto L_0x0010;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r0 == 6) goto L_0x0016;
     */
    @Override // e.h.c.b
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void j(d dVar, boolean z) {
        int i2;
        int i3 = this.f108j;
        this.f109k = i3;
        if (z) {
            if (i3 != 5) {
            }
            i2 = 1;
        } else {
            if (i3 != 5) {
            }
            i2 = 0;
        }
        this.f109k = i2;
        if (dVar instanceof a) {
            ((a) dVar).s0 = this.f109k;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f110l.t0 = z;
    }

    public void setDpMargin(int i2) {
        this.f110l.u0 = (int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i2) {
        this.f110l.u0 = i2;
    }

    public void setType(int i2) {
        this.f108j = i2;
    }
}
