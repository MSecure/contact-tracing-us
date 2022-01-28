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

public class a extends Drawable implements n, e.i.c.m.a {
    public b b;

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

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new a(new b(this), null);
        }
    }

    public a(b bVar, C0097a aVar) {
        this.b = bVar;
    }

    public void draw(Canvas canvas) {
        b bVar = this.b;
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.b;
    }

    public int getOpacity() {
        return this.b.a.getOpacity();
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        this.b = new b(this.b);
        return this;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.b.a.setBounds(rect);
    }

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

    public void setAlpha(int i2) {
        this.b.a.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.a.setColorFilter(colorFilter);
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        g gVar = this.b.a;
        gVar.b.a = jVar;
        gVar.invalidateSelf();
    }

    public void setTint(int i2) {
        this.b.a.setTint(i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.b.a.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.b.a.setTintMode(mode);
    }

    public a(j jVar) {
        this.b = new b(new g(jVar));
    }
}
