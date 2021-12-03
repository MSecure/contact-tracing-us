package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.b.e.i.g;
import e.b.e.i.n;
import e.b.f.c;
import e.b.f.i1;
import e.i.i.v;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionBarContextView extends e.b.f.a {

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f63j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f64k;

    /* renamed from: l  reason: collision with root package name */
    public View f65l;
    public View m;
    public View n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public int r;
    public int s;
    public boolean t;
    public int u;

    public class a implements View.OnClickListener {
        public final /* synthetic */ e.b.e.a b;

        public a(ActionBarContextView actionBarContextView, e.b.e.a aVar) {
            this.b = aVar;
        }

        public void onClick(View view) {
            this.b.c();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int resourceId;
        int i2 = R$attr.actionModeStyle;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMode, i2, 0);
        int i3 = R$styleable.ActionMode_background;
        Drawable drawable = (!obtainStyledAttributes.hasValue(i3) || (resourceId = obtainStyledAttributes.getResourceId(i3, 0)) == 0) ? obtainStyledAttributes.getDrawable(i3) : m.e.h0(context, resourceId);
        AtomicInteger atomicInteger = v.a;
        v.d.q(this, drawable);
        this.r = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_titleTextStyle, 0);
        this.s = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f832f = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionMode_height, 0);
        this.u = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    public void f(e.b.e.a aVar) {
        c cVar;
        n nVar;
        n nVar2;
        View view;
        View view2 = this.f65l;
        if (view2 == null) {
            view = LayoutInflater.from(getContext()).inflate(this.u, (ViewGroup) this, false);
            this.f65l = view;
        } else {
            if (view2.getParent() == null) {
                view = this.f65l;
            }
            View findViewById = this.f65l.findViewById(R$id.action_mode_close_button);
            this.m = findViewById;
            findViewById.setOnClickListener(new a(this, aVar));
            g gVar = (g) aVar.e();
            cVar = this.f831e;
            if (cVar != null) {
                cVar.a();
            }
            c cVar2 = new c(getContext());
            this.f831e = cVar2;
            cVar2.m = true;
            cVar2.n = true;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            gVar.b(this.f831e, this.c);
            c cVar3 = this.f831e;
            nVar = cVar3.f767i;
            if (nVar == null) {
                n nVar3 = (n) cVar3.f763e.inflate(cVar3.f765g, (ViewGroup) this, false);
                cVar3.f767i = nVar3;
                nVar3.b(cVar3.f762d);
                cVar3.j(true);
            }
            nVar2 = cVar3.f767i;
            if (nVar != nVar2) {
                ((ActionMenuView) nVar2).setPresenter(cVar3);
            }
            ActionMenuView actionMenuView = (ActionMenuView) nVar2;
            this.f830d = actionMenuView;
            AtomicInteger atomicInteger = v.a;
            v.d.q(actionMenuView, null);
            addView(this.f830d, layoutParams);
        }
        addView(view);
        View findViewById2 = this.f65l.findViewById(R$id.action_mode_close_button);
        this.m = findViewById2;
        findViewById2.setOnClickListener(new a(this, aVar));
        g gVar2 = (g) aVar.e();
        cVar = this.f831e;
        if (cVar != null) {
        }
        c cVar22 = new c(getContext());
        this.f831e = cVar22;
        cVar22.m = true;
        cVar22.n = true;
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -1);
        gVar2.b(this.f831e, this.c);
        c cVar32 = this.f831e;
        nVar = cVar32.f767i;
        if (nVar == null) {
        }
        nVar2 = cVar32.f767i;
        if (nVar != nVar2) {
        }
        ActionMenuView actionMenuView2 = (ActionMenuView) nVar2;
        this.f830d = actionMenuView2;
        AtomicInteger atomicInteger2 = v.a;
        v.d.q(actionMenuView2, null);
        addView(this.f830d, layoutParams2);
    }

    public final void g() {
        if (this.o == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.o = linearLayout;
            this.p = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.q = (TextView) this.o.findViewById(R$id.action_bar_subtitle);
            if (this.r != 0) {
                this.p.setTextAppearance(getContext(), this.r);
            }
            if (this.s != 0) {
                this.q.setTextAppearance(getContext(), this.s);
            }
        }
        this.p.setText(this.f63j);
        this.q.setText(this.f64k);
        boolean z = !TextUtils.isEmpty(this.f63j);
        boolean z2 = !TextUtils.isEmpty(this.f64k);
        int i2 = 0;
        this.q.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.o;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.o.getParent() == null) {
            addView(this.o);
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // e.b.f.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // e.b.f.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f64k;
    }

    public CharSequence getTitle() {
        return this.f63j;
    }

    public void h() {
        removeAllViews();
        this.n = null;
        this.f830d = null;
        this.f831e = null;
        View view = this.m;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f831e;
        if (cVar != null) {
            cVar.k();
            this.f831e.l();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f63j);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean a2 = i1.a(this);
        int paddingRight = a2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f65l;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f65l.getLayoutParams();
            int i6 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i8 = a2 ? paddingRight - i6 : paddingRight + i6;
            int d2 = i8 + d(this.f65l, i8, paddingTop, paddingTop2, a2);
            paddingRight = a2 ? d2 - i7 : d2 + i7;
        }
        int i9 = paddingRight;
        LinearLayout linearLayout = this.o;
        if (!(linearLayout == null || this.n != null || linearLayout.getVisibility() == 8)) {
            i9 += d(this.o, i9, paddingTop, paddingTop2, a2);
        }
        View view2 = this.n;
        if (view2 != null) {
            d(view2, i9, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f830d;
        if (actionMenuView != null) {
            d(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4 = 1073741824;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i3) != 0) {
            int size = View.MeasureSpec.getSize(i2);
            int i5 = this.f832f;
            if (i5 <= 0) {
                i5 = View.MeasureSpec.getSize(i3);
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i6 = i5 - paddingBottom;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
            View view = this.f65l;
            if (view != null) {
                int c = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f65l.getLayoutParams();
                paddingLeft = c - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f830d;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f830d, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.o;
            if (linearLayout != null && this.n == null) {
                if (this.t) {
                    this.o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.o.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.o.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.n;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i7 = layoutParams.width;
                int i8 = i7 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i7 >= 0) {
                    paddingLeft = Math.min(i7, paddingLeft);
                }
                int i9 = layoutParams.height;
                if (i9 == -2) {
                    i4 = Integer.MIN_VALUE;
                }
                if (i9 >= 0) {
                    i6 = Math.min(i9, i6);
                }
                this.n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i8), View.MeasureSpec.makeMeasureSpec(i6, i4));
            }
            if (this.f832f <= 0) {
                int childCount = getChildCount();
                i5 = 0;
                for (int i10 = 0; i10 < childCount; i10++) {
                    int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingBottom;
                    if (measuredHeight > i5) {
                        i5 = measuredHeight;
                    }
                }
            }
            setMeasuredDimension(size, i5);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    @Override // e.b.f.a
    public void setContentHeight(int i2) {
        this.f832f = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.n;
        if (view2 != null) {
            removeView(view2);
        }
        this.n = view;
        if (!(view == null || (linearLayout = this.o) == null)) {
            removeView(linearLayout);
            this.o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f64k = charSequence;
        g();
    }

    public void setTitle(CharSequence charSequence) {
        this.f63j = charSequence;
        g();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.t) {
            requestLayout();
        }
        this.t = z;
    }

    @Override // e.b.f.a
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
