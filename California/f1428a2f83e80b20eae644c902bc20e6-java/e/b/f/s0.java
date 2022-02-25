package e.b.f;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.i.i.l;
import java.util.concurrent.atomic.AtomicInteger;

public class s0 extends CompoundButton {
    public static final Property<s0, Float> O = new a(Float.class, "thumbPos");
    public static final int[] P = {16842912};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final TextPaint G;
    public ColorStateList H;
    public Layout I;
    public Layout J;
    public TransformationMethod K;
    public ObjectAnimator L;
    public final y M;
    public final Rect N;
    public Drawable b;
    public ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f936d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f937e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f938f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f939g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f940h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f941i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f942j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f943k;

    /* renamed from: l  reason: collision with root package name */
    public int f944l;
    public int m;
    public int n;
    public boolean o;
    public CharSequence p;
    public CharSequence q;
    public boolean r;
    public int s;
    public int t;
    public float u;
    public float v;
    public VelocityTracker w;
    public int x;
    public float y;
    public int z;

    public class a extends Property<s0, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(s0 s0Var) {
            return Float.valueOf(s0Var.y);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(s0 s0Var, Float f2) {
            s0Var.setThumbPosition(f2.floatValue());
        }
    }

    public s0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public s0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Typeface typeface;
        int resourceId;
        e.b.d.a aVar = null;
        this.c = null;
        this.f936d = null;
        this.f937e = false;
        this.f938f = false;
        this.f940h = null;
        this.f941i = null;
        this.f942j = false;
        this.f943k = false;
        this.w = VelocityTracker.obtain();
        this.N = new Rect();
        t0.a(this, getContext());
        boolean z2 = true;
        TextPaint textPaint = new TextPaint(1);
        this.G = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.SwitchCompat;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        y0 y0Var = new y0(context, obtainStyledAttributes);
        l.q(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        Drawable g2 = y0Var.g(R$styleable.SwitchCompat_android_thumb);
        this.b = g2;
        if (g2 != null) {
            g2.setCallback(this);
        }
        Drawable g3 = y0Var.g(R$styleable.SwitchCompat_track);
        this.f939g = g3;
        if (g3 != null) {
            g3.setCallback(this);
        }
        this.p = y0Var.n(R$styleable.SwitchCompat_android_textOn);
        this.q = y0Var.n(R$styleable.SwitchCompat_android_textOff);
        this.r = y0Var.a(R$styleable.SwitchCompat_showText, true);
        this.f944l = y0Var.f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.m = y0Var.f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.n = y0Var.f(R$styleable.SwitchCompat_switchPadding, 0);
        this.o = y0Var.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList c2 = y0Var.c(R$styleable.SwitchCompat_thumbTint);
        if (c2 != null) {
            this.c = c2;
            this.f937e = true;
        }
        PorterDuff.Mode d2 = e0.d(y0Var.j(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f936d != d2) {
            this.f936d = d2;
            this.f938f = true;
        }
        if (this.f937e || this.f938f) {
            a();
        }
        ColorStateList c3 = y0Var.c(R$styleable.SwitchCompat_trackTint);
        if (c3 != null) {
            this.f940h = c3;
            this.f942j = true;
        }
        PorterDuff.Mode d3 = e0.d(y0Var.j(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f941i != d3) {
            this.f941i = d3;
            this.f943k = true;
        }
        if (this.f942j || this.f943k) {
            b();
        }
        int l2 = y0Var.l(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (l2 != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(l2, R$styleable.TextAppearance);
            int i3 = R$styleable.TextAppearance_android_textColor;
            ColorStateList colorStateList = (!obtainStyledAttributes2.hasValue(i3) || (resourceId = obtainStyledAttributes2.getResourceId(i3, 0)) == 0 || (colorStateList = e.b.b.a.a.a(context, resourceId)) == null) ? obtainStyledAttributes2.getColorStateList(i3) : colorStateList;
            this.H = colorStateList == null ? getTextColors() : colorStateList;
            int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);
            if (dimensionPixelSize != 0) {
                float f2 = (float) dimensionPixelSize;
                if (f2 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f2);
                    requestLayout();
                }
            }
            int i4 = obtainStyledAttributes2.getInt(R$styleable.TextAppearance_android_typeface, -1);
            int i5 = obtainStyledAttributes2.getInt(R$styleable.TextAppearance_android_textStyle, -1);
            if (i4 != 1) {
                typeface = i4 != 2 ? i4 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF;
            } else {
                typeface = Typeface.SANS_SERIF;
            }
            float f3 = 0.0f;
            if (i5 > 0) {
                Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i5) : Typeface.create(typeface, i5);
                setSwitchTypeface(defaultFromStyle);
                int i6 = i5 & (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0));
                textPaint.setFakeBoldText((i6 & 1) == 0 ? false : z2);
                textPaint.setTextSkewX((i6 & 2) != 0 ? -0.25f : f3);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            this.K = obtainStyledAttributes2.getBoolean(R$styleable.TextAppearance_textAllCaps, false) ? new e.b.d.a(getContext()) : aVar;
            obtainStyledAttributes2.recycle();
        }
        y yVar = new y(this);
        this.M = yVar;
        yVar.e(attributeSet, i2);
        y0Var.b.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.t = viewConfiguration.getScaledTouchSlop();
        this.x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private boolean getTargetCheckedState() {
        return this.y > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((e1.a(this) ? 1.0f - this.y : this.y) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f939g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.N;
        drawable.getPadding(rect);
        Drawable drawable2 = this.b;
        Rect c2 = drawable2 != null ? e0.c(drawable2) : e0.c;
        return ((((this.z - this.B) - rect.left) - rect.right) - c2.left) - c2.right;
    }

    public final void a() {
        Drawable drawable = this.b;
        if (drawable == null) {
            return;
        }
        if (this.f937e || this.f938f) {
            Drawable mutate = m.h.v1(drawable).mutate();
            this.b = mutate;
            if (this.f937e) {
                mutate.setTintList(this.c);
            }
            if (this.f938f) {
                this.b.setTintMode(this.f936d);
            }
            if (this.b.isStateful()) {
                this.b.setState(getDrawableState());
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f939g;
        if (drawable == null) {
            return;
        }
        if (this.f942j || this.f943k) {
            Drawable mutate = m.h.v1(drawable).mutate();
            this.f939g = mutate;
            if (this.f942j) {
                mutate.setTintList(this.f940h);
            }
            if (this.f943k) {
                this.f939g.setTintMode(this.f941i);
            }
            if (this.f939g.isStateful()) {
                this.f939g.setState(getDrawableState());
            }
        }
    }

    public final Layout c(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.K;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        TextPaint textPaint = this.G;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.N;
        int i4 = this.C;
        int i5 = this.D;
        int i6 = this.E;
        int i7 = this.F;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.b;
        Rect c2 = drawable != null ? e0.c(drawable) : e0.c;
        Drawable drawable2 = this.f939g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i8 = rect.left;
            thumbOffset += i8;
            if (c2 != null) {
                int i9 = c2.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = c2.top;
                int i11 = rect.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = c2.right;
                int i13 = rect.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = c2.bottom;
                int i15 = rect.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f939g.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f939g.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i16 = thumbOffset - rect.left;
            int i17 = thumbOffset + this.B + rect.right;
            this.b.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
        Drawable drawable2 = this.f939g;
        if (drawable2 != null) {
            drawable2.setHotspot(f2, f3);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.b;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f939g;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!e1.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (e1.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.r;
    }

    public boolean getSplitTrack() {
        return this.o;
    }

    public int getSwitchMinWidth() {
        return this.m;
    }

    public int getSwitchPadding() {
        return this.n;
    }

    public CharSequence getTextOff() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.b;
    }

    public int getThumbTextPadding() {
        return this.f944l;
    }

    public ColorStateList getThumbTintList() {
        return this.c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f936d;
    }

    public Drawable getTrackDrawable() {
        return this.f939g;
    }

    public ColorStateList getTrackTintList() {
        return this.f940h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f941i;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f939g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.L.end();
            this.L = null;
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, P);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.f939g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.D;
        int i4 = this.F;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.b;
        if (drawable != null) {
            if (!this.o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect c2 = e0.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += c2.left;
                rect.right -= c2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.I : this.J;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.H;
            if (colorStateList != null) {
                this.G.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.G.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onLayout(z2, i2, i3, i4, i5);
        int i11 = 0;
        if (this.b != null) {
            Rect rect = this.N;
            Drawable drawable = this.f939g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect c2 = e0.c(this.b);
            i6 = Math.max(0, c2.left - rect.left);
            i11 = Math.max(0, c2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (e1.a(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.z + i8) - i6) - i11;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i11;
            i8 = (i7 - this.z) + i6 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = getPaddingTop();
            int i12 = this.A;
            int height = (((getHeight() + paddingTop) - getPaddingBottom()) / 2) - (i12 / 2);
            i9 = i12 + height;
            i10 = height;
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i9 = this.A + i10;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.A;
        }
        this.C = i8;
        this.D = i10;
        this.F = i9;
        this.E = i7;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (this.r) {
            if (this.I == null) {
                this.I = c(this.p);
            }
            if (this.J == null) {
                this.J = c(this.q);
            }
        }
        Rect rect = this.N;
        Drawable drawable = this.b;
        int i7 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.b.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.b.getIntrinsicHeight();
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (this.r) {
            i6 = (this.f944l * 2) + Math.max(this.I.getWidth(), this.J.getWidth());
        } else {
            i6 = 0;
        }
        this.B = Math.max(i6, i5);
        Drawable drawable2 = this.f939g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i7 = this.f939g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i8 = rect.left;
        int i9 = rect.right;
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            Rect c2 = e0.c(drawable3);
            i8 = Math.max(i8, c2.left);
            i9 = Math.max(i9, c2.right);
        }
        int max = Math.max(this.m, (this.B * 2) + i8 + i9);
        int max2 = Math.max(i7, i4);
        this.z = max;
        this.A = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0 != 3) goto L_0x0153;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        this.w.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = false;
        if (actionMasked != 0) {
            float f2 = 0.0f;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.s;
                    if (i2 == 1) {
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.u) > ((float) this.t) || Math.abs(y2 - this.v) > ((float) this.t)) {
                            this.s = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.u = x2;
                            this.v = y2;
                            return true;
                        }
                    } else if (i2 == 2) {
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f3 = x3 - this.u;
                        float f4 = thumbScrollRange != 0 ? f3 / ((float) thumbScrollRange) : f3 > 0.0f ? 1.0f : -1.0f;
                        if (e1.a(this)) {
                            f4 = -f4;
                        }
                        float f5 = this.y;
                        float f6 = f4 + f5;
                        if (f6 >= 0.0f) {
                            f2 = f6 > 1.0f ? 1.0f : f6;
                        }
                        if (f2 != f5) {
                            this.u = x3;
                            setThumbPosition(f2);
                        }
                        return true;
                    }
                }
            }
            if (this.s == 2) {
                this.s = 0;
                boolean z4 = motionEvent.getAction() == 1 && isEnabled();
                boolean isChecked = isChecked();
                if (z4) {
                    this.w.computeCurrentVelocity(1000);
                    float xVelocity = this.w.getXVelocity();
                    z2 = Math.abs(xVelocity) > ((float) this.x) ? !e1.a(this) ? xVelocity > 0.0f : xVelocity < 0.0f : getTargetCheckedState();
                } else {
                    z2 = isChecked;
                }
                if (z2 != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z2);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.s = 0;
            this.w.clear();
        } else {
            float x4 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (isEnabled()) {
                if (this.b != null) {
                    int thumbOffset = getThumbOffset();
                    this.b.getPadding(this.N);
                    int i3 = this.D;
                    int i4 = this.t;
                    int i5 = i3 - i4;
                    int i6 = (this.C + thumbOffset) - i4;
                    Rect rect = this.N;
                    int i7 = this.B + i6 + rect.left + rect.right + i4;
                    int i8 = this.F + i4;
                    if (x4 > ((float) i6) && x4 < ((float) i7) && y3 > ((float) i5) && y3 < ((float) i8)) {
                        z3 = true;
                    }
                }
                if (z3) {
                    this.s = 1;
                    this.u = x4;
                    this.v = y3;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean isChecked = isChecked();
        float f2 = 1.0f;
        if (getWindowToken() != null) {
            AtomicInteger atomicInteger = l.a;
            if (isLaidOut()) {
                if (!isChecked) {
                    f2 = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, O, f2);
                this.L = ofFloat;
                ofFloat.setDuration(250L);
                this.L.setAutoCancel(true);
                this.L.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (!isChecked) {
            f2 = 0.0f;
        }
        setThumbPosition(f2);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.h.w1(this, callback));
    }

    public void setShowText(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z2) {
        this.o = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.G.getTypeface() != null && !this.G.getTypeface().equals(typeface)) || (this.G.getTypeface() == null && typeface != null)) {
            this.G.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f2) {
        this.y = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(e.b.b.a.a.b(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.f944l = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.c = colorStateList;
        this.f937e = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f936d = mode;
        this.f938f = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f939g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f939g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(e.b.b.a.a.b(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f940h = colorStateList;
        this.f942j = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f941i = mode;
        this.f943k = true;
        b();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b || drawable == this.f939g;
    }
}
