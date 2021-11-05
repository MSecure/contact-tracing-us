package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import b.b.k.i;
import b.i.l.l;
import b.i.l.m;
import b.i.l.w.b;
import b.x.t;
import c.b.a.b.k;
import c.b.a.b.o.a;
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.android.gms.nearby.messages.Strategy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ViewPager.d
public class TabLayout extends HorizontalScrollView {
    public static final int P = k.Widget_Design_TabLayout;
    public static final b.i.k.b<g> Q = new b.i.k.c(16);
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public c E;
    public final ArrayList<c> F = new ArrayList<>();
    public c G;
    public ValueAnimator H;
    public ViewPager I;
    public b.a0.a.a J;
    public DataSetObserver K;
    public h L;
    public b M;
    public boolean N;
    public final b.i.k.b<i> O = new b.i.k.b<>(12);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<g> f6123b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public g f6124c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f6125d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    public final f f6126e;

    /* renamed from: f  reason: collision with root package name */
    public int f6127f;

    /* renamed from: g  reason: collision with root package name */
    public int f6128g;
    public int h;
    public int i;
    public int j;
    public ColorStateList k;
    public ColorStateList l;
    public ColorStateList m;
    public Drawable n;
    public PorterDuff.Mode o;
    public float p;
    public float q;
    public final int r;
    public int s = Integer.MAX_VALUE;
    public final int t;
    public final int u;
    public final int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.h {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6130a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void a(ViewPager viewPager, b.a0.a.a aVar, b.a0.a.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.I == viewPager) {
                tabLayout.k(aVar2, this.f6130a);
            }
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface d extends c<g> {
    }

    public class e extends DataSetObserver {
        public e() {
        }

        public void onChanged() {
            TabLayout.this.i();
        }

        public void onInvalidated() {
            TabLayout.this.i();
        }
    }

    public class f extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        public int f6133b;

        /* renamed from: c  reason: collision with root package name */
        public final Paint f6134c;

        /* renamed from: d  reason: collision with root package name */
        public final GradientDrawable f6135d;

        /* renamed from: e  reason: collision with root package name */
        public int f6136e = -1;

        /* renamed from: f  reason: collision with root package name */
        public float f6137f;

        /* renamed from: g  reason: collision with root package name */
        public int f6138g = -1;
        public int h = -1;
        public int i = -1;
        public ValueAnimator j;
        public int k = -1;
        public int l = -1;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f6139a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f6140b;

            public a(int i, int i2) {
                this.f6139a = i;
                this.f6140b = i2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                f fVar = f.this;
                int b2 = c.b.a.b.m.a.b(fVar.k, this.f6139a, animatedFraction);
                int i = f.this.l;
                int round = Math.round(animatedFraction * ((float) (this.f6140b - i))) + i;
                if (b2 != fVar.h || round != fVar.i) {
                    fVar.h = b2;
                    fVar.i = round;
                    m.M(fVar);
                }
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f6142a;

            public b(int i) {
                this.f6142a = i;
            }

            public void onAnimationEnd(Animator animator) {
                f fVar = f.this;
                fVar.f6136e = this.f6142a;
                fVar.f6137f = 0.0f;
            }

            public void onAnimationStart(Animator animator) {
                f.this.f6136e = this.f6142a;
            }
        }

        public f(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f6134c = new Paint();
            this.f6135d = new GradientDrawable();
        }

        public final void a(i iVar, RectF rectF) {
            int contentWidth = iVar.getContentWidth();
            int f1 = (int) t.f1(getContext(), 24);
            if (contentWidth < f1) {
                contentWidth = f1;
            }
            int right = (iVar.getRight() + iVar.getLeft()) / 2;
            int i2 = contentWidth / 2;
            rectF.set((float) (right - i2), 0.0f, (float) (right + i2), 0.0f);
        }

        public final void b() {
            int i2;
            View childAt = getChildAt(this.f6136e);
            int i3 = -1;
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
            } else {
                int left = childAt.getLeft();
                int right = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.C && (childAt instanceof i)) {
                    a((i) childAt, tabLayout.f6125d);
                    RectF rectF = TabLayout.this.f6125d;
                    left = (int) rectF.left;
                    right = (int) rectF.right;
                }
                if (this.f6137f <= 0.0f || this.f6136e >= getChildCount() - 1) {
                    i3 = left;
                    i2 = right;
                } else {
                    View childAt2 = getChildAt(this.f6136e + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.C && (childAt2 instanceof i)) {
                        a((i) childAt2, tabLayout2.f6125d);
                        RectF rectF2 = TabLayout.this.f6125d;
                        left2 = (int) rectF2.left;
                        right2 = (int) rectF2.right;
                    }
                    float f2 = this.f6137f;
                    float f3 = 1.0f - f2;
                    i3 = (int) ((((float) left) * f3) + (((float) left2) * f2));
                    i2 = (int) ((f3 * ((float) right)) + (((float) right2) * f2));
                }
            }
            if (i3 != this.h || i2 != this.i) {
                this.h = i3;
                this.i = i2;
                m.M(this);
            }
        }

        public final void c(boolean z, int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.C && (childAt instanceof i)) {
                a((i) childAt, tabLayout.f6125d);
                RectF rectF = TabLayout.this.f6125d;
                left = (int) rectF.left;
                right = (int) rectF.right;
            }
            int i4 = this.h;
            int i5 = this.i;
            if (i4 != left || i5 != right) {
                if (z) {
                    this.k = i4;
                    this.l = i5;
                }
                a aVar = new a(left, right);
                if (z) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.j = valueAnimator;
                    valueAnimator.setInterpolator(c.b.a.b.m.a.f4411b);
                    valueAnimator.setDuration((long) i3);
                    valueAnimator.setFloatValues(0.0f, 1.0f);
                    valueAnimator.addUpdateListener(aVar);
                    valueAnimator.addListener(new b(i2));
                    valueAnimator.start();
                    return;
                }
                this.j.removeAllUpdateListeners();
                this.j.addUpdateListener(aVar);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
        public void draw(Canvas canvas) {
            Drawable drawable;
            Paint paint;
            Drawable drawable2 = TabLayout.this.n;
            int i2 = 0;
            int intrinsicHeight = drawable2 != null ? drawable2.getIntrinsicHeight() : 0;
            int i3 = this.f6133b;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.z;
            if (i4 != 0) {
                if (i4 == 1) {
                    i2 = (getHeight() - intrinsicHeight) / 2;
                    intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
                } else if (i4 != 2) {
                    if (i4 != 3) {
                        intrinsicHeight = 0;
                    }
                }
                int i5 = this.h;
                if (i5 >= 0 && this.i > i5) {
                    drawable = TabLayout.this.n;
                    if (drawable == null) {
                        drawable = this.f6135d;
                    }
                    Drawable mutate = drawable.mutate();
                    mutate.setBounds(this.h, i2, this.i, intrinsicHeight);
                    paint = this.f6134c;
                    if (paint != null) {
                        mutate.setTint(paint.getColor());
                    }
                    mutate.draw(canvas);
                }
                super.draw(canvas);
            }
            i2 = getHeight() - intrinsicHeight;
            intrinsicHeight = getHeight();
            int i52 = this.h;
            drawable = TabLayout.this.n;
            if (drawable == null) {
            }
            Drawable mutate2 = drawable.mutate();
            mutate2.setBounds(this.h, i2, this.i, intrinsicHeight);
            paint = this.f6134c;
            if (paint != null) {
            }
            mutate2.draw(canvas);
            super.draw(canvas);
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
            } else {
                c(false, this.f6136e, -1);
            }
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.x == 1 || tabLayout.A == 2) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (((int) t.f1(getContext(), 16)) * 2)) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.x = 0;
                            tabLayout2.p(false);
                        }
                        if (z) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f6144a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f6145b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f6146c;

        /* renamed from: d  reason: collision with root package name */
        public int f6147d = -1;

        /* renamed from: e  reason: collision with root package name */
        public View f6148e;

        /* renamed from: f  reason: collision with root package name */
        public int f6149f = 1;

        /* renamed from: g  reason: collision with root package name */
        public TabLayout f6150g;
        public i h;

        public g a(int i) {
            TabLayout tabLayout = this.f6150g;
            if (tabLayout != null) {
                b(b.b.l.a.a.b(tabLayout.getContext(), i));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g b(Drawable drawable) {
            this.f6144a = drawable;
            TabLayout tabLayout = this.f6150g;
            if (tabLayout.x == 1 || tabLayout.A == 2) {
                this.f6150g.p(true);
            }
            e();
            return this;
        }

        public g c(int i) {
            TabLayout tabLayout = this.f6150g;
            if (tabLayout != null) {
                d(tabLayout.getResources().getText(i));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g d(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f6146c) && !TextUtils.isEmpty(charSequence)) {
                this.h.setContentDescription(charSequence);
            }
            this.f6145b = charSequence;
            e();
            return this;
        }

        public void e() {
            i iVar = this.h;
            if (iVar != null) {
                iVar.i();
            }
        }
    }

    public static class h implements ViewPager.i {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<TabLayout> f6151a;

        /* renamed from: b  reason: collision with root package name */
        public int f6152b;

        /* renamed from: c  reason: collision with root package name */
        public int f6153c;

        public h(TabLayout tabLayout) {
            this.f6151a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f2, int i2) {
            TabLayout tabLayout = this.f6151a.get();
            if (tabLayout != null) {
                boolean z = false;
                boolean z2 = this.f6153c != 2 || this.f6152b == 1;
                if (!(this.f6153c == 2 && this.f6152b == 0)) {
                    z = true;
                }
                tabLayout.l(i, f2, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            this.f6152b = this.f6153c;
            this.f6153c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
            TabLayout tabLayout = this.f6151a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.f6153c;
                tabLayout.j(tabLayout.g(i), i2 == 0 || (i2 == 2 && this.f6152b == 0));
            }
        }
    }

    public final class i extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        public g f6154b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f6155c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f6156d;

        /* renamed from: e  reason: collision with root package name */
        public View f6157e;

        /* renamed from: f  reason: collision with root package name */
        public c.b.a.b.o.a f6158f;

        /* renamed from: g  reason: collision with root package name */
        public View f6159g;
        public TextView h;
        public ImageView i;
        public Drawable j;
        public int k = 2;

        public i(Context context) {
            super(context);
            j(context);
            setPaddingRelative(TabLayout.this.f6127f, TabLayout.this.f6128g, TabLayout.this.h, TabLayout.this.i);
            setGravity(17);
            setOrientation(!TabLayout.this.B ? 1 : 0);
            setClickable(true);
            l lVar = Build.VERSION.SDK_INT >= 24 ? new l(PointerIcon.getSystemIcon(getContext(), 1002)) : new l(null);
            if (Build.VERSION.SDK_INT >= 24) {
                setPointerIcon((PointerIcon) lVar.f1866a);
            }
        }

        private c.b.a.b.o.a getBadge() {
            return this.f6158f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private int getContentWidth() {
            View[] viewArr = {this.f6155c, this.f6156d, this.f6159g};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        private c.b.a.b.o.a getOrCreateBadge() {
            if (this.f6158f == null) {
                Context context = getContext();
                int i2 = c.b.a.b.o.a.s;
                int i3 = c.b.a.b.o.a.r;
                c.b.a.b.o.a aVar = new c.b.a.b.o.a(context);
                TypedArray d2 = c.b.a.b.c0.k.d(context, null, c.b.a.b.l.Badge, i2, i3, new int[0]);
                int i4 = d2.getInt(c.b.a.b.l.Badge_maxCharacterCount, 4);
                a.C0077a aVar2 = aVar.i;
                if (aVar2.f4481f != i4) {
                    aVar2.f4481f = i4;
                    aVar.l = ((int) Math.pow(10.0d, ((double) i4) - 1.0d)) - 1;
                    aVar.f4473d.f4212d = true;
                    aVar.e();
                    aVar.invalidateSelf();
                }
                if (d2.hasValue(c.b.a.b.l.Badge_number)) {
                    int max = Math.max(0, d2.getInt(c.b.a.b.l.Badge_number, 0));
                    a.C0077a aVar3 = aVar.i;
                    if (aVar3.f4480e != max) {
                        aVar3.f4480e = max;
                        aVar.f4473d.f4212d = true;
                        aVar.e();
                        aVar.invalidateSelf();
                    }
                }
                int defaultColor = t.B1(context, d2, c.b.a.b.l.Badge_backgroundColor).getDefaultColor();
                aVar.i.f4477b = defaultColor;
                ColorStateList valueOf = ColorStateList.valueOf(defaultColor);
                c.b.a.b.h0.g gVar = aVar.f4472c;
                if (gVar.f4261b.f4271d != valueOf) {
                    gVar.r(valueOf);
                    aVar.invalidateSelf();
                }
                if (d2.hasValue(c.b.a.b.l.Badge_badgeTextColor)) {
                    int defaultColor2 = t.B1(context, d2, c.b.a.b.l.Badge_badgeTextColor).getDefaultColor();
                    aVar.i.f4478c = defaultColor2;
                    if (aVar.f4473d.f4209a.getColor() != defaultColor2) {
                        aVar.f4473d.f4209a.setColor(defaultColor2);
                        aVar.invalidateSelf();
                    }
                }
                int i5 = d2.getInt(c.b.a.b.l.Badge_badgeGravity, 8388661);
                a.C0077a aVar4 = aVar.i;
                if (aVar4.j != i5) {
                    aVar4.j = i5;
                    WeakReference<View> weakReference = aVar.p;
                    if (!(weakReference == null || weakReference.get() == null)) {
                        View view = aVar.p.get();
                        WeakReference<ViewGroup> weakReference2 = aVar.q;
                        ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
                        aVar.p = new WeakReference<>(view);
                        aVar.q = new WeakReference<>(viewGroup);
                        aVar.e();
                        aVar.invalidateSelf();
                    }
                }
                aVar.i.k = d2.getDimensionPixelOffset(c.b.a.b.l.Badge_horizontalOffset, 0);
                aVar.e();
                aVar.i.l = d2.getDimensionPixelOffset(c.b.a.b.l.Badge_verticalOffset, 0);
                aVar.e();
                d2.recycle();
                this.f6158f = aVar;
            }
            g();
            c.b.a.b.o.a aVar5 = this.f6158f;
            if (aVar5 != null) {
                return aVar5;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final boolean d() {
            return this.f6158f != null;
        }

        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.j;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.j.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e(View view) {
            if (d() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                c.b.a.b.o.a aVar = this.f6158f;
                c.b.a.b.o.b.a(aVar, view, null);
                view.getOverlay().add(aVar);
                this.f6157e = view;
            }
        }

        public final void f() {
            if (d()) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f6157e;
                if (view != null) {
                    c.b.a.b.o.a aVar = this.f6158f;
                    if (aVar != null) {
                        view.getOverlay().remove(aVar);
                    }
                    this.f6157e = null;
                }
            }
        }

        public final void g() {
            g gVar;
            View view;
            g gVar2;
            if (d()) {
                if (this.f6159g == null) {
                    View view2 = this.f6156d;
                    if (view2 == null || (gVar2 = this.f6154b) == null || gVar2.f6144a == null) {
                        view2 = this.f6155c;
                        if (!(view2 == null || (gVar = this.f6154b) == null || gVar.f6149f != 1)) {
                            if (this.f6157e != view2) {
                                f();
                                view = this.f6155c;
                            }
                            h(view2);
                            return;
                        }
                    } else {
                        if (this.f6157e != view2) {
                            f();
                            view = this.f6156d;
                        }
                        h(view2);
                        return;
                    }
                    e(view);
                    return;
                }
                f();
            }
        }

        public g getTab() {
            return this.f6154b;
        }

        public final void h(View view) {
            if (d() && view == this.f6157e) {
                c.b.a.b.o.a aVar = this.f6158f;
                ImageView imageView = this.f6156d;
                c.b.a.b.o.b.a(aVar, view, null);
            }
        }

        public final void i() {
            Drawable drawable;
            g gVar = this.f6154b;
            Drawable drawable2 = null;
            View view = gVar != null ? gVar.f6148e : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f6159g = view;
                TextView textView = this.f6155c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f6156d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f6156d.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.h = textView2;
                if (textView2 != null) {
                    this.k = textView2.getMaxLines();
                }
                this.i = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.f6159g;
                if (view2 != null) {
                    removeView(view2);
                    this.f6159g = null;
                }
                this.h = null;
                this.i = null;
            }
            boolean z = false;
            if (this.f6159g == null) {
                if (this.f6156d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f6156d = imageView2;
                    addView(imageView2, 0);
                }
                if (!(gVar == null || (drawable = gVar.f6144a) == null)) {
                    drawable2 = drawable.mutate();
                }
                if (drawable2 != null) {
                    drawable2.setTintList(TabLayout.this.l);
                    PorterDuff.Mode mode = TabLayout.this.o;
                    if (mode != null) {
                        drawable2.setTintMode(mode);
                    }
                }
                if (this.f6155c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_layout_tab_text, (ViewGroup) this, false);
                    this.f6155c = textView3;
                    addView(textView3);
                    this.k = this.f6155c.getMaxLines();
                }
                this.f6155c.setTextAppearance(TabLayout.this.j);
                ColorStateList colorStateList = TabLayout.this.k;
                if (colorStateList != null) {
                    this.f6155c.setTextColor(colorStateList);
                }
                k(this.f6155c, this.f6156d);
                g();
                ImageView imageView3 = this.f6156d;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new c.b.a.b.k0.b(this, imageView3));
                }
                TextView textView4 = this.f6155c;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new c.b.a.b.k0.b(this, textView4));
                }
            } else if (!(this.h == null && this.i == null)) {
                k(this.h, this.i);
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f6146c)) {
                setContentDescription(gVar.f6146c);
            }
            if (gVar != null) {
                TabLayout tabLayout = gVar.f6150g;
                if (tabLayout != null) {
                    if (tabLayout.getSelectedTabPosition() == gVar.f6147d) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            setSelected(z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v5, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void j(Context context) {
            int i2 = TabLayout.this.r;
            GradientDrawable gradientDrawable = null;
            if (i2 != 0) {
                Drawable b2 = b.b.l.a.a.b(context, i2);
                this.j = b2;
                if (b2 != null && b2.isStateful()) {
                    this.j.setState(getDrawableState());
                }
            } else {
                this.j = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.m != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateList = TabLayout.this.m;
                ColorStateList colorStateList2 = new ColorStateList(new int[][]{c.b.a.b.f0.a.j, StateSet.NOTHING}, new int[]{c.b.a.b.f0.a.a(colorStateList, c.b.a.b.f0.a.f4248f), c.b.a.b.f0.a.a(colorStateList, c.b.a.b.f0.a.f4244b)});
                if (TabLayout.this.D) {
                    gradientDrawable2 = null;
                }
                if (!TabLayout.this.D) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(colorStateList2, gradientDrawable2, gradientDrawable);
            }
            m.X(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        public final void k(TextView textView, ImageView imageView) {
            Drawable drawable;
            g gVar = this.f6154b;
            CharSequence charSequence = null;
            Drawable mutate = (gVar == null || (drawable = gVar.f6144a) == null) ? null : drawable.mutate();
            g gVar2 = this.f6154b;
            CharSequence charSequence2 = gVar2 != null ? gVar2.f6145b : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequence2);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence2);
                    if (this.f6154b.f6149f == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int f1 = (!z || imageView.getVisibility() != 0) ? 0 : (int) t.f1(getContext(), 8);
                if (TabLayout.this.B) {
                    if (f1 != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(f1);
                        marginLayoutParams.bottomMargin = 0;
                    }
                } else if (f1 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = f1;
                    marginLayoutParams.setMarginEnd(0);
                }
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
            g gVar3 = this.f6154b;
            CharSequence charSequence3 = gVar3 != null ? gVar3.f6146c : null;
            if (!z) {
                charSequence = charSequence3;
            }
            i.j.i0(this, charSequence);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            Context context;
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            c.b.a.b.o.a aVar = this.f6158f;
            if (aVar != null && aVar.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                StringBuilder sb = new StringBuilder();
                sb.append((Object) contentDescription);
                sb.append(", ");
                c.b.a.b.o.a aVar2 = this.f6158f;
                Object obj = null;
                if (aVar2.isVisible()) {
                    if (!aVar2.d()) {
                        obj = aVar2.i.f4482g;
                    } else if (aVar2.i.h > 0 && (context = aVar2.f4471b.get()) != null) {
                        int c2 = aVar2.c();
                        int i2 = aVar2.l;
                        obj = c2 <= i2 ? context.getResources().getQuantityString(aVar2.i.h, aVar2.c(), Integer.valueOf(aVar2.c())) : context.getString(aVar2.i.i, Integer.valueOf(i2));
                    }
                }
                sb.append(obj);
                accessibilityNodeInfo.setContentDescription(sb.toString());
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) b.c.a(0, 1, this.f6154b.f6147d, 1, false, isSelected()).f1917a);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) b.a.f1909e.f1912a);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", "Tab");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x0095;
         */
        public void onMeasure(int i2, int i3) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.s, BleSignal.UNKNOWN_TX_POWER);
            }
            super.onMeasure(i2, i3);
            if (this.f6155c != null) {
                float f2 = TabLayout.this.p;
                int i4 = this.k;
                ImageView imageView = this.f6156d;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f6155c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.q;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f6155c.getTextSize();
                int lineCount = this.f6155c.getLineCount();
                int maxLines = this.f6155c.getMaxLines();
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                    if (TabLayout.this.A == 1 && i5 > 0 && lineCount == 1) {
                        Layout layout = this.f6155c.getLayout();
                        if (layout != null) {
                        }
                        z = false;
                    }
                    if (z) {
                        this.f6155c.setTextSize(0, f2);
                        this.f6155c.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f6154b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            g gVar = this.f6154b;
            TabLayout tabLayout = gVar.f6150g;
            if (tabLayout != null) {
                tabLayout.j(gVar, true);
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.f6155c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f6156d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f6159g;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.f6154b) {
                this.f6154b = gVar;
                i();
            }
        }
    }

    public static class j implements d {

        /* renamed from: a  reason: collision with root package name */
        public final ViewPager f6160a;

        public j(ViewPager viewPager) {
            this.f6160a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.f6160a.setCurrentItem(gVar.f6147d);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r3, P), attributeSet, r3);
        int i2 = c.b.a.b.b.tabStyle;
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f6126e = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray d2 = c.b.a.b.c0.k.d(context2, attributeSet, c.b.a.b.l.TabLayout, i2, P, c.b.a.b.l.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            c.b.a.b.h0.g gVar = new c.b.a.b.h0.g();
            gVar.r(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            gVar.f4261b.f4269b = new c.b.a.b.z.a(context2);
            gVar.z();
            gVar.q(m.l(this));
            setBackground(gVar);
        }
        f fVar2 = this.f6126e;
        int dimensionPixelSize = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabIndicatorHeight, -1);
        if (fVar2.f6133b != dimensionPixelSize) {
            fVar2.f6133b = dimensionPixelSize;
            m.M(fVar2);
        }
        f fVar3 = this.f6126e;
        int color = d2.getColor(c.b.a.b.l.TabLayout_tabIndicatorColor, 0);
        if (fVar3.f6134c.getColor() != color) {
            fVar3.f6134c.setColor(color);
            m.M(fVar3);
        }
        setSelectedTabIndicator(t.F1(context2, d2, c.b.a.b.l.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(d2.getInt(c.b.a.b.l.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(d2.getBoolean(c.b.a.b.l.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize2 = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabPadding, 0);
        this.i = dimensionPixelSize2;
        this.h = dimensionPixelSize2;
        this.f6128g = dimensionPixelSize2;
        this.f6127f = dimensionPixelSize2;
        this.f6127f = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabPaddingStart, dimensionPixelSize2);
        this.f6128g = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabPaddingTop, this.f6128g);
        this.h = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabPaddingEnd, this.h);
        this.i = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabPaddingBottom, this.i);
        int resourceId = d2.getResourceId(c.b.a.b.l.TabLayout_tabTextAppearance, k.TextAppearance_Design_Tab);
        this.j = resourceId;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, b.b.j.TextAppearance);
        try {
            this.p = (float) obtainStyledAttributes.getDimensionPixelSize(b.b.j.TextAppearance_android_textSize, 0);
            this.k = t.B1(context2, obtainStyledAttributes, b.b.j.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (d2.hasValue(c.b.a.b.l.TabLayout_tabTextColor)) {
                this.k = t.B1(context2, d2, c.b.a.b.l.TabLayout_tabTextColor);
            }
            if (d2.hasValue(c.b.a.b.l.TabLayout_tabSelectedTextColor)) {
                int color2 = d2.getColor(c.b.a.b.l.TabLayout_tabSelectedTextColor, 0);
                int defaultColor = this.k.getDefaultColor();
                this.k = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{color2, defaultColor});
            }
            this.l = t.B1(context2, d2, c.b.a.b.l.TabLayout_tabIconTint);
            this.o = t.m2(d2.getInt(c.b.a.b.l.TabLayout_tabIconTintMode, -1), null);
            this.m = t.B1(context2, d2, c.b.a.b.l.TabLayout_tabRippleColor);
            this.y = d2.getInt(c.b.a.b.l.TabLayout_tabIndicatorAnimationDuration, Strategy.TTL_SECONDS_DEFAULT);
            this.t = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabMinWidth, -1);
            this.u = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabMaxWidth, -1);
            this.r = d2.getResourceId(c.b.a.b.l.TabLayout_tabBackground, 0);
            this.w = d2.getDimensionPixelSize(c.b.a.b.l.TabLayout_tabContentStart, 0);
            this.A = d2.getInt(c.b.a.b.l.TabLayout_tabMode, 1);
            this.x = d2.getInt(c.b.a.b.l.TabLayout_tabGravity, 0);
            this.B = d2.getBoolean(c.b.a.b.l.TabLayout_tabInlineLabel, false);
            this.D = d2.getBoolean(c.b.a.b.l.TabLayout_tabUnboundedRipple, false);
            d2.recycle();
            Resources resources = getResources();
            this.q = (float) resources.getDimensionPixelSize(c.b.a.b.d.design_tab_text_size_2line);
            this.v = resources.getDimensionPixelSize(c.b.a.b.d.design_tab_scrollable_min_width);
            d();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getDefaultHeight() {
        int size = this.f6123b.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f6123b.get(i2);
                if (gVar != null && gVar.f6144a != null && !TextUtils.isEmpty(gVar.f6145b)) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.B) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.A;
        if (i3 == 0 || i3 == 2) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f6126e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f6126e.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f6126e.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    public void a(g gVar, boolean z2) {
        int size = this.f6123b.size();
        if (gVar.f6150g == this) {
            gVar.f6147d = size;
            this.f6123b.add(size, gVar);
            int size2 = this.f6123b.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                }
                this.f6123b.get(size).f6147d = size;
            }
            i iVar = gVar.h;
            iVar.setSelected(false);
            iVar.setActivated(false);
            f fVar = this.f6126e;
            int i2 = gVar.f6147d;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            o(layoutParams);
            fVar.addView(iVar, i2, layoutParams);
            if (z2) {
                TabLayout tabLayout = gVar.f6150g;
                if (tabLayout != null) {
                    tabLayout.j(gVar, true);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void addView(View view) {
        b(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        b(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    public final void b(View view) {
        if (view instanceof c.b.a.b.k0.a) {
            c.b.a.b.k0.a aVar = (c.b.a.b.k0.a) view;
            g h2 = h();
            CharSequence charSequence = aVar.f4349b;
            if (charSequence != null) {
                h2.d(charSequence);
            }
            Drawable drawable = aVar.f4350c;
            if (drawable != null) {
                h2.b(drawable);
            }
            int i2 = aVar.f4351d;
            if (i2 != 0) {
                h2.f6148e = LayoutInflater.from(h2.h.getContext()).inflate(i2, (ViewGroup) h2.h, false);
                h2.e();
            }
            if (!TextUtils.isEmpty(aVar.getContentDescription())) {
                h2.f6146c = aVar.getContentDescription();
                h2.e();
            }
            a(h2, this.f6123b.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void c(int i2) {
        boolean z2;
        if (i2 != -1) {
            if (getWindowToken() != null && m.C(this)) {
                f fVar = this.f6126e;
                int childCount = fVar.getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        z2 = false;
                        break;
                    } else if (fVar.getChildAt(i3).getWidth() <= 0) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    int scrollX = getScrollX();
                    int e2 = e(i2, 0.0f);
                    if (scrollX != e2) {
                        f();
                        this.H.setIntValues(scrollX, e2);
                        this.H.start();
                    }
                    f fVar2 = this.f6126e;
                    int i4 = this.y;
                    ValueAnimator valueAnimator = fVar2.j;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        fVar2.j.cancel();
                    }
                    fVar2.c(true, i2, i4);
                    return;
                }
            }
            l(i2, 0.0f, true, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 != 2) goto L_0x0040;
     */
    public final void d() {
        int i2;
        f fVar;
        int i3 = this.A;
        m.d0(this.f6126e, (i3 == 0 || i3 == 2) ? Math.max(0, this.w - this.f6127f) : 0, 0, 0, 0);
        int i4 = this.A;
        if (i4 == 0) {
            int i5 = this.x;
            if (i5 != 0) {
                if (i5 == 1) {
                    fVar = this.f6126e;
                    i2 = 1;
                    fVar.setGravity(i2);
                }
            }
            fVar = this.f6126e;
            i2 = 8388611;
            fVar.setGravity(i2);
        } else if (i4 == 1 || i4 == 2) {
            int i6 = this.x;
            this.f6126e.setGravity(1);
        }
        p(true);
    }

    public final int e(int i2, float f2) {
        int i3 = this.A;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f6126e.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.f6126e.getChildCount() ? this.f6126e.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        return m.p(this) == 0 ? left + i6 : left - i6;
    }

    public final void f() {
        if (this.H == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.H = valueAnimator;
            valueAnimator.setInterpolator(c.b.a.b.m.a.f4411b);
            this.H.setDuration((long) this.y);
            this.H.addUpdateListener(new a());
        }
    }

    public g g(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f6123b.get(i2);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        g gVar = this.f6124c;
        if (gVar != null) {
            return gVar.f6147d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f6123b.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.l;
    }

    public int getTabIndicatorGravity() {
        return this.z;
    }

    public int getTabMaxWidth() {
        return this.s;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.m;
    }

    public Drawable getTabSelectedIndicator() {
        return this.n;
    }

    public ColorStateList getTabTextColors() {
        return this.k;
    }

    public g h() {
        CharSequence charSequence;
        g a2 = Q.a();
        if (a2 == null) {
            a2 = new g();
        }
        a2.f6150g = this;
        b.i.k.b<i> bVar = this.O;
        i a3 = bVar != null ? bVar.a() : null;
        if (a3 == null) {
            a3 = new i(getContext());
        }
        a3.setTab(a2);
        a3.setFocusable(true);
        a3.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(a2.f6146c)) {
            charSequence = a2.f6145b;
        } else {
            charSequence = a2.f6146c;
        }
        a3.setContentDescription(charSequence);
        a2.h = a3;
        return a2;
    }

    public void i() {
        int currentItem;
        for (int childCount = this.f6126e.getChildCount() - 1; childCount >= 0; childCount--) {
            i iVar = (i) this.f6126e.getChildAt(childCount);
            this.f6126e.removeViewAt(childCount);
            if (iVar != null) {
                iVar.setTab(null);
                iVar.setSelected(false);
                this.O.b(iVar);
            }
            requestLayout();
        }
        Iterator<g> it = this.f6123b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.f6150g = null;
            next.h = null;
            next.f6144a = null;
            next.f6145b = null;
            next.f6146c = null;
            next.f6147d = -1;
            next.f6148e = null;
            Q.b(next);
        }
        this.f6124c = null;
        b.a0.a.a aVar = this.J;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                g h2 = h();
                h2.d(this.J.getPageTitle(i2));
                a(h2, false);
            }
            ViewPager viewPager = this.I;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                j(g(currentItem), true);
            }
        }
    }

    public void j(g gVar, boolean z2) {
        g gVar2 = this.f6124c;
        if (gVar2 != gVar) {
            int i2 = gVar != null ? gVar.f6147d : -1;
            if (z2) {
                if ((gVar2 == null || gVar2.f6147d == -1) && i2 != -1) {
                    l(i2, 0.0f, true, true);
                } else {
                    c(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            this.f6124c = gVar;
            if (gVar2 != null) {
                for (int size = this.F.size() - 1; size >= 0; size--) {
                    this.F.get(size).a(gVar2);
                }
            }
            if (gVar != null) {
                for (int size2 = this.F.size() - 1; size2 >= 0; size2--) {
                    this.F.get(size2).b(gVar);
                }
            }
        } else if (gVar2 != null) {
            for (int size3 = this.F.size() - 1; size3 >= 0; size3--) {
                this.F.get(size3).c(gVar);
            }
            c(gVar.f6147d);
        }
    }

    public void k(b.a0.a.a aVar, boolean z2) {
        DataSetObserver dataSetObserver;
        b.a0.a.a aVar2 = this.J;
        if (!(aVar2 == null || (dataSetObserver = this.K) == null)) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.J = aVar;
        if (z2 && aVar != null) {
            if (this.K == null) {
                this.K = new e();
            }
            aVar.registerDataSetObserver(this.K);
        }
        i();
    }

    public void l(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.f6126e.getChildCount()) {
            if (z3) {
                f fVar = this.f6126e;
                ValueAnimator valueAnimator = fVar.j;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    fVar.j.cancel();
                }
                fVar.f6136e = i2;
                fVar.f6137f = f2;
                fVar.b();
            }
            ValueAnimator valueAnimator2 = this.H;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.H.cancel();
            }
            scrollTo(e(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public final void m(ViewPager viewPager, boolean z2, boolean z3) {
        List<ViewPager.h> list;
        List<ViewPager.i> list2;
        ViewPager viewPager2 = this.I;
        if (viewPager2 != null) {
            h hVar = this.L;
            if (!(hVar == null || (list2 = viewPager2.S) == null)) {
                list2.remove(hVar);
            }
            b bVar = this.M;
            if (!(bVar == null || (list = this.I.U) == null)) {
                list.remove(bVar);
            }
        }
        c cVar = this.G;
        if (cVar != null) {
            this.F.remove(cVar);
            this.G = null;
        }
        if (viewPager != null) {
            this.I = viewPager;
            if (this.L == null) {
                this.L = new h(this);
            }
            h hVar2 = this.L;
            hVar2.f6153c = 0;
            hVar2.f6152b = 0;
            if (viewPager.S == null) {
                viewPager.S = new ArrayList();
            }
            viewPager.S.add(hVar2);
            j jVar = new j(viewPager);
            this.G = jVar;
            if (!this.F.contains(jVar)) {
                this.F.add(jVar);
            }
            b.a0.a.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                k(adapter, z2);
            }
            if (this.M == null) {
                this.M = new b();
            }
            b bVar2 = this.M;
            bVar2.f6130a = z2;
            if (viewPager.U == null) {
                viewPager.U = new ArrayList();
            }
            viewPager.U.add(bVar2);
            l(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.I = null;
            k(null, false);
        }
        this.N = z3;
    }

    public final void n() {
        int size = this.f6123b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f6123b.get(i2).e();
        }
    }

    public final void o(LinearLayout.LayoutParams layoutParams) {
        float f2;
        if (this.A == 1 && this.x == 0) {
            layoutParams.width = 0;
            f2 = 1.0f;
        } else {
            layoutParams.width = -2;
            f2 = 0.0f;
        }
        layoutParams.weight = f2;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof c.b.a.b.h0.g) {
            t.K2(this, (c.b.a.b.h0.g) background);
        }
        if (this.I == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m((ViewPager) parent, true, true);
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager(null);
            this.N = false;
        }
    }

    public void onDraw(Canvas canvas) {
        i iVar;
        Drawable drawable;
        for (int i2 = 0; i2 < this.f6126e.getChildCount(); i2++) {
            View childAt = this.f6126e.getChildAt(i2);
            if ((childAt instanceof i) && (drawable = (iVar = (i) childAt).j) != null) {
                drawable.setBounds(iVar.getLeft(), iVar.getTop(), iVar.getRight(), iVar.getBottom());
                iVar.j.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0036b.a(1, getTabCount(), false, 1).f1916a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    public void onMeasure(int i2, int i3) {
        int round = Math.round(t.f1(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i3);
        boolean z2 = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + round, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i3) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.u;
            if (i4 <= 0) {
                i4 = (int) (((float) size) - t.f1(getContext(), 56));
            }
            this.s = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i5 = this.A;
            if (i5 != 0) {
                if (i5 != 1) {
                }
                if (z2) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                }
            }
        }
    }

    public void p(boolean z2) {
        for (int i2 = 0; i2 < this.f6126e.getChildCount(); i2++) {
            View childAt = this.f6126e.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            o((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        t.J2(this, f2);
    }

    public void setInlineLabel(boolean z2) {
        ImageView imageView;
        TextView textView;
        if (this.B != z2) {
            this.B = z2;
            for (int i2 = 0; i2 < this.f6126e.getChildCount(); i2++) {
                View childAt = this.f6126e.getChildAt(i2);
                if (childAt instanceof i) {
                    i iVar = (i) childAt;
                    iVar.setOrientation(!TabLayout.this.B ? 1 : 0);
                    if (iVar.h == null && iVar.i == null) {
                        textView = iVar.f6155c;
                        imageView = iVar.f6156d;
                    } else {
                        textView = iVar.h;
                        imageView = iVar.i;
                    }
                    iVar.k(textView, imageView);
                }
            }
            d();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.E;
        if (cVar2 != null) {
            this.F.remove(cVar2);
        }
        this.E = cVar;
        if (cVar != null && !this.F.contains(cVar)) {
            this.F.add(cVar);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.H.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(int i2) {
        setSelectedTabIndicator(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.n != drawable) {
            this.n = drawable;
            m.M(this.f6126e);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        f fVar = this.f6126e;
        if (fVar.f6134c.getColor() != i2) {
            fVar.f6134c.setColor(i2);
            m.M(fVar);
        }
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            m.M(this.f6126e);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        f fVar = this.f6126e;
        if (fVar.f6133b != i2) {
            fVar.f6133b = i2;
            m.M(fVar);
        }
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            d();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            n();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(b.b.l.a.a.a(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.C = z2;
        m.M(this.f6126e);
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            d();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            for (int i2 = 0; i2 < this.f6126e.getChildCount(); i2++) {
                View childAt = this.f6126e.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).j(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(b.b.l.a.a.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            n();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(b.a0.a.a aVar) {
        k(aVar, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            for (int i2 = 0; i2 < this.f6126e.getChildCount(); i2++) {
                View childAt = this.f6126e.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).j(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m(viewPager, true, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
