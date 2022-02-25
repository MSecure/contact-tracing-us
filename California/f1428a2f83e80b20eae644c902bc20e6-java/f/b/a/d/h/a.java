package f.b.a.d.h;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import e.b.a.m;
import e.d.a.b;
import f.b.a.d.v.d;
import f.b.a.d.v.e;
import f.b.a.d.v.g;
import f.b.a.d.v.i;
import f.b.a.d.v.j;
import java.util.Objects;

public class a {
    public static final int[] t = {16842912};
    public static final double u = Math.cos(Math.toRadians(45.0d));
    public final MaterialCardView a;
    public final Rect b = new Rect();
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final g f2597d;

    /* renamed from: e  reason: collision with root package name */
    public int f2598e;

    /* renamed from: f  reason: collision with root package name */
    public int f2599f;

    /* renamed from: g  reason: collision with root package name */
    public int f2600g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f2601h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f2602i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f2603j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f2604k;

    /* renamed from: l  reason: collision with root package name */
    public j f2605l;
    public ColorStateList m;
    public Drawable n;
    public LayerDrawable o;
    public g p;
    public g q;
    public boolean r = false;
    public boolean s;

    /* renamed from: f.b.a.d.h.a$a  reason: collision with other inner class name */
    public class C0090a extends InsetDrawable {
        public C0090a(a aVar, Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
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
        this.a = materialCardView;
        g gVar = new g(j.b(materialCardView.getContext(), attributeSet, i2, i3).a());
        this.c = gVar;
        gVar.n(materialCardView.getContext());
        gVar.s(-12303292);
        j jVar = gVar.b.a;
        Objects.requireNonNull(jVar);
        j.b bVar = new j.b(jVar);
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        int i4 = R$styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            bVar.c(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.f2597d = new g();
        h(bVar.a());
        obtainStyledAttributes.recycle();
    }

    public final float a() {
        float b2 = b(this.f2605l.a, this.c.l());
        d dVar = this.f2605l.b;
        g gVar = this.c;
        float max = Math.max(b2, b(dVar, gVar.b.a.f2781f.a(gVar.h())));
        d dVar2 = this.f2605l.c;
        g gVar2 = this.c;
        float b3 = b(dVar2, gVar2.b.a.f2782g.a(gVar2.h()));
        d dVar3 = this.f2605l.f2779d;
        g gVar3 = this.c;
        return Math.max(max, Math.max(b3, b(dVar3, gVar3.b.a.f2783h.a(gVar3.h()))));
    }

    public final float b(d dVar, float f2) {
        if (dVar instanceof i) {
            return (float) ((1.0d - u) * ((double) f2));
        }
        if (dVar instanceof e) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float c() {
        return this.a.getMaxCardElevation() + (j() ? a() : 0.0f);
    }

    public final float d() {
        return (this.a.getMaxCardElevation() * 1.5f) + (j() ? a() : 0.0f);
    }

    public final Drawable e() {
        if (this.n == null) {
            int[] iArr = f.b.a.d.t.a.a;
            this.q = new g(this.f2605l);
            this.n = new RippleDrawable(this.f2603j, null, this.q);
        }
        if (this.o == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.f2602i;
            if (drawable != null) {
                stateListDrawable.addState(t, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.f2597d, stateListDrawable});
            this.o = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    public final Drawable f(Drawable drawable) {
        int i2;
        int i3;
        if (this.a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((double) d());
            i3 = (int) Math.ceil((double) c());
            i2 = ceil;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new C0090a(this, drawable, i3, i2, i3, i2);
    }

    public void g(Drawable drawable) {
        this.f2602i = drawable;
        if (drawable != null) {
            Drawable v1 = m.h.v1(drawable.mutate());
            this.f2602i = v1;
            v1.setTintList(this.f2604k);
        }
        if (this.o != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.f2602i;
            if (drawable2 != null) {
                stateListDrawable.addState(t, drawable2);
            }
            this.o.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public void h(j jVar) {
        this.f2605l = jVar;
        g gVar = this.c;
        gVar.b.a = jVar;
        gVar.invalidateSelf();
        g gVar2 = this.c;
        gVar2.w = !gVar2.o();
        g gVar3 = this.f2597d;
        if (gVar3 != null) {
            gVar3.b.a = jVar;
            gVar3.invalidateSelf();
        }
        g gVar4 = this.q;
        if (gVar4 != null) {
            gVar4.b.a = jVar;
            gVar4.invalidateSelf();
        }
        g gVar5 = this.p;
        if (gVar5 != null) {
            gVar5.b.a = jVar;
            gVar5.invalidateSelf();
        }
    }

    public final boolean i() {
        return this.a.getPreventCornerOverlap() && !this.c.o();
    }

    public final boolean j() {
        return this.a.getPreventCornerOverlap() && this.c.o() && this.a.getUseCompatPadding();
    }

    public void k() {
        float f2 = 0.0f;
        float a2 = i() || j() ? a() : 0.0f;
        if (this.a.getPreventCornerOverlap() && this.a.getUseCompatPadding()) {
            f2 = (float) ((1.0d - u) * ((double) this.a.getCardViewRadius()));
        }
        int i2 = (int) (a2 - f2);
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.f1161f.set(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
        ((b) e.d.a.a.f1158j).c(materialCardView.f1163h);
    }

    public void l() {
        if (!this.r) {
            this.a.setBackgroundInternal(f(this.c));
        }
        this.a.setForeground(f(this.f2601h));
    }

    public final void m() {
        int[] iArr = f.b.a.d.t.a.a;
        Drawable drawable = this.n;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.f2603j);
            return;
        }
        g gVar = this.p;
        if (gVar != null) {
            gVar.q(this.f2603j);
        }
    }

    public void n() {
        this.f2597d.u((float) this.f2600g, this.m);
    }
}
