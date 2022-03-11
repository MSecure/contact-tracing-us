package e.m.a;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R$id;
import androidx.fragment.R$styleable;
import f.a.a.a.a;
import java.util.ArrayList;

public final class w extends FrameLayout {
    public ArrayList<View> b;
    public ArrayList<View> c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1691d = true;

    public w(Context context) {
        super(context);
    }

    public w(Context context, AttributeSet attributeSet, c0 c0Var) {
        super(context, attributeSet);
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        l I = c0Var.I(id);
        if (classAttribute != null && I == null) {
            if (id <= 0) {
                throw new IllegalStateException(a.c("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? a.t(" with tag ", string) : ""));
            }
            l a = c0Var.M().a(context.getClassLoader(), classAttribute);
            a.W(context, attributeSet, null);
            a aVar = new a(c0Var);
            aVar.p = true;
            a.E = this;
            aVar.e(getId(), a, string, 1);
            if (!aVar.f1638g) {
                aVar.f1639h = false;
                aVar.q.E(aVar, true);
                return;
            }
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
    }

    public final void a(View view) {
        ArrayList<View> arrayList;
        if (view.getAnimation() != null || ((arrayList = this.c) != null && arrayList.contains(view))) {
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            this.b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if ((tag instanceof l ? (l) tag : null) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if ((tag instanceof l ? (l) tag : null) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f1691d && this.b != null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                super.drawChild(canvas, this.b.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList<View> arrayList;
        if (!this.f1691d || (arrayList = this.b) == null || arrayList.size() <= 0 || !this.b.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.b;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1691d = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
        }
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    public void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    public void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.f1691d = z;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            this.c.add(view);
        }
        super.startViewTransition(view);
    }
}
