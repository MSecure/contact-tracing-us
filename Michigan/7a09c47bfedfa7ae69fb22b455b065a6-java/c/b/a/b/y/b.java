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
import b.b.p.c;
import b.i.l.m;
import b.x.t;
import c.b.a.b.d;
import c.b.a.b.h0.g;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.m0.a.a;

public class b extends e.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f4637e = c.b.a.b.b.alertDialogStyle;

    /* renamed from: f  reason: collision with root package name */
    public static final int f4638f = k.MaterialAlertDialog_MaterialComponents;

    /* renamed from: g  reason: collision with root package name */
    public static final int f4639g = c.b.a.b.b.materialAlertDialogTheme;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f4640c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f4641d;

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(Context context) {
        super(r2, r13 == null ? 0 : r13.data);
        TypedValue z2 = t.z2(context, f4639g);
        int i = z2 == null ? 0 : z2.data;
        Context a2 = a.a(context, null, f4637e, f4638f);
        a2 = i != 0 ? new c(a2, i) : a2;
        TypedValue z22 = t.z2(context, f4639g);
        Context context2 = this.f515a.f59a;
        Resources.Theme theme = context2.getTheme();
        TypedArray d2 = c.b.a.b.c0.k.d(context2, null, l.MaterialAlertDialog, f4637e, f4638f, new int[0]);
        int dimensionPixelSize = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = d2.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_bottom));
        d2.recycle();
        if (context2.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.f4641d = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        int B2 = t.B2(context2, c.b.a.b.b.colorSurface, b.class.getCanonicalName());
        g gVar = new g(context2, null, f4637e, f4638f);
        gVar.f4261b.f4269b = new c.b.a.b.z.a(context2);
        gVar.z();
        gVar.r(ColorStateList.valueOf(B2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(this.f515a.f59a.getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                gVar.f4261b.f4268a = gVar.f4261b.f4268a.e(dimension);
                gVar.invalidateSelf();
            }
        }
        this.f4640c = gVar;
    }

    @Override // b.b.k.e.a
    public e a() {
        e a2 = super.a();
        Window window = a2.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f4640c;
        if (drawable instanceof g) {
            ((g) drawable).q(m.l(decorView));
        }
        Drawable drawable2 = this.f4640c;
        Rect rect = this.f4641d;
        window.setBackgroundDrawable(new InsetDrawable(drawable2, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(a2, this.f4641d));
        return a2;
    }
}
