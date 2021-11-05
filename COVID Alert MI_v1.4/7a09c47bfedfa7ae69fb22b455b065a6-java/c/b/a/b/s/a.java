package c.b.a.b.s;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import b.x.t;
import c.b.a.b.b;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.h0.n;
import com.google.android.material.button.MaterialButton;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialButton f4513a;

    /* renamed from: b  reason: collision with root package name */
    public j f4514b;

    /* renamed from: c  reason: collision with root package name */
    public int f4515c;

    /* renamed from: d  reason: collision with root package name */
    public int f4516d;

    /* renamed from: e  reason: collision with root package name */
    public int f4517e;

    /* renamed from: f  reason: collision with root package name */
    public int f4518f;

    /* renamed from: g  reason: collision with root package name */
    public int f4519g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;

    public a(MaterialButton materialButton, j jVar) {
        this.f4513a = materialButton;
        this.f4514b = jVar;
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
        this.f4514b = jVar;
        if (b() != null) {
            g b2 = b();
            b2.f4261b.f4268a = jVar;
            b2.invalidateSelf();
        }
        if (d() != null) {
            g d2 = d();
            d2.f4261b.f4268a = jVar;
            d2.invalidateSelf();
        }
        if (a() != null) {
            a().setShapeAppearanceModel(jVar);
        }
    }

    public final void f() {
        g b2 = b();
        g d2 = d();
        if (b2 != null) {
            b2.v((float) this.h, this.k);
            if (d2 != null) {
                d2.u((float) this.h, this.n ? t.A1(this.f4513a, b.colorSurface) : 0);
            }
        }
    }
}
