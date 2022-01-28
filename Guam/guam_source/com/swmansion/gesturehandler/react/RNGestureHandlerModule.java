package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.gesturehandler.FlingGestureHandler;
import com.swmansion.gesturehandler.GestureHandler;
import com.swmansion.gesturehandler.LongPressGestureHandler;
import com.swmansion.gesturehandler.NativeViewGestureHandler;
import com.swmansion.gesturehandler.OnTouchEventListener;
import com.swmansion.gesturehandler.PanGestureHandler;
import com.swmansion.gesturehandler.PinchGestureHandler;
import com.swmansion.gesturehandler.RotationGestureDetector;
import com.swmansion.gesturehandler.RotationGestureHandler;
import com.swmansion.gesturehandler.TapGestureHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RNGestureHandlerModule extends ReactContextBaseJavaModule {
    public static final String KEY_DIRECTION;
    public static final String KEY_ENABLED;
    public static final String KEY_HIT_SLOP;
    public static final String KEY_HIT_SLOP_BOTTOM;
    public static final String KEY_HIT_SLOP_HEIGHT;
    public static final String KEY_HIT_SLOP_HORIZONTAL;
    public static final String KEY_HIT_SLOP_LEFT;
    public static final String KEY_HIT_SLOP_RIGHT;
    public static final String KEY_HIT_SLOP_TOP;
    public static final String KEY_HIT_SLOP_VERTICAL;
    public static final String KEY_HIT_SLOP_WIDTH;
    public static final String KEY_LONG_PRESS_MAX_DIST;
    public static final String KEY_LONG_PRESS_MIN_DURATION_MS;
    public static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION;
    public static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START;
    public static final String KEY_NUMBER_OF_POINTERS;
    public static final String KEY_PAN_ACTIVE_OFFSET_X_END;
    public static final String KEY_PAN_ACTIVE_OFFSET_X_START;
    public static final String KEY_PAN_ACTIVE_OFFSET_Y_END;
    public static final String KEY_PAN_ACTIVE_OFFSET_Y_START;
    public static final String KEY_PAN_AVG_TOUCHES;
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END;
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START;
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END;
    public static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START;
    public static final String KEY_PAN_MAX_POINTERS;
    public static final String KEY_PAN_MIN_DIST;
    public static final String KEY_PAN_MIN_POINTERS;
    public static final String KEY_PAN_MIN_VELOCITY;
    public static final String KEY_PAN_MIN_VELOCITY_X;
    public static final String KEY_PAN_MIN_VELOCITY_Y;
    public static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE;
    public static final String KEY_TAP_MAX_DELAY_MS;
    public static final String KEY_TAP_MAX_DELTA_X;
    public static final String KEY_TAP_MAX_DELTA_Y;
    public static final String KEY_TAP_MAX_DIST;
    public static final String KEY_TAP_MAX_DURATION_MS;
    public static final String KEY_TAP_MIN_POINTERS;
    public static final String KEY_TAP_NUMBER_OF_TAPS;
    public static final String MODULE_NAME;
    public List<Integer> mEnqueuedRootViewInit = new ArrayList();
    public OnTouchEventListener mEventListener = new OnTouchEventListener() {
        /* class com.swmansion.gesturehandler.react.RNGestureHandlerModule.AnonymousClass1 */
    };
    public HandlerFactory[] mHandlerFactories = {new NativeViewGestureHandlerFactory(null), new TapGestureHandlerFactory(null), new LongPressGestureHandlerFactory(null), new PanGestureHandlerFactory(null), new PinchGestureHandlerFactory(null), new RotationGestureHandlerFactory(null), new FlingGestureHandlerFactory(null)};
    public RNGestureHandlerInteractionManager mInteractionManager = new RNGestureHandlerInteractionManager();
    public final RNGestureHandlerRegistry mRegistry = new RNGestureHandlerRegistry();
    public List<RNGestureHandlerRootHelper> mRoots = new ArrayList();

    public static class FlingGestureHandlerFactory extends HandlerFactory<FlingGestureHandler> {
        public FlingGestureHandlerFactory(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(FlingGestureHandler flingGestureHandler, ReadableMap readableMap) {
            FlingGestureHandler flingGestureHandler2 = flingGestureHandler;
            super.configure(flingGestureHandler2, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                flingGestureHandler2.mNumberOfPointersRequired = readableMap.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                flingGestureHandler2.mDirection = readableMap.getInt(RNGestureHandlerModule.KEY_DIRECTION);
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public FlingGestureHandler create(Context context) {
            return new FlingGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerEventDataExtractor
        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            FlingGestureHandler flingGestureHandler = (FlingGestureHandler) gestureHandler;
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) flingGestureHandler.mNumberOfPointers);
            writableMap.putDouble("x", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(flingGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(flingGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(flingGestureHandler.mLastX));
            writableMap.putDouble("absoluteY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(flingGestureHandler.mLastY));
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return "FlingGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<FlingGestureHandler> getType() {
            return FlingGestureHandler.class;
        }
    }

    public static abstract class HandlerFactory<T extends GestureHandler> implements RNGestureHandlerEventDataExtractor<T> {
        public HandlerFactory(AnonymousClass1 r1) {
        }

        public void configure(T t, ReadableMap readableMap) {
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                t.mShouldCancelWhenOutside = readableMap.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_ENABLED)) {
                boolean z = readableMap.getBoolean(RNGestureHandlerModule.KEY_ENABLED);
                if (t.mView != null) {
                    t.cancel();
                }
                t.mEnabled = z;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                RNGestureHandlerModule.handleHitSlopProperty(t, readableMap);
            }
        }

        public abstract T create(Context context);

        public abstract String getName();

        public abstract Class<T> getType();
    }

    public static class LongPressGestureHandlerFactory extends HandlerFactory<LongPressGestureHandler> {
        public LongPressGestureHandlerFactory(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(LongPressGestureHandler longPressGestureHandler, ReadableMap readableMap) {
            LongPressGestureHandler longPressGestureHandler2 = longPressGestureHandler;
            super.configure(longPressGestureHandler2, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                longPressGestureHandler2.mMinDurationMs = (long) readableMap.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS);
            }
            if (readableMap.hasKey("maxDist")) {
                float pixelFromDIP = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble("maxDist"));
                longPressGestureHandler2.mMaxDistSq = pixelFromDIP * pixelFromDIP;
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public LongPressGestureHandler create(Context context) {
            return new LongPressGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerEventDataExtractor
        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            LongPressGestureHandler longPressGestureHandler = (LongPressGestureHandler) gestureHandler;
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) longPressGestureHandler.mNumberOfPointers);
            writableMap.putDouble("x", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(longPressGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(longPressGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(longPressGestureHandler.mLastX));
            writableMap.putDouble("absoluteY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(longPressGestureHandler.mLastY));
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return "LongPressGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<LongPressGestureHandler> getType() {
            return LongPressGestureHandler.class;
        }
    }

    public static class NativeViewGestureHandlerFactory extends HandlerFactory<NativeViewGestureHandler> {
        public NativeViewGestureHandlerFactory(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(NativeViewGestureHandler nativeViewGestureHandler, ReadableMap readableMap) {
            NativeViewGestureHandler nativeViewGestureHandler2 = nativeViewGestureHandler;
            super.configure(nativeViewGestureHandler2, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                nativeViewGestureHandler2.mShouldActivateOnStart = readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                nativeViewGestureHandler2.mDisallowInterruption = readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION);
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public NativeViewGestureHandler create(Context context) {
            return new NativeViewGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerEventDataExtractor
        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) gestureHandler;
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) nativeViewGestureHandler.mNumberOfPointers);
            writableMap.putBoolean("pointerInside", nativeViewGestureHandler.mWithinBounds);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return "NativeViewGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<NativeViewGestureHandler> getType() {
            return NativeViewGestureHandler.class;
        }
    }

    public static class PanGestureHandlerFactory extends HandlerFactory<PanGestureHandler> {
        public PanGestureHandlerFactory(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(PanGestureHandler panGestureHandler, ReadableMap readableMap) {
            boolean z;
            PanGestureHandler panGestureHandler2 = panGestureHandler;
            super.configure(panGestureHandler2, readableMap);
            boolean z2 = true;
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                panGestureHandler2.mActiveOffsetXStart = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START));
                z = true;
            } else {
                z = false;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                panGestureHandler2.mActiveOffsetXEnd = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                panGestureHandler2.mFailOffsetXStart = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                panGestureHandler2.mFailOffsetXEnd = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                panGestureHandler2.mActiveOffsetYStart = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                panGestureHandler2.mActiveOffsetYEnd = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                panGestureHandler2.mFailOffsetYStart = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                panGestureHandler2.mFailOffsetYEnd = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                float pixelFromDIP = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY));
                panGestureHandler2.mMinVelocitySq = pixelFromDIP * pixelFromDIP;
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                panGestureHandler2.mMinVelocityX = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                panGestureHandler2.mMinVelocityY = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y));
            } else {
                z2 = z;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                float pixelFromDIP2 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST));
                panGestureHandler2.mMinDistSq = pixelFromDIP2 * pixelFromDIP2;
            } else if (z2) {
                panGestureHandler2.mMinDistSq = Float.POSITIVE_INFINITY;
            }
            if (readableMap.hasKey("minPointers")) {
                panGestureHandler2.mMinPointers = readableMap.getInt("minPointers");
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                panGestureHandler2.mMaxPointers = readableMap.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                panGestureHandler2.mAverageTouches = readableMap.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES);
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public PanGestureHandler create(Context context) {
            return new PanGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerEventDataExtractor
        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            PanGestureHandler panGestureHandler = (PanGestureHandler) gestureHandler;
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) panGestureHandler.mNumberOfPointers);
            writableMap.putDouble("x", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(panGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(panGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(((GestureHandler) panGestureHandler).mLastX));
            writableMap.putDouble("absoluteY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(((GestureHandler) panGestureHandler).mLastY));
            writableMap.putDouble("translationX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((panGestureHandler.mLastX - panGestureHandler.mStartX) + panGestureHandler.mOffsetX));
            writableMap.putDouble("translationY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((panGestureHandler.mLastY - panGestureHandler.mStartY) + panGestureHandler.mOffsetY));
            writableMap.putDouble("velocityX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(panGestureHandler.mLastVelocityX));
            writableMap.putDouble("velocityY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(panGestureHandler.mLastVelocityY));
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return "PanGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<PanGestureHandler> getType() {
            return PanGestureHandler.class;
        }
    }

    public static class PinchGestureHandlerFactory extends HandlerFactory<PinchGestureHandler> {
        public PinchGestureHandlerFactory(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public PinchGestureHandler create(Context context) {
            return new PinchGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerEventDataExtractor
        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            float f;
            PinchGestureHandler pinchGestureHandler = (PinchGestureHandler) gestureHandler;
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) pinchGestureHandler.mNumberOfPointers);
            writableMap.putDouble("scale", pinchGestureHandler.mLastScaleFactor);
            ScaleGestureDetector scaleGestureDetector = pinchGestureHandler.mScaleGestureDetector;
            float f2 = Float.NaN;
            if (scaleGestureDetector == null) {
                f = Float.NaN;
            } else {
                f = scaleGestureDetector.getFocusX();
            }
            writableMap.putDouble("focalX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(f));
            ScaleGestureDetector scaleGestureDetector2 = pinchGestureHandler.mScaleGestureDetector;
            if (scaleGestureDetector2 != null) {
                f2 = scaleGestureDetector2.getFocusY();
            }
            writableMap.putDouble("focalY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(f2));
            writableMap.putDouble("velocity", pinchGestureHandler.mLastVelocity);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return "PinchGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<PinchGestureHandler> getType() {
            return PinchGestureHandler.class;
        }
    }

    public static class RotationGestureHandlerFactory extends HandlerFactory<RotationGestureHandler> {
        public RotationGestureHandlerFactory(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public RotationGestureHandler create(Context context) {
            return new RotationGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerEventDataExtractor
        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            float f;
            RotationGestureHandler rotationGestureHandler = (RotationGestureHandler) gestureHandler;
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) rotationGestureHandler.mNumberOfPointers);
            writableMap.putDouble("rotation", rotationGestureHandler.mLastRotation);
            RotationGestureDetector rotationGestureDetector = rotationGestureHandler.mRotationGestureDetector;
            float f2 = Float.NaN;
            if (rotationGestureDetector == null) {
                f = Float.NaN;
            } else {
                f = rotationGestureDetector.mAnchorX;
            }
            writableMap.putDouble("anchorX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(f));
            RotationGestureDetector rotationGestureDetector2 = rotationGestureHandler.mRotationGestureDetector;
            if (rotationGestureDetector2 != null) {
                f2 = rotationGestureDetector2.mAnchorY;
            }
            writableMap.putDouble("anchorY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(f2));
            writableMap.putDouble("velocity", rotationGestureHandler.mLastVelocity);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return "RotationGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<RotationGestureHandler> getType() {
            return RotationGestureHandler.class;
        }
    }

    public static class TapGestureHandlerFactory extends HandlerFactory<TapGestureHandler> {
        public TapGestureHandlerFactory(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(TapGestureHandler tapGestureHandler, ReadableMap readableMap) {
            TapGestureHandler tapGestureHandler2 = tapGestureHandler;
            super.configure(tapGestureHandler2, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                tapGestureHandler2.mNumberOfTaps = readableMap.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                tapGestureHandler2.mMaxDurationMs = (long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                tapGestureHandler2.mMaxDelayMs = (long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                tapGestureHandler2.mMaxDeltaX = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                tapGestureHandler2.mMaxDeltaY = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y));
            }
            if (readableMap.hasKey("maxDist")) {
                float pixelFromDIP = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble("maxDist"));
                tapGestureHandler2.mMaxDistSq = pixelFromDIP * pixelFromDIP;
            }
            if (readableMap.hasKey("minPointers")) {
                tapGestureHandler2.mMinNumberOfPointers = readableMap.getInt("minPointers");
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public TapGestureHandler create(Context context) {
            return new TapGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerEventDataExtractor
        public void extractEventData(GestureHandler gestureHandler, WritableMap writableMap) {
            TapGestureHandler tapGestureHandler = (TapGestureHandler) gestureHandler;
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) ((GestureHandler) tapGestureHandler).mNumberOfPointers);
            writableMap.putDouble("x", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(tapGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(tapGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(((GestureHandler) tapGestureHandler).mLastX));
            writableMap.putDouble("absoluteY", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(((GestureHandler) tapGestureHandler).mLastY));
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return "TapGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<TapGestureHandler> getType() {
            return TapGestureHandler.class;
        }
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private HandlerFactory findFactoryForHandler(GestureHandler gestureHandler) {
        int i = 0;
        while (true) {
            HandlerFactory[] handlerFactoryArr = this.mHandlerFactories;
            if (i >= handlerFactoryArr.length) {
                return null;
            }
            HandlerFactory handlerFactory = handlerFactoryArr[i];
            if (handlerFactory.getType().equals(gestureHandler.getClass())) {
                return handlerFactory;
            }
            i++;
        }
    }

    private RNGestureHandlerRootHelper findRootHelperForViewAncestor(int i) {
        int resolveRootTagFromReactTag = ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).resolveRootTagFromReactTag(i);
        if (resolveRootTagFromReactTag < 1) {
            return null;
        }
        synchronized (this.mRoots) {
            for (int i2 = 0; i2 < this.mRoots.size(); i2++) {
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.mRoots.get(i2);
                ViewGroup viewGroup = rNGestureHandlerRootHelper.mRootView;
                if ((viewGroup instanceof ReactRootView) && ((ReactRootView) viewGroup).getRootViewTag() == resolveRootTagFromReactTag) {
                    return rNGestureHandlerRootHelper;
                }
            }
            return null;
        }
    }

    public static void handleHitSlopProperty(GestureHandler gestureHandler, ReadableMap readableMap) {
        if (readableMap.getType(KEY_HIT_SLOP) == ReadableType.Number) {
            float pixelFromDIP = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(KEY_HIT_SLOP));
            gestureHandler.setHitSlop(pixelFromDIP, pixelFromDIP, pixelFromDIP, pixelFromDIP, Float.NaN, Float.NaN);
            return;
        }
        ReadableMap map = readableMap.getMap(KEY_HIT_SLOP);
        float f = Float.NaN;
        float pixelFromDIP2 = map.hasKey(KEY_HIT_SLOP_HORIZONTAL) ? AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_HORIZONTAL)) : Float.NaN;
        float f2 = pixelFromDIP2;
        float pixelFromDIP3 = map.hasKey(KEY_HIT_SLOP_VERTICAL) ? AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_VERTICAL)) : Float.NaN;
        float f3 = pixelFromDIP3;
        if (map.hasKey(KEY_HIT_SLOP_LEFT)) {
            pixelFromDIP2 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_LEFT));
        }
        if (map.hasKey(KEY_HIT_SLOP_TOP)) {
            pixelFromDIP3 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_TOP));
        }
        if (map.hasKey(KEY_HIT_SLOP_RIGHT)) {
            f2 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_RIGHT));
        }
        if (map.hasKey(KEY_HIT_SLOP_BOTTOM)) {
            f3 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_BOTTOM));
        }
        float pixelFromDIP4 = map.hasKey(KEY_HIT_SLOP_WIDTH) ? AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_WIDTH)) : Float.NaN;
        if (map.hasKey(KEY_HIT_SLOP_HEIGHT)) {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(map.getDouble(KEY_HIT_SLOP_HEIGHT));
        }
        gestureHandler.setHitSlop(pixelFromDIP2, pixelFromDIP3, f2, f3, pixelFromDIP4, f);
    }

    /* access modifiers changed from: public */
    private void onStateChange(GestureHandler gestureHandler, int i, int i2) {
        if (gestureHandler.mTag >= 0) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(RNGestureHandlerStateChangeEvent.obtain(gestureHandler, i, i2, findFactoryForHandler(gestureHandler)));
        }
    }

    /* access modifiers changed from: public */
    private void onTouchEvent(GestureHandler gestureHandler, MotionEvent motionEvent) {
        if (gestureHandler.mTag >= 0 && gestureHandler.mState == 4) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(RNGestureHandlerEvent.obtain(gestureHandler, findFactoryForHandler(gestureHandler)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r6 = r5.mEnqueuedRootViewInit;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r5.mEnqueuedRootViewInit.contains(java.lang.Integer.valueOf(r1)) == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        r5.mEnqueuedRootViewInit.add(java.lang.Integer.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r0.addUIBlock(new com.swmansion.gesturehandler.react.RNGestureHandlerModule.AnonymousClass2());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
        return;
     */
    private void tryInitializeHandlerForReactRootView(int i) {
        UIManagerModule uIManagerModule = (UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class);
        final int resolveRootTagFromReactTag = uIManagerModule.resolveRootTagFromReactTag(i);
        if (resolveRootTagFromReactTag >= 1) {
            synchronized (this.mRoots) {
                for (int i2 = 0; i2 < this.mRoots.size(); i2++) {
                    ViewGroup viewGroup = this.mRoots.get(i2).mRootView;
                    if ((viewGroup instanceof ReactRootView) && ((ReactRootView) viewGroup).getRootViewTag() == resolveRootTagFromReactTag) {
                        return;
                    }
                }
            }
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline4("Could find root view for a given ancestor with tag ", i));
        }
    }

    public void attachGestureHandler(int i, int i2) {
        tryInitializeHandlerForReactRootView(i2);
        if (!this.mRegistry.attachHandlerToView(i, i2)) {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline5("Handler with tag ", i, " does not exists"));
        }
    }

    public void createGestureHandler(String str, int i, ReadableMap readableMap) {
        int i2 = 0;
        while (true) {
            HandlerFactory[] handlerFactoryArr = this.mHandlerFactories;
            if (i2 < handlerFactoryArr.length) {
                HandlerFactory handlerFactory = handlerFactoryArr[i2];
                if (handlerFactory.getName().equals(str)) {
                    GestureHandler create = handlerFactory.create(getReactApplicationContext());
                    create.mTag = i;
                    create.mListener = this.mEventListener;
                    RNGestureHandlerRegistry rNGestureHandlerRegistry = this.mRegistry;
                    synchronized (rNGestureHandlerRegistry) {
                        rNGestureHandlerRegistry.mHandlers.put(create.mTag, create);
                    }
                    this.mInteractionManager.configureInteractions(create, readableMap);
                    handlerFactory.configure(create, readableMap);
                    return;
                }
                i2++;
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid handler name ", str));
            }
        }
    }

    public void dropGestureHandler(int i) {
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.mInteractionManager;
        rNGestureHandlerInteractionManager.mWaitForRelations.remove(i);
        rNGestureHandlerInteractionManager.mSimultaneousRelations.remove(i);
        this.mRegistry.dropHandler(i);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("UNDETERMINED", 0);
        hashMap.put("BEGAN", 2);
        hashMap.put("ACTIVE", 4);
        hashMap.put("CANCELLED", 3);
        hashMap.put("FAILED", 1);
        hashMap.put("END", 5);
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("State", hashMap, "Direction", AppCompatDelegateImpl.ConfigurationImplApi17.of("RIGHT", 1, "LEFT", 2, "UP", 4, "DOWN", 8));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    public RNGestureHandlerRegistry getRegistry() {
        return this.mRegistry;
    }

    public void handleClearJSResponder() {
    }

    public void handleSetJSResponder(int i, boolean z) {
        RNGestureHandlerRootHelper findRootHelperForViewAncestor;
        if (this.mRegistry != null && (findRootHelperForViewAncestor = findRootHelperForViewAncestor(i)) != null && z) {
            UiThreadUtil.runOnUiThread(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  
                  (wrap: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper$1 : 0x000e: CONSTRUCTOR  (r3v1 com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper$1) = (r2v1 'findRootHelperForViewAncestor' com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper) call: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper.1.<init>(com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper):void type: CONSTRUCTOR)
                 type: STATIC call: com.facebook.react.bridge.UiThreadUtil.runOnUiThread(java.lang.Runnable):void in method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.handleSetJSResponder(int, boolean):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r3v1 com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper$1) = (r2v1 'findRootHelperForViewAncestor' com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper) call: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper.1.<init>(com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper):void type: CONSTRUCTOR in method: com.swmansion.gesturehandler.react.RNGestureHandlerModule.handleSetJSResponder(int, boolean):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
                this = this;
                com.swmansion.gesturehandler.react.RNGestureHandlerRegistry r0 = r1.mRegistry
                if (r0 == 0) goto L_0x0014
                com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper r2 = r1.findRootHelperForViewAncestor(r2)
                if (r2 == 0) goto L_0x0014
                if (r3 == 0) goto L_0x0014
                com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper$1 r3 = new com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper$1
                r3.<init>()
                com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r3)
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerModule.handleSetJSResponder(int, boolean):void");
        }

        @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
        public void onCatalystInstanceDestroy() {
            RNGestureHandlerRegistry rNGestureHandlerRegistry = this.mRegistry;
            synchronized (rNGestureHandlerRegistry) {
                rNGestureHandlerRegistry.mHandlers.clear();
                rNGestureHandlerRegistry.mAttachedTo.clear();
                rNGestureHandlerRegistry.mHandlersForView.clear();
            }
            RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.mInteractionManager;
            rNGestureHandlerInteractionManager.mWaitForRelations.clear();
            rNGestureHandlerInteractionManager.mSimultaneousRelations.clear();
            synchronized (this.mRoots) {
                while (!this.mRoots.isEmpty()) {
                    int size = this.mRoots.size();
                    RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.mRoots.get(0);
                    ViewGroup viewGroup = rNGestureHandlerRootHelper.mRootView;
                    if (viewGroup instanceof RNGestureHandlerEnabledRootView) {
                        RNGestureHandlerEnabledRootView rNGestureHandlerEnabledRootView = (RNGestureHandlerEnabledRootView) viewGroup;
                        RNGestureHandlerRootHelper rNGestureHandlerRootHelper2 = rNGestureHandlerEnabledRootView.mGestureRootHelper;
                        if (rNGestureHandlerRootHelper2 != null) {
                            rNGestureHandlerRootHelper2.tearDown();
                            rNGestureHandlerEnabledRootView.mGestureRootHelper = null;
                        }
                    } else {
                        rNGestureHandlerRootHelper.tearDown();
                    }
                    if (this.mRoots.size() >= size) {
                        throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                    }
                }
            }
            super.onCatalystInstanceDestroy();
        }

        public void registerRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
            synchronized (this.mRoots) {
                if (!this.mRoots.contains(rNGestureHandlerRootHelper)) {
                    this.mRoots.add(rNGestureHandlerRootHelper);
                } else {
                    throw new IllegalStateException("Root helper" + rNGestureHandlerRootHelper + " already registered");
                }
            }
        }

        public void unregisterRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
            synchronized (this.mRoots) {
                this.mRoots.remove(rNGestureHandlerRootHelper);
            }
        }

        public void updateGestureHandler(int i, ReadableMap readableMap) {
            GestureHandler gestureHandler;
            HandlerFactory findFactoryForHandler;
            RNGestureHandlerRegistry rNGestureHandlerRegistry = this.mRegistry;
            synchronized (rNGestureHandlerRegistry) {
                gestureHandler = rNGestureHandlerRegistry.mHandlers.get(i);
            }
            if (gestureHandler != null && (findFactoryForHandler = findFactoryForHandler(gestureHandler)) != null) {
                RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager = this.mInteractionManager;
                rNGestureHandlerInteractionManager.mWaitForRelations.remove(i);
                rNGestureHandlerInteractionManager.mSimultaneousRelations.remove(i);
                this.mInteractionManager.configureInteractions(gestureHandler, readableMap);
                findFactoryForHandler.configure(gestureHandler, readableMap);
            }
        }
    }
