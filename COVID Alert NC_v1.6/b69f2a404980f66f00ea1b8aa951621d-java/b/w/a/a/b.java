package b.w.a.a;

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
import android.util.Xml;
import b.b.k.i;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class b extends e implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    public C0048b f1842c;

    /* renamed from: d  reason: collision with root package name */
    public Context f1843d;

    /* renamed from: e  reason: collision with root package name */
    public ArgbEvaluator f1844e;
    public final Drawable.Callback f;

    public class a implements Drawable.Callback {
        public a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            b.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: b.w.a.a.b$b  reason: collision with other inner class name */
    public static class C0048b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f1846a;

        /* renamed from: b  reason: collision with root package name */
        public f f1847b;

        /* renamed from: c  reason: collision with root package name */
        public AnimatorSet f1848c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Animator> f1849d;

        /* renamed from: e  reason: collision with root package name */
        public b.e.a<Animator, String> f1850e;

        public C0048b(C0048b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f1846a = bVar.f1846a;
                f fVar = bVar.f1847b;
                if (fVar != null) {
                    Drawable.ConstantState constantState = fVar.getConstantState();
                    f fVar2 = (f) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.f1847b = fVar2;
                    fVar2.mutate();
                    this.f1847b = fVar2;
                    fVar2.setCallback(callback);
                    this.f1847b.setBounds(bVar.f1847b.getBounds());
                    this.f1847b.g = false;
                }
                ArrayList<Animator> arrayList = bVar.f1849d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f1849d = new ArrayList<>(size);
                    this.f1850e = new b.e.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = bVar.f1849d.get(i);
                        Animator clone = animator.clone();
                        String orDefault = bVar.f1850e.getOrDefault(animator, null);
                        clone.setTarget(this.f1847b.f1855c.f1874b.p.getOrDefault(orDefault, null));
                        this.f1849d.add(clone);
                        this.f1850e.put(clone, orDefault);
                    }
                    if (this.f1848c == null) {
                        this.f1848c = new AnimatorSet();
                    }
                    this.f1848c.playTogether(this.f1849d);
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f1846a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public b() {
        this(null, null, null);
    }

    public b(Context context, C0048b bVar, Resources resources) {
        this.f1844e = null;
        this.f = new a();
        this.f1843d = context;
        this.f1842c = new C0048b(null, this.f, null);
    }

    @Override // b.w.a.a.e
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f1842c.f1847b.draw(canvas);
        if (this.f1842c.f1848c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f1842c.f1847b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1842c.f1846a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f1842c.f1847b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f1854b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f1854b.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f1842c.f1847b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f1842c.f1847b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.getOpacity() : this.f1842c.f1847b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00eb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ee, code lost:
        r7 = "Can't load animation resource ID #0x";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f3, code lost:
        r7 = "Can't load animation resource ID #0x";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00eb A[ExcHandler: all (th java.lang.Throwable), Splitter:B:32:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0139  */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray;
        Animator animator;
        XmlResourceParser xmlResourceParser;
        String str;
        XmlPullParserException e2;
        IOException e3;
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        for (int i = 1; eventType != i && (xmlPullParser.getDepth() >= depth || eventType != 3); i = 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                XmlResourceParser xmlResourceParser2 = null;
                if ("animated-vector".equals(name)) {
                    typedArray = i.j.C0(resources, theme, attributeSet, a.f1841e);
                    int resourceId = typedArray.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f b2 = f.b(resources, resourceId, theme);
                        b2.g = false;
                        b2.setCallback(this.f);
                        f fVar = this.f1842c.f1847b;
                        if (fVar != null) {
                            fVar.setCallback(null);
                        }
                        this.f1842c.f1847b = b2;
                    }
                } else if ("target".equals(name)) {
                    typedArray = resources.obtainAttributes(attributeSet, a.f);
                    String string = typedArray.getString(0);
                    int resourceId2 = typedArray.getResourceId(i, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f1843d;
                        if (context != null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                animator = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                Resources resources2 = context.getResources();
                                Resources.Theme theme2 = context.getTheme();
                                try {
                                    xmlResourceParser = resources2.getAnimation(resourceId2);
                                    try {
                                        str = "Can't load animation resource ID #0x";
                                        animator = i.j.D(context, resources2, theme2, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, 1.0f);
                                        xmlResourceParser.close();
                                    } catch (XmlPullParserException e4) {
                                        e2 = e4;
                                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                        notFoundException.initCause(e2);
                                        throw notFoundException;
                                    } catch (IOException e5) {
                                        e3 = e5;
                                        xmlResourceParser2 = xmlResourceParser;
                                        Resources.NotFoundException notFoundException2 = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                        notFoundException2.initCause(e3);
                                        throw notFoundException2;
                                    } catch (Throwable th) {
                                    }
                                } catch (XmlPullParserException e6) {
                                    e2 = e6;
                                    str = "Can't load animation resource ID #0x";
                                    Resources.NotFoundException notFoundException3 = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                    notFoundException3.initCause(e2);
                                    throw notFoundException3;
                                } catch (IOException e7) {
                                    e3 = e7;
                                    str = "Can't load animation resource ID #0x";
                                    Resources.NotFoundException notFoundException22 = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                    notFoundException22.initCause(e3);
                                    throw notFoundException22;
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    xmlResourceParser = xmlResourceParser2;
                                    if (xmlResourceParser != null) {
                                        xmlResourceParser.close();
                                    }
                                    throw th3;
                                }
                            }
                            animator.setTarget(this.f1842c.f1847b.f1855c.f1874b.p.getOrDefault(string, null));
                            C0048b bVar = this.f1842c;
                            if (bVar.f1849d == null) {
                                bVar.f1849d = new ArrayList<>();
                                this.f1842c.f1850e = new b.e.a<>();
                            }
                            this.f1842c.f1849d.add(animator);
                            this.f1842c.f1850e.put(animator, string);
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
        C0048b bVar2 = this.f1842c;
        if (bVar2.f1848c == null) {
            bVar2.f1848c = new AnimatorSet();
        }
        bVar2.f1848c.playTogether(bVar2.f1849d);
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f1842c.f1847b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f1854b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f1842c.f1848c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.isStateful() : this.f1842c.f1847b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f1842c.f1847b.setBounds(rect);
        }
    }

    @Override // b.w.a.a.e
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.setLevel(i) : this.f1842c.f1847b.setLevel(i);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.setState(iArr) : this.f1842c.f1847b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f1842c.f1847b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            return;
        }
        f fVar = this.f1842c.f1847b;
        Drawable drawable2 = fVar.f1854b;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(z);
        } else {
            fVar.f1855c.f1877e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        f fVar = this.f1842c.f1847b;
        Drawable drawable2 = fVar.f1854b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        fVar.f1857e = colorFilter;
        fVar.invalidateSelf();
    }

    public void setTint(int i) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            i.j.b1(drawable, i);
        } else {
            this.f1842c.f1847b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            i.j.c1(drawable, colorStateList);
        } else {
            this.f1842c.f1847b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            i.j.d1(drawable, mode);
        } else {
            this.f1842c.f1847b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f1842c.f1847b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f1842c.f1848c.isStarted()) {
            this.f1842c.f1848c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f1842c.f1848c.end();
        }
    }

    public static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f1851a;

        public c(Drawable.ConstantState constantState) {
            this.f1851a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f1851a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1851a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            b bVar = new b(null, null, null);
            Drawable newDrawable = this.f1851a.newDrawable();
            bVar.f1854b = newDrawable;
            newDrawable.setCallback(bVar.f);
            return bVar;
        }

        public Drawable newDrawable(Resources resources) {
            b bVar = new b(null, null, null);
            Drawable newDrawable = this.f1851a.newDrawable(resources);
            bVar.f1854b = newDrawable;
            newDrawable.setCallback(bVar.f);
            return bVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b(null, null, null);
            Drawable newDrawable = this.f1851a.newDrawable(resources, theme);
            bVar.f1854b = newDrawable;
            newDrawable.setCallback(bVar.f);
            return bVar;
        }
    }
}
