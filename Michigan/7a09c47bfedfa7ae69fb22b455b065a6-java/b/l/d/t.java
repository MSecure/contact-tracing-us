package b.l.d;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import b.l.b;
import b.l.c;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class t extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<View> f2131b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<View> f2132c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2133d = true;

    public t(Context context, AttributeSet attributeSet, z zVar) {
        super(context, attributeSet);
        View view;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(c.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(c.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment I = zVar.I(id);
        if (classAttribute != null && I == null) {
            if (id <= 0) {
                throw new IllegalStateException(a.c("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? a.q(" with tag ", string) : ""));
            }
            Fragment a2 = zVar.M().a(context.getClassLoader(), classAttribute);
            a2.onInflate(context, attributeSet, (Bundle) null);
            a aVar = new a(zVar);
            aVar.p = true;
            a2.mContainer = this;
            aVar.g(getId(), a2, string, 1);
            aVar.f();
        }
        Iterator it = ((ArrayList) zVar.f2180c.f()).iterator();
        while (it.hasNext()) {
            g0 g0Var = (g0) it.next();
            Fragment fragment = g0Var.f2021c;
            if (fragment.mContainerId == getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = this;
                g0Var.b();
            }
        }
    }

    public final void a(View view) {
        ArrayList<View> arrayList = this.f2132c;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.f2131b == null) {
                this.f2131b = new ArrayList<>();
            }
            this.f2131b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(b.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        Object tag = view.getTag(b.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f2133d && this.f2131b != null) {
            for (int i = 0; i < this.f2131b.size(); i++) {
                super.drawChild(canvas, this.f2131b.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList<View> arrayList;
        if (!this.f2133d || (arrayList = this.f2131b) == null || arrayList.size() <= 0 || !this.f2131b.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f2132c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f2131b;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f2133d = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
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

    public void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.f2133d = z;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f2132c == null) {
                this.f2132c = new ArrayList<>();
            }
            this.f2132c.add(view);
        }
        super.startViewTransition(view);
    }
}
