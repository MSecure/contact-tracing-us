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
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
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
import e.i.i.c0.b;
import e.i.i.v;
import f.b.a.e.i.b;
import f.b.a.e.q.k;
import f.b.a.e.s.d;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import f.b.a.e.v.n;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Chip extends g implements b.a, n {
    public static final int w = R$style.Widget_MaterialComponents_Chip_Action;
    public static final Rect x = new Rect();
    public static final int[] y = {16842913};
    public static final int[] z = {16842911};

    /* renamed from: f  reason: collision with root package name */
    public f.b.a.e.i.b f548f;

    /* renamed from: g  reason: collision with root package name */
    public InsetDrawable f549g;

    /* renamed from: h  reason: collision with root package name */
    public RippleDrawable f550h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f551i;

    /* renamed from: j  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f552j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f553k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f554l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public final b r;
    public boolean s;
    public final Rect t = new Rect();
    public final RectF u = new RectF();
    public final d v = new a();

    public class a extends d {
        public a() {
        }

        @Override // f.b.a.e.s.d
        public void a(int i2) {
        }

        @Override // f.b.a.e.s.d
        public void b(Typeface typeface, boolean z) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            f.b.a.e.i.b bVar = chip.f548f;
            if (bVar.G0) {
                charSequence = bVar.H;
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
            int i2 = Chip.w;
            return (!chip.e() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 0 : 1;
        }

        @Override // e.k.b.a
        public void o(List<Integer> list) {
            boolean z = false;
            list.add(0);
            Chip chip = Chip.this;
            int i2 = Chip.w;
            if (chip.e()) {
                Chip chip2 = Chip.this;
                f.b.a.e.i.b bVar = chip2.f548f;
                if (bVar != null && bVar.N) {
                    z = true;
                }
                if (z && chip2.f551i != null) {
                    list.add(1);
                }
            }
        }

        @Override // e.k.b.a
        public boolean r(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.g();
            }
            return false;
        }

        @Override // e.k.b.a
        public void s(e.i.i.c0.b bVar) {
            bVar.a.setCheckable(Chip.this.f());
            bVar.a.setClickable(Chip.this.isClickable());
            bVar.a.setClassName(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.a.setText(text);
            } else {
                bVar.a.setContentDescription(text);
            }
        }

        @Override // e.k.b.a
        public void t(int i2, e.i.i.c0.b bVar) {
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
                bVar.a(b.a.f1539e);
                bVar.a.setEnabled(Chip.this.isEnabled());
                return;
            }
            bVar.a.setContentDescription(str);
            bVar.a.setBoundsInParent(Chip.x);
        }

        @Override // e.k.b.a
        public void u(int i2, boolean z) {
            if (i2 == 1) {
                Chip chip = Chip.this;
                chip.n = z;
                chip.refreshDrawableState();
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0335  */
    public Chip(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r8, r9), attributeSet, r8);
        int i2;
        int i3;
        boolean hasValue;
        TextUtils.TruncateAt truncateAt;
        int resourceId;
        int i4 = R$attr.chipStyle;
        int i5 = w;
        Context context2 = getContext();
        if (attributeSet != null) {
            attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background");
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
            } else {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
        }
        f.b.a.e.i.b bVar = new f.b.a.e.i.b(context2, attributeSet, i4, i5);
        Context context3 = bVar.h0;
        int[] iArr = R$styleable.Chip;
        TypedArray d2 = k.d(context3, attributeSet, iArr, i4, i5, new int[0]);
        int i6 = R$styleable.Chip_shapeAppearance;
        bVar.I0 = d2.hasValue(i6);
        ColorStateList x0 = f.b.a.c.b.o.b.x0(bVar.h0, d2, R$styleable.Chip_chipSurfaceColor);
        if (bVar.A != x0) {
            bVar.A = x0;
            bVar.onStateChange(bVar.getState());
        }
        bVar.Q(f.b.a.c.b.o.b.x0(bVar.h0, d2, R$styleable.Chip_chipBackgroundColor));
        bVar.X(d2.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        int i7 = R$styleable.Chip_chipCornerRadius;
        if (d2.hasValue(i7)) {
            bVar.R(d2.getDimension(i7, 0.0f));
        }
        bVar.Z(f.b.a.c.b.o.b.x0(bVar.h0, d2, R$styleable.Chip_chipStrokeColor));
        bVar.a0(d2.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        bVar.k0(f.b.a.c.b.o.b.x0(bVar.h0, d2, R$styleable.Chip_rippleColor));
        bVar.l0(d2.getText(R$styleable.Chip_android_text));
        Context context4 = bVar.h0;
        int i8 = R$styleable.Chip_android_textAppearance;
        f.b.a.e.s.b bVar2 = (!d2.hasValue(i8) || (resourceId = d2.getResourceId(i8, 0)) == 0) ? null : new f.b.a.e.s.b(context4, resourceId);
        bVar2.f3015k = d2.getDimension(R$styleable.Chip_android_textSize, bVar2.f3015k);
        bVar.m0(bVar2);
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
            bVar.T(f.b.a.c.b.o.b.D0(bVar.h0, d2, R$styleable.Chip_chipIcon));
            i2 = R$styleable.Chip_chipIconTint;
            if (d2.hasValue(i2)) {
                bVar.V(f.b.a.c.b.o.b.x0(bVar.h0, d2, i2));
            }
            bVar.U(d2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
            bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
                bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
            }
            bVar.b0(f.b.a.c.b.o.b.D0(bVar.h0, d2, R$styleable.Chip_closeIcon));
            bVar.g0(f.b.a.c.b.o.b.x0(bVar.h0, d2, R$styleable.Chip_closeIconTint));
            bVar.d0(d2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
            bVar.M(d2.getBoolean(R$styleable.Chip_android_checkable, false));
            bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
                bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
            }
            bVar.N(f.b.a.c.b.o.b.D0(bVar.h0, d2, R$styleable.Chip_checkedIcon));
            i3 = R$styleable.Chip_checkedIconTint;
            if (d2.hasValue(i3)) {
                bVar.O(f.b.a.c.b.o.b.x0(bVar.h0, d2, i3));
            }
            bVar.X = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_showMotionSpec);
            bVar.Y = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_hideMotionSpec);
            bVar.Y(d2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
            bVar.j0(d2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
            bVar.i0(d2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
            bVar.o0(d2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
            bVar.n0(d2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
            bVar.e0(d2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
            bVar.c0(d2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
            bVar.S(d2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
            bVar.H0 = d2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
            d2.recycle();
            k.a(context2, attributeSet, i4, i5);
            k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
            this.o = obtainStyledAttributes.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
            this.q = (int) Math.ceil((double) obtainStyledAttributes.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) TypedValue.applyDimension(1, (float) 48, getContext().getResources().getDisplayMetrics()))));
            obtainStyledAttributes.recycle();
            setChipDrawable(bVar);
            bVar.p(v.i.i(this));
            k.a(context2, attributeSet, i4, i5);
            k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
            TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
            if (Build.VERSION.SDK_INT < 23) {
                setTextColor(f.b.a.c.b.o.b.x0(context2, obtainStyledAttributes2, R$styleable.Chip_android_textColor));
            }
            hasValue = obtainStyledAttributes2.hasValue(i6);
            obtainStyledAttributes2.recycle();
            this.r = new b(this);
            i();
            if (!hasValue) {
                setOutlineProvider(new f.b.a.e.i.a(this));
            }
            setChecked(this.f553k);
            setText(bVar.H);
            setEllipsize(bVar.F0);
            l();
            if (!this.f548f.G0) {
                setLines(1);
                setHorizontallyScrolling(true);
            }
            setGravity(8388627);
            k();
            if (this.o) {
                setMinHeight(this.q);
            }
            this.p = v.e.d(this);
        } else {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        }
        bVar.F0 = truncateAt;
        bVar.W(d2.getBoolean(R$styleable.Chip_chipIconVisible, false));
        bVar.W(d2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        bVar.T(f.b.a.c.b.o.b.D0(bVar.h0, d2, R$styleable.Chip_chipIcon));
        i2 = R$styleable.Chip_chipIconTint;
        if (d2.hasValue(i2)) {
        }
        bVar.U(d2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconVisible, false));
        bVar.h0(d2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        bVar.b0(f.b.a.c.b.o.b.D0(bVar.h0, d2, R$styleable.Chip_closeIcon));
        bVar.g0(f.b.a.c.b.o.b.x0(bVar.h0, d2, R$styleable.Chip_closeIconTint));
        bVar.d0(d2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        bVar.M(d2.getBoolean(R$styleable.Chip_android_checkable, false));
        bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        bVar.P(d2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        bVar.N(f.b.a.c.b.o.b.D0(bVar.h0, d2, R$styleable.Chip_checkedIcon));
        i3 = R$styleable.Chip_checkedIconTint;
        if (d2.hasValue(i3)) {
        }
        bVar.X = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_showMotionSpec);
        bVar.Y = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_hideMotionSpec);
        bVar.Y(d2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        bVar.j0(d2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        bVar.i0(d2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        bVar.o0(d2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        bVar.n0(d2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        bVar.e0(d2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        bVar.c0(d2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        bVar.S(d2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        bVar.H0 = d2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
        d2.recycle();
        k.a(context2, attributeSet, i4, i5);
        k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
        this.o = obtainStyledAttributes3.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.q = (int) Math.ceil((double) obtainStyledAttributes3.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) TypedValue.applyDimension(1, (float) 48, getContext().getResources().getDisplayMetrics()))));
        obtainStyledAttributes3.recycle();
        setChipDrawable(bVar);
        bVar.p(v.i.i(this));
        k.a(context2, attributeSet, i4, i5);
        k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
        TypedArray obtainStyledAttributes22 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
        if (Build.VERSION.SDK_INT < 23) {
        }
        hasValue = obtainStyledAttributes22.hasValue(i6);
        obtainStyledAttributes22.recycle();
        this.r = new b(this);
        i();
        if (!hasValue) {
        }
        setChecked(this.f553k);
        setText(bVar.H);
        setEllipsize(bVar.F0);
        l();
        if (!this.f548f.G0) {
        }
        setGravity(8388627);
        k();
        if (this.o) {
        }
        this.p = v.e.d(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getCloseIconTouchBounds() {
        this.u.setEmpty();
        if (e() && this.f551i != null) {
            f.b.a.e.i.b bVar = this.f548f;
            bVar.D(bVar.getBounds(), this.u);
        }
        return this.u;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.t.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.t;
    }

    private f.b.a.e.s.b getTextAppearance() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.n0.f2970f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.m != z2) {
            this.m = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f554l != z2) {
            this.f554l = z2;
            refreshDrawableState();
        }
    }

    @Override // f.b.a.e.i.b.a
    public void a() {
        d(this.q);
        requestLayout();
        invalidateOutline();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (r0.right == r7) goto L_0x006b;
     */
    public boolean d(int i2) {
        this.q = i2;
        if (!this.o) {
            if (this.f549g != null) {
                h();
            } else {
                int[] iArr = f.b.a.e.t.b.a;
                j();
            }
            return false;
        }
        int max = Math.max(0, i2 - ((int) this.f548f.C));
        int max2 = Math.max(0, i2 - this.f548f.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i3 = max2 > 0 ? max2 / 2 : 0;
            int i4 = max > 0 ? max / 2 : 0;
            if (this.f549g != null) {
                Rect rect = new Rect();
                this.f549g.getPadding(rect);
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
            this.f549g = new InsetDrawable((Drawable) this.f548f, i3, i4, i3, i4);
            int[] iArr2 = f.b.a.e.t.b.a;
            j();
            return true;
        }
        if (this.f549g != null) {
            h();
        } else {
            int[] iArr3 = f.b.a.e.t.b.a;
            j();
        }
        return false;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z2;
        if (!this.s) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = e.k.b.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.r)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = e.k.b.a.class.getDeclaredMethod("x", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.r, Integer.MIN_VALUE);
                    z2 = true;
                    if (!z2 || this.r.m(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
                        return true;
                    }
                    return false;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        z2 = false;
        return !z2 ? true : true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.s) {
            return super.dispatchKeyEvent(keyEvent);
        }
        b bVar = this.r;
        Objects.requireNonNull(bVar);
        boolean z2 = false;
        int i2 = 0;
        z2 = false;
        z2 = false;
        z2 = false;
        z2 = false;
        z2 = false;
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
                                boolean z3 = false;
                                while (i2 < repeatCount && bVar.p(i3, null)) {
                                    i2++;
                                    z3 = true;
                                }
                                z2 = z3;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i4 = bVar.f1600l;
                    if (i4 != Integer.MIN_VALUE) {
                        bVar.r(i4, 16, null);
                    }
                    z2 = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z2 = bVar.p(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z2 = bVar.p(1, null);
            }
        }
        if (!z2 || this.r.f1600l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // e.b.f.g
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f.b.a.e.i.b bVar = this.f548f;
        boolean z2 = false;
        int i2 = 0;
        z2 = false;
        if (bVar != null && f.b.a.e.i.b.J(bVar.O)) {
            f.b.a.e.i.b bVar2 = this.f548f;
            ?? isEnabled = isEnabled();
            int i3 = isEnabled;
            if (this.n) {
                i3 = isEnabled + 1;
            }
            int i4 = i3;
            if (this.m) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (this.f554l) {
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
            if (this.n) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.m) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.f554l) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            z2 = bVar2.f0(iArr);
        }
        if (z2) {
            invalidate();
        }
    }

    public final boolean e() {
        f.b.a.e.i.b bVar = this.f548f;
        return (bVar == null || bVar.G() == null) ? false : true;
    }

    public boolean f() {
        f.b.a.e.i.b bVar = this.f548f;
        return bVar != null && bVar.T;
    }

    public boolean g() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f551i;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        if (this.s) {
            this.r.w(1, 1);
        }
        return z2;
    }

    public CharSequence getAccessibilityClassName() {
        if (!f()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return (!(parent instanceof ChipGroup) || !((ChipGroup) parent).f557h) ? "android.widget.CompoundButton" : "android.widget.RadioButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f549g;
        return insetDrawable == null ? this.f548f : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.V;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.W;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.B;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return Math.max(0.0f, bVar.F());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f548f;
    }

    public float getChipEndPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.g0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar == null || (drawable = bVar.J) == null) {
            return null;
        }
        return m.e.L1(drawable);
    }

    public float getChipIconSize() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.L;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.K;
        }
        return null;
    }

    public float getChipMinHeight() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.C;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.Z;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.E;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.F;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.G();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.S;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.f0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.R;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.e0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.Q;
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.F0;
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        if (this.s) {
            b bVar = this.r;
            if (bVar.f1600l == 1 || bVar.f1599k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public f.b.a.e.a.g getHideMotionSpec() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.Y;
        }
        return null;
    }

    public float getIconEndPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.b0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.a0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.G;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        return this.f548f.b.a;
    }

    public f.b.a.e.a.g getShowMotionSpec() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.X;
        }
        return null;
    }

    public float getTextEndPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.d0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            return bVar.c0;
        }
        return 0.0f;
    }

    public final void h() {
        if (this.f549g != null) {
            this.f549g = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            int[] iArr = f.b.a.e.t.b.a;
            j();
        }
    }

    public final void i() {
        if (e()) {
            f.b.a.e.i.b bVar = this.f548f;
            if ((bVar != null && bVar.N) && this.f551i != null) {
                v.u(this, this.r);
                this.s = true;
                return;
            }
        }
        v.u(this, null);
        this.s = false;
    }

    public final void j() {
        this.f550h = new RippleDrawable(f.b.a.e.t.b.a(this.f548f.G), getBackgroundDrawable(), null);
        this.f548f.p0(false);
        RippleDrawable rippleDrawable = this.f550h;
        AtomicInteger atomicInteger = v.a;
        v.d.q(this, rippleDrawable);
        k();
    }

    public final void k() {
        f.b.a.e.i.b bVar;
        if (!TextUtils.isEmpty(getText()) && (bVar = this.f548f) != null) {
            int E = (int) (bVar.E() + bVar.g0 + bVar.d0);
            f.b.a.e.i.b bVar2 = this.f548f;
            int B = (int) (bVar2.B() + bVar2.Z + bVar2.c0);
            if (this.f549g != null) {
                Rect rect = new Rect();
                this.f549g.getPadding(rect);
                B += rect.left;
                E += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            AtomicInteger atomicInteger = v.a;
            v.e.k(this, B, paddingTop, E, paddingBottom);
        }
    }

    public final void l() {
        TextPaint paint = getPaint();
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            paint.drawableState = bVar.getState();
        }
        f.b.a.e.s.b textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.v);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.b.a.c.b.o.b.p1(this, this.f548f);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, y);
        }
        if (f()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, z);
        }
        return onCreateDrawableState;
    }

    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.s) {
            b bVar = this.r;
            int i3 = bVar.f1600l;
            if (i3 != Integer.MIN_VALUE) {
                bVar.k(i3);
            }
            if (z2) {
                bVar.p(i2, rect);
            }
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                z2 = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        z2 = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(z2);
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f2956d) {
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
        if (this.p != i2) {
            this.p = i2;
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f554l) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                    }
                }
                z2 = false;
                return !z2 || super.onTouchEvent(motionEvent);
            } else if (this.f554l) {
                g();
                z2 = true;
                setCloseIconPressed(false);
                if (!z2) {
                }
            }
            z2 = false;
            setCloseIconPressed(false);
            if (!z2) {
            }
        }
        if (contains) {
            setCloseIconPressed(true);
        }
        z2 = false;
        if (!z2) {
        }
        z2 = true;
        if (!z2) {
        }
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f550h) {
            super.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i2) {
    }

    @Override // e.b.f.g
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f550h) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // e.b.f.g
    public void setBackgroundResource(int i2) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.M(z2);
        }
    }

    public void setCheckableResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.M(bVar.h0.getResources().getBoolean(i2));
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar == null) {
            this.f553k = z2;
        } else if (bVar.T) {
            boolean isChecked = isChecked();
            super.setChecked(z2);
            if (isChecked != z2 && (onCheckedChangeListener = this.f552j) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z2);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.N(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.N(m.e.h0(bVar.h0, i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.O(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.O(m.e.f0(bVar.h0, i2));
        }
    }

    public void setCheckedIconVisible(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.P(bVar.h0.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIconVisible(boolean z2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.P(z2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null && bVar.B != colorStateList) {
            bVar.B = colorStateList;
            bVar.onStateChange(bVar.getState());
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.Q(m.e.f0(bVar.h0, i2));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.R(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.R(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(f.b.a.e.i.b bVar) {
        f.b.a.e.i.b bVar2 = this.f548f;
        if (bVar2 != bVar) {
            if (bVar2 != null) {
                bVar2.E0 = new WeakReference<>(null);
            }
            this.f548f = bVar;
            bVar.G0 = false;
            Objects.requireNonNull(bVar);
            bVar.E0 = new WeakReference<>(this);
            d(this.q);
        }
    }

    public void setChipEndPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null && bVar.g0 != f2) {
            bVar.g0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.S(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipIcon(Drawable drawable) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.T(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.T(m.e.h0(bVar.h0, i2));
        }
    }

    public void setChipIconSize(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.U(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.U(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.V(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.V(m.e.f0(bVar.h0, i2));
        }
    }

    public void setChipIconVisible(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.W(bVar.h0.getResources().getBoolean(i2));
        }
    }

    public void setChipIconVisible(boolean z2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.W(z2);
        }
    }

    public void setChipMinHeight(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null && bVar.C != f2) {
            bVar.C = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipMinHeightResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.X(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null && bVar.Z != f2) {
            bVar.Z = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.Y(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.Z(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.Z(m.e.f0(bVar.h0, i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.a0(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.a0(bVar.h0.getResources().getDimension(i2));
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
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.b0(drawable);
        }
        i();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null && bVar.S != charSequence) {
            e.i.g.a c = e.i.g.a.c();
            bVar.S = c.d(charSequence, c.c, true);
            bVar.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.c0(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.c0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.b0(m.e.h0(bVar.h0, i2));
        }
        i();
    }

    public void setCloseIconSize(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.d0(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.d0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.e0(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.e0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.g0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.g0(m.e.f0(bVar.h0, i2));
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCloseIconVisible(boolean z2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.h0(z2);
        }
        i();
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
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            g.b bVar2 = bVar.b;
            if (bVar2.o != f2) {
                bVar2.o = f2;
                bVar.y();
            }
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f548f != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                f.b.a.e.i.b bVar = this.f548f;
                if (bVar != null) {
                    bVar.F0 = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.o = z2;
        d(this.q);
    }

    public void setGravity(int i2) {
        if (i2 == 8388627) {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(f.b.a.e.a.g gVar) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.Y = gVar;
        }
    }

    public void setHideMotionSpecResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.Y = f.b.a.e.a.g.b(bVar.h0, i2);
        }
    }

    public void setIconEndPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.i0(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.i0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.j0(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.j0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setLayoutDirection(int i2) {
        if (this.f548f != null) {
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
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.H0 = i2;
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
        this.f552j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f551i = onClickListener;
        i();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.k0(colorStateList);
        }
        if (!this.f548f.C0) {
            j();
        }
    }

    public void setRippleColorResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.k0(m.e.f0(bVar.h0, i2));
            if (!this.f548f.C0) {
                j();
            }
        }
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        f.b.a.e.i.b bVar = this.f548f;
        bVar.b.a = jVar;
        bVar.invalidateSelf();
    }

    public void setShowMotionSpec(f.b.a.e.a.g gVar) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.X = gVar;
        }
    }

    public void setShowMotionSpecResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.X = f.b.a.e.a.g.b(bVar.h0, i2);
        }
    }

    public void setSingleLine(boolean z2) {
        if (z2) {
            super.setSingleLine(z2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(bVar.G0 ? null : charSequence, bufferType);
            f.b.a.e.i.b bVar2 = this.f548f;
            if (bVar2 != null) {
                bVar2.l0(charSequence);
            }
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.m0(new f.b.a.e.s.b(bVar.h0, i2));
        }
        l();
    }

    public void setTextAppearance(f.b.a.e.s.b bVar) {
        f.b.a.e.i.b bVar2 = this.f548f;
        if (bVar2 != null) {
            bVar2.m0(bVar);
        }
        l();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null && bVar.d0 != f2) {
            bVar.d0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setTextEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.n0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null && bVar.c0 != f2) {
            bVar.c0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setTextStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.o0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        f.b.a.e.i.b bVar = this.f548f;
        if (bVar != null) {
            bVar.m0(new f.b.a.e.s.b(bVar.h0, i2));
        }
        l();
    }
}
