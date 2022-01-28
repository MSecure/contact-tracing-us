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
import android.os.Build;
import android.text.InputFilter;
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
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.R$id;
import e.b.a.m;
import e.i.i.t;
import e.i.i.v;
import e.m.a.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class w0 extends CompoundButton {
    public static final Property<w0, Float> S = new a(Float.class, "thumbPos");
    public static final int[] T = {16842912};
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public final TextPaint I;
    public ColorStateList J;
    public Layout K;
    public Layout L;
    public TransformationMethod M;
    public ObjectAnimator N;
    public final b0 O;
    public n P;
    public b Q;
    public final Rect R;
    public Drawable b;
    public ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f971d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f972e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f973f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f974g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f975h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f976i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f977j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f978k;

    /* renamed from: l  reason: collision with root package name */
    public int f979l;
    public int m;
    public int n;
    public boolean o;
    public CharSequence p;
    public CharSequence q;
    public CharSequence r;
    public CharSequence s;
    public boolean t;
    public int u;
    public int v;
    public float w;
    public float x;
    public VelocityTracker y;
    public int z;

    public class a extends Property<w0, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(w0 w0Var) {
            return Float.valueOf(w0Var.A);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(w0 w0Var, Float f2) {
            w0Var.setThumbPosition(f2.floatValue());
        }
    }

    public static class b extends e.AbstractC0047e {
        public final Reference<w0> a;

        public b(w0 w0Var) {
            this.a = new WeakReference(w0Var);
        }

        @Override // e.m.a.e.AbstractC0047e
        public void a(Throwable th) {
            w0 w0Var = this.a.get();
            if (w0Var != null) {
                w0Var.e();
            }
        }

        @Override // e.m.a.e.AbstractC0047e
        public void b() {
            w0 w0Var = this.a.get();
            if (w0Var != null) {
                w0Var.e();
            }
        }
    }

    public w0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public w0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Typeface typeface;
        int resourceId;
        e.b.d.a aVar = null;
        this.c = null;
        this.f971d = null;
        this.f972e = false;
        this.f973f = false;
        this.f975h = null;
        this.f976i = null;
        this.f977j = false;
        this.f978k = false;
        this.y = VelocityTracker.obtain();
        this.R = new Rect();
        x0.a(this, getContext());
        boolean z2 = true;
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.SwitchCompat;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        c1 c1Var = new c1(context, obtainStyledAttributes);
        v.t(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        Drawable g2 = c1Var.g(R$styleable.SwitchCompat_android_thumb);
        this.b = g2;
        if (g2 != null) {
            g2.setCallback(this);
        }
        Drawable g3 = c1Var.g(R$styleable.SwitchCompat_track);
        this.f974g = g3;
        if (g3 != null) {
            g3.setCallback(this);
        }
        setTextOnInternal(c1Var.n(R$styleable.SwitchCompat_android_textOn));
        setTextOffInternal(c1Var.n(R$styleable.SwitchCompat_android_textOff));
        this.t = c1Var.a(R$styleable.SwitchCompat_showText, true);
        this.f979l = c1Var.f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.m = c1Var.f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.n = c1Var.f(R$styleable.SwitchCompat_switchPadding, 0);
        this.o = c1Var.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList c2 = c1Var.c(R$styleable.SwitchCompat_thumbTint);
        if (c2 != null) {
            this.c = c2;
            this.f972e = true;
        }
        PorterDuff.Mode e2 = i0.e(c1Var.j(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f971d != e2) {
            this.f971d = e2;
            this.f973f = true;
        }
        if (this.f972e || this.f973f) {
            a();
        }
        ColorStateList c3 = c1Var.c(R$styleable.SwitchCompat_trackTint);
        if (c3 != null) {
            this.f975h = c3;
            this.f977j = true;
        }
        PorterDuff.Mode e3 = i0.e(c1Var.j(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f976i != e3) {
            this.f976i = e3;
            this.f978k = true;
        }
        if (this.f977j || this.f978k) {
            b();
        }
        int l2 = c1Var.l(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (l2 != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(l2, R$styleable.TextAppearance);
            int i3 = R$styleable.TextAppearance_android_textColor;
            ColorStateList colorStateList = (!obtainStyledAttributes2.hasValue(i3) || (resourceId = obtainStyledAttributes2.getResourceId(i3, 0)) == 0 || (colorStateList = m.e.f0(context, resourceId)) == null) ? obtainStyledAttributes2.getColorStateList(i3) : colorStateList;
            this.J = colorStateList == null ? getTextColors() : colorStateList;
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
            this.M = obtainStyledAttributes2.getBoolean(R$styleable.TextAppearance_textAllCaps, false) ? new e.b.d.a(getContext()) : aVar;
            setTextOnInternal(this.p);
            setTextOffInternal(this.r);
            obtainStyledAttributes2.recycle();
        }
        b0 b0Var = new b0(this);
        this.O = b0Var;
        b0Var.e(attributeSet, i2);
        c1Var.b.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v = viewConfiguration.getScaledTouchSlop();
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().a(attributeSet, i2);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private n getEmojiTextViewHelper() {
        if (this.P == null) {
            this.P = new n(this);
        }
        return this.P;
    }

    private boolean getTargetCheckedState() {
        return this.A > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((i1.a(this) ? 1.0f - this.A : this.A) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f974g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.b;
        Rect d2 = drawable2 != null ? i0.d(drawable2) : i0.c;
        return ((((this.B - this.D) - rect.left) - rect.right) - d2.left) - d2.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.r = charSequence;
        this.s = c(charSequence);
        this.L = null;
        if (this.t) {
            h();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.p = charSequence;
        this.q = c(charSequence);
        this.K = null;
        if (this.t) {
            h();
        }
    }

    public final void a() {
        Drawable drawable = this.b;
        if (drawable == null) {
            return;
        }
        if (this.f972e || this.f973f) {
            Drawable mutate = m.e.P1(drawable).mutate();
            this.b = mutate;
            if (this.f972e) {
                mutate.setTintList(this.c);
            }
            if (this.f973f) {
                this.b.setTintMode(this.f971d);
            }
            if (this.b.isStateful()) {
                this.b.setState(getDrawableState());
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f974g;
        if (drawable == null) {
            return;
        }
        if (this.f977j || this.f978k) {
            Drawable mutate = m.e.P1(drawable).mutate();
            this.f974g = mutate;
            if (this.f977j) {
                mutate.setTintList(this.f975h);
            }
            if (this.f978k) {
                this.f974g.setTintMode(this.f976i);
            }
            if (this.f974g.isStateful()) {
                this.f974g.setState(getDrawableState());
            }
        }
    }

    public final CharSequence c(CharSequence charSequence) {
        TransformationMethod e2 = getEmojiTextViewHelper().b.a.e(this.M);
        return e2 != null ? e2.getTransformation(charSequence, this) : charSequence;
    }

    public final Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.I;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.R;
        int i4 = this.E;
        int i5 = this.F;
        int i6 = this.G;
        int i7 = this.H;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.b;
        Rect d2 = drawable != null ? i0.d(drawable) : i0.c;
        Drawable drawable2 = this.f974g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i8 = rect.left;
            thumbOffset += i8;
            if (d2 != null) {
                int i9 = d2.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = d2.top;
                int i11 = rect.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = d2.right;
                int i13 = rect.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = d2.bottom;
                int i15 = rect.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f974g.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f974g.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i16 = thumbOffset - rect.left;
            int i17 = thumbOffset + this.D + rect.right;
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
        Drawable drawable2 = this.f974g;
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
        Drawable drawable2 = this.f974g;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public void e() {
        setTextOnInternal(this.p);
        setTextOffInternal(this.r);
        requestLayout();
    }

    public final void f() {
        if (Build.VERSION.SDK_INT >= 30) {
            Object obj = this.r;
            if (obj == null) {
                obj = getResources().getString(R$string.abc_capital_off);
            }
            AtomicInteger atomicInteger = v.a;
            new t(R$id.tag_state_description, CharSequence.class, 64, 30).e(this, obj);
        }
    }

    public final void g() {
        if (Build.VERSION.SDK_INT >= 30) {
            Object obj = this.p;
            if (obj == null) {
                obj = getResources().getString(R$string.abc_capital_on);
            }
            AtomicInteger atomicInteger = v.a;
            new t(R$id.tag_state_description, CharSequence.class, 64, 30).e(this, obj);
        }
    }

    public int getCompoundPaddingLeft() {
        if (!i1.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (i1.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m.e.M1(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.t;
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
        return this.r;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.b;
    }

    public int getThumbTextPadding() {
        return this.f979l;
    }

    public ColorStateList getThumbTintList() {
        return this.c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f971d;
    }

    public Drawable getTrackDrawable() {
        return this.f974g;
    }

    public ColorStateList getTrackTintList() {
        return this.f975h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f976i;
    }

    public final void h() {
        if (this.Q == null && this.P.b.a.b() && e.c()) {
            e a2 = e.a();
            int b2 = a2.b();
            if (b2 == 3 || b2 == 0) {
                b bVar = new b(this);
                this.Q = bVar;
                a2.j(bVar);
            }
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f974g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.N.end();
            this.N = null;
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, T);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.R;
        Drawable drawable = this.f974g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.F;
        int i4 = this.H;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.b;
        if (drawable != null) {
            if (!this.o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d2 = i0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d2.left;
                rect.right -= d2.right;
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
        Layout layout = getTargetCheckedState() ? this.K : this.L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.J;
            if (colorStateList != null) {
                this.I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.I.drawableState = drawableState;
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
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.p : this.r;
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
            Rect rect = this.R;
            Drawable drawable = this.f974g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d2 = i0.d(this.b);
            i6 = Math.max(0, d2.left - rect.left);
            i11 = Math.max(0, d2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (i1.a(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.B + i8) - i6) - i11;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i11;
            i8 = (i7 - this.B) + i6 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = getPaddingTop();
            int i12 = this.C;
            int height = (((getHeight() + paddingTop) - getPaddingBottom()) / 2) - (i12 / 2);
            i9 = i12 + height;
            i10 = height;
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i9 = this.C + i10;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.C;
        }
        this.E = i8;
        this.F = i10;
        this.H = i9;
        this.G = i7;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (this.t) {
            if (this.K == null) {
                this.K = d(this.q);
            }
            if (this.L == null) {
                this.L = d(this.s);
            }
        }
        Rect rect = this.R;
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
        if (this.t) {
            i6 = (this.f979l * 2) + Math.max(this.K.getWidth(), this.L.getWidth());
        } else {
            i6 = 0;
        }
        this.D = Math.max(i6, i5);
        Drawable drawable2 = this.f974g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i7 = this.f974g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i8 = rect.left;
        int i9 = rect.right;
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            Rect d2 = i0.d(drawable3);
            i8 = Math.max(i8, d2.left);
            i9 = Math.max(i9, d2.right);
        }
        int max = Math.max(this.m, (this.D * 2) + i8 + i9);
        int max2 = Math.max(i7, i4);
        this.B = max;
        this.C = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.r;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0 != 3) goto L_0x0153;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        this.y.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = false;
        if (actionMasked != 0) {
            float f2 = 0.0f;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.u;
                    if (i2 == 1) {
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.w) > ((float) this.v) || Math.abs(y2 - this.x) > ((float) this.v)) {
                            this.u = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.w = x2;
                            this.x = y2;
                            return true;
                        }
                    } else if (i2 == 2) {
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f3 = x3 - this.w;
                        float f4 = thumbScrollRange != 0 ? f3 / ((float) thumbScrollRange) : f3 > 0.0f ? 1.0f : -1.0f;
                        if (i1.a(this)) {
                            f4 = -f4;
                        }
                        float f5 = this.A;
                        float f6 = f4 + f5;
                        if (f6 >= 0.0f) {
                            f2 = f6 > 1.0f ? 1.0f : f6;
                        }
                        if (f2 != f5) {
                            this.w = x3;
                            setThumbPosition(f2);
                        }
                        return true;
                    }
                }
            }
            if (this.u == 2) {
                this.u = 0;
                boolean z4 = motionEvent.getAction() == 1 && isEnabled();
                boolean isChecked = isChecked();
                if (z4) {
                    this.y.computeCurrentVelocity(1000);
                    float xVelocity = this.y.getXVelocity();
                    z2 = Math.abs(xVelocity) > ((float) this.z) ? !i1.a(this) ? xVelocity > 0.0f : xVelocity < 0.0f : getTargetCheckedState();
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
            this.u = 0;
            this.y.clear();
        } else {
            float x4 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (isEnabled()) {
                if (this.b != null) {
                    int thumbOffset = getThumbOffset();
                    this.b.getPadding(this.R);
                    int i3 = this.F;
                    int i4 = this.v;
                    int i5 = i3 - i4;
                    int i6 = (this.E + thumbOffset) - i4;
                    Rect rect = this.R;
                    int i7 = this.D + i6 + rect.left + rect.right + i4;
                    int i8 = this.H + i4;
                    if (x4 > ((float) i6) && x4 < ((float) i7) && y3 > ((float) i5) && y3 < ((float) i8)) {
                        z3 = true;
                    }
                }
                if (z3) {
                    this.u = 1;
                    this.w = x4;
                    this.x = y3;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b.a.c(z2);
    }

    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean isChecked = isChecked();
        if (isChecked) {
            g();
        } else {
            f();
        }
        float f2 = 1.0f;
        if (getWindowToken() != null) {
            AtomicInteger atomicInteger = v.a;
            if (v.g.c(this)) {
                if (!isChecked) {
                    f2 = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, S, f2);
                this.N = ofFloat;
                ofFloat.setDuration(250L);
                this.N.setAutoCancel(true);
                this.N.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (!isChecked) {
            f2 = 0.0f;
        }
        setThumbPosition(f2);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.e.Q1(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().b.a.d(z2);
        setTextOnInternal(this.p);
        setTextOffInternal(this.r);
        requestLayout();
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().b.a.a(inputFilterArr));
    }

    public void setShowText(boolean z2) {
        if (this.t != z2) {
            this.t = z2;
            requestLayout();
            if (z2) {
                h();
            }
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
        if ((this.I.getTypeface() != null && !this.I.getTypeface().equals(typeface)) || (this.I.getTypeface() == null && typeface != null)) {
            this.I.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            f();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            g();
        }
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
        this.A = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(m.e.h0(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.f979l = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.c = colorStateList;
        this.f972e = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f971d = mode;
        this.f973f = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f974g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f974g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(m.e.h0(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f975h = colorStateList;
        this.f977j = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f976i = mode;
        this.f978k = true;
        b();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b || drawable == this.f974g;
    }
}
