package b.b.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import b.b.l.a.a;

public class r extends RadioButton {

    /* renamed from: b  reason: collision with root package name */
    public final i f705b;

    /* renamed from: c  reason: collision with root package name */
    public final e f706c;

    /* renamed from: d  reason: collision with root package name */
    public final y f707d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        v0.a(context);
        t0.a(this, getContext());
        i iVar = new i(this);
        this.f705b = iVar;
        iVar.b(attributeSet, i);
        e eVar = new e(this);
        this.f706c = eVar;
        eVar.d(attributeSet, i);
        y yVar = new y(this);
        this.f707d = yVar;
        yVar.e(attributeSet, i);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f706c;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f707d;
        if (yVar != null) {
            yVar.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f705b;
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f706c;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f706c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f705b;
        if (iVar != null) {
            return iVar.f649b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f705b;
        if (iVar != null) {
            return iVar.f650c;
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f706c;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f706c;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(a.b(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f705b;
        if (iVar == null) {
            return;
        }
        if (iVar.f) {
            iVar.f = false;
            return;
        }
        iVar.f = true;
        iVar.a();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f706c;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f706c;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f705b;
        if (iVar != null) {
            iVar.f649b = colorStateList;
            iVar.f651d = true;
            iVar.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f705b;
        if (iVar != null) {
            iVar.f650c = mode;
            iVar.f652e = true;
            iVar.a();
        }
    }
}
