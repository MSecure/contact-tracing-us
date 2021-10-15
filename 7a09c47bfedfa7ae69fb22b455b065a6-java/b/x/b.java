package b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b.b.k.i;
import b.i.l.m;
import java.util.Map;

public class b extends i {
    public static final String[] M = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> N = new C0055b(PointF.class, "boundsOrigin");
    public static final Property<k, PointF> O = new c(PointF.class, "topLeft");
    public static final Property<k, PointF> P = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> Q = new e(PointF.class, "bottomRight");
    public static final Property<View, PointF> R = new f(PointF.class, "topLeft");
    public static final Property<View, PointF> S = new g(PointF.class, "position");
    public static g T = new g();
    public int[] J = new int[2];
    public boolean K = false;
    public boolean L = false;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f2634b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2635c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f2636d;

        public a(b bVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.f2633a = viewGroup;
            this.f2634b = bitmapDrawable;
            this.f2635c = view;
            this.f2636d = f2;
        }

        public void onAnimationEnd(Animator animator) {
            v a2 = w.a(this.f2633a);
            ((u) a2).f2725a.remove(this.f2634b);
            w.f2726a.e(this.f2635c, this.f2636d);
        }
    }

    /* renamed from: b.x.b$b  reason: collision with other inner class name */
    public static class C0055b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f2637a = new Rect();

        public C0055b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2637a);
            Rect rect = this.f2637a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.f2637a);
            this.f2637a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.f2637a);
        }
    }

    public static class c extends Property<k, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(k kVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(k kVar, PointF pointF) {
            k kVar2 = kVar;
            PointF pointF2 = pointF;
            if (kVar2 != null) {
                kVar2.f2648a = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                kVar2.f2649b = round;
                int i = kVar2.f2653f + 1;
                kVar2.f2653f = i;
                if (i == kVar2.f2654g) {
                    w.d(kVar2.f2652e, kVar2.f2648a, round, kVar2.f2650c, kVar2.f2651d);
                    kVar2.f2653f = 0;
                    kVar2.f2654g = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public static class d extends Property<k, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(k kVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(k kVar, PointF pointF) {
            k kVar2 = kVar;
            PointF pointF2 = pointF;
            if (kVar2 != null) {
                kVar2.f2650c = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                kVar2.f2651d = round;
                int i = kVar2.f2654g + 1;
                kVar2.f2654g = i;
                if (kVar2.f2653f == i) {
                    w.d(kVar2.f2652e, kVar2.f2648a, kVar2.f2649b, kVar2.f2650c, round);
                    kVar2.f2653f = 0;
                    kVar2.f2654g = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            w.d(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            w.d(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    public static class g extends Property<View, PointF> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            w.d(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f2638a;
        public k mViewBounds = this.f2638a;

        public h(b bVar, k kVar) {
            this.f2638a = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2639a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2640b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Rect f2641c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f2642d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f2644f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f2645g;

        public i(b bVar, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f2640b = view;
            this.f2641c = rect;
            this.f2642d = i;
            this.f2643e = i2;
            this.f2644f = i3;
            this.f2645g = i4;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2639a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f2639a) {
                m.Y(this.f2640b, this.f2641c);
                w.d(this.f2640b, this.f2642d, this.f2643e, this.f2644f, this.f2645g);
            }
        }
    }

    public class j extends l {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2646a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2647b;

        public j(b bVar, ViewGroup viewGroup) {
            this.f2647b = viewGroup;
        }

        @Override // b.x.l, b.x.i.d
        public void a(i iVar) {
            s.a(this.f2647b, false);
        }

        @Override // b.x.l, b.x.i.d
        public void b(i iVar) {
            s.a(this.f2647b, true);
        }

        @Override // b.x.l, b.x.i.d
        public void d(i iVar) {
            s.a(this.f2647b, false);
            this.f2646a = true;
        }

        @Override // b.x.i.d
        public void e(i iVar) {
            if (!this.f2646a) {
                s.a(this.f2647b, false);
            }
            iVar.y(this);
        }
    }

    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public int f2648a;

        /* renamed from: b  reason: collision with root package name */
        public int f2649b;

        /* renamed from: c  reason: collision with root package name */
        public int f2650c;

        /* renamed from: d  reason: collision with root package name */
        public int f2651d;

        /* renamed from: e  reason: collision with root package name */
        public View f2652e;

        /* renamed from: f  reason: collision with root package name */
        public int f2653f;

        /* renamed from: g  reason: collision with root package name */
        public int f2654g;

        public k(View view) {
            this.f2652e = view;
        }
    }

    public final void K(q qVar) {
        View view = qVar.f2713b;
        if (m.C(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            qVar.f2712a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            qVar.f2712a.put("android:changeBounds:parent", qVar.f2713b.getParent());
            if (this.L) {
                qVar.f2713b.getLocationInWindow(this.J);
                qVar.f2712a.put("android:changeBounds:windowX", Integer.valueOf(this.J[0]));
                qVar.f2712a.put("android:changeBounds:windowY", Integer.valueOf(this.J[1]));
            }
            if (this.K) {
                qVar.f2712a.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    @Override // b.x.i
    public void e(q qVar) {
        K(qVar);
    }

    @Override // b.x.i
    public void h(q qVar) {
        K(qVar);
    }

    @Override // b.x.i
    public Animator l(ViewGroup viewGroup, q qVar, q qVar2) {
        int i2;
        View view;
        AnimatorSet animatorSet;
        ObjectAnimator objectAnimator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator2;
        Property<View, PointF> property;
        Path path;
        q o;
        if (qVar == null || qVar2 == null) {
            return null;
        }
        Map<String, Object> map = qVar.f2712a;
        Map<String, Object> map2 = qVar2.f2712a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = qVar2.f2713b;
        if (!this.L || ((o = o(viewGroup2, true)) != null ? viewGroup3 == o.f2713b : viewGroup2 == viewGroup3)) {
            Rect rect2 = (Rect) qVar.f2712a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) qVar2.f2712a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) qVar.f2712a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) qVar2.f2712a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            if (!this.K) {
                view = view2;
                w.d(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        path = this.F.a((float) i4, (float) i6, (float) i5, (float) i7);
                        property = S;
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator T2 = i.j.T(kVar, O, this.F.a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator T3 = i.j.T(kVar, P, this.F.a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.playTogether(T2, T3);
                        animatorSet2.addListener(new h(this, kVar));
                        animatorSet = animatorSet2;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    path = this.F.a((float) i8, (float) i10, (float) i9, (float) i11);
                    property = Q;
                } else {
                    path = this.F.a((float) i4, (float) i6, (float) i5, (float) i7);
                    property = R;
                }
                animatorSet = i.j.T(view, property, path);
            } else {
                view = view2;
                w.d(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                if (i4 == i5 && i6 == i7) {
                    objectAnimator = null;
                } else {
                    objectAnimator = i.j.T(view, S, this.F.a((float) i4, (float) i6, (float) i5, (float) i7));
                }
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (!rect.equals(rect6)) {
                    m.Y(view, rect);
                    g gVar = T;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", gVar, objArr);
                    ofObject.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animatorSet = p.b(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                s.a(viewGroup4, true);
                a(new j(this, viewGroup4));
            }
            return animatorSet;
        }
        int intValue = ((Integer) qVar.f2712a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) qVar.f2712a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) qVar2.f2712a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) qVar2.f2712a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.J);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float b2 = w.b(view2);
        w.f2726a.e(view2, 0.0f);
        viewGroup.getOverlay().add(bitmapDrawable);
        e eVar = this.F;
        int[] iArr = this.J;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolder.ofObject(N, (TypeConverter) null, eVar.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1]))));
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, b2));
        return ofPropertyValuesHolder;
    }

    @Override // b.x.i
    public String[] r() {
        return M;
    }
}
