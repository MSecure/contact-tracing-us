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
import e.i.i.l;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionBarContainer extends FrameLayout {
    public boolean b;
    public View c;

    /* renamed from: d  reason: collision with root package name */
    public View f44d;

    /* renamed from: e  reason: collision with root package name */
    public View f45e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f46f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f47g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f48h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50j;

    /* renamed from: k  reason: collision with root package name */
    public int f51k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        AtomicInteger atomicInteger = l.a;
        setBackground(bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f46f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f47g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f51k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R$id.split_action_bar) {
            this.f49i = true;
            this.f48h = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f49i ? !(this.f46f == null && this.f47g == null) : this.f48h != null) {
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
        Drawable drawable = this.f46f;
        if (drawable != null && drawable.isStateful()) {
            this.f46f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f47g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f47g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f48h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f48h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f46f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f47g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f48h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f44d = findViewById(R$id.action_bar);
        this.f45e = findViewById(R$id.action_context_bar);
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
        if (this.f49i) {
            Drawable drawable3 = this.f48h;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f46f != null) {
                if (this.f44d.getVisibility() == 0) {
                    drawable2 = this.f46f;
                    left = this.f44d.getLeft();
                    top = this.f44d.getTop();
                    right = this.f44d.getRight();
                    view = this.f44d;
                } else {
                    View view3 = this.f45e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f46f.setBounds(0, 0, 0, 0);
                        z3 = true;
                    } else {
                        drawable2 = this.f46f;
                        left = this.f45e.getLeft();
                        top = this.f45e.getTop();
                        right = this.f45e.getRight();
                        view = this.f45e;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.f50j = z4;
            if (!z4 || (drawable = this.f47g) == null) {
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
        if (this.f44d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.f51k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f44d != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view2 = this.c;
            if (view2 != null && view2.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f44d)) {
                    view = this.f44d;
                } else if (!b(this.f45e)) {
                    view = this.f45e;
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
        Drawable drawable2 = this.f46f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f46f);
        }
        this.f46f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f44d;
            if (view != null) {
                this.f46f.setBounds(view.getLeft(), this.f44d.getTop(), this.f44d.getRight(), this.f44d.getBottom());
            }
        }
        boolean z = true;
        if (!this.f49i ? !(this.f46f == null && this.f47g == null) : this.f48h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f48h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f48h);
        }
        this.f48h = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f49i && (drawable2 = this.f48h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f49i ? this.f46f == null && this.f47g == null : this.f48h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f47g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f47g);
        }
        this.f47g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f50j && (drawable2 = this.f47g) != null) {
                drawable2.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f49i ? !(this.f46f == null && this.f47g == null) : this.f48h != null) {
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
        Drawable drawable = this.f46f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f47g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f48h;
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
        return (drawable == this.f46f && !this.f49i) || (drawable == this.f47g && this.f50j) || ((drawable == this.f48h && this.f49i) || super.verifyDrawable(drawable));
    }
}
