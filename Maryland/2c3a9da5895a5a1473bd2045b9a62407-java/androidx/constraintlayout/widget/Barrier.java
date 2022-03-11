package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import e.g.b.h.a;
import e.g.b.h.d;
import e.g.c.b;

public class Barrier extends b {

    /* renamed from: i  reason: collision with root package name */
    public int f104i;

    /* renamed from: j  reason: collision with root package name */
    public int f105j;

    /* renamed from: k  reason: collision with root package name */
    public a f106k;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    @Override // e.g.c.b
    public void f(AttributeSet attributeSet) {
        super.f(attributeSet);
        this.f106k = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f106k.o0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f106k.p0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1355e = this.f106k;
        k();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r0 == 6) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r0 == 6) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // e.g.c.b
    public void g(d dVar, boolean z) {
        int i2;
        int i3 = this.f104i;
        this.f105j = i3;
        if (z) {
            if (i3 != 5) {
            }
            i2 = 1;
            this.f105j = i2;
            if (!(dVar instanceof a)) {
                ((a) dVar).n0 = this.f105j;
                return;
            }
            return;
        } else if (i3 != 5) {
        }
        i2 = 0;
        this.f105j = i2;
        if (!(dVar instanceof a)) {
        }
    }

    public int getMargin() {
        return this.f106k.p0;
    }

    public int getType() {
        return this.f104i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f106k.o0 = z;
    }

    public void setDpMargin(int i2) {
        this.f106k.p0 = (int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i2) {
        this.f106k.p0 = i2;
    }

    public void setType(int i2) {
        this.f104i = i2;
    }
}
