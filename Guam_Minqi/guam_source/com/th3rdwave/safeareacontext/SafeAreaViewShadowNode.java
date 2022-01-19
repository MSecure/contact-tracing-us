package com.th3rdwave.safeareacontext;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.EnumSet;

public class SafeAreaViewShadowNode extends LayoutShadowNode {
    public SafeAreaViewLocalData mLocalData;
    public float[] mMargins;
    public boolean mNeedsUpdate = false;
    public float[] mPaddings;

    public SafeAreaViewShadowNode() {
        int[] iArr = ViewProps.PADDING_MARGIN_SPACING_TYPES;
        this.mPaddings = new float[iArr.length];
        this.mMargins = new float[iArr.length];
        for (int i = 0; i < ViewProps.PADDING_MARGIN_SPACING_TYPES.length; i++) {
            this.mPaddings[i] = Float.NaN;
            this.mMargins[i] = Float.NaN;
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.mNeedsUpdate) {
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(Object obj) {
        SafeAreaViewMode safeAreaViewMode;
        if (obj instanceof SafeAreaViewLocalData) {
            SafeAreaViewLocalData safeAreaViewLocalData = (SafeAreaViewLocalData) obj;
            SafeAreaViewLocalData safeAreaViewLocalData2 = this.mLocalData;
            if (!(safeAreaViewLocalData2 == null || (safeAreaViewMode = safeAreaViewLocalData2.mMode) == safeAreaViewLocalData.mMode)) {
                if (safeAreaViewMode == SafeAreaViewMode.PADDING) {
                    super.setPadding(1, this.mPaddings[1]);
                    super.setPadding(2, this.mPaddings[1]);
                    super.setPadding(3, this.mPaddings[3]);
                    super.setPadding(0, this.mPaddings[0]);
                } else {
                    super.setMargin(1, this.mMargins[1]);
                    super.setMargin(2, this.mMargins[1]);
                    super.setMargin(3, this.mMargins[3]);
                    super.setMargin(0, this.mMargins[0]);
                }
            }
            this.mLocalData = safeAreaViewLocalData;
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        this.mMargins[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setMargins(i, dynamic);
        this.mNeedsUpdate = true;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        this.mPaddings[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setPaddings(i, dynamic);
        this.mNeedsUpdate = true;
    }

    public final void updateInsets() {
        float f;
        float f2;
        float f3;
        SafeAreaViewMode safeAreaViewMode = SafeAreaViewMode.PADDING;
        SafeAreaViewLocalData safeAreaViewLocalData = this.mLocalData;
        if (safeAreaViewLocalData != null) {
            float[] fArr = safeAreaViewLocalData.mMode == safeAreaViewMode ? this.mPaddings : this.mMargins;
            float f4 = fArr[8];
            if (!Float.isNaN(f4)) {
                f3 = f4;
                f2 = f3;
                f = f2;
            } else {
                f4 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                f3 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                f2 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            }
            float f5 = fArr[7];
            if (!Float.isNaN(f5)) {
                f4 = f5;
                f2 = f4;
            }
            float f6 = fArr[6];
            if (!Float.isNaN(f6)) {
                f3 = f6;
                f = f3;
            }
            float f7 = fArr[1];
            if (!Float.isNaN(f7)) {
                f4 = f7;
            }
            float f8 = fArr[2];
            if (!Float.isNaN(f8)) {
                f3 = f8;
            }
            float f9 = fArr[3];
            if (!Float.isNaN(f9)) {
                f2 = f9;
            }
            float f10 = fArr[0];
            if (!Float.isNaN(f10)) {
                f = f10;
            }
            float pixelFromDIP = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f4);
            float pixelFromDIP2 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f3);
            float pixelFromDIP3 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f2);
            float pixelFromDIP4 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f);
            SafeAreaViewLocalData safeAreaViewLocalData2 = this.mLocalData;
            EnumSet<SafeAreaViewEdges> enumSet = safeAreaViewLocalData2.mEdges;
            EdgeInsets edgeInsets = safeAreaViewLocalData2.mInsets;
            float f11 = enumSet.contains(SafeAreaViewEdges.TOP) ? edgeInsets.top : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            float f12 = enumSet.contains(SafeAreaViewEdges.RIGHT) ? edgeInsets.right : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            float f13 = enumSet.contains(SafeAreaViewEdges.BOTTOM) ? edgeInsets.bottom : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            float f14 = enumSet.contains(SafeAreaViewEdges.LEFT) ? edgeInsets.left : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            if (this.mLocalData.mMode == safeAreaViewMode) {
                super.setPadding(1, f11 + pixelFromDIP);
                super.setPadding(2, f12 + pixelFromDIP2);
                super.setPadding(3, f13 + pixelFromDIP3);
                super.setPadding(0, f14 + pixelFromDIP4);
                return;
            }
            super.setMargin(1, f11 + pixelFromDIP);
            super.setMargin(2, f12 + pixelFromDIP2);
            super.setMargin(3, f13 + pixelFromDIP3);
            super.setMargin(0, f14 + pixelFromDIP4);
        }
    }
}
