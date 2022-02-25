package f.b.a.d.b0;

import android.view.ViewTreeObserver;
import com.google.android.material.timepicker.ClockFaceView;
import com.google.android.material.timepicker.ClockHandView;

public class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ClockFaceView b;

    public a(ClockFaceView clockFaceView) {
        this.b = clockFaceView;
    }

    public boolean onPreDraw() {
        if (!this.b.isShown()) {
            return true;
        }
        this.b.getViewTreeObserver().removeOnPreDrawListener(this);
        ClockFaceView clockFaceView = this.b;
        int height = ((this.b.getHeight() / 2) - clockFaceView.x.f627h) - clockFaceView.D;
        if (height != clockFaceView.v) {
            clockFaceView.v = height;
            clockFaceView.k();
            ClockHandView clockHandView = clockFaceView.x;
            clockHandView.p = clockFaceView.v;
            clockHandView.invalidate();
        }
        return true;
    }
}
