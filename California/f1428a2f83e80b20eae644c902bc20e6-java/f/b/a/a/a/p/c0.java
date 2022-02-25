package f.b.a.a.a.p;

import android.view.View;
import com.google.android.material.progressindicator.ProgressIndicator;
import e.p.r;

public final /* synthetic */ class c0 implements r {
    public final /* synthetic */ View a;
    public final /* synthetic */ ProgressIndicator b;

    public /* synthetic */ c0(View view, ProgressIndicator progressIndicator) {
        this.a = view;
        this.b = progressIndicator;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        View view = this.a;
        ProgressIndicator progressIndicator = this.b;
        int i2 = l3.a0;
        if (((Boolean) obj).booleanValue()) {
            view.setVisibility(8);
            progressIndicator.b();
        }
    }
}
