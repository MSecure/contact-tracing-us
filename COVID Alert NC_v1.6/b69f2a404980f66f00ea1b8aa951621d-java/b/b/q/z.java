package b.b.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import b.b.k.i;
import b.b.l.a.a;
import b.i.f.d;
import b.i.j.b;
import b.i.m.b;
import b.i.m.e;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class z extends TextView implements e, b {

    /* renamed from: b  reason: collision with root package name */
    public final e f761b;

    /* renamed from: c  reason: collision with root package name */
    public final y f762c;

    /* renamed from: d  reason: collision with root package name */
    public final x f763d;

    /* renamed from: e  reason: collision with root package name */
    public Future<b.i.j.b> f764e;

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        v0.a(context);
        t0.a(this, getContext());
        e eVar = new e(this);
        this.f761b = eVar;
        eVar.d(attributeSet, i);
        y yVar = new y(this);
        this.f762c = yVar;
        yVar.e(attributeSet, i);
        this.f762c.b();
        this.f763d = new x(this);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f761b;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f1217a) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f762c;
        if (yVar != null) {
            return Math.round(yVar.i.f589e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f1217a) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f762c;
        if (yVar != null) {
            return Math.round(yVar.i.f588d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f1217a) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f762c;
        if (yVar != null) {
            return Math.round(yVar.i.f587c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f1217a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f762c;
        return yVar != null ? yVar.i.f : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.f1217a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f762c;
        if (yVar != null) {
            return yVar.i.f585a;
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f761b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f761b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        w0 w0Var = this.f762c.h;
        if (w0Var != null) {
            return w0Var.f743a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        w0 w0Var = this.f762c.h;
        if (w0Var != null) {
            return w0Var.f744b;
        }
        return null;
    }

    public CharSequence getText() {
        Future<b.i.j.b> future = this.f764e;
        if (future != null) {
            try {
                this.f764e = null;
                i.j.Z0(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        x xVar;
        return (Build.VERSION.SDK_INT >= 28 || (xVar = this.f763d) == null) ? super.getTextClassifier() : xVar.a();
    }

    public b.a getTextMetricsParamsCompat() {
        return i.j.p0(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i.j.E0(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        y yVar = this.f762c;
        if (yVar != null && !b.i.m.b.f1217a) {
            yVar.i.a();
        }
    }

    public void onMeasure(int i, int i2) {
        Future<b.i.j.b> future = this.f764e;
        if (future != null) {
            try {
                this.f764e = null;
                i.j.Z0(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i2);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        y yVar = this.f762c;
        if (yVar != null && !b.i.m.b.f1217a && yVar.d()) {
            this.f762c.i.a();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.i.m.b.f1217a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.g(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.i.m.b.f1217a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.h(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.i.m.b.f1217a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.i(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f761b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f761b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.b();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = a.b(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = a.b(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.b();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.j.n1(this, callback));
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            i.j.V0(this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            i.j.W0(this, i);
        }
    }

    public void setLineHeight(int i) {
        i.j.X0(this, i);
    }

    public void setPrecomputedText(b.i.j.b bVar) {
        i.j.Z0(this, bVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f761b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f761b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // b.i.m.e
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f762c.j(colorStateList);
        this.f762c.b();
    }

    @Override // b.i.m.e
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f762c.k(mode);
        this.f762c.b();
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.f(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.f763d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            xVar.f748b = textClassifier;
        }
    }

    public void setTextFuture(Future<b.i.j.b> future) {
        this.f764e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        TextDirectionHeuristic textDirectionHeuristic = aVar.f1120b;
        int i = 1;
        if (!(textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i = 6;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(aVar.f1119a);
        setBreakStrategy(aVar.f1121c);
        setHyphenationFrequency(aVar.f1122d);
    }

    public void setTextSize(int i, float f) {
        boolean z = b.i.m.b.f1217a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        y yVar = this.f762c;
        if (yVar != null && !z && !yVar.d()) {
            yVar.i.f(i, f);
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        Typeface a2 = (typeface == null || i <= 0) ? null : d.a(getContext(), typeface, i);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f762c;
        if (yVar != null) {
            yVar.b();
        }
    }
}
