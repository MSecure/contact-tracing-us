package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.b.q.g;
import b.i.l.m;
import b.i.l.w.b;
import c.b.a.a.c.n.c;
import c.b.a.b.c0.i;
import c.b.a.b.e0.d;
import c.b.a.b.f;
import c.b.a.b.h0.g;
import c.b.a.b.h0.n;
import c.b.a.b.j;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.v.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends g implements b.a, n {
    public static final int u = k.Widget_MaterialComponents_Chip_Action;
    public static final Rect v = new Rect();
    public static final int[] w = {16842913};
    public static final int[] x = {16842911};

    /* renamed from: e  reason: collision with root package name */
    public c.b.a.b.v.b f4492e;
    public InsetDrawable f;
    public RippleDrawable g;
    public View.OnClickListener h;
    public CompoundButton.OnCheckedChangeListener i;
    public boolean j;
    public boolean k;
    public boolean l;
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

        @Override // c.b.a.b.e0.d
        public void a(int i) {
        }

        @Override // c.b.a.b.e0.d
        public void b(Typeface typeface, boolean z) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            c.b.a.b.v.b bVar = chip.f4492e;
            if (bVar.G0) {
                charSequence = bVar.G;
            } else {
                charSequence = chip.getText();
            }
            chip.setText(charSequence);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends b.k.b.a {
        public b(Chip chip) {
            super(chip);
        }

        @Override // b.k.b.a
        public void m(List<Integer> list) {
            boolean z = false;
            list.add(0);
            if (Chip.this.f()) {
                c.b.a.b.v.b bVar = Chip.this.f4492e;
                if (bVar != null && bVar.M) {
                    z = true;
                }
                if (z && Chip.this.h != null) {
                    list.add(1);
                }
            }
        }

        @Override // b.k.b.a
        public boolean p(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.h;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.q.s(1, 1);
                }
            }
            return z;
        }

        @Override // b.k.b.a
        public void q(int i, b.i.l.w.b bVar) {
            String str = "";
            if (i == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription == null) {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = j.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    objArr[0] = str;
                    closeIconContentDescription = context.getString(i2, objArr).trim();
                }
                bVar.f1195a.setContentDescription(closeIconContentDescription);
                bVar.f1195a.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                bVar.a(b.a.f1198e);
                bVar.f1195a.setEnabled(Chip.this.isEnabled());
                return;
            }
            bVar.f1195a.setContentDescription(str);
            bVar.f1195a.setBoundsInParent(Chip.v);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0304  */
    public Chip(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r6, u), attributeSet, r6);
        boolean hasValue;
        TextUtils.TruncateAt truncateAt;
        int resourceId;
        int i2 = c.b.a.b.b.chipStyle;
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
        int i3 = u;
        c.b.a.b.v.b bVar = new c.b.a.b.v.b(context2, attributeSet, i2, i3);
        TypedArray d2 = i.d(bVar.g0, attributeSet, l.Chip, i2, i3, new int[0]);
        bVar.I0 = d2.hasValue(l.Chip_shapeAppearance);
        ColorStateList Z0 = c.Z0(bVar.g0, d2, l.Chip_chipSurfaceColor);
        if (bVar.z != Z0) {
            bVar.z = Z0;
            bVar.onStateChange(bVar.getState());
        }
        bVar.Q(c.Z0(bVar.g0, d2, l.Chip_chipBackgroundColor));
        bVar.X(d2.getDimension(l.Chip_chipMinHeight, 0.0f));
        if (d2.hasValue(l.Chip_chipCornerRadius)) {
            bVar.R(d2.getDimension(l.Chip_chipCornerRadius, 0.0f));
        }
        bVar.Z(c.Z0(bVar.g0, d2, l.Chip_chipStrokeColor));
        bVar.a0(d2.getDimension(l.Chip_chipStrokeWidth, 0.0f));
        bVar.k0(c.Z0(bVar.g0, d2, l.Chip_rippleColor));
        bVar.l0(d2.getText(l.Chip_android_text));
        Context context3 = bVar.g0;
        int i4 = l.Chip_android_textAppearance;
        bVar.m0((!d2.hasValue(i4) || (resourceId = d2.getResourceId(i4, 0)) == 0) ? null : new c.b.a.b.e0.b(context3, resourceId));
        int i5 = d2.getInt(l.Chip_android_ellipsize, 0);
        if (i5 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else if (i5 != 2) {
            if (i5 == 3) {
                truncateAt = TextUtils.TruncateAt.END;
            }
            bVar.W(d2.getBoolean(l.Chip_chipIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
                bVar.W(d2.getBoolean(l.Chip_chipIconEnabled, false));
            }
            bVar.T(c.d1(bVar.g0, d2, l.Chip_chipIcon));
            if (d2.hasValue(l.Chip_chipIconTint)) {
                bVar.V(c.Z0(bVar.g0, d2, l.Chip_chipIconTint));
            }
            bVar.U(d2.getDimension(l.Chip_chipIconSize, 0.0f));
            bVar.h0(d2.getBoolean(l.Chip_closeIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
                bVar.h0(d2.getBoolean(l.Chip_closeIconEnabled, false));
            }
            bVar.b0(c.d1(bVar.g0, d2, l.Chip_closeIcon));
            bVar.g0(c.Z0(bVar.g0, d2, l.Chip_closeIconTint));
            bVar.d0(d2.getDimension(l.Chip_closeIconSize, 0.0f));
            bVar.M(d2.getBoolean(l.Chip_android_checkable, false));
            bVar.P(d2.getBoolean(l.Chip_checkedIconVisible, false));
            if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
                bVar.P(d2.getBoolean(l.Chip_checkedIconEnabled, false));
            }
            bVar.N(c.d1(bVar.g0, d2, l.Chip_checkedIcon));
            if (d2.hasValue(l.Chip_checkedIconTint)) {
                bVar.O(c.Z0(bVar.g0, d2, l.Chip_checkedIconTint));
            }
            bVar.W = c.b.a.b.m.g.a(bVar.g0, d2, l.Chip_showMotionSpec);
            bVar.X = c.b.a.b.m.g.a(bVar.g0, d2, l.Chip_hideMotionSpec);
            bVar.Y(d2.getDimension(l.Chip_chipStartPadding, 0.0f));
            bVar.j0(d2.getDimension(l.Chip_iconStartPadding, 0.0f));
            bVar.i0(d2.getDimension(l.Chip_iconEndPadding, 0.0f));
            bVar.o0(d2.getDimension(l.Chip_textStartPadding, 0.0f));
            bVar.n0(d2.getDimension(l.Chip_textEndPadding, 0.0f));
            bVar.e0(d2.getDimension(l.Chip_closeIconStartPadding, 0.0f));
            bVar.c0(d2.getDimension(l.Chip_closeIconEndPadding, 0.0f));
            bVar.S(d2.getDimension(l.Chip_chipEndPadding, 0.0f));
            bVar.H0 = d2.getDimensionPixelSize(l.Chip_android_maxWidth, Integer.MAX_VALUE);
            d2.recycle();
            TypedArray d3 = i.d(context2, attributeSet, l.Chip, i2, u, new int[0]);
            this.n = d3.getBoolean(l.Chip_ensureMinTouchTargetSize, false);
            this.p = (int) Math.ceil((double) d3.getDimension(l.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) c.H0(getContext(), 48))));
            d3.recycle();
            setChipDrawable(bVar);
            bVar.q(getElevation());
            TypedArray d4 = i.d(context2, attributeSet, l.Chip, i2, u, new int[0]);
            hasValue = d4.hasValue(l.Chip_shapeAppearance);
            d4.recycle();
            this.q = new b(this);
            i();
            if (!hasValue) {
                setOutlineProvider(new c.b.a.b.v.a(this));
            }
            setChecked(this.j);
            setText(bVar.G);
            setEllipsize(bVar.F0);
            setIncludeFontPadding(false);
            l();
            if (!this.f4492e.G0) {
                setLines(1);
                setHorizontallyScrolling(true);
            }
            setGravity(8388627);
            k();
            if (this.n) {
                setMinHeight(this.p);
            }
            this.o = getLayoutDirection();
        } else {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        }
        bVar.F0 = truncateAt;
        bVar.W(d2.getBoolean(l.Chip_chipIconVisible, false));
        bVar.W(d2.getBoolean(l.Chip_chipIconEnabled, false));
        bVar.T(c.d1(bVar.g0, d2, l.Chip_chipIcon));
        if (d2.hasValue(l.Chip_chipIconTint)) {
        }
        bVar.U(d2.getDimension(l.Chip_chipIconSize, 0.0f));
        bVar.h0(d2.getBoolean(l.Chip_closeIconVisible, false));
        bVar.h0(d2.getBoolean(l.Chip_closeIconEnabled, false));
        bVar.b0(c.d1(bVar.g0, d2, l.Chip_closeIcon));
        bVar.g0(c.Z0(bVar.g0, d2, l.Chip_closeIconTint));
        bVar.d0(d2.getDimension(l.Chip_closeIconSize, 0.0f));
        bVar.M(d2.getBoolean(l.Chip_android_checkable, false));
        bVar.P(d2.getBoolean(l.Chip_checkedIconVisible, false));
        bVar.P(d2.getBoolean(l.Chip_checkedIconEnabled, false));
        bVar.N(c.d1(bVar.g0, d2, l.Chip_checkedIcon));
        if (d2.hasValue(l.Chip_checkedIconTint)) {
        }
        bVar.W = c.b.a.b.m.g.a(bVar.g0, d2, l.Chip_showMotionSpec);
        bVar.X = c.b.a.b.m.g.a(bVar.g0, d2, l.Chip_hideMotionSpec);
        bVar.Y(d2.getDimension(l.Chip_chipStartPadding, 0.0f));
        bVar.j0(d2.getDimension(l.Chip_iconStartPadding, 0.0f));
        bVar.i0(d2.getDimension(l.Chip_iconEndPadding, 0.0f));
        bVar.o0(d2.getDimension(l.Chip_textStartPadding, 0.0f));
        bVar.n0(d2.getDimension(l.Chip_textEndPadding, 0.0f));
        bVar.e0(d2.getDimension(l.Chip_closeIconStartPadding, 0.0f));
        bVar.c0(d2.getDimension(l.Chip_closeIconEndPadding, 0.0f));
        bVar.S(d2.getDimension(l.Chip_chipEndPadding, 0.0f));
        bVar.H0 = d2.getDimensionPixelSize(l.Chip_android_maxWidth, Integer.MAX_VALUE);
        d2.recycle();
        TypedArray d32 = i.d(context2, attributeSet, l.Chip, i2, u, new int[0]);
        this.n = d32.getBoolean(l.Chip_ensureMinTouchTargetSize, false);
        this.p = (int) Math.ceil((double) d32.getDimension(l.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) c.H0(getContext(), 48))));
        d32.recycle();
        setChipDrawable(bVar);
        bVar.q(getElevation());
        TypedArray d42 = i.d(context2, attributeSet, l.Chip, i2, u, new int[0]);
        hasValue = d42.hasValue(l.Chip_shapeAppearance);
        d42.recycle();
        this.q = new b(this);
        i();
        if (!hasValue) {
        }
        setChecked(this.j);
        setText(bVar.G);
        setEllipsize(bVar.F0);
        setIncludeFontPadding(false);
        l();
        if (!this.f4492e.G0) {
        }
        setGravity(8388627);
        k();
        if (this.n) {
        }
        this.o = getLayoutDirection();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getCloseIconTouchBounds() {
        this.s.setEmpty();
        if (f()) {
            c.b.a.b.v.b bVar = this.f4492e;
            bVar.E(bVar.getBounds(), this.s);
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

    private c.b.a.b.e0.b getTextAppearance() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.n0.f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    @Override // c.b.a.b.v.b.a
    public void a() {
        e(this.p);
        requestLayout();
        invalidateOutline();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x00a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int i2;
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = b.k.b.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = b.k.b.a.class.getDeclaredMethod("t", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.q, Integer.MIN_VALUE);
                    z = true;
                    if (!z) {
                        return true;
                    }
                    b bVar = this.q;
                    if (bVar.h.isEnabled() && bVar.h.isTouchExplorationEnabled()) {
                        int action = motionEvent.getAction();
                        if (action == 7 || action == 9) {
                            int i3 = (!Chip.this.f() || !Chip.this.getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY())) ? 0 : 1;
                            int i4 = bVar.m;
                            if (i4 != i3) {
                                bVar.m = i3;
                                bVar.s(i3, RecyclerView.d0.FLAG_IGNORE);
                                bVar.s(i4, RecyclerView.d0.FLAG_TMP_DETACHED);
                            }
                        } else if (action == 10 && (i2 = bVar.m) != Integer.MIN_VALUE) {
                            if (i2 != Integer.MIN_VALUE) {
                                bVar.m = Integer.MIN_VALUE;
                                bVar.s(Integer.MIN_VALUE, RecyclerView.d0.FLAG_IGNORE);
                                bVar.s(i2, RecyclerView.d0.FLAG_TMP_DETACHED);
                            }
                        }
                        z2 = true;
                        return z2 || super.dispatchHoverEvent(motionEvent);
                    }
                    z2 = false;
                    if (z2) {
                        return true;
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        z = false;
        if (!z) {
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        b bVar = this.q;
        if (bVar != null) {
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
                                    while (i2 < repeatCount && bVar.n(i3, null)) {
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
                        int i4 = bVar.l;
                        if (i4 != Integer.MIN_VALUE) {
                            bVar.p(i4, 16, null);
                        }
                        z = true;
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    z = bVar.n(2, null);
                } else if (keyEvent.hasModifiers(1)) {
                    z = bVar.n(1, null);
                }
            }
            if (!z || this.q.l == Integer.MIN_VALUE) {
                return super.dispatchKeyEvent(keyEvent);
            }
            return true;
        }
        throw null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // b.b.q.g
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c.b.a.b.v.b bVar = this.f4492e;
        boolean z = false;
        int i2 = 0;
        z = false;
        if (bVar != null && c.b.a.b.v.b.J(bVar.N)) {
            c.b.a.b.v.b bVar2 = this.f4492e;
            ?? isEnabled = isEnabled();
            int i3 = isEnabled;
            if (this.m) {
                i3 = isEnabled + 1;
            }
            int i4 = i3;
            if (this.l) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (this.k) {
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
            if (this.l) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.k) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r0.right == r7) goto L_0x0069;
     */
    public boolean e(int i2) {
        this.p = i2;
        int i3 = 0;
        if (!this.n) {
            if (this.f != null) {
                h();
            } else {
                boolean z = c.b.a.b.f0.a.f2968a;
                j();
            }
            return false;
        }
        int max = Math.max(0, i2 - ((int) this.f4492e.B));
        int max2 = Math.max(0, i2 - this.f4492e.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i4 = max2 > 0 ? max2 / 2 : 0;
            if (max > 0) {
                i3 = max / 2;
            }
            if (this.f != null) {
                Rect rect = new Rect();
                this.f.getPadding(rect);
                if (rect.top == i3) {
                    if (rect.bottom == i3) {
                        if (rect.left == i4) {
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
            this.f = new InsetDrawable((Drawable) this.f4492e, i4, i3, i4, i3);
            boolean z2 = c.b.a.b.f0.a.f2968a;
            j();
            return true;
        }
        if (this.f != null) {
            h();
        } else {
            boolean z3 = c.b.a.b.f0.a.f2968a;
            j();
        }
        return false;
    }

    public final boolean f() {
        c.b.a.b.v.b bVar = this.f4492e;
        return (bVar == null || bVar.H() == null) ? false : true;
    }

    public boolean g() {
        c.b.a.b.v.b bVar = this.f4492e;
        return bVar != null && bVar.S;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f;
        return insetDrawable == null ? this.f4492e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.U;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.V;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.A;
        }
        return null;
    }

    public float getChipCornerRadius() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return Math.max(0.0f, bVar.G());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f4492e;
    }

    public float getChipEndPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.f0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar == null || (drawable = bVar.I) == null) {
            return null;
        }
        return i.j.l1(drawable);
    }

    public float getChipIconSize() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.K;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.J;
        }
        return null;
    }

    public float getChipMinHeight() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.B;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.Y;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.D;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c.b.a.b.v.b bVar = this.f4492e;
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
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.H();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.R;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.e0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.Q;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.d0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.P;
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.F0;
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        b bVar = this.q;
        if (bVar.l == 1 || bVar.k == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public c.b.a.b.m.g getHideMotionSpec() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.X;
        }
        return null;
    }

    public float getIconEndPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.a0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.Z;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.F;
        }
        return null;
    }

    public c.b.a.b.h0.j getShapeAppearanceModel() {
        return this.f4492e.f2982b.f2987a;
    }

    public c.b.a.b.m.g getShowMotionSpec() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.W;
        }
        return null;
    }

    public float getTextEndPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.c0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            return bVar.b0;
        }
        return 0.0f;
    }

    public final void h() {
        if (this.f != null) {
            this.f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            boolean z = c.b.a.b.f0.a.f2968a;
            j();
        }
    }

    public final void i() {
        b bVar;
        if (f()) {
            c.b.a.b.v.b bVar2 = this.f4492e;
            if ((bVar2 != null && bVar2.M) && this.h != null) {
                bVar = this.q;
                m.T(this, bVar);
            }
        }
        bVar = null;
        m.T(this, bVar);
    }

    public final void j() {
        this.g = new RippleDrawable(c.b.a.b.f0.a.b(this.f4492e.F), getBackgroundDrawable(), null);
        this.f4492e.p0(false);
        m.W(this, this.g);
        k();
    }

    public final void k() {
        c.b.a.b.v.b bVar;
        if (!TextUtils.isEmpty(getText()) && (bVar = this.f4492e) != null) {
            int F = (int) (bVar.F() + bVar.f0 + bVar.c0);
            c.b.a.b.v.b bVar2 = this.f4492e;
            int C = (int) (bVar2.C() + bVar2.Y + bVar2.b0);
            if (this.f != null) {
                Rect rect = new Rect();
                this.f.getPadding(rect);
                C += rect.left;
                F += rect.right;
            }
            m.c0(this, C, getPaddingTop(), F, getPaddingBottom());
        }
    }

    public final void l() {
        TextPaint paint = getPaint();
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            paint.drawableState = bVar.getState();
        }
        c.b.a.b.e0.b textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.c(getContext(), paint, this.t);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.f2(this, this.f4492e);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, w);
        }
        if (g()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, x);
        }
        return onCreateDrawableState;
    }

    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        b bVar = this.q;
        int i3 = bVar.l;
        if (i3 != Integer.MIN_VALUE) {
            bVar.k(i3);
        }
        if (z) {
            bVar.n(i2, rect);
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
        accessibilityNodeInfo.setClassName((g() || isClickable()) ? g() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            int i3 = -1;
            if (chipGroup.f2936d) {
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= chipGroup.getChildCount()) {
                        i5 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i4) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i4)) == this) {
                            break;
                        }
                        i5++;
                    }
                    i4++;
                }
                i2 = i5;
            } else {
                i2 = -1;
            }
            Object tag = getTag(f.row_index_key);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) b.c.a(i3, 1, i2, 1, false, isChecked()).f1204a);
        }
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.o != i2) {
            this.o = i2;
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.k) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                    }
                }
                z = false;
                return !z || super.onTouchEvent(motionEvent);
            } else if (this.k) {
                playSoundEffect(0);
                View.OnClickListener onClickListener = this.h;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                this.q.s(1, 1);
                z = true;
                setCloseIconPressed(false);
                if (!z) {
                }
            }
            z = false;
            setCloseIconPressed(false);
            if (!z) {
            }
        }
        if (contains) {
            setCloseIconPressed(true);
        }
        z = false;
        if (!z) {
        }
        z = true;
        if (!z) {
        }
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.g) {
            super.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i2) {
    }

    @Override // b.b.q.g
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.g) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // b.b.q.g
    public void setBackgroundResource(int i2) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.M(z);
        }
    }

    public void setCheckableResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.M(bVar.g0.getResources().getBoolean(i2));
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar == null) {
            this.j = z;
        } else if (bVar.S) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.i) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c.b.a.b.v.b bVar = this.f4492e;
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
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.N(b.b.l.a.a.b(bVar.g0, i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.O(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.O(b.b.l.a.a.a(bVar.g0, i2));
        }
    }

    public void setCheckedIconVisible(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.P(bVar.g0.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.P(z);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null && bVar.A != colorStateList) {
            bVar.A = colorStateList;
            bVar.onStateChange(bVar.getState());
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.Q(b.b.l.a.a.a(bVar.g0, i2));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.R(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.R(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(c.b.a.b.v.b bVar) {
        c.b.a.b.v.b bVar2 = this.f4492e;
        if (bVar2 != bVar) {
            if (bVar2 != null) {
                bVar2.E0 = new WeakReference<>(null);
            }
            this.f4492e = bVar;
            bVar.G0 = false;
            if (bVar != null) {
                bVar.E0 = new WeakReference<>(this);
                e(this.p);
                return;
            }
            throw null;
        }
    }

    public void setChipEndPadding(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null && bVar.f0 != f2) {
            bVar.f0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipEndPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.S(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipIcon(Drawable drawable) {
        c.b.a.b.v.b bVar = this.f4492e;
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
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.T(b.b.l.a.a.b(bVar.g0, i2));
        }
    }

    public void setChipIconSize(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.U(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.U(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.V(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.V(b.b.l.a.a.a(bVar.g0, i2));
        }
    }

    public void setChipIconVisible(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.W(bVar.g0.getResources().getBoolean(i2));
        }
    }

    public void setChipIconVisible(boolean z) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.W(z);
        }
    }

    public void setChipMinHeight(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null && bVar.B != f2) {
            bVar.B = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipMinHeightResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.X(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null && bVar.Y != f2) {
            bVar.Y = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setChipStartPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.Y(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.Z(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.Z(b.b.l.a.a.a(bVar.g0, i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.a0(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
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
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.b0(drawable);
        }
        i();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null && bVar.R != charSequence) {
            b.i.j.a c2 = b.i.j.a.c();
            bVar.R = c2.d(charSequence, c2.f1113c, true);
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
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.c0(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.c0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.b0(b.b.l.a.a.b(bVar.g0, i2));
        }
        i();
    }

    public void setCloseIconSize(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.d0(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.d0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.e0(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.e0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.g0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.g0(b.b.l.a.a.a(bVar.g0, i2));
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCloseIconVisible(boolean z) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.h0(z);
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
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            g.b bVar2 = bVar.f2982b;
            if (bVar2.o != f2) {
                bVar2.o = f2;
                bVar.z();
            }
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f4492e != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                c.b.a.b.v.b bVar = this.f4492e;
                if (bVar != null) {
                    bVar.F0 = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.n = z;
        e(this.p);
    }

    public void setGravity(int i2) {
        if (i2 == 8388627) {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(c.b.a.b.m.g gVar) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.X = gVar;
        }
    }

    public void setHideMotionSpecResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.X = c.b.a.b.m.g.b(bVar.g0, i2);
        }
    }

    public void setIconEndPadding(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.i0(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.i0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.j0(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.j0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setLayoutDirection(int i2) {
        if (this.f4492e != null) {
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
        c.b.a.b.v.b bVar = this.f4492e;
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
        this.i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.h = onClickListener;
        i();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.k0(colorStateList);
        }
        if (!this.f4492e.C0) {
            j();
        }
    }

    public void setRippleColorResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.k0(b.b.l.a.a.a(bVar.g0, i2));
            if (!this.f4492e.C0) {
                j();
            }
        }
    }

    @Override // c.b.a.b.h0.n
    public void setShapeAppearanceModel(c.b.a.b.h0.j jVar) {
        c.b.a.b.v.b bVar = this.f4492e;
        bVar.f2982b.f2987a = jVar;
        bVar.invalidateSelf();
    }

    public void setShowMotionSpec(c.b.a.b.m.g gVar) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.W = gVar;
        }
    }

    public void setShowMotionSpecResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.W = c.b.a.b.m.g.b(bVar.g0, i2);
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
        if (this.f4492e != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(this.f4492e.G0 ? null : charSequence, bufferType);
            c.b.a.b.v.b bVar = this.f4492e;
            if (bVar != null) {
                bVar.l0(charSequence);
            }
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.n0.b(new c.b.a.b.e0.b(bVar.g0, i2), bVar.g0);
        }
        l();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null && bVar.c0 != f2) {
            bVar.c0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setTextEndPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.n0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null && bVar.b0 != f2) {
            bVar.b0 = f2;
            bVar.invalidateSelf();
            bVar.K();
        }
    }

    public void setTextStartPaddingResource(int i2) {
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.o0(bVar.g0.getResources().getDimension(i2));
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        c.b.a.b.v.b bVar = this.f4492e;
        if (bVar != null) {
            bVar.n0.b(new c.b.a.b.e0.b(bVar.g0, i2), bVar.g0);
        }
        l();
    }

    public void setTextAppearance(c.b.a.b.e0.b bVar) {
        c.b.a.b.v.b bVar2 = this.f4492e;
        if (bVar2 != null) {
            bVar2.n0.b(bVar, bVar2.g0);
        }
        l();
    }
}
