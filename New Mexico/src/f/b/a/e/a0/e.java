package f.b.a.e.a0;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Objects;
/* loaded from: classes.dex */
public class e extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView a;

    public e(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        TimePickerView timePickerView = this.a;
        int i2 = TimePickerView.z;
        Objects.requireNonNull(timePickerView);
        return false;
    }
}
