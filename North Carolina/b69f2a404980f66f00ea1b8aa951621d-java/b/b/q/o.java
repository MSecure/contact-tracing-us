package b.b.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import b.b.a;
import b.b.k.i;

public class o extends MultiAutoCompleteTextView {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f688d = {16843126};

    /* renamed from: b  reason: collision with root package name */
    public final e f689b;

    /* renamed from: c  reason: collision with root package name */
    public final y f690c;

    /* JADX WARNING: Illegal instructions before constructor call */
    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i = a.autoCompleteTextViewStyle;
        v0.a(context);
        t0.a(this, getContext());
        y0 q = y0.q(getContext(), attributeSet, f688d, i, 0);
        if (q.o(0)) {
            setDropDownBackgroundDrawable(q.g(0));
        }
        q.f759b.recycle();
        e eVar = new e(this);
        this.f689b = eVar;
        eVar.d(attributeSet, i);
        y yVar = new y(this);
        this.f690c = yVar;
        yVar.e(attributeSet, i);
        this.f690c.b();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f689b;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f690c;
        if (yVar != null) {
            yVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f689b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f689b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i.j.E0(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f689b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f689b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(b.b.l.a.a.b(getContext(), i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f689b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f689b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f690c;
        if (yVar != null) {
            yVar.f(context, i);
        }
    }
}
