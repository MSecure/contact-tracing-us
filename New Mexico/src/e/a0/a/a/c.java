package e.a0.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import e.a0.a.a.g;
import e.b.a.m;
import e.j.b.b.h;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class c extends f implements Animatable {
    public b c;

    /* renamed from: d */
    public Context f663d;

    /* renamed from: e */
    public ArgbEvaluator f664e;

    /* renamed from: f */
    public final Drawable.Callback f665f;

    /* loaded from: classes.dex */
    public class a implements Drawable.Callback {
        public a() {
            c.this = r1;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            c.this.scheduleSelf(runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Drawable.ConstantState {
        public int a;
        public g b;
        public AnimatorSet c;

        /* renamed from: d */
        public ArrayList<Animator> f666d;

        /* renamed from: e */
        public e.f.a<Animator, String> f667e;

        public b(b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.a = bVar.a;
                g gVar = bVar.b;
                if (gVar != null) {
                    Drawable.ConstantState constantState = gVar.getConstantState();
                    g gVar2 = (g) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.b = gVar2;
                    gVar2.mutate();
                    this.b = gVar2;
                    gVar2.setCallback(callback);
                    this.b.setBounds(bVar.b.getBounds());
                    this.b.f672g = false;
                }
                ArrayList<Animator> arrayList = bVar.f666d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f666d = new ArrayList<>(size);
                    this.f667e = new e.f.a<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = bVar.f666d.get(i2);
                        Animator clone = animator.clone();
                        String orDefault = bVar.f667e.getOrDefault(animator, null);
                        clone.setTarget(this.b.c.b.p.getOrDefault(orDefault, null));
                        this.f666d.add(clone);
                        this.f667e.put(clone, orDefault);
                    }
                    if (this.c == null) {
                        this.c = new AnimatorSet();
                    }
                    this.c.playTogether(this.f666d);
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public c() {
        this(null, null, null);
    }

    public c(Context context, b bVar, Resources resources) {
        this.f664e = null;
        a aVar = new a();
        this.f665f = aVar;
        this.f663d = context;
        this.c = new b(null, aVar, null);
    }

    @Override // e.a0.a.a.f, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.c.b.draw(canvas);
        if (this.c.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.c.b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.c.b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0012c(this.b.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.c.b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.c.b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getOpacity() : this.c.b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray;
        Animator animator;
        XmlResourceParser xmlResourceParser;
        Throwable th;
        XmlPullParserException e2;
        IOException e3;
        g gVar;
        int next;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    typedArray = m.e.c1(resources, theme, attributeSet, a.f655e);
                    int resourceId = typedArray.getResourceId(0, 0);
                    if (resourceId != 0) {
                        PorterDuff.Mode mode = g.f668k;
                        if (Build.VERSION.SDK_INT >= 24) {
                            gVar = new g();
                            ThreadLocal<TypedValue> threadLocal = h.a;
                            gVar.b = resources.getDrawable(resourceId, theme);
                            new g.i(gVar.b.getConstantState());
                        } else {
                            try {
                                XmlResourceParser xml = resources.getXml(resourceId);
                                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                                while (true) {
                                    next = xml.next();
                                    if (next == 2 || next == 1) {
                                        break;
                                    }
                                }
                                if (next != 2) {
                                    throw new XmlPullParserException("No start tag found");
                                    break;
                                }
                                gVar = g.a(resources, xml, asAttributeSet, theme);
                            } catch (IOException | XmlPullParserException unused) {
                                gVar = null;
                            }
                        }
                        gVar.f672g = false;
                        gVar.setCallback(this.f665f);
                        g gVar2 = this.c.b;
                        if (gVar2 != null) {
                            gVar2.setCallback(null);
                        }
                        this.c.b = gVar;
                    }
                } else if ("target".equals(name)) {
                    typedArray = resources.obtainAttributes(attributeSet, a.f656f);
                    String string = typedArray.getString(0);
                    int resourceId2 = typedArray.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f663d;
                        if (context != null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                animator = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                Resources resources2 = context.getResources();
                                Resources.Theme theme2 = context.getTheme();
                                try {
                                    try {
                                        xmlResourceParser = resources2.getAnimation(resourceId2);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        xmlResourceParser = null;
                                    }
                                } catch (IOException e4) {
                                    e3 = e4;
                                } catch (XmlPullParserException e5) {
                                    e2 = e5;
                                }
                                try {
                                    animator = d.a(context, resources2, theme2, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, 1.0f);
                                    xmlResourceParser.close();
                                } catch (IOException e6) {
                                    e3 = e6;
                                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                    notFoundException.initCause(e3);
                                    throw notFoundException;
                                } catch (XmlPullParserException e7) {
                                    e2 = e7;
                                    Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                    notFoundException2.initCause(e2);
                                    throw notFoundException2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (xmlResourceParser != null) {
                                        xmlResourceParser.close();
                                    }
                                    throw th;
                                }
                            }
                            animator.setTarget(this.c.b.c.b.p.getOrDefault(string, null));
                            b bVar = this.c;
                            if (bVar.f666d == null) {
                                bVar.f666d = new ArrayList<>();
                                this.c.f667e = new e.f.a<>();
                            }
                            this.c.f666d.add(animator);
                            this.c.f667e.put(animator, string);
                        } else {
                            typedArray.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                typedArray.recycle();
            }
            eventType = xmlPullParser.next();
        }
        b bVar2 = this.c;
        if (bVar2.c == null) {
            bVar2.c = new AnimatorSet();
        }
        bVar2.c.playTogether(bVar2.f666d);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.c.b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.c.c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.isStateful() : this.c.b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.c.b.setBounds(rect);
        }
    }

    @Override // e.a0.a.a.f, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setLevel(i2) : this.c.b.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setState(iArr) : this.c.b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.c.b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            return;
        }
        g gVar = this.c.b;
        Drawable drawable2 = gVar.b;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(z);
        } else {
            gVar.c.f704e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        g gVar = this.c.b;
        Drawable drawable2 = gVar.b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        gVar.f670e = colorFilter;
        gVar.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.E1(drawable, i2);
        } else {
            this.c.b.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.F1(drawable, colorStateList);
        } else {
            this.c.b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.G1(drawable, mode);
        } else {
            this.c.b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.c.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.c.c.isStarted()) {
            this.c.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.c.c.end();
        }
    }

    /* renamed from: e.a0.a.a.c$c */
    /* loaded from: classes.dex */
    public static class C0012c extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public C0012c(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c(null, null, null);
            Drawable newDrawable = this.a.newDrawable();
            cVar.b = newDrawable;
            newDrawable.setCallback(cVar.f665f);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c(null, null, null);
            Drawable newDrawable = this.a.newDrawable(resources);
            cVar.b = newDrawable;
            newDrawable.setCallback(cVar.f665f);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c(null, null, null);
            Drawable newDrawable = this.a.newDrawable(resources, theme);
            cVar.b = newDrawable;
            newDrawable.setCallback(cVar.f665f);
            return cVar;
        }
    }
}
