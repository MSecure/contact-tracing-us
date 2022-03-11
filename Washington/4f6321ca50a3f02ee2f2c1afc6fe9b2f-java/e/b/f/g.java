package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R$attr;
import e.b.b.a.a;

public class g extends CheckBox {
    public final i b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final y f884d;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        v0.a(context);
        t0.a(this, getContext());
        i iVar = new i(this);
        this.b = iVar;
        iVar.b(attributeSet, i2);
        e eVar = new e(this);
        this.c = eVar;
        eVar.d(attributeSet, i2);
        y yVar = new y(this);
        this.f884d = yVar;
        yVar.e(attributeSet, i2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.c;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f884d;
        if (yVar != null) {
            yVar.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.b;
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.c;
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.c;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.c;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(a.b(getContext(), i2));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.b;
        if (iVar == null) {
            return;
        }
        if (iVar.f894f) {
            iVar.f894f = false;
            return;
        }
        iVar.f894f = true;
        iVar.a();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.b = colorStateList;
            iVar.f892d = true;
            iVar.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.c = mode;
            iVar.f893e = true;
            iVar.a();
        }
    }
}
