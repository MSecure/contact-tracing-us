package f.b.a.e.y;

import android.widget.AutoCompleteTextView;
/* loaded from: classes.dex */
public class k implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        h hVar = this.a;
        hVar.f3138j = true;
        hVar.f3140l = System.currentTimeMillis();
        h.g(this.a, false);
    }
}
