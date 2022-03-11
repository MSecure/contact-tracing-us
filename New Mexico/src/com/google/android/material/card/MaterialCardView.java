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
import e.j.j.v;
import f.b.a.c.b.o.b;
import f.b.a.e.q.k;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import f.b.a.e.v.n;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class MaterialCardView extends e.e.a.a implements Checkable, n {
    public static final int[] p = {16842911};
    public static final int[] q = {16842912};
    public static final int[] r = {R$attr.state_dragged};
    public static final int s = R$style.Widget_MaterialComponents_CardView;

    /* renamed from: k */
    public final f.b.a.e.g.a f558k;
    public a o;
    public boolean m = false;
    public boolean n = false;

    /* renamed from: l */
    public boolean f559l = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r6, r7), attributeSet, r6);
        int i2 = R$attr.materialCardViewStyle;
        int i3 = s;
        TypedArray d2 = k.d(getContext(), attributeSet, R$styleable.MaterialCardView, i2, i3, new int[0]);
        f.b.a.e.g.a aVar = new f.b.a.e.g.a(this, attributeSet, i2, i3);
        this.f558k = aVar;
        aVar.c.r(super.getCardBackgroundColor());
        aVar.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.k();
        ColorStateList y0 = b.y0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_strokeColor);
        aVar.m = y0;
        if (y0 == null) {
            aVar.m = ColorStateList.valueOf(-1);
        }
        aVar.f2911g = d2.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = d2.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        aVar.s = z;
        aVar.a.setLongClickable(z);
        aVar.f2915k = b.y0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIconTint);
        aVar.g(b.E0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_checkedIcon));
        aVar.f2910f = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        aVar.f2909e = d2.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList y02 = b.y0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_rippleColor);
        aVar.f2914j = y02;
        if (y02 == null) {
            aVar.f2914j = ColorStateList.valueOf(b.x0(aVar.a, R$attr.colorControlHighlight));
        }
        ColorStateList y03 = b.y0(aVar.a.getContext(), d2, R$styleable.MaterialCardView_cardForegroundColor);
        aVar.f2908d.r(y03 == null ? ColorStateList.valueOf(0) : y03);
        aVar.m();
        aVar.c.q(aVar.a.getCardElevation());
        aVar.n();
        aVar.a.setBackgroundInternal(aVar.f(aVar.c));
        Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2908d;
        aVar.f2912h = e2;
        aVar.a.setForeground(aVar.f(e2));
        d2.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f558k.c.getBounds());
        return rectF;
    }

    public final void d() {
        f.b.a.e.g.a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (aVar = this.f558k).n) != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    public boolean e() {
        f.b.a.e.g.a aVar = this.f558k;
        return aVar != null && aVar.s;
    }

    @Override // e.e.a.a
    public ColorStateList getCardBackgroundColor() {
        return this.f558k.c.b.f3077d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f558k.f2908d.b.f3077d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f558k.f2913i;
    }

    public int getCheckedIconMargin() {
        return this.f558k.f2909e;
    }

    public int getCheckedIconSize() {
        return this.f558k.f2910f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f558k.f2915k;
    }

    @Override // e.e.a.a
    public int getContentPaddingBottom() {
        return this.f558k.b.bottom;
    }

    @Override // e.e.a.a
    public int getContentPaddingLeft() {
        return this.f558k.b.left;
    }

    @Override // e.e.a.a
    public int getContentPaddingRight() {
        return this.f558k.b.right;
    }

    @Override // e.e.a.a
    public int getContentPaddingTop() {
        return this.f558k.b.top;
    }

    public float getProgress() {
        return this.f558k.c.b.f3084k;
    }

    @Override // e.e.a.a
    public float getRadius() {
        return this.f558k.c.m();
    }

    public ColorStateList getRippleColor() {
        return this.f558k.f2914j;
    }

    public j getShapeAppearanceModel() {
        return this.f558k.f2916l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f558k.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f558k.m;
    }

    public int getStrokeWidth() {
        return this.f558k.f2911g;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.m;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.q1(this, this.f558k.c);
    }

    @Override // android.view.View, android.view.ViewGroup
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // e.e.a.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        f.b.a.e.g.a aVar = this.f558k;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.o != null) {
            int i6 = aVar.f2909e;
            int i7 = aVar.f2910f;
            int i8 = (measuredWidth - i6) - i7;
            int i9 = (measuredHeight - i6) - i7;
            if (aVar.a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil((double) (aVar.d() * 2.0f));
                i8 -= (int) Math.ceil((double) (aVar.c() * 2.0f));
            }
            int i10 = aVar.f2909e;
            MaterialCardView materialCardView = aVar.a;
            AtomicInteger atomicInteger = v.a;
            if (v.e.d(materialCardView) == 1) {
                i4 = i8;
                i5 = i10;
            } else {
                i5 = i8;
                i4 = i10;
            }
            aVar.o.setLayerInset(2, i5, aVar.f2909e, i4, i9);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f559l) {
            f.b.a.e.g.a aVar = this.f558k;
            if (!aVar.r) {
                aVar.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // e.e.a.a
    public void setCardBackgroundColor(int i2) {
        f.b.a.e.g.a aVar = this.f558k;
        aVar.c.r(ColorStateList.valueOf(i2));
    }

    @Override // e.e.a.a
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        f.b.a.e.g.a aVar = this.f558k;
        aVar.c.q(aVar.a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.f558k.f2908d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.r(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f558k.s = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f558k.g(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f558k.f2909e = i2;
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f558k.f2909e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f558k.g(m.e.i0(getContext(), i2));
    }

    public void setCheckedIconSize(int i2) {
        this.f558k.f2910f = i2;
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f558k.f2910f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f558k;
        aVar.f2915k = colorStateList;
        Drawable drawable = aVar.f2913i;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        f.b.a.e.g.a aVar = this.f558k;
        if (aVar != null) {
            Drawable drawable = aVar.f2912h;
            Drawable e2 = aVar.a.isClickable() ? aVar.e() : aVar.f2908d;
            aVar.f2912h = e2;
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

    @Override // e.e.a.a
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f558k.l();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.o = aVar;
    }

    @Override // e.e.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f558k.l();
        this.f558k.k();
    }

    public void setProgress(float f2) {
        f.b.a.e.g.a aVar = this.f558k;
        aVar.c.s(f2);
        g gVar = aVar.f2908d;
        if (gVar != null) {
            gVar.s(f2);
        }
        g gVar2 = aVar.q;
        if (gVar2 != null) {
            gVar2.s(f2);
        }
    }

    @Override // e.e.a.a
    public void setRadius(float f2) {
        super.setRadius(f2);
        f.b.a.e.g.a aVar = this.f558k;
        aVar.h(aVar.f2916l.e(f2));
        aVar.f2912h.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f558k;
        aVar.f2914j = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(int i2) {
        f.b.a.e.g.a aVar = this.f558k;
        aVar.f2914j = m.e.g0(getContext(), i2);
        aVar.m();
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.f558k.h(jVar);
    }

    public void setStrokeColor(int i2) {
        setStrokeColor(ColorStateList.valueOf(i2));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        f.b.a.e.g.a aVar = this.f558k;
        if (aVar.m != colorStateList) {
            aVar.m = colorStateList;
            aVar.n();
        }
        invalidate();
    }

    public void setStrokeWidth(int i2) {
        f.b.a.e.g.a aVar = this.f558k;
        if (i2 != aVar.f2911g) {
            aVar.f2911g = i2;
            aVar.n();
        }
        invalidate();
    }

    @Override // e.e.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f558k.l();
        this.f558k.k();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.m = !this.m;
            refreshDrawableState();
            d();
            f.b.a.e.g.a aVar = this.f558k;
            boolean z = this.m;
            Drawable drawable = aVar.f2913i;
            if (drawable != null) {
                drawable.setAlpha(z ? 255 : 0);
            }
            a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.a(this, this.m);
            }
        }
    }

    @Override // e.e.a.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f558k.c.r(colorStateList);
    }
}
