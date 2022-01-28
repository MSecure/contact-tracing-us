package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.g.b.h.a;
import b.g.c.b;
import b.g.c.i;

public class Barrier extends b {
    public int i;
    public int j;
    public a k;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    @Override // b.g.c.b
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.k = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.k.g0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == i.ConstraintLayout_Layout_barrierMargin) {
                    this.k.h0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
        }
        this.f1585e = this.k;
        i();
    }

    public int getMargin() {
        return this.k.h0;
    }

    public int getType() {
        return this.i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.k.g0 = z;
    }

    public void setDpMargin(int i2) {
        this.k.h0 = (int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i2) {
        this.k.h0 = i2;
    }

    public void setType(int i2) {
        this.i = i2;
    }
}
