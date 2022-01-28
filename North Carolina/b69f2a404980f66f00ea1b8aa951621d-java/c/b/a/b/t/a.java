package c.b.a.b.t;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import c.b.a.b.d;
import c.b.a.b.f;
import c.b.a.b.h0.e;
import c.b.a.b.h0.g;
import c.b.a.b.h0.i;
import c.b.a.b.h0.j;
import c.b.a.b.k;
import c.b.a.b.l;
import com.google.android.material.card.MaterialCardView;

public class a {
    public static final int[] t = {16842912};
    public static final double u = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f3203a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f3204b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public final g f3205c;

    /* renamed from: d  reason: collision with root package name */
    public final g f3206d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3207e;
    public final int f;
    public int g;
    public Drawable h;
    public Drawable i;
    public ColorStateList j;
    public ColorStateList k;
    public j l;
    public ColorStateList m;
    public Drawable n;
    public LayerDrawable o;
    public g p;
    public g q;
    public boolean r = false;
    public boolean s;

    /* renamed from: c.b.a.b.t.a$a  reason: collision with other inner class name */
    public class C0071a extends InsetDrawable {
        public C0071a(a aVar, Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        public int getMinimumHeight() {
            return -1;
        }

        public int getMinimumWidth() {
            return -1;
        }

        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i2, int i3) {
        this.f3203a = materialCardView;
        g gVar = new g(materialCardView.getContext(), attributeSet, i2, i3);
        this.f3205c = gVar;
        gVar.o(materialCardView.getContext());
        this.f3205c.t(-12303292);
        j jVar = this.f3205c.f2982b.f2987a;
        if (jVar != null) {
            j.b bVar = new j.b(jVar);
            TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, l.CardView, i2, k.CardView);
            if (obtainStyledAttributes.hasValue(l.CardView_cardCornerRadius)) {
                bVar.c(obtainStyledAttributes.getDimension(l.CardView_cardCornerRadius, 0.0f));
            }
            this.f3206d = new g();
            h(bVar.a());
            Resources resources = materialCardView.getResources();
            this.f3207e = resources.getDimensionPixelSize(d.mtrl_card_checked_icon_margin);
            this.f = resources.getDimensionPixelSize(d.mtrl_card_checked_icon_size);
            obtainStyledAttributes.recycle();
            return;
        }
        throw null;
    }

    public final float a() {
        float b2 = b(this.l.f2994a, this.f3205c.m());
        c.b.a.b.h0.d dVar = this.l.f2995b;
        g gVar = this.f3205c;
        float max = Math.max(b2, b(dVar, gVar.f2982b.f2987a.f.a(gVar.i())));
        c.b.a.b.h0.d dVar2 = this.l.f2996c;
        g gVar2 = this.f3205c;
        float b3 = b(dVar2, gVar2.f2982b.f2987a.g.a(gVar2.i()));
        c.b.a.b.h0.d dVar3 = this.l.f2997d;
        g gVar3 = this.f3205c;
        return Math.max(max, Math.max(b3, b(dVar3, gVar3.f2982b.f2987a.h.a(gVar3.i()))));
    }

    public final float b(c.b.a.b.h0.d dVar, float f2) {
        if (dVar instanceof i) {
            return (float) ((1.0d - u) * ((double) f2));
        }
        if (dVar instanceof e) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float c() {
        return this.f3203a.getMaxCardElevation() + (j() ? a() : 0.0f);
    }

    public final float d() {
        return (this.f3203a.getMaxCardElevation() * 1.5f) + (j() ? a() : 0.0f);
    }

    public final Drawable e() {
        if (this.n == null) {
            boolean z = c.b.a.b.f0.a.f2968a;
            this.q = new g(this.l);
            this.n = new RippleDrawable(this.j, null, this.q);
        }
        if (this.o == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.i;
            if (drawable != null) {
                stateListDrawable.addState(t, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.f3206d, stateListDrawable});
            this.o = layerDrawable;
            layerDrawable.setId(2, f.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    public final Drawable f(Drawable drawable) {
        int i2;
        int i3;
        if (0 != 0 || this.f3203a.getUseCompatPadding()) {
            i2 = (int) Math.ceil((double) d());
            i3 = (int) Math.ceil((double) c());
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new C0071a(this, drawable, i3, i2, i3, i2);
    }

    public void g(Drawable drawable) {
        this.i = drawable;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.i = mutate;
            mutate.setTintList(this.k);
        }
        if (this.o != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.i;
            if (drawable2 != null) {
                stateListDrawable.addState(t, drawable2);
            }
            this.o.setDrawableByLayerId(f.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public void h(j jVar) {
        this.l = jVar;
        g gVar = this.f3205c;
        gVar.f2982b.f2987a = jVar;
        gVar.invalidateSelf();
        g gVar2 = this.f3205c;
        gVar2.w = !gVar2.p();
        g gVar3 = this.f3206d;
        if (gVar3 != null) {
            gVar3.f2982b.f2987a = jVar;
            gVar3.invalidateSelf();
        }
        g gVar4 = this.q;
        if (gVar4 != null) {
            gVar4.f2982b.f2987a = jVar;
            gVar4.invalidateSelf();
        }
        g gVar5 = this.p;
        if (gVar5 != null) {
            gVar5.f2982b.f2987a = jVar;
            gVar5.invalidateSelf();
        }
    }

    public final boolean i() {
        return this.f3203a.getPreventCornerOverlap() && !this.f3205c.p();
    }

    public final boolean j() {
        return this.f3203a.getPreventCornerOverlap() && this.f3205c.p() && this.f3203a.getUseCompatPadding();
    }

    public void k() {
        float f2 = 0.0f;
        float a2 = i() || j() ? a() : 0.0f;
        if (this.f3203a.getPreventCornerOverlap() && this.f3203a.getUseCompatPadding()) {
            f2 = (float) ((1.0d - u) * ((double) this.f3203a.getCardViewRadius()));
        }
        int i2 = (int) (a2 - f2);
        MaterialCardView materialCardView = this.f3203a;
        Rect rect = this.f3204b;
        materialCardView.f.set(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
        ((b.d.e.a) CardView.j).e(materialCardView.h);
    }

    public void l() {
        if (!this.r) {
            this.f3203a.setBackgroundInternal(f(this.f3205c));
        }
        this.f3203a.setForeground(f(this.h));
    }

    public final void m() {
        boolean z = c.b.a.b.f0.a.f2968a;
        Drawable drawable = this.n;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.j);
            return;
        }
        g gVar = this.p;
        if (gVar != null) {
            gVar.r(this.j);
        }
    }

    public void n() {
        this.f3206d.v((float) this.g, this.m);
    }
}
