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
import b.b.f;
import b.b.j;
import b.b.q.b;
import b.b.q.q0;
import b.i.l.m;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f39b;

    /* renamed from: c  reason: collision with root package name */
    public View f40c;

    /* renamed from: d  reason: collision with root package name */
    public View f41d;

    /* renamed from: e  reason: collision with root package name */
    public View f42e;
    public Drawable f;
    public Drawable g;
    public Drawable h;
    public boolean i;
    public boolean j;
    public int k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.W(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.f = obtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.g = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.k = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        boolean z = true;
        if (getId() == f.split_action_bar) {
            this.i = true;
            this.h = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.i ? !(this.f == null && this.g == null) : this.h != null) {
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

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f;
        if (drawable != null && drawable.isStateful()) {
            this.f.setState(getDrawableState());
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.g.setState(getDrawableState());
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f40c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f41d = findViewById(f.action_bar);
        this.f42e = findViewById(f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f39b || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        View view2 = this.f40c;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (!(view2 == null || view2.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i6 = ((FrameLayout.LayoutParams) view2.getLayoutParams()).bottomMargin;
            view2.layout(i2, (measuredHeight - view2.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
        }
        if (this.i) {
            Drawable drawable3 = this.h;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                if (z2) {
                    invalidate();
                    return;
                }
                return;
            }
        } else {
            if (this.f != null) {
                if (this.f41d.getVisibility() == 0) {
                    drawable2 = this.f;
                    left = this.f41d.getLeft();
                    top = this.f41d.getTop();
                    right = this.f41d.getRight();
                    view = this.f41d;
                } else {
                    View view3 = this.f42e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f.setBounds(0, 0, 0, 0);
                        z3 = true;
                    } else {
                        drawable2 = this.f;
                        left = this.f42e.getLeft();
                        top = this.f42e.getTop();
                        right = this.f42e.getRight();
                        view = this.f42e;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.j = z4;
            if (z4 && (drawable = this.g) != null) {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                if (z2) {
                }
            }
        }
        z2 = z3;
        if (z2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    public void onMeasure(int i2, int i3) {
        int i4;
        View view;
        int i5;
        if (this.f41d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f41d != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view2 = this.f40c;
            if (view2 != null && view2.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f41d)) {
                    view = this.f41d;
                } else if (!b(this.f42e)) {
                    view = this.f42e;
                } else {
                    i4 = 0;
                    setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f40c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
                }
                i4 = a(view);
                setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f40c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f);
        }
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f41d;
            if (view != null) {
                this.f.setBounds(view.getLeft(), this.f41d.getTop(), this.f41d.getRight(), this.f41d.getBottom());
            }
        }
        boolean z = true;
        if (!this.i ? !(this.f == null && this.g == null) : this.h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.h);
        }
        this.h = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.i && (drawable2 = this.h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.i ? this.f == null && this.g == null : this.h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.g);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.j && (drawable2 = this.g) != null) {
                drawable2.setBounds(this.f40c.getLeft(), this.f40c.getTop(), this.f40c.getRight(), this.f40c.getBottom());
            }
        }
        boolean z = true;
        if (!this.i ? !(this.f == null && this.g == null) : this.h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(q0 q0Var) {
        View view = this.f40c;
        if (view != null) {
            removeView(view);
        }
        this.f40c = q0Var;
        if (q0Var != null) {
            addView(q0Var);
            ViewGroup.LayoutParams layoutParams = q0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            q0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f39b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f && !this.i) || (drawable == this.g && this.j) || ((drawable == this.h && this.i) || super.verifyDrawable(drawable));
    }
}
