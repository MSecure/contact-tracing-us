package b.r.d;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.nearby.messages.BleSignal;

public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.m f2293a;

    /* renamed from: b  reason: collision with root package name */
    public int f2294b = BleSignal.UNKNOWN_TX_POWER;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f2295c = new Rect();

    public a0(RecyclerView.m mVar, y yVar) {
        this.f2293a = mVar;
    }

    public static a0 a(RecyclerView.m mVar, int i) {
        if (i == 0) {
            return new y(mVar);
        }
        if (i == 1) {
            return new z(mVar);
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
        if (Integer.MIN_VALUE == this.f2294b) {
            return 0;
        }
        return l() - this.f2294b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i);
}
