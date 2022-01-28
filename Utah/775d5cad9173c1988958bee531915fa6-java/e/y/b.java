package e.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import e.b.a.m;
import e.i.i.v;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class b extends h {
    public static final Property<Drawable, PointF> A = new a(PointF.class, "boundsOrigin");
    public static final Property<i, PointF> B = new C0063b(PointF.class, "topLeft");
    public static final Property<i, PointF> C = new c(PointF.class, "bottomRight");
    public static final Property<View, PointF> D = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> E = new e(PointF.class, "topLeft");
    public static final Property<View, PointF> F = new f(PointF.class, "position");
    public static f G = new f();
    public static final String[] z = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public int[] y = new int[2];

    public static class a extends Property<Drawable, PointF> {
        public Rect a = new Rect();

        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.a);
        }
    }

    /* renamed from: e.y.b$b  reason: collision with other inner class name */
    public static class C0063b extends Property<i, PointF> {
        public C0063b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            Objects.requireNonNull(iVar2);
            iVar2.a = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.b = round;
            int i2 = iVar2.f2040f + 1;
            iVar2.f2040f = i2;
            if (i2 == iVar2.f2041g) {
                s.b(iVar2.f2039e, iVar2.a, round, iVar2.c, iVar2.f2038d);
                iVar2.f2040f = 0;
                iVar2.f2041g = 0;
            }
        }
    }

    public static class c extends Property<i, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            Objects.requireNonNull(iVar2);
            iVar2.c = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.f2038d = round;
            int i2 = iVar2.f2041g + 1;
            iVar2.f2041g = i2;
            if (iVar2.f2040f == i2) {
                s.b(iVar2.f2039e, iVar2.a, iVar2.b, iVar2.c, round);
                iVar2.f2040f = 0;
                iVar2.f2041g = 0;
            }
        }
    }

    public static class d extends Property<View, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            s.b(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            s.b(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            s.b(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        private i mViewBounds;

        public g(b bVar, i iVar) {
            this.a = iVar;
            this.mViewBounds = iVar;
        }
    }

    public class h extends k {
        public boolean a = false;
        public final /* synthetic */ ViewGroup b;

        public h(b bVar, ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // e.y.k, e.y.h.d
        public void a(h hVar) {
            r.a(this.b, false);
        }

        @Override // e.y.k, e.y.h.d
        public void b(h hVar) {
            r.a(this.b, true);
        }

        @Override // e.y.k, e.y.h.d
        public void d(h hVar) {
            r.a(this.b, false);
            this.a = true;
        }

        @Override // e.y.h.d
        public void e(h hVar) {
            if (!this.a) {
                r.a(this.b, false);
            }
            hVar.v(this);
        }
    }

    public static class i {
        public int a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f2038d;

        /* renamed from: e  reason: collision with root package name */
        public View f2039e;

        /* renamed from: f  reason: collision with root package name */
        public int f2040f;

        /* renamed from: g  reason: collision with root package name */
        public int f2041g;

        public i(View view) {
            this.f2039e = view;
        }
    }

    public final void H(p pVar) {
        View view = pVar.b;
        AtomicInteger atomicInteger = v.a;
        if (v.g.c(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            pVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            pVar.a.put("android:changeBounds:parent", pVar.b.getParent());
        }
    }

    @Override // e.y.h
    public void d(p pVar) {
        H(pVar);
    }

    @Override // e.y.h
    public void g(p pVar) {
        H(pVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v11, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0114  */
    @Override // e.y.h
    public Animator k(ViewGroup viewGroup, p pVar, p pVar2) {
        int i2;
        ObjectAnimator objectAnimator;
        b bVar;
        Property<View, PointF> property;
        Path path;
        if (pVar == null || pVar2 == null) {
            return null;
        }
        Map<String, Object> map = pVar.a;
        Map<String, Object> map2 = pVar2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = pVar2.b;
        Rect rect = (Rect) pVar.a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) pVar2.a.get("android:changeBounds:bounds");
        int i3 = rect.left;
        int i4 = rect2.left;
        int i5 = rect.top;
        int i6 = rect2.top;
        int i7 = rect.right;
        int i8 = rect2.right;
        int i9 = rect.bottom;
        int i10 = rect2.bottom;
        int i11 = i7 - i3;
        int i12 = i9 - i5;
        int i13 = i8 - i4;
        int i14 = i10 - i6;
        Rect rect3 = (Rect) pVar.a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) pVar2.a.get("android:changeBounds:clip");
        if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
            i2 = 0;
        } else {
            i2 = (i3 == i4 && i5 == i6) ? 0 : 1;
            if (!(i7 == i8 && i9 == i10)) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        s.b(view, i3, i5, i7, i9);
        if (i2 != 2) {
            bVar = this;
            if (i3 == i4 && i5 == i6) {
                path = bVar.u.a((float) i7, (float) i9, (float) i8, (float) i10);
                property = D;
            } else {
                path = bVar.u.a((float) i3, (float) i5, (float) i4, (float) i6);
                property = E;
            }
        } else if (i11 == i13 && i12 == i14) {
            bVar = this;
            path = bVar.u.a((float) i3, (float) i5, (float) i4, (float) i6);
            property = F;
        } else {
            bVar = this;
            i iVar = new i(view);
            ObjectAnimator X0 = m.e.X0(iVar, B, bVar.u.a((float) i3, (float) i5, (float) i4, (float) i6));
            ObjectAnimator X02 = m.e.X0(iVar, C, bVar.u.a((float) i7, (float) i9, (float) i8, (float) i10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(X0, X02);
            animatorSet.addListener(new g(bVar, iVar));
            objectAnimator = animatorSet;
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                r.a(viewGroup4, true);
                bVar.a(new h(bVar, viewGroup4));
            }
            return objectAnimator;
        }
        objectAnimator = m.e.X0(view, property, path);
        if (view.getParent() instanceof ViewGroup) {
        }
        return objectAnimator;
    }

    @Override // e.y.h
    public String[] p() {
        return z;
    }
}
