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
import e.b.a.m;
import e.i.i.v;
import f.b.a.c.b.o.b;
import f.b.a.e.q.k;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import f.b.a.e.v.n;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialCardView extends e.d.a.a implements Checkable, n {
    public static final int[] p = {16842911};
    public static final int[] q = {16842912};
    public static final int[] r = {R$attr.state_dragged};
    public static final int s = R$style.Widget_MaterialComponents_CardView;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.e.g.a f546k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f547l = true;
    public boolean m = false;
    public boolean n = false;
    public a o;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r6, r7), attributeSet, r6);
        int i2 = R$attr.materialCardViewStyle;
        int i3 = s;
        TypedArray d2 = k.d(getContext(), attributeSet, R$styleable.MaterialCardView, i2, i3, new int[0]);
        f.b.a.e.g.a aVar = new f.b.a.e.g.a(this, attributeSet, i2, i3);
        this.f546k = aVar;
        aVar.c.q(super.getCardBackgroundColor());
        aVar.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.k();
        ColorStateList x0 = b.x0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_strokeColor);
        aVar.m = x0;
        if (x0 == null) {
            aVar.m = ColorStateList.valueOf(-1);
        }
        aVar.f2869g = d2.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = d2.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        aVar.s = z;
        aVar.a.setLongClickable(z);
        aVar.f2873k = b.x0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIconTint);
        aVar.g(b.D0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIcon));
        aVar.f2868f = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        aVar.f2867e = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList x02 = b.x0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_rippleColor);
        aVar.f2872j = x02;
        if (x02 == null) {
            aVar.f2872j = ColorStateList.valueOf(b.w0(aVar.a, R$attr.colorControlHighlight));
        }
        ColorStateList x03 = b.x0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_cardForegroundColor);
        aVar.f2866d.q(x03 == null ? ColorStateList.valueOf(0) : x03);
        aVar.m();
        aVar.c.p(aVar.a.getCardElevation());
        aVar.n();
        aVar.a.setBackgroundInternal(aVar.f(aVar.c));
        Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2866d;
        aVar.f2870h = e2;
        aVar.a.setForeground(aVar.f(e2));
        d2.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f546k.c.getBounds());
        return rectF;
    }

    public final void d() {
        f.b.a.e.g.a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (aVar = this.f546k).n) != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    public boolean e() {
        f.b.a.e.g.a aVar = this.f546k;
        return aVar != null && aVar.s;
    }

    @Override // e.d.a.a
    public ColorStateList getCardBackgroundColor() {
        return this.f546k.c.b.f3035d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f546k.f2866d.b.f3035d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f546k.f2871i;
    }

    public int getCheckedIconMargin() {
        return this.f546k.f2867e;
    }

    public int getCheckedIconSize() {
        return this.f546k.f2868f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f546k.f2873k;
    }

    @Override // e.d.a.a
    public int getContentPaddingBottom() {
        return this.f546k.b.bottom;
    }

    @Override // e.d.a.a
    public int getContentPaddingLeft() {
        return this.f546k.b.left;
    }

    @Override // e.d.a.a
    public int getContentPaddingRight() {
        return this.f546k.b.right;
    }

    @Override // e.d.a.a
    public int getContentPaddingTop() {
        return this.f546k.b.top;
    }

    public float getProgress() {
        return this.f546k.c.b.f3042k;
    }

    @Override // e.d.a.a
    public float getRadius() {
        return this.f546k.c.l();
    }

    public ColorStateList getRippleColor() {
        return this.f546k.f2872j;
    }

    public j getShapeAppearanceModel() {
        return this.f546k.f2874l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f546k.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f546k.m;
    }

    public int getStrokeWidth() {
        return this.f546k.f2869g;
    }

    public boolean isChecked() {
        return this.m;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.p1(this, this.f546k.c);
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
        f.b.a.e.g.a aVar = this.f546k;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.o != null) {
            int i6 = aVar.f2867e;
            int i7 = aVar.f2868f;
            int i8 = (measuredWidth - i6) - i7;
            int i9 = (measuredHeight - i6) - i7;
            if (aVar.a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil((double) (aVar.d() * 2.0f));
                i8 -= (int) Math.ceil((double) (aVar.c() * 2.0f));
            }
            int i10 = aVar.f2867e;
            MaterialCardView materialCardView = aVar.a;
            AtomicInteger atomicInteger = v.a;
            if (v.e.d(materialCardView) == 1) {
                i4 = i8;
                i5 = i10;
            } else {
                i5 = i8;
                i4 = i10;
            }
            aVar.o.setLayerInset(2, i5, aVar.f2867e, i4, i9);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f547l) {
            f.b.a.e.g.a aVar = this.f546k;
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
        f.b.a.e.g.a aVar = this.f546k;
        aVar.c.q(ColorStateList.valueOf(i2));
    }

    @Override // e.d.a.a
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        f.b.a.e.g.a aVar = this.f546k;
        aVar.c.p(aVar.a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.f546k.f2866d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.q(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f546k.s = z;
    }

    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f546k.g(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f546k.f2867e = i2;
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f546k.f2867e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f546k.g(m.e.h0(getContext(), i2));
    }

    public void setCheckedIconSize(int i2) {
        this.f546k.f2868f = i2;
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f546k.f2868f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f546k;
        aVar.f2873k = colorStateList;
        Drawable drawable = aVar.f2871i;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        f.b.a.e.g.a aVar = this.f546k;
        if (aVar != null) {
            Drawable drawable = aVar.f2870h;
            Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2866d;
            aVar.f2870h = e2;
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
        this.f546k.l();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.o = aVar;
    }

    @Override // e.d.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f546k.l();
        this.f546k.k();
    }

    public void setProgress(float f2) {
        f.b.a.e.g.a aVar = this.f546k;
        aVar.c.r(f2);
        g gVar = aVar.f2866d;
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
        f.b.a.e.g.a aVar = this.f546k;
        aVar.h(aVar.f2874l.e(f2));
        aVar.f2870h.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f546k;
        aVar.f2872j = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(int i2) {
        f.b.a.e.g.a aVar = this.f546k;
        aVar.f2872j = m.e.f0(getContext(), i2);
        aVar.m();
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.f546k.h(jVar);
    }

    public void setStrokeColor(int i2) {
        setStrokeColor(ColorStateList.valueOf(i2));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f546k;
        if (aVar.m != colorStateList) {
            aVar.m = colorStateList;
            aVar.n();
        }
        invalidate();
    }

    public void setStrokeWidth(int i2) {
        f.b.a.e.g.a aVar = this.f546k;
        if (i2 != aVar.f2869g) {
            aVar.f2869g = i2;
            aVar.n();
        }
        invalidate();
    }

    @Override // e.d.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f546k.l();
        this.f546k.k();
    }

    public void toggle() {
        if (e() && isEnabled()) {
            this.m = !this.m;
            refreshDrawableState();
            d();
            f.b.a.e.g.a aVar = this.f546k;
            boolean z = this.m;
            Drawable drawable = aVar.f2871i;
            if (drawable != null) {
                drawable.setAlpha(z ? 255 : 0);
            }
            a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.a(this, this.m);
            }
        }
    }

    @Override // e.d.a.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f546k.c.q(colorStateList);
    }
}
