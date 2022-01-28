package c.b.a.b.n0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.c.d;
import b.i.l.m;
import c.b.a.b.f;
import c.b.a.b.h;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.l;

public class c extends ConstraintLayout {
    public final Runnable u;
    public int v;
    public g w;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.l();
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(h.material_radial_view_group, this);
        g gVar = new g();
        this.w = gVar;
        c.b.a.b.h0.h hVar = new c.b.a.b.h0.h(0.5f);
        j jVar = gVar.f4261b.f4268a;
        if (jVar != null) {
            j.b bVar = new j.b(jVar);
            bVar.f4288e = hVar;
            bVar.f4289f = hVar;
            bVar.f4290g = hVar;
            bVar.h = hVar;
            gVar.f4261b.f4268a = bVar.a();
            gVar.invalidateSelf();
            this.w.r(ColorStateList.valueOf(-1));
            m.X(this, this.w);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.RadialViewGroup, i, 0);
            this.v = obtainStyledAttributes.getDimensionPixelSize(l.RadialViewGroup_materialCircleRadius, 0);
            this.u = new a();
            obtainStyledAttributes.recycle();
            return;
        }
        throw null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(m.f());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.u);
            handler.post(this.u);
        }
    }

    public int getRadius() {
        return this.v;
    }

    public final void l() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        d dVar = new d();
        dVar.c(this);
        float f2 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != f.circle_center && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int i4 = f.circle_center;
                int i5 = this.v;
                if (!dVar.f1604c.containsKey(Integer.valueOf(id))) {
                    dVar.f1604c.put(Integer.valueOf(id), new d.a());
                }
                d.b bVar = dVar.f1604c.get(Integer.valueOf(id)).f1608d;
                bVar.x = i4;
                bVar.y = i5;
                bVar.z = f2;
                f2 = (360.0f / ((float) (childCount - i))) + f2;
            }
        }
        dVar.b(this, true);
        setConstraintSet(null);
        requestLayout();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        l();
    }

    public void setBackgroundColor(int i) {
        this.w.r(ColorStateList.valueOf(i));
    }

    public void setRadius(int i) {
        this.v = i;
        l();
    }
}
