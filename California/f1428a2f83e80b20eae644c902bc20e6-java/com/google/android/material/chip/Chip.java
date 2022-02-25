package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.a.m;
import e.b.f.g;
import e.i.i.l;
import e.i.i.w.b;
import f.b.a.d.j.b;
import f.b.a.d.q.k;
import f.b.a.d.s.d;
import f.b.a.d.v.g;
import f.b.a.d.v.j;
import f.b.a.d.v.n;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Chip extends g implements b.a, n {
    public static final int u = R$style.Widget_MaterialComponents_Chip_Action;
    public static final Rect v = new Rect();
    public static final int[] w = {16842913};
    public static final int[] x = {16842911};

    /* renamed from: e  reason: collision with root package name */
    public f.b.a.d.j.b f509e;

    /* renamed from: f  reason: collision with root package name */
    public InsetDrawable f510f;

    /* renamed from: g  reason: collision with root package name */
    public RippleDrawable f511g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f512h;

    /* renamed from: i  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f513i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f514j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f515k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f516l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public final b q;
    public final Rect r = new Rect();
    public final RectF s = new RectF();
    public final d t = new a();

    public class a extends d {
        public a() {
        }

        @Override // f.b.a.d.s.d
        public void a(int i2) {
        }

        @Override // f.b.a.d.s.d
        public void b(Typeface typeface, boolean z) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            f.b.a.d.j.b bVar = chip.f509e;
            if (bVar.F0) {
                charSequence = bVar.G;
            } else {
                charSequence = chip.getText();
            }
            chip.setText(charSequence);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends e.k.b.a {
        public b(Chip chip) {
            super(chip);
        }

        @Override // e.k.b.a
        public int n(float f2, float f3) {
            Chip chip = Chip.this;
            int i2 = Chip.u;
            return (!chip.e() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 0 : 1;
        }

        @Override // e.k.b.a
        public void o(List<Integer> list) {
            boolean z = false;
            list.add(0);
            Chip chip = Chip.this;
            int i2 = Chip.u;
            if (chip.e()) {
                Chip chip2 = Chip.this;
                f.b.a.d.j.b bVar = chip2.f509e;
                if (bVar != null && bVar.M) {
                    z = true;
                }
                if (z && chip2.f512h != null) {
                    list.add(1);
                }
            }
        }

        @Override // e.k.b.a
        public boolean r(int i2, int i3, Bundle bundle) {
            boolean z = false;
            if (i3 == 16) {
                if (i2 == 0) {
                    return Chip.this.performClick();
                }
                if (i2 == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.f512h;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.q.w(1, 1);
                }
            }
            return z;
        }

        @Override // e.k.b.a
        public void s(e.i.i.w.b bVar) {
            bVar.a.setCheckable(Chip.this.f());
            bVar.a.setClickable(Chip.this.isClickable());
            if (Chip.this.f() || Chip.this.isClickable()) {
                bVar.a.setClassName(Chip.this.f() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                bVar.a.setClassName("android.view.View");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.a.setText(text);
            } else {
                bVar.a.setContentDescription(text);
            }
        }

        @Override // e.k.b.a
        public void t(int i2, e.i.i.w.b bVar) {
            String str = "";
            if (i2 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription == null) {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    objArr[0] = str;
                    closeIconContentDescription = context.getString(i3, objArr).trim();
                }
                bVar.a.setContentDescription(closeIconContentDescription);
                bVar.a.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                bVar.a(b.a.f1485e);
                bVar.a.setEnabled(Chip.this.isEnabled());
                return;
            }
            bVar.a.setContentDescription(str);
            bVar.a.setBoundsInParent(Chip.v);
        }

        @Override // e.k.b.a
        public void u(int i2, boolean z) {
            if (i2 == 1) {
                Chip chip = Chip.this;
                chip.m = z;
                chip.refreshDrawableState();
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0342  */
    public Chip(Context context, AttributeSet attributeSet) {
        super(f.b.a.d.a0.a.a.a(context, attributeSet, r8, r9), attributeSet, r8);
        int i2;
        int i3;
        boolean hasValue;
        TextUtils.TruncateAt truncateAt;
        int resourceId;
        int i4 = R$attr.chipStyle;
        int i5 = u;
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        f.b.a.d.j.b bVar = new f.b.a.d.j.b(context2, attributeSet, i4, i5);
        Context context3 = bVar.g0;
        int[] iArr = R$styleable.Chip;
        TypedArray d2 = k.d(context3, attributeSet, iArr, i4, i5, new int[0]);
        int i6 = R$styleable.Chip_shapeAppearance;
        bVar.H0 = d2.hasValue(i6);
        ColorStateList L0 = f.b.a.c.b.o.b.L0(bVar.g0, d2, R$styleable.Chip_chipSurfaceColor);
        if (bVar.z != L0) {
            bVar.z = L0;
            bVar.onStateChange(bVar.getState());
        }
        bVar.Q(f.b.a.c.b.o.b.L0(bVar.g0, d2, R$styleable.Chip_chipBackgroundColor));
        bVar.X(d2.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        int i7 = R$styleable.Chip_chipCornerRadius;
        if (d2.hasValue(i7)) {
            bVar.R(d2.getDimension(i7, 0.0f));
        }
        bVar.Z(f.b.a.c.b.o.b.L0(bVar.g0, d2, R$styleable.Chip_chipStrokeColor));
        bVar.a0(d2.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        bVar.k0(f.b.a.c.b.o.b.L0(bVar.g0, d2, R$styleable.Chip_rippleColor));
        bVar.l0(d2.getText(R$styleable.Chip_android_text));
        Context context4 = bVar.g0;
        int i8 = R$styleable.Chip_android_textAppearance;
        f.b.a.d.s.b bVar2 = (!d2.hasValue(i8) || (resourceId = d2.getResourceId(i8, 0)) == 0) ? null : new f.b.a.d.s.b(context4, resourceId);
        bVar2.f2742k = d2.getDimension(R$styleable.Chip_android_textSize, bVar2.f2742k);
        bVar.m0.b(bVar2, bVar.g0);
        int i9 = d2.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i9 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else if (i9 != 2) {
            if (i9 == 3) {
                truncateAt = TextUtils.TruncateAt.END;
            }
            bVar.W(d2.getBoolean(R$styleable.Chip_chipIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
                bVar.W(d2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
            }
            bVar.T(f.b.a.c.b.o.b.O0(bVar.g0, d2, R$styleable.Chip_chipIcon));
            i2 = R$styleable.Chip_chipIconTint;
            if (d2.hasValue(i2)) {
                bVar.V(f.b.a.c.b.o.b.L0(bVar.g0, d2, i2));
            }
            bVar.U(d2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
            bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
                bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
            }
            bVar.b0(f.b.a.c.b.o.b.O0(bVar.g0, d2, R$styleable.Chip_closeIcon));
            bVar.g0(f.b.a.c.b.o.b.L0(bVar.g0, d2, R$styleable.Chip_closeIconTint));
            bVar.d0(d2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
            bVar.M(d2.getBoolean(R$styleable.Chip_android_checkable, false));
            bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
                bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
            }
            bVar.N(f.b.a.c.b.o.b.O0(bVar.g0, d2, R$styleable.Chip_checkedIcon));
            i3 = R$styleable.Chip_checkedIconTint;
            if (d2.hasValue(i3)) {
                bVar.O(f.b.a.c.b.o.b.L0(bVar.g0, d2, i3));
            }
            bVar.W = f.b.a.d.a.g.a(bVar.g0, d2, R$styleable.Chip_showMotionSpec);
            bVar.X = f.b.a.d.a.g.a(bVar.g0, d2, R$styleable.Chip_hideMotionSpec);
            bVar.Y(d2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
            bVar.j0(d2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
            bVar.i0(d2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
            bVar.n0(d2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
            bVar.m0(d2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
            bVar.e0(d2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
            bVar.c0(d2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
            bVar.S(d2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
            bVar.G0 = d2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
            d2.recycle();
            k.a(context2, attributeSet, i4, i5);
            k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
            this.n = obtainStyledAttributes.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
            this.p = (int) Math.ceil((double) obtainStyledAttributes.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) f.b.a.c.b.o.b.r0(getContext(), 48))));
            obtainStyledAttributes.recycle();
            setChipDrawable(bVar);
            bVar.p(getElevation());
            k.a(context2, attributeSet, i4, i5);
            k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
            TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
            if (Build.VERSION.SDK_INT < 23) {
                setTextColor(f.b.a.c.b.o.b.L0(context2, obtainStyledAttributes2, R$styleable.Chip_android_textColor));
            }
            hasValue = obtainStyledAttributes2.hasValue(i6);
            obtainStyledAttributes2.recycle();
            this.q = new b(this);
            h();
            if (!hasValue) {
                setOutlineProvider(new f.b.a.d.j.a(this));
            }
            setChecked(this.f514j);
            setText(bVar.G);
            setEllipsize(bVar.E0);
            k();
            if (!this.f509e.F0) {
                setLines(1);
                setHorizontallyScrolling(true);
            }
            setGravity(8388627);
            j();
            if (this.n) {
                setMinHeight(this.p);
            }
            this.o = getLayoutDirection();
        } else {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        }
        bVar.E0 = truncateAt;
        bVar.W(d2.getBoolean(R$styleable.Chip_chipIconVisible, false));
        bVar.W(d2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        bVar.T(f.b.a.c.b.o.b.O0(bVar.g0, d2, R$styleable.Chip_chipIcon));
        i2 = R$styleable.Chip_chipIconTint;
        if (d2.hasValue(i2)) {
        }
        bVar.U(d2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconVisible, false));
        bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        bVar.b0(f.b.a.c.b.o.b.O0(bVar.g0, d2, R$styleable.Chip_closeIcon));
        bVar.g0(f.b.a.c.b.o.b.L0(bVar.g0, d2, R$styleable.Chip_closeIconTint));
        bVar.d0(d2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        bVar.M(d2.getBoolean(R$styleable.Chip_android_checkable, false));
        bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        bVar.N(f.b.a.c.b.o.b.O0(bVar.g0, d2, R$styleable.Chip_checkedIcon));
        i3 = R$styleable.Chip_checkedIconTint;
        if (d2.hasValue(i3)) {
        }
        bVar.W = f.b.a.d.a.g.a(bVar.g0, d2, R$styleable.Chip_showMotionSpec);
        bVar.X = f.b.a.d.a.g.a(bVar.g0, d2, R$styleable.Chip_hideMotionSpec);
        bVar.Y(d2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        bVar.j0(d2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        bVar.i0(d2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        bVar.n0(d2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        bVar.m0(d2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        bVar.e0(d2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        bVar.c0(d2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        bVar.S(d2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        bVar.G0 = d2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
        d2.recycle();
        k.a(context2, attributeSet, i4, i5);
        k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
        this.n = obtainStyledAttributes3.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.p = (int) Math.ceil((double) obtainStyledAttributes3.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) f.b.a.c.b.o.b.r0(getContext(), 48))));
        obtainStyledAttributes3.recycle();
        setChipDrawable(bVar);
        bVar.p(getElevation());
        k.a(context2, attributeSet, i4, i5);
        k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
        TypedArray obtainStyledAttributes22 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
        if (Build.VERSION.SDK_INT < 23) {
        }
        hasValue = obtainStyledAttributes22.hasValue(i6);
        obtainStyledAttributes22.recycle();
        this.q = new b(this);
        h();
        if (!hasValue) {
        }
        setChecked(this.f514j);
        setText(bVar.G);
        setEllipsize(bVar.E0);
        k();
        if (!this.f509e.F0) {
        }
        setGravity(8388627);
        j();
        if (this.n) {
        }
        this.o = getLayoutDirection();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getCloseIconTouchBounds() {
        this.s.setEmpty();
        if (e()) {
            f.b.a.d.j.b bVar = this.f509e;
            bVar.D(bVar.getBounds(), this.s);
        }
        return this.s;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.r;
    }

    private f.b.a.d.s.b getTextAppearance() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.m0.f2693f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.f516l != z) {
            this.f516l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.f515k != z) {
            this.f515k = z;
            refreshDrawableState();
        }
    }

    @Override // f.b.a.d.j.b.a
    public void a() {
        d(this.p);
        requestLayout();
        invalidateOutline();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (r0.right == r7) goto L_0x006b;
     */
    public boolean d(int i2) {
        this.p = i2;
        if (!this.n) {
            if (this.f510f != null) {
                g();
            } else {
                int[] iArr = f.b.a.d.t.a.a;
                i();
            }
            return false;
        }
        int max = Math.max(0, i2 - ((int) this.f509e.B));
        int max2 = Math.max(0, i2 - this.f509e.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i3 = max2 > 0 ? max2 / 2 : 0;
            int i4 = max > 0 ? max / 2 : 0;
            if (this.f510f != null) {
                Rect rect = new Rect();
                this.f510f.getPadding(rect);
                if (rect.top == i4) {
                    if (rect.bottom == i4) {
                        if (rect.left == i3) {
                        }
                    }
                }
            }
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
            this.f510f = new InsetDrawable((Drawable) this.f509e, i3, i4, i3, i4);
            int[] iArr2 = f.b.a.d.t.a.a;
            i();
            return true;
        }
        if (this.f510f != null) {
            g();
        } else {
            int[] iArr3 = f.b.a.d.t.a.a;
            i();
        }
        return false;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = e.k.b.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = e.k.b.a.class.getDeclaredMethod("x", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.q, Integer.MIN_VALUE);
                    z = true;
                    if (!z || this.q.m(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
                        return true;
                    }
                    return false;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            }
        }
        z = false;
        return !z ? true : true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        b bVar = this.q;
        Objects.requireNonNull(bVar);
        boolean z = false;
        int i2 = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i3 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i3 = 33;
                                } else if (keyCode == 21) {
                                    i3 = 17;
                                } else if (keyCode != 22) {
                                    i3 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z2 = false;
                                while (i2 < repeatCount && bVar.p(i3, null)) {
                                    i2++;
                                    z2 = true;
                                }
                                z = z2;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i4 = bVar.f1531l;
                    if (i4 != Integer.MIN_VALUE) {
                        bVar.r(i4, 16, null);
                    }
                    z = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z = bVar.p(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z = bVar.p(1, null);
            }
        }
        if (!z || this.q.f1531l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // e.b.f.g
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f.b.a.d.j.b bVar = this.f509e;
        boolean z = false;
        int i2 = 0;
        z = false;
        if (bVar != null && f.b.a.d.j.b.J(bVar.N)) {
            f.b.a.d.j.b bVar2 = this.f509e;
            ?? isEnabled = isEnabled();
            int i3 = isEnabled;
            if (this.m) {
                i3 = isEnabled + 1;
            }
            int i4 = i3;
            if (this.f516l) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (this.f515k) {
                i5 = i4 + 1;
            }
            int i6 = i5;
            if (isChecked()) {
                i6 = i5 + 1;
            }
            int[] iArr = new int[i6];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            }
            if (this.m) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.f516l) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.f515k) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            z = bVar2.f0(iArr);
        }
        if (z) {
            invalidate();
        }
    }

    public final boolean e() {
        f.b.a.d.j.b bVar = this.f509e;
        return (bVar == null || bVar.G() == null) ? false : true;
    }

    public boolean f() {
        f.b.a.d.j.b bVar = this.f509e;
        return bVar != null && bVar.S;
    }

    public final void g() {
        if (this.f510f != null) {
            this.f510f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            int[] iArr = f.b.a.d.t.a.a;
            i();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f510f;
        return insetDrawable == null ? this.f509e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.U;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.V;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.A;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return Math.max(0.0f, bVar.F());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f509e;
    }

    public float getChipEndPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.f0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar == null || (drawable = bVar.I) == null) {
            return null;
        }
        return m.h.s1(drawable);
    }

    public float getChipIconSize() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.K;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.J;
        }
        return null;
    }

    public float getChipMinHeight() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.B;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.Y;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.D;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.E;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.G();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.R;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.e0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.Q;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.d0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.P;
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.E0;
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        b bVar = this.q;
        if (bVar.f1531l == 1 || bVar.f1530k == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public f.b.a.d.a.g getHideMotionSpec() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.X;
        }
        return null;
    }

    public float getIconEndPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.a0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.Z;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.F;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        return this.f509e.b.a;
    }

    public f.b.a.d.a.g getShowMotionSpec() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.W;
        }
        return null;
    }

    public float getTextEndPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.c0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            return bVar.b0;
        }
        return 0.0f;
    }

    public final void h() {
        b bVar;
        if (e()) {
            f.b.a.d.j.b bVar2 = this.f509e;
            if ((bVar2 != null && bVar2.M) && this.f512h != null) {
                bVar = this.q;
                l.r(this, bVar);
            }
        }
        bVar = null;
        l.r(this, bVar);
    }

    public final void i() {
        this.f511g = new RippleDrawable(f.b.a.d.t.a.b(this.f509e.F), getBackgroundDrawable(), null);
        this.f509e.o0(false);
        RippleDrawable rippleDrawable = this.f511g;
        AtomicInteger atomicInteger = l.a;
        setBackground(rippleDrawable);
        j();
    }

    public final void j() {
        f.b.a.d.j.b bVar;
        if (!TextUtils.isEmpty(getText()) && (bVar = this.f509e) != null) {
            int E = (int) (bVar.E() + bVar.f0 + bVar.c0);
            f.b.a.d.j.b bVar2 = this.f509e;
            int B = (int) (bVar2.B() + bVar2.Y + bVar2.b0);
            if (this.f510f != null) {
                Rect rect = new Rect();
                this.f510f.getPadding(rect);
                B += rect.left;
                E += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            AtomicInteger atomicInteger = l.a;
            setPaddingRelative(B, paddingTop, E, paddingBottom);
        }
    }

    public final void k() {
        TextPaint paint = getPaint();
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            paint.drawableState = bVar.getState();
        }
        f.b.a.d.s.b textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.c(getContext(), paint, this.t);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.b.a.c.b.o.b.O1(this, this.f509e);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, w);
        }
        if (f()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, x);
        }
        return onCreateDrawableState;
    }

    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        b bVar = this.q;
        int i3 = bVar.f1531l;
        if (i3 != Integer.MIN_VALUE) {
            bVar.k(i3);
        }
        if (z) {
            bVar.p(i2, rect);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                z = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        z = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(z);
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((f() || isClickable()) ? f() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f2679d) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= chipGroup.getChildCount()) {
                        i4 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i3) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i3)) == this) {
                            break;
                        }
                        i4++;
                    }
                    i3++;
                }
                i2 = i4;
            } else {
                i2 = -1;
            }
            Object tag = getTag(R$id.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) b.c.a(!(tag instanceof Integer) ? -1 : ((Integer) tag).intValue(), 1, i2, 1, false, isChecked()).a);
        }
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.o != i2) {
            this.o = i2;
            j();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f515k) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                    }
                }
                z = false;
                if (!z || super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } else if (this.f515k) {
                playSoundEffect(0);
                View.OnClickListener onClickListener = this.f512h;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                this.q.w(1, 1);
                z = true;
                setCloseIconPressed(false);
                if (!z) {
                }
                return true;
            }
            z = false;
            setCloseIconPressed(false);
            if (!z) {
            }
            return true;
        }
        if (contains) {
            setCloseIconPressed(true);
        }
        z = false;
        if (!z) {
        }
        return true;
        z = true;
        if (!z) {
        }
        return true;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f511g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // e.b.f.g
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f511g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // e.b.f.g
    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.M(z);
        }
    }

    public void setCheckableResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.M(bVar.g0.getResources().getBoolean(i2));
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar == null) {
            this.f514j = z;
        } else if (bVar.S) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.f513i) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.N(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.N(e.b.b.a.a.b(bVar.g0, i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.O(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.O(e.b.b.a.a.a(bVar.g0, i2));
        }
    }

    public void setCheckedIconVisible(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.P(bVar.g0.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.P(z);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null && bVar.A != colorStateList) {
            bVar.A = colorStateList;
            bVar.onStateChange(bVar.getState());
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.Q(e.b.b.a.a.a(bVar.g0, i2));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.R(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.R(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(f.b.a.d.j.b bVar) {
        f.b.a.d.j.b bVar2 = this.f509e;
        if (bVar2 != bVar) {
            if (bVar2 != null) {
                bVar2.D0 = new WeakReference<>(null);
            }
            this.f509e = bVar;
            bVar.F0 = false;
            Objects.requireNonNull(bVar);
            bVar.D0 = new WeakReference<>(this);
            d(this.p);
        }
    }

    public void setChipEndPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null && bVar.f0 != f2) {
            bVar.f0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipEndPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.S(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipIcon(Drawable drawable) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.T(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.T(e.b.b.a.a.b(bVar.g0, i2));
        }
    }

    public void setChipIconSize(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.U(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.U(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.V(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.V(e.b.b.a.a.a(bVar.g0, i2));
        }
    }

    public void setChipIconVisible(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.W(bVar.g0.getResources().getBoolean(i2));
        }
    }

    public void setChipIconVisible(boolean z) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.W(z);
        }
    }

    public void setChipMinHeight(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null && bVar.B != f2) {
            bVar.B = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipMinHeightResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.X(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null && bVar.Y != f2) {
            bVar.Y = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipStartPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.Y(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.Z(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.Z(e.b.b.a.a.a(bVar.g0, i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.a0(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.a0(bVar.g0.getResources().getDimension(i2));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.b0(drawable);
        }
        h();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null && bVar.R != charSequence) {
            e.i.g.a c = e.i.g.a.c();
            bVar.R = c.d(charSequence, c.c, true);
            bVar.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.c0(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.c0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.b0(e.b.b.a.a.b(bVar.g0, i2));
        }
        h();
    }

    public void setCloseIconSize(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.d0(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.d0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.e0(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.e0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.g0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.g0(e.b.b.a.a.a(bVar.g0, i2));
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCloseIconVisible(boolean z) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.h0(z);
        }
        h();
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            g.b bVar2 = bVar.b;
            if (bVar2.o != f2) {
                bVar2.o = f2;
                bVar.y();
            }
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f509e != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                f.b.a.d.j.b bVar = this.f509e;
                if (bVar != null) {
                    bVar.E0 = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.n = z;
        d(this.p);
    }

    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(f.b.a.d.a.g gVar) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.X = gVar;
        }
    }

    public void setHideMotionSpecResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.X = f.b.a.d.a.g.b(bVar.g0, i2);
        }
    }

    public void setIconEndPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.i0(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.i0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.j0(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.j0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setLayoutDirection(int i2) {
        if (this.f509e != null) {
            super.setLayoutDirection(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.G0 = i2;
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f513i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f512h = onClickListener;
        h();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.k0(colorStateList);
        }
        if (!this.f509e.B0) {
            i();
        }
    }

    public void setRippleColorResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.k0(e.b.b.a.a.a(bVar.g0, i2));
            if (!this.f509e.B0) {
                i();
            }
        }
    }

    @Override // f.b.a.d.v.n
    public void setShapeAppearanceModel(j jVar) {
        f.b.a.d.j.b bVar = this.f509e;
        bVar.b.a = jVar;
        bVar.invalidateSelf();
    }

    public void setShowMotionSpec(f.b.a.d.a.g gVar) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.W = gVar;
        }
    }

    public void setShowMotionSpecResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.W = f.b.a.d.a.g.b(bVar.g0, i2);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(bVar.F0 ? null : charSequence, bufferType);
            f.b.a.d.j.b bVar2 = this.f509e;
            if (bVar2 != null) {
                bVar2.l0(charSequence);
            }
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.m0.b(new f.b.a.d.s.b(bVar.g0, i2), bVar.g0);
        }
        k();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null && bVar.c0 != f2) {
            bVar.c0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setTextEndPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.m0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null && bVar.b0 != f2) {
            bVar.b0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setTextStartPaddingResource(int i2) {
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.n0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        f.b.a.d.j.b bVar = this.f509e;
        if (bVar != null) {
            bVar.m0.b(new f.b.a.d.s.b(bVar.g0, i2), bVar.g0);
        }
        k();
    }

    public void setTextAppearance(f.b.a.d.s.b bVar) {
        f.b.a.d.j.b bVar2 = this.f509e;
        if (bVar2 != null) {
            bVar2.m0.b(bVar, bVar2.g0);
        }
        k();
    }
}
