package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.R$attr;
import e.b.a.m;
import e.b.b.a.a;

public class d extends AutoCompleteTextView {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f874d = {16843126};
    public final e b;
    public final y c;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        v0.a(context);
        t0.a(this, getContext());
        y0 q = y0.q(getContext(), attributeSet, f874d, i2, 0);
        if (q.o(0)) {
            setDropDownBackgroundDrawable(q.g(0));
        }
        q.b.recycle();
        e eVar = new e(this);
        this.b = eVar;
        eVar.d(attributeSet, i2);
        y yVar = new y(this);
        this.c = yVar;
        yVar.e(attributeSet, i2);
        yVar.b();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.c;
        if (yVar != null) {
            yVar.b();
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
        m.h.F0(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.h.x1(this, callback));
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.b(getContext(), i2));
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
        y yVar = this.c;
        if (yVar != null) {
            yVar.f(context, i2);
        }
    }
}
