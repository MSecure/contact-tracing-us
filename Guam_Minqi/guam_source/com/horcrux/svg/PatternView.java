package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.Brush;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

@SuppressLint({"ViewConstructor"})
public class PatternView extends GroupView {
    public static final float[] sRawMatrix = {1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f};
    public String mAlign;
    public SVGLength mH;
    public Matrix mMatrix = null;
    public int mMeetOrSlice;
    public float mMinX;
    public float mMinY;
    public Brush.BrushUnits mPatternContentUnits;
    public Brush.BrushUnits mPatternUnits;
    public float mVbHeight;
    public float mVbWidth;
    public SVGLength mW;
    public SVGLength mX;
    public SVGLength mY;

    public PatternView(ReactContext reactContext) {
        super(reactContext);
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.GroupView
    public void saveDefinition() {
        if (this.mName != null) {
            boolean z = false;
            Brush brush = new Brush(Brush.BrushType.PATTERN, new SVGLength[]{this.mX, this.mY, this.mW, this.mH}, this.mPatternUnits);
            if (this.mPatternContentUnits == Brush.BrushUnits.OBJECT_BOUNDING_BOX) {
                z = true;
            }
            brush.mUseContentObjectBoundingBoxUnits = z;
            brush.mPattern = this;
            Matrix matrix = this.mMatrix;
            if (matrix != null) {
                brush.mMatrix = matrix;
            }
            SvgView svgView = getSvgView();
            Brush.BrushUnits brushUnits = this.mPatternUnits;
            Brush.BrushUnits brushUnits2 = Brush.BrushUnits.USER_SPACE_ON_USE;
            if (brushUnits == brushUnits2 || this.mPatternContentUnits == brushUnits2) {
                brush.mUserSpaceBoundingBox = svgView.getCanvasBounds();
            }
            svgView.defineBrush(brush, this.mName);
        }
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)
    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    @ReactProp(name = "minX")
    public void setMinX(float f) {
        this.mMinX = f;
        invalidate();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f) {
        this.mMinY = f;
        invalidate();
    }

    @ReactProp(name = "patternContentUnits")
    public void setPatternContentUnits(int i) {
        if (i == 0) {
            this.mPatternContentUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mPatternContentUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "patternTransform")
    public void setPatternTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int matrixData = PathParser.toMatrixData(readableArray, sRawMatrix, this.mScale);
            if (matrixData == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                }
                this.mMatrix.setValues(sRawMatrix);
            } else if (matrixData != -1) {
                FLog.w("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.mMatrix = null;
        }
        invalidate();
    }

    @ReactProp(name = "patternUnits")
    public void setPatternUnits(int i) {
        if (i == 0) {
            this.mPatternUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mPatternUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f) {
        this.mVbHeight = f;
        invalidate();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f) {
        this.mVbWidth = f;
        invalidate();
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH)
    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.from(dynamic);
        invalidate();
    }
}
