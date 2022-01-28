package e.g.c;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

public abstract class i extends b {

    /* renamed from: j  reason: collision with root package name */
    public boolean f1443j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1444k;

    @Override // e.g.c.b
    public void g(ConstraintLayout constraintLayout) {
        f(constraintLayout);
    }

    @Override // e.g.c.b
    public void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f1443j = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f1444k = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void o() {
    }

    @Override // e.g.c.b
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1443j || this.f1444k) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i2 = 0; i2 < this.c; i2++) {
                    View d2 = constraintLayout.d(this.b[i2]);
                    if (d2 != null) {
                        if (this.f1443j) {
                            d2.setVisibility(visibility);
                        }
                        if (this.f1444k && elevation > 0.0f) {
                            d2.setTranslationZ(d2.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            f((ConstraintLayout) parent);
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            f((ConstraintLayout) parent);
        }
    }
}
