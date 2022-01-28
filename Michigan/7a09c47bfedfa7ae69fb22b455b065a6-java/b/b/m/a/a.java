package b.b.m.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import b.b.k.i;
import b.b.m.a.b;
import b.b.m.a.d;
import b.b.q.n0;
import b.e.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
public class a extends d {
    public c p;
    public g q;
    public int r;
    public int s;
    public boolean t;

    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final Animatable f610a;

        public b(Animatable animatable) {
            super(null);
            this.f610a = animatable;
        }

        @Override // b.b.m.a.a.g
        public void c() {
            this.f610a.start();
        }

        @Override // b.b.m.a.a.g
        public void d() {
            this.f610a.stop();
        }
    }

    public static class c extends d.a {
        public b.e.e<Long> K;
        public i<Integer> L;

        public c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            i<Integer> iVar;
            if (cVar != null) {
                this.K = cVar.K;
                iVar = cVar.L;
            } else {
                this.K = new b.e.e<>();
                iVar = new i<>();
            }
            this.L = iVar;
        }

        public static long i(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        @Override // b.b.m.a.d.a, b.b.m.a.b.c
        public void e() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int h(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long i3 = i(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a2;
            this.K.a(i3, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(i(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        public int j(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.e(i, 0).intValue();
        }

        public int k(int[] iArr) {
            int g2 = super.g(iArr);
            return g2 >= 0 ? g2 : super.g(StateSet.WILD_CARD);
        }

        @Override // b.b.m.a.d.a
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // b.b.m.a.d.a
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        public final b.y.a.a.b f611a;

        public d(b.y.a.a.b bVar) {
            super(null);
            this.f611a = bVar;
        }

        @Override // b.b.m.a.a.g
        public void c() {
            this.f611a.start();
        }

        @Override // b.b.m.a.a.g
        public void d() {
            this.f611a.stop();
        }
    }

    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        public final ObjectAnimator f612a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f613b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) fVar.f616c);
            ofInt.setInterpolator(fVar);
            this.f613b = z2;
            this.f612a = ofInt;
        }

        @Override // b.b.m.a.a.g
        public boolean a() {
            return this.f613b;
        }

        @Override // b.b.m.a.a.g
        public void b() {
            this.f612a.reverse();
        }

        @Override // b.b.m.a.a.g
        public void c() {
            this.f612a.start();
        }

        @Override // b.b.m.a.a.g
        public void d() {
            this.f612a.cancel();
        }
    }

    public static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public int[] f614a;

        /* renamed from: b  reason: collision with root package name */
        public int f615b;

        /* renamed from: c  reason: collision with root package name */
        public int f616c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f615b = numberOfFrames;
            int[] iArr = this.f614a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f614a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f614a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f616c = i;
        }

        public float getInterpolation(float f2) {
            int i = (int) ((f2 * ((float) this.f616c)) + 0.5f);
            int i2 = this.f615b;
            int[] iArr = this.f614a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.f616c) : 0.0f);
        }
    }

    public static abstract class g {
        public g(C0010a aVar) {
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
        this.r = -1;
        this.s = -1;
        c cVar2 = new c(cVar, this, resources);
        super.f(cVar2);
        this.p = cVar2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d3, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(c.a.a.a.a.f(r19, new java.lang.StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
     */
    public static a h(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        Drawable drawable;
        b.y.a.a.b bVar;
        int next;
        int next2;
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            Drawable drawable2 = null;
            a aVar = new a(null, null);
            TypedArray S = i.j.S(resources, theme, attributeSet, b.b.n.b.AnimatedStateListDrawableCompat);
            int i = 1;
            aVar.setVisible(S.getBoolean(b.b.n.b.AnimatedStateListDrawableCompat_android_visible, true), true);
            c cVar = aVar.p;
            cVar.f628d |= S.getChangingConfigurations();
            cVar.i = S.getBoolean(b.b.n.b.AnimatedStateListDrawableCompat_android_variablePadding, cVar.i);
            cVar.l = S.getBoolean(b.b.n.b.AnimatedStateListDrawableCompat_android_constantSize, cVar.l);
            cVar.A = S.getInt(b.b.n.b.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A);
            cVar.B = S.getInt(b.b.n.b.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B);
            aVar.setDither(S.getBoolean(b.b.n.b.AnimatedStateListDrawableCompat_android_dither, cVar.x));
            aVar.f617b.f(resources);
            S.recycle();
            int depth2 = xmlPullParser.getDepth() + 1;
            while (true) {
                int next3 = xmlPullParser.next();
                if (next3 == i || ((depth = xmlPullParser.getDepth()) < depth2 && next3 == 3)) {
                    aVar.onStateChange(aVar.getState());
                } else if (next3 == 2 && depth <= depth2) {
                    if (xmlPullParser.getName().equals("item")) {
                        TypedArray S2 = i.j.S(resources, theme, attributeSet, b.b.n.b.AnimatedStateListDrawableItem);
                        int resourceId = S2.getResourceId(b.b.n.b.AnimatedStateListDrawableItem_android_id, 0);
                        int resourceId2 = S2.getResourceId(b.b.n.b.AnimatedStateListDrawableItem_android_drawable, -1);
                        if (resourceId2 > 0) {
                            drawable2 = n0.d().f(context, resourceId2);
                        }
                        S2.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i2 = 0;
                        for (int i3 = 0; i3 < attributeCount; i3++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                                int i4 = i2 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i2] = attributeNameResource;
                                i2 = i4;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr, i2);
                        if (drawable2 == null) {
                            do {
                                next2 = xmlPullParser.next();
                            } while (next2 == 4);
                            if (next2 == 2) {
                                drawable2 = xmlPullParser.getName().equals("vector") ? b.y.a.a.f.c(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            } else {
                                throw new XmlPullParserException(c.a.a.a.a.f(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                            }
                        }
                        if (drawable2 != null) {
                            c cVar2 = aVar.p;
                            int a2 = cVar2.a(drawable2);
                            cVar2.J[a2] = trimStateSet;
                            cVar2.L.g(a2, Integer.valueOf(resourceId));
                        } else {
                            throw new XmlPullParserException(c.a.a.a.a.f(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                        }
                    } else if (xmlPullParser.getName().equals("transition")) {
                        TypedArray S3 = i.j.S(resources, theme, attributeSet, b.b.n.b.AnimatedStateListDrawableTransition);
                        int resourceId3 = S3.getResourceId(b.b.n.b.AnimatedStateListDrawableTransition_android_fromId, -1);
                        int resourceId4 = S3.getResourceId(b.b.n.b.AnimatedStateListDrawableTransition_android_toId, -1);
                        int resourceId5 = S3.getResourceId(b.b.n.b.AnimatedStateListDrawableTransition_android_drawable, -1);
                        b.y.a.a.b f2 = resourceId5 > 0 ? n0.d().f(context, resourceId5) : null;
                        boolean z = S3.getBoolean(b.b.n.b.AnimatedStateListDrawableTransition_android_reversible, false);
                        S3.recycle();
                        if (f2 == null) {
                            do {
                                next = xmlPullParser.next();
                            } while (next == 4);
                            if (next != 2) {
                                throw new XmlPullParserException(c.a.a.a.a.f(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                            } else if (xmlPullParser.getName().equals("animated-vector")) {
                                drawable = null;
                                b.y.a.a.b bVar2 = new b.y.a.a.b(context, null, null);
                                bVar2.inflate(resources, xmlPullParser, attributeSet, theme);
                                bVar = bVar2;
                            } else {
                                drawable = null;
                                bVar = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            }
                        } else {
                            drawable = null;
                            bVar = f2;
                        }
                        if (bVar == null) {
                            throw new XmlPullParserException(c.a.a.a.a.f(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                        } else if (resourceId3 != -1 && resourceId4 != -1) {
                            aVar.p.h(resourceId3, resourceId4, bVar, z);
                            drawable2 = drawable;
                            i = 1;
                        }
                    }
                    drawable2 = null;
                    i = 1;
                }
            }
            aVar.onStateChange(aVar.getState());
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // b.b.m.a.b, b.b.m.a.d
    public b.c b() {
        return new c(this.p, this, null);
    }

    @Override // b.b.m.a.b, b.b.m.a.d
    public void f(b.c cVar) {
        super.f(cVar);
        if (cVar instanceof c) {
            this.p = (c) cVar;
        }
    }

    @Override // b.b.m.a.d
    public d.a g() {
        return new c(this.p, this, null);
    }

    @Override // b.b.m.a.d
    public boolean isStateful() {
        return true;
    }

    @Override // b.b.m.a.b
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            e(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // b.b.m.a.b, b.b.m.a.d
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.e();
                this.t = true;
            }
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (e(r0) == false) goto L_0x00e4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // b.b.m.a.b, b.b.m.a.d
    public boolean onStateChange(int[] iArr) {
        boolean z;
        g gVar;
        int k = this.p.k(iArr);
        int i = this.h;
        boolean z2 = true;
        if (k != i) {
            g gVar2 = this.q;
            if (gVar2 != null) {
                if (k != this.r) {
                    if (k != this.s || !gVar2.a()) {
                        i = this.r;
                        gVar2.d();
                    } else {
                        gVar2.b();
                        this.r = this.s;
                        this.s = k;
                    }
                }
                z = true;
                if (!z) {
                }
                Drawable drawable = this.f619d;
                return drawable == null ? z2 | drawable.setState(iArr) : z2;
            }
            this.q = null;
            this.s = -1;
            this.r = -1;
            c cVar = this.p;
            int j = cVar.j(i);
            int j2 = cVar.j(k);
            if (!(j2 == 0 || j == 0)) {
                int longValue = (int) cVar.K.f(c.i(j, j2), -1L).longValue();
                if (longValue >= 0) {
                    boolean z3 = (cVar.K.f(c.i(j, j2), -1L).longValue() & 8589934592L) != 0;
                    e(longValue);
                    Drawable drawable2 = this.f619d;
                    if (drawable2 instanceof AnimationDrawable) {
                        gVar = new e((AnimationDrawable) drawable2, (cVar.K.f(c.i(j, j2), -1L).longValue() & 4294967296L) != 0, z3);
                    } else if (drawable2 instanceof b.y.a.a.b) {
                        gVar = new d((b.y.a.a.b) drawable2);
                    } else if (drawable2 instanceof Animatable) {
                        gVar = new b((Animatable) drawable2);
                    }
                    gVar.c();
                    this.q = gVar;
                    this.s = i;
                    this.r = k;
                    z = true;
                    if (!z) {
                    }
                    Drawable drawable3 = this.f619d;
                    if (drawable3 == null) {
                    }
                }
            }
            z = false;
            if (!z) {
            }
            Drawable drawable32 = this.f619d;
            if (drawable32 == null) {
            }
        }
        z2 = false;
        Drawable drawable322 = this.f619d;
        if (drawable322 == null) {
        }
    }

    @Override // b.b.m.a.b
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.q != null && (visible || z2)) {
            if (z) {
                this.q.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
