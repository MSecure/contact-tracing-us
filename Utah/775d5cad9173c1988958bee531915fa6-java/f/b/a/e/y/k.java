package f.b.a.e.y;

import android.widget.AutoCompleteTextView;

public class k implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    public void onDismiss() {
        h hVar = this.a;
        hVar.f3096j = true;
        hVar.f3098l = System.currentTimeMillis();
        h.g(this.a, false);
    }
}
