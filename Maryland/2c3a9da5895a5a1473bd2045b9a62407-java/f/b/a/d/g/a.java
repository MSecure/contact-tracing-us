package f.b.a.d.g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.R$attr;
import com.google.android.material.button.MaterialButton;
import e.i.i.m;
import f.b.a.c.b.o.b;
import f.b.a.d.v.g;
import f.b.a.d.v.j;
import f.b.a.d.v.n;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    public final MaterialButton a;
    public j b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2696d;

    /* renamed from: e  reason: collision with root package name */
    public int f2697e;

    /* renamed from: f  reason: collision with root package name */
    public int f2698f;

    /* renamed from: g  reason: collision with root package name */
    public int f2699g;

    /* renamed from: h  reason: collision with root package name */
    public int f2700h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f2701i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f2702j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f2703k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f2704l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;
    public int s;

    public a(MaterialButton materialButton, j jVar) {
        this.a = materialButton;
        this.b = jVar;
    }

    public n a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.r.getNumberOfLayers() > 2 ? this.r.getDrawable(2) : this.r.getDrawable(1));
    }

    public g b() {
        return c(false);
    }

    public final g c(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final g d() {
        return c(true);
    }

    public void e(j jVar) {
        this.b = jVar;
        if (b() != null) {
            g b2 = b();
            b2.b.a = jVar;
            b2.invalidateSelf();
        }
        if (d() != null) {
            g d2 = d();
            d2.b.a = jVar;
            d2.invalidateSelf();
        }
        if (a() != null) {
            a().setShapeAppearanceModel(jVar);
        }
    }

    public final void f(int i2, int i3) {
        MaterialButton materialButton = this.a;
        AtomicInteger atomicInteger = m.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = this.a.getPaddingEnd();
        int paddingBottom = this.a.getPaddingBottom();
        int i4 = this.f2697e;
        int i5 = this.f2698f;
        this.f2698f = i3;
        this.f2697e = i2;
        if (!this.o) {
            g();
        }
        this.a.setPaddingRelative(paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    public final void g() {
        MaterialButton materialButton = this.a;
        g gVar = new g(this.b);
        gVar.n(this.a.getContext());
        gVar.setTintList(this.f2702j);
        PorterDuff.Mode mode = this.f2701i;
        if (mode != null) {
            gVar.setTintMode(mode);
        }
        gVar.u((float) this.f2700h, this.f2703k);
        g gVar2 = new g(this.b);
        gVar2.setTint(0);
        gVar2.t((float) this.f2700h, this.n ? b.K0(this.a, R$attr.colorSurface) : 0);
        g gVar3 = new g(this.b);
        this.m = gVar3;
        gVar3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(f.b.a.d.t.a.b(this.f2704l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), this.c, this.f2697e, this.f2696d, this.f2698f), this.m);
        this.r = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        g b2 = b();
        if (b2 != null) {
            b2.p((float) this.s);
        }
    }

    public final void h() {
        g b2 = b();
        g d2 = d();
        if (b2 != null) {
            b2.u((float) this.f2700h, this.f2703k);
            if (d2 != null) {
                d2.t((float) this.f2700h, this.n ? b.K0(this.a, R$attr.colorSurface) : 0);
            }
        }
    }
}
