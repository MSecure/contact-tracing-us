package e.s.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class q {
    public final RecyclerView.m a;
    public int b = Integer.MIN_VALUE;
    public final Rect c = new Rect();

    public q(RecyclerView.m mVar, o oVar) {
        this.a = mVar;
    }

    public static q a(RecyclerView.m mVar, int i2) {
        if (i2 == 0) {
            return new o(mVar);
        }
        if (i2 == 1) {
            return new p(mVar);
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
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return l() - this.b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i2);
}
