package com.google.android.material.shape;

import com.facebook.react.uimanager.BaseViewManager;

public class RoundedCornerTreatment extends CornerTreatment {
    public float radius = -1.0f;

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, f3 * f2, 180.0f, 180.0f - f);
        float f4 = f3 * 2.0f * f2;
        shapePath.addArc(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, f4, f4, 180.0f, f);
    }
}
