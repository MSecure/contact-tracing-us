package f.b.a.a.a.q;

import android.widget.Button;
import android.widget.ProgressBar;
import e.p.r;

public final /* synthetic */ class c implements r {
    public final /* synthetic */ y a;
    public final /* synthetic */ Button b;
    public final /* synthetic */ ProgressBar c;

    public /* synthetic */ c(y yVar, Button button, ProgressBar progressBar) {
        this.a = yVar;
        this.b = button;
        this.c = progressBar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        y yVar = this.a;
        Button button = this.b;
        ProgressBar progressBar = this.c;
        Boolean bool = (Boolean) obj;
        yVar.c0.setEnabled(!bool.booleanValue());
        button.setEnabled(!bool.booleanValue());
        int i2 = 0;
        progressBar.setVisibility(bool.booleanValue() ? 0 : 4);
        Button button2 = yVar.c0;
        if (bool.booleanValue()) {
            i2 = 4;
        }
        button2.setVisibility(i2);
    }
}
