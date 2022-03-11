package e.d;

import android.widget.TextView;
import e.r.t;
/* loaded from: classes.dex */
public class z implements t<CharSequence> {
    public final /* synthetic */ x a;

    public z(x xVar) {
        this.a = xVar;
    }

    @Override // e.r.t
    public void a(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        x xVar = this.a;
        xVar.m0.removeCallbacks(xVar.n0);
        TextView textView = this.a.s0;
        if (textView != null) {
            textView.setText(charSequence2);
        }
        x xVar2 = this.a;
        xVar2.m0.postDelayed(xVar2.n0, 2000);
    }
}
