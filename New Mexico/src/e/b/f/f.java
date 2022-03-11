package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;
import e.b.a.m;
import e.j.k.b;
import e.j.k.h;
/* loaded from: classes.dex */
public class f extends Button implements b, h {
    public final e b;
    public final b0 c;

    /* renamed from: d  reason: collision with root package name */
    public n f944d;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        z0.a(context);
        x0.a(this, getContext());
        e eVar = new e(this);
        this.b = eVar;
        eVar.d(attributeSet, i2);
        b0 b0Var = new b0(this);
        this.c = b0Var;
        b0Var.e(attributeSet, i2);
        b0Var.b();
        getEmojiTextViewHelper().a(attributeSet, i2);
    }

    private n getEmojiTextViewHelper() {
        if (this.f944d == null) {
            this.f944d = new n(this);
        }
        return this.f944d;
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.a) {
            return super.getAutoSizeMaxTextSize();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return Math.round(b0Var.f906i.f928e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b.a) {
            return super.getAutoSizeMinTextSize();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return Math.round(b0Var.f906i.f927d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b.a) {
            return super.getAutoSizeStepGranularity();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return Math.round(b0Var.f906i.c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        b0 b0Var = this.c;
        return b0Var != null ? b0Var.f906i.f929f : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (b.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            return b0Var.f906i.a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m.e.U1(super.getCustomSelectionActionModeCallback());
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
        a1 a1Var = this.c.f905h;
        if (a1Var != null) {
            return a1Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        a1 a1Var = this.c.f905h;
        if (a1Var != null) {
            return a1Var.b;
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b0 b0Var = this.c;
        if (b0Var != null && !b.a) {
            b0Var.f906i.a();
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        b0 b0Var = this.c;
        if (b0Var != null && !b.a && b0Var.d()) {
            this.c.f906i.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b.a.c(z);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (b.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.h(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (b.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.i(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.j(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.b;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.e.Y1(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().b.a.d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().b.a.a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.a.setAllCaps(z);
        }
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

    @Override // e.j.k.h
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.c.k(colorStateList);
        this.c.b();
    }

    @Override // e.j.k.h
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.c.l(mode);
        this.c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.f(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        boolean z = b.a;
        if (z) {
            super.setTextSize(i2, f2);
            return;
        }
        b0 b0Var = this.c;
        if (b0Var != null && !z && !b0Var.d()) {
            b0Var.f906i.f(i2, f2);
        }
    }
}
