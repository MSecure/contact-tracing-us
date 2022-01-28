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
    public final MaterialCardView f4520a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f4521b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public final g f4522c;

    /* renamed from: d  reason: collision with root package name */
    public final g f4523d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4524e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4525f;

    /* renamed from: g  reason: collision with root package name */
    public int f4526g;
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
    public class C0080a extends InsetDrawable {
        public C0080a(a aVar, Drawable drawable, int i, int i2, int i3, int i4) {
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
        this.f4520a = materialCardView;
        g gVar = new g(materialCardView.getContext(), attributeSet, i2, i3);
        this.f4522c = gVar;
        gVar.o(materialCardView.getContext());
        this.f4522c.t(-12303292);
        j jVar = this.f4522c.f4261b.f4268a;
        if (jVar != null) {
            j.b bVar = new j.b(jVar);
            TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, l.CardView, i2, k.CardView);
            if (obtainStyledAttributes.hasValue(l.CardView_cardCornerRadius)) {
                bVar.c(obtainStyledAttributes.getDimension(l.CardView_cardCornerRadius, 0.0f));
            }
            this.f4523d = new g();
            h(bVar.a());
            Resources resources = materialCardView.getResources();
            this.f4524e = resources.getDimensionPixelSize(d.mtrl_card_checked_icon_margin);
            this.f4525f = resources.getDimensionPixelSize(d.mtrl_card_checked_icon_size);
            obtainStyledAttributes.recycle();
            return;
        }
        throw null;
    }

    public final float a() {
        float b2 = b(this.l.f4277a, this.f4522c.m());
        c.b.a.b.h0.d dVar = this.l.f4278b;
        g gVar = this.f4522c;
        float max = Math.max(b2, b(dVar, gVar.f4261b.f4268a.f4282f.a(gVar.i())));
        c.b.a.b.h0.d dVar2 = this.l.f4279c;
        g gVar2 = this.f4522c;
        float b3 = b(dVar2, gVar2.f4261b.f4268a.f4283g.a(gVar2.i()));
        c.b.a.b.h0.d dVar3 = this.l.f4280d;
        g gVar3 = this.f4522c;
        return Math.max(max, Math.max(b3, b(dVar3, gVar3.f4261b.f4268a.h.a(gVar3.i()))));
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
        return this.f4520a.getMaxCardElevation() + (j() ? a() : 0.0f);
    }

    public final float d() {
        return (this.f4520a.getMaxCardElevation() * 1.5f) + (j() ? a() : 0.0f);
    }

    public final Drawable e() {
        if (this.n == null) {
            boolean z = c.b.a.b.f0.a.f4243a;
            this.q = new g(this.l);
            this.n = new RippleDrawable(this.j, null, this.q);
        }
        if (this.o == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.i;
            if (drawable != null) {
                stateListDrawable.addState(t, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.f4523d, stateListDrawable});
            this.o = layerDrawable;
            layerDrawable.setId(2, f.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    public final Drawable f(Drawable drawable) {
        int i2;
        int i3;
        if (0 != 0 || this.f4520a.getUseCompatPadding()) {
            i2 = (int) Math.ceil((double) d());
            i3 = (int) Math.ceil((double) c());
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new C0080a(this, drawable, i3, i2, i3, i2);
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
        g gVar = this.f4522c;
        gVar.f4261b.f4268a = jVar;
        gVar.invalidateSelf();
        g gVar2 = this.f4522c;
        gVar2.w = !gVar2.p();
        g gVar3 = this.f4523d;
        if (gVar3 != null) {
            gVar3.f4261b.f4268a = jVar;
            gVar3.invalidateSelf();
        }
        g gVar4 = this.q;
        if (gVar4 != null) {
            gVar4.f4261b.f4268a = jVar;
            gVar4.invalidateSelf();
        }
        g gVar5 = this.p;
        if (gVar5 != null) {
            gVar5.f4261b.f4268a = jVar;
            gVar5.invalidateSelf();
        }
    }

    public final boolean i() {
        return this.f4520a.getPreventCornerOverlap() && !this.f4522c.p();
    }

    public final boolean j() {
        return this.f4520a.getPreventCornerOverlap() && this.f4522c.p() && this.f4520a.getUseCompatPadding();
    }

    public void k() {
        float f2 = 0.0f;
        float a2 = i() || j() ? a() : 0.0f;
        if (this.f4520a.getPreventCornerOverlap() && this.f4520a.getUseCompatPadding()) {
            f2 = (float) ((1.0d - u) * ((double) this.f4520a.getCardViewRadius()));
        }
        int i2 = (int) (a2 - f2);
        MaterialCardView materialCardView = this.f4520a;
        Rect rect = this.f4521b;
        materialCardView.f159f.set(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
        ((b.d.e.a) CardView.j).e(materialCardView.h);
    }

    public void l() {
        if (!this.r) {
            this.f4520a.setBackgroundInternal(f(this.f4522c));
        }
        this.f4520a.setForeground(f(this.h));
    }

    public final void m() {
        boolean z = c.b.a.b.f0.a.f4243a;
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
        this.f4523d.v((float) this.f4526g, this.m);
    }
}
