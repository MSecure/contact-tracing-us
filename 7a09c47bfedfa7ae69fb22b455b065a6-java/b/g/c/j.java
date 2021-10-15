package b.g.c;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class j extends b {
    public boolean i;
    public boolean j;

    @Override // b.g.c.b
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.ConstraintLayout_Layout_android_visibility) {
                    this.i = true;
                } else if (index == i.ConstraintLayout_Layout_android_elevation) {
                    this.j = true;
                }
            }
        }
    }

    public void j() {
    }

    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.i || this.j) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i2 = 0; i2 < this.f1583c; i2++) {
                View e2 = constraintLayout.e(this.f1582b[i2]);
                if (e2 != null) {
                    if (this.i) {
                        e2.setVisibility(visibility);
                    }
                    if (this.j && elevation > 0.0f) {
                        e2.setTranslationZ(e2.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        c();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        c();
    }
}
