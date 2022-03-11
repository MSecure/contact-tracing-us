package f.b.a.d.b0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import e.g.c.d;
import e.i.i.m;
import f.b.a.d.v.g;
import f.b.a.d.v.h;
import f.b.a.d.v.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends ConstraintLayout {
    public final Runnable u;
    public int v;
    public g w;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.k();
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        g gVar = new g();
        this.w = gVar;
        h hVar = new h(0.5f);
        j jVar = gVar.b.a;
        Objects.requireNonNull(jVar);
        j.b bVar = new j.b(jVar);
        bVar.f2893e = hVar;
        bVar.f2894f = hVar;
        bVar.f2895g = hVar;
        bVar.f2896h = hVar;
        gVar.b.a = bVar.a();
        gVar.invalidateSelf();
        this.w.q(ColorStateList.valueOf(-1));
        g gVar2 = this.w;
        AtomicInteger atomicInteger = m.a;
        setBackground(gVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i2, 0);
        this.v = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.u = new a();
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            AtomicInteger atomicInteger = m.a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.u);
            handler.post(this.u);
        }
    }

    public void k() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            if ("skip".equals(getChildAt(i3).getTag())) {
                i2++;
            }
        }
        d dVar = new d();
        dVar.b(this);
        float f2 = 0.0f;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            int i5 = R$id.circle_center;
            if (id != i5 && !"skip".equals(childAt.getTag())) {
                int id2 = childAt.getId();
                int i6 = this.v;
                if (!dVar.c.containsKey(Integer.valueOf(id2))) {
                    dVar.c.put(Integer.valueOf(id2), new d.a());
                }
                d.b bVar = dVar.c.get(Integer.valueOf(id2)).f1365d;
                bVar.x = i5;
                bVar.y = i6;
                bVar.z = f2;
                f2 = (360.0f / ((float) (childCount - i2))) + f2;
            }
        }
        dVar.a(this, true);
        setConstraintSet(null);
        requestLayout();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        k();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.u);
            handler.post(this.u);
        }
    }

    public void setBackgroundColor(int i2) {
        this.w.q(ColorStateList.valueOf(i2));
    }
}
