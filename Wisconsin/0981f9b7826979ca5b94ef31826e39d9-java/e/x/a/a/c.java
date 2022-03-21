package e.x.a.a;

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
import android.util.Log;
import android.util.Xml;
import e.b.a.m;
import e.i.b.b.h;
import e.x.a.a.g;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c extends f implements Animatable {
    public b c;

    /* renamed from: d  reason: collision with root package name */
    public Context f1948d;

    /* renamed from: e  reason: collision with root package name */
    public ArgbEvaluator f1949e;

    /* renamed from: f  reason: collision with root package name */
    public final Drawable.Callback f1950f;

    public class a implements Drawable.Callback {
        public a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            c.this.scheduleSelf(runnable, j2);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    public static class b extends Drawable.ConstantState {
        public int a;
        public g b;
        public AnimatorSet c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Animator> f1951d;

        /* renamed from: e  reason: collision with root package name */
        public e.e.a<Animator, String> f1952e;

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
                    this.b.f1957g = false;
                }
                ArrayList<Animator> arrayList = bVar.f1951d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f1951d = new ArrayList<>(size);
                    this.f1952e = new e.e.a<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = bVar.f1951d.get(i2);
                        Animator clone = animator.clone();
                        String orDefault = bVar.f1952e.getOrDefault(animator, null);
                        clone.setTarget(this.b.c.b.p.getOrDefault(orDefault, null));
                        this.f1951d.add(clone);
                        this.f1952e.put(clone, orDefault);
                    }
                    if (this.c == null) {
                        this.c = new AnimatorSet();
                    }
                    this.c.playTogether(this.f1951d);
                }
            }
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public c() {
        this(null, null, null);
    }

    public c(Context context, b bVar, Resources resources) {
        this.f1949e = null;
        a aVar = new a();
        this.f1950f = aVar;
        this.f1948d = context;
        this.c = new b(null, aVar, null);
    }

    @Override // e.x.a.a.f
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

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

    public int getAlpha() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.c.b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.c.b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0061c(this.b.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.c.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.c.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getOpacity() : this.c.b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A[Catch:{ IOException | XmlPullParserException -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x007d A[SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Animator animator;
        XmlResourceParser xmlResourceParser;
        Throwable th;
        XmlPullParserException e2;
        IOException e3;
        g gVar;
        int next;
        int i2 = Build.VERSION.SDK_INT;
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
                XmlResourceParser xmlResourceParser2 = null;
                if ("animated-vector".equals(name)) {
                    TypedArray e4 = h.e(resources, theme, attributeSet, a.f1940e);
                    int resourceId = e4.getResourceId(0, 0);
                    if (resourceId != 0) {
                        PorterDuff.Mode mode = g.f1953k;
                        if (i2 >= 24) {
                            gVar = new g();
                            gVar.b = resources.getDrawable(resourceId, theme);
                            new g.i(gVar.b.getConstantState());
                        } else {
                            try {
                                XmlResourceParser xml = resources.getXml(resourceId);
                                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                                while (true) {
                                    next = xml.next();
                                    if (next == 2 || next == 1) {
                                        if (next != 2) {
                                            gVar = g.a(resources, xml, asAttributeSet, theme);
                                        } else {
                                            throw new XmlPullParserException("No start tag found");
                                        }
                                    }
                                }
                                if (next != 2) {
                                }
                            } catch (IOException | XmlPullParserException e5) {
                                Log.e("VectorDrawableCompat", "parser error", e5);
                                gVar = null;
                            }
                        }
                        gVar.f1957g = false;
                        gVar.setCallback(this.f1950f);
                        g gVar2 = this.c.b;
                        if (gVar2 != null) {
                            gVar2.setCallback(null);
                        }
                        this.c.b = gVar;
                    }
                    e4.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f1941f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f1948d;
                        if (context != null) {
                            if (i2 >= 24) {
                                animator = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                Resources resources2 = context.getResources();
                                Resources.Theme theme2 = context.getTheme();
                                try {
                                    xmlResourceParser = resources2.getAnimation(resourceId2);
                                    try {
                                        animator = d.a(context, resources2, theme2, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, 1.0f);
                                        xmlResourceParser.close();
                                    } catch (XmlPullParserException e6) {
                                        e2 = e6;
                                        Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                        notFoundException.initCause(e2);
                                        throw notFoundException;
                                    } catch (IOException e7) {
                                        e3 = e7;
                                        xmlResourceParser2 = xmlResourceParser;
                                        Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                        notFoundException2.initCause(e3);
                                        throw notFoundException2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (xmlResourceParser != null) {
                                        }
                                        throw th;
                                    }
                                } catch (XmlPullParserException e8) {
                                    e2 = e8;
                                    Resources.NotFoundException notFoundException3 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                    notFoundException3.initCause(e2);
                                    throw notFoundException3;
                                } catch (IOException e9) {
                                    e3 = e9;
                                    Resources.NotFoundException notFoundException22 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                    notFoundException22.initCause(e3);
                                    throw notFoundException22;
                                } catch (Throwable th3) {
                                    th = th3;
                                    xmlResourceParser = xmlResourceParser2;
                                    if (xmlResourceParser != null) {
                                        xmlResourceParser.close();
                                    }
                                    throw th;
                                }
                            }
                            animator.setTarget(this.c.b.c.b.p.getOrDefault(string, null));
                            b bVar = this.c;
                            if (bVar.f1951d == null) {
                                bVar.f1951d = new ArrayList<>();
                                this.c.f1952e = new e.e.a<>();
                            }
                            this.c.f1951d.add(animator);
                            this.c.f1952e.put(animator, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        b bVar2 = this.c;
        if (bVar2.c == null) {
            bVar2.c = new AnimatorSet();
        }
        bVar2.c.playTogether(bVar2.f1951d);
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.c.b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.c.c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.isStateful() : this.c.b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.c.b.setBounds(rect);
        }
    }

    @Override // e.x.a.a.f
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setLevel(i2) : this.c.b.setLevel(i2);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setState(iArr) : this.c.b.setState(iArr);
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.c.b.setAlpha(i2);
        }
    }

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
            gVar.c.f1989e = z;
        }
    }

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
        gVar.f1955e = colorFilter;
        gVar.invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.d1(drawable, i2);
        } else {
            this.c.b.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.e1(drawable, colorStateList);
        } else {
            this.c.b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.f1(drawable, mode);
        } else {
            this.c.b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.c.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.c.c.isStarted()) {
            this.c.c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.c.c.end();
        }
    }

    /* renamed from: e.x.a.a.c$c  reason: collision with other inner class name */
    public static class C0061c extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public C0061c(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            c cVar = new c(null, null, null);
            Drawable newDrawable = this.a.newDrawable();
            cVar.b = newDrawable;
            newDrawable.setCallback(cVar.f1950f);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            c cVar = new c(null, null, null);
            Drawable newDrawable = this.a.newDrawable(resources);
            cVar.b = newDrawable;
            newDrawable.setCallback(cVar.f1950f);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c(null, null, null);
            Drawable newDrawable = this.a.newDrawable(resources, theme);
            cVar.b = newDrawable;
            newDrawable.setCallback(cVar.f1950f);
            return cVar;
        }
    }
}
