package f.b.a.e.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.R$attr;
import com.google.android.material.button.MaterialButton;
import e.i.i.v;
import f.b.a.c.b.o.b;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import f.b.a.e.v.n;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    public static final boolean t = true;
    public static final boolean u;
    public final MaterialButton a;
    public j b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2857d;

    /* renamed from: e  reason: collision with root package name */
    public int f2858e;

    /* renamed from: f  reason: collision with root package name */
    public int f2859f;

    /* renamed from: g  reason: collision with root package name */
    public int f2860g;

    /* renamed from: h  reason: collision with root package name */
    public int f2861h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f2862i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f2863j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f2864k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f2865l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;
    public int s;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i2 > 22) {
            z = false;
        }
        u = z;
    }

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
        return (g) (t ? (LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable() : this.r).getDrawable(!z ? 1 : 0);
    }

    public final g d() {
        return c(true);
    }

    public void e(j jVar) {
        this.b = jVar;
        if (!u || this.o) {
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
                return;
            }
            return;
        }
        MaterialButton materialButton = this.a;
        AtomicInteger atomicInteger = v.a;
        int f2 = v.e.f(materialButton);
        int paddingTop = this.a.getPaddingTop();
        int e2 = v.e.e(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        g();
        v.e.k(this.a, f2, paddingTop, e2, paddingBottom);
    }

    public final void f(int i2, int i3) {
        MaterialButton materialButton = this.a;
        AtomicInteger atomicInteger = v.a;
        int f2 = v.e.f(materialButton);
        int paddingTop = this.a.getPaddingTop();
        int e2 = v.e.e(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i4 = this.f2858e;
        int i5 = this.f2859f;
        this.f2859f = i3;
        this.f2858e = i2;
        if (!this.o) {
            g();
        }
        v.e.k(this.a, f2, (paddingTop + i2) - i4, e2, (paddingBottom + i3) - i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.graphics.drawable.LayerDrawable, android.graphics.drawable.RippleDrawable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void g() {
        InsetDrawable insetDrawable;
        MaterialButton materialButton = this.a;
        g gVar = new g(this.b);
        gVar.n(this.a.getContext());
        gVar.setTintList(this.f2863j);
        PorterDuff.Mode mode = this.f2862i;
        if (mode != null) {
            gVar.setTintMode(mode);
        }
        gVar.u((float) this.f2861h, this.f2864k);
        g gVar2 = new g(this.b);
        gVar2.setTint(0);
        gVar2.t((float) this.f2861h, this.n ? b.w0(this.a, R$attr.colorSurface) : 0);
        if (t) {
            g gVar3 = new g(this.b);
            this.m = gVar3;
            gVar3.setTint(-1);
            ?? rippleDrawable = new RippleDrawable(f.b.a.e.t.b.a(this.f2865l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), this.c, this.f2858e, this.f2857d, this.f2859f), this.m);
            this.r = rippleDrawable;
            insetDrawable = rippleDrawable;
        } else {
            f.b.a.e.t.a aVar = new f.b.a.e.t.a(this.b);
            this.m = aVar;
            aVar.setTintList(f.b.a.e.t.b.a(this.f2865l));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.m});
            this.r = layerDrawable;
            insetDrawable = new InsetDrawable((Drawable) layerDrawable, this.c, this.f2858e, this.f2857d, this.f2859f);
        }
        materialButton.setInternalBackground(insetDrawable);
        g b2 = b();
        if (b2 != null) {
            b2.p((float) this.s);
        }
    }

    public final void h() {
        g b2 = b();
        g d2 = d();
        if (b2 != null) {
            b2.u((float) this.f2861h, this.f2864k);
            if (d2 != null) {
                d2.t((float) this.f2861h, this.n ? b.w0(this.a, R$attr.colorSurface) : 0);
            }
        }
    }
}
