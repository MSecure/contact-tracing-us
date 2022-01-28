package f.b.a.e.x;

import android.widget.AutoCompleteTextView;

public class k implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    public void onDismiss() {
        h hVar = this.a;
        hVar.f3032i = true;
        hVar.f3034k = System.currentTimeMillis();
        h.g(this.a, false);
    }
}
