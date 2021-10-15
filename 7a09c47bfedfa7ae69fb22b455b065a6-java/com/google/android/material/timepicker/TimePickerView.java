package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.c.d;
import b.i.l.m;
import c.b.a.b.f;
import c.b.a.b.h;
import c.b.a.b.n0.d;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

public class TimePickerView extends ConstraintLayout {
    public final Chip u;
    public final Chip v;
    public final MaterialButtonToggleGroup w;
    public final View.OnClickListener x = new a();
    public b y;
    public c z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            c cVar = TimePickerView.this.z;
            if (cVar != null) {
                cVar.a(((Integer) view.getTag(f.selection_type)).intValue());
            }
        }
    }

    public interface b {
        void a(int i);
    }

    public interface c {
        void a(int i);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater.from(context).inflate(h.material_timepicker, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(f.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(f.material_clock_period_toggle);
        this.w = materialButtonToggleGroup;
        materialButtonToggleGroup.f6059e.add(new d(this));
        this.u = (Chip) findViewById(f.material_minute_tv);
        this.v = (Chip) findViewById(f.material_hour_tv);
        ClockHandView clockHandView = (ClockHandView) findViewById(f.material_clock_hand);
        this.u.setTag(f.selection_type, 12);
        this.v.setTag(f.selection_type, 10);
        this.u.setOnClickListener(this.x);
        this.v.setOnClickListener(this.x);
    }

    public final void k() {
        if (this.w.getVisibility() == 0) {
            b.g.c.d dVar = new b.g.c.d();
            dVar.c(this);
            char c2 = m.p(this) == 0 ? (char) 2 : 1;
            int i = f.material_clock_display;
            if (dVar.f1604c.containsKey(Integer.valueOf(i))) {
                d.a aVar = dVar.f1604c.get(Integer.valueOf(i));
                switch (c2) {
                    case 1:
                        d.b bVar = aVar.f1608d;
                        bVar.i = -1;
                        bVar.h = -1;
                        bVar.D = -1;
                        bVar.J = -1;
                        break;
                    case 2:
                        d.b bVar2 = aVar.f1608d;
                        bVar2.k = -1;
                        bVar2.j = -1;
                        bVar2.E = -1;
                        bVar2.L = -1;
                        break;
                    case 3:
                        d.b bVar3 = aVar.f1608d;
                        bVar3.m = -1;
                        bVar3.l = -1;
                        bVar3.F = -1;
                        bVar3.K = -1;
                        break;
                    case 4:
                        d.b bVar4 = aVar.f1608d;
                        bVar4.n = -1;
                        bVar4.o = -1;
                        bVar4.G = -1;
                        bVar4.M = -1;
                        break;
                    case 5:
                        aVar.f1608d.p = -1;
                        break;
                    case 6:
                        d.b bVar5 = aVar.f1608d;
                        bVar5.q = -1;
                        bVar5.r = -1;
                        bVar5.I = -1;
                        bVar5.O = -1;
                        break;
                    case 7:
                        d.b bVar6 = aVar.f1608d;
                        bVar6.s = -1;
                        bVar6.t = -1;
                        bVar6.H = -1;
                        bVar6.N = -1;
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

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            k();
        }
    }
}
