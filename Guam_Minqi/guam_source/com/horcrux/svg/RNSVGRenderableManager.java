package com.horcrux.svg;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Region;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.uimanager.BaseViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RNSVGRenderableManager extends ReactContextBaseJavaModule {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int EOF = -1;

    public RNSVGRenderableManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getBBox(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        boolean z = readableMap.getBoolean("fill");
        boolean z2 = readableMap.getBoolean("stroke");
        boolean z3 = readableMap.getBoolean("markers");
        boolean z4 = readableMap.getBoolean("clipped");
        try {
            renderableViewByTag.getPath(null, null);
            float f = renderableViewByTag.mScale;
            renderableViewByTag.initBounds();
            RectF rectF = new RectF();
            RectF rectF2 = renderableViewByTag.mFillBounds;
            RectF rectF3 = renderableViewByTag.mStrokeBounds;
            RectF rectF4 = renderableViewByTag.mMarkerBounds;
            RectF rectF5 = renderableViewByTag.mClipBounds;
            if (z && rectF2 != null) {
                rectF.union(rectF2);
            }
            if (z2 && rectF3 != null) {
                rectF.union(rectF3);
            }
            if (z3 && rectF4 != null) {
                rectF.union(rectF4);
            }
            if (z4 && rectF5 != null) {
                rectF.intersect(rectF5);
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", (double) (rectF.left / f));
            createMap.putDouble("y", (double) (rectF.top / f));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, (double) (rectF.width() / f));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, (double) (rectF.height() / f));
            return createMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getCTM(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        float f = renderableViewByTag.mScale;
        Matrix matrix = new Matrix(renderableViewByTag.mCTM);
        matrix.preConcat(renderableViewByTag.getSvgView().mInvViewBoxMatrix);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("a", (double) fArr[0]);
        createMap.putDouble("b", (double) fArr[3]);
        createMap.putDouble("c", (double) fArr[1]);
        createMap.putDouble("d", (double) fArr[4]);
        createMap.putDouble("e", (double) (fArr[2] / f));
        createMap.putDouble("f", (double) (fArr[5] / f));
        return createMap;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSVGRenderableManager";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getPointAtLength(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        try {
            PathMeasure pathMeasure = new PathMeasure(renderableViewByTag.getPath(null, null), false);
            float f = (float) readableMap.getDouble("length");
            float f2 = renderableViewByTag.mScale;
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            pathMeasure.getPosTan(Math.max((float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, Math.min(f, pathMeasure.getLength())), fArr, fArr2);
            double atan2 = Math.atan2((double) fArr2[1], (double) fArr2[0]);
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", (double) (fArr[0] / f2));
            createMap.putDouble("y", (double) (fArr[1] / f2));
            createMap.putDouble("angle", atan2);
            return createMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @ReactMethod
    public void getRawResource(String str, Promise promise) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Resources resources = reactApplicationContext.getResources();
            InputStream openRawResource = resources.openRawResource(resources.getIdentifier(str, "raw", reactApplicationContext.getPackageName()));
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(openRawResource, StandardCharsets.UTF_8);
                char[] cArr = new char[4096];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = inputStreamReader.read(cArr, 0, 4096);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        promise.resolve(sb.toString());
                        try {
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                }
            } finally {
                try {
                    openRawResource.close();
                } catch (IOException unused2) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getScreenCTM(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        float[] fArr = new float[9];
        renderableViewByTag.mCTM.getValues(fArr);
        float f = renderableViewByTag.mScale;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("a", (double) fArr[0]);
        createMap.putDouble("b", (double) fArr[3]);
        createMap.putDouble("c", (double) fArr[1]);
        createMap.putDouble("d", (double) fArr[4]);
        createMap.putDouble("e", (double) (fArr[2] / f));
        createMap.putDouble("f", (double) (fArr[5] / f));
        return createMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public float getTotalLength(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }
        try {
            return new PathMeasure(renderableViewByTag.getPath(null, null), false).getLength() / renderableViewByTag.mScale;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return -1.0f;
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInFill(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return false;
        }
        float f = renderableViewByTag.mScale;
        if (renderableViewByTag.hitTest(new float[]{((float) readableMap.getDouble("x")) * f, ((float) readableMap.getDouble("y")) * f}) != -1) {
            return true;
        }
        return false;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInStroke(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return false;
        }
        try {
            renderableViewByTag.getPath(null, null);
            renderableViewByTag.initBounds();
            double d = (double) renderableViewByTag.mScale;
            int i2 = (int) (readableMap.getDouble("x") * d);
            int i3 = (int) (readableMap.getDouble("y") * d);
            Region region = renderableViewByTag.mStrokeRegion;
            if (region == null || !region.contains(i2, i3)) {
                return false;
            }
            return true;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return false;
        }
    }
}
