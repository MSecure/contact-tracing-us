package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import e.g.c.d;
import e.i.i.m;
import f.b.a.e.z.d;
import f.b.a.e.z.e;
import f.b.a.e.z.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int y = 0;
    public final Chip u;
    public final Chip v;
    public final MaterialButtonToggleGroup w;
    public final View.OnClickListener x;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            TimePickerView timePickerView = TimePickerView.this;
            int i2 = TimePickerView.y;
            Objects.requireNonNull(timePickerView);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.x = aVar;
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.w = materialButtonToggleGroup;
        materialButtonToggleGroup.f541e.add(new d(this));
        Chip chip = (Chip) findViewById(R$id.material_minute_tv);
        this.u = chip;
        Chip chip2 = (Chip) findViewById(R$id.material_hour_tv);
        this.v = chip2;
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        f fVar = new f(this, new GestureDetector(getContext(), new e(this)));
        chip.setOnTouchListener(fVar);
        chip2.setOnTouchListener(fVar);
        int i2 = R$id.selection_type;
        chip.setTag(i2, 12);
        chip2.setTag(i2, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
    }

    public final void k() {
        if (this.w.getVisibility() == 0) {
            e.g.c.d dVar = new e.g.c.d();
            dVar.b(this);
            AtomicInteger atomicInteger = m.a;
            char c = getLayoutDirection() == 0 ? (char) 2 : 1;
            int i2 = R$id.material_clock_display;
            if (dVar.c.containsKey(Integer.valueOf(i2))) {
                d.a aVar = dVar.c.get(Integer.valueOf(i2));
                switch (c) {
                    case 1:
                        d.b bVar = aVar.f1176d;
                        bVar.f1184i = -1;
                        bVar.f1183h = -1;
                        bVar.D = -1;
                        bVar.J = -1;
                        break;
                    case 2:
                        d.b bVar2 = aVar.f1176d;
                        bVar2.f1186k = -1;
                        bVar2.f1185j = -1;
                        bVar2.E = -1;
                        bVar2.L = -1;
                        break;
                    case 3:
                        d.b bVar3 = aVar.f1176d;
                        bVar3.m = -1;
                        bVar3.f1187l = -1;
                        bVar3.F = -1;
                        bVar3.K = -1;
                        break;
                    case 4:
                        d.b bVar4 = aVar.f1176d;
                        bVar4.n = -1;
                        bVar4.o = -1;
                        bVar4.G = -1;
                        bVar4.M = -1;
                        break;
                    case 5:
                        aVar.f1176d.p = -1;
                        break;
                    case 6:
                        d.b bVar5 = aVar.f1176d;
                        bVar5.q = -1;
                        bVar5.r = -1;
                        bVar5.I = -1;
                        bVar5.O = -1;
                        break;
                    case 7:
                        d.b bVar6 = aVar.f1176d;
                        bVar6.s = -1;
                        bVar6.t = -1;
                        bVar6.H = -1;
                        bVar6.N = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            dVar.a(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            k();
        }
    }
}
