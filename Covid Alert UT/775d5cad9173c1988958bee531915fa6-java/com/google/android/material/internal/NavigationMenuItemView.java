package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import e.b.a.m;
import e.b.e.i.i;
import e.b.e.i.n;
import e.b.f.m0;
import e.i.b.b.h;
import e.i.i.c;
import e.i.i.c0.b;
import e.i.i.v;
import f.b.a.e.q.f;
import java.util.concurrent.atomic.AtomicInteger;

public class NavigationMenuItemView extends f implements n.a {
    public static final int[] G = {16842912};
    public FrameLayout A;
    public i B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final c F;
    public int w;
    public boolean x;
    public boolean y;
    public final CheckedTextView z;

    public class a extends c {
        public a() {
        }

        @Override // e.i.i.c
        public void d(View view, b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            bVar.a.setCheckable(NavigationMenuItemView.this.y);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        v.u(checkedTextView, aVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // e.b.e.i.n.a
    public void d(i iVar, int i2) {
        int i3;
        m0.a aVar;
        StateListDrawable stateListDrawable;
        this.B = iVar;
        int i4 = iVar.a;
        if (i4 > 0) {
            setId(i4);
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
        boolean z2 = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R$attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            AtomicInteger atomicInteger = v.a;
            v.d.q(this, stateListDrawable);
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.f799e);
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.q);
        m.e.z1(this, iVar.r);
        i iVar2 = this.B;
        if (!(iVar2.f799e == null && iVar2.getIcon() == null && this.B.getActionView() != null)) {
            z2 = false;
        }
        if (z2) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                aVar = (m0.a) frameLayout.getLayoutParams();
                i3 = -1;
            } else {
                return;
            }
        } else {
            this.z.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 != null) {
                aVar = (m0.a) frameLayout2.getLayoutParams();
                i3 = -2;
            } else {
                return;
            }
        }
        ((LinearLayout.LayoutParams) aVar).width = i3;
        this.A.setLayoutParams(aVar);
    }

    @Override // e.b.e.i.n.a
    public i getItemData() {
        return this.B;
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.B;
        if (iVar != null && iVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.y != z2) {
            this.y = z2;
            this.F.h(this.z, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.z.setChecked(z2);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = m.e.P1(drawable).mutate();
                drawable.setTintList(this.C);
            }
            int i2 = this.w;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.x) {
            if (this.E == null) {
                Resources resources = getResources();
                int i3 = R$drawable.navigation_empty_icon;
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal<TypedValue> threadLocal = h.a;
                Drawable drawable2 = resources.getDrawable(i3, theme);
                this.E = drawable2;
                if (drawable2 != null) {
                    int i4 = this.w;
                    drawable2.setBounds(0, 0, i4, i4);
                }
            }
            drawable = this.E;
        }
        this.z.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.z.setCompoundDrawablePadding(i2);
    }

    public void setIconSize(int i2) {
        this.w = i2;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        i iVar = this.B;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i2) {
        this.z.setMaxLines(i2);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.x = z2;
    }

    public void setTextAppearance(int i2) {
        m.e.v1(this.z, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }
}
