package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.a.m;
import e.b.f.f;
import e.i.i.v;
import f.b.a.e.q.k;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import f.b.a.e.v.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialButton extends f implements Checkable, n {
    public static final int[] r = {16842911};
    public static final int[] s = {16842912};
    public static final int t = R$style.Widget_MaterialComponents_Button;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.e.f.a f525e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedHashSet<a> f526f = new LinkedHashSet<>();

    /* renamed from: g  reason: collision with root package name */
    public b f527g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f528h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f529i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f530j;

    /* renamed from: k  reason: collision with root package name */
    public int f531k;

    /* renamed from: l  reason: collision with root package name */
    public int f532l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public int q;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
    }

    public static class c extends e.k.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f533d;

        public static class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new c[i2];
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
            this.f533d = parcel.readInt() != 1 ? false : true;
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f533d ? 1 : 0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r6, r7), attributeSet, r6);
        int i2 = R$attr.materialButtonStyle;
        int i3 = t;
        boolean z = false;
        this.o = false;
        this.p = false;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialButton, i2, i3, new int[0]);
        this.n = d2.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f528h = f.b.a.c.b.o.b.f1(d2.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f529i = f.b.a.c.b.o.b.x0(getContext(), d2, R$styleable.MaterialButton_iconTint);
        this.f530j = f.b.a.c.b.o.b.D0(getContext(), d2, R$styleable.MaterialButton_icon);
        this.q = d2.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f531k = d2.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        f.b.a.e.f.a aVar = new f.b.a.e.f.a(this, j.b(context2, attributeSet, i2, i3).a());
        this.f525e = aVar;
        aVar.c = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        aVar.f2857d = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        aVar.f2858e = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        aVar.f2859f = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        int i4 = R$styleable.MaterialButton_cornerRadius;
        if (d2.hasValue(i4)) {
            int dimensionPixelSize = d2.getDimensionPixelSize(i4, -1);
            aVar.f2860g = dimensionPixelSize;
            aVar.e(aVar.b.e((float) dimensionPixelSize));
            aVar.p = true;
        }
        aVar.f2861h = d2.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        aVar.f2862i = f.b.a.c.b.o.b.f1(d2.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        aVar.f2863j = f.b.a.c.b.o.b.x0(aVar.a.getContext(), d2, R$styleable.MaterialButton_backgroundTint);
        aVar.f2864k = f.b.a.c.b.o.b.x0(aVar.a.getContext(), d2, R$styleable.MaterialButton_strokeColor);
        aVar.f2865l = f.b.a.c.b.o.b.x0(aVar.a.getContext(), d2, R$styleable.MaterialButton_rippleColor);
        aVar.q = d2.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        aVar.s = d2.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        MaterialButton materialButton = aVar.a;
        AtomicInteger atomicInteger = v.a;
        int f2 = v.e.f(materialButton);
        int paddingTop = aVar.a.getPaddingTop();
        int e2 = v.e.e(aVar.a);
        int paddingBottom = aVar.a.getPaddingBottom();
        if (d2.hasValue(R$styleable.MaterialButton_android_background)) {
            aVar.o = true;
            aVar.a.setSupportBackgroundTintList(aVar.f2863j);
            aVar.a.setSupportBackgroundTintMode(aVar.f2862i);
        } else {
            aVar.g();
        }
        v.e.k(aVar.a, f2 + aVar.c, paddingTop + aVar.f2858e, e2 + aVar.f2857d, paddingBottom + aVar.f2859f);
        d2.recycle();
        setCompoundDrawablePadding(this.n);
        g(this.f530j != null ? true : z);
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
        f.b.a.e.f.a aVar = this.f525e;
        return aVar != null && aVar.q;
    }

    public final boolean b() {
        int i2 = this.q;
        return i2 == 3 || i2 == 4;
    }

    public final boolean c() {
        int i2 = this.q;
        return i2 == 1 || i2 == 2;
    }

    public final boolean d() {
        int i2 = this.q;
        return i2 == 16 || i2 == 32;
    }

    public final boolean e() {
        f.b.a.e.f.a aVar = this.f525e;
        return aVar != null && !aVar.o;
    }

    public final void f() {
        if (c()) {
            setCompoundDrawablesRelative(this.f530j, null, null, null);
        } else if (b()) {
            setCompoundDrawablesRelative(null, null, this.f530j, null);
        } else if (d()) {
            setCompoundDrawablesRelative(null, this.f530j, null, null);
        }
    }

    public final void g(boolean z) {
        Drawable drawable = this.f530j;
        boolean z2 = true;
        if (drawable != null) {
            Drawable mutate = m.e.P1(drawable).mutate();
            this.f530j = mutate;
            mutate.setTintList(this.f529i);
            PorterDuff.Mode mode = this.f528h;
            if (mode != null) {
                this.f530j.setTintMode(mode);
            }
            int i2 = this.f531k;
            if (i2 == 0) {
                i2 = this.f530j.getIntrinsicWidth();
            }
            int i3 = this.f531k;
            if (i3 == 0) {
                i3 = this.f530j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f530j;
            int i4 = this.f532l;
            int i5 = this.m;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
            this.f530j.setVisible(true, z);
        }
        if (z) {
            f();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((!c() || drawable3 == this.f530j) && ((!b() || drawable5 == this.f530j) && (!d() || drawable4 == this.f530j))) {
            z2 = false;
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
            return this.f525e.f2860g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f530j;
    }

    public int getIconGravity() {
        return this.q;
    }

    public int getIconPadding() {
        return this.n;
    }

    public int getIconSize() {
        return this.f531k;
    }

    public ColorStateList getIconTint() {
        return this.f529i;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f528h;
    }

    public int getInsetBottom() {
        return this.f525e.f2859f;
    }

    public int getInsetTop() {
        return this.f525e.f2858e;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f525e.f2865l;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        if (e()) {
            return this.f525e.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f525e.f2864k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f525e.f2861h;
        }
        return 0;
    }

    @Override // e.b.f.f
    public ColorStateList getSupportBackgroundTintList() {
        if (e()) {
            return this.f525e.f2863j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // e.b.f.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (e()) {
            return this.f525e.f2862i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public final void h(int i2, int i3) {
        if (this.f530j != null && getLayout() != null) {
            if (c() || b()) {
                this.m = 0;
                int i4 = this.q;
                boolean z = true;
                if (i4 == 1 || i4 == 3) {
                    this.f532l = 0;
                } else {
                    int i5 = this.f531k;
                    if (i5 == 0) {
                        i5 = this.f530j.getIntrinsicWidth();
                    }
                    int textWidth = i2 - getTextWidth();
                    AtomicInteger atomicInteger = v.a;
                    int e2 = ((((textWidth - v.e.e(this)) - i5) - this.n) - v.e.f(this)) / 2;
                    boolean z2 = v.e.d(this) == 1;
                    if (this.q != 4) {
                        z = false;
                    }
                    if (z2 != z) {
                        e2 = -e2;
                    }
                    if (this.f532l != e2) {
                        this.f532l = e2;
                        g(false);
                        return;
                    }
                    return;
                }
            } else if (d()) {
                this.f532l = 0;
                if (this.q == 16) {
                    this.m = 0;
                } else {
                    int i6 = this.f531k;
                    if (i6 == 0) {
                        i6 = this.f530j.getIntrinsicHeight();
                    }
                    int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i6) - this.n) - getPaddingBottom()) / 2;
                    if (this.m != textHeight) {
                        this.m = textHeight;
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
        return this.o;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            f.b.a.c.b.o.b.p1(this, this.f525e.b());
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, r);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, s);
        }
        return onCreateDrawableState;
    }

    @Override // e.b.f.f
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // e.b.f.f
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // e.b.f.f
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        f.b.a.e.f.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f525e) != null) {
            int i6 = i5 - i3;
            int i7 = i4 - i2;
            Drawable drawable = aVar.m;
            if (drawable != null) {
                drawable.setBounds(aVar.c, aVar.f2858e, i7 - aVar.f2857d, i6 - aVar.f2859f);
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.b);
        setChecked(cVar.f533d);
    }

    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f533d = this.o;
        return cVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        h(i2, i3);
    }

    @Override // e.b.f.f
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
            f.b.a.e.f.a aVar = this.f525e;
            if (aVar.b() != null) {
                aVar.b().setTint(i2);
                return;
            }
            return;
        }
        super.setBackgroundColor(i2);
    }

    @Override // e.b.f.f
    public void setBackgroundDrawable(Drawable drawable) {
        if (e()) {
            if (drawable != getBackground()) {
                f.b.a.e.f.a aVar = this.f525e;
                aVar.o = true;
                aVar.a.setSupportBackgroundTintList(aVar.f2863j);
                aVar.a.setSupportBackgroundTintMode(aVar.f2862i);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // e.b.f.f
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? m.e.h0(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.f525e.q = z;
        }
    }

    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.o != z) {
            this.o = z;
            refreshDrawableState();
            if (!this.p) {
                this.p = true;
                Iterator<a> it = this.f526f.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.o);
                }
                this.p = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (e()) {
            f.b.a.e.f.a aVar = this.f525e;
            if (!aVar.p || aVar.f2860g != i2) {
                aVar.f2860g = i2;
                aVar.p = true;
                aVar.e(aVar.b.e((float) i2));
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
            g b2 = this.f525e.b();
            g.b bVar = b2.b;
            if (bVar.o != f2) {
                bVar.o = f2;
                b2.y();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f530j != drawable) {
            this.f530j = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.q != i2) {
            this.q = i2;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i2) {
        if (this.n != i2) {
            this.n = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? m.e.h0(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f531k != i2) {
            this.f531k = i2;
            g(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f529i != colorStateList) {
            this.f529i = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f528h != mode) {
            this.f528h = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(m.e.f0(getContext(), i2));
    }

    public void setInsetBottom(int i2) {
        f.b.a.e.f.a aVar = this.f525e;
        aVar.f(aVar.f2858e, i2);
    }

    public void setInsetTop(int i2) {
        f.b.a.e.f.a aVar = this.f525e;
        aVar.f(i2, aVar.f2859f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f527g = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.f527g;
        if (bVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            f.b.a.e.f.a aVar = this.f525e;
            if (aVar.f2865l != colorStateList) {
                aVar.f2865l = colorStateList;
                boolean z = f.b.a.e.f.a.t;
                if (z && (aVar.a.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) aVar.a.getBackground()).setColor(f.b.a.e.t.b.a(colorStateList));
                } else if (!z && (aVar.a.getBackground() instanceof f.b.a.e.t.a)) {
                    ((f.b.a.e.t.a) aVar.a.getBackground()).setTintList(f.b.a.e.t.b.a(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i2) {
        if (e()) {
            setRippleColor(m.e.f0(getContext(), i2));
        }
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        if (e()) {
            this.f525e.e(jVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            f.b.a.e.f.a aVar = this.f525e;
            aVar.n = z;
            aVar.h();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            f.b.a.e.f.a aVar = this.f525e;
            if (aVar.f2864k != colorStateList) {
                aVar.f2864k = colorStateList;
                aVar.h();
            }
        }
    }

    public void setStrokeColorResource(int i2) {
        if (e()) {
            setStrokeColor(m.e.f0(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (e()) {
            f.b.a.e.f.a aVar = this.f525e;
            if (aVar.f2861h != i2) {
                aVar.f2861h = i2;
                aVar.h();
            }
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // e.b.f.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (e()) {
            f.b.a.e.f.a aVar = this.f525e;
            if (aVar.f2863j != colorStateList) {
                aVar.f2863j = colorStateList;
                if (aVar.b() != null) {
                    aVar.b().setTintList(aVar.f2863j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // e.b.f.f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (e()) {
            f.b.a.e.f.a aVar = this.f525e;
            if (aVar.f2862i != mode) {
                aVar.f2862i = mode;
                if (aVar.b() != null && aVar.f2862i != null) {
                    aVar.b().setTintMode(aVar.f2862i);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    public void toggle() {
        setChecked(!this.o);
    }
}
