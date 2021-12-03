package e.g.b.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import e.g.b.a.c;

public class b extends e.g.c.b implements c.AbstractC0029c {

    /* renamed from: j  reason: collision with root package name */
    public boolean f1365j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1366k;

    /* renamed from: l  reason: collision with root package name */
    public float f1367l;
    public View[] m;

    @Override // e.g.b.a.c.AbstractC0029c
    public void a(c cVar, int i2, int i3) {
    }

    @Override // e.g.b.a.c.AbstractC0029c
    public void b(c cVar, int i2, int i3, float f2) {
    }

    public float getProgress() {
        return this.f1367l;
    }

    @Override // e.g.c.b
    public void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.f1365j = obtainStyledAttributes.getBoolean(index, this.f1365j);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.f1366k = obtainStyledAttributes.getBoolean(index, this.f1366k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void o() {
    }

    public void setProgress(float f2) {
        this.f1367l = f2;
        int i2 = 0;
        if (this.c > 0) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            View[] viewArr = this.f1389h;
            if (viewArr == null || viewArr.length != this.c) {
                this.f1389h = new View[this.c];
            }
            for (int i3 = 0; i3 < this.c; i3++) {
                this.f1389h[i3] = constraintLayout.d(this.b[i3]);
            }
            this.m = this.f1389h;
            while (i2 < this.c) {
                View view = this.m[i2];
                o();
                i2++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i2 < childCount) {
            if (!(viewGroup.getChildAt(i2) instanceof b)) {
                o();
            }
            i2++;
        }
    }
}
