package f.b.a.e.m;

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
import e.j.j.v;
import f.b.a.e.q.k;
import f.b.a.e.z.a.a;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b extends g.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f2961e = R$attr.alertDialogStyle;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2962f = R$style.MaterialAlertDialog_MaterialComponents;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2963g = R$attr.materialAlertDialogTheme;
    public Drawable c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2964d;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public b(Context context, int i2) {
        super(r3, i2);
        int i3 = f2963g;
        TypedValue l1 = f.b.a.c.b.o.b.l1(context, i3);
        int i4 = l1 == null ? 0 : l1.data;
        int i5 = f2961e;
        int i6 = f2962f;
        Context a = a.a(context, null, i5, i6);
        a = i4 != 0 ? new c(a, i4) : a;
        if (i2 == 0) {
            TypedValue l12 = f.b.a.c.b.o.b.l1(context, i3);
            i2 = l12 == null ? 0 : l12.data;
        }
        Context context2 = this.a.a;
        Resources.Theme theme = context2.getTheme();
        int[] iArr = R$styleable.MaterialAlertDialog;
        k.a(context2, null, i5, i6);
        k.b(context2, null, iArr, i5, i6, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(null, iArr, i5, i6);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_bottom));
        obtainStyledAttributes.recycle();
        if (context2.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.f2964d = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        int n1 = f.b.a.c.b.o.b.n1(context2, R$attr.colorSurface, b.class.getCanonicalName());
        f.b.a.e.v.g gVar = new f.b.a.e.v.g(context2, null, i5, i6);
        gVar.b.b = new f.b.a.e.n.a(context2);
        gVar.z();
        gVar.r(ColorStateList.valueOf(n1));
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
        if (drawable instanceof f.b.a.e.v.g) {
            AtomicInteger atomicInteger = v.a;
            ((f.b.a.e.v.g) drawable).q(v.i.i(decorView));
        }
        Drawable drawable2 = this.c;
        Rect rect = this.f2964d;
        window.setBackgroundDrawable(new InsetDrawable(drawable2, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(a, this.f2964d));
        return a;
    }

    public b c(int i2) {
        AlertController.b bVar = this.a;
        bVar.f33f = bVar.a.getText(i2);
        return this;
    }

    public b d(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertController.b bVar = this.a;
        bVar.f36i = bVar.a.getText(i2);
        this.a.f37j = onClickListener;
        return this;
    }

    public b e(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertController.b bVar = this.a;
        bVar.f34g = bVar.a.getText(i2);
        this.a.f35h = onClickListener;
        return this;
    }

    public b f(int i2) {
        AlertController.b bVar = this.a;
        bVar.f31d = bVar.a.getText(i2);
        return this;
    }
}
