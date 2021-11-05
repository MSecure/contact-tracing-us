package b.q.d;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.o f1453a;

    /* renamed from: b  reason: collision with root package name */
    public int f1454b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f1455c = new Rect();

    public a0(RecyclerView.o oVar, y yVar) {
        this.f1453a = oVar;
    }

    public static a0 a(RecyclerView.o oVar, int i) {
        if (i == 0) {
            return new y(oVar);
        }
        if (i == 1) {
            return new z(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public int m() {
        if (Integer.MIN_VALUE == this.f1454b) {
            return 0;
        }
        return l() - this.f1454b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i);
}
