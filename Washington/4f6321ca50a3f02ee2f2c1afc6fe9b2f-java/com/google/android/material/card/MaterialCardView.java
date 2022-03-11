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
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.i.i.l;
import f.b.a.c.b.o.b;
import f.b.a.d.q.k;
import f.b.a.d.v.g;
import f.b.a.d.v.j;
import f.b.a.d.v.n;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialCardView extends e.d.a.a implements Checkable, n {
    public static final int[] p = {16842911};
    public static final int[] q = {16842912};
    public static final int[] r = {R$attr.state_dragged};
    public static final int s = R$style.Widget_MaterialComponents_CardView;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.d.h.a f506k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f507l = true;
    public boolean m = false;
    public boolean n = false;
    public a o;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(f.b.a.d.a0.a.a.a(context, attributeSet, r6, r7), attributeSet, r6);
        int i2 = R$attr.materialCardViewStyle;
        int i3 = s;
        TypedArray d2 = k.d(getContext(), attributeSet, R$styleable.MaterialCardView, i2, i3, new int[0]);
        f.b.a.d.h.a aVar = new f.b.a.d.h.a(this, attributeSet, i2, i3);
        this.f506k = aVar;
        aVar.c.q(super.getCardBackgroundColor());
        aVar.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.k();
        ColorStateList L0 = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_strokeColor);
        aVar.m = L0;
        if (L0 == null) {
            aVar.m = ColorStateList.valueOf(-1);
        }
        aVar.f2608g = d2.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = d2.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        aVar.s = z;
        aVar.a.setLongClickable(z);
        aVar.f2612k = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIconTint);
        aVar.g(b.O0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIcon));
        aVar.f2607f = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        aVar.f2606e = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList L02 = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_rippleColor);
        aVar.f2611j = L02;
        if (L02 == null) {
            aVar.f2611j = ColorStateList.valueOf(b.K0(aVar.a, R$attr.colorControlHighlight));
        }
        ColorStateList L03 = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_cardForegroundColor);
        aVar.f2605d.q(L03 == null ? ColorStateList.valueOf(0) : L03);
        aVar.m();
        aVar.c.p(aVar.a.getCardElevation());
        aVar.n();
        aVar.a.setBackgroundInternal(aVar.f(aVar.c));
        Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2605d;
        aVar.f2609h = e2;
        aVar.a.setForeground(aVar.f(e2));
        d2.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f506k.c.getBounds());
        return rectF;
    }

    public final void d() {
        f.b.a.d.h.a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (aVar = this.f506k).n) != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    public boolean e() {
        f.b.a.d.h.a aVar = this.f506k;
        return aVar != null && aVar.s;
    }

    @Override // e.d.a.a
    public ColorStateList getCardBackgroundColor() {
        return this.f506k.c.b.f2778d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f506k.f2605d.b.f2778d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f506k.f2610i;
    }

    public int getCheckedIconMargin() {
        return this.f506k.f2606e;
    }

    public int getCheckedIconSize() {
        return this.f506k.f2607f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f506k.f2612k;
    }

    @Override // e.d.a.a
    public int getContentPaddingBottom() {
        return this.f506k.b.bottom;
    }

    @Override // e.d.a.a
    public int getContentPaddingLeft() {
        return this.f506k.b.left;
    }

    @Override // e.d.a.a
    public int getContentPaddingRight() {
        return this.f506k.b.right;
    }

    @Override // e.d.a.a
    public int getContentPaddingTop() {
        return this.f506k.b.top;
    }

    public float getProgress() {
        return this.f506k.c.b.f2785k;
    }

    @Override // e.d.a.a
    public float getRadius() {
        return this.f506k.c.l();
    }

    public ColorStateList getRippleColor() {
        return this.f506k.f2611j;
    }

    public j getShapeAppearanceModel() {
        return this.f506k.f2613l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f506k.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f506k.m;
    }

    public int getStrokeWidth() {
        return this.f506k.f2608g;
    }

    public boolean isChecked() {
        return this.m;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.O1(this, this.f506k.c);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
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

    @Override // e.d.a.a
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        f.b.a.d.h.a aVar = this.f506k;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.o != null) {
            int i6 = aVar.f2606e;
            int i7 = aVar.f2607f;
            int i8 = (measuredWidth - i6) - i7;
            int i9 = (measuredHeight - i6) - i7;
            if (aVar.a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil((double) (aVar.d() * 2.0f));
                i8 -= (int) Math.ceil((double) (aVar.c() * 2.0f));
            }
            int i10 = aVar.f2606e;
            MaterialCardView materialCardView = aVar.a;
            AtomicInteger atomicInteger = l.a;
            if (materialCardView.getLayoutDirection() == 1) {
                i4 = i8;
                i5 = i10;
            } else {
                i5 = i8;
                i4 = i10;
            }
            aVar.o.setLayerInset(2, i5, aVar.f2606e, i4, i9);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f507l) {
            if (!this.f506k.r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f506k.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // e.d.a.a
    public void setCardBackgroundColor(int i2) {
        f.b.a.d.h.a aVar = this.f506k;
        aVar.c.q(ColorStateList.valueOf(i2));
    }

    @Override // e.d.a.a
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        f.b.a.d.h.a aVar = this.f506k;
        aVar.c.p(aVar.a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.f506k.f2605d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.q(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f506k.s = z;
    }

    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f506k.g(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f506k.f2606e = i2;
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f506k.f2606e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f506k.g(e.b.b.a.a.b(getContext(), i2));
    }

    public void setCheckedIconSize(int i2) {
        this.f506k.f2607f = i2;
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f506k.f2607f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.d.h.a aVar = this.f506k;
        aVar.f2612k = colorStateList;
        Drawable drawable = aVar.f2610i;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        f.b.a.d.h.a aVar = this.f506k;
        if (aVar != null) {
            Drawable drawable = aVar.f2609h;
            Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2605d;
            aVar.f2609h = e2;
            if (drawable == e2) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23 || !(aVar.a.getForeground() instanceof InsetDrawable)) {
                aVar.a.setForeground(aVar.f(e2));
            } else {
                ((InsetDrawable) aVar.a.getForeground()).setDrawable(e2);
            }
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

    @Override // e.d.a.a
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f506k.l();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.o = aVar;
    }

    @Override // e.d.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f506k.l();
        this.f506k.k();
    }

    public void setProgress(float f2) {
        f.b.a.d.h.a aVar = this.f506k;
        aVar.c.r(f2);
        g gVar = aVar.f2605d;
        if (gVar != null) {
            gVar.r(f2);
        }
        g gVar2 = aVar.q;
        if (gVar2 != null) {
            gVar2.r(f2);
        }
    }

    @Override // e.d.a.a
    public void setRadius(float f2) {
        super.setRadius(f2);
        f.b.a.d.h.a aVar = this.f506k;
        aVar.h(aVar.f2613l.e(f2));
        aVar.f2609h.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.d.h.a aVar = this.f506k;
        aVar.f2611j = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(int i2) {
        f.b.a.d.h.a aVar = this.f506k;
        aVar.f2611j = e.b.b.a.a.a(getContext(), i2);
        aVar.m();
    }

    @Override // f.b.a.d.v.n
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.f506k.h(jVar);
    }

    public void setStrokeColor(int i2) {
        f.b.a.d.h.a aVar = this.f506k;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (aVar.m != valueOf) {
            aVar.m = valueOf;
            aVar.n();
        }
    }

    public void setStrokeWidth(int i2) {
        f.b.a.d.h.a aVar = this.f506k;
        if (i2 != aVar.f2608g) {
            aVar.f2608g = i2;
            aVar.n();
        }
    }

    @Override // e.d.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f506k.l();
        this.f506k.k();
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

    @Override // e.d.a.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f506k.c.q(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        f.b.a.d.h.a aVar = this.f506k;
        if (aVar.m != colorStateList) {
            aVar.m = colorStateList;
            aVar.n();
        }
    }
}
