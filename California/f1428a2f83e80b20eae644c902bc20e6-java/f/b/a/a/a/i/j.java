package f.b.a.a.a.i;

import android.widget.TextView;
import e.p.r;
import f.b.a.a.a.w.n0;

public final /* synthetic */ class j implements r {
    public final /* synthetic */ TextView a;

    public /* synthetic */ j(TextView textView) {
        this.a = textView;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        TextView textView = this.a;
        n0.b bVar = (n0.b) obj;
        int i2 = l.b0;
        textView.setVisibility(bVar != n0.b.DISMISSED ? 0 : 8);
    }
}
