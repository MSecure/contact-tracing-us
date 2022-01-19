package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

@SuppressLint({"ViewConstructor"})
public class ForeignObjectView extends GroupView {
    public Canvas fake = new Canvas(this.fakeBitmap);
    public Bitmap fakeBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    public SVGLength mH;
    public SVGLength mW;
    public SVGLength mX;
    public SVGLength mY;

    public ForeignObjectView(ReactContext reactContext) {
        super(reactContext);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(this.fake);
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.GroupView
    public void draw(Canvas canvas, Paint paint, float f) {
        canvas.translate((float) relativeOnWidth(this.mX), (float) relativeOnHeight(this.mY));
        canvas.clipRect(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) relativeOnWidth(this.mW), (float) relativeOnHeight(this.mH));
        setupGlyphContext(canvas);
        clip(canvas, paint);
        drawGroup(canvas, paint, f);
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(this.fake, view, j);
    }

    @Override // com.horcrux.svg.GroupView
    public void drawGroup(Canvas canvas, Paint paint, float f) {
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        textRootGlyphContext.pushNodeAndFont(this, this.mFont);
        textRootGlyphContext.pushIndices();
        SvgView svgView = getSvgView();
        RectF rectF = new RectF();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt instanceof MaskView)) {
                if (childAt instanceof VirtualView) {
                    VirtualView virtualView = (VirtualView) childAt;
                    if (!"none".equals(virtualView.mDisplay)) {
                        boolean z = virtualView instanceof RenderableView;
                        if (z) {
                            ((RenderableView) virtualView).mergeProperties(this);
                        }
                        int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas, this.mCTM);
                        virtualView.render(canvas, paint, this.mOpacity * f);
                        RectF clientRect = virtualView.getClientRect();
                        if (clientRect != null) {
                            rectF.union(clientRect);
                        }
                        virtualView.restoreCanvas(canvas, saveAndSetupCanvas);
                        if (z) {
                            ((RenderableView) virtualView).resetProperties();
                        }
                        if (virtualView.isResponsible()) {
                            svgView.enableTouchEvents();
                        }
                    }
                } else if (childAt instanceof SvgView) {
                    SvgView svgView2 = (SvgView) childAt;
                    svgView2.drawChildren(canvas);
                    if (svgView2.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                } else {
                    childAt.draw(canvas);
                }
            }
        }
        setClientRect(rectF);
        popGlyphContext();
    }

    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)
    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
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
