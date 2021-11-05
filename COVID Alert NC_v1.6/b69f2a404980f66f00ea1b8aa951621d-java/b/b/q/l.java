package b.b.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import b.b.a;

public class l extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    public final e f677b;

    /* renamed from: c  reason: collision with root package name */
    public final m f678c;

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        v0.a(context);
        t0.a(this, getContext());
        e eVar = new e(this);
        this.f677b = eVar;
        eVar.d(attributeSet, i);
        m mVar = new m(this);
        this.f678c = mVar;
        mVar.b(attributeSet, i);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f677b;
        if (eVar != null) {
            eVar.a();
        }
        m mVar = this.f678c;
        if (mVar != null) {
            mVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f677b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f677b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        w0 w0Var;
        m mVar = this.f678c;
        if (mVar == null || (w0Var = mVar.f680b) == null) {
            return null;
        }
        return w0Var.f743a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        w0 w0Var;
        m mVar = this.f678c;
        if (mVar == null || (w0Var = mVar.f680b) == null) {
            return null;
        }
        return w0Var.f744b;
    }

    public boolean hasOverlappingRendering() {
        if (!(!(this.f678c.f679a.getBackground() instanceof RippleDrawable)) || !super.hasOverlappingRendering()) {
            return false;
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f677b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f677b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m mVar = this.f678c;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.f678c;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setImageResource(int i) {
        this.f678c.c(i);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.f678c;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f677b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f677b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        m mVar = this.f678c;
        if (mVar != null) {
            mVar.d(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        m mVar = this.f678c;
        if (mVar != null) {
            mVar.e(mode);
        }
    }
}
