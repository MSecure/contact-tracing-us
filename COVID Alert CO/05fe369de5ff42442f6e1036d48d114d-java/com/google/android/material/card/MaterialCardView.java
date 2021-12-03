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
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.i.i.m;
import f.b.a.c.b.o.b;
import f.b.a.e.p.k;
import f.b.a.e.u.g;
import f.b.a.e.u.j;
import f.b.a.e.u.n;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialCardView extends e.d.a.a implements Checkable, n {
    public static final int[] p = {16842911};
    public static final int[] q = {16842912};
    public static final int[] r = {R$attr.state_dragged};
    public static final int s = R$style.Widget_MaterialComponents_CardView;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.e.g.a f551k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f552l = true;
    public boolean m = false;
    public boolean n = false;
    public a o;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.y.a.a.a(context, attributeSet, r6, r7), attributeSet, r6);
        int i2 = R$attr.materialCardViewStyle;
        int i3 = s;
        TypedArray d2 = k.d(getContext(), attributeSet, R$styleable.MaterialCardView, i2, i3, new int[0]);
        f.b.a.e.g.a aVar = new f.b.a.e.g.a(this, attributeSet, i2, i3);
        this.f551k = aVar;
        aVar.c.q(super.getCardBackgroundColor());
        aVar.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.k();
        ColorStateList w0 = b.w0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_strokeColor);
        aVar.m = w0;
        if (w0 == null) {
            aVar.m = ColorStateList.valueOf(-1);
        }
        aVar.f2813g = d2.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = d2.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        aVar.s = z;
        aVar.a.setLongClickable(z);
        aVar.f2817k = b.w0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIconTint);
        aVar.g(b.B0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIcon));
        aVar.f2812f = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        aVar.f2811e = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList w02 = b.w0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_rippleColor);
        aVar.f2816j = w02;
        if (w02 == null) {
            aVar.f2816j = ColorStateList.valueOf(b.v0(aVar.a, R$attr.colorControlHighlight));
        }
        ColorStateList w03 = b.w0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_cardForegroundColor);
        aVar.f2810d.q(w03 == null ? ColorStateList.valueOf(0) : w03);
        aVar.m();
        aVar.c.p(aVar.a.getCardElevation());
        aVar.n();
        aVar.a.setBackgroundInternal(aVar.f(aVar.c));
        Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2810d;
        aVar.f2814h = e2;
        aVar.a.setForeground(aVar.f(e2));
        d2.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f551k.c.getBounds());
        return rectF;
    }

    public final void d() {
        f.b.a.e.g.a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (aVar = this.f551k).n) != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    public boolean e() {
        f.b.a.e.g.a aVar = this.f551k;
        return aVar != null && aVar.s;
    }

    @Override // e.d.a.a
    public ColorStateList getCardBackgroundColor() {
        return this.f551k.c.b.f2971d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f551k.f2810d.b.f2971d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f551k.f2815i;
    }

    public int getCheckedIconMargin() {
        return this.f551k.f2811e;
    }

    public int getCheckedIconSize() {
        return this.f551k.f2812f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f551k.f2817k;
    }

    @Override // e.d.a.a
    public int getContentPaddingBottom() {
        return this.f551k.b.bottom;
    }

    @Override // e.d.a.a
    public int getContentPaddingLeft() {
        return this.f551k.b.left;
    }

    @Override // e.d.a.a
    public int getContentPaddingRight() {
        return this.f551k.b.right;
    }

    @Override // e.d.a.a
    public int getContentPaddingTop() {
        return this.f551k.b.top;
    }

    public float getProgress() {
        return this.f551k.c.b.f2978k;
    }

    @Override // e.d.a.a
    public float getRadius() {
        return this.f551k.c.l();
    }

    public ColorStateList getRippleColor() {
        return this.f551k.f2816j;
    }

    public j getShapeAppearanceModel() {
        return this.f551k.f2818l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f551k.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f551k.m;
    }

    public int getStrokeWidth() {
        return this.f551k.f2813g;
    }

    public boolean isChecked() {
        return this.m;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.m1(this, this.f551k.c);
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
        f.b.a.e.g.a aVar = this.f551k;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.o != null) {
            int i6 = aVar.f2811e;
            int i7 = aVar.f2812f;
            int i8 = (measuredWidth - i6) - i7;
            int i9 = (measuredHeight - i6) - i7;
            if (aVar.a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil((double) (aVar.d() * 2.0f));
                i8 -= (int) Math.ceil((double) (aVar.c() * 2.0f));
            }
            int i10 = aVar.f2811e;
            MaterialCardView materialCardView = aVar.a;
            AtomicInteger atomicInteger = m.a;
            if (materialCardView.getLayoutDirection() == 1) {
                i4 = i8;
                i5 = i10;
            } else {
                i5 = i8;
                i4 = i10;
            }
            aVar.o.setLayerInset(2, i5, aVar.f2811e, i4, i9);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f552l) {
            f.b.a.e.g.a aVar = this.f551k;
            if (!aVar.r) {
                aVar.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // e.d.a.a
    public void setCardBackgroundColor(int i2) {
        f.b.a.e.g.a aVar = this.f551k;
        aVar.c.q(ColorStateList.valueOf(i2));
    }

    @Override // e.d.a.a
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        f.b.a.e.g.a aVar = this.f551k;
        aVar.c.p(aVar.a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.f551k.f2810d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.q(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f551k.s = z;
    }

    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f551k.g(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f551k.f2811e = i2;
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f551k.f2811e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f551k.g(e.b.b.a.a.b(getContext(), i2));
    }

    public void setCheckedIconSize(int i2) {
        this.f551k.f2812f = i2;
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f551k.f2812f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f551k;
        aVar.f2817k = colorStateList;
        Drawable drawable = aVar.f2815i;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        f.b.a.e.g.a aVar = this.f551k;
        if (aVar != null) {
            Drawable drawable = aVar.f2814h;
            Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2810d;
            aVar.f2814h = e2;
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
        this.f551k.l();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.o = aVar;
    }

    @Override // e.d.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f551k.l();
        this.f551k.k();
    }

    public void setProgress(float f2) {
        f.b.a.e.g.a aVar = this.f551k;
        aVar.c.r(f2);
        g gVar = aVar.f2810d;
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
        f.b.a.e.g.a aVar = this.f551k;
        aVar.h(aVar.f2818l.e(f2));
        aVar.f2814h.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f551k;
        aVar.f2816j = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(int i2) {
        f.b.a.e.g.a aVar = this.f551k;
        aVar.f2816j = e.b.b.a.a.a(getContext(), i2);
        aVar.m();
    }

    @Override // f.b.a.e.u.n
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.f551k.h(jVar);
    }

    public void setStrokeColor(int i2) {
        f.b.a.e.g.a aVar = this.f551k;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (aVar.m != valueOf) {
            aVar.m = valueOf;
            aVar.n();
        }
    }

    public void setStrokeWidth(int i2) {
        f.b.a.e.g.a aVar = this.f551k;
        if (i2 != aVar.f2813g) {
            aVar.f2813g = i2;
            aVar.n();
        }
    }

    @Override // e.d.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f551k.l();
        this.f551k.k();
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
        this.f551k.c.q(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f551k;
        if (aVar.m != colorStateList) {
            aVar.m = colorStateList;
            aVar.n();
        }
    }
}
