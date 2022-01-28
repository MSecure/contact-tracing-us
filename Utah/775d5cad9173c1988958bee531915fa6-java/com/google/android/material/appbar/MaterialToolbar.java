package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.a.m;
import e.i.i.v;
import f.b.a.c.b.o.b;
import f.b.a.e.q.k;
import f.b.a.e.v.g;
import f.b.a.e.z.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialToolbar extends Toolbar {
    public static final int T = R$style.Widget_MaterialComponents_Toolbar;
    public Integer Q;
    public boolean R;
    public boolean S;

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.toolbarStyle;
        int i3 = T;
        Context context2 = getContext();
        int i4 = 0;
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialToolbar, i2, i3, new int[0]);
        int i5 = R$styleable.MaterialToolbar_navigationIconTint;
        if (d2.hasValue(i5)) {
            setNavigationIconTint(d2.getColor(i5, -1));
        }
        this.R = d2.getBoolean(R$styleable.MaterialToolbar_titleCentered, false);
        this.S = d2.getBoolean(R$styleable.MaterialToolbar_subtitleCentered, false);
        d2.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.q(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : i4));
            gVar.b.b = new f.b.a.e.n.a(context2);
            gVar.y();
            AtomicInteger atomicInteger = v.a;
            gVar.p(v.i.i(this));
            v.d.q(this, gVar);
        }
    }

    public Integer getNavigationIconTint() {
        return this.Q;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            b.p1(this, (g) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.R || this.S) {
            TextView K0 = b.K0(this, getTitle());
            TextView K02 = b.K0(this, getSubtitle());
            if (!(K0 == null && K02 == null)) {
                int measuredWidth = getMeasuredWidth();
                int i6 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i7 = 0; i7 < getChildCount(); i7++) {
                    View childAt = getChildAt(i7);
                    if (!(childAt.getVisibility() == 8 || childAt == K0 || childAt == K02)) {
                        if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.R && K0 != null) {
                    w(K0, pair);
                }
                if (this.S && K02 != null) {
                    w(K02, pair);
                }
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        b.o1(this, f2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (!(drawable == null || this.Q == null)) {
            drawable = m.e.P1(drawable.mutate());
            drawable.setTint(this.Q.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i2) {
        this.Q = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.S != z) {
            this.S = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.R != z) {
            this.R = z;
            requestLayout();
        }
    }

    public final void w(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i2 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i3 = measuredWidth2 + i2;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i2, 0), Math.max(i3 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i2 += max;
            i3 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 - i2, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i2, view.getTop(), i3, view.getBottom());
    }
}
