package c.b.a.b.n0;

import c.b.a.b.f;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;

public class d implements MaterialButtonToggleGroup.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerView f4470a;

    public d(TimePickerView timePickerView) {
        this.f4470a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
    public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        int i2 = i == f.material_clock_period_pm_button ? 1 : 0;
        TimePickerView.b bVar = this.f4470a.y;
        if (bVar != null && z) {
            bVar.a(i2);
        }
    }
}
