package f.b.a.e.y;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView b;
    public final /* synthetic */ h c;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.c = hVar;
        this.b = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.c.j()) {
                this.c.f3138j = false;
            }
            h.h(this.c, this.b);
        }
        return false;
    }
}
