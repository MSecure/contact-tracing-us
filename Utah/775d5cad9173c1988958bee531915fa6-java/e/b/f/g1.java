package e.b.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

public class g1 {
    public final Context a;
    public final View b;
    public final TextView c;

    /* renamed from: d  reason: collision with root package name */
    public final WindowManager.LayoutParams f893d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f894e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f895f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    public final int[] f896g = new int[2];

    public g1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f893d = layoutParams;
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.b = inflate;
        this.c = (TextView) inflate.findViewById(R$id.message);
        layoutParams.setTitle(g1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a() {
        if (this.b.getParent() != null) {
            ((WindowManager) this.a.getSystemService("window")).removeView(this.b);
        }
    }
}
