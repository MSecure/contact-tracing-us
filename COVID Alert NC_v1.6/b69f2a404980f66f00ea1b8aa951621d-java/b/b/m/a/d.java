package b.b.m.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import b.b.m.a.b;

@SuppressLint({"RestrictedAPI"})
public class d extends b {
    public a n;
    public boolean o;

    public static class a extends b.c {
        public int[][] J;

        public a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[this.g.length][];
            }
        }

        @Override // b.b.m.a.b.c
        public void e() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        public int g(int[] iArr) {
            int[][] iArr2 = this.J;
            int i = this.h;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new d(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    public d(a aVar) {
    }

    public d(a aVar, Resources resources) {
        f(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // b.b.m.a.b
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // b.b.m.a.b
    public void f(b.c cVar) {
        super.f(cVar);
        if (cVar instanceof a) {
            this.n = (a) cVar;
        }
    }

    /* renamed from: g */
    public a b() {
        return new a(this.n, this, null);
    }

    public boolean isStateful() {
        return true;
    }

    @Override // b.b.m.a.b
    public Drawable mutate() {
        if (!this.o) {
            super.mutate();
            if (this == this) {
                this.n.e();
                this.o = true;
            }
        }
        return this;
    }

    @Override // b.b.m.a.b
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int g = this.n.g(iArr);
        if (g < 0) {
            g = this.n.g(StateSet.WILD_CARD);
        }
        return e(g) || onStateChange;
    }
}
