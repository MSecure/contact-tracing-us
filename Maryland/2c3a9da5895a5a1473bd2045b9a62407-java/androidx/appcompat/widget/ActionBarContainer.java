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
import e.b.f.q0;
import e.i.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionBarContainer extends FrameLayout {
    public boolean b;
    public View c;

    /* renamed from: d  reason: collision with root package name */
    public View f52d;

    /* renamed from: e  reason: collision with root package name */
    public View f53e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f54f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f55g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f56h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58j;

    /* renamed from: k  reason: collision with root package name */
    public int f59k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        AtomicInteger atomicInteger = m.a;
        setBackground(bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f54f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f55g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f59k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R$id.split_action_bar) {
            this.f57i = true;
            this.f56h = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f57i ? !(this.f54f == null && this.f55g == null) : this.f56h != null) {
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
        Drawable drawable = this.f54f;
        if (drawable != null && drawable.isStateful()) {
            this.f54f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f55g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f55g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f56h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f56h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f54f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f55g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f56h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f52d = findViewById(R$id.action_bar);
        this.f53e = findViewById(R$id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b || super.onInterceptTouchEvent(motionEvent);
    }

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
        boolean z3 = false;
        boolean z4 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (!(view2 == null || view2.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i6 = ((FrameLayout.LayoutParams) view2.getLayoutParams()).bottomMargin;
            view2.layout(i2, (measuredHeight - view2.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
        }
        if (this.f57i) {
            Drawable drawable3 = this.f56h;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f54f != null) {
                if (this.f52d.getVisibility() == 0) {
                    drawable2 = this.f54f;
                    left = this.f52d.getLeft();
                    top = this.f52d.getTop();
                    right = this.f52d.getRight();
                    view = this.f52d;
                } else {
                    View view3 = this.f53e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f54f.setBounds(0, 0, 0, 0);
                        z3 = true;
                    } else {
                        drawable2 = this.f54f;
                        left = this.f53e.getLeft();
                        top = this.f53e.getTop();
                        right = this.f53e.getRight();
                        view = this.f53e;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.f58j = z4;
            if (!z4 || (drawable = this.f55g) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    public void onMeasure(int i2, int i3) {
        int i4;
        View view;
        int i5;
        if (this.f52d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.f59k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f52d != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view2 = this.c;
            if (view2 != null && view2.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f52d)) {
                    view = this.f52d;
                } else if (!b(this.f53e)) {
                    view = this.f53e;
                } else {
                    i4 = 0;
                    setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
                }
                i4 = a(view);
                setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.c) + i4, mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f54f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f54f);
        }
        this.f54f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f52d;
            if (view != null) {
                this.f54f.setBounds(view.getLeft(), this.f52d.getTop(), this.f52d.getRight(), this.f52d.getBottom());
            }
        }
        boolean z = true;
        if (!this.f57i ? !(this.f54f == null && this.f55g == null) : this.f56h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f56h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f56h);
        }
        this.f56h = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f57i && (drawable2 = this.f56h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f57i ? this.f54f == null && this.f55g == null : this.f56h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f55g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f55g);
        }
        this.f55g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f58j && (drawable2 = this.f55g) != null) {
                drawable2.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f57i ? !(this.f54f == null && this.f55g == null) : this.f56h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(q0 q0Var) {
        View view = this.c;
        if (view != null) {
            removeView(view);
        }
        this.c = q0Var;
        if (q0Var != null) {
            addView(q0Var);
            ViewGroup.LayoutParams layoutParams = q0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            q0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f54f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f55g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f56h;
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
        return (drawable == this.f54f && !this.f57i) || (drawable == this.f55g && this.f58j) || ((drawable == this.f56h && this.f57i) || super.verifyDrawable(drawable));
    }
}
