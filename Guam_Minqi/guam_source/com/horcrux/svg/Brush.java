package com.horcrux.svg;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.SVGLength;

public class Brush {
    public ReadableArray mColors;
    public Matrix mMatrix;
    public PatternView mPattern;
    public final SVGLength[] mPoints;
    public final BrushType mType;
    public boolean mUseContentObjectBoundingBoxUnits;
    public final boolean mUseObjectBoundingBox;
    public Rect mUserSpaceBoundingBox;

    public enum BrushType {
        LINEAR_GRADIENT,
        RADIAL_GRADIENT,
        PATTERN
    }

    public enum BrushUnits {
        OBJECT_BOUNDING_BOX,
        USER_SPACE_ON_USE
    }

    public Brush(BrushType brushType, SVGLength[] sVGLengthArr, BrushUnits brushUnits) {
        this.mType = brushType;
        this.mPoints = sVGLengthArr;
        this.mUseObjectBoundingBox = brushUnits == BrushUnits.OBJECT_BOUNDING_BOX;
    }

    public final double getVal(SVGLength sVGLength, double d, float f, float f2) {
        double d2;
        if (this.mUseObjectBoundingBox) {
            if (sVGLength.unit == SVGLength.UnitType.NUMBER) {
                d2 = d;
                return PathParser.fromRelative(sVGLength, d, 0.0d, d2, (double) f2);
            }
        }
        d2 = (double) f;
        return PathParser.fromRelative(sVGLength, d, 0.0d, d2, (double) f2);
    }
}
