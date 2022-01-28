package com.facebook.react.uimanager;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.R$string;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> implements BaseViewManagerInterface<T> {
    public static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = ((float) Math.sqrt(5.0d));
    public static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    public static final String STATE_BUSY = "busy";
    public static final String STATE_CHECKED = "checked";
    public static final String STATE_EXPANDED = "expanded";
    public static final String STATE_MIXED = "mixed";
    public static MatrixMathHelper$MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper$MatrixDecompositionContext();
    public static final Map<String, Integer> sStateDescription;
    public static double[] sTransformDecompositionArray = new double[16];

    static {
        HashMap hashMap = new HashMap();
        sStateDescription = hashMap;
        hashMap.put(STATE_BUSY, Integer.valueOf(R$string.state_busy_description));
        sStateDescription.put(STATE_EXPANDED, Integer.valueOf(R$string.state_expanded_description));
        sStateDescription.put("collapsed", Integer.valueOf(R$string.state_collapsed_description));
    }

    private void logUnsupportedPropertyWarning(String str) {
        FLog.w("ReactNative", "%s doesn't support property '%s'", getName(), str);
    }

    public static void resetTransformProperty(View view) {
        view.setTranslationX(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP((float) CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        view.setTranslationY(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP((float) CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        view.setRotation(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setRotationX(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setRotationY(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    }

    public static float sanitizeFloatPropertyValue(float f) {
        if (f >= -3.4028235E38f && f <= Float.MAX_VALUE) {
            return f;
        }
        if (f < -3.4028235E38f || f == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f > Float.MAX_VALUE || f == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f)) {
            return CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }
        throw new IllegalStateException("Invalid float property value: " + f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e3 A[LOOP:2: B:28:0x00e1->B:29:0x00e3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fb A[LOOP:3: B:31:0x00f9->B:32:0x00fb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01e8  */
    public static void setTransformProperty(View view, ReadableArray readableArray) {
        int i;
        double[][] dArr;
        int i2;
        char c;
        MatrixMathHelper$MatrixDecompositionContext matrixMathHelper$MatrixDecompositionContext = sMatrixDecompositionContext;
        MatrixMathHelper$MatrixDecompositionContext.resetArray(matrixMathHelper$MatrixDecompositionContext.perspective);
        MatrixMathHelper$MatrixDecompositionContext.resetArray(matrixMathHelper$MatrixDecompositionContext.scale);
        MatrixMathHelper$MatrixDecompositionContext.resetArray(matrixMathHelper$MatrixDecompositionContext.skew);
        MatrixMathHelper$MatrixDecompositionContext.resetArray(matrixMathHelper$MatrixDecompositionContext.translation);
        MatrixMathHelper$MatrixDecompositionContext.resetArray(matrixMathHelper$MatrixDecompositionContext.rotationDegrees);
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        double[] dArr2 = sTransformDecompositionArray;
        MatrixMathHelper$MatrixDecompositionContext matrixMathHelper$MatrixDecompositionContext2 = sMatrixDecompositionContext;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(dArr2.length == 16);
        double[] dArr3 = matrixMathHelper$MatrixDecompositionContext2.perspective;
        double[] dArr4 = matrixMathHelper$MatrixDecompositionContext2.scale;
        double[] dArr5 = matrixMathHelper$MatrixDecompositionContext2.skew;
        double[] dArr6 = matrixMathHelper$MatrixDecompositionContext2.translation;
        double[] dArr7 = matrixMathHelper$MatrixDecompositionContext2.rotationDegrees;
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.isZero(dArr2[15])) {
            double[][] dArr8 = (double[][]) Array.newInstance(double.class, 4, 4);
            double[] dArr9 = new double[16];
            for (int i3 = 0; i3 < 4; i3++) {
                for (int i4 = 0; i4 < 4; i4++) {
                    int i5 = (i3 * 4) + i4;
                    double d = dArr2[i5] / dArr2[15];
                    dArr8[i3][i4] = d;
                    if (i4 == 3) {
                        d = 0.0d;
                    }
                    dArr9[i5] = d;
                }
            }
            dArr9[15] = 1.0d;
            if (!AppCompatDelegateImpl.ConfigurationImplApi17.isZero(AppCompatDelegateImpl.ConfigurationImplApi17.determinant(dArr9))) {
                if (AppCompatDelegateImpl.ConfigurationImplApi17.isZero(dArr8[0][3])) {
                    c = 1;
                    if (AppCompatDelegateImpl.ConfigurationImplApi17.isZero(dArr8[1][3]) && AppCompatDelegateImpl.ConfigurationImplApi17.isZero(dArr8[2][3])) {
                        dArr3[2] = 0.0d;
                        dArr3[1] = 0.0d;
                        dArr3[0] = 0.0d;
                        dArr3[3] = 1.0d;
                        for (i = 0; i < 3; i++) {
                            dArr6[i] = dArr8[3][i];
                        }
                        dArr = (double[][]) Array.newInstance(double.class, 3, 3);
                        for (i2 = 0; i2 < 3; i2++) {
                            dArr[i2][0] = dArr8[i2][0];
                            dArr[i2][1] = dArr8[i2][1];
                            dArr[i2][2] = dArr8[i2][2];
                        }
                        dArr4[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Length(dArr[0]);
                        dArr[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Normalize(dArr[0], dArr4[0]);
                        dArr5[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], dArr[1]);
                        dArr[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[1], dArr[0], 1.0d, -dArr5[0]);
                        dArr5[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], dArr[1]);
                        dArr[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[1], dArr[0], 1.0d, -dArr5[0]);
                        dArr4[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Length(dArr[1]);
                        dArr[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Normalize(dArr[1], dArr4[1]);
                        dArr5[0] = dArr5[0] / dArr4[1];
                        dArr5[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], dArr[2]);
                        dArr[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[2], dArr[0], 1.0d, -dArr5[1]);
                        dArr5[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[1], dArr[2]);
                        dArr[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[2], dArr[1], 1.0d, -dArr5[2]);
                        dArr4[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Length(dArr[2]);
                        dArr[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Normalize(dArr[2], dArr4[2]);
                        dArr5[1] = dArr5[1] / dArr4[2];
                        dArr5[2] = dArr5[2] / dArr4[2];
                        if (AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], AppCompatDelegateImpl.ConfigurationImplApi17.v3Cross(dArr[1], dArr[2])) < 0.0d) {
                            for (int i6 = 0; i6 < 3; i6++) {
                                dArr4[i6] = dArr4[i6] * -1.0d;
                                double[] dArr10 = dArr[i6];
                                dArr10[0] = dArr10[0] * -1.0d;
                                double[] dArr11 = dArr[i6];
                                dArr11[1] = dArr11[1] * -1.0d;
                                double[] dArr12 = dArr[i6];
                                dArr12[2] = dArr12[2] * -1.0d;
                            }
                        }
                        dArr7[0] = AppCompatDelegateImpl.ConfigurationImplApi17.roundTo3Places((-Math.atan2(dArr[2][1], dArr[2][2])) * 57.29577951308232d);
                        dArr7[1] = AppCompatDelegateImpl.ConfigurationImplApi17.roundTo3Places((-Math.atan2(-dArr[2][0], Math.sqrt((dArr[2][2] * dArr[2][2]) + (dArr[2][1] * dArr[2][1])))) * 57.29577951308232d);
                        dArr7[2] = AppCompatDelegateImpl.ConfigurationImplApi17.roundTo3Places((-Math.atan2(dArr[1][0], dArr[0][0])) * 57.29577951308232d);
                    }
                } else {
                    c = 1;
                }
                double[] dArr13 = new double[4];
                dArr13[0] = dArr8[0][3];
                dArr13[c] = dArr8[c][3];
                dArr13[2] = dArr8[2][3];
                dArr13[3] = dArr8[3][3];
                AppCompatDelegateImpl.ConfigurationImplApi17.multiplyVectorByMatrix(dArr13, AppCompatDelegateImpl.ConfigurationImplApi17.transpose(AppCompatDelegateImpl.ConfigurationImplApi17.inverse(dArr9)), dArr3);
                while (i < 3) {
                }
                dArr = (double[][]) Array.newInstance(double.class, 3, 3);
                while (i2 < 3) {
                }
                dArr4[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Length(dArr[0]);
                dArr[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Normalize(dArr[0], dArr4[0]);
                dArr5[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], dArr[1]);
                dArr[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[1], dArr[0], 1.0d, -dArr5[0]);
                dArr5[0] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], dArr[1]);
                dArr[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[1], dArr[0], 1.0d, -dArr5[0]);
                dArr4[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Length(dArr[1]);
                dArr[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Normalize(dArr[1], dArr4[1]);
                dArr5[0] = dArr5[0] / dArr4[1];
                dArr5[1] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], dArr[2]);
                dArr[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[2], dArr[0], 1.0d, -dArr5[1]);
                dArr5[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[1], dArr[2]);
                dArr[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Combine(dArr[2], dArr[1], 1.0d, -dArr5[2]);
                dArr4[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Length(dArr[2]);
                dArr[2] = AppCompatDelegateImpl.ConfigurationImplApi17.v3Normalize(dArr[2], dArr4[2]);
                dArr5[1] = dArr5[1] / dArr4[2];
                dArr5[2] = dArr5[2] / dArr4[2];
                if (AppCompatDelegateImpl.ConfigurationImplApi17.v3Dot(dArr[0], AppCompatDelegateImpl.ConfigurationImplApi17.v3Cross(dArr[1], dArr[2])) < 0.0d) {
                }
                dArr7[0] = AppCompatDelegateImpl.ConfigurationImplApi17.roundTo3Places((-Math.atan2(dArr[2][1], dArr[2][2])) * 57.29577951308232d);
                dArr7[1] = AppCompatDelegateImpl.ConfigurationImplApi17.roundTo3Places((-Math.atan2(-dArr[2][0], Math.sqrt((dArr[2][2] * dArr[2][2]) + (dArr[2][1] * dArr[2][1])))) * 57.29577951308232d);
                dArr7[2] = AppCompatDelegateImpl.ConfigurationImplApi17.roundTo3Places((-Math.atan2(dArr[1][0], dArr[0][0])) * 57.29577951308232d);
            }
        }
        view.setTranslationX(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.translation[0])));
        view.setTranslationY(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.translation[1])));
        view.setRotation(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.rotationDegrees[2]));
        view.setRotationX(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.rotationDegrees[0]));
        view.setRotationY(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.rotationDegrees[1]));
        view.setScaleX(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.scale[0]));
        view.setScaleY(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.scale[1]));
        double[] dArr14 = sMatrixDecompositionContext.perspective;
        if (dArr14.length > 2) {
            float f = (float) dArr14[2];
            if (f == CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                f = 7.8125E-4f;
            }
            float f2 = -1.0f / f;
            float f3 = AppCompatDelegateImpl.ConfigurationImplApi17.sScreenDisplayMetrics.density;
            view.setCameraDistance(sanitizeFloatPropertyValue(f3 * f3 * f2 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
    }

    private void updateViewAccessibility(T t) {
        ReactAccessibilityDelegate.setDelegate(t);
    }

    private void updateViewContentDescription(T t) {
        Dynamic dynamic;
        String str = (String) t.getTag(R$id.accessibility_label);
        ReadableMap readableMap = (ReadableMap) t.getTag(R$id.accessibility_state);
        String str2 = (String) t.getTag(R$id.accessibility_hint);
        ArrayList arrayList = new ArrayList();
        ReadableMap readableMap2 = (ReadableMap) t.getTag(R$id.accessibility_value);
        if (str != null) {
            arrayList.add(str);
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                Dynamic dynamic2 = readableMap.getDynamic(nextKey);
                if (nextKey.equals(STATE_CHECKED) && dynamic2.getType() == ReadableType.String && dynamic2.asString().equals(STATE_MIXED)) {
                    arrayList.add(t.getContext().getString(R$string.state_mixed_description));
                } else if (nextKey.equals(STATE_BUSY) && dynamic2.getType() == ReadableType.Boolean && dynamic2.asBoolean()) {
                    arrayList.add(t.getContext().getString(R$string.state_busy_description));
                } else if (nextKey.equals(STATE_EXPANDED) && dynamic2.getType() == ReadableType.Boolean) {
                    arrayList.add(t.getContext().getString(dynamic2.asBoolean() ? R$string.state_expanded_description : R$string.state_collapsed_description));
                }
            }
        }
        if (readableMap2 != null && readableMap2.hasKey("text") && (dynamic = readableMap2.getDynamic("text")) != null && dynamic.getType() == ReadableType.String) {
            arrayList.add(dynamic.asString());
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (arrayList.size() > 0) {
            t.setContentDescription(TextUtils.join(", ", arrayList));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = AppCompatDelegateImpl.ConfigurationImplApi17.builder();
        builder.put("topAccessibilityAction", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onAccessibilityAction"));
        return builder.build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(T t) {
        super.onAfterUpdateTransaction(t);
        updateViewAccessibility(t);
    }

    @ReactProp(name = "accessibilityActions")
    public void setAccessibilityActions(T t, ReadableArray readableArray) {
        if (readableArray != null) {
            t.setTag(R$id.accessibility_actions, readableArray);
        }
    }

    @ReactProp(name = "accessibilityHint")
    public void setAccessibilityHint(T t, String str) {
        t.setTag(R$id.accessibility_hint, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(T t, String str) {
        t.setTag(R$id.accessibility_label, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t, String str) {
        if (str == null || str.equals("none")) {
            ViewCompat.setAccessibilityLiveRegion(t, 0);
        } else if (str.equals("polite")) {
            ViewCompat.setAccessibilityLiveRegion(t, 1);
        } else if (str.equals("assertive")) {
            ViewCompat.setAccessibilityLiveRegion(t, 2);
        }
    }

    @ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(T t, String str) {
        if (str != null) {
            int i = R$id.accessibility_role;
            ReactAccessibilityDelegate.AccessibilityRole[] values = ReactAccessibilityDelegate.AccessibilityRole.values();
            for (ReactAccessibilityDelegate.AccessibilityRole accessibilityRole : values) {
                if (accessibilityRole.name().equalsIgnoreCase(str)) {
                    t.setTag(i, accessibilityRole);
                    return;
                }
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid accessibility role value: ", str));
        }
    }

    @ReactProp(name = "accessibilityValue")
    public void setAccessibilityValue(T t, ReadableMap readableMap) {
        if (readableMap != null) {
            t.setTag(R$id.accessibility_value, readableMap);
            if (readableMap.hasKey("text")) {
                updateViewContentDescription(t);
            }
        }
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(T t, int i) {
        t.setBackgroundColor(i);
    }

    public void setBorderBottomLeftRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderBottomLeftRadius");
    }

    public void setBorderBottomRightRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderBottomRightRadius");
    }

    public void setBorderRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderRadius");
    }

    public void setBorderTopLeftRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderTopLeftRadius");
    }

    public void setBorderTopRightRadius(T t, float f) {
        logUnsupportedPropertyWarning("borderTopRightRadius");
    }

    @ReactProp(name = "elevation")
    public void setElevation(T t, float f) {
        ViewCompat.setElevation(t, AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
    }

    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t, String str) {
        if (str == null || str.equals("auto")) {
            ViewCompat.setImportantForAccessibility(t, 0);
        } else if (str.equals("yes")) {
            ViewCompat.setImportantForAccessibility(t, 1);
        } else if (str.equals("no")) {
            ViewCompat.setImportantForAccessibility(t, 2);
        } else if (str.equals("no-hide-descendants")) {
            ViewCompat.setImportantForAccessibility(t, 4);
        }
    }

    @ReactProp(name = "nativeID")
    public void setNativeId(T t, String str) {
        t.setTag(R$id.view_tag_native_id, str);
        ReactFindViewUtil.notifyViewRendered(t);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(T t, float f) {
        t.setAlpha(f);
    }

    @ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t, boolean z) {
        t.setLayerType(z ? 2 : 0, null);
    }

    @ReactProp(name = "rotation")
    @Deprecated
    public void setRotation(T t, float f) {
        t.setRotation(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(T t, float f) {
        t.setScaleX(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(T t, float f) {
        t.setScaleY(f);
    }

    @ReactProp(name = "testID")
    public void setTestId(T t, String str) {
        t.setTag(R$id.react_test_id, str);
        t.setTag(str);
    }

    @ReactProp(name = "transform")
    public void setTransform(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(t);
        } else {
            setTransformProperty(t, readableArray);
        }
    }

    @ReactProp(defaultFloat = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "translateX")
    @Deprecated
    public void setTranslateX(T t, float f) {
        t.setTranslationX(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
    }

    @ReactProp(defaultFloat = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "translateY")
    @Deprecated
    public void setTranslateY(T t, float f) {
        t.setTranslationY(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
    }

    @ReactProp(name = "accessibilityState")
    public void setViewState(T t, ReadableMap readableMap) {
        if (readableMap != null) {
            t.setTag(R$id.accessibility_state, readableMap);
            t.setSelected(false);
            t.setEnabled(true);
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (nextKey.equals(STATE_BUSY) || nextKey.equals(STATE_EXPANDED) || (nextKey.equals(STATE_CHECKED) && readableMap.getType(STATE_CHECKED) == ReadableType.String)) {
                    updateViewContentDescription(t);
                    return;
                } else if (t.isAccessibilityFocused()) {
                    t.sendAccessibilityEvent(1);
                }
            }
        }
    }

    @ReactProp(name = "zIndex")
    public void setZIndex(T t, float f) {
        ViewGroupManager.setViewZIndex(t, Math.round(f));
        ViewParent parent = t.getParent();
        if (parent instanceof ReactZIndexedViewGroup) {
            ((ReactZIndexedViewGroup) parent).updateDrawingOrder();
        }
    }
}
