package e.n.a;

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
import e.i.i.b0;
import e.i.i.v;
import f.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class y extends FrameLayout {
    public ArrayList<View> b;
    public ArrayList<View> c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1799d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1800e = true;

    public y(Context context) {
        super(context);
    }

    public y(Context context, AttributeSet attributeSet, e0 e0Var) {
        super(context, attributeSet);
        View view;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        m H = e0Var.H(id);
        if (classAttribute != null && H == null) {
            if (id <= 0) {
                throw new IllegalStateException(a.c("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? a.w(" with tag ", string) : ""));
            }
            m a = e0Var.L().a(context.getClassLoader(), classAttribute);
            a.a0(context, attributeSet, null);
            a aVar = new a(e0Var);
            aVar.p = true;
            a.E = this;
            aVar.e(getId(), a, string, 1);
            if (!aVar.f1745g) {
                aVar.f1746h = false;
                aVar.q.D(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = ((ArrayList) e0Var.c.f()).iterator();
        while (it.hasNext()) {
            k0 k0Var = (k0) it.next();
            m mVar = k0Var.c;
            if (mVar.x == getId() && (view = mVar.F) != null && view.getParent() == null) {
                mVar.E = this;
                k0Var.b();
            }
        }
    }

    public final void a(View view) {
        ArrayList<View> arrayList = this.c;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            this.b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if ((tag instanceof m ? (m) tag : null) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if ((tag instanceof m ? (m) tag : null) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        b0 i2 = b0.i(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1799d;
        b0 h2 = onApplyWindowInsetsListener != null ? b0.h(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : v.p(this, i2);
        if (!h2.f()) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                v.e(getChildAt(i3), h2);
            }
        }
        return windowInsets;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f1800e && this.b != null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                super.drawChild(canvas, this.b.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList<View> arrayList;
        if (!this.f1800e || (arrayList = this.b) == null || arrayList.size() <= 0 || !this.b.contains(view)) {
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
                this.f1800e = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
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
        this.f1800e = z;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f1799d = onApplyWindowInsetsListener;
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
