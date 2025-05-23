package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import f.b.a.d.w.n;
import f.b.a.d.w.o;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] s = {R$attr.snackbarButtonStyle, R$attr.snackbarTextViewStyle};
    public final AccessibilityManager r;

    public static final class SnackbarLayout extends BaseTransientBottomBar.i {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    public Snackbar(ViewGroup viewGroup, View view, n nVar) {
        super(viewGroup, view, nVar);
        this.r = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static Snackbar j(View view, CharSequence charSequence, int i2) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (view instanceof CoordinatorLayout) {
                break;
            }
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    break;
                }
                viewGroup2 = (ViewGroup) view;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
                continue;
            } else {
                view = null;
                continue;
            }
            if (view == null) {
                viewGroup = viewGroup2;
                break;
            }
        }
        viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes(s);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            boolean z = true;
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            if (resourceId == -1 || resourceId2 == -1) {
                z = false;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(z ? R$layout.mtrl_layout_snackbar_include : R$layout.design_layout_snackbar_include, viewGroup, false);
            Snackbar snackbar = new Snackbar(viewGroup, snackbarContentLayout, snackbarContentLayout);
            ((SnackbarContentLayout) snackbar.c.getChildAt(0)).getMessageView().setText(charSequence);
            snackbar.f552e = i2;
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void a() {
        b(3);
    }

    public int i() {
        int i2 = this.f552e;
        if (i2 == -2) {
            return -2;
        }
        return Build.VERSION.SDK_INT >= 29 ? this.r.getRecommendedTimeoutMillis(i2, 3) : i2;
    }

    public void k() {
        o b = o.b();
        int i2 = i();
        o.b bVar = this.n;
        synchronized (b.a) {
            if (b.c(bVar)) {
                o.c cVar = b.c;
                cVar.b = i2;
                b.b.removeCallbacksAndMessages(cVar);
                b.g(b.c);
            } else {
                if (b.d(bVar)) {
                    b.f2826d.b = i2;
                } else {
                    b.f2826d = new o.c(i2, bVar);
                }
                o.c cVar2 = b.c;
                if (cVar2 == null || !b.a(cVar2, 4)) {
                    b.c = null;
                    b.h();
                }
            }
        }
    }
}
