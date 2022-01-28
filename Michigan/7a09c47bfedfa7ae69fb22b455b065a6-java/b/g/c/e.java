package b.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.c.d;

public class e extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public d f1637b;

    public static class a extends ConstraintLayout.a {
        public float n0;
        public boolean o0;
        public float p0;
        public float q0;
        public float r0;
        public float s0;
        public float t0;
        public float u0;
        public float v0;
        public float w0;
        public float x0;
        public float y0;
        public float z0;

        public a(int i, int i2) {
            super(i, i2);
            this.n0 = 1.0f;
            this.o0 = false;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 0.0f;
            this.t0 = 1.0f;
            this.u0 = 1.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
            this.z0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n0 = 1.0f;
            this.o0 = false;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 0.0f;
            this.t0 = 1.0f;
            this.u0 = 1.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
            this.z0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == i.ConstraintSet_android_alpha) {
                    this.n0 = obtainStyledAttributes.getFloat(index, this.n0);
                } else if (index == i.ConstraintSet_android_elevation) {
                    this.p0 = obtainStyledAttributes.getFloat(index, this.p0);
                    this.o0 = true;
                } else if (index == i.ConstraintSet_android_rotationX) {
                    this.r0 = obtainStyledAttributes.getFloat(index, this.r0);
                } else if (index == i.ConstraintSet_android_rotationY) {
                    this.s0 = obtainStyledAttributes.getFloat(index, this.s0);
                } else if (index == i.ConstraintSet_android_rotation) {
                    this.q0 = obtainStyledAttributes.getFloat(index, this.q0);
                } else if (index == i.ConstraintSet_android_scaleX) {
                    this.t0 = obtainStyledAttributes.getFloat(index, this.t0);
                } else if (index == i.ConstraintSet_android_scaleY) {
                    this.u0 = obtainStyledAttributes.getFloat(index, this.u0);
                } else if (index == i.ConstraintSet_android_transformPivotX) {
                    this.v0 = obtainStyledAttributes.getFloat(index, this.v0);
                } else if (index == i.ConstraintSet_android_transformPivotY) {
                    this.w0 = obtainStyledAttributes.getFloat(index, this.w0);
                } else if (index == i.ConstraintSet_android_translationX) {
                    this.x0 = obtainStyledAttributes.getFloat(index, this.x0);
                } else if (index == i.ConstraintSet_android_translationY) {
                    this.y0 = obtainStyledAttributes.getFloat(index, this.y0);
                } else if (index == i.ConstraintSet_android_translationZ) {
                    this.z0 = obtainStyledAttributes.getFloat(index, this.z0);
                }
            }
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public d getConstraintSet() {
        if (this.f1637b == null) {
            this.f1637b = new d();
        }
        d dVar = this.f1637b;
        if (dVar != null) {
            int childCount = getChildCount();
            dVar.f1604c.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                a aVar = (a) childAt.getLayoutParams();
                int id = childAt.getId();
                if (!dVar.f1603b || id != -1) {
                    if (!dVar.f1604c.containsKey(Integer.valueOf(id))) {
                        dVar.f1604c.put(Integer.valueOf(id), new d.a());
                    }
                    d.a aVar2 = dVar.f1604c.get(Integer.valueOf(id));
                    if (childAt instanceof b) {
                        b bVar = (b) childAt;
                        aVar2.c(id, aVar);
                        if (bVar instanceof Barrier) {
                            d.b bVar2 = aVar2.f1608d;
                            bVar2.d0 = 1;
                            Barrier barrier = (Barrier) bVar;
                            bVar2.b0 = barrier.getType();
                            aVar2.f1608d.e0 = barrier.getReferencedIds();
                            aVar2.f1608d.c0 = barrier.getMargin();
                        }
                    }
                    aVar2.c(id, aVar);
                } else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }
            return this.f1637b;
        }
        throw null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
