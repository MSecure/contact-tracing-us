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
import e.j.j.c0.b;
import e.j.j.v;
import f.b.a.e.i.b;
import f.b.a.e.q.k;
import f.b.a.e.s.d;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import f.b.a.e.v.n;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class Chip extends g implements b.a, n {
    public static final int w = R$style.Widget_MaterialComponents_Chip_Action;
    public static final Rect x = new Rect();
    public static final int[] y = {16842913};
    public static final int[] z = {16842911};

    /* renamed from: f */
    public f.b.a.e.i.b f560f;

    /* renamed from: g */
    public InsetDrawable f561g;

    /* renamed from: h */
    public RippleDrawable f562h;

    /* renamed from: i */
    public View.OnClickListener f563i;

    /* renamed from: j */
    public CompoundButton.OnCheckedChangeListener f564j;

    /* renamed from: k */
    public boolean f565k;

    /* renamed from: l */
    public boolean f566l;
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

    /* loaded from: classes.dex */
    public class a extends d {
        public a() {
            Chip.this = r1;
        }

        @Override // f.b.a.e.s.d
        public void a(int i2) {
        }

        @Override // f.b.a.e.s.d
        public void b(Typeface typeface, boolean z) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            f.b.a.e.i.b bVar = chip.f560f;
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

    /* loaded from: classes.dex */
    public class b extends e.l.b.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Chip chip) {
            super(chip);
            Chip.this = r1;
        }

        @Override // e.l.b.a
        public void m(List<Integer> list) {
            boolean z = false;
            list.add(0);
            Chip chip = Chip.this;
            int i2 = Chip.w;
            if (chip.e()) {
                Chip chip2 = Chip.this;
                f.b.a.e.i.b bVar = chip2.f560f;
                if (bVar != null && bVar.N) {
                    z = true;
                }
                if (z && chip2.f563i != null) {
                    list.add(1);
                }
            }
        }

        @Override // e.l.b.a
        public boolean p(int i2, int i3, Bundle bundle) {
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

        @Override // e.l.b.a
        public void q(int i2, e.j.j.c0.b bVar) {
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
                bVar.a(b.a.f1624e);
                bVar.a.setEnabled(Chip.this.isEnabled());
                return;
            }
            bVar.a.setContentDescription(str);
            bVar.a.setBoundsInParent(Chip.x);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0335  */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        ColorStateList y0 = f.b.a.c.b.o.b.y0(bVar.h0, d2, R$styleable.Chip_chipSurfaceColor);
        if (bVar.A != y0) {
            bVar.A = y0;
            bVar.onStateChange(bVar.getState());
        }
        bVar.R(f.b.a.c.b.o.b.y0(bVar.h0, d2, R$styleable.Chip_chipBackgroundColor));
        bVar.Y(d2.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        int i7 = R$styleable.Chip_chipCornerRadius;
        if (d2.hasValue(i7)) {
            bVar.S(d2.getDimension(i7, 0.0f));
        }
        bVar.a0(f.b.a.c.b.o.b.y0(bVar.h0, d2, R$styleable.Chip_chipStrokeColor));
        bVar.b0(d2.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        bVar.l0(f.b.a.c.b.o.b.y0(bVar.h0, d2, R$styleable.Chip_rippleColor));
        bVar.m0(d2.getText(R$styleable.Chip_android_text));
        Context context4 = bVar.h0;
        int i8 = R$styleable.Chip_android_textAppearance;
        f.b.a.e.s.b bVar2 = (!d2.hasValue(i8) || (resourceId = d2.getResourceId(i8, 0)) == 0) ? null : new f.b.a.e.s.b(context4, resourceId);
        bVar2.f3057k = d2.getDimension(R$styleable.Chip_android_textSize, bVar2.f3057k);
        bVar.n0(bVar2);
        int i9 = d2.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i9 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else if (i9 != 2) {
            if (i9 == 3) {
                truncateAt = TextUtils.TruncateAt.END;
            }
            bVar.X(d2.getBoolean(R$styleable.Chip_chipIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
                bVar.X(d2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
            }
            bVar.U(f.b.a.c.b.o.b.E0(bVar.h0, d2, R$styleable.Chip_chipIcon));
            i2 = R$styleable.Chip_chipIconTint;
            if (d2.hasValue(i2)) {
                bVar.W(f.b.a.c.b.o.b.y0(bVar.h0, d2, i2));
            }
            bVar.V(d2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
            bVar.i0(d2.getBoolean(R$styleable.Chip_closeIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
                bVar.i0(d2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
            }
            bVar.c0(f.b.a.c.b.o.b.E0(bVar.h0, d2, R$styleable.Chip_closeIcon));
            bVar.h0(f.b.a.c.b.o.b.y0(bVar.h0, d2, R$styleable.Chip_closeIconTint));
            bVar.e0(d2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
            bVar.N(d2.getBoolean(R$styleable.Chip_android_checkable, false));
            bVar.Q(d2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
                bVar.Q(d2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
            }
            bVar.O(f.b.a.c.b.o.b.E0(bVar.h0, d2, R$styleable.Chip_checkedIcon));
            i3 = R$styleable.Chip_checkedIconTint;
            if (d2.hasValue(i3)) {
                bVar.P(f.b.a.c.b.o.b.y0(bVar.h0, d2, i3));
            }
            bVar.X = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_showMotionSpec);
            bVar.Y = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_hideMotionSpec);
            bVar.Z(d2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
            bVar.k0(d2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
            bVar.j0(d2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
            bVar.p0(d2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
            bVar.o0(d2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
            bVar.f0(d2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
            bVar.d0(d2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
            bVar.T(d2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
            bVar.H0 = d2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
            d2.recycle();
            k.a(context2, attributeSet, i4, i5);
            k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
            this.o = obtainStyledAttributes.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
            this.q = (int) Math.ceil((double) obtainStyledAttributes.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) TypedValue.applyDimension(1, (float) 48, getContext().getResources().getDisplayMetrics()))));
            obtainStyledAttributes.recycle();
            setChipDrawable(bVar);
            bVar.q(v.i.i(this));
            k.a(context2, attributeSet, i4, i5);
            k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
            TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
            if (Build.VERSION.SDK_INT < 23) {
                setTextColor(f.b.a.c.b.o.b.y0(context2, obtainStyledAttributes2, R$styleable.Chip_android_textColor));
            }
            hasValue = obtainStyledAttributes2.hasValue(i6);
            obtainStyledAttributes2.recycle();
            this.r = new b(this);
            i();
            if (!hasValue) {
                setOutlineProvider(new f.b.a.e.i.a(this));
            }
            setChecked(this.f565k);
            setText(bVar.H);
            setEllipsize(bVar.F0);
            l();
            if (!this.f560f.G0) {
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
        bVar.X(d2.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet == null) {
            bVar.X(d2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        bVar.U(f.b.a.c.b.o.b.E0(bVar.h0, d2, R$styleable.Chip_chipIcon));
        i2 = R$styleable.Chip_chipIconTint;
        if (d2.hasValue(i2)) {
        }
        bVar.V(d2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        bVar.i0(d2.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet == null) {
            bVar.i0(d2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        bVar.c0(f.b.a.c.b.o.b.E0(bVar.h0, d2, R$styleable.Chip_closeIcon));
        bVar.h0(f.b.a.c.b.o.b.y0(bVar.h0, d2, R$styleable.Chip_closeIconTint));
        bVar.e0(d2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        bVar.N(d2.getBoolean(R$styleable.Chip_android_checkable, false));
        bVar.Q(d2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet == null) {
            bVar.Q(d2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        bVar.O(f.b.a.c.b.o.b.E0(bVar.h0, d2, R$styleable.Chip_checkedIcon));
        i3 = R$styleable.Chip_checkedIconTint;
        if (d2.hasValue(i3)) {
        }
        bVar.X = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_showMotionSpec);
        bVar.Y = f.b.a.e.a.g.a(bVar.h0, d2, R$styleable.Chip_hideMotionSpec);
        bVar.Z(d2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        bVar.k0(d2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        bVar.j0(d2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        bVar.p0(d2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        bVar.o0(d2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        bVar.f0(d2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        bVar.d0(d2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        bVar.T(d2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        bVar.H0 = d2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
        d2.recycle();
        k.a(context2, attributeSet, i4, i5);
        k.b(context2, attributeSet, iArr, i4, i5, new int[0]);
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr, i4, i5);
        this.o = obtainStyledAttributes3.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.q = (int) Math.ceil((double) obtainStyledAttributes3.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) TypedValue.applyDimension(1, (float) 48, getContext().getResources().getDisplayMetrics()))));
        obtainStyledAttributes3.recycle();
        setChipDrawable(bVar);
        bVar.q(v.i.i(this));
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
        setChecked(this.f565k);
        setText(bVar.H);
        setEllipsize(bVar.F0);
        l();
        if (!this.f560f.G0) {
        }
        setGravity(8388627);
        k();
        if (this.o) {
        }
        this.p = v.e.d(this);
    }

    public RectF getCloseIconTouchBounds() {
        this.u.setEmpty();
        if (e() && this.f563i != null) {
            f.b.a.e.i.b bVar = this.f560f;
            bVar.E(bVar.getBounds(), this.u);
        }
        return this.u;
    }

    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.t.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.t;
    }

    private f.b.a.e.s.b getTextAppearance() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.n0.f3012f;
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
        if (this.f566l != z2) {
            this.f566l = z2;
            refreshDrawableState();
        }
    }

    @Override // f.b.a.e.i.b.a
    public void a() {
        d(this.q);
        requestLayout();
        invalidateOutline();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
        if (r0.right == r7) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean d(int i2) {
        this.q = i2;
        if (!this.o) {
            if (this.f561g != null) {
                h();
            } else {
                int[] iArr = f.b.a.e.t.b.a;
                j();
            }
            return false;
        }
        int max = Math.max(0, i2 - ((int) this.f560f.C));
        int max2 = Math.max(0, i2 - this.f560f.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i3 = max2 > 0 ? max2 / 2 : 0;
            int i4 = max > 0 ? max / 2 : 0;
            if (this.f561g != null) {
                Rect rect = new Rect();
                this.f561g.getPadding(rect);
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
            this.f561g = new InsetDrawable((Drawable) this.f560f, i3, i4, i3, i4);
            int[] iArr2 = f.b.a.e.t.b.a;
            j();
            return true;
        }
        if (this.f561g != null) {
            h();
        } else {
            int[] iArr3 = f.b.a.e.t.b.a;
            j();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x0072;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z2;
        int i2;
        if (!this.s) {
            return super.dispatchHoverEvent(motionEvent);
        }
        b bVar = this.r;
        if (bVar.f1681h.isEnabled() && bVar.f1681h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int i3 = (!Chip.this.e() || !Chip.this.getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY())) ? 0 : 1;
                int i4 = bVar.m;
                if (i4 != i3) {
                    bVar.m = i3;
                    bVar.s(i3, 128);
                    bVar.s(i4, 256);
                }
            } else if (action == 10 && (i2 = bVar.m) != Integer.MIN_VALUE) {
                if (i2 != Integer.MIN_VALUE) {
                    bVar.m = Integer.MIN_VALUE;
                    bVar.s(Integer.MIN_VALUE, 128);
                    bVar.s(i2, 256);
                }
                z2 = true;
            }
            if (!z2 || super.dispatchHoverEvent(motionEvent)) {
                return true;
            }
            return false;
        }
        z2 = false;
        if (!z2) {
        }
        return true;
    }

    @Override // android.view.View
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
                                while (i2 < repeatCount && bVar.n(i3, null)) {
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
                    int i4 = bVar.f1685l;
                    if (i4 != Integer.MIN_VALUE) {
                        bVar.p(i4, 16, null);
                    }
                    z2 = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z2 = bVar.n(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z2 = bVar.n(1, null);
            }
        }
        if (!z2 || this.r.f1685l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, boolean] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // e.b.f.g, android.widget.TextView, android.widget.CompoundButton, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f.b.a.e.i.b bVar = this.f560f;
        boolean z2 = false;
        int i2 = 0;
        z2 = false;
        if (bVar != null && f.b.a.e.i.b.K(bVar.O)) {
            f.b.a.e.i.b bVar2 = this.f560f;
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
            if (this.f566l) {
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
            if (this.f566l) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            z2 = bVar2.g0(iArr);
        }
        if (z2) {
            invalidate();
        }
    }

    public final boolean e() {
        f.b.a.e.i.b bVar = this.f560f;
        return (bVar == null || bVar.H() == null) ? false : true;
    }

    public boolean f() {
        f.b.a.e.i.b bVar = this.f560f;
        return bVar != null && bVar.T;
    }

    public boolean g() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f563i;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        if (this.s) {
            this.r.s(1, 1);
        }
        return z2;
    }

    @Override // android.widget.CheckBox, android.widget.TextView, android.widget.CompoundButton, android.widget.Button, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!f()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return (!(parent instanceof ChipGroup) || !((ChipGroup) parent).f569h) ? "android.widget.CompoundButton" : "android.widget.RadioButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f561g;
        return insetDrawable == null ? this.f560f : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.V;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.W;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.B;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return Math.max(0.0f, bVar.G());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f560f;
    }

    public float getChipEndPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.g0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar == null || (drawable = bVar.J) == null) {
            return null;
        }
        return m.e.T1(drawable);
    }

    public float getChipIconSize() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.L;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.K;
        }
        return null;
    }

    public float getChipMinHeight() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.C;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.Z;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.E;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f.b.a.e.i.b bVar = this.f560f;
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
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.H();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.S;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.f0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.R;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.e0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.Q;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.F0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.s) {
            b bVar = this.r;
            if (bVar.f1685l == 1 || bVar.f1684k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public f.b.a.e.a.g getHideMotionSpec() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.Y;
        }
        return null;
    }

    public float getIconEndPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.b0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.a0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.G;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        return this.f560f.b.a;
    }

    public f.b.a.e.a.g getShowMotionSpec() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.X;
        }
        return null;
    }

    public float getTextEndPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.d0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            return bVar.c0;
        }
        return 0.0f;
    }

    public final void h() {
        if (this.f561g != null) {
            this.f561g = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            int[] iArr = f.b.a.e.t.b.a;
            j();
        }
    }

    public final void i() {
        if (e()) {
            f.b.a.e.i.b bVar = this.f560f;
            if ((bVar != null && bVar.N) && this.f563i != null) {
                v.u(this, this.r);
                this.s = true;
                return;
            }
        }
        v.u(this, null);
        this.s = false;
    }

    public final void j() {
        this.f562h = new RippleDrawable(f.b.a.e.t.b.a(this.f560f.G), getBackgroundDrawable(), null);
        this.f560f.q0(false);
        RippleDrawable rippleDrawable = this.f562h;
        AtomicInteger atomicInteger = v.a;
        v.d.q(this, rippleDrawable);
        k();
    }

    public final void k() {
        f.b.a.e.i.b bVar;
        if (!TextUtils.isEmpty(getText()) && (bVar = this.f560f) != null) {
            int F = (int) (bVar.F() + bVar.g0 + bVar.d0);
            f.b.a.e.i.b bVar2 = this.f560f;
            int C = (int) (bVar2.C() + bVar2.Z + bVar2.c0);
            if (this.f561g != null) {
                Rect rect = new Rect();
                this.f561g.getPadding(rect);
                C += rect.left;
                F += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            AtomicInteger atomicInteger = v.a;
            v.e.k(this, C, paddingTop, F, paddingBottom);
        }
    }

    public final void l() {
        TextPaint paint = getPaint();
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            paint.drawableState = bVar.getState();
        }
        f.b.a.e.s.b textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.v);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.b.a.c.b.o.b.q1(this, this.f560f);
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
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

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.s) {
            b bVar = this.r;
            int i3 = bVar.f1685l;
            if (i3 != Integer.MIN_VALUE) {
                bVar.k(i3);
            }
            if (z2) {
                bVar.n(i2, rect);
            }
        }
    }

    @Override // android.view.View
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

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f2998d) {
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

    @Override // android.widget.TextView, android.widget.Button, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.p != i2) {
            this.p = i2;
            k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    @Override // android.widget.TextView, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f566l) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                        z2 = true;
                    }
                }
                z2 = false;
            } else if (this.f566l) {
                g();
                z2 = true;
                setCloseIconPressed(false);
            }
            z2 = false;
            setCloseIconPressed(false);
        } else {
            if (contains) {
                setCloseIconPressed(true);
                z2 = true;
            }
            z2 = false;
        }
        return z2 || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f562h) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
    }

    @Override // e.b.f.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f562h) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // e.b.f.g, android.view.View
    public void setBackgroundResource(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.N(z2);
        }
    }

    public void setCheckableResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.N(bVar.h0.getResources().getBoolean(i2));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar == null) {
            this.f565k = z2;
        } else if (bVar.T) {
            boolean isChecked = isChecked();
            super.setChecked(z2);
            if (isChecked != z2 && (onCheckedChangeListener = this.f564j) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z2);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.O(drawable);
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
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.O(m.e.i0(bVar.h0, i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.P(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.P(m.e.g0(bVar.h0, i2));
        }
    }

    public void setCheckedIconVisible(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.Q(bVar.h0.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIconVisible(boolean z2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.Q(z2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null && bVar.B != colorStateList) {
            bVar.B = colorStateList;
            bVar.onStateChange(bVar.getState());
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.R(m.e.g0(bVar.h0, i2));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.S(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.S(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(f.b.a.e.i.b bVar) {
        f.b.a.e.i.b bVar2 = this.f560f;
        if (bVar2 != bVar) {
            if (bVar2 != null) {
                bVar2.E0 = new WeakReference<>(null);
            }
            this.f560f = bVar;
            bVar.G0 = false;
            Objects.requireNonNull(bVar);
            bVar.E0 = new WeakReference<>(this);
            d(this.q);
        }
    }

    public void setChipEndPadding(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null && bVar.g0 != f2) {
            bVar.g0 = f2;
            bVar.invalidateSelf();
            bVar.L();
        }
    }

    public void setChipEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.T(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipIcon(Drawable drawable) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.U(drawable);
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
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.U(m.e.i0(bVar.h0, i2));
        }
    }

    public void setChipIconSize(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.V(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.V(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.W(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.W(m.e.g0(bVar.h0, i2));
        }
    }

    public void setChipIconVisible(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.X(bVar.h0.getResources().getBoolean(i2));
        }
    }

    public void setChipIconVisible(boolean z2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.X(z2);
        }
    }

    public void setChipMinHeight(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null && bVar.C != f2) {
            bVar.C = f2;
            bVar.invalidateSelf();
            bVar.L();
        }
    }

    public void setChipMinHeightResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.Y(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null && bVar.Z != f2) {
            bVar.Z = f2;
            bVar.invalidateSelf();
            bVar.L();
        }
    }

    public void setChipStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.Z(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.a0(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.a0(m.e.g0(bVar.h0, i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.b0(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.b0(bVar.h0.getResources().getDimension(i2));
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
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.c0(drawable);
        }
        i();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null && bVar.S != charSequence) {
            e.j.h.a c = e.j.h.a.c();
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
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.d0(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.d0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.c0(m.e.i0(bVar.h0, i2));
        }
        i();
    }

    public void setCloseIconSize(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.e0(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.e0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.f0(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.f0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.h0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.h0(m.e.g0(bVar.h0, i2));
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCloseIconVisible(boolean z2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.i0(z2);
        }
        i();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
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

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            g.b bVar2 = bVar.b;
            if (bVar2.o != f2) {
                bVar2.o = f2;
                bVar.z();
            }
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f560f != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                f.b.a.e.i.b bVar = this.f560f;
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

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 == 8388627) {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(f.b.a.e.a.g gVar) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.Y = gVar;
        }
    }

    public void setHideMotionSpecResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.Y = f.b.a.e.a.g.b(bVar.h0, i2);
        }
    }

    public void setIconEndPadding(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.j0(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.j0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.k0(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.k0(bVar.h0.getResources().getDimension(i2));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.f560f != null) {
            super.setLayoutDirection(i2);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.H0 = i2;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f564j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f563i = onClickListener;
        i();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.l0(colorStateList);
        }
        if (!this.f560f.C0) {
            j();
        }
    }

    public void setRippleColorResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.l0(m.e.g0(bVar.h0, i2));
            if (!this.f560f.C0) {
                j();
            }
        }
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        f.b.a.e.i.b bVar = this.f560f;
        bVar.b.a = jVar;
        bVar.invalidateSelf();
    }

    public void setShowMotionSpec(f.b.a.e.a.g gVar) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.X = gVar;
        }
    }

    public void setShowMotionSpecResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.X = f.b.a.e.a.g.b(bVar.h0, i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (z2) {
            super.setSingleLine(z2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(bVar.G0 ? null : charSequence, bufferType);
            f.b.a.e.i.b bVar2 = this.f560f;
            if (bVar2 != null) {
                bVar2.m0(charSequence);
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.n0(new f.b.a.e.s.b(bVar.h0, i2));
        }
        l();
    }

    public void setTextAppearance(f.b.a.e.s.b bVar) {
        f.b.a.e.i.b bVar2 = this.f560f;
        if (bVar2 != null) {
            bVar2.n0(bVar);
        }
        l();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null && bVar.d0 != f2) {
            bVar.d0 = f2;
            bVar.invalidateSelf();
            bVar.L();
        }
    }

    public void setTextEndPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.o0(bVar.h0.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null && bVar.c0 != f2) {
            bVar.c0 = f2;
            bVar.invalidateSelf();
            bVar.L();
        }
    }

    public void setTextStartPaddingResource(int i2) {
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.p0(bVar.h0.getResources().getDimension(i2));
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        f.b.a.e.i.b bVar = this.f560f;
        if (bVar != null) {
            bVar.n0(new f.b.a.e.s.b(bVar.h0, i2));
        }
        l();
    }
}
