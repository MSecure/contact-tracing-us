package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;

public class o extends ImageButton {
    public final e b;
    public final p c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f939d;

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        z0.a(context);
        this.f939d = false;
        x0.a(this, getContext());
        e eVar = new e(this);
        this.b = eVar;
        eVar.d(attributeSet, i2);
        p pVar = new p(this);
        this.c = pVar;
        pVar.b(attributeSet, i2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
        p pVar = this.c;
        if (pVar != null) {
            pVar.a();
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

    public ColorStateList getSupportImageTintList() {
        a1 a1Var;
        p pVar = this.c;
        if (pVar == null || (a1Var = pVar.b) == null) {
            return null;
        }
        return a1Var.a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        a1 a1Var;
        p pVar = this.c;
        if (pVar == null || (a1Var = pVar.b) == null) {
            return null;
        }
        return a1Var.b;
    }

    public boolean hasOverlappingRendering() {
        if (!(!(this.c.a.getBackground() instanceof RippleDrawable)) || !super.hasOverlappingRendering()) {
            return false;
        }
        return true;
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

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        p pVar = this.c;
        if (pVar != null) {
            pVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        p pVar = this.c;
        if (!(pVar == null || drawable == null || this.f939d)) {
            pVar.f949d = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        p pVar2 = this.c;
        if (pVar2 != null) {
            pVar2.a();
            if (!this.f939d) {
                p pVar3 = this.c;
                if (pVar3.a.getDrawable() != null) {
                    pVar3.a.getDrawable().setLevel(pVar3.f949d);
                }
            }
        }
    }

    public void setImageLevel(int i2) {
        super.setImageLevel(i2);
        this.f939d = true;
    }

    public void setImageResource(int i2) {
        this.c.c(i2);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        p pVar = this.c;
        if (pVar != null) {
            pVar.a();
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        p pVar = this.c;
        if (pVar != null) {
            pVar.d(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        p pVar = this.c;
        if (pVar != null) {
            pVar.e(mode);
        }
    }
}
