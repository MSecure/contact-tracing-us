package f.b.a.d.z;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class j implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView b;
    public final /* synthetic */ h c;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.c = hVar;
        this.b = autoCompleteTextView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.c.j()) {
                this.c.f2843i = false;
            }
            h.h(this.c, this.b);
        }
        return false;
    }
}
