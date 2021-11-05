package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.m;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a  reason: collision with root package name */
    public int f4575a = 0;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f4576b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4577c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.b.a.b.a0.a f4578d;

        public a(View view, int i, c.b.a.b.a0.a aVar) {
            this.f4576b = view;
            this.f4577c = i;
            this.f4578d = aVar;
        }

        public boolean onPreDraw() {
            this.f4576b.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.f4575a == this.f4577c) {
                c.b.a.b.a0.a aVar = this.f4578d;
                expandableBehavior.C((View) aVar, this.f4576b, aVar.a(), false);
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
            return this.f4575a == 1;
        }
        int i = this.f4575a;
        return i == 0 || i == 2;
    }

    public abstract boolean C(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
        c.b.a.b.a0.a aVar = (c.b.a.b.a0.a) view2;
        if (!B(aVar.a())) {
            return false;
        }
        this.f4575a = aVar.a() ? 1 : 2;
        return C((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
        c.b.a.b.a0.a aVar;
        if (!m.B(view)) {
            List<View> d2 = coordinatorLayout.d(view);
            int size = d2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = d2.get(i2);
                if (d(coordinatorLayout, view, view2)) {
                    aVar = (c.b.a.b.a0.a) view2;
                    break;
                }
                i2++;
            }
            if (aVar != null && B(aVar.a())) {
                int i3 = aVar.a() ? 1 : 2;
                this.f4575a = i3;
                view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, aVar));
            }
        }
        return false;
    }
}
