package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e.i.i.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    public int a = 0;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f.b.a.d.o.a f631d;

        public a(View view, int i2, f.b.a.d.o.a aVar) {
            this.b = view;
            this.c = i2;
            this.f631d = aVar;
        }

        public boolean onPreDraw() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.a == this.c) {
                f.b.a.d.o.a aVar = this.f631d;
                expandableBehavior.C((View) aVar, this.b, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean B(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i2 = this.a;
        return i2 == 0 || i2 == 2;
    }

    public abstract boolean C(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
        f.b.a.d.o.a aVar = (f.b.a.d.o.a) view2;
        if (!B(aVar.a())) {
            return false;
        }
        this.a = aVar.a() ? 1 : 2;
        return C((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i2) {
        f.b.a.d.o.a aVar;
        AtomicInteger atomicInteger = l.a;
        if (!view.isLaidOut()) {
            List<View> d2 = coordinatorLayout.d(view);
            int size = d2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = d2.get(i3);
                if (d(coordinatorLayout, view, view2)) {
                    aVar = (f.b.a.d.o.a) view2;
                    break;
                }
                i3++;
            }
            if (aVar != null && B(aVar.a())) {
                int i4 = aVar.a() ? 1 : 2;
                this.a = i4;
                view.getViewTreeObserver().addOnPreDrawListener(new a(view, i4, aVar));
            }
        }
        return false;
    }
}
