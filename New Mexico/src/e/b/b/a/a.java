package e.b.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R$styleable;
import e.b.a.m;
import e.b.b.a.b;
import e.b.b.a.d;
import e.b.f.r0;
import e.f.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class a extends d implements e.j.c.m.a {
    public c q;
    public g r;
    public int s;
    public int t;
    public boolean u;

    /* loaded from: classes.dex */
    public static class b extends g {
        public final Animatable a;

        public b(Animatable animatable) {
            super(null);
            this.a = animatable;
        }

        @Override // e.b.b.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // e.b.b.a.a.g
        public void d() {
            this.a.stop();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d.a {
        public e.f.e<Long> K;
        public i<Integer> L;

        public c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            i<Integer> iVar;
            if (cVar != null) {
                this.K = cVar.K;
                iVar = cVar.L;
            } else {
                this.K = new e.f.e<>();
                iVar = new i<>();
            }
            this.L = iVar;
        }

        public static long h(int i2, int i3) {
            return ((long) i3) | (((long) i2) << 32);
        }

        @Override // e.b.b.a.d.a, e.b.b.a.b.c
        public void e() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int i(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.e(i2, 0).intValue();
        }

        @Override // e.b.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // e.b.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends g {
        public final e.a0.a.a.c a;

        public d(e.a0.a.a.c cVar) {
            super(null);
            this.a = cVar;
        }

        @Override // e.b.b.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // e.b.b.a.a.g
        public void d() {
            this.a.stop();
        }
    }

    /* loaded from: classes.dex */
    public static class e extends g {
        public final ObjectAnimator a;
        public final boolean b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            e.b.c.a.a(ofInt, true);
            ofInt.setDuration((long) fVar.c);
            ofInt.setInterpolator(fVar);
            this.b = z2;
            this.a = ofInt;
        }

        @Override // e.b.b.a.a.g
        public boolean a() {
            return this.b;
        }

        @Override // e.b.b.a.a.g
        public void b() {
            this.a.reverse();
        }

        @Override // e.b.b.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // e.b.b.a.a.g
        public void d() {
            this.a.cancel();
        }
    }

    /* loaded from: classes.dex */
    public static class f implements TimeInterpolator {
        public int[] a;
        public int b;
        public int c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.c = i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * ((float) this.c)) + 0.5f);
            int i3 = this.b;
            int[] iArr = this.a;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (((float) i4) / ((float) i3)) + (i4 < i3 ? ((float) i2) / ((float) this.c) : 0.0f);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g {
        public g(C0015a aVar) {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public a(c cVar, Resources resources) {
        super(null);
        this.s = -1;
        this.t = -1;
        c cVar2 = new c(cVar, this, resources);
        super.e(cVar2);
        this.q = cVar2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0207, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(f.a.a.a.a.g(r20, new java.lang.StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static a g(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int next;
        int next2;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            Drawable drawable = null;
            a aVar = new a(null, null);
            TypedArray c1 = m.e.c1(resources, theme2, attributeSet2, R$styleable.AnimatedStateListDrawableCompat);
            int i2 = 1;
            aVar.setVisible(c1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
            c cVar = aVar.q;
            cVar.f784d |= e.b.c.b.b(c1);
            cVar.f789i = c1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f789i);
            cVar.f792l = c1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f792l);
            cVar.A = c1.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A);
            cVar.B = c1.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B);
            aVar.setDither(c1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, cVar.x));
            aVar.b.f(resources);
            c1.recycle();
            int depth2 = xmlPullParser.getDepth() + 1;
            Context context2 = context;
            Resources resources2 = resources;
            while (true) {
                int next3 = xmlPullParser.next();
                if (next3 == i2 || ((depth = xmlPullParser.getDepth()) < depth2 && next3 == 3)) {
                    break;
                } else if (next3 == 2 && depth <= depth2) {
                    if (xmlPullParser.getName().equals("item")) {
                        TypedArray c12 = m.e.c1(resources2, theme2, attributeSet2, R$styleable.AnimatedStateListDrawableItem);
                        int resourceId = c12.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
                        int resourceId2 = c12.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
                        if (resourceId2 > 0) {
                            drawable = r0.d().f(context2, resourceId2);
                        }
                        c12.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i3 = 0;
                        for (int i4 = 0; i4 < attributeCount; i4++) {
                            int attributeNameResource = attributeSet2.getAttributeNameResource(i4);
                            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                                i3++;
                                if (!attributeSet2.getAttributeBooleanValue(i4, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i3] = attributeNameResource;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr, i3);
                        if (drawable == null) {
                            do {
                                next2 = xmlPullParser.next();
                            } while (next2 == 4);
                            if (next2 == 2) {
                                drawable = xmlPullParser.getName().equals("vector") ? e.a0.a.a.g.a(resources, xmlPullParser, attributeSet, theme) : e.b.c.b.a(resources, xmlPullParser, attributeSet, theme);
                            } else {
                                throw new XmlPullParserException(f.a.a.a.a.g(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                            }
                        }
                        if (drawable != null) {
                            c cVar2 = aVar.q;
                            int a = cVar2.a(drawable);
                            cVar2.J[a] = trimStateSet;
                            cVar2.L.g(a, Integer.valueOf(resourceId));
                        } else {
                            throw new XmlPullParserException(f.a.a.a.a.g(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                        }
                    } else {
                        if (xmlPullParser.getName().equals("transition")) {
                            TypedArray c13 = m.e.c1(resources2, theme2, attributeSet2, R$styleable.AnimatedStateListDrawableTransition);
                            int resourceId3 = c13.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
                            int resourceId4 = c13.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
                            int resourceId5 = c13.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
                            e.a0.a.a.c f2 = resourceId5 > 0 ? r0.d().f(context2, resourceId5) : null;
                            boolean z = c13.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
                            c13.recycle();
                            e.a0.a.a.c cVar3 = f2;
                            if (f2 == null) {
                                do {
                                    next = xmlPullParser.next();
                                } while (next == 4);
                                if (next != 2) {
                                    throw new XmlPullParserException(f.a.a.a.a.g(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                                } else if (xmlPullParser.getName().equals("animated-vector")) {
                                    e.a0.a.a.c cVar4 = new e.a0.a.a.c(context2, null, null);
                                    cVar4.inflate(resources2, xmlPullParser, attributeSet2, theme2);
                                    cVar3 = cVar4;
                                } else {
                                    cVar3 = e.b.c.b.a(resources, xmlPullParser, attributeSet, theme);
                                }
                            }
                            if (cVar3 == null) {
                                throw new XmlPullParserException(f.a.a.a.a.g(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                            } else if (resourceId3 == -1 || resourceId4 == -1) {
                                break;
                            } else {
                                c cVar5 = aVar.q;
                                int a2 = cVar5.a(cVar3);
                                long h2 = c.h(resourceId3, resourceId4);
                                long j2 = z ? 8589934592L : 0;
                                long j3 = (long) a2;
                                cVar5.K.a(h2, Long.valueOf(j3 | j2));
                                if (z) {
                                    cVar5.K.a(c.h(resourceId4, resourceId3), Long.valueOf(j3 | 4294967296L | j2));
                                }
                            }
                        }
                        context2 = context;
                        resources2 = resources;
                    }
                    drawable = null;
                    i2 = 1;
                    attributeSet2 = attributeSet;
                    theme2 = theme;
                }
            }
            aVar.onStateChange(aVar.getState());
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // e.b.b.a.d, e.b.b.a.b
    public b.c b() {
        return new c(this.q, this, null);
    }

    @Override // e.b.b.a.d, e.b.b.a.b
    public void e(b.c cVar) {
        super.e(cVar);
        if (cVar instanceof c) {
            this.q = (c) cVar;
        }
    }

    @Override // e.b.b.a.d
    public d.a f() {
        return new c(this.q, this, null);
    }

    @Override // e.b.b.a.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // e.b.b.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.r;
        if (gVar != null) {
            gVar.d();
            this.r = null;
            d(this.s);
            this.s = -1;
            this.t = -1;
        }
    }

    @Override // e.b.b.a.d, e.b.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.u) {
            super.mutate();
            if (this == this) {
                this.q.e();
                this.u = true;
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00eb  */
    @Override // e.b.b.a.d, e.b.b.a.b, android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onStateChange(int[] iArr) {
        boolean z;
        g gVar;
        c cVar = this.q;
        int g2 = cVar.g(iArr);
        if (g2 < 0) {
            g2 = cVar.g(StateSet.WILD_CARD);
        }
        int i2 = this.f779h;
        boolean z2 = false;
        if (g2 != i2) {
            g gVar2 = this.r;
            if (gVar2 != null) {
                if (g2 != this.s) {
                    if (g2 != this.t || !gVar2.a()) {
                        i2 = this.s;
                        gVar2.d();
                    } else {
                        gVar2.b();
                        this.s = this.t;
                        this.t = g2;
                    }
                }
                z = true;
                if (!z || d(g2)) {
                    z2 = true;
                }
            }
            this.r = null;
            this.t = -1;
            this.s = -1;
            c cVar2 = this.q;
            int i3 = cVar2.i(i2);
            int i4 = cVar2.i(g2);
            if (!(i4 == 0 || i3 == 0)) {
                int longValue = (int) cVar2.K.f(c.h(i3, i4), -1L).longValue();
                if (longValue >= 0) {
                    boolean z3 = (cVar2.K.f(c.h(i3, i4), -1L).longValue() & 8589934592L) != 0;
                    d(longValue);
                    Drawable drawable = this.f775d;
                    if (drawable instanceof AnimationDrawable) {
                        gVar = new e((AnimationDrawable) drawable, (cVar2.K.f(c.h(i3, i4), -1L).longValue() & 4294967296L) != 0, z3);
                    } else if (drawable instanceof e.a0.a.a.c) {
                        gVar = new d((e.a0.a.a.c) drawable);
                    } else if (drawable instanceof Animatable) {
                        gVar = new b((Animatable) drawable);
                    }
                    gVar.c();
                    this.r = gVar;
                    this.t = i2;
                    this.s = g2;
                    z = true;
                    if (!z) {
                    }
                    z2 = true;
                }
            }
            z = false;
            if (!z) {
            }
            z2 = true;
        }
        Drawable drawable2 = this.f775d;
        return drawable2 != null ? z2 | drawable2.setState(iArr) : z2;
    }

    @Override // e.b.b.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.r;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
