package f.b.a.e.t;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import f.b.a.e.v.n;
/* loaded from: classes.dex */
public class a extends Drawable implements n, e.j.c.m.a {
    public b b;

    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {
        public g a;
        public boolean b;

        public b(b bVar) {
            this.a = (g) bVar.a.b.newDrawable();
            this.b = bVar.b;
        }

        public b(g gVar) {
            this.a = gVar;
            this.b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(new b(this), null);
        }
    }

    public a(b bVar, C0099a aVar) {
        this.b = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.b;
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.b.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.b = new b(this.b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.b.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.b.a.setState(iArr)) {
            onStateChange = true;
        }
        boolean b2 = b.b(iArr);
        b bVar = this.b;
        if (bVar.b == b2) {
            return onStateChange;
        }
        bVar.b = b2;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.a.setColorFilter(colorFilter);
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        g gVar = this.b.a;
        gVar.b.a = jVar;
        gVar.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        this.b.a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.b.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.b.a.setTintMode(mode);
    }

    public a(j jVar) {
        this.b = new b(new g(jVar));
    }
}
