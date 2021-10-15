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
import com.google.android.gms.nearby.messages.BleSignal;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f77b;

    /* renamed from: c  reason: collision with root package name */
    public View f78c;

    /* renamed from: d  reason: collision with root package name */
    public View f79d;

    /* renamed from: e  reason: collision with root package name */
    public View f80e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f81f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f82g;
    public Drawable h;
    public boolean i;
    public boolean j;
    public int k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.X(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.f81f = obtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.f82g = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.k = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        boolean z = true;
        if (getId() == f.split_action_bar) {
            this.i = true;
            this.h = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.i ? !(this.f81f == null && this.f82g == null) : this.h != null) {
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
        Drawable drawable = this.f81f;
        if (drawable != null && drawable.isStateful()) {
            this.f81f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f82g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f82g.setState(getDrawableState());
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f78c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f81f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f82g;
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
        this.f79d = findViewById(f.action_bar);
        this.f80e = findViewById(f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f77b || super.onInterceptTouchEvent(motionEvent);
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
        View view2 = this.f78c;
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
            if (this.f81f != null) {
                if (this.f79d.getVisibility() == 0) {
                    drawable2 = this.f81f;
                    left = this.f79d.getLeft();
                    top = this.f79d.getTop();
                    right = this.f79d.getRight();
                    view = this.f79d;
                } else {
                    View view3 = this.f80e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f81f.setBounds(0, 0, 0, 0);
                        z3 = true;
                    } else {
                        drawable2 = this.f81f;
                        left = this.f80e.getLeft();
                        top = this.f80e.getTop();
                        right = this.f80e.getRight();
                        view = this.f80e;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.j = z4;
            if (z4 && (drawable = this.f82g) != null) {
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
        if (this.f79d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), BleSignal.UNKNOWN_TX_POWER);
        }
        super.onMeasure(i2, i3);
        if (this.f79d != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view2 = this.f78c;
            if (view2 != null && view2.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f79d)) {
                    view = this.f79d;
                } else if (!b(this.f80e)) {
                    view = this.f80e;
                } else {
                    i4 = 0;
                    setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f78c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
                }
                i4 = a(view);
                setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f78c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f81f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f81f);
        }
        this.f81f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f79d;
            if (view != null) {
                this.f81f.setBounds(view.getLeft(), this.f79d.getTop(), this.f79d.getRight(), this.f79d.getBottom());
            }
        }
        boolean z = true;
        if (!this.i ? !(this.f81f == null && this.f82g == null) : this.h != null) {
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
        if (!this.i ? this.f81f == null && this.f82g == null : this.h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f82g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f82g);
        }
        this.f82g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.j && (drawable2 = this.f82g) != null) {
                drawable2.setBounds(this.f78c.getLeft(), this.f78c.getTop(), this.f78c.getRight(), this.f78c.getBottom());
            }
        }
        boolean z = true;
        if (!this.i ? !(this.f81f == null && this.f82g == null) : this.h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(q0 q0Var) {
        View view = this.f78c;
        if (view != null) {
            removeView(view);
        }
        this.f78c = q0Var;
        if (q0Var != null) {
            addView(q0Var);
            ViewGroup.LayoutParams layoutParams = q0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            q0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f77b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f81f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f82g;
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
        return (drawable == this.f81f && !this.i) || (drawable == this.f82g && this.j) || ((drawable == this.h && this.i) || super.verifyDrawable(drawable));
    }
}
