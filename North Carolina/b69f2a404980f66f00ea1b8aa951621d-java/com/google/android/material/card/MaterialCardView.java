package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import b.i.l.m;
import c.b.a.a.c.n.c;
import c.b.a.b.b;
import c.b.a.b.c0.i;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.h0.n;
import c.b.a.b.k;
import c.b.a.b.l;

public class MaterialCardView extends CardView implements Checkable, n {
    public static final int[] p = {16842911};
    public static final int[] q = {16842912};
    public static final int[] r = {b.state_dragged};
    public static final int s = k.Widget_MaterialComponents_CardView;
    public final c.b.a.b.t.a k;
    public boolean l = true;
    public boolean m = false;
    public boolean n = false;
    public a o;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r6, s), attributeSet, r6);
        int i = b.materialCardViewStyle;
        TypedArray d2 = i.d(getContext(), attributeSet, l.MaterialCardView, i, s, new int[0]);
        c.b.a.b.t.a aVar = new c.b.a.b.t.a(this, attributeSet, i, s);
        this.k = aVar;
        aVar.f3205c.r(super.getCardBackgroundColor());
        c.b.a.b.t.a aVar2 = this.k;
        aVar2.f3204b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar2.k();
        c.b.a.b.t.a aVar3 = this.k;
        ColorStateList Z0 = c.Z0(aVar3.f3203a.getContext(), d2, l.MaterialCardView_strokeColor);
        aVar3.m = Z0;
        if (Z0 == null) {
            aVar3.m = ColorStateList.valueOf(-1);
        }
        aVar3.g = d2.getDimensionPixelSize(l.MaterialCardView_strokeWidth, 0);
        boolean z = d2.getBoolean(l.MaterialCardView_android_checkable, false);
        aVar3.s = z;
        aVar3.f3203a.setLongClickable(z);
        aVar3.k = c.Z0(aVar3.f3203a.getContext(), d2, l.MaterialCardView_checkedIconTint);
        aVar3.g(c.d1(aVar3.f3203a.getContext(), d2, l.MaterialCardView_checkedIcon));
        ColorStateList Z02 = c.Z0(aVar3.f3203a.getContext(), d2, l.MaterialCardView_rippleColor);
        aVar3.j = Z02;
        if (Z02 == null) {
            aVar3.j = ColorStateList.valueOf(c.Y0(aVar3.f3203a, b.colorControlHighlight));
        }
        ColorStateList Z03 = c.Z0(aVar3.f3203a.getContext(), d2, l.MaterialCardView_cardForegroundColor);
        aVar3.f3206d.r(Z03 == null ? ColorStateList.valueOf(0) : Z03);
        aVar3.m();
        aVar3.f3205c.q(aVar3.f3203a.getCardElevation());
        aVar3.n();
        aVar3.f3203a.setBackgroundInternal(aVar3.f(aVar3.f3205c));
        Drawable e2 = aVar3.f3203a.isClickable() ? aVar3.e() : aVar3.f3206d;
        aVar3.h = e2;
        aVar3.f3203a.setForeground(aVar3.f(e2));
        d2.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.k.f3205c.getBounds());
        return rectF;
    }

    public final void d() {
        c.b.a.b.t.a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (aVar = this.k).n) != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    public boolean e() {
        c.b.a.b.t.a aVar = this.k;
        return aVar != null && aVar.s;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.k.f3205c.f2982b.f2990d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.k.f3206d.f2982b.f2990d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.k.i;
    }

    public ColorStateList getCheckedIconTint() {
        return this.k.k;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.k.f3204b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.k.f3204b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.k.f3204b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.k.f3204b.top;
    }

    public float getProgress() {
        return this.k.f3205c.f2982b.k;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.k.f3205c.m();
    }

    public ColorStateList getRippleColor() {
        return this.k.j;
    }

    public j getShapeAppearanceModel() {
        return this.k.l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.k.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.k.m;
    }

    public int getStrokeWidth() {
        return this.k.g;
    }

    public boolean isChecked() {
        return this.m;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.f2(this, this.k.f3205c);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, q);
        }
        if (this.n) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        c.b.a.b.t.a aVar = this.k;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.o != null) {
            int i5 = aVar.f3207e;
            int i6 = aVar.f;
            int i7 = (measuredWidth - i5) - i6;
            int i8 = (measuredHeight - i5) - i6;
            if (aVar.f3203a.getUseCompatPadding()) {
                i8 -= (int) Math.ceil((double) (aVar.d() * 2.0f));
                i7 -= (int) Math.ceil((double) (aVar.c() * 2.0f));
            }
            int i9 = aVar.f3207e;
            if (m.o(aVar.f3203a) == 1) {
                i3 = i7;
                i4 = i9;
            } else {
                i4 = i7;
                i3 = i9;
            }
            aVar.o.setLayerInset(2, i4, aVar.f3207e, i3, i8);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.l) {
            c.b.a.b.t.a aVar = this.k;
            if (!aVar.r) {
                aVar.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        c.b.a.b.t.a aVar = this.k;
        aVar.f3205c.r(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        c.b.a.b.t.a aVar = this.k;
        aVar.f3205c.q(aVar.f3203a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.k.f3206d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.r(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.k.s = z;
    }

    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.k.g(drawable);
    }

    public void setCheckedIconResource(int i) {
        this.k.g(b.b.l.a.a.b(getContext(), i));
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c.b.a.b.t.a aVar = this.k;
        aVar.k = colorStateList;
        Drawable drawable = aVar.i;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        c.b.a.b.t.a aVar = this.k;
        Drawable drawable = aVar.h;
        Drawable e2 = aVar.f3203a.isClickable() ? aVar.e() : aVar.f3206d;
        aVar.h = e2;
        if (drawable == e2) {
            return;
        }
        if (aVar.f3203a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) aVar.f3203a.getForeground()).setDrawable(e2);
        } else {
            aVar.f3203a.setForeground(aVar.f(e2));
        }
    }

    public void setDragged(boolean z) {
        if (this.n != z) {
            this.n = z;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.k.l();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.o = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.k.l();
        this.k.k();
    }

    public void setProgress(float f) {
        c.b.a.b.t.a aVar = this.k;
        aVar.f3205c.s(f);
        g gVar = aVar.f3206d;
        if (gVar != null) {
            gVar.s(f);
        }
        g gVar2 = aVar.q;
        if (gVar2 != null) {
            gVar2.s(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        c.b.a.b.t.a aVar = this.k;
        aVar.h(aVar.l.e(f));
        aVar.h.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c.b.a.b.t.a aVar = this.k;
        aVar.j = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(int i) {
        c.b.a.b.t.a aVar = this.k;
        aVar.j = b.b.l.a.a.a(getContext(), i);
        aVar.m();
    }

    @Override // c.b.a.b.h0.n
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.k.h(jVar);
    }

    public void setStrokeColor(int i) {
        c.b.a.b.t.a aVar = this.k;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (aVar.m != valueOf) {
            aVar.m = valueOf;
            aVar.n();
        }
    }

    public void setStrokeWidth(int i) {
        c.b.a.b.t.a aVar = this.k;
        if (i != aVar.g) {
            aVar.g = i;
            aVar.n();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.k.l();
        this.k.k();
    }

    public void toggle() {
        if (e() && isEnabled()) {
            this.m = !this.m;
            refreshDrawableState();
            d();
            a aVar = this.o;
            if (aVar != null) {
                aVar.a(this, this.m);
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.k.f3205c.r(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c.b.a.b.t.a aVar = this.k;
        if (aVar.m != colorStateList) {
            aVar.m = colorStateList;
            aVar.n();
        }
    }
}
