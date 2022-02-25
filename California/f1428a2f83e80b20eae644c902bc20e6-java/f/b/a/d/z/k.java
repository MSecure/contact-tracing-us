package f.b.a.d.z;

import android.widget.AutoCompleteTextView;

public class k implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    public void onDismiss() {
        h hVar = this.a;
        hVar.f2835i = true;
        hVar.f2837k = System.currentTimeMillis();
        h.g(this.a, false);
    }
}
