package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e.j.j.v;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    public int a = 0;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f.b.a.e.o.a f642d;

        public a(View view, int i2, f.b.a.e.o.a aVar) {
            this.b = view;
            this.c = i2;
            this.f642d = aVar;
        }

        public boolean onPreDraw() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.a == this.c) {
                f.b.a.e.o.a aVar = this.f642d;
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
        f.b.a.e.o.a aVar = (f.b.a.e.o.a) view2;
        if (!B(aVar.a())) {
            return false;
        }
        this.a = aVar.a() ? 1 : 2;
        return C((View) aVar, view, aVar.a(), true);
    }

    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i2) {
        f.b.a.e.o.a aVar;
        AtomicInteger atomicInteger = v.a;
        if (!v.g.c(view)) {
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
                    aVar = (f.b.a.e.o.a) view2;
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
