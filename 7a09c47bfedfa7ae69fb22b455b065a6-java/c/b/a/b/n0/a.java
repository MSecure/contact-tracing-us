package c.b.a.b.n0;

import android.view.ViewTreeObserver;
import com.google.android.material.timepicker.ClockFaceView;

public class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f4467b;

    public a(ClockFaceView clockFaceView) {
        this.f4467b = clockFaceView;
    }

    public boolean onPreDraw() {
        if (!this.f4467b.isShown()) {
            return true;
        }
        this.f4467b.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = (this.f4467b.getHeight() / 2) - this.f4467b.x.getSelectorRadius();
        ClockFaceView clockFaceView = this.f4467b;
        clockFaceView.setRadius(height - clockFaceView.D);
        return true;
    }
}
