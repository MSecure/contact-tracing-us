package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
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
import b.b.k.i;
import b.b.p.i.i;
import b.b.p.i.n;
import b.b.q.i0;
import b.i.l.m;
import b.i.l.w.b;
import c.b.a.b.c0.f;
import c.b.a.b.d;
import c.b.a.b.e;
import c.b.a.b.h;

public class NavigationMenuItemView extends f implements n.a {
    public static final int[] G = {16842912};
    public FrameLayout A;
    public i B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final b.i.l.a F = new a();
    public int w;
    public boolean x;
    public boolean y;
    public final CheckedTextView z;

    public class a extends b.i.l.a {
        public a() {
        }

        @Override // b.i.l.a
        public void d(View view, b bVar) {
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
            bVar.f1906a.setCheckable(NavigationMenuItemView.this.y);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(0);
        LayoutInflater.from(context).inflate(h.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(c.b.a.b.f.design_menu_item_text);
        this.z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        m.U(this.z, this.F);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(c.b.a.b.f.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // b.b.p.i.n.a
    public boolean d() {
        return false;
    }

    @Override // b.b.p.i.n.a
    public void e(i iVar, int i) {
        int i2;
        i0.a aVar;
        StateListDrawable stateListDrawable;
        this.B = iVar;
        int i3 = iVar.f732a;
        if (i3 > 0) {
            setId(i3);
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
        boolean z2 = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(b.b.a.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            m.X(this, stateListDrawable);
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.f736e);
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.q);
        i.j.i0(this, iVar.r);
        b.b.p.i.i iVar2 = this.B;
        if (!(iVar2.f736e == null && iVar2.getIcon() == null && this.B.getActionView() != null)) {
            z2 = false;
        }
        if (z2) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                aVar = (i0.a) frameLayout.getLayoutParams();
                i2 = -1;
            } else {
                return;
            }
        } else {
            this.z.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 != null) {
                aVar = (i0.a) frameLayout2.getLayoutParams();
                i2 = -2;
            } else {
                return;
            }
        }
        ((ViewGroup.MarginLayoutParams) aVar).width = i2;
        this.A.setLayoutParams(aVar);
    }

    @Override // b.b.p.i.n.a
    public b.b.p.i.i getItemData() {
        return this.B;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        b.b.p.i.i iVar = this.B;
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

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.C);
            }
            int i = this.w;
            drawable.setBounds(0, 0, i, i);
        } else if (this.x) {
            if (this.E == null) {
                Drawable drawable2 = getResources().getDrawable(e.navigation_empty_icon, getContext().getTheme());
                this.E = drawable2;
                if (drawable2 != null) {
                    int i2 = this.w;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.E;
        }
        this.z.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.z.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.w = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        b.b.p.i.i iVar = this.B;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.z.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.x = z2;
    }

    public void setTextAppearance(int i) {
        this.z.setTextAppearance(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }
}
