package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import e.b.a.m;
import e.i.c.e;
import e.i.c.l;
import e.i.g.b;
import e.i.j.b;
import e.i.j.h;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class d0 extends TextView implements h, b {
    public final e b;
    public final b0 c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f855d;

    /* renamed from: e  reason: collision with root package name */
    public n f856e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f857f;

    /* renamed from: g  reason: collision with root package name */
    public Future<e.i.g.b> f858g;

    public d0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        z0.a(context);
        this.f857f = false;
        x0.a(this, getContext());
        e eVar = new e(this);
        this.b = eVar;
        eVar.d(attributeSet, i2);
        b0 b0Var = new b0(this);
        this.c = b0Var;
        b0Var.e(attributeSet, i2);
        b0Var.b();
        this.f855d = new a0(this);
        getEmojiTextViewHelper().a(attributeSet, i2);
    }

    private n getEmojiTextViewHelper() {
        if (this.f856e == null) {
            this.f856e = new n(this);
        }
        return this.f856e;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.a) {
            return super.getAutoSizeMaxTextSize();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return Math.round(b0Var.f842i.f864e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.a) {
            return super.getAutoSizeMinTextSize();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return Math.round(b0Var.f842i.f863d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.a) {
            return super.getAutoSizeStepGranularity();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return Math.round(b0Var.f842i.c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        b0 b0Var = this.c;
        return b0Var != null ? b0Var.f842i.f865f : new int[0];
    }

    public int getAutoSizeTextType() {
        if (b.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return b0Var.f842i.a;
        }
        return 0;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m.e.M1(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        a1 a1Var = this.c.f841h;
        if (a1Var != null) {
            return a1Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        a1 a1Var = this.c.f841h;
        if (a1Var != null) {
            return a1Var.b;
        }
        return null;
    }

    public CharSequence getText() {
        Future<e.i.g.b> future = this.f858g;
        if (future != null) {
            try {
                this.f858g = null;
                m.e.u1(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        a0 a0Var;
        return (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f855d) == null) ? super.getTextClassifier() : a0Var.a();
    }

    public b.a getTextMetricsParamsCompat() {
        return m.e.C0(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.c.g(this, onCreateInputConnection, editorInfo);
        m.e.Y0(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b0 b0Var = this.c;
        if (b0Var != null && !e.i.j.b.a) {
            b0Var.f842i.a();
        }
    }

    public void onMeasure(int i2, int i3) {
        Future<e.i.g.b> future = this.f858g;
        if (future != null) {
            try {
                this.f858g = null;
                m.e.u1(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i2, i3);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        b0 b0Var = this.c;
        if (b0Var != null && !e.i.j.b.a && b0Var.d()) {
            this.c.f842i.a();
        }
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b.a.c(z);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (e.i.j.b.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.h(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (e.i.j.b.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.i(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (e.i.j.b.a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.j(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.b;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable h0 = i2 != 0 ? m.e.h0(context, i2) : null;
        Drawable h02 = i3 != 0 ? m.e.h0(context, i3) : null;
        Drawable h03 = i4 != 0 ? m.e.h0(context, i4) : null;
        if (i5 != 0) {
            drawable = m.e.h0(context, i5);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(h0, h02, h03, drawable);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable h0 = i2 != 0 ? m.e.h0(context, i2) : null;
        Drawable h02 = i3 != 0 ? m.e.h0(context, i3) : null;
        Drawable h03 = i4 != 0 ? m.e.h0(context, i4) : null;
        if (i5 != 0) {
            drawable = m.e.h0(context, i5);
        }
        setCompoundDrawablesWithIntrinsicBounds(h0, h02, h03, drawable);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.e.Q1(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().b.a.d(z);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().b.a.a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            m.e.p1(this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            m.e.q1(this, i2);
        }
    }

    public void setLineHeight(int i2) {
        m.e.s1(this, i2);
    }

    public void setPrecomputedText(e.i.g.b bVar) {
        m.e.u1(this, bVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // e.i.j.h
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.c.k(colorStateList);
        this.c.b();
    }

    @Override // e.i.j.h
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.c.l(mode);
        this.c.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.f(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        a0 a0Var;
        if (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f855d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            a0Var.b = textClassifier;
        }
    }

    public void setTextFuture(Future<e.i.g.b> future) {
        this.f858g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        int i2 = Build.VERSION.SDK_INT;
        TextDirectionHeuristic textDirectionHeuristic = aVar.b;
        int i3 = 1;
        if (!(textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                i3 = 2;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                i3 = 3;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                i3 = 4;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                i3 = 5;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i3 = 6;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i3 = 7;
            }
        }
        setTextDirection(i3);
        if (i2 < 23) {
            float textScaleX = aVar.a.getTextScaleX();
            getPaint().set(aVar.a);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
            return;
        }
        getPaint().set(aVar.a);
        setBreakStrategy(aVar.c);
        setHyphenationFrequency(aVar.f1521d);
    }

    public void setTextSize(int i2, float f2) {
        boolean z = e.i.j.b.a;
        if (z) {
            super.setTextSize(i2, f2);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null && !z && !b0Var.d()) {
            b0Var.f842i.f(i2, f2);
        }
    }

    public void setTypeface(Typeface typeface, int i2) {
        if (!this.f857f) {
            Typeface typeface2 = null;
            if (typeface != null && i2 > 0) {
                Context context = getContext();
                l lVar = e.a;
                if (context != null) {
                    typeface2 = Typeface.create(typeface, i2);
                } else {
                    throw new IllegalArgumentException("Context cannot be null");
                }
            }
            this.f857f = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i2);
            } finally {
                this.f857f = false;
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }
}
