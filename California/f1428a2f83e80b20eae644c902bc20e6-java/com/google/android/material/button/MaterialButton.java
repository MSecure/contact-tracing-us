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
import android.util.Log;
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
import e.i.i.l;
import f.b.a.d.q.k;
import f.b.a.d.v.g;
import f.b.a.d.v.j;
import f.b.a.d.v.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialButton extends f implements Checkable, n {
    public static final int[] q = {16842911};
    public static final int[] r = {16842912};
    public static final int s = R$style.Widget_MaterialComponents_Button;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.d.g.a f485d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<a> f486e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public b f487f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f488g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f489h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f490i;

    /* renamed from: j  reason: collision with root package name */
    public int f491j;

    /* renamed from: k  reason: collision with root package name */
    public int f492k;

    /* renamed from: l  reason: collision with root package name */
    public int f493l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
    }

    public static class c extends e.k.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f494d;

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
            this.f494d = parcel.readInt() != 1 ? false : true;
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f494d ? 1 : 0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(f.b.a.d.a0.a.a.a(context, attributeSet, r6, r7), attributeSet, r6);
        int i2 = R$attr.materialButtonStyle;
        int i3 = s;
        boolean z = false;
        this.n = false;
        this.o = false;
        Context context2 = getContext();
        TypedArray d2 = k.d(context2, attributeSet, R$styleable.MaterialButton, i2, i3, new int[0]);
        this.m = d2.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f488g = f.b.a.c.b.o.b.v1(d2.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f489h = f.b.a.c.b.o.b.L0(getContext(), d2, R$styleable.MaterialButton_iconTint);
        this.f490i = f.b.a.c.b.o.b.O0(getContext(), d2, R$styleable.MaterialButton_icon);
        this.p = d2.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f491j = d2.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        f.b.a.d.g.a aVar = new f.b.a.d.g.a(this, j.b(context2, attributeSet, i2, i3).a());
        this.f485d = aVar;
        aVar.c = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        aVar.f2588d = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        aVar.f2589e = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        aVar.f2590f = d2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        int i4 = R$styleable.MaterialButton_cornerRadius;
        if (d2.hasValue(i4)) {
            int dimensionPixelSize = d2.getDimensionPixelSize(i4, -1);
            aVar.f2591g = dimensionPixelSize;
            aVar.e(aVar.b.e((float) dimensionPixelSize));
            aVar.p = true;
        }
        aVar.f2592h = d2.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        aVar.f2593i = f.b.a.c.b.o.b.v1(d2.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        aVar.f2594j = f.b.a.c.b.o.b.L0(aVar.a.getContext(), d2, R$styleable.MaterialButton_backgroundTint);
        aVar.f2595k = f.b.a.c.b.o.b.L0(aVar.a.getContext(), d2, R$styleable.MaterialButton_strokeColor);
        aVar.f2596l = f.b.a.c.b.o.b.L0(aVar.a.getContext(), d2, R$styleable.MaterialButton_rippleColor);
        aVar.q = d2.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        aVar.s = d2.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        MaterialButton materialButton = aVar.a;
        AtomicInteger atomicInteger = l.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = aVar.a.getPaddingTop();
        int paddingEnd = aVar.a.getPaddingEnd();
        int paddingBottom = aVar.a.getPaddingBottom();
        if (d2.hasValue(R$styleable.MaterialButton_android_background)) {
            aVar.o = true;
            aVar.a.setSupportBackgroundTintList(aVar.f2594j);
            aVar.a.setSupportBackgroundTintMode(aVar.f2593i);
        } else {
            aVar.g();
        }
        aVar.a.setPaddingRelative(paddingStart + aVar.c, paddingTop + aVar.f2589e, paddingEnd + aVar.f2588d, paddingBottom + aVar.f2590f);
        d2.recycle();
        setCompoundDrawablePadding(this.m);
        g(this.f490i != null ? true : z);
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
        f.b.a.d.g.a aVar = this.f485d;
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
        f.b.a.d.g.a aVar = this.f485d;
        return aVar != null && !aVar.o;
    }

    public final void f() {
        if (c()) {
            setCompoundDrawablesRelative(this.f490i, null, null, null);
        } else if (b()) {
            setCompoundDrawablesRelative(null, null, this.f490i, null);
        } else if (d()) {
            setCompoundDrawablesRelative(null, this.f490i, null, null);
        }
    }

    public final void g(boolean z) {
        Drawable drawable = this.f490i;
        if (drawable != null) {
            Drawable mutate = m.h.v1(drawable).mutate();
            this.f490i = mutate;
            mutate.setTintList(this.f489h);
            PorterDuff.Mode mode = this.f488g;
            if (mode != null) {
                this.f490i.setTintMode(mode);
            }
            int i2 = this.f491j;
            if (i2 == 0) {
                i2 = this.f490i.getIntrinsicWidth();
            }
            int i3 = this.f491j;
            if (i3 == 0) {
                i3 = this.f490i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f490i;
            int i4 = this.f492k;
            int i5 = this.f493l;
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
        if ((c() && drawable3 != this.f490i) || ((b() && drawable5 != this.f490i) || (d() && drawable4 != this.f490i))) {
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
            return this.f485d.f2591g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f490i;
    }

    public int getIconGravity() {
        return this.p;
    }

    public int getIconPadding() {
        return this.m;
    }

    public int getIconSize() {
        return this.f491j;
    }

    public ColorStateList getIconTint() {
        return this.f489h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f488g;
    }

    public int getInsetBottom() {
        return this.f485d.f2590f;
    }

    public int getInsetTop() {
        return this.f485d.f2589e;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f485d.f2596l;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        if (e()) {
            return this.f485d.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f485d.f2595k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f485d.f2592h;
        }
        return 0;
    }

    @Override // e.b.f.f
    public ColorStateList getSupportBackgroundTintList() {
        if (e()) {
            return this.f485d.f2594j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // e.b.f.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (e()) {
            return this.f485d.f2593i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public final void h(int i2, int i3) {
        if (this.f490i != null && getLayout() != null) {
            if (c() || b()) {
                this.f493l = 0;
                int i4 = this.p;
                boolean z = true;
                if (i4 == 1 || i4 == 3) {
                    this.f492k = 0;
                } else {
                    int i5 = this.f491j;
                    if (i5 == 0) {
                        i5 = this.f490i.getIntrinsicWidth();
                    }
                    int textWidth = i2 - getTextWidth();
                    AtomicInteger atomicInteger = l.a;
                    int paddingEnd = ((((textWidth - getPaddingEnd()) - i5) - this.m) - getPaddingStart()) / 2;
                    boolean z2 = getLayoutDirection() == 1;
                    if (this.p != 4) {
                        z = false;
                    }
                    if (z2 != z) {
                        paddingEnd = -paddingEnd;
                    }
                    if (this.f492k != paddingEnd) {
                        this.f492k = paddingEnd;
                        g(false);
                        return;
                    }
                    return;
                }
            } else if (d()) {
                this.f492k = 0;
                if (this.p == 16) {
                    this.f493l = 0;
                } else {
                    int i6 = this.f491j;
                    if (i6 == 0) {
                        i6 = this.f490i.getIntrinsicHeight();
                    }
                    int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i6) - this.m) - getPaddingBottom()) / 2;
                    if (this.f493l != textHeight) {
                        this.f493l = textHeight;
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
            f.b.a.c.b.o.b.O1(this, this.f485d.b());
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
        f.b.a.d.g.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f485d) != null) {
            int i6 = i5 - i3;
            int i7 = i4 - i2;
            Drawable drawable = aVar.m;
            if (drawable != null) {
                drawable.setBounds(aVar.c, aVar.f2589e, i7 - aVar.f2588d, i6 - aVar.f2590f);
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
        setChecked(cVar.f494d);
    }

    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f494d = this.n;
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
            f.b.a.d.g.a aVar = this.f485d;
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
                Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
                f.b.a.d.g.a aVar = this.f485d;
                aVar.o = true;
                aVar.a.setSupportBackgroundTintList(aVar.f2594j);
                aVar.a.setSupportBackgroundTintMode(aVar.f2593i);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // e.b.f.f
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? e.b.b.a.a.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.f485d.q = z;
        }
    }

    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.n != z) {
            this.n = z;
            refreshDrawableState();
            if (!this.o) {
                this.o = true;
                Iterator<a> it = this.f486e.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.n);
                }
                this.o = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (e()) {
            f.b.a.d.g.a aVar = this.f485d;
            if (!aVar.p || aVar.f2591g != i2) {
                aVar.f2591g = i2;
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
            g b2 = this.f485d.b();
            g.b bVar = b2.b;
            if (bVar.o != f2) {
                bVar.o = f2;
                b2.y();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f490i != drawable) {
            this.f490i = drawable;
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
        setIcon(i2 != 0 ? e.b.b.a.a.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f491j != i2) {
            this.f491j = i2;
            g(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f489h != colorStateList) {
            this.f489h = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f488g != mode) {
            this.f488g = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(e.b.b.a.a.a(getContext(), i2));
    }

    public void setInsetBottom(int i2) {
        f.b.a.d.g.a aVar = this.f485d;
        aVar.f(aVar.f2589e, i2);
    }

    public void setInsetTop(int i2) {
        f.b.a.d.g.a aVar = this.f485d;
        aVar.f(i2, aVar.f2590f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f487f = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.f487f;
        if (bVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            f.b.a.d.g.a aVar = this.f485d;
            if (aVar.f2596l != colorStateList) {
                aVar.f2596l = colorStateList;
                if (aVar.a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) aVar.a.getBackground()).setColor(f.b.a.d.t.a.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i2) {
        if (e()) {
            setRippleColor(e.b.b.a.a.a(getContext(), i2));
        }
    }

    @Override // f.b.a.d.v.n
    public void setShapeAppearanceModel(j jVar) {
        if (e()) {
            this.f485d.e(jVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            f.b.a.d.g.a aVar = this.f485d;
            aVar.n = z;
            aVar.h();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            f.b.a.d.g.a aVar = this.f485d;
            if (aVar.f2595k != colorStateList) {
                aVar.f2595k = colorStateList;
                aVar.h();
            }
        }
    }

    public void setStrokeColorResource(int i2) {
        if (e()) {
            setStrokeColor(e.b.b.a.a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (e()) {
            f.b.a.d.g.a aVar = this.f485d;
            if (aVar.f2592h != i2) {
                aVar.f2592h = i2;
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
            f.b.a.d.g.a aVar = this.f485d;
            if (aVar.f2594j != colorStateList) {
                aVar.f2594j = colorStateList;
                if (aVar.b() != null) {
                    aVar.b().setTintList(aVar.f2594j);
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
            f.b.a.d.g.a aVar = this.f485d;
            if (aVar.f2593i != mode) {
                aVar.f2593i = mode;
                if (aVar.b() != null && aVar.f2593i != null) {
                    aVar.b().setTintMode(aVar.f2593i);
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
