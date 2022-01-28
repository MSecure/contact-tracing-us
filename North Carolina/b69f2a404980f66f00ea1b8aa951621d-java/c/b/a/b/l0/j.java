package c.b.a.b.l0;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class j implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f3083b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f3084c;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.f3084c = hVar;
        this.f3083b = autoCompleteTextView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f3084c.i()) {
                this.f3084c.i = false;
            }
            h.g(this.f3084c, this.f3083b);
        }
        return false;
    }
}
