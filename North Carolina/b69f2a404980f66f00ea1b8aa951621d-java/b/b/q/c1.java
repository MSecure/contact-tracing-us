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
    public final Context f611a;

    /* renamed from: b  reason: collision with root package name */
    public final View f612b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f613c;

    /* renamed from: d  reason: collision with root package name */
    public final WindowManager.LayoutParams f614d = new WindowManager.LayoutParams();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f615e = new Rect();
    public final int[] f = new int[2];
    public final int[] g = new int[2];

    public c1(Context context) {
        this.f611a = context;
        View inflate = LayoutInflater.from(context).inflate(g.abc_tooltip, (ViewGroup) null);
        this.f612b = inflate;
        this.f613c = (TextView) inflate.findViewById(f.message);
        this.f614d.setTitle(c1.class.getSimpleName());
        this.f614d.packageName = this.f611a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f614d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a() {
        if (this.f612b.getParent() != null) {
            ((WindowManager) this.f611a.getSystemService("window")).removeView(this.f612b);
        }
    }
}
