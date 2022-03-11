package f.b.a.e.g;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import e.b.a.m;
import f.b.a.e.t.b;
import f.b.a.e.v.d;
import f.b.a.e.v.e;
import f.b.a.e.v.g;
import f.b.a.e.v.i;
import f.b.a.e.v.j;
import java.util.Objects;
/* loaded from: classes.dex */
public class a {
    public static final double t = Math.cos(Math.toRadians(45.0d));
    public final MaterialCardView a;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final g f2908d;

    /* renamed from: e  reason: collision with root package name */
    public int f2909e;

    /* renamed from: f  reason: collision with root package name */
    public int f2910f;

    /* renamed from: g  reason: collision with root package name */
    public int f2911g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f2912h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f2913i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f2914j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f2915k;

    /* renamed from: l  reason: collision with root package name */
    public j f2916l;
    public ColorStateList m;
    public Drawable n;
    public LayerDrawable o;
    public g p;
    public g q;
    public boolean s;
    public final Rect b = new Rect();
    public boolean r = false;

    /* renamed from: f.b.a.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0092a extends InsetDrawable {
        public C0092a(a aVar, Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.Drawable, android.graphics.drawable.DrawableWrapper
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i2, int i3) {
        this.a = materialCardView;
        g gVar = new g(j.b(materialCardView.getContext(), attributeSet, i2, i3).a());
        this.c = gVar;
        gVar.o(materialCardView.getContext());
        gVar.t(-12303292);
        j jVar = gVar.b.a;
        Objects.requireNonNull(jVar);
        j.b bVar = new j.b(jVar);
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        int i4 = R$styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            bVar.c(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.f2908d = new g();
        h(bVar.a());
        obtainStyledAttributes.recycle();
    }

    public final float a() {
        float b = b(this.f2916l.a, this.c.m());
        d dVar = this.f2916l.b;
        g gVar = this.c;
        float max = Math.max(b, b(dVar, gVar.b.a.f3088f.a(gVar.i())));
        d dVar2 = this.f2916l.c;
        g gVar2 = this.c;
        float b2 = b(dVar2, gVar2.b.a.f3089g.a(gVar2.i()));
        d dVar3 = this.f2916l.f3086d;
        g gVar3 = this.c;
        return Math.max(max, Math.max(b2, b(dVar3, gVar3.b.a.f3090h.a(gVar3.i()))));
    }

    public final float b(d dVar, float f2) {
        if (dVar instanceof i) {
            return (float) ((1.0d - t) * ((double) f2));
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
            int[] iArr = b.a;
            this.q = new g(this.f2916l);
            this.n = new RippleDrawable(this.f2914j, null, this.q);
        }
        if (this.o == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.f2908d, this.f2913i});
            this.o = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    public final Drawable f(Drawable drawable) {
        int i2;
        int i3;
        if (this.a.getUseCompatPadding()) {
            i2 = (int) Math.ceil((double) d());
            i3 = (int) Math.ceil((double) c());
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new C0092a(this, drawable, i3, i2, i3, i2);
    }

    public void g(Drawable drawable) {
        this.f2913i = drawable;
        if (drawable != null) {
            Drawable mutate = m.e.X1(drawable).mutate();
            this.f2913i = mutate;
            mutate.setTintList(this.f2915k);
            boolean isChecked = this.a.isChecked();
            Drawable drawable2 = this.f2913i;
            if (drawable2 != null) {
                drawable2.setAlpha(isChecked ? 255 : 0);
            }
        }
        LayerDrawable layerDrawable = this.o;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, this.f2913i);
        }
    }

    public void h(j jVar) {
        this.f2916l = jVar;
        g gVar = this.c;
        gVar.b.a = jVar;
        gVar.invalidateSelf();
        g gVar2 = this.c;
        gVar2.x = !gVar2.p();
        g gVar3 = this.f2908d;
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
        return this.a.getPreventCornerOverlap() && !this.c.p();
    }

    public final boolean j() {
        return this.a.getPreventCornerOverlap() && this.c.p() && this.a.getUseCompatPadding();
    }

    public void k() {
        float f2 = 0.0f;
        float a = i() || j() ? a() : 0.0f;
        if (this.a.getPreventCornerOverlap() && this.a.getUseCompatPadding()) {
            f2 = (float) ((1.0d - t) * ((double) this.a.getCardViewRadius()));
        }
        int i2 = (int) (a - f2);
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.f1278f.set(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
        ((e.e.a.b) e.e.a.a.f1275j).c(materialCardView.f1280h);
    }

    public void l() {
        if (!this.r) {
            this.a.setBackgroundInternal(f(this.c));
        }
        this.a.setForeground(f(this.f2912h));
    }

    public final void m() {
        int[] iArr = b.a;
        Drawable drawable = this.n;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.f2914j);
            return;
        }
        g gVar = this.p;
        if (gVar != null) {
            gVar.r(this.f2914j);
        }
    }

    public void n() {
        this.f2908d.v((float) this.f2911g, this.m);
    }
}
