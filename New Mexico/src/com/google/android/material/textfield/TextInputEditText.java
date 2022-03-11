package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.f.l;
import f.b.a.e.q.k;
import f.b.a.e.z.a.a;
import java.util.Locale;
/* loaded from: classes.dex */
public class TextInputEditText extends l {

    /* renamed from: g */
    public final Rect f614g = new Rect();

    /* renamed from: h */
    public boolean f615h;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public TextInputEditText(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, r6, 0), attributeSet, r6);
        int i2 = R$attr.editTextStyle;
        int[] iArr = R$styleable.TextInputEditText;
        int i3 = R$style.Widget_Design_TextInputEditText;
        k.a(context, attributeSet, i2, i3);
        k.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        setTextInputLayoutFocusedRectEnabled(obtainStyledAttributes.getBoolean(R$styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        obtainStyledAttributes.recycle();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f615h && rect != null) {
            textInputLayout.getFocusedRect(this.f614g);
            rect.bottom = this.f614g.bottom;
        }
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout == null || !this.f615h || rect == null)) {
            textInputLayout.getGlobalVisibleRect(this.f614g, point);
            rect.bottom = this.f614g.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.F) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.F && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // e.b.f.l, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            Editable text = getText();
            CharSequence hint = textInputLayout.getHint();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            setLabelFor(R$id.textinput_helper_text);
            String str = "";
            String charSequence = z2 ? hint.toString() : str;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append((Object) text);
                if (!TextUtils.isEmpty(charSequence)) {
                    str = f.a.a.a.a.x(", ", charSequence);
                }
                sb.append(str);
                str = sb.toString();
            } else if (!TextUtils.isEmpty(charSequence)) {
                str = charSequence;
            }
            accessibilityNodeInfo.setText(str);
        }
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f615h) {
            this.f614g.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R$dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f614g, true);
        }
        return requestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.f615h = z;
    }
}
