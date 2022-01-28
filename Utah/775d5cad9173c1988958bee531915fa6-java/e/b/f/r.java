package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import e.b.a.m;

public class r extends MultiAutoCompleteTextView {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f951e = {16843126};
    public final e b;
    public final b0 c;

    /* renamed from: d  reason: collision with root package name */
    public final m f952d;

    /* JADX WARNING: Illegal instructions before constructor call */
    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.autoCompleteTextViewStyle;
        z0.a(context);
        x0.a(this, getContext());
        c1 q = c1.q(getContext(), attributeSet, f951e, i2, 0);
        if (q.o(0)) {
            setDropDownBackgroundDrawable(q.g(0));
        }
        q.b.recycle();
        e eVar = new e(this);
        this.b = eVar;
        eVar.d(attributeSet, i2);
        b0 b0Var = new b0(this);
        this.c = b0Var;
        b0Var.e(attributeSet, i2);
        b0Var.b();
        m mVar = new m(this);
        this.f952d = mVar;
        mVar.b(attributeSet, i2);
        mVar.a();
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

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        m.e.Y0(onCreateInputConnection, editorInfo, this);
        return this.f952d.c(onCreateInputConnection, editorInfo);
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

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(m.e.h0(getContext(), i2));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f952d.b.a.c(z);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f952d.b.a.a(keyListener));
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

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.f(context, i2);
        }
    }
}
