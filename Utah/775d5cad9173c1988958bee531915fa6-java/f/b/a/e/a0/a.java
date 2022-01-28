package f.b.a.e.a0;

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
        int height = ((this.b.getHeight() / 2) - clockFaceView.y.f623h) - clockFaceView.F;
        if (height != clockFaceView.w) {
            clockFaceView.w = height;
            clockFaceView.s();
            ClockHandView clockHandView = clockFaceView.y;
            clockHandView.p = clockFaceView.w;
            clockHandView.invalidate();
        }
        return true;
    }
}
