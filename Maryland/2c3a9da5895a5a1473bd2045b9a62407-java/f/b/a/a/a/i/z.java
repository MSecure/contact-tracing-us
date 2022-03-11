package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import e.z.a;

public final class z implements a {
    public final LinearLayout a;
    public final RadioGroup b;
    public final ImageButton c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f2154d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f2155e;

    public z(LinearLayout linearLayout, MaterialRadioButton materialRadioButton, MaterialRadioButton materialRadioButton2, MaterialRadioButton materialRadioButton3, RadioGroup radioGroup, ImageButton imageButton, Button button, Button button2) {
        this.a = linearLayout;
        this.b = radioGroup;
        this.c = imageButton;
        this.f2154d = button;
        this.f2155e = button2;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
