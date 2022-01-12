package com.google.android.material.shape;

import com.facebook.react.uimanager.BaseViewManager;

public class EdgeTreatment {
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        shapePath.lineTo(f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    }
}
