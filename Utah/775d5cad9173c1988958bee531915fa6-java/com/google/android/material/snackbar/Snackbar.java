package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import f.b.a.e.w.n;
import f.b.a.e.w.o;
import f.b.a.e.w.p;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] s = {R$attr.snackbarButtonStyle, R$attr.snackbarTextViewStyle};
    public final AccessibilityManager q;
    public boolean r;

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

    public Snackbar(Context context, ViewGroup viewGroup, View view, n nVar) {
        super(context, viewGroup, view, nVar);
        this.q = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
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
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                viewGroup = viewGroup2;
                break;
            }
        }
        viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            Context context = viewGroup.getContext();
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(s);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            boolean z = true;
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            if (resourceId == -1 || resourceId2 == -1) {
                z = false;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(z ? R$layout.mtrl_layout_snackbar_include : R$layout.design_layout_snackbar_include, viewGroup, false);
            Snackbar snackbar = new Snackbar(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
            ((SnackbarContentLayout) snackbar.c.getChildAt(0)).getMessageView().setText(charSequence);
            snackbar.f582e = i2;
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void a() {
        b(3);
    }

    public int i() {
        int i2 = this.f582e;
        if (i2 == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.q.getRecommendedTimeoutMillis(i2, (this.r ? 4 : 0) | 1 | 2);
        } else if (!this.r || !this.q.isTouchExplorationEnabled()) {
            return i2;
        } else {
            return -2;
        }
    }

    public Snackbar k(int i2, View.OnClickListener onClickListener) {
        CharSequence text = this.b.getText(i2);
        Button actionView = ((SnackbarContentLayout) this.c.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(text)) {
            this.r = true;
            actionView.setVisibility(0);
            actionView.setText(text);
            actionView.setOnClickListener(new o(this, onClickListener));
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.r = false;
        }
        return this;
    }

    public void l() {
        p b = p.b();
        int i2 = i();
        p.b bVar = this.m;
        synchronized (b.a) {
            if (b.c(bVar)) {
                p.c cVar = b.c;
                cVar.b = i2;
                b.b.removeCallbacksAndMessages(cVar);
                b.g(b.c);
            } else {
                if (b.d(bVar)) {
                    b.f3083d.b = i2;
                } else {
                    b.f3083d = new p.c(i2, bVar);
                }
                p.c cVar2 = b.c;
                if (cVar2 == null || !b.a(cVar2, 4)) {
                    b.c = null;
                    b.h();
                }
            }
        }
    }
}
