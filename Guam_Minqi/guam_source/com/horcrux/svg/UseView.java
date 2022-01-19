package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

@SuppressLint({"ViewConstructor"})
public class UseView extends RenderableView {
    public SVGLength mH;
    public String mHref;
    public SVGLength mW;
    public SVGLength mX;
    public SVGLength mY;

    public UseView(ReactContext reactContext) {
        super(reactContext);
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public void draw(Canvas canvas, Paint paint, float f) {
        boolean z;
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate == null) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("`Use` element expected a pre-defined svg template as `href` prop, template named: ");
            outline15.append(this.mHref);
            outline15.append(" is not defined.");
            FLog.w("ReactNative", outline15.toString());
            return;
        }
        definedTemplate.clearCache();
        canvas.translate((float) relativeOnWidth(this.mX), (float) relativeOnHeight(this.mY));
        boolean z2 = definedTemplate instanceof RenderableView;
        if (z2) {
            ((RenderableView) definedTemplate).mergeProperties(this);
        }
        int saveAndSetupCanvas = definedTemplate.saveAndSetupCanvas(canvas, this.mCTM);
        clip(canvas, paint);
        if (definedTemplate instanceof SymbolView) {
            SymbolView symbolView = (SymbolView) definedTemplate;
            float relativeOnWidth = (float) relativeOnWidth(this.mW);
            float relativeOnHeight = (float) relativeOnHeight(this.mH);
            if (symbolView.mAlign != null) {
                float f2 = symbolView.mMinX;
                float f3 = symbolView.mScale;
                float f4 = symbolView.mMinY;
                z = z2;
                canvas.concat(PathParser.getTransform(new RectF(f2 * f3, f4 * f3, (f2 + symbolView.mVbWidth) * f3, (f4 + symbolView.mVbHeight) * f3), new RectF(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, relativeOnWidth, relativeOnHeight), symbolView.mAlign, symbolView.mMeetOrSlice));
                symbolView.setupGlyphContext(canvas);
                symbolView.clip(canvas, paint);
                symbolView.drawGroup(canvas, paint, f);
            } else {
                z = z2;
            }
        } else {
            z = z2;
            definedTemplate.draw(canvas, paint, f * this.mOpacity);
        }
        setClientRect(definedTemplate.getClientRect());
        definedTemplate.restoreCanvas(canvas, saveAndSetupCanvas);
        if (z) {
            ((RenderableView) definedTemplate).resetProperties();
        }
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public Path getPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate == null) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("`Use` element expected a pre-defined svg template as `href` prop, template named: ");
            outline15.append(this.mHref);
            outline15.append(" is not defined.");
            FLog.w("ReactNative", outline15.toString());
            return null;
        }
        Path path = definedTemplate.getPath(canvas, paint);
        Path path2 = new Path();
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) relativeOnWidth(this.mX), (float) relativeOnHeight(this.mY));
        path.transform(matrix, path2);
        return path2;
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public int hitTest(float[] fArr) {
        if (this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
            if (definedTemplate == null) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("`Use` element expected a pre-defined svg template as `href` prop, template named: ");
                outline15.append(this.mHref);
                outline15.append(" is not defined.");
                FLog.w("ReactNative", outline15.toString());
                return -1;
            }
            int hitTest = definedTemplate.hitTest(fArr2);
            if (hitTest != -1) {
                return (definedTemplate.isResponsible() || hitTest != definedTemplate.getId()) ? hitTest : getId();
            }
        }
        return -1;
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)
    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "href")
    public void setHref(String str) {
        this.mHref = str;
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
