package f.b.a.e.a0;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;
/* loaded from: classes.dex */
public class f implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector b;

    public f(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.b = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.b.onTouchEvent(motionEvent);
        }
        return false;
    }
}
