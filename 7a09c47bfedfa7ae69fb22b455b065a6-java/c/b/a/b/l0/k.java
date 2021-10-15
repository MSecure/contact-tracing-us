package c.b.a.b.l0;

import android.widget.AutoCompleteTextView;

public class k implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f4382a;

    public k(h hVar) {
        this.f4382a = hVar;
    }

    public void onDismiss() {
        h hVar = this.f4382a;
        hVar.i = true;
        hVar.k = System.currentTimeMillis();
        h.f(this.f4382a, false);
    }
}
