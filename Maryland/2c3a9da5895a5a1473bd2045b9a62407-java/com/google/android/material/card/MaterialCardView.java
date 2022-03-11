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
import e.i.i.m;
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
    public final f.b.a.d.h.a f523k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f524l = true;
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
        this.f523k = aVar;
        aVar.c.q(super.getCardBackgroundColor());
        aVar.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.k();
        ColorStateList L0 = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_strokeColor);
        aVar.m = L0;
        if (L0 == null) {
            aVar.m = ColorStateList.valueOf(-1);
        }
        aVar.f2708g = d2.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = d2.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        aVar.s = z;
        aVar.a.setLongClickable(z);
        aVar.f2712k = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIconTint);
        aVar.g(b.P0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIcon));
        aVar.f2707f = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        aVar.f2706e = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList L02 = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_rippleColor);
        aVar.f2711j = L02;
        if (L02 == null) {
            aVar.f2711j = ColorStateList.valueOf(b.K0(aVar.a, R$attr.colorControlHighlight));
        }
        ColorStateList L03 = b.L0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_cardForegroundColor);
        aVar.f2705d.q(L03 == null ? ColorStateList.valueOf(0) : L03);
        aVar.m();
        aVar.c.p(aVar.a.getCardElevation());
        aVar.n();
        aVar.a.setBackgroundInternal(aVar.f(aVar.c));
        Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2705d;
        aVar.f2709h = e2;
        aVar.a.setForeground(aVar.f(e2));
        d2.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f523k.c.getBounds());
        return rectF;
    }

    public final void d() {
        f.b.a.d.h.a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (aVar = this.f523k).n) != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    public boolean e() {
        f.b.a.d.h.a aVar = this.f523k;
        return aVar != null && aVar.s;
    }

    @Override // e.d.a.a
    public ColorStateList getCardBackgroundColor() {
        return this.f523k.c.b.f2874d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f523k.f2705d.b.f2874d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f523k.f2710i;
    }

    public int getCheckedIconMargin() {
        return this.f523k.f2706e;
    }

    public int getCheckedIconSize() {
        return this.f523k.f2707f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f523k.f2712k;
    }

    @Override // e.d.a.a
    public int getContentPaddingBottom() {
        return this.f523k.b.bottom;
    }

    @Override // e.d.a.a
    public int getContentPaddingLeft() {
        return this.f523k.b.left;
    }

    @Override // e.d.a.a
    public int getContentPaddingRight() {
        return this.f523k.b.right;
    }

    @Override // e.d.a.a
    public int getContentPaddingTop() {
        return this.f523k.b.top;
    }

    public float getProgress() {
        return this.f523k.c.b.f2881k;
    }

    @Override // e.d.a.a
    public float getRadius() {
        return this.f523k.c.l();
    }

    public ColorStateList getRippleColor() {
        return this.f523k.f2711j;
    }

    public j getShapeAppearanceModel() {
        return this.f523k.f2713l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f523k.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f523k.m;
    }

    public int getStrokeWidth() {
        return this.f523k.f2708g;
    }

    public boolean isChecked() {
        return this.m;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.N1(this, this.f523k.c);
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
        f.b.a.d.h.a aVar = this.f523k;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.o != null) {
            int i6 = aVar.f2706e;
            int i7 = aVar.f2707f;
            int i8 = (measuredWidth - i6) - i7;
            int i9 = (measuredHeight - i6) - i7;
            if (aVar.a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil((double) (aVar.d() * 2.0f));
                i8 -= (int) Math.ceil((double) (aVar.c() * 2.0f));
            }
            int i10 = aVar.f2706e;
            MaterialCardView materialCardView = aVar.a;
            AtomicInteger atomicInteger = m.a;
            if (materialCardView.getLayoutDirection() == 1) {
                i4 = i8;
                i5 = i10;
            } else {
                i5 = i8;
                i4 = i10;
            }
            aVar.o.setLayerInset(2, i5, aVar.f2706e, i4, i9);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f524l) {
            if (!this.f523k.r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f523k.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // e.d.a.a
    public void setCardBackgroundColor(int i2) {
        f.b.a.d.h.a aVar = this.f523k;
        aVar.c.q(ColorStateList.valueOf(i2));
    }

    @Override // e.d.a.a
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        f.b.a.d.h.a aVar = this.f523k;
        aVar.c.p(aVar.a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.f523k.f2705d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.q(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f523k.s = z;
    }

    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f523k.g(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f523k.f2706e = i2;
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f523k.f2706e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f523k.g(e.b.b.a.a.b(getContext(), i2));
    }

    public void setCheckedIconSize(int i2) {
        this.f523k.f2707f = i2;
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f523k.f2707f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.d.h.a aVar = this.f523k;
        aVar.f2712k = colorStateList;
        Drawable drawable = aVar.f2710i;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        f.b.a.d.h.a aVar = this.f523k;
        if (aVar != null) {
            Drawable drawable = aVar.f2709h;
            Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2705d;
            aVar.f2709h = e2;
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
        this.f523k.l();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.o = aVar;
    }

    @Override // e.d.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f523k.l();
        this.f523k.k();
    }

    public void setProgress(float f2) {
        f.b.a.d.h.a aVar = this.f523k;
        aVar.c.r(f2);
        g gVar = aVar.f2705d;
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
        f.b.a.d.h.a aVar = this.f523k;
        aVar.h(aVar.f2713l.e(f2));
        aVar.f2709h.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.d.h.a aVar = this.f523k;
        aVar.f2711j = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(int i2) {
        f.b.a.d.h.a aVar = this.f523k;
        aVar.f2711j = e.b.b.a.a.a(getContext(), i2);
        aVar.m();
    }

    @Override // f.b.a.d.v.n
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.f523k.h(jVar);
    }

    public void setStrokeColor(int i2) {
        f.b.a.d.h.a aVar = this.f523k;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (aVar.m != valueOf) {
            aVar.m = valueOf;
            aVar.n();
        }
    }

    public void setStrokeWidth(int i2) {
        f.b.a.d.h.a aVar = this.f523k;
        if (i2 != aVar.f2708g) {
            aVar.f2708g = i2;
            aVar.n();
        }
    }

    @Override // e.d.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f523k.l();
        this.f523k.k();
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
        this.f523k.c.q(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        f.b.a.d.h.a aVar = this.f523k;
        if (aVar.m != colorStateList) {
            aVar.m = colorStateList;
            aVar.n();
        }
    }
}
