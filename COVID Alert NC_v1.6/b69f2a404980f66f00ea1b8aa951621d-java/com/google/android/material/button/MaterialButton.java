package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
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
import c.b.a.b.c0.i;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.h0.n;
import c.b.a.b.k;
import c.b.a.b.l;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends f implements Checkable, n {
    public static final int[] p = {16842911};
    public static final int[] q = {16842912};
    public static final int r = k.Widget_MaterialComponents_Button;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.a.b.s.a f4489d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<a> f4490e = new LinkedHashSet<>();
    public b f;
    public PorterDuff.Mode g;
    public ColorStateList h;
    public Drawable i;
    public int j;
    public int k;
    public int l;
    public boolean m = false;
    public boolean n = false;
    public int o;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public static class c extends b.k.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f4491d;

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
            this.f4491d = parcel.readInt() != 1 ? false : true;
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            parcel.writeInt(this.f4491d ? 1 : 0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r8, r), attributeSet, r8);
        int i2 = c.b.a.b.b.materialButtonStyle;
        Context context2 = getContext();
        TypedArray d2 = i.d(context2, attributeSet, l.MaterialButton, i2, r, new int[0]);
        this.l = d2.getDimensionPixelSize(l.MaterialButton_iconPadding, 0);
        this.g = c.b.a.a.c.n.c.M1(d2.getInt(l.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.h = c.b.a.a.c.n.c.Z0(getContext(), d2, l.MaterialButton_iconTint);
        this.i = c.b.a.a.c.n.c.d1(getContext(), d2, l.MaterialButton_icon);
        this.o = d2.getInteger(l.MaterialButton_iconGravity, 1);
        this.j = d2.getDimensionPixelSize(l.MaterialButton_iconSize, 0);
        c.b.a.b.s.a aVar = new c.b.a.b.s.a(this, j.b(context2, attributeSet, i2, r).a());
        this.f4489d = aVar;
        aVar.f3200c = d2.getDimensionPixelOffset(l.MaterialButton_android_insetLeft, 0);
        aVar.f3201d = d2.getDimensionPixelOffset(l.MaterialButton_android_insetRight, 0);
        aVar.f3202e = d2.getDimensionPixelOffset(l.MaterialButton_android_insetTop, 0);
        aVar.f = d2.getDimensionPixelOffset(l.MaterialButton_android_insetBottom, 0);
        if (d2.hasValue(l.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = d2.getDimensionPixelSize(l.MaterialButton_cornerRadius, -1);
            aVar.g = dimensionPixelSize;
            aVar.e(aVar.f3199b.e((float) dimensionPixelSize));
            aVar.p = true;
        }
        aVar.h = d2.getDimensionPixelSize(l.MaterialButton_strokeWidth, 0);
        aVar.i = c.b.a.a.c.n.c.M1(d2.getInt(l.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        aVar.j = c.b.a.a.c.n.c.Z0(aVar.f3198a.getContext(), d2, l.MaterialButton_backgroundTint);
        aVar.k = c.b.a.a.c.n.c.Z0(aVar.f3198a.getContext(), d2, l.MaterialButton_strokeColor);
        aVar.l = c.b.a.a.c.n.c.Z0(aVar.f3198a.getContext(), d2, l.MaterialButton_rippleColor);
        aVar.q = d2.getBoolean(l.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = d2.getDimensionPixelSize(l.MaterialButton_elevation, 0);
        int s = m.s(aVar.f3198a);
        int paddingTop = aVar.f3198a.getPaddingTop();
        int paddingEnd = aVar.f3198a.getPaddingEnd();
        int paddingBottom = aVar.f3198a.getPaddingBottom();
        if (d2.hasValue(l.MaterialButton_android_background)) {
            aVar.o = true;
            aVar.f3198a.setSupportBackgroundTintList(aVar.j);
            aVar.f3198a.setSupportBackgroundTintMode(aVar.i);
        } else {
            MaterialButton materialButton = aVar.f3198a;
            g gVar = new g(aVar.f3199b);
            gVar.o(aVar.f3198a.getContext());
            gVar.setTintList(aVar.j);
            PorterDuff.Mode mode = aVar.i;
            if (mode != null) {
                gVar.setTintMode(mode);
            }
            gVar.v((float) aVar.h, aVar.k);
            g gVar2 = new g(aVar.f3199b);
            gVar2.setTint(0);
            gVar2.u((float) aVar.h, aVar.n ? c.b.a.a.c.n.c.Y0(aVar.f3198a, c.b.a.b.b.colorSurface) : 0);
            g gVar3 = new g(aVar.f3199b);
            aVar.m = gVar3;
            gVar3.setTint(-1);
            RippleDrawable rippleDrawable = new RippleDrawable(c.b.a.b.f0.a.b(aVar.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), aVar.f3200c, aVar.f3202e, aVar.f3201d, aVar.f), aVar.m);
            aVar.r = rippleDrawable;
            materialButton.setInternalBackground(rippleDrawable);
            g b2 = aVar.b();
            if (b2 != null) {
                b2.q((float) dimensionPixelSize2);
            }
        }
        aVar.f3198a.setPaddingRelative(s + aVar.f3200c, paddingTop + aVar.f3202e, paddingEnd + aVar.f3201d, paddingBottom + aVar.f);
        d2.recycle();
        setCompoundDrawablePadding(this.l);
        c(this.i != null);
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public boolean a() {
        c.b.a.b.s.a aVar = this.f4489d;
        return aVar != null && aVar.q;
    }

    public final boolean b() {
        c.b.a.b.s.a aVar = this.f4489d;
        return aVar != null && !aVar.o;
    }

    public final void c(boolean z) {
        Drawable drawable = this.i;
        boolean z2 = false;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.i = mutate;
            mutate.setTintList(this.h);
            PorterDuff.Mode mode = this.g;
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
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        int i5 = this.o;
        boolean z3 = i5 == 1 || i5 == 2;
        if (z) {
            Drawable drawable3 = this.i;
            if (z3) {
                setCompoundDrawablesRelative(drawable3, null, null, null);
            } else {
                setCompoundDrawablesRelative(null, null, drawable3, null);
            }
        } else {
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            Drawable drawable4 = compoundDrawablesRelative[0];
            Drawable drawable5 = compoundDrawablesRelative[2];
            if ((z3 && drawable4 != this.i) || (!z3 && drawable5 != this.i)) {
                z2 = true;
            }
            if (z2) {
                Drawable drawable6 = this.i;
                if (z3) {
                    setCompoundDrawablesRelative(drawable6, null, null, null);
                } else {
                    setCompoundDrawablesRelative(null, null, drawable6, null);
                }
            }
        }
    }

    public final void d() {
        if (this.i != null && getLayout() != null) {
            int i2 = this.o;
            boolean z = true;
            if (i2 == 1 || i2 == 3) {
                this.k = 0;
                c(false);
                return;
            }
            TextPaint paint = getPaint();
            String charSequence = getText().toString();
            if (getTransformationMethod() != null) {
                charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
            }
            int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
            int i3 = this.j;
            if (i3 == 0) {
                i3 = this.i.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - min) - m.r(this)) - i3) - this.l) - getPaddingStart()) / 2;
            boolean z2 = m.o(this) == 1;
            if (this.o != 4) {
                z = false;
            }
            if (z2 != z) {
                measuredWidth = -measuredWidth;
            }
            if (this.k != measuredWidth) {
                this.k = measuredWidth;
                c(false);
            }
        }
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f4489d.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.i;
    }

    public int getIconGravity() {
        return this.o;
    }

    public int getIconPadding() {
        return this.l;
    }

    public int getIconSize() {
        return this.j;
    }

    public ColorStateList getIconTint() {
        return this.h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.g;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f4489d.l;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        if (b()) {
            return this.f4489d.f3199b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f4489d.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f4489d.h;
        }
        return 0;
    }

    @Override // b.b.q.f
    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.f4489d.j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // b.b.q.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.f4489d.i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isChecked() {
        return this.m;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (b()) {
            c.b.a.a.c.n.c.f2(this, this.f4489d.b());
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, q);
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

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        d();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.f1231b);
        setChecked(cVar.f4491d);
    }

    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f4491d = this.m;
        return cVar;
    }

    @Override // b.b.q.f
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        d();
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
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
        if (b()) {
            if (drawable != getBackground()) {
                c.b.a.b.s.a aVar = this.f4489d;
                aVar.o = true;
                aVar.f3198a.setSupportBackgroundTintList(aVar.j);
                aVar.f3198a.setSupportBackgroundTintMode(aVar.i);
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
        if (b()) {
            this.f4489d.q = z;
        }
    }

    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.m != z) {
            this.m = z;
            refreshDrawableState();
            if (!this.n) {
                this.n = true;
                Iterator<a> it = this.f4490e.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.m);
                }
                this.n = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
            if (!aVar.p || aVar.g != i2) {
                aVar.g = i2;
                aVar.p = true;
                aVar.e(aVar.f3199b.e((float) i2));
            }
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (b()) {
            g b2 = this.f4489d.b();
            g.b bVar = b2.f2982b;
            if (bVar.o != f2) {
                bVar.o = f2;
                b2.z();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            c(true);
        }
    }

    public void setIconGravity(int i2) {
        if (this.o != i2) {
            this.o = i2;
            d();
        }
    }

    public void setIconPadding(int i2) {
        if (this.l != i2) {
            this.l = i2;
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
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.g != mode) {
            this.g = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(b.b.l.a.a.a(getContext(), i2));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
            if (aVar.l != colorStateList) {
                aVar.l = colorStateList;
                if (aVar.f3198a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) aVar.f3198a.getBackground()).setColor(c.b.a.b.f0.a.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i2) {
        if (b()) {
            setRippleColor(b.b.l.a.a.a(getContext(), i2));
        }
    }

    @Override // c.b.a.b.h0.n
    public void setShapeAppearanceModel(j jVar) {
        if (b()) {
            this.f4489d.e(jVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
            aVar.n = z;
            aVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
            if (aVar.k != colorStateList) {
                aVar.k = colorStateList;
                aVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i2) {
        if (b()) {
            setStrokeColor(b.b.l.a.a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
            if (aVar.h != i2) {
                aVar.h = i2;
                aVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // b.b.q.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
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
        if (b()) {
            c.b.a.b.s.a aVar = this.f4489d;
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
        setChecked(!this.m);
    }
}
