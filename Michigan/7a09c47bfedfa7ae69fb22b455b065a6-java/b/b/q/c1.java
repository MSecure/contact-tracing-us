package b.b.q;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import b.b.f;
import b.b.g;
import b.b.i;

public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f809a;

    /* renamed from: b  reason: collision with root package name */
    public final View f810b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f811c;

    /* renamed from: d  reason: collision with root package name */
    public final WindowManager.LayoutParams f812d = new WindowManager.LayoutParams();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f813e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f814f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    public final int[] f815g = new int[2];

    public c1(Context context) {
        this.f809a = context;
        View inflate = LayoutInflater.from(context).inflate(g.abc_tooltip, (ViewGroup) null);
        this.f810b = inflate;
        this.f811c = (TextView) inflate.findViewById(f.message);
        this.f812d.setTitle(c1.class.getSimpleName());
        this.f812d.packageName = this.f809a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f812d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a() {
        if (this.f810b.getParent() != null) {
            ((WindowManager) this.f809a.getSystemService("window")).removeView(this.f810b);
        }
    }
}
