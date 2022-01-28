package b.v;

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
    public static final Property<Drawable, PointF> N = new C0045b(PointF.class, "boundsOrigin");
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
        public final /* synthetic */ ViewGroup f1756a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f1757b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f1758c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f1759d;

        public a(b bVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.f1756a = viewGroup;
            this.f1757b = bitmapDrawable;
            this.f1758c = view;
            this.f1759d = f;
        }

        public void onAnimationEnd(Animator animator) {
            u a2 = v.a(this.f1756a);
            ((t) a2).f1831a.remove(this.f1757b);
            v.f1832a.e(this.f1758c, this.f1759d);
        }
    }

    /* renamed from: b.v.b$b  reason: collision with other inner class name */
    public static class C0045b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f1760a = new Rect();

        public C0045b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f1760a);
            Rect rect = this.f1760a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.f1760a);
            this.f1760a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.f1760a);
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
                kVar2.f1769a = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                kVar2.f1770b = round;
                int i = kVar2.f + 1;
                kVar2.f = i;
                if (i == kVar2.g) {
                    v.d(kVar2.f1773e, kVar2.f1769a, round, kVar2.f1771c, kVar2.f1772d);
                    kVar2.f = 0;
                    kVar2.g = 0;
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
                kVar2.f1771c = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                kVar2.f1772d = round;
                int i = kVar2.g + 1;
                kVar2.g = i;
                if (kVar2.f == i) {
                    v.d(kVar2.f1773e, kVar2.f1769a, kVar2.f1770b, kVar2.f1771c, round);
                    kVar2.f = 0;
                    kVar2.g = 0;
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
            v.d(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
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
            v.d(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
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
            v.d(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f1761a;
        public k mViewBounds = this.f1761a;

        public h(b bVar, k kVar) {
            this.f1761a = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1762a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1763b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Rect f1764c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f1765d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f1766e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public i(b bVar, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f1763b = view;
            this.f1764c = rect;
            this.f1765d = i;
            this.f1766e = i2;
            this.f = i3;
            this.g = i4;
        }

        public void onAnimationCancel(Animator animator) {
            this.f1762a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1762a) {
                m.X(this.f1763b, this.f1764c);
                v.d(this.f1763b, this.f1765d, this.f1766e, this.f, this.g);
            }
        }
    }

    public class j extends l {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1767a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1768b;

        public j(b bVar, ViewGroup viewGroup) {
            this.f1768b = viewGroup;
        }

        @Override // b.v.l, b.v.i.d
        public void a(i iVar) {
            s.a(this.f1768b, false);
        }

        @Override // b.v.l, b.v.i.d
        public void b(i iVar) {
            s.a(this.f1768b, true);
        }

        @Override // b.v.l, b.v.i.d
        public void d(i iVar) {
            s.a(this.f1768b, false);
            this.f1767a = true;
        }

        @Override // b.v.i.d
        public void e(i iVar) {
            if (!this.f1767a) {
                s.a(this.f1768b, false);
            }
            iVar.w(this);
        }
    }

    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public int f1769a;

        /* renamed from: b  reason: collision with root package name */
        public int f1770b;

        /* renamed from: c  reason: collision with root package name */
        public int f1771c;

        /* renamed from: d  reason: collision with root package name */
        public int f1772d;

        /* renamed from: e  reason: collision with root package name */
        public View f1773e;
        public int f;
        public int g;

        public k(View view) {
            this.f1773e = view;
        }
    }

    public final void I(q qVar) {
        View view = qVar.f1824b;
        if (m.B(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            qVar.f1823a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            qVar.f1823a.put("android:changeBounds:parent", qVar.f1824b.getParent());
            if (this.L) {
                qVar.f1824b.getLocationInWindow(this.J);
                qVar.f1823a.put("android:changeBounds:windowX", Integer.valueOf(this.J[0]));
                qVar.f1823a.put("android:changeBounds:windowY", Integer.valueOf(this.J[1]));
            }
            if (this.K) {
                qVar.f1823a.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    @Override // b.v.i
    public void e(q qVar) {
        I(qVar);
    }

    @Override // b.v.i
    public void h(q qVar) {
        I(qVar);
    }

    @Override // b.v.i
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
        Map<String, Object> map = qVar.f1823a;
        Map<String, Object> map2 = qVar2.f1823a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = qVar2.f1824b;
        if (!this.L || ((o = o(viewGroup2, true)) != null ? viewGroup3 == o.f1824b : viewGroup2 == viewGroup3)) {
            Rect rect2 = (Rect) qVar.f1823a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) qVar2.f1823a.get("android:changeBounds:bounds");
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
            Rect rect4 = (Rect) qVar.f1823a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) qVar2.f1823a.get("android:changeBounds:clip");
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
                v.d(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        path = this.F.a((float) i4, (float) i6, (float) i5, (float) i7);
                        property = S;
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator D0 = i.j.D0(kVar, O, this.F.a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator D02 = i.j.D0(kVar, P, this.F.a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.playTogether(D0, D02);
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
                animatorSet = i.j.D0(view, property, path);
            } else {
                view = view2;
                v.d(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                if (i4 == i5 && i6 == i7) {
                    objectAnimator = null;
                } else {
                    objectAnimator = i.j.D0(view, S, this.F.a((float) i4, (float) i6, (float) i5, (float) i7));
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
                    m.X(view, rect);
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
        int intValue = ((Integer) qVar.f1823a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) qVar.f1823a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) qVar2.f1823a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) qVar2.f1823a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.J);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float b2 = v.b(view2);
        v.f1832a.e(view2, 0.0f);
        viewGroup.getOverlay().add(bitmapDrawable);
        e eVar = this.F;
        int[] iArr = this.J;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolder.ofObject(N, (TypeConverter) null, eVar.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1]))));
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, b2));
        return ofPropertyValuesHolder;
    }

    @Override // b.v.i
    public String[] q() {
        return M;
    }
}
