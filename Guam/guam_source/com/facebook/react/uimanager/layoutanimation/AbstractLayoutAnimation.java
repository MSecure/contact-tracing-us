package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Locale;
import java.util.Map;

public abstract class AbstractLayoutAnimation {
    public static final Map<InterpolatorType, BaseInterpolator> INTERPOLATOR = AppCompatDelegateImpl.ConfigurationImplApi17.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator());
    public AnimatedPropertyType mAnimatedProperty;
    public int mDelayMs;
    public int mDurationMs;
    public Interpolator mInterpolator;

    public final Animation createAnimation(View view, int i, int i2, int i3, int i4) {
        if (!isValid()) {
            return null;
        }
        Animation createAnimationImpl = createAnimationImpl(view, i, i2, i3, i4);
        if (createAnimationImpl != null) {
            createAnimationImpl.setDuration((long) (this.mDurationMs * 1));
            createAnimationImpl.setStartOffset((long) (this.mDelayMs * 1));
            createAnimationImpl.setInterpolator(this.mInterpolator);
        }
        return createAnimationImpl;
    }

    public abstract Animation createAnimationImpl(View view, int i, int i2, int i3, int i4);

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void initializeFromConfig(ReadableMap readableMap, int i) {
        AnimatedPropertyType animatedPropertyType;
        InterpolatorType interpolatorType;
        BaseInterpolator baseInterpolator;
        boolean z;
        InterpolatorType interpolatorType2 = InterpolatorType.SPRING;
        char c = 65535;
        if (readableMap.hasKey("property")) {
            String string = readableMap.getString("property");
            switch (string.hashCode()) {
                case -1267206133:
                    if (string.equals("opacity")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case -908189618:
                    if (string.equals("scaleX")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -908189617:
                    if (string.equals("scaleY")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1910893003:
                    if (string.equals("scaleXY")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                animatedPropertyType = AnimatedPropertyType.OPACITY;
            } else if (z) {
                animatedPropertyType = AnimatedPropertyType.SCALE_X;
            } else if (z) {
                animatedPropertyType = AnimatedPropertyType.SCALE_Y;
            } else if (z) {
                animatedPropertyType = AnimatedPropertyType.SCALE_XY;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Unsupported animated property: ", string));
            }
        } else {
            animatedPropertyType = null;
        }
        this.mAnimatedProperty = animatedPropertyType;
        if (readableMap.hasKey("duration")) {
            i = readableMap.getInt("duration");
        }
        this.mDurationMs = i;
        this.mDelayMs = readableMap.hasKey("delay") ? readableMap.getInt("delay") : 0;
        if (readableMap.hasKey("type")) {
            String string2 = readableMap.getString("type");
            String lowerCase = string2.toLowerCase(Locale.US);
            switch (lowerCase.hashCode()) {
                case -1965056864:
                    if (lowerCase.equals("easeout")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1310315117:
                    if (lowerCase.equals("easein")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1102672091:
                    if (lowerCase.equals("linear")) {
                        c = 0;
                        break;
                    }
                    break;
                case -895679987:
                    if (lowerCase.equals("spring")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1164546989:
                    if (lowerCase.equals("easeineaseout")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                interpolatorType = InterpolatorType.LINEAR;
            } else if (c == 1) {
                interpolatorType = InterpolatorType.EASE_IN;
            } else if (c == 2) {
                interpolatorType = InterpolatorType.EASE_OUT;
            } else if (c == 3) {
                interpolatorType = InterpolatorType.EASE_IN_EASE_OUT;
            } else if (c == 4) {
                interpolatorType = interpolatorType2;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Unsupported interpolation type : ", string2));
            }
            if (interpolatorType.equals(interpolatorType2)) {
                baseInterpolator = new SimpleSpringInterpolator(readableMap.getType("springDamping").equals(ReadableType.Number) ? (float) readableMap.getDouble("springDamping") : 0.5f);
            } else {
                baseInterpolator = INTERPOLATOR.get(interpolatorType);
            }
            if (baseInterpolator != null) {
                this.mInterpolator = baseInterpolator;
                if (!isValid()) {
                    throw new IllegalViewOperationException("Invalid layout animation : " + readableMap);
                }
                return;
            }
            throw new IllegalArgumentException("Missing interpolator for type : " + interpolatorType);
        }
        throw new IllegalArgumentException("Missing interpolation type.");
    }

    public abstract boolean isValid();

    public void reset() {
        this.mAnimatedProperty = null;
        this.mDurationMs = 0;
        this.mDelayMs = 0;
        this.mInterpolator = null;
    }
}
