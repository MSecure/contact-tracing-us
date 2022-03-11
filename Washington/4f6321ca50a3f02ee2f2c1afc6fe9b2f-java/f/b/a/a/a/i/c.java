package f.b.a.a.a.i;

import android.widget.TextView;
import e.p.r;
import f.b.a.a.a.w.k0;

public final /* synthetic */ class c implements r {
    public final /* synthetic */ TextView a;

    public /* synthetic */ c(TextView textView) {
        this.a = textView;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        TextView textView = this.a;
        k0.f fVar = (k0.f) obj;
        int i2 = l.b0;
        textView.setVisibility(fVar != k0.f.DISMISSED ? 0 : 8);
    }
}
