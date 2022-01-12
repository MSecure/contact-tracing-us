package androidx.appcompat.graphics.drawable;

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
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
public class AnimatedStateListDrawableCompat extends StateListDrawable {
    public boolean mMutated;
    public AnimatedStateListState mState;
    public Transition mTransition;
    public int mTransitionFromIndex;
    public int mTransitionToIndex;

    public static class AnimatableTransition extends Transition {
        public final Animatable mA;

        public AnimatableTransition(Animatable animatable) {
            super(null);
            this.mA = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mA.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mA.stop();
        }
    }

    public static class AnimatedStateListState extends StateListDrawable.StateListState {
        public SparseArrayCompat<Integer> mStateIds;
        public LongSparseArray<Long> mTransitions;

        public AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.mTransitions = animatedStateListState.mTransitions;
                this.mStateIds = animatedStateListState.mStateIds;
                return;
            }
            this.mTransitions = new LongSparseArray<>();
            this.mStateIds = new SparseArrayCompat<>(10);
        }

        public static long generateTransitionKey(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        public int addTransition(int i, int i2, Drawable drawable, boolean z) {
            int addChild = super.addChild(drawable);
            long generateTransitionKey = generateTransitionKey(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) addChild;
            this.mTransitions.append(generateTransitionKey, Long.valueOf(j2 | j));
            if (z) {
                this.mTransitions.append(generateTransitionKey(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return addChild;
        }

        public int getKeyframeIdAt(int i) {
            if (i < 0) {
                return 0;
            }
            return this.mStateIds.get(i, 0).intValue();
        }

        public int indexOfKeyframe(int[] iArr) {
            int indexOfStateSet = super.indexOfStateSet(iArr);
            if (indexOfStateSet >= 0) {
                return indexOfStateSet;
            }
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState, androidx.appcompat.graphics.drawable.StateListDrawable.StateListState
        public void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {
        public final AnimatedVectorDrawableCompat mAvd;

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super(null);
            this.mAvd = animatedVectorDrawableCompat;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAvd.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAvd.stop();
        }
    }

    public static class AnimationDrawableTransition extends Transition {
        public final ObjectAnimator mAnim;
        public final boolean mHasReversibleFlag;

        public AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) frameInterpolator.mTotalDuration);
            ofInt.setInterpolator(frameInterpolator);
            this.mHasReversibleFlag = z2;
            this.mAnim = ofInt;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAnim.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAnim.cancel();
        }
    }

    public static class FrameInterpolator implements TimeInterpolator {
        public int[] mFrameTimes;
        public int mFrames;
        public int mTotalDuration;

        public FrameInterpolator(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.mFrames = numberOfFrames;
            int[] iArr = this.mFrameTimes;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.mFrameTimes = new int[numberOfFrames];
            }
            int[] iArr2 = this.mFrameTimes;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.mTotalDuration = i;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.mTotalDuration)) + 0.5f);
            int i2 = this.mFrames;
            int[] iArr = this.mFrameTimes;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.mTotalDuration) : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    public static abstract class Transition {
        public Transition(AnonymousClass1 r1) {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d3, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(com.android.tools.r8.GeneratedOutlineSupport.outline16(r19, new java.lang.StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
     */
    public static AnimatedStateListDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        int depth;
        Drawable drawable;
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        int next;
        int next2;
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            Drawable drawable2 = null;
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat(null, null);
            TypedArray obtainAttributes1 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
            int i = 1;
            animatedStateListDrawableCompat.setVisible(obtainAttributes1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
            AnimatedStateListState animatedStateListState = animatedStateListDrawableCompat.mState;
            animatedStateListState.mChangingConfigurations |= obtainAttributes1.getChangingConfigurations();
            animatedStateListState.mVariablePadding = obtainAttributes1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, animatedStateListState.mVariablePadding);
            animatedStateListState.mConstantSize = obtainAttributes1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, animatedStateListState.mConstantSize);
            animatedStateListState.mEnterFadeDuration = obtainAttributes1.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, animatedStateListState.mEnterFadeDuration);
            animatedStateListState.mExitFadeDuration = obtainAttributes1.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, animatedStateListState.mExitFadeDuration);
            animatedStateListDrawableCompat.setDither(obtainAttributes1.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, animatedStateListState.mDither));
            animatedStateListDrawableCompat.mDrawableContainerState.updateDensity(resources);
            obtainAttributes1.recycle();
            int depth2 = xmlPullParser.getDepth() + 1;
            while (true) {
                int next3 = xmlPullParser.next();
                if (next3 == i || ((depth = xmlPullParser.getDepth()) < depth2 && next3 == 3)) {
                    animatedStateListDrawableCompat.onStateChange(animatedStateListDrawableCompat.getState());
                } else if (next3 == 2 && depth <= depth2) {
                    if (xmlPullParser.getName().equals("item")) {
                        TypedArray obtainAttributes12 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
                        int resourceId = obtainAttributes12.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
                        int resourceId2 = obtainAttributes12.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
                        if (resourceId2 > 0) {
                            drawable2 = ResourceManagerInternal.get().getDrawable(context, resourceId2);
                        }
                        obtainAttributes12.recycle();
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
                            if (next2 != 2) {
                                throw new XmlPullParserException(GeneratedOutlineSupport.outline16(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                            } else if (xmlPullParser.getName().equals("vector")) {
                                drawable2 = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            } else {
                                drawable2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            }
                        }
                        if (drawable2 != null) {
                            AnimatedStateListState animatedStateListState2 = animatedStateListDrawableCompat.mState;
                            int addChild = animatedStateListState2.addChild(drawable2);
                            animatedStateListState2.mStateSets[addChild] = trimStateSet;
                            animatedStateListState2.mStateIds.put(addChild, Integer.valueOf(resourceId));
                        } else {
                            throw new XmlPullParserException(GeneratedOutlineSupport.outline16(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                        }
                    } else if (xmlPullParser.getName().equals("transition")) {
                        TypedArray obtainAttributes13 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
                        int resourceId3 = obtainAttributes13.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
                        int resourceId4 = obtainAttributes13.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
                        int resourceId5 = obtainAttributes13.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
                        AnimatedVectorDrawableCompat drawable3 = resourceId5 > 0 ? ResourceManagerInternal.get().getDrawable(context, resourceId5) : null;
                        boolean z = obtainAttributes13.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
                        obtainAttributes13.recycle();
                        if (drawable3 == null) {
                            do {
                                next = xmlPullParser.next();
                            } while (next == 4);
                            if (next != 2) {
                                throw new XmlPullParserException(GeneratedOutlineSupport.outline16(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                            } else if (xmlPullParser.getName().equals("animated-vector")) {
                                drawable = null;
                                AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = new AnimatedVectorDrawableCompat(context, null, null);
                                animatedVectorDrawableCompat2.inflate(resources, xmlPullParser, attributeSet, theme);
                                animatedVectorDrawableCompat = animatedVectorDrawableCompat2;
                            } else {
                                drawable = null;
                                animatedVectorDrawableCompat = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            }
                        } else {
                            drawable = null;
                            animatedVectorDrawableCompat = drawable3;
                        }
                        if (animatedVectorDrawableCompat == null) {
                            throw new XmlPullParserException(GeneratedOutlineSupport.outline16(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                        } else if (resourceId3 != -1 && resourceId4 != -1) {
                            animatedStateListDrawableCompat.mState.addTransition(resourceId3, resourceId4, animatedVectorDrawableCompat, z);
                            drawable2 = drawable;
                            i = 1;
                        }
                    }
                    drawable2 = null;
                    i = 1;
                }
            }
            animatedStateListDrawableCompat.onStateChange(animatedStateListDrawableCompat.getState());
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.StateListDrawable
    public DrawableContainer.DrawableContainerState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.mTransition;
        if (transition != null) {
            transition.stop();
            this.mTransition = null;
            selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, androidx.appcompat.graphics.drawable.StateListDrawable
    public Drawable mutate() {
        if (!this.mMutated) {
            super.mutate();
            if (this == this) {
                this.mState.mutate();
                this.mMutated = true;
            }
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (selectDrawable(r0) == false) goto L_0x00e4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, androidx.appcompat.graphics.drawable.StateListDrawable
    public boolean onStateChange(int[] iArr) {
        boolean z;
        Transition transition;
        int indexOfKeyframe = this.mState.indexOfKeyframe(iArr);
        int i = this.mCurIndex;
        boolean z2 = true;
        if (indexOfKeyframe != i) {
            Transition transition2 = this.mTransition;
            if (transition2 != null) {
                if (indexOfKeyframe != this.mTransitionToIndex) {
                    if (indexOfKeyframe != this.mTransitionFromIndex || !transition2.canReverse()) {
                        i = this.mTransitionToIndex;
                        transition2.stop();
                    } else {
                        transition2.reverse();
                        this.mTransitionToIndex = this.mTransitionFromIndex;
                        this.mTransitionFromIndex = indexOfKeyframe;
                    }
                }
                z = true;
                if (!z) {
                }
                Drawable drawable = this.mCurrDrawable;
                return drawable == null ? z2 | drawable.setState(iArr) : z2;
            }
            this.mTransition = null;
            this.mTransitionFromIndex = -1;
            this.mTransitionToIndex = -1;
            AnimatedStateListState animatedStateListState = this.mState;
            int keyframeIdAt = animatedStateListState.getKeyframeIdAt(i);
            int keyframeIdAt2 = animatedStateListState.getKeyframeIdAt(indexOfKeyframe);
            if (!(keyframeIdAt2 == 0 || keyframeIdAt == 0)) {
                int longValue = (int) animatedStateListState.mTransitions.get(AnimatedStateListState.generateTransitionKey(keyframeIdAt, keyframeIdAt2), -1L).longValue();
                if (longValue >= 0) {
                    boolean z3 = (animatedStateListState.mTransitions.get(AnimatedStateListState.generateTransitionKey(keyframeIdAt, keyframeIdAt2), -1L).longValue() & 8589934592L) != 0;
                    selectDrawable(longValue);
                    Drawable drawable2 = this.mCurrDrawable;
                    if (drawable2 instanceof AnimationDrawable) {
                        transition = new AnimationDrawableTransition((AnimationDrawable) drawable2, (animatedStateListState.mTransitions.get(AnimatedStateListState.generateTransitionKey(keyframeIdAt, keyframeIdAt2), -1L).longValue() & 4294967296L) != 0, z3);
                    } else if (drawable2 instanceof AnimatedVectorDrawableCompat) {
                        transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) drawable2);
                    } else if (drawable2 instanceof Animatable) {
                        transition = new AnimatableTransition((Animatable) drawable2);
                    }
                    transition.start();
                    this.mTransition = transition;
                    this.mTransitionFromIndex = i;
                    this.mTransitionToIndex = indexOfKeyframe;
                    z = true;
                    if (!z) {
                    }
                    Drawable drawable3 = this.mCurrDrawable;
                    if (drawable3 == null) {
                    }
                }
            }
            z = false;
            if (!z) {
            }
            Drawable drawable32 = this.mCurrDrawable;
            if (drawable32 == null) {
            }
        }
        z2 = false;
        Drawable drawable322 = this.mCurrDrawable;
        if (drawable322 == null) {
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, androidx.appcompat.graphics.drawable.StateListDrawable
    public void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.mState = (AnimatedStateListState) drawableContainerState;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.mTransition != null && (visible || z2)) {
            if (z) {
                this.mTransition.start();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        AnimatedStateListState animatedStateListState2 = new AnimatedStateListState(animatedStateListState, this, resources);
        super.setConstantState(animatedStateListState2);
        this.mState = animatedStateListState2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.StateListDrawable
    /* renamed from: cloneConstantState  reason: collision with other method in class */
    public StateListDrawable.StateListState m0cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }
}
