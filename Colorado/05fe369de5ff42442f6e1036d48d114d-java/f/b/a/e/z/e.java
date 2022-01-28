package f.b.a.e.z;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Objects;

public class e extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView a;

    public e(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView timePickerView = this.a;
        int i2 = TimePickerView.y;
        Objects.requireNonNull(timePickerView);
        return onDoubleTap;
    }
}
