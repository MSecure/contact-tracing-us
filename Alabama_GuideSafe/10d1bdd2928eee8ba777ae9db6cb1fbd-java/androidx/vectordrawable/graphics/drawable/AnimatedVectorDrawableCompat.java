package androidx.vectordrawable.graphics.drawable;

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
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.ArrayMap;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable {
    public AnimatedVectorDrawableCompatState mAnimatedVectorState;
    public ArgbEvaluator mArgbEvaluator;
    public final Drawable.Callback mCallback;
    public Context mContext;

    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        public AnimatorSet mAnimatorSet;
        public ArrayList<Animator> mAnimators;
        public int mChangingConfigurations;
        public ArrayMap<Animator, String> mTargetNameMap;
        public VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.mChangingConfigurations = animatedVectorDrawableCompatState.mChangingConfigurations;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.mVectorDrawable;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = this.mVectorDrawable;
                    vectorDrawableCompat2.mutate();
                    this.mVectorDrawable = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.mVectorDrawable.setBounds(animatedVectorDrawableCompatState.mVectorDrawable.getBounds());
                    this.mVectorDrawable.mAllowCaching = false;
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.mAnimators;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.mAnimators = new ArrayList<>(size);
                    this.mTargetNameMap = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = animatedVectorDrawableCompatState.mAnimators.get(i);
                        Animator clone = animator.clone();
                        String orDefault = animatedVectorDrawableCompatState.mTargetNameMap.getOrDefault(animator, null);
                        clone.setTarget(this.mVectorDrawable.mVectorState.mVPathRenderer.mVGTargetsMap.getOrDefault(orDefault, null));
                        this.mAnimators.add(clone);
                        this.mTargetNameMap.put(clone, orDefault);
                    }
                    if (this.mAnimatorSet == null) {
                        this.mAnimatorSet = new AnimatorSet();
                    }
                    this.mAnimatorSet.playTogether(this.mAnimators);
                }
            }
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ee, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f1, code lost:
        r7 = "Can't load animation resource ID #0x";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f6, code lost:
        r7 = "Can't load animation resource ID #0x";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013c, code lost:
        r19.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ee A[ExcHandler: all (th java.lang.Throwable), Splitter:B:33:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013c  */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Animator animator;
        XmlResourceParser xmlResourceParser;
        String str;
        XmlPullParserException e;
        IOException e2;
        Drawable drawable = this.mDelegateDrawable;
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
                    TypedArray obtainAttributes1 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
                    int resourceId = obtainAttributes1.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, theme);
                        create.mAllowCaching = false;
                        create.setCallback(this.mCallback);
                        VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.mVectorDrawable;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback(null);
                        }
                        this.mAnimatedVectorState.mVectorDrawable = create;
                    }
                    obtainAttributes1.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(i, 0);
                    if (resourceId2 != 0) {
                        Context context = this.mContext;
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
                                        animator = AppCompatDelegateImpl.ConfigurationImplApi17.createAnimatorFromXml(context, resources2, theme2, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, 1.0f);
                                        xmlResourceParser.close();
                                    } catch (XmlPullParserException e3) {
                                        e = e3;
                                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                        notFoundException.initCause(e);
                                        throw notFoundException;
                                    } catch (IOException e4) {
                                        e2 = e4;
                                        xmlResourceParser2 = xmlResourceParser;
                                        Resources.NotFoundException notFoundException2 = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                        notFoundException2.initCause(e2);
                                        throw notFoundException2;
                                    } catch (Throwable th) {
                                    }
                                } catch (XmlPullParserException e5) {
                                    e = e5;
                                    str = "Can't load animation resource ID #0x";
                                    Resources.NotFoundException notFoundException3 = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                    notFoundException3.initCause(e);
                                    throw notFoundException3;
                                } catch (IOException e6) {
                                    e2 = e6;
                                    str = "Can't load animation resource ID #0x";
                                    Resources.NotFoundException notFoundException22 = new Resources.NotFoundException(str + Integer.toHexString(resourceId2));
                                    notFoundException22.initCause(e2);
                                    throw notFoundException22;
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    xmlResourceParser = xmlResourceParser2;
                                    if (xmlResourceParser != null) {
                                    }
                                    throw th3;
                                }
                            }
                            animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.mVectorState.mVPathRenderer.mVGTargetsMap.getOrDefault(string, null));
                            AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.mAnimatedVectorState;
                            if (animatedVectorDrawableCompatState.mAnimators == null) {
                                animatedVectorDrawableCompatState.mAnimators = new ArrayList<>();
                                this.mAnimatedVectorState.mTargetNameMap = new ArrayMap<>();
                            }
                            this.mAnimatedVectorState.mAnimators.add(animator);
                            this.mAnimatedVectorState.mTargetNameMap.put(animator, string);
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
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState2 = this.mAnimatedVectorState;
        if (animatedVectorDrawableCompatState2.mAnimatorSet == null) {
            animatedVectorDrawableCompatState2.mAnimatorSet = new AnimatorSet();
        }
        animatedVectorDrawableCompatState2.mAnimatorSet.playTogether(animatedVectorDrawableCompatState2.mAnimators);
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon
    public boolean onLevelChange(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(i);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            return;
        }
        VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.mVectorDrawable;
        Drawable drawable2 = vectorDrawableCompat.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(z);
        } else {
            vectorDrawableCompat.mVectorState.mAutoMirrored = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.mVectorDrawable;
        Drawable drawable2 = vectorDrawableCompat.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        vectorDrawableCompat.mColorFilter = colorFilter;
        vectorDrawableCompat.invalidateSelf();
    }

    public void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setTint(drawable, i);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setTintList(drawable, colorStateList);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setTintMode(drawable, mode);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.mAnimatedVectorState.mVectorDrawable.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            this.mAnimatedVectorState.mAnimatorSet.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.mAnimatedVectorState.mAnimatorSet.end();
        }
    }

    public AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.mArgbEvaluator = null;
        this.mCallback = new Drawable.Callback() {
            /* class androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.AnonymousClass1 */

            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(null, this.mCallback, null);
    }

    public static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        public final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
            Drawable newDrawable = this.mDelegateState.newDrawable();
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
            Drawable newDrawable = this.mDelegateState.newDrawable(resources);
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
            Drawable newDrawable = this.mDelegateState.newDrawable(resources, theme);
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
