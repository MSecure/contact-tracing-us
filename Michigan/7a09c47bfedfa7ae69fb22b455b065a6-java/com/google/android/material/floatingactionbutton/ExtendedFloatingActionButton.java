package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.m;
import c.b.a.b.b0.i;
import c.b.a.b.c0.d;
import c.b.a.b.l;
import c.b.a.b.m.g;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public final i t;
    public final i u;
    public final i v;
    public final i w;
    public boolean x;

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f6081a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6082b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6083c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f6082b = false;
            this.f6083c = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ExtendedFloatingActionButton_Behavior_Layout);
            this.f6082b = obtainStyledAttributes.getBoolean(l.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f6083c = obtainStyledAttributes.getBoolean(l.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        public final boolean B(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams();
            if ((this.f6082b || this.f6083c) && fVar.f191f == view.getId()) {
                return true;
            }
            return false;
        }

        public final boolean C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            i iVar;
            i iVar2;
            if (!B(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f6081a == null) {
                this.f6081a = new Rect();
            }
            Rect rect = this.f6081a;
            d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (this.f6083c) {
                    iVar2 = extendedFloatingActionButton.t;
                } else {
                    iVar2 = extendedFloatingActionButton.w;
                }
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, iVar2);
                return true;
            }
            if (this.f6083c) {
                iVar = extendedFloatingActionButton.u;
            } else {
                iVar = extendedFloatingActionButton.v;
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, iVar);
            return true;
        }

        public final boolean D(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            i iVar;
            i iVar2;
            if (!B(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                if (this.f6083c) {
                    iVar2 = extendedFloatingActionButton.t;
                } else {
                    iVar2 = extendedFloatingActionButton.w;
                }
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, iVar2);
                return true;
            }
            if (this.f6083c) {
                iVar = extendedFloatingActionButton.u;
            } else {
                iVar = extendedFloatingActionButton.v;
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, iVar);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                C(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f186a instanceof BottomSheetBehavior : false) {
                    D(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List<View> d2 = coordinatorLayout.d(extendedFloatingActionButton);
            int size = d2.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = d2.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f186a instanceof BottomSheetBehavior : false) && D(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (C(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.q(extendedFloatingActionButton, i);
            return true;
        }
    }

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f2) {
            View view2 = view;
            view2.getLayoutParams().width = f2.intValue();
            view2.requestLayout();
        }
    }

    public static class b extends Property<View, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f2) {
            View view2 = view;
            view2.getLayoutParams().height = f2.intValue();
            view2.requestLayout();
        }
    }

    public static abstract class c {
    }

    static {
        new a(Float.class, "width");
        new b(Float.class, "height");
    }

    public static void i(ExtendedFloatingActionButton extendedFloatingActionButton, i iVar) {
        if (extendedFloatingActionButton == null) {
            throw null;
        } else if (!iVar.f()) {
            if (!(m.C(extendedFloatingActionButton) && !extendedFloatingActionButton.isInEditMode())) {
                iVar.g();
                iVar.e(null);
                return;
            }
            extendedFloatingActionButton.measure(0, 0);
            AnimatorSet a2 = iVar.a();
            a2.addListener(new c.b.a.b.b0.a(extendedFloatingActionButton, iVar));
            for (Animator.AnimatorListener animatorListener : iVar.d()) {
                a2.addListener(animatorListener);
            }
            a2.start();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public int getCollapsedSize() {
        return getIconSize() + (Math.min(m.t(this), getPaddingEnd()) * 2);
    }

    public g getExtendMotionSpec() {
        throw null;
    }

    public g getHideMotionSpec() {
        throw null;
    }

    public g getShowMotionSpec() {
        throw null;
    }

    public g getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.x && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.x = false;
            throw null;
        }
    }

    public void setExtendMotionSpec(g gVar) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(g.b(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.x != z) {
            i iVar = null;
            if (!iVar.f()) {
                iVar.g();
            }
        }
    }

    public void setHideMotionSpec(g gVar) {
        throw null;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(g.b(getContext(), i));
    }

    public void setShowMotionSpec(g gVar) {
        throw null;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(g.b(getContext(), i));
    }

    public void setShrinkMotionSpec(g gVar) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(g.b(getContext(), i));
    }
}
