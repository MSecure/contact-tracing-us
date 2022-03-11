package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import e.b.f.b;
import e.b.f.u0;
import e.j.j.v;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public boolean b;
    public View c;

    /* renamed from: d */
    public View f55d;

    /* renamed from: e */
    public View f56e;

    /* renamed from: f */
    public Drawable f57f;

    /* renamed from: g */
    public Drawable f58g;

    /* renamed from: h */
    public Drawable f59h;

    /* renamed from: i */
    public boolean f60i;

    /* renamed from: j */
    public boolean f61j;

    /* renamed from: k */
    public int f62k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        AtomicInteger atomicInteger = v.a;
        v.d.q(this, bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f57f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f58g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f62k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R$id.split_action_bar) {
            this.f60i = true;
            this.f59h = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f60i ? !(this.f57f == null && this.f58g == null) : this.f59h != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f57f;
        if (drawable != null && drawable.isStateful()) {
            this.f57f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f58g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f58g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f59h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f59h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.c;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f57f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f58g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f59h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f55d = findViewById(R$id.action_bar);
        this.f56e = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        View view2 = this.c;
        boolean z2 = true;
        z2 = false;
        boolean z3 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (!(view2 == null || view2.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i6 = ((FrameLayout.LayoutParams) view2.getLayoutParams()).bottomMargin;
            view2.layout(i2, (measuredHeight - view2.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
        }
        if (this.f60i) {
            Drawable drawable3 = this.f59h;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f57f != null) {
                if (this.f55d.getVisibility() == 0) {
                    drawable2 = this.f57f;
                    left = this.f55d.getLeft();
                    top = this.f55d.getTop();
                    right = this.f55d.getRight();
                    view = this.f55d;
                } else {
                    View view3 = this.f56e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f57f.setBounds(0, 0, 0, 0);
                        z2 = true;
                    } else {
                        drawable2 = this.f57f;
                        left = this.f56e.getLeft();
                        top = this.f56e.getTop();
                        right = this.f56e.getRight();
                        view = this.f56e;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z2 = true;
            }
            this.f61j = z3;
            if (z3 && (drawable = this.f58g) != null) {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onMeasure(int i2, int i3) {
        int i4;
        View view;
        int i5;
        if (this.f55d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.f62k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f55d != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view2 = this.c;
            if (view2 != null && view2.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f55d)) {
                    view = this.f55d;
                } else if (!b(this.f56e)) {
                    view = this.f56e;
                } else {
                    i4 = 0;
                    setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
                }
                i4 = a(view);
                setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f57f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f57f);
        }
        this.f57f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f55d;
            if (view != null) {
                this.f57f.setBounds(view.getLeft(), this.f55d.getTop(), this.f55d.getRight(), this.f55d.getBottom());
            }
        }
        boolean z = true;
        if (!this.f60i ? !(this.f57f == null && this.f58g == null) : this.f59h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f59h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f59h);
        }
        this.f59h = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f60i && (drawable2 = this.f59h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f60i ? this.f57f == null && this.f58g == null : this.f59h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f58g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f58g);
        }
        this.f58g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f61j && (drawable2 = this.f58g) != null) {
                drawable2.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f60i ? !(this.f57f == null && this.f58g == null) : this.f59h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(u0 u0Var) {
        View view = this.c;
        if (view != null) {
            removeView(view);
        }
        this.c = u0Var;
        if (u0Var != null) {
            addView(u0Var);
            ViewGroup.LayoutParams layoutParams = u0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            u0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f57f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f58g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f59h;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f57f && !this.f60i) || (drawable == this.f58g && this.f61j) || ((drawable == this.f59h && this.f60i) || super.verifyDrawable(drawable));
    }
}
