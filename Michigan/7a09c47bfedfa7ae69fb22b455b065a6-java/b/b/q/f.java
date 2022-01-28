package b.b.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import b.b.a;
import b.b.k.i;
import b.i.m.b;
import b.i.m.e;

public class f extends Button implements b, e {

    /* renamed from: b  reason: collision with root package name */
    public final e f830b;

    /* renamed from: c  reason: collision with root package name */
    public final y f831c;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        v0.a(context);
        t0.a(this, getContext());
        e eVar = new e(this);
        this.f830b = eVar;
        eVar.d(attributeSet, i);
        y yVar = new y(this);
        this.f831c = yVar;
        yVar.e(attributeSet, i);
        this.f831c.b();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f830b;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f831c;
        if (yVar != null) {
            yVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f1935a) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f831c;
        if (yVar != null) {
            return Math.round(yVar.i.f781e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f1935a) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f831c;
        if (yVar != null) {
            return Math.round(yVar.i.f780d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f1935a) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f831c;
        if (yVar != null) {
            return Math.round(yVar.i.f779c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f1935a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f831c;
        return yVar != null ? yVar.i.f782f : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.f1935a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f831c;
        if (yVar != null) {
            return yVar.i.f777a;
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f830b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f830b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        w0 w0Var = this.f831c.h;
        if (w0Var != null) {
            return w0Var.f968a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        w0 w0Var = this.f831c.h;
        if (w0Var != null) {
            return w0Var.f969b;
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        y yVar = this.f831c;
        if (yVar != null && !b.f1935a) {
            yVar.i.a();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        y yVar = this.f831c;
        if (yVar != null && !b.f1935a && yVar.d()) {
            this.f831c.i.a();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.f1935a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        y yVar = this.f831c;
        if (yVar != null) {
            yVar.g(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.f1935a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        y yVar = this.f831c;
        if (yVar != null) {
            yVar.h(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.f1935a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        y yVar = this.f831c;
        if (yVar != null) {
            yVar.i(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f830b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f830b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.j.m0(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        y yVar = this.f831c;
        if (yVar != null) {
            yVar.f974a.setAllCaps(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f830b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f830b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // b.i.m.e
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f831c.j(colorStateList);
        this.f831c.b();
    }

    @Override // b.i.m.e
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f831c.k(mode);
        this.f831c.b();
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f831c;
        if (yVar != null) {
            yVar.f(context, i);
        }
    }

    public void setTextSize(int i, float f2) {
        boolean z = b.f1935a;
        if (z) {
            super.setTextSize(i, f2);
            return;
        }
        y yVar = this.f831c;
        if (yVar != null && !z && !yVar.d()) {
            yVar.i.f(i, f2);
        }
    }
}
