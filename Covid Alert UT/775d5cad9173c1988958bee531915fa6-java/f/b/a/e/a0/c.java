package f.b.a.e.a0;

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
import e.i.i.v;
import f.b.a.e.v.g;
import f.b.a.e.v.h;
import f.b.a.e.v.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends ConstraintLayout {
    public final Runnable v;
    public int w;
    public g x;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.s();
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        g gVar = new g();
        this.x = gVar;
        h hVar = new h(0.5f);
        j jVar = gVar.b.a;
        Objects.requireNonNull(jVar);
        j.b bVar = new j.b(jVar);
        bVar.f3054e = hVar;
        bVar.f3055f = hVar;
        bVar.f3056g = hVar;
        bVar.f3057h = hVar;
        gVar.b.a = bVar.a();
        gVar.invalidateSelf();
        this.x.q(ColorStateList.valueOf(-1));
        g gVar2 = this.x;
        AtomicInteger atomicInteger = v.a;
        v.d.q(this, gVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i2, 0);
        this.w = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.v = new a();
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            AtomicInteger atomicInteger = v.a;
            view.setId(v.e.a());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.v);
            handler.post(this.v);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        s();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.v);
            handler.post(this.v);
        }
    }

    public void s() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            if ("skip".equals(getChildAt(i3).getTag())) {
                i2++;
            }
        }
        d dVar = new d();
        dVar.c(this);
        float f2 = 0.0f;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            int i5 = R$id.circle_center;
            if (id != i5 && !"skip".equals(childAt.getTag())) {
                int id2 = childAt.getId();
                int i6 = this.w;
                if (!dVar.c.containsKey(Integer.valueOf(id2))) {
                    dVar.c.put(Integer.valueOf(id2), new d.a());
                }
                d.b bVar = dVar.c.get(Integer.valueOf(id2)).f1400d;
                bVar.z = i5;
                bVar.A = i6;
                bVar.B = f2;
                f2 = (360.0f / ((float) (childCount - i2))) + f2;
            }
        }
        dVar.b(this, true);
        setConstraintSet(null);
        requestLayout();
    }

    public void setBackgroundColor(int i2) {
        this.x.q(ColorStateList.valueOf(i2));
    }
}
