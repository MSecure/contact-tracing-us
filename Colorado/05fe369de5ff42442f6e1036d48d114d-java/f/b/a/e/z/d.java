package f.b.a.e.z;

import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Objects;

public class d implements MaterialButtonToggleGroup.e {
    public final /* synthetic */ TimePickerView a;

    public d(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
    public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
        TimePickerView timePickerView = this.a;
        int i3 = TimePickerView.y;
        Objects.requireNonNull(timePickerView);
    }
}
