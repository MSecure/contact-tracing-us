package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;

@SuppressLint({"ViewConstructor"})
public class ClipPathView extends GroupView {
    public ClipPathView(ReactContext reactContext) {
        super(reactContext);
        this.mClipRule = 1;
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.GroupView
    public void draw(Canvas canvas, Paint paint, float f) {
        FLog.w("ReactNative", "RNSVG: ClipPath can't be drawn, it should be defined as a child component for `Defs` ");
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.GroupView
    public int hitTest(float[] fArr) {
        return -1;
    }

    @Override // com.horcrux.svg.VirtualView
    public boolean isResponsible() {
        return false;
    }

    @Override // com.horcrux.svg.RenderableView
    public void mergeProperties(RenderableView renderableView) {
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.GroupView
    public void resetProperties() {
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.GroupView
    public void saveDefinition() {
        getSvgView().defineClipPath(this, this.mName);
    }
}
