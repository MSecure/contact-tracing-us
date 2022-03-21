package e.g.c;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

public abstract class h extends b {

    /* renamed from: i  reason: collision with root package name */
    public boolean f1381i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1382j;

    @Override // e.g.c.b
    public void f(AttributeSet attributeSet) {
        super.f(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f1381i = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f1382j = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void l() {
    }

    @Override // e.g.c.b
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f1381i || this.f1382j) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i2 = 0; i2 < this.c; i2++) {
                View d2 = constraintLayout.d(this.b[i2]);
                if (d2 != null) {
                    if (this.f1381i) {
                        d2.setVisibility(visibility);
                    }
                    if (this.f1382j && elevation > 0.0f) {
                        d2.setTranslationZ(d2.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        d();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        d();
    }
}
