package c.b.a.b.l0;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class j implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f4380b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f4381c;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.f4381c = hVar;
        this.f4380b = autoCompleteTextView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f4381c.i()) {
                this.f4381c.i = false;
            }
            h.g(this.f4381c, this.f4380b);
        }
        return false;
    }
}
