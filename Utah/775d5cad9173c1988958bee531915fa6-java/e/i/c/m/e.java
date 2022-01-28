package e.i.c.m;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public final class e extends Drawable.ConstantState {
    public int a;
    public Drawable.ConstantState b;
    public ColorStateList c = null;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f1505d = c.f1499h;

    public e(e eVar) {
        if (eVar != null) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.f1505d = eVar.f1505d;
        }
    }

    public int getChangingConfigurations() {
        int i2 = this.a;
        Drawable.ConstantState constantState = this.b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return new d(this, null);
    }

    public Drawable newDrawable(Resources resources) {
        return new d(this, resources);
    }
}
