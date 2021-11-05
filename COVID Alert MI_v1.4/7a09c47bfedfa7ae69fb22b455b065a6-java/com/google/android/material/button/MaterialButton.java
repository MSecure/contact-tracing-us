package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import b.b.q.f;
import b.i.l.m;
import b.x.t;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.h0.n;
import c.b.a.b.k;
import c.b.a.b.l;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends f implements Checkable, n {
    public static final int[] q = {16842911};
    public static final int[] r = {16842912};
    public static final int s = k.Widget_MaterialComponents_Button;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.a.b.s.a f6051d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<a> f6052e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public b f6053f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f6054g;
    public ColorStateList h;
    public Drawable i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n = false;
    public boolean o = false;
    public int p;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
    }

    public static class c extends b.k.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f6055d;

        public static class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new c[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                c.class.getClassLoader();
            }
            this.f6055d = parcel.readInt() != 1 ? false : true;
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1952b, i);
            parcel.writeInt(this.f6055d ? 1 : 0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r8, s), attributeSet, r8);
        int i2 = c.b.a.b.b.materialButtonStyle;
        Context context2 = getContext();
        TypedArray d2 = c.b.a.b.c0.k.d(context2, attributeSet, l.MaterialButton, i2, s, new int[0]);
        this.m = d2.getDimensionPixelSize(l.MaterialButton_iconPadding, 0);
        this.f6054g = t.m2(d2.getInt(l.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.h = t.B1(getContext(), d2, l.MaterialButton_iconTint);
        this.i = t.F1(getContext(), d2, l.MaterialButton_icon);
        this.p = d2.getInteger(l.MaterialButton_iconGravity, 1);
        this.j = d2.getDimensionPixelSize(l.MaterialButton_iconSize, 0);
        c.b.a.b.s.a aVar = new c.b.a.b.s.a(this, j.b(context2, attributeSet, i2, s).a());
        this.f6051d = aVar;
        aVar.f4515c = d2.getDimensionPixelOffset(l.MaterialButton_android_insetLeft, 0);
        aVar.f4516d = d2.getDimensionPixelOffset(l.MaterialButton_android_insetRight, 0);
        aVar.f4517e = d2.getDimensionPixelOffset(l.MaterialButton_android_insetTop, 0);
        aVar.f4518f = d2.getDimensionPixelOffset(l.MaterialButton_android_insetBottom, 0);
        if (d2.hasValue(l.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = d2.getDimensionPixelSize(l.MaterialButton_cornerRadius, -1);
            aVar.f4519g = dimensionPixelSize;
            aVar.e(aVar.f4514b.e((float) dimensionPixelSize));
            aVar.p = true;
        }
        aVar.h = d2.getDimensionPixelSize(l.MaterialButton_strokeWidth, 0);
        aVar.i = t.m2(d2.getInt(l.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        aVar.j = t.B1(aVar.f4513a.getContext(), d2, l.MaterialButton_backgroundTint);
        aVar.k = t.B1(aVar.f4513a.getContext(), d2, l.MaterialButton_strokeColor);
        aVar.l = t.B1(aVar.f4513a.getContext(), d2, l.MaterialButton_rippleColor);
        aVar.q = d2.getBoolean(l.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = d2.getDimensionPixelSize(l.MaterialButton_elevation, 0);
        int t = m.t(aVar.f4513a);
        int paddingTop = aVar.f4513a.getPaddingTop();
        int paddingEnd = aVar.f4513a.getPaddingEnd();
        int paddingBottom = aVar.f4513a.getPaddingBottom();
        if (d2.hasValue(l.MaterialButton_android_background)) {
            aVar.o = true;
            aVar.f4513a.setSupportBackgroundTintList(aVar.j);
            aVar.f4513a.setSupportBackgroundTintMode(aVar.i);
        } else {
            MaterialButton materialButton = aVar.f4513a;
            g gVar = new g(aVar.f4514b);
            gVar.o(aVar.f4513a.getContext());
            gVar.setTintList(aVar.j);
            PorterDuff.Mode mode = aVar.i;
            if (mode != null) {
                gVar.setTintMode(mode);
            }
            gVar.v((float) aVar.h, aVar.k);
            g gVar2 = new g(aVar.f4514b);
            gVar2.setTint(0);
            gVar2.u((float) aVar.h, aVar.n ? t.A1(aVar.f4513a, c.b.a.b.b.colorSurface) : 0);
            g gVar3 = new g(aVar.f4514b);
            aVar.m = gVar3;
            gVar3.setTint(-1);
            RippleDrawable rippleDrawable = new RippleDrawable(c.b.a.b.f0.a.b(aVar.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), aVar.f4515c, aVar.f4517e, aVar.f4516d, aVar.f4518f), aVar.m);
            aVar.r = rippleDrawable;
            materialButton.setInternalBackground(rippleDrawable);
            g b2 = aVar.b();
            if (b2 != null) {
                b2.q((float) dimensionPixelSize2);
            }
        }
        aVar.f4513a.setPaddingRelative(t + aVar.f4515c, paddingTop + aVar.f4517e, paddingEnd + aVar.f4516d, paddingBottom + aVar.f4518f);
        d2.recycle();
        setCompoundDrawablePadding(this.m);
        g(this.i != null);
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public boolean a() {
        c.b.a.b.s.a aVar = this.f6051d;
        return aVar != null && aVar.q;
    }

    public final boolean b() {
        int i2 = this.p;
        return i2 == 3 || i2 == 4;
    }

    public final boolean c() {
        int i2 = this.p;
        return i2 == 1 || i2 == 2;
    }

    public final boolean d() {
        int i2 = this.p;
        return i2 == 16 || i2 == 32;
    }

    public final boolean e() {
        c.b.a.b.s.a aVar = this.f6051d;
        return aVar != null && !aVar.o;
    }

    public final void f() {
        if (c()) {
            setCompoundDrawablesRelative(this.i, null, null, null);
        } else if (b()) {
            setCompoundDrawablesRelative(null, null, this.i, null);
        } else if (d()) {
            setCompoundDrawablesRelative(null, this.i, null, null);
        }
    }

    public final void g(boolean z) {
        Drawable drawable = this.i;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.i = mutate;
            mutate.setTintList(this.h);
            PorterDuff.Mode mode = this.f6054g;
            if (mode != null) {
                this.i.setTintMode(mode);
            }
            int i2 = this.j;
            if (i2 == 0) {
                i2 = this.i.getIntrinsicWidth();
            }
            int i3 = this.j;
            if (i3 == 0) {
                i3 = this.i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.i;
            int i4 = this.k;
            int i5 = this.l;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
        }
        if (z) {
            f();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((c() && drawable3 != this.i) || ((b() && drawable5 != this.i) || (d() && drawable4 != this.i))) {
            z2 = true;
        }
        if (z2) {
            f();
        }
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (e()) {
            return this.f6051d.f4519g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.i;
    }

    public int getIconGravity() {
        return this.p;
    }

    public int getIconPadding() {
        return this.m;
    }

    public int getIconSize() {
        return this.j;
    }

    public ColorStateList getIconTint() {
        return this.h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f6054g;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f6051d.l;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        if (e()) {
            return this.f6051d.f4514b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f6051d.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f6051d.h;
        }
        return 0;
    }

    @Override // b.b.q.f
    public ColorStateList getSupportBackgroundTintList() {
        if (e()) {
            return this.f6051d.j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // b.b.q.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (e()) {
            return this.f6051d.i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public final void h(int i2, int i3) {
        if (this.i != null && getLayout() != null) {
            if (c() || b()) {
                this.l = 0;
                int i4 = this.p;
                boolean z = true;
                if (i4 == 1 || i4 == 3) {
                    this.k = 0;
                } else {
                    int i5 = this.j;
                    if (i5 == 0) {
                        i5 = this.i.getIntrinsicWidth();
                    }
                    int textWidth = (((((i2 - getTextWidth()) - m.s(this)) - i5) - this.m) - getPaddingStart()) / 2;
                    boolean z2 = m.p(this) == 1;
                    if (this.p != 4) {
                        z = false;
                    }
                    if (z2 != z) {
                        textWidth = -textWidth;
                    }
                    if (this.k != textWidth) {
                        this.k = textWidth;
                        g(false);
                        return;
                    }
                    return;
                }
            } else if (d()) {
                this.k = 0;
                if (this.p == 16) {
                    this.l = 0;
                } else {
                    int i6 = this.j;
                    if (i6 == 0) {
                        i6 = this.i.getIntrinsicHeight();
                    }
                    int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i6) - this.m) - getPaddingBottom()) / 2;
                    if (this.l != textHeight) {
                        this.l = textHeight;
                        g(false);
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            g(false);
        }
    }

    public boolean isChecked() {
        return this.n;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            t.K2(this, this.f6051d.b());
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, q);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    @Override // b.b.q.f
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // b.b.q.f
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // b.b.q.f
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.f1952b);
        setChecked(cVar.f6055d);
    }

    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f6055d = this.n;
        return cVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        h(i2, i3);
    }

    @Override // b.b.q.f
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            if (aVar.b() != null) {
                aVar.b().setTint(i2);
                return;
            }
            return;
        }
        super.setBackgroundColor(i2);
    }

    @Override // b.b.q.f
    public void setBackgroundDrawable(Drawable drawable) {
        if (e()) {
            if (drawable != getBackground()) {
                c.b.a.b.s.a aVar = this.f6051d;
                aVar.o = true;
                aVar.f4513a.setSupportBackgroundTintList(aVar.j);
                aVar.f4513a.setSupportBackgroundTintMode(aVar.i);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // b.b.q.f
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.f6051d.q = z;
        }
    }

    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.n != z) {
            this.n = z;
            refreshDrawableState();
            if (!this.o) {
                this.o = true;
                Iterator<a> it = this.f6052e.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.n);
                }
                this.o = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            if (!aVar.p || aVar.f4519g != i2) {
                aVar.f4519g = i2;
                aVar.p = true;
                aVar.e(aVar.f4514b.e((float) i2));
            }
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (e()) {
            g b2 = this.f6051d.b();
            g.b bVar = b2.f4261b;
            if (bVar.o != f2) {
                bVar.o = f2;
                b2.z();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.p != i2) {
            this.p = i2;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i2) {
        if (this.m != i2) {
            this.m = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.j != i2) {
            this.j = i2;
            g(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f6054g != mode) {
            this.f6054g = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(b.b.l.a.a.a(getContext(), i2));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f6053f = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.f6053f;
        if (bVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            if (aVar.l != colorStateList) {
                aVar.l = colorStateList;
                if (aVar.f4513a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) aVar.f4513a.getBackground()).setColor(c.b.a.b.f0.a.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i2) {
        if (e()) {
            setRippleColor(b.b.l.a.a.a(getContext(), i2));
        }
    }

    @Override // c.b.a.b.h0.n
    public void setShapeAppearanceModel(j jVar) {
        if (e()) {
            this.f6051d.e(jVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            aVar.n = z;
            aVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            if (aVar.k != colorStateList) {
                aVar.k = colorStateList;
                aVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i2) {
        if (e()) {
            setStrokeColor(b.b.l.a.a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            if (aVar.h != i2) {
                aVar.h = i2;
                aVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // b.b.q.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            if (aVar.j != colorStateList) {
                aVar.j = colorStateList;
                if (aVar.b() != null) {
                    aVar.b().setTintList(aVar.j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // b.b.q.f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (e()) {
            c.b.a.b.s.a aVar = this.f6051d;
            if (aVar.i != mode) {
                aVar.i = mode;
                if (aVar.b() != null && aVar.i != null) {
                    aVar.b().setTintMode(aVar.i);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    public void toggle() {
        setChecked(!this.n);
    }
}
