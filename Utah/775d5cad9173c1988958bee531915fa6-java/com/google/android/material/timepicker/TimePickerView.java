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
import e.i.i.v;
import f.b.a.e.a0.d;
import f.b.a.e.a0.e;
import f.b.a.e.a0.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int z = 0;
    public final Chip v;
    public final Chip w;
    public final MaterialButtonToggleGroup x;
    public final View.OnClickListener y;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            TimePickerView timePickerView = TimePickerView.this;
            int i2 = TimePickerView.z;
            Objects.requireNonNull(timePickerView);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.y = aVar;
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.x = materialButtonToggleGroup;
        materialButtonToggleGroup.f536e.add(new d(this));
        Chip chip = (Chip) findViewById(R$id.material_minute_tv);
        this.v = chip;
        Chip chip2 = (Chip) findViewById(R$id.material_hour_tv);
        this.w = chip2;
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

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            s();
        }
    }

    public final void s() {
        d.a aVar;
        if (this.x.getVisibility() == 0) {
            e.g.c.d dVar = new e.g.c.d();
            dVar.c(this);
            AtomicInteger atomicInteger = v.a;
            char c = v.e.d(this) == 0 ? (char) 2 : 1;
            int i2 = R$id.material_clock_display;
            if (dVar.c.containsKey(Integer.valueOf(i2)) && (aVar = dVar.c.get(Integer.valueOf(i2))) != null) {
                switch (c) {
                    case 1:
                        d.b bVar = aVar.f1400d;
                        bVar.f1418i = -1;
                        bVar.f1417h = -1;
                        bVar.F = -1;
                        bVar.M = Integer.MIN_VALUE;
                        break;
                    case 2:
                        d.b bVar2 = aVar.f1400d;
                        bVar2.f1420k = -1;
                        bVar2.f1419j = -1;
                        bVar2.G = -1;
                        bVar2.O = Integer.MIN_VALUE;
                        break;
                    case 3:
                        d.b bVar3 = aVar.f1400d;
                        bVar3.m = -1;
                        bVar3.f1421l = -1;
                        bVar3.H = 0;
                        bVar3.N = Integer.MIN_VALUE;
                        break;
                    case 4:
                        d.b bVar4 = aVar.f1400d;
                        bVar4.n = -1;
                        bVar4.o = -1;
                        bVar4.I = 0;
                        bVar4.P = Integer.MIN_VALUE;
                        break;
                    case 5:
                        d.b bVar5 = aVar.f1400d;
                        bVar5.p = -1;
                        bVar5.q = -1;
                        bVar5.r = -1;
                        bVar5.L = 0;
                        bVar5.S = Integer.MIN_VALUE;
                        break;
                    case 6:
                        d.b bVar6 = aVar.f1400d;
                        bVar6.s = -1;
                        bVar6.t = -1;
                        bVar6.K = 0;
                        bVar6.R = Integer.MIN_VALUE;
                        break;
                    case 7:
                        d.b bVar7 = aVar.f1400d;
                        bVar7.u = -1;
                        bVar7.v = -1;
                        bVar7.J = 0;
                        bVar7.Q = Integer.MIN_VALUE;
                        break;
                    case '\b':
                        d.b bVar8 = aVar.f1400d;
                        bVar8.B = -1.0f;
                        bVar8.A = -1;
                        bVar8.z = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            dVar.b(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }
}
