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
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.a0.a.b;
import e.b.a.m;
import e.i.i.m;
import e.i.i.x.b;
import f.b.a.d.c.a;
import f.b.a.d.q.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@b.AbstractC0012b
public class TabLayout extends HorizontalScrollView {
    public static final int Q = R$style.Widget_Design_TabLayout;
    public static final e.i.h.b<g> R = new e.i.h.c(16);
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public f.b.a.d.y.b F;
    public c G;
    public final ArrayList<c> H = new ArrayList<>();
    public c I;
    public ValueAnimator J;
    public e.a0.a.b K;
    public DataSetObserver L;
    public h M;
    public b N;
    public boolean O;
    public final e.i.h.b<i> P = new e.i.h.b<>(12);
    public final ArrayList<g> b = new ArrayList<>();
    public g c;

    /* renamed from: d  reason: collision with root package name */
    public final f f578d;

    /* renamed from: e  reason: collision with root package name */
    public int f579e;

    /* renamed from: f  reason: collision with root package name */
    public int f580f;

    /* renamed from: g  reason: collision with root package name */
    public int f581g;

    /* renamed from: h  reason: collision with root package name */
    public int f582h;

    /* renamed from: i  reason: collision with root package name */
    public int f583i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f584j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f585k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f586l;
    public Drawable m = new GradientDrawable();
    public int n = 0;
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

    public class b implements b.e {
        public boolean a;

        public b() {
        }

        @Override // e.a0.a.b.e
        public void a(e.a0.a.b bVar, e.a0.a.a aVar, e.a0.a.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.K == bVar) {
                tabLayout.k(aVar2, this.a);
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
        public ValueAnimator b;
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public float f587d;

        /* renamed from: e  reason: collision with root package name */
        public int f588e = -1;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ View b;

            public a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.c(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ int a;

            public b(int i2) {
                this.a = i2;
            }

            public void onAnimationEnd(Animator animator) {
                f.this.c = this.a;
            }

            public void onAnimationStart(Animator animator) {
                f.this.c = this.a;
            }
        }

        public f(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        public final void a() {
            View childAt = getChildAt(this.c);
            TabLayout tabLayout = TabLayout.this;
            f.b.a.d.y.b bVar = tabLayout.F;
            Drawable drawable = tabLayout.m;
            Objects.requireNonNull(bVar);
            RectF a2 = f.b.a.d.y.b.a(tabLayout, childAt);
            drawable.setBounds((int) a2.left, drawable.getBounds().top, (int) a2.right, drawable.getBounds().bottom);
        }

        public void b(int i2) {
            Rect bounds = TabLayout.this.m.getBounds();
            TabLayout.this.m.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        public final void c(View view, View view2, float f2) {
            if (view != null && view.getWidth() > 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.F.b(tabLayout, view, view2, f2, tabLayout.m);
            } else {
                Drawable drawable = TabLayout.this.m;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.m.getBounds().bottom);
            }
            AtomicInteger atomicInteger = m.a;
            postInvalidateOnAnimation();
        }

        public final void d(boolean z, int i2, int i3) {
            View childAt = getChildAt(this.c);
            View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                a();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.b = valueAnimator;
                valueAnimator.setInterpolator(f.b.a.d.a.a.b);
                valueAnimator.setDuration((long) i3);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i2));
                valueAnimator.start();
                return;
            }
            this.b.removeAllUpdateListeners();
            this.b.addUpdateListener(aVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
        public void draw(Canvas canvas) {
            int height = TabLayout.this.m.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.m.getIntrinsicHeight();
            }
            int i2 = TabLayout.this.z;
            int i3 = 0;
            if (i2 != 0) {
                if (i2 == 1) {
                    i3 = (getHeight() - height) / 2;
                    height = (getHeight() + height) / 2;
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        height = 0;
                    }
                }
                if (TabLayout.this.m.getBounds().width() > 0) {
                    Rect bounds = TabLayout.this.m.getBounds();
                    TabLayout.this.m.setBounds(bounds.left, i3, bounds.right, height);
                    TabLayout tabLayout = TabLayout.this;
                    Drawable drawable = tabLayout.m;
                    if (tabLayout.n != 0) {
                        drawable = m.h.w1(drawable);
                        if (Build.VERSION.SDK_INT == 21) {
                            drawable.setColorFilter(TabLayout.this.n, PorterDuff.Mode.SRC_IN);
                        } else {
                            drawable.setTint(TabLayout.this.n);
                        }
                    }
                    drawable.draw(canvas);
                }
                super.draw(canvas);
            }
            i3 = getHeight() - height;
            height = getHeight();
            if (TabLayout.this.m.getBounds().width() > 0) {
            }
            super.draw(canvas);
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                d(false, this.c, -1);
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
                        if (i4 * childCount <= getMeasuredWidth() - (((int) f.b.a.c.b.o.b.r0(getContext(), 16)) * 2)) {
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
            if (Build.VERSION.SDK_INT < 23 && this.f588e != i2) {
                requestLayout();
                this.f588e = i2;
            }
        }
    }

    public static class g {
        public Drawable a;
        public CharSequence b;
        public CharSequence c;

        /* renamed from: d  reason: collision with root package name */
        public int f590d = -1;

        /* renamed from: e  reason: collision with root package name */
        public View f591e;

        /* renamed from: f  reason: collision with root package name */
        public TabLayout f592f;

        /* renamed from: g  reason: collision with root package name */
        public i f593g;

        /* renamed from: h  reason: collision with root package name */
        public int f594h = -1;

        public g a(int i2) {
            TabLayout tabLayout = this.f592f;
            if (tabLayout != null) {
                b(e.b.b.a.a.b(tabLayout.getContext(), i2));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g b(Drawable drawable) {
            this.a = drawable;
            TabLayout tabLayout = this.f592f;
            if (tabLayout.x == 1 || tabLayout.A == 2) {
                tabLayout.p(true);
            }
            e();
            return this;
        }

        public g c(int i2) {
            TabLayout tabLayout = this.f592f;
            if (tabLayout != null) {
                d(tabLayout.getResources().getText(i2));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g d(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(charSequence)) {
                this.f593g.setContentDescription(charSequence);
            }
            this.b = charSequence;
            e();
            return this;
        }

        public void e() {
            i iVar = this.f593g;
            if (iVar != null) {
                iVar.f();
            }
        }
    }

    public static class h implements b.f {
        public final WeakReference<TabLayout> a;
        public int b;
        public int c;

        public h(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        @Override // e.a0.a.b.f
        public void a(int i2) {
            this.b = this.c;
            this.c = i2;
        }
    }

    public final class i extends LinearLayout {
        public static final /* synthetic */ int m = 0;
        public g b;
        public TextView c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f595d;

        /* renamed from: e  reason: collision with root package name */
        public View f596e;

        /* renamed from: f  reason: collision with root package name */
        public f.b.a.d.c.a f597f;

        /* renamed from: g  reason: collision with root package name */
        public View f598g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f599h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f600i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f601j;

        /* renamed from: k  reason: collision with root package name */
        public int f602k = 2;

        public i(Context context) {
            super(context);
            g(context);
            int i2 = TabLayout.this.f579e;
            int i3 = TabLayout.this.f580f;
            int i4 = TabLayout.this.f581g;
            int i5 = TabLayout.this.f582h;
            AtomicInteger atomicInteger = e.i.i.m.a;
            setPaddingRelative(i2, i3, i4, i5);
            setGravity(17);
            setOrientation(!TabLayout.this.B ? 1 : 0);
            setClickable(true);
            Context context2 = getContext();
            int i6 = Build.VERSION.SDK_INT;
            PointerIcon systemIcon = i6 >= 24 ? PointerIcon.getSystemIcon(context2, 1002) : null;
            if (i6 >= 24) {
                setPointerIcon(systemIcon);
            }
        }

        private f.b.a.d.c.a getBadge() {
            return this.f597f;
        }

        private f.b.a.d.c.a getOrCreateBadge() {
            if (this.f597f == null) {
                Context context = getContext();
                int i2 = f.b.a.d.c.a.s;
                int i3 = f.b.a.d.c.a.r;
                f.b.a.d.c.a aVar = new f.b.a.d.c.a(context);
                int[] iArr = R$styleable.Badge;
                FrameLayout frameLayout = null;
                k.a(context, null, i2, i3);
                k.b(context, null, iArr, i2, i3, new int[0]);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i2, i3);
                int i4 = obtainStyledAttributes.getInt(R$styleable.Badge_maxCharacterCount, 4);
                a.C0091a aVar2 = aVar.f2677i;
                if (aVar2.f2683f != i4) {
                    aVar2.f2683f = i4;
                    aVar.f2680l = ((int) Math.pow(10.0d, ((double) i4) - 1.0d)) - 1;
                    aVar.f2672d.f2799d = true;
                    aVar.g();
                    aVar.invalidateSelf();
                }
                int i5 = R$styleable.Badge_number;
                if (obtainStyledAttributes.hasValue(i5)) {
                    int max = Math.max(0, obtainStyledAttributes.getInt(i5, 0));
                    a.C0091a aVar3 = aVar.f2677i;
                    if (aVar3.f2682e != max) {
                        aVar3.f2682e = max;
                        aVar.f2672d.f2799d = true;
                        aVar.g();
                        aVar.invalidateSelf();
                    }
                }
                int defaultColor = f.b.a.c.b.o.b.L0(context, obtainStyledAttributes, R$styleable.Badge_backgroundColor).getDefaultColor();
                aVar.f2677i.b = defaultColor;
                ColorStateList valueOf = ColorStateList.valueOf(defaultColor);
                f.b.a.d.v.g gVar = aVar.c;
                if (gVar.b.f2874d != valueOf) {
                    gVar.q(valueOf);
                    aVar.invalidateSelf();
                }
                int i6 = R$styleable.Badge_badgeTextColor;
                if (obtainStyledAttributes.hasValue(i6)) {
                    int defaultColor2 = f.b.a.c.b.o.b.L0(context, obtainStyledAttributes, i6).getDefaultColor();
                    aVar.f2677i.c = defaultColor2;
                    if (aVar.f2672d.a.getColor() != defaultColor2) {
                        aVar.f2672d.a.setColor(defaultColor2);
                        aVar.invalidateSelf();
                    }
                }
                int i7 = obtainStyledAttributes.getInt(R$styleable.Badge_badgeGravity, 8388661);
                a.C0091a aVar4 = aVar.f2677i;
                if (aVar4.f2687j != i7) {
                    aVar4.f2687j = i7;
                    WeakReference<View> weakReference = aVar.p;
                    if (!(weakReference == null || weakReference.get() == null)) {
                        View view = aVar.p.get();
                        WeakReference<FrameLayout> weakReference2 = aVar.q;
                        if (weakReference2 != null) {
                            frameLayout = weakReference2.get();
                        }
                        aVar.f(view, frameLayout);
                    }
                }
                aVar.f2677i.f2689l = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0);
                aVar.g();
                aVar.f2677i.m = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0);
                aVar.g();
                obtainStyledAttributes.recycle();
                this.f597f = aVar;
            }
            d();
            f.b.a.d.c.a aVar5 = this.f597f;
            if (aVar5 != null) {
                return aVar5;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final boolean a() {
            return this.f597f != null;
        }

        public final void b(View view) {
            if (a() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                f.b.a.d.c.a aVar = this.f597f;
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                aVar.setBounds(rect);
                aVar.f(view, null);
                if (aVar.c() != null) {
                    aVar.c().setForeground(aVar);
                } else {
                    view.getOverlay().add(aVar);
                }
                this.f596e = view;
            }
        }

        public final void c() {
            if (a()) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f596e;
                if (view != null) {
                    f.b.a.d.c.a aVar = this.f597f;
                    if (aVar != null) {
                        if (aVar.c() != null) {
                            aVar.c().setForeground(null);
                        } else {
                            view.getOverlay().remove(aVar);
                        }
                    }
                    this.f596e = null;
                }
            }
        }

        public final void d() {
            g gVar;
            View view;
            g gVar2;
            if (a()) {
                if (this.f598g == null) {
                    ImageView imageView = this.f595d;
                    if (imageView == null || (gVar2 = this.b) == null || gVar2.a == null) {
                        if (!(this.c == null || (gVar = this.b) == null)) {
                            Objects.requireNonNull(gVar);
                            View view2 = this.f596e;
                            TextView textView = this.c;
                            if (view2 != textView) {
                                c();
                                view = this.c;
                            } else {
                                e(textView);
                                return;
                            }
                        }
                    } else if (this.f596e != imageView) {
                        c();
                        view = this.f595d;
                    } else {
                        e(imageView);
                        return;
                    }
                    b(view);
                    return;
                }
                c();
            }
        }

        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f601j;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f601j.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e(View view) {
            if (a() && view == this.f596e) {
                f.b.a.d.c.a aVar = this.f597f;
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                aVar.setBounds(rect);
                aVar.f(view, null);
            }
        }

        public final void f() {
            Drawable drawable;
            g gVar = this.b;
            Drawable drawable2 = null;
            View view = gVar != null ? gVar.f591e : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f598g = view;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f595d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f595d.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.f599h = textView2;
                if (textView2 != null) {
                    this.f602k = textView2.getMaxLines();
                }
                this.f600i = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.f598g;
                if (view2 != null) {
                    removeView(view2);
                    this.f598g = null;
                }
                this.f599h = null;
                this.f600i = null;
            }
            boolean z = false;
            if (this.f598g == null) {
                if (this.f595d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f595d = imageView2;
                    addView(imageView2, 0);
                }
                if (!(gVar == null || (drawable = gVar.a) == null)) {
                    drawable2 = m.h.w1(drawable).mutate();
                }
                if (drawable2 != null) {
                    drawable2.setTintList(TabLayout.this.f585k);
                    PorterDuff.Mode mode = TabLayout.this.o;
                    if (mode != null) {
                        drawable2.setTintMode(mode);
                    }
                }
                if (this.c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.c = textView3;
                    addView(textView3);
                    this.f602k = this.c.getMaxLines();
                }
                m.h.d1(this.c, TabLayout.this.f583i);
                ColorStateList colorStateList = TabLayout.this.f584j;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
                h(this.c, this.f595d);
                d();
                ImageView imageView3 = this.f595d;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new f.b.a.d.y.d(this, imageView3));
                }
                TextView textView4 = this.c;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new f.b.a.d.y.d(this, textView4));
                }
            } else {
                TextView textView5 = this.f599h;
                if (!(textView5 == null && this.f600i == null)) {
                    h(textView5, this.f600i);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.c)) {
                setContentDescription(gVar.c);
            }
            if (gVar != null) {
                TabLayout tabLayout = gVar.f592f;
                if (tabLayout != null) {
                    if (tabLayout.getSelectedTabPosition() == gVar.f590d) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            setSelected(z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.material.tabs.TabLayout$i, android.widget.LinearLayout, android.view.View] */
        /* JADX WARN: Type inference failed for: r3v5, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void g(Context context) {
            int i2 = TabLayout.this.r;
            GradientDrawable gradientDrawable = null;
            if (i2 != 0) {
                Drawable b2 = e.b.b.a.a.b(context, i2);
                this.f601j = b2;
                if (b2 != null && b2.isStateful()) {
                    this.f601j.setState(getDrawableState());
                }
            } else {
                this.f601j = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.f586l != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateList = TabLayout.this.f586l;
                ColorStateList colorStateList2 = new ColorStateList(new int[][]{f.b.a.d.t.a.f2853i, StateSet.NOTHING}, new int[]{f.b.a.d.t.a.a(colorStateList, f.b.a.d.t.a.f2849e), f.b.a.d.t.a.a(colorStateList, f.b.a.d.t.a.a)});
                boolean z = TabLayout.this.E;
                if (z) {
                    gradientDrawable2 = null;
                }
                if (!z) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(colorStateList2, gradientDrawable2, gradientDrawable);
            }
            AtomicInteger atomicInteger = e.i.i.m.a;
            setBackground(gradientDrawable2);
            TabLayout.this.invalidate();
        }

        public int getContentHeight() {
            View[] viewArr = {this.c, this.f595d, this.f598g};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getTop()) : view.getTop();
                    i2 = z ? Math.max(i2, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i2 - i3;
        }

        public int getContentWidth() {
            View[] viewArr = {this.c, this.f595d, this.f598g};
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

        public g getTab() {
            return this.b;
        }

        public final void h(TextView textView, ImageView imageView) {
            Drawable drawable;
            g gVar = this.b;
            CharSequence charSequence = null;
            Drawable mutate = (gVar == null || (drawable = gVar.a) == null) ? null : m.h.w1(drawable).mutate();
            g gVar2 = this.b;
            CharSequence charSequence2 = gVar2 != null ? gVar2.b : null;
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
                    Objects.requireNonNull(this.b);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int r0 = (!z || imageView.getVisibility() != 0) ? 0 : (int) f.b.a.c.b.o.b.r0(getContext(), 8);
                if (TabLayout.this.B) {
                    if (r0 != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(r0);
                        marginLayoutParams.bottomMargin = 0;
                    }
                } else if (r0 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = r0;
                    marginLayoutParams.setMarginEnd(0);
                }
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
            g gVar3 = this.b;
            if (gVar3 != null) {
                charSequence = gVar3.c;
            }
            if (!z) {
                charSequence2 = charSequence;
            }
            m.h.h1(this, charSequence2);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            Context context;
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            f.b.a.d.c.a aVar = this.f597f;
            if (aVar != null && aVar.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                StringBuilder sb = new StringBuilder();
                sb.append((Object) contentDescription);
                sb.append(", ");
                f.b.a.d.c.a aVar2 = this.f597f;
                Object obj = null;
                if (aVar2.isVisible()) {
                    if (!aVar2.e()) {
                        obj = aVar2.f2677i.f2684g;
                    } else if (aVar2.f2677i.f2685h > 0 && (context = aVar2.b.get()) != null) {
                        int d2 = aVar2.d();
                        int i2 = aVar2.f2680l;
                        obj = d2 <= i2 ? context.getResources().getQuantityString(aVar2.f2677i.f2685h, aVar2.d(), Integer.valueOf(aVar2.d())) : context.getString(aVar2.f2677i.f2686i, Integer.valueOf(i2));
                    }
                }
                sb.append(obj);
                accessibilityNodeInfo.setContentDescription(sb.toString());
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) b.c.a(0, 1, this.b.f590d, 1, false, isSelected()).a);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) b.a.f1498e.a);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R$string.item_view_role_description));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x0096;
         */
        public void onMeasure(int i2, int i3) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.s, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.c != null) {
                float f2 = TabLayout.this.p;
                int i4 = this.f602k;
                ImageView imageView = this.f595d;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.q;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.c.getTextSize();
                int lineCount = this.c.getLineCount();
                int maxLines = this.c.getMaxLines();
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                    if (TabLayout.this.A == 1 && i5 > 0 && lineCount == 1) {
                        Layout layout = this.c.getLayout();
                        if (layout != null) {
                        }
                        z = false;
                    }
                    if (z) {
                        this.c.setTextSize(0, f2);
                        this.c.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            g gVar = this.b;
            TabLayout tabLayout = gVar.f592f;
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
            TextView textView = this.c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f595d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f598g;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.b) {
                this.b = gVar;
                f();
            }
        }
    }

    public static class j implements d {
        public final e.a0.a.b a;

        public j(e.a0.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.a.setCurrentItem(gVar.f590d);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet) {
        super(f.b.a.d.a0.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.tabStyle;
        int i3 = Q;
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f578d = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R$styleable.TabLayout;
        int i4 = R$styleable.TabLayout_tabTextAppearance;
        TypedArray d2 = k.d(context2, attributeSet, iArr, i2, i3, i4);
        if (getBackground() instanceof ColorDrawable) {
            f.b.a.d.v.g gVar = new f.b.a.d.v.g();
            gVar.q(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            gVar.b.b = new f.b.a.d.n.a(context2);
            gVar.y();
            AtomicInteger atomicInteger = e.i.i.m.a;
            gVar.p(getElevation());
            setBackground(gVar);
        }
        setSelectedTabIndicator(f.b.a.c.b.o.b.P0(context2, d2, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(d2.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        fVar.b(d2.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(d2.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(d2.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(d2.getInt(R$styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int dimensionPixelSize = d2.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f582h = dimensionPixelSize;
        this.f581g = dimensionPixelSize;
        this.f580f = dimensionPixelSize;
        this.f579e = dimensionPixelSize;
        this.f579e = d2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f580f = d2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f580f);
        this.f581g = d2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f581g);
        this.f582h = d2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f582h);
        int resourceId = d2.getResourceId(i4, R$style.TextAppearance_Design_Tab);
        this.f583i = resourceId;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.p = (float) obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, 0);
            this.f584j = f.b.a.c.b.o.b.L0(context2, obtainStyledAttributes, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            int i5 = R$styleable.TabLayout_tabTextColor;
            if (d2.hasValue(i5)) {
                this.f584j = f.b.a.c.b.o.b.L0(context2, d2, i5);
            }
            int i6 = R$styleable.TabLayout_tabSelectedTextColor;
            if (d2.hasValue(i6)) {
                int color = d2.getColor(i6, 0);
                int defaultColor = this.f584j.getDefaultColor();
                this.f584j = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{color, defaultColor});
            }
            this.f585k = f.b.a.c.b.o.b.L0(context2, d2, R$styleable.TabLayout_tabIconTint);
            this.o = f.b.a.c.b.o.b.u1(d2.getInt(R$styleable.TabLayout_tabIconTintMode, -1), null);
            this.f586l = f.b.a.c.b.o.b.L0(context2, d2, R$styleable.TabLayout_tabRippleColor);
            this.y = d2.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.t = d2.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.u = d2.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.r = d2.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.w = d2.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.A = d2.getInt(R$styleable.TabLayout_tabMode, 1);
            this.x = d2.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.B = d2.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.E = d2.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            d2.recycle();
            Resources resources = getResources();
            this.q = (float) resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.v = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            d();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getDefaultHeight() {
        int size = this.b.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.b.get(i2);
                if (gVar != null && gVar.a != null && !TextUtils.isEmpty(gVar.b)) {
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
        return Math.max(0, ((this.f578d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f578d.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f578d.getChildAt(i3);
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
        int size = this.b.size();
        if (gVar.f592f == this) {
            gVar.f590d = size;
            this.b.add(size, gVar);
            int size2 = this.b.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                }
                this.b.get(size).f590d = size;
            }
            i iVar = gVar.f593g;
            iVar.setSelected(false);
            iVar.setActivated(false);
            f fVar = this.f578d;
            int i2 = gVar.f590d;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            o(layoutParams);
            fVar.addView(iVar, i2, layoutParams);
            if (z2) {
                TabLayout tabLayout = gVar.f592f;
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
        if (view instanceof f.b.a.d.y.c) {
            f.b.a.d.y.c cVar = (f.b.a.d.y.c) view;
            g h2 = h();
            Objects.requireNonNull(cVar);
            if (!TextUtils.isEmpty(cVar.getContentDescription())) {
                h2.c = cVar.getContentDescription();
                h2.e();
            }
            a(h2, this.b.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void c(int i2) {
        boolean z2;
        if (i2 != -1) {
            if (getWindowToken() != null) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                if (isLaidOut()) {
                    f fVar = this.f578d;
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
                            this.J.setIntValues(scrollX, e2);
                            this.J.start();
                        }
                        f fVar2 = this.f578d;
                        int i4 = this.y;
                        ValueAnimator valueAnimator = fVar2.b;
                        if (valueAnimator != null && valueAnimator.isRunning()) {
                            fVar2.b.cancel();
                        }
                        fVar2.d(true, i2, i4);
                        return;
                    }
                }
            }
            l(i2, 0.0f, true, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r0 != 2) goto L_0x0050;
     */
    public final void d() {
        int i2;
        f fVar;
        int i3 = this.A;
        int max = (i3 == 0 || i3 == 2) ? Math.max(0, this.w - this.f579e) : 0;
        f fVar2 = this.f578d;
        AtomicInteger atomicInteger = e.i.i.m.a;
        fVar2.setPaddingRelative(max, 0, 0, 0);
        int i4 = this.A;
        if (i4 == 0) {
            int i5 = this.x;
            if (i5 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i5 == 1) {
                fVar = this.f578d;
                i2 = 1;
                fVar.setGravity(i2);
            }
            fVar = this.f578d;
            i2 = 8388611;
            fVar.setGravity(i2);
        } else if (i4 == 1 || i4 == 2) {
            if (this.x == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f578d.setGravity(1);
        }
        p(true);
    }

    public final int e(int i2, float f2) {
        int i3 = this.A;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f578d.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.f578d.getChildCount() ? this.f578d.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        AtomicInteger atomicInteger = e.i.i.m.a;
        return getLayoutDirection() == 0 ? left + i6 : left - i6;
    }

    public final void f() {
        if (this.J == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.J = valueAnimator;
            valueAnimator.setInterpolator(f.b.a.d.a.a.b);
            this.J.setDuration((long) this.y);
            this.J.addUpdateListener(new a());
        }
    }

    public g g(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.b.get(i2);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        g gVar = this.c;
        if (gVar != null) {
            return gVar.f590d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.b.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.f585k;
    }

    public int getTabIndicatorAnimationMode() {
        return this.D;
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
        return this.f586l;
    }

    public Drawable getTabSelectedIndicator() {
        return this.m;
    }

    public ColorStateList getTabTextColors() {
        return this.f584j;
    }

    public g h() {
        CharSequence charSequence;
        g a2 = R.a();
        if (a2 == null) {
            a2 = new g();
        }
        a2.f592f = this;
        e.i.h.b<i> bVar = this.P;
        i a3 = bVar != null ? bVar.a() : null;
        if (a3 == null) {
            a3 = new i(getContext());
        }
        a3.setTab(a2);
        a3.setFocusable(true);
        a3.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(a2.c)) {
            charSequence = a2.b;
        } else {
            charSequence = a2.c;
        }
        a3.setContentDescription(charSequence);
        a2.f593g = a3;
        int i2 = a2.f594h;
        if (i2 != -1) {
            a3.setId(i2);
        }
        return a2;
    }

    public void i() {
        int childCount = this.f578d.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            i iVar = (i) this.f578d.getChildAt(childCount);
            this.f578d.removeViewAt(childCount);
            if (iVar != null) {
                iVar.setTab(null);
                iVar.setSelected(false);
                this.P.b(iVar);
            }
            requestLayout();
        }
        Iterator<g> it = this.b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.f592f = null;
            next.f593g = null;
            next.a = null;
            next.f594h = -1;
            next.b = null;
            next.c = null;
            next.f590d = -1;
            next.f591e = null;
            R.b(next);
        }
        this.c = null;
    }

    public void j(g gVar, boolean z2) {
        g gVar2 = this.c;
        if (gVar2 != gVar) {
            int i2 = gVar != null ? gVar.f590d : -1;
            if (z2) {
                if ((gVar2 == null || gVar2.f590d == -1) && i2 != -1) {
                    l(i2, 0.0f, true, true);
                } else {
                    c(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            this.c = gVar;
            if (gVar2 != null) {
                for (int size = this.H.size() - 1; size >= 0; size--) {
                    this.H.get(size).a(gVar2);
                }
            }
            if (gVar != null) {
                for (int size2 = this.H.size() - 1; size2 >= 0; size2--) {
                    this.H.get(size2).b(gVar);
                }
            }
        } else if (gVar2 != null) {
            for (int size3 = this.H.size() - 1; size3 >= 0; size3--) {
                this.H.get(size3).c(gVar);
            }
            c(gVar.f590d);
        }
    }

    public void k(e.a0.a.a aVar, boolean z2) {
        if (!z2 || aVar == null) {
            i();
            return;
        }
        if (this.L == null) {
            this.L = new e();
        }
        throw null;
    }

    public void l(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.f578d.getChildCount()) {
            if (z3) {
                f fVar = this.f578d;
                ValueAnimator valueAnimator = fVar.b;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    fVar.b.cancel();
                }
                fVar.c = i2;
                fVar.f587d = f2;
                fVar.c(fVar.getChildAt(i2), fVar.getChildAt(fVar.c + 1), fVar.f587d);
            }
            ValueAnimator valueAnimator2 = this.J;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.J.cancel();
            }
            scrollTo(e(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public final void m(e.a0.a.b bVar, boolean z2, boolean z3) {
        List<b.e> list;
        List<b.f> list2;
        e.a0.a.b bVar2 = this.K;
        if (bVar2 != null) {
            h hVar = this.M;
            if (!(hVar == null || (list2 = bVar2.y) == null)) {
                list2.remove(hVar);
            }
            b bVar3 = this.N;
            if (!(bVar3 == null || (list = this.K.A) == null)) {
                list.remove(bVar3);
            }
        }
        c cVar = this.I;
        if (cVar != null) {
            this.H.remove(cVar);
            this.I = null;
        }
        if (bVar != null) {
            this.K = bVar;
            if (this.M == null) {
                this.M = new h(this);
            }
            h hVar2 = this.M;
            hVar2.c = 0;
            hVar2.b = 0;
            if (bVar.y == null) {
                bVar.y = new ArrayList();
            }
            bVar.y.add(hVar2);
            j jVar = new j(bVar);
            this.I = jVar;
            if (!this.H.contains(jVar)) {
                this.H.add(jVar);
            }
            e.a0.a.a adapter = bVar.getAdapter();
            if (adapter != null) {
                k(adapter, z2);
            }
            if (this.N == null) {
                this.N = new b();
            }
            b bVar4 = this.N;
            bVar4.a = z2;
            if (bVar.A == null) {
                bVar.A = new ArrayList();
            }
            bVar.A.add(bVar4);
            l(bVar.getCurrentItem(), 0.0f, true, true);
        } else {
            this.K = null;
            k(null, false);
        }
        this.O = z3;
    }

    public final void n() {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.b.get(i2).e();
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
        if (background instanceof f.b.a.d.v.g) {
            f.b.a.c.b.o.b.N1(this, (f.b.a.d.v.g) background);
        }
        if (this.K == null) {
            ViewParent parent = getParent();
            if (parent instanceof e.a0.a.b) {
                m((e.a0.a.b) parent, true, true);
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O) {
            setupWithViewPager(null);
            this.O = false;
        }
    }

    public void onDraw(Canvas canvas) {
        i iVar;
        Drawable drawable;
        for (int i2 = 0; i2 < this.f578d.getChildCount(); i2++) {
            View childAt = this.f578d.getChildAt(i2);
            if ((childAt instanceof i) && (drawable = (iVar = (i) childAt).f601j) != null) {
                drawable.setBounds(iVar.getLeft(), iVar.getTop(), iVar.getRight(), iVar.getBottom());
                iVar.f601j.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0039b.a(1, getTabCount(), false, 1).a);
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
        int round = Math.round(f.b.a.c.b.o.b.r0(getContext(), getDefaultHeight()));
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
                i4 = (int) (((float) size) - f.b.a.c.b.o.b.r0(getContext(), 56));
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
        for (int i2 = 0; i2 < this.f578d.getChildCount(); i2++) {
            View childAt = this.f578d.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            o((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        f.b.a.c.b.o.b.M1(this, f2);
    }

    public void setInlineLabel(boolean z2) {
        ImageView imageView;
        if (this.B != z2) {
            this.B = z2;
            for (int i2 = 0; i2 < this.f578d.getChildCount(); i2++) {
                View childAt = this.f578d.getChildAt(i2);
                if (childAt instanceof i) {
                    i iVar = (i) childAt;
                    iVar.setOrientation(!TabLayout.this.B ? 1 : 0);
                    TextView textView = iVar.f599h;
                    if (textView == null && iVar.f600i == null) {
                        textView = iVar.c;
                        imageView = iVar.f595d;
                    } else {
                        imageView = iVar.f600i;
                    }
                    iVar.h(textView, imageView);
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
        c cVar2 = this.G;
        if (cVar2 != null) {
            this.H.remove(cVar2);
        }
        this.G = cVar;
        if (cVar != null && !this.H.contains(cVar)) {
            this.H.add(cVar);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.J.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(int i2) {
        setSelectedTabIndicator(i2 != 0 ? e.b.b.a.a.b(getContext(), i2) : null);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.m != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.m = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.n = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            f fVar = this.f578d;
            AtomicInteger atomicInteger = e.i.i.m.a;
            fVar.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f578d.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            d();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f585k != colorStateList) {
            this.f585k = colorStateList;
            n();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(e.b.b.a.a.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        f.b.a.d.y.b bVar;
        this.D = i2;
        if (i2 == 0) {
            bVar = new f.b.a.d.y.b();
        } else if (i2 == 1) {
            bVar = new f.b.a.d.y.a();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
        this.F = bVar;
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.C = z2;
        f fVar = this.f578d;
        AtomicInteger atomicInteger = e.i.i.m.a;
        fVar.postInvalidateOnAnimation();
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            d();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f586l != colorStateList) {
            this.f586l = colorStateList;
            for (int i2 = 0; i2 < this.f578d.getChildCount(); i2++) {
                View childAt = this.f578d.getChildAt(i2);
                if (childAt instanceof i) {
                    Context context = getContext();
                    int i3 = i.m;
                    ((i) childAt).g(context);
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(e.b.b.a.a.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f584j != colorStateList) {
            this.f584j = colorStateList;
            n();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(e.a0.a.a aVar) {
        k(aVar, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            for (int i2 = 0; i2 < this.f578d.getChildCount(); i2++) {
                View childAt = this.f578d.getChildAt(i2);
                if (childAt instanceof i) {
                    Context context = getContext();
                    int i3 = i.m;
                    ((i) childAt).g(context);
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(e.a0.a.b bVar) {
        m(bVar, true, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
