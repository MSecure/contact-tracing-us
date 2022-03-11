package f.b.a.d.m;

import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertController;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.a.g;
import e.b.e.c;
import e.i.i.m;
import f.b.a.d.a0.a.a;
import f.b.a.d.q.k;
import java.util.concurrent.atomic.AtomicInteger;

public class b extends g.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f2758e = R$attr.alertDialogStyle;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2759f = R$style.MaterialAlertDialog_MaterialComponents;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2760g = R$attr.materialAlertDialogTheme;
    public Drawable c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2761d;

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(Context context) {
        super(r3, r14 == null ? 0 : r14.data);
        int i2 = f2760g;
        TypedValue B1 = f.b.a.c.b.o.b.B1(context, i2);
        int i3 = B1 == null ? 0 : B1.data;
        int i4 = f2758e;
        int i5 = f2759f;
        Context a = a.a(context, null, i4, i5);
        a = i3 != 0 ? new c(a, i3) : a;
        TypedValue B12 = f.b.a.c.b.o.b.B1(context, i2);
        Context context2 = this.a.a;
        Resources.Theme theme = context2.getTheme();
        int[] iArr = R$styleable.MaterialAlertDialog;
        k.a(context2, null, i4, i5);
        k.b(context2, null, iArr, i4, i5, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(null, iArr, i4, i5);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_bottom));
        obtainStyledAttributes.recycle();
        if (context2.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.f2761d = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        int D1 = f.b.a.c.b.o.b.D1(context2, R$attr.colorSurface, b.class.getCanonicalName());
        f.b.a.d.v.g gVar = new f.b.a.d.v.g(context2, null, i4, i5);
        gVar.b.b = new f.b.a.d.n.a(context2);
        gVar.y();
        gVar.q(ColorStateList.valueOf(D1));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(this.a.a.getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                gVar.b.a = gVar.b.a.e(dimension);
                gVar.invalidateSelf();
            }
        }
        this.c = gVar;
    }

    @Override // e.b.a.g.a
    public g a() {
        g a = super.a();
        Window window = a.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.c;
        if (drawable instanceof f.b.a.d.v.g) {
            AtomicInteger atomicInteger = m.a;
            ((f.b.a.d.v.g) drawable).p(decorView.getElevation());
        }
        Drawable drawable2 = this.c;
        Rect rect = this.f2761d;
        window.setBackgroundDrawable(new InsetDrawable(drawable2, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(a, this.f2761d));
        return a;
    }

    public b c(int i2) {
        AlertController.b bVar = this.a;
        bVar.f29f = bVar.a.getText(i2);
        return this;
    }

    public b d(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertController.b bVar = this.a;
        bVar.f32i = bVar.a.getText(i2);
        this.a.f33j = onClickListener;
        return this;
    }

    public b e(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertController.b bVar = this.a;
        bVar.f30g = bVar.a.getText(i2);
        this.a.f31h = onClickListener;
        return this;
    }

    public b f(int i2) {
        AlertController.b bVar = this.a;
        bVar.f27d = bVar.a.getText(i2);
        return this;
    }
}
