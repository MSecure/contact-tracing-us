package c.b.a.b.y;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import b.b.k.e;
import b.i.l.m;
import c.b.a.a.c.n.c;
import c.b.a.b.c0.i;
import c.b.a.b.d;
import c.b.a.b.h0.g;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.m0.a.a;

public class b extends e.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f3303e = c.b.a.b.b.alertDialogStyle;
    public static final int f = k.MaterialAlertDialog_MaterialComponents;
    public static final int g = c.b.a.b.b.materialAlertDialogTheme;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f3304c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f3305d;

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(Context context) {
        super(r2, r13 == null ? 0 : r13.data);
        TypedValue U1 = c.U1(context, g);
        int i = U1 == null ? 0 : U1.data;
        Context a2 = a.a(context, null, f3303e, f);
        a2 = i != 0 ? new b.b.p.c(a2, i) : a2;
        TypedValue U12 = c.U1(context, g);
        Context context2 = this.f365a.f27a;
        Resources.Theme theme = context2.getTheme();
        TypedArray d2 = i.d(context2, null, l.MaterialAlertDialog, f3303e, f, new int[0]);
        int dimensionPixelSize = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_bottom));
        d2.recycle();
        if (context2.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.f3305d = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        int W1 = c.W1(context2, c.b.a.b.b.colorSurface, b.class.getCanonicalName());
        g gVar = new g(context2, null, f3303e, f);
        gVar.f2982b.f2988b = new c.b.a.b.z.a(context2);
        gVar.z();
        gVar.r(ColorStateList.valueOf(W1));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(this.f365a.f27a.getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                gVar.f2982b.f2987a = gVar.f2982b.f2987a.e(dimension);
                gVar.invalidateSelf();
            }
        }
        this.f3304c = gVar;
    }

    @Override // b.b.k.e.a
    public e a() {
        e a2 = super.a();
        Window window = a2.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f3304c;
        if (drawable instanceof g) {
            ((g) drawable).q(m.k(decorView));
        }
        Drawable drawable2 = this.f3304c;
        Rect rect = this.f3305d;
        window.setBackgroundDrawable(new InsetDrawable(drawable2, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(a2, this.f3305d));
        return a2;
    }
}
