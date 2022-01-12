package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

@SuppressLint({"ViewConstructor"})
public class RectView extends RenderableView {
    public SVGLength mH;
    public SVGLength mRx;
    public SVGLength mRy;
    public SVGLength mW;
    public SVGLength mX;
    public SVGLength mY;

    public RectView(ReactContext reactContext) {
        super(reactContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public Path getPath(Canvas canvas, Paint paint) {
        double d;
        double d2;
        double d3;
        double d4;
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.mX);
        double relativeOnHeight = relativeOnHeight(this.mY);
        double relativeOnWidth2 = relativeOnWidth(this.mW);
        double relativeOnHeight2 = relativeOnHeight(this.mH);
        if (this.mRx == null && this.mRy == null) {
            path.addRect((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2), Path.Direction.CW);
            path.close();
        } else {
            SVGLength sVGLength = this.mRx;
            if (sVGLength == null) {
                d2 = relativeOnHeight(this.mRy);
            } else if (this.mRy == null) {
                d2 = relativeOnWidth(sVGLength);
            } else {
                d2 = relativeOnWidth(sVGLength);
                d = relativeOnHeight(this.mRy);
                d3 = relativeOnWidth2 / 2.0d;
                if (d2 > d3) {
                    d2 = d3;
                }
                d4 = relativeOnHeight2 / 2.0d;
                if (d > d4) {
                    d = d4;
                }
                path.addRoundRect((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2), (float) d2, (float) d, Path.Direction.CW);
            }
            d = d2;
            d3 = relativeOnWidth2 / 2.0d;
            if (d2 > d3) {
            }
            d4 = relativeOnHeight2 / 2.0d;
            if (d > d4) {
            }
            path.addRoundRect((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2), (float) d2, (float) d, Path.Direction.CW);
        }
        return path;
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)
    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.mRx = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.mRy = SVGLength.from(dynamic);
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
